# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-25 15:36
from __future__ import unicode_literals

from django.db import migrations
import django.db.models.manager


class Migration(migrations.Migration):

    dependencies = [
        ('app_main', '0002_auto_20170624_1918'),
    ]

    operations = [
        migrations.AlterModelManagers(
            name='user',
            managers=[
                ('manager', django.db.models.manager.Manager()),
            ],
        ),
    ]
