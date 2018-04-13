from django.conf.urls import url,include

urlpatterns = [
    url(r'^',include('apps.app_random_word_generator.urls')),
]
