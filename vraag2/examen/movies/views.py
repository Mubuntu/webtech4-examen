# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.http import HttpResponse

from django.shortcuts import render
import redis

# Create your views here.

r = redis.StrictRedis(host='localhost', port=6379, db = 0);
lines = [line.rstrip('\n') for line in open('movies.txt','r')]
    for line in lines: 
        tempLines = line.split(':')
        r.set(tempLines[0], tempLines[1] )

file = open("movies.txt", "r")
def index(request):
    #r.get('movies:*')
    html = '<html><body><h1>movies><h1/><br><br><table>'
    html+='<tr><th>movie</th><th>actors</th></tr>'
     for line in lines: 
        tempLines = line.split(':')
        # r.set(tempLines[0], tempLines[1] )

        html+='<tr><td>' + tempLines[0]+ '</td>'
        # acteurs in lijst steken
        actors = tempLines[1].split(',')
        html+='<td><ul>'
        for actor in actors: 
            # in redis plaatsen
            r.set(tempLines[0], actor); 
            html+='<li>' + actor+ '</li>'
        html+='</ul><td><tr></table></body></html>'

    return HttpResponse(html)


def search_actor(request):
    return render(request, 'movies/search_form.html')

def search_movies(request):
    if request.method == 'POST':
        movie = request.POST['search_term']
        actors_list = r.get(movie)
        html = '<html><body><h1>actors in ' +movie + '><h1/><br><br>'
        html+='<ul>'
        
        for actor in actors_list:
            html+='<li>'+ actor +'</li>'
        html+= '</ul></body></html>'
    
    return HttpResponse(html)


        
