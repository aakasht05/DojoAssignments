from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^users/(?P<id>\d+)$',views.user_show),
    url(r'^register$',views.register),
    url(r'^login$',views.login),

    url(r'^books$',views.books),
    url(r'^books/add$',views.book_add),
    url(r'^books/new$',views.book_new),
    url(r'^books/(?P<id>\d+)$',views.book_show),

    url(r'^books/remove/(?P<id>\d+)$',views.review_remove),
]
