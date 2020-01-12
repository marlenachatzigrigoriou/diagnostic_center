# DIAGNOSTIC CENTER

This is a useful app for every health center. It provides functions both for the client and the business. Every client can book an appointment, delete an existing one or change it. He can also evaluate his experience in the Medical Center as well as his experinece of booking an appointment using the app. Now the business can manage its employees (recruitment of an employee, dismissal etc) and services (add new service, delete etc). Also, the app extracts several statistic results ,using the clients' ratings, about the services.


## REQUIREMENTS

* You should have our GitHub repository downloaded on your computer (https://github.com/marlenachatzigrigoriou/diagnostic_center).
* You should have all the .txt files ,provided on our repository, saved (find them in "files" commit).
* You should have the necessary .java files saved too (provided in the "src" commit).
* You should have installed Java compiler on your PC.
* You should have installed JUnit on your PC.


## INSTALLING

1)Clone or download our GitHub repository on your computer. 

2)Extract the zip file you downloaded (our GitHub repository) and save them in a folder on your computer.

3)Keep only the archives that belong to src folder (delete the other files).

4)Open your command line and go inside the folder of our repository you downloaded. In the src folder of this folder you will see all our      classes and required files.

5)To create the .jar, write the following command:
      
      jar cmf manifest.mf "Diagnostic Center.jar" αιματολογικές.txt ακτινογραφίες.txt 
      ανοσολογικές.txt "αξονικές τομογραφίες.txt" αλλεργιολογικές.txt βιοχημικές.txt
      γαστρεντερολογικές.txt γυναικολογικές.txt καλλιέργειες.txt καρδιολογικές.txt 
      "μαγνητικές τομογραφίες.txt" μαστογραφίες.txt μικροβιολογικές.txt νευρολογικές.txt 
      ορμονικές.txt ούρων.txt πακέτα.txt "προγεννητικός έλεγχος.txt" υπέρηχοι.txt checkup.txt
      doppler.txt triplex.txt Client.class CreateObjects.class DeleteAndChange.class Employees.class 
      EnterAppointment.class Evaluation.class Main.class Menu.class Services.class Statistics.class Table.class
