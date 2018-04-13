from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),

    url(r'^signin$',views.sign_in),
    url(r'^sign_in_process$',views.sign_in_process),
    url(r'^signout$',views.sign_out),

    url(r'^register$',views.register),
    url(r'^register_process$',views.register_process),

    url(r'^users/new$',views.users_new),
    url(r'^users/show/(?P<user_id>\d+)$',views.users_show),
    url(r'^users/show/(?P<user_id>\d+)/post$',views.post),
    url(r'^users/show/(?P<user_id>\d+)/post/(?P<post_id>\d+)$',views.comment),
    url(r'^users/delete/(?P<user_id>\d+)$',views.users_delete),

    url(r'^users/edit$',views.users_edit),
    url(r'^users/edit/updateprofile$',views.updateProfile),
    url(r'^users/edit/updatepassword$',views.updatePassword),
    url(r'^users/edit/(?P<user_id>\d+)$',views.users_edit_user),
    url(r'^users/edit/(?P<user_id>\d+)/editprofile$',views.editProfile),

    url(r'^dashboard$',views.dashboard)
]
