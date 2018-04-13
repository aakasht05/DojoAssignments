from __future__ import unicode_literals
from django.shortcuts import render
from datetime import datetime

def index(req):
    time = datetime.now()
    ctx = {
        'time':time
    }

    return render(req,'app_timedisplay/index.html',ctx)
