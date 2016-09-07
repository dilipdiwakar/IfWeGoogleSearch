"# IfWeGoogleSearch" 

Step 1: 
========
	# Create a Dummy Maven Project

	mvn archetype:generate
		provide the groupid , artifactid , version etc..
	mvn eclipse:eclipse

Step 2:
=======
	Open the eclipse , Import the Maven project that you have created.

	In the Pom.xml add the below dependency 
		Selenium-server
		TestNg
		maven-compiler-plugin
		Add the Sure fire report plugins as well.

		Configure the path of the TestNg xml file in the pom.xml file

Step 3:
======
    Create a TestNg xml and make the test to run in Parallel
    Create  Test Methods and DataProviders methods
    Create BeforeMethod to intialize the WebDriver objects and 
    Create AfterMethod  and quit the driver object
    
    Pass the browser name as parameter from the Testng.xml file to your BeforeMethods.
    
Step 4 :
=======
	Run the below command to check everything works.
		mvn compile test
		
Step 5:
=======
	Upload the project to Git using the below commands.
	
	git init
	git add README.md
	git commit -m "first commit"
	git remote add origin https://github.com/dilipdiwakar/IfWeGoogleSearch.git
	git push -u origin master