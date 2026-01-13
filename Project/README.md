# Kompetenznachweis M4 – Eigenes Projekt (Einzelarbeit)

## Projektname

**Idle Miners**

## Autor

Mert Bal

## Projektbeschreibung

**Idle Miners** ist ein 2D-Idle-Game, inspiriert von *Adventure Capitalist*.
Der Spieler fängt mit einer Stein-Mine an. Diese klickt er durchgehend an und erhält die Ressource Stein. Diese kann er verkaufen für je einen Dollar. Mit dem Geld kann er Arbeiter kaufen, welche automatisch die Steine schürfen. Im späteren Verlauf mit verdientem Geld, ist es möglich auch eine Silber, sowie eine Gold-Mine zu kaufen.

Das Projekt wurde mit **Unity (C#)** umgesetzt und legt den Fokus auf **objektorientierte Konzepte**, saubere Architektur und klare Trennung von Verantwortlichkeiten.

## Ziel des Projekts

### Muss-Kriterien

* Ressourcen abbauen (Stein, Eisen, Gold)
* Manuelles Minen (Klick)
* Automatisches Minen durch Arbeiter
* Freischalten neuer Ressourcen
* Persistente Speicherung des Spielstands
* Achievements mit Fortschrittsanzeige und Belohnungen
* Saubere Trennung von UI, Logik und Persistenz

### Nice-to-Have

* Offline-Progress
* Scrollbare Achievements
* Tab-System (Workers / Upgrades / Achievements)
* Erweiterbarkeit für weitere Ressourcen oder Upgrades

## Architektur & Design

Die Applikation ist **schichtenbasiert** aufgebaut:

### Architekturübersicht

* **UI-Layer**
  Darstellung, Benutzerinteraktion
  (`GameUIController`, `AchievementItemView`, `TabController`)

* **Core / Logik**
  Spiellogik, Regeln, Tick-System
  (`GameManager`, `EconomyService`, `WorkerService`)

* **Domain / Modelle**
  Daten und Zustände
  (`PlayerState`, `Achievement`, `ResourceDefinition`)

* **Persistenz**
  Speicherung & Laden
  (`ISaveService`, `JsonSaveService`)

Diese Struktur stellt sicher, dass **UI keine Geschäftslogik enthält** und Logik unabhängig test- und erweiterbar bleibt.


## UML-Klassendiagramm (geplant & final)

* Zu Projektbeginn wurde ein **grobes Klassendiagramm** erstellt
* Nach Abschluss wurde ein **detailliertes UML-Diagramm** auf Basis des finalen Codes erstellt

![UML Diagramm][uml]


## Sequenzdiagramm

![Sequenz Diagramm][sequenzdiagramm]


## Verwendete objektorientierte Konzepte

### Delegation

* UI ruft **nur Methoden des `GameManager`** auf
* Spiellogik wird an spezialisierte Services delegiert
  z.B.:

  * `EconomyService`
  * `WorkerService`
  * `AchievementService`

### Polymorphismus

* Mining-Logik über `IMiningStrategy`
* Achievements über `IAchievementCondition` und `IAchievementReward`
* Unterschiedliche Implementierungen je Ressource / Bedingung

### Interfaces

* `IMiningStrategy`
* `IAchievementCondition`
* `IAchievementReward`
* `ISaveService`

### Vererbung

* Unity-spezifische Klassen erben von `MonoBehaviour`
* Gemeinsames Verhalten wird abstrahiert, wo sinnvoll

## Verwendete Design Patterns

### Factory Pattern

**ResourceFactory**

* Erzeugt ResourceDefinitions und MiningStrategies
* Vorteil: Zentrale Kontrolle, einfache Erweiterbarkeit

### Strategy Pattern

**IMiningStrategy**

* Unterschiedliche Mining-Berechnungen je Ressource
* Ermöglicht unterschiedliche Balancing-Logiken

### Service Pattern

* `AchievementService`
* `WorkerService`
* `EconomyService`

Trennung von Regeln und Daten, bessere Wartbarkeit


## Use Cases

### UC-1: Ressource manuell abbauen

1. Spieler klickt auf „Mine Stone“
2. UI ruft `GameManager.MineClick(ResourceType.Stone)`
3. Mining-Strategie berechnet Ertrag
4. Ressource wird dem PlayerState hinzugefügt
5. UI aktualisiert Anzeige

### UC-2: Worker kaufen

1. Spieler klickt „Buy Stone Worker“
2. Kosten werden geprüft
3. Geld wird abgezogen
4. Worker-Zähler erhöht
5. Auto-Mining steigt

### UC-3: Achievement freischalten

1. Spieler erfüllt Bedingung (z.B. 100 Klicks)
2. Fortschritt wird angezeigt
3. Claim-Button wird aktiv
4. Spieler claimt Achievement
5. Belohnung wird angewendet
6. Achievement wird als „CLAIMED“ markiert


## 9Persistente Daten

* Speicherung über `JsonSaveService`
* Daten werden im `Application.persistentDataPath` abgelegt
* Gespeichert werden u.a.:

  * Ressourcen
  * Worker-Anzahl
  * Unlocks
  * Achievements (claimed)
  * Klick-Zähler


## Clean Code & Qualität

Angewendete Clean-Code-Regeln:

* Single Responsibility Principle
* Sprechende Klassen- und Methodennamen
* Keine Logik im UI
* Kleine, klar strukturierte Methoden
* Exceptions für ungültige Aktionen (`InvalidPurchaseException`)

Kommentare wurden eingesetzt


## Einsatz von KI (Dokumentation)

KI wurde **unterstützend** eingesetzt, nicht zur vollständigen Code-Generierung.

### Typische KI-Prompts:

```text
Generier mir ein Bild von diesen Tabs die ich extrahieren kann, also mach jeweils Workers Upgrades und Achievments, alle unangeklickt und dann noch einmal in einem Status wie sie angeklickt aussehen. Halt dich an das Design welches wir bereits verwenden. Hintergrund soll Transparent sein
```

```text
Extrahier diese ZIP und überprüf dies mit meinem UML, ob die Einstellungen korrekt sind
```

```text
Wie passe ich mein Canvas im Unity Editor so an, dass ich am ende eine scrollable Entity für die Achievments habe
```

Alle generierten Inhalte wurden:

* verstanden
* angepasst
* manuell integriert
* erweitert

Die Projektlogik wurde **eigenständig umgesetzt**.

## Fazit & Lernprozess

Durch das Projekt konnte ich:

* OO-Konzepte praktisch anwenden
* Architektur bewusst planen
* Design Patterns sinnvoll einsetzen
* UI- und Logik-Trennung sauber umsetzen
* Ein komplexeres Unity-Projekt strukturieren

Besonders lehrreich war die Umsetzung der **Achievements mit Conditions, Rewards und Progress-Tracking** sowie die saubere Entkopplung der Systeme.

[uml]: /Project/Level4UML.png
[sequenzdiagramm]: /Project/Level4Sequenzdiagramm.png