#! /bin/bash
# Salvo la data attuale in una variabile
a=$(date)
git add .
git commit -m "$a"
git push origin main
