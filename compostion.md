# Entwurfsmuster "Kompositum"

## Beschreibung
Komposition ermöglicht es, eine Gruppe von Objekten wie eine einzelne Instanz des Objekts zu behandeln: Anstatt mit _konkreten Instanzen eines Objekts_ zu arbeiten, wird ein _Interface_ verwendet - die sogenannte **Komponente**. 

Objekte die dieses Interface implementieren werden **Blätter** genannt. Das **Kompositum** implementiert dies ebenfalls. Es kann, sich selbst außgeschlossen, alle Instanzen einer Komponente beinhalten.

## Klassendiagramm
![](resources/img/1000px-Composite_UML_class_diagram_(fixed).svg.png)

## Beispielcodierung
Siehe ausführbares [Beispiel (example/Main.java)](example/Main.java), bestehend aus:

1. ["Component"-Interface](example/interfaces/ComponentInterface.java)
1. ["Composite"-Klasse](example/entities/Composite.java)
1. ["Leaf"-Klasse](example/entities/Leaf.java)

## Übungsaufgabe
Probiere alle fünf Beispiele in der [Main (example/Main.java)](example/Main.java) aus. Lies bei Bedarf die erklärenden Kommentare. Beantworte, warum es im letzten Beispiel zu einem Fehler kommt?

## Lösung
1. **firstExample()**
    ```
    Composite #6 here.
    ```

1. **secondExample()**
    ```
    Composite #27 here.
    
    "Hello" says leaf #25.
    "Hello" says leaf #78.
    ```

1. **thirdExample()**
    ```
    Composite #72 here.
    Composite #41 here.
    ```

1. **fourthExample()**
    ```
    Composite #12 here.
    "Hello" says leaf #71.
    
    Composite #99 here.
    "Hello" says leaf #71.
    "Hello" says leaf #72.
    ```
 
1. **Rekursion**
 
## Bildquellen
- []()https://upload.wikimedia.org/wikipedia/commons/5/5a/Composite_UML_class_diagram_%28fixed%29.svg)