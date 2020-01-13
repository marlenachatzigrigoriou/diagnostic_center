# DIAGNOSTIC CENTER

This is a useful app for every health center. It provides functions both for the client and the business. Every client can book an appointment, delete an existing one or change it. He can also evaluate his experience in the Medical Center as well as his experinece of booking an appointment using the app. Now the business can manage its employees (recruitment of an employee, dismissal etc) and services (add new service, delete etc). Also, the app extracts several statistic results ,using the clients' ratings, about the services.


## REQUIREMENTS

* You should have our GitHub repository downloaded on your computer https://github.com/marlenachatzigrigoriou/diagnostic_center.
* You should have all the .txt files ,provided on our repository, saved (find them in "src" commit).
* You should have the necessary .java files saved (provided in the "src" commit).
* You should have installed Java compiler on your PC.
* You should have installed JUnit on your PC.


## INSTALLING

1)Clone or download our GitHub repository on your computer. 

2)Extract the zip file you downloaded (our GitHub repository) and save them in a folder on your computer.

3)Keep only the archives that belong to src folder (delete the other files if you want to).

4)Open your command line and go inside the folder of our repository you downloaded. In the src folder of repository's folder you will see all our      classes (<name>.java) and required files (<name>.txt, manifest.mf).

5)To create the .jar, insert the following commands on your command line:
      
      javac *.java
      
      jar cmf manifest.mf "Diagnostic Center.jar" *.txt *.class
      
6)If you want to run the tests:
