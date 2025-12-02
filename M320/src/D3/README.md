# Movie Recommendation

## Was es macht
Eine Ausgabe aller vorhandenen Filme und Serien in der omdbapi. Auf Basis des imdb ratings, wird dann ausgegeben, ob es empfohlen wird diesen Film oder die Serie zu schauen.

## Aufbau
* API Key von dieser Website beziehen: https://www.omdbapi.com/
* Klassischer Backend Aufbau mit Controller und Service
* Entities für jeweils die Anfrage und die Ausgabe (Auch eine Entity möglich und stattdessen ein DTO, aber simplitätshalber mit 2 Entitäten)

## Ausführung
* Main ausführen
* Beliebigen Film eingeben
* Erscheinungsjahr eingeben (Optional, um die Suche zu verbessern, falls es Titel mit einem ähnlichen Namen gibt)
* Empfehlung erhalten, ob sich der Film lohnt anzuschauen (Basierend auf IMDB Rating)