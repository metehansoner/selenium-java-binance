# UI Test Automation Using Java and Selenium


# Languages and Frameworks

-   [Java 17](https://openjdk.java.net/projects/jdk/17/)  as the programming language
-   [TestNG](https://testng.org/doc/)  as the UnitTest framework to support the test creation
-   [Selenium WebDriver](https://www.selenium.dev/)  as the web browser automation framework using the Java 
-   [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)  as the Selenium binaries management
-   [Owner](http://owner.aeonbits.org/)  menagement configurations file
-  [Apache POI ](https://poi.apache.org/) read and write MS Excel files using Java
- [Cucumber](https://cucumber.io/) Cucumber BDD tool used to develop test cases

## EXECUTION                  
├── src                    
│──├── main
│ ──── ├──── resources               
│ ────────── ├── general.properties
│ ────────── ├── environment.properties
│ ────────── ├── grid.properties

-   `general.properties file contains target value. You can set target value to REMOTE or LOCAL`
-    `environment.properties file contains environment value. You can set environment  value to test,qa,staging and  prod`
- `general.properties file contains selenium grid url and port `

├── src                    
│──├── test
│ ──── ├──── resources               
│ ────────── ├── local.xml
│ ────────── ├── remote.xml


- `You can directly run the remote.xml and local.xml files to run your tests.`
- `You can pass environment and browser as parameters in these suites.`
- `In order for the tests to run on the selenium grid, the target value in the genaral.properties file must be REMOTE.`
- Start the Grid by running the following command inside the  project root folder
    -   `docker-compose.yml up`
    -   `Run remote.xml `



## Profiles executors on pom.xml

There is a profile called  `web-execution`  created to execute the test suite  `remote.xml`  inside  `src/test/resources/suites`  folder.

    -  `mvn test -Pweb-execution -Dsuite=remote -Dtestng.dtd.http=true ` with maven

If you have more than one suite on  _src/test/resources/suites_  folder you can parameterize the xml file name. To do this you need:

-   Create a property on  `pom.xml`  called  _suite_
``` bash

mvn test -Pweb-execution -Dtestng.dtd.http=true

```

If you have more than one suite on _src/test/resources/suites_ folder you can parameterize the xml file name.

To do this you need:

* Create a property on `pom.xml` called _suite_

```xml

<properties>

<suite>remote</suite>

</properties>

```

* Change the profile id

```xml

<profile>

<id>web-execution</id>

</profile>

```

* Replace the xml file name to `${suite}` on the profile

```xml

<configuration>

<suiteXmlFiles>

<suiteXmlFile>src/test/resources/suite/${suite}.xml</suiteXmlFile>

</suiteXmlFiles>

</configuration>

```
