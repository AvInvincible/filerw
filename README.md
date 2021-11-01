# FileRW
Project that help reading files placed within a project directory, without writing any extensive code. 
It simplify the process of reading the writing files.

## Add to your project 
```
<dependency>
  <groupId>com.avinc</groupId>
  <artifactId>filerw</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>

$mvn install
```

## Repository 
> https://github.com/AvInvincible/filerw <br>
> https://github.com/AvInvincible/filerw/blob/main/README.md

## Technologies
A list of technologies used within the project:
* [Java](https://www.java.com/en/): Version 1.8
* Build tool [Maven](http://maven.apache.org/): Version 3.8.3

## Guide
### Reading .properties files
```
Instantiate the PropertiesFileRW object 

**PropertiesFileRW rw = new PropertiesFileRW();**

Set the file name using setFileName("fileName") method, which returns the PropertiesFileRW object
Use getKey("keyName") method to get the value from the file

**rw.setFileName("testData").getKey("fruit1")**
```
Note: PropertiesFileRW internally scan the project directory to locate the file name set using setFileName() method.
