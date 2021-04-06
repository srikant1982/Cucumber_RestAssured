# CucumberRestAssuredMaven
API Testing Using RestAssured and Cucumber

The Tests runs against APIs mentioned on https://reqres.in/.

**Steps to Run from Local** :
- Clone the repository
- Open the command prompt and navigate to project path
  >mvn test verify
- This will run the scenarios and generate the report under target/cucumber-html-reports/*

or 

- You can load this project in eclipse.
- Go to "RunnerTest.java" file and right click and run as Junit Tests.
- Will generate the reports under target/cucumber-html-reports/*

**Steps to Run from Jenkins** :
- Note : You need to install Cucumber Reports plugin from Manage Jenkins -> Manage Plugins
- Create new Freestyle item/build
- Mention the repository under Git
- In Source Code Management -> Advances -> Name= Origin & Refspec=refs/pull/*:refs/remotes/origin/ and other steps shown in image below

            ![image](https://user-images.githubusercontent.com/557085/113252520-94ff7a80-92e1-11eb-8231-11165f47885a.png)
            ![image](https://user-images.githubusercontent.com/557085/113252582-a5175a00-92e1-11eb-8f7c-8e25e942bb7d.png)
            ![image](https://user-images.githubusercontent.com/557085/113252641-b52f3980-92e1-11eb-90c8-86101c2c9ec1.png)

- And Run the build
- After the build is complete you should see below Cucumber Report

           ![image](https://user-images.githubusercontent.com/557085/113252859-05a69700-92e2-11eb-9629-646dc79fd1a7.png) 
           ![image](https://user-images.githubusercontent.com/557085/113252911-19ea9400-92e2-11eb-8dee-d21acd373bed.png)
           
- Added jenkins file and the webhook.
