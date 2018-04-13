from __future__ import unicode_literals
from django.shortcuts import render,redirect
from django.contrib import messages
from .models import User,Author,Book,Review
#so much for a skinny controller even with managers for all models/classes/tables.
#Dont forget to clear your cache.
def index(request):
    if 'id' in request.session:#You shouldnt be logged in, clear session.
        request.session.clear()
    
    return render(request,'app_main/index.html')

def register(request):
    first_name = request.POST['first_name']
    last_name  = request.POST['last_name']
    email      = request.POST['email']
    password   = request.POST['password']
    confirm    = request.POST['confirm']

    reg = User.manager.register(
        first_name,last_name,email,password,confirm
    )

    if not reg[0]:
        for err in reg[1]:
            messages.add_message(request,messages.ERROR,err)
        return redirect('/')
    request.session['id'] = reg[1].id
    request.session['first_name'] = reg[1].first_name
    return redirect('/books')

def login(request):
    email      = request.POST['email']
    password   = request.POST['password']
    log        = User.manager.login(email,password)

    if not log[0]:
        for err in log[1]:
            messages.add_message(request,messages.ERROR,err)
        return redirect('/')
    request.session['id'] = log[1].id
    request.session['first_name'] = log[1].first_name
    return redirect('/books')

def user_show(request,id):
    #all this just to remove duplicates. A normal JOIN and GROUP BY would be nice right about now.
    reviews = Review.manager.filter(user_id=id).values(
        'user__first_name',
        'user__last_name',
        'user__email',
        'user__reviews',
        'book__title',
        'book_id'
    ).distinct()

    return render(request,'app_main/user_show.html',{
        'reviews':reviews
    })

def books(request):
    if not 'id' in request.session:#nope
        messages.add_message(request,messages.ERROR,"You must be logged in to visit this page.")
        return redirect('/')

    recent_reviews = Review.manager.all().order_by('-id')[:3]
    reviews = Review.manager.values('book_id','book__title').distinct()#I cant get duplicates to go away with distinct or order by.

    # :/
    for i in recent_reviews:
        i.stars = ['']*i.rating

    ctx = {
        'recent_reviews':recent_reviews,
        'reviews':reviews
    }

    return render(request,'app_main/books.html',ctx)

def book_add(request):
    #null selected book in case they we're previously on the review page.
    request.session['selected_book'] = ""
    return render(request,'app_main/new_book.html',{
        'authors':Author.manager.distinct()
    })

def book_new(request):
    selected_author = ""
    try:#if no authors, this will break.
        selected_author = request.POST['selected_author']
    except Exception as e:#Their are no authors or they're reviewing an existing book.
        selected_author = ""
        #raise e <-- Please dont

    if request.session['selected_book'] != "":#they're definitely trying to add a review to an existing book, coming from show_book.html.
        review = Review.manager.add(
            request.POST['text'],
            request.session['id'],#user id
            request.session['selected_book'],#book id
            request.POST['rating']
        )
    else:
        author = Author.manager.add(
            request.POST['first_name'],
            request.POST['last_name'],
            selected_author
        )
        if not author[0]:
            for err in author[1]:
                messages.add_message(request,messages.ERROR,err)
            return redirect('/books/add')

        book = Book.manager.add(
            request.POST['title'],
            author[1].id
        )
        if not book[0]:#now we have the above author floating in space.
            for err in book[1]:
                messages.add_message(request,messages.ERROR,err)
            return redirect('/books/add')

        review = Review.manager.add(
            request.POST['text'],
            request.session['id'],
            book[1].id,
            request.POST['rating']
        )

    if not review[0]:
        for err in review[1]:#now we have the above book and author in outer space..
            messages.add_message(request,messages.ERROR,err)
        return redirect('/books/add')

    route = "/books/{}".format(review[1].book_id)
    return redirect(route)

def book_show(request,id):
    reviews = Review.manager.filter(book_id=id)#all reviews for this book.
    # :\
    for i in reviews:
        i.stars = ['']*i.rating

    #save id so we dont need a new route for review form.
    request.session['selected_book'] = id

    return render(request,'app_main/book_show.html',{
        'reviews':reviews
    })

def review_remove(request,id):
    #If its the only review, the book will linger in space and in db. Should the book be deleted if its the only review, else leave it alone? Once the user leaves the book's page, theres no going back until someone else creates a review for it.
    user = User.manager.get(id=request.session['id'])
    user.reviews -= 1
    user.save()

    review   = Review.manager.get(id=id)
    review.delete()
    return redirect('/books/{}'.format(review.book_id))
