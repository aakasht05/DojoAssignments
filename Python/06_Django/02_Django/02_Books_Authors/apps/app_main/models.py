from __future__ import unicode_literals
from django.db import models

class Author(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)

class Book(models.Model):
    title          = models.CharField(max_length=128)
    author_id      = models.ForeignKey(Author)
    published_date = models.DateTimeField(auto_now_add=True)
    category       = models.CharField(max_length=64)
    in_print       = models.BooleanField()

a1 = Author.objects.create(first_name='J.K.',last_name='Rowling')
a2 = Author.objects.create(first_name='John',last_name='Steinbeck')
a3 = Author.objects.create(first_name='Doctor',last_name='Seuss')
a4 = Author.objects.create(first_name='H.G.',last_name='Wells')

b1 = Book.objects.create(title='Harry Potter',author_id=a1,published_date=02-15-2008,category='Fiction',in_print=True)
b2 = Book.objects.create(title='Of Mice and Men',author_id=a1,published_date=02-15-1970,category='Fiction',in_print=True)
b3 = Book.objects.create(title='Green Eggs and Ham',author_id=a4,published_date=02-15-1988,category='Fiction',in_print=True)
b4 = Book.objects.create(title='War Of The Worlds',author_id=a4,published_date=02-15-1868,category='Fiction',in_print=True)




