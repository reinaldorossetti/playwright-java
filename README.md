# Microsoft Playwright - Java API

Microsoft has a new open source web automation tool, Playwright. It recently released support for Java. Here are example tests that demonstrate how to use Playwright, including creating Page Objects  


###Requirements:  
>> Install Java JDK 11  
```  
  <configuration>  
      <source>11</source>  
      <target>11</target>  
  </configuration>  
```  
https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html  

>> download allure command line:  
npm install -g allure-commandline --save-dev  

>> download dependencies:  
mvn package  

>> run tests:  
mvn clean test  
allure serve target/allure-results  


References:  
https://playwright.dev  
https://applitools.com/blog/playwright-java/  
