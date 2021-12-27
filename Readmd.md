# Logging PII through Slf4j via Log4j

## Pre-requisites
- Intellij IDE
- JDK 11

## How to
1. Created a new intellij project
2. Add slf4j and log4j to pom.xml
```xml
<dependencies>
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.32</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.25</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>
```
3. Add the src/main/java/SLF4JDemo
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SLF4JDemo {

    private String name;
    private String ssn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


    public static void main(String[] args) {

        SLF4JDemo slf4JDemo = new SLF4JDemo();

        slf4JDemo.setName("pcap");
        slf4JDemo.setSsn("7857803094");

        //Creating the Logger object
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);

        //Logs only the class
        logger.info("The class that contains PII is " + slf4JDemo);

        // logs the name attribute of slf4JDemo
        logger.debug("The name is " + slf4JDemo.getName());

        // logs the ssn attribute of slf4JDemo
        logger.debug("The ssn is " + slf4JDemo.getSsn());
    }
}
```
4. Add log4j.properties file inside teh resources folder
```properties
# Root logger option
log4j.rootLogger=DEBUG, stdout

# Direct log messages to stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1} - %m%
```
5. Run the application

## Case in point
When logging classes that have PII, it is important to understand that when logging the class,
it does not directly log the PII. The attribute needs to be called via getter to expose PII

#### Reference:
https://examples.javacodegeeks.com/enterprise-java/slf4j/slf4j-configuration-file-example/