# SuperLoggerApi-Java
A console logger for Java developpers !

# Documentation

It's very simple, you just need to do thats steps :

1 - Create a variable with type : SuperLogger
```java

SuperLogger logger = new SuperLogger("[prefix of the log]", SurroundKey.[type of surround], "the log");

```

2- Create the log : 
```java 

logger.log();

```

You can get and set new prefix, surround & log with : 

```java

log.getPrefix()

log.getSurroundKey()

log.getArgs()

log.setPrefix("[new prefix]")

log.setSurroundKey(SurroundKey.[new SurroundKey])

log.setArgs("[new log]")

```
