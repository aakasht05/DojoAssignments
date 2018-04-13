from __future__ import unicode_literals
from django.db import models
import re
import bcrypt
email_re = re.compile(r"(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)")
name_re  = re.compile(r'^[a-zA-z]$')

class UserManager(models.Manager):
    def login(self,email,password):
        errs  = []

        if len(email) < 1:
            errs.append('Email cannot be blank.')
        elif not email_re.match(email):
            errs.append('Invalid email format.')
        else:#dont bother touching db if either of the above happen
            user = User.manager.filter(email=email)
            if len(user) < 1:
                errs.append('This account does not exist.')
            else:
                valid = bcrypt.hashpw(password.encode('utf-8'),user[0].password.encode('utf-8'))
                if not valid == user[0].password:#incorrect
                    errs.append('Incorrect Password.')

        if len(password) < 8:
            errs.append('Invalid password.')

        if len(errs) < 1:
            return True,user[0]
        else:
            return False,errs
    def register(self,first_name,last_name,email,password,confirm):
        errs = []
        if len(first_name) < 1 or len(last_name) < 1:
            errs.append('Name cannot be blank.')

        if len(email) < 1:
            errs.append('Email cannot be blank.')
        elif not email_re.match(email):
            errs.append('Invalid email format.')
        else:#dont bother touching db if either of the above happen
            user = User.manager.filter(email=email)
            if len(user) >= 1:
                errs.append('A user with this email already exists.')

        if len(password) < 8 or len(confirm) < 8:
            errs.append('Password must be at least 8 characters long.')
        elif password != confirm:
            errs.append('Password do not match.')

        if len(errs) < 1:
            return True,User.manager.create(
                first_name = first_name,
                last_name  = last_name,
                email      = email,
                password   = bcrypt.hashpw(password.encode('utf-8'),bcrypt.gensalt()),#hash
                reviews    = 0
            )
        else:
            return False,errs

class AuthorManager(models.Manager):
    def add(self,first_name,last_name,selected_author):
        errs = []
        sel  = selected_author.split() #first and last name from dropdown input.

        if len(first_name) < 1 or len(last_name) < 1:
            # try to get an author from the dropdown / select input.
            author = Author.manager.filter(first_name=sel[0],last_name=sel[1])
            
            if len(author) < 1:#no author found by dropdown / select, so none exist. There would be a default if any exist.
                errs.append('Author name cannot be blank.')
            #else they must want to add a book to an existing author.
        else:    
            author = Author.manager.filter(first_name=first_name,last_name=last_name)
        
        #if author exists, return author, else return new author.
        if len(errs) < 1:
            if len(author) < 1:
                author = Author.manager.create(
                    first_name = first_name,
                    last_name  = last_name
                )
            else:
                author = author[0]

            return True,author
        else:
            return False,errs

class BookManager(models.Manager):
    def add(self,title,author_id):
        errs = []

        if len(title) < 1:
            errs.append('Book title cannot be blank.')
        #if book exists, return book, else return new book.
        book = Book.manager.filter(title=title)

        if len(book) < 1:
            book = Book.manager.create(
                title = title,
                author_id = author_id
            )
        else:
            book = book[0]

        if len(errs) < 1:
            return True,book
        else:
            return False,errs

class ReviewManager(models.Manager):
    def add(self,text,user_id,book_id,rating):
        errs = []

        if len(text) < 16:
            errs.append('Review must be at least 16 characters long.')
        if int(rating) < 1 or int(rating) > 5:
            errs.append('Rating must be within 1-5 stars.')

        if len(errs) < 1:
            user = User.manager.get(id=user_id)
            user.reviews += 1
            user.save()

            return True,Review.manager.create(
                text    = text,
                user_id = user_id,
                book_id = book_id,
                rating  = rating
            )
        else:
            return False,errs

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name  = models.CharField(max_length=255)
    email      = models.CharField(max_length=255)
    password   = models.CharField(max_length=255)
    reviews    = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    manager    = UserManager()

class Author(models.Model):
    first_name = models.CharField(max_length=255)
    last_name  = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    manager    = AuthorManager()

class Book(models.Model):
    title  = models.CharField(max_length=255)
    author = models.ForeignKey(Author)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    manager = BookManager()

class Review(models.Model):
    text   = models.TextField(max_length=1000)
    user   = models.ForeignKey(User)
    book   = models.ForeignKey(Book)
    rating = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    manager = ReviewManager()
