Authors :
Rebecca Messier (40338041)
Taminda Ait Ouazzou (40344517)

Setup
1. Import or open the project in your IDE
2. Add the two JAR files in lib/ to the project build path
3. Run src/driver/SmartTravelDriver.java as the main class

Why LinkedList vs ArrayList for this use case:

  LinkedList works better here because we’re constantly adding items to the front and removing the last one. It handles that easily, while an ArrayList would have to shift all the elements every time, which is slower and unnecessary for this situation.

A2 Compatibility: 

  Yes, the changes for A3 are additive only; A GenericFileManager that acts as one general manager for all types and two new load and save methods that use the GenericFileManager. None of the methods or the menu cases (1 to 6 and 8 to 11) where modified and all the file managers from A2 are still present as fallback. 