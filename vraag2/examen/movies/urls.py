from django.conf.urls import url
from . import views
urlpatterns = [
	url(r'^$', views.index, name='index'),
	url(r'search/movies', views.search_movies, name='search_movies'),
	url(r'search/form', views.search_form, name='search_form'),
	# url(r'^(?P<author_name>[A-z ]+)/$', views.detail, name='detail'),
]