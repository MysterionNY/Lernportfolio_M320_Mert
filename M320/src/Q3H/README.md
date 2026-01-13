## 1) Status-Reihenfolge ist unklar

Aktuell steht nur „nicht rückwärts“. Das lässt z.B. zu:

* `CREATED → DELIVERED` (Sprung)
* `IN_TRANSIT → IN_TRANSIT` (Doppel-Scan)
* `DELIVERED → LOST` (wenn man nur ordinal nimmt ist das rückwärts, ok – aber “LOST” ist Spezialfall)

-> Zwischen states definieren: CREATED -> PICKED_UP, PICKED_UP -> IN_TRANSIT / Würde klarer sein

## 2) „cannot scan after DELIVERED except note“ ist unklar

Was ist “note” genau?

* Darf man nach Delivered **ein neues Event** machen?
* Oder darf man nur beim letzten Event den Text ergänzen?
* Ist das ein extra `ScanType.NOTE` oder bleibt es `DELIVERED` mit Note?
* 
## 3) Zeit-Regel fehlt: Muss timestamp immer steigen?

Ohne Regel könnte man Events in der Vergangenheit eintragen.

## 4) „stuck packages“ Definition ist nicht komplett

* nicht DELIVERED
* last scan älter als X Stunden

Aber:

* Sind `LOST` Pakete stuck oder ausgeschlossen?
* Was ist, wenn ein Paket **nur CREATED** hat und nie abgeholt wurde – zählt das als stuck? (meist ja)

## 5) „most common last location“: Auf welche Menge bezogen?

* Auf **alle Pakete**?
* Oder nur auf **stuck packages**?
* Oder nur auf **nicht-delivered**?