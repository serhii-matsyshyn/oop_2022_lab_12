# oop_2022_lab_12 Chain of Responsibility & Decorator

Made by Serhii Matsyshyn

## Task 1

See example of usage in task1.Main or in tests.
It uses ChangeMakingProblem class, that is based on Chain of Responsibility pattern.

## Task 2
The task is based on Decorator pattern.  
See example of usage in task2.Main.  
It uses Google Cloud Storage as a storage for files (so file should be uploaded here beforehand).  
It uses Google Cloud Vision API to detect text in images.

Two decorators are implemented:
- TimedDocument - checks how much time it takes to detect text in image
- CachedDocument - checks if text is already detected in image (by filename) and if so, returns it from cache db
Sqlite database is used for storing data.
