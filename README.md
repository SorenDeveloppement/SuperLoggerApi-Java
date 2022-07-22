# SuperLoggerApi-Java
A console logger for Java developpers !

# Documentation

It's very simple, you just need to do thats steps :

1 - Create a variable with type : SuperLogger
```java

SuperLogger logger = new SuperLogger("[prefix of the log]", SurroundKey.[type of surround], "the log", AnsiConsoleTextColors.[color], "path");

```

2- Create the log : 
```java 

logger.log()

```

You don't need to use ```logger.logInFile("", "")``` because wrote to the log file is automaticaly

You can get and set new prefix, surround & log with : 

```java

log.getPrefix()

log.getSurroundKey()

log.getArgs()

log.getColor()

log.getLogFilePath();

log.setPrefix("[new prefix]")

log.setSurroundKey(SurroundKey.[new SurroundKey])

log.setArgs("[new log]")

log.setColor(AnsiConsoleTextColors.[set new color])

log.setNewLogFilePath("[just the path |you don't need to put a filename, it will do it automatically|]")

```

Also, you can find character strings in your logs by doing:

```java

LogReader logReader = new LogReader("[here, the path where your logs diles are]", "[the string you want to search]");
System.out.println(logReader.checkWordInFile());

```
