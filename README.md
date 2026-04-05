Authors :
Rebecca Messier (40338041)
Taminda Ait Ouazzou (40344517)

Setup
1. Import or open the project in your IDE
2. Add the two JAR files in lib/ to the project build path
3. Run src/driver/SmartTravelDriver.java as the main class

Why LinkedList vs ArrayList for this use case:

  LinkedList works better here because we’re constantly adding items to the front and removing the last one. It handles that easily, while an ArrayList would have to shift all the elements every time, which is slower and unnecessary for this situation.