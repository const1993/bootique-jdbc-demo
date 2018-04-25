[![Build Status](https://travis-ci.org/bootique-examples/bootique-jdbc-demo.svg)](https://travis-ci.org/bootique-examples/bootique-jdbc-demo)
# bootique-jdbc-demo

How to work with JDBC data stores integrated for [Bootique](http://bootique.io) app. 
   
*For additional help/questions about this example send a message to
[Bootique forum](https://groups.google.com/forum/#!forum/bootique-user).*
   
## Prerequisites
      
    * Java 1.8 or newer.
    * Apache Maven.
      
## Build the Demo
      
Here is how to build it:
```bash           
git clone git@github.com:bootique-examples/bootique-jdbc-demo.git
cd bootique-jdbc-demo
mvn package
```
      
## Run the Demo

Now you can check the options available in your app:
```bash  
java -jar target/bootique.jdbc.demo-1.0-SNAPSHOT.jar
```
```  
OPTIONS
  -c yaml_location, --config=yaml_location
       Specifies YAML config location, which can be a file path or a URL.

  -h, --help
       Prints this message.

  -H, --help-config
       Prints information about application modules and their configuration options.

  -t, --create-table
      Demo command to create table.

  -i, --insert
       Demo command to insert data.

  -s, --select
       Demo command to select data.
```

Provide required configuration via *config.yml*. Uncomment 'type' to use hikariCP :
```yaml  
jdbc:
  DerbyDatabase:
    jdbcUrl: jdbc:derby:target/derby/DerbyDatabase;create=true
    username: sa
    #type: hikari
```

Run custom command *--create-table* to create a table:
```bash
java -jar target/bootique.jdbc.demo-1.0-SNAPSHOT.jar -c config.yml -t
```


Run custom command via *--insert* command to insert data in table:
```bash    
java -jar target/bootique.jdbc.demo-1.0-SNAPSHOT.jar -c config.yml -i
```

Check data via *--select* command:
```bash
java -jar target/bootique.jdbc.demo-1.0-SNAPSHOT.jar -c config.yml -d
```

Show created row with text 'The Row':
```    
...
   The text in selected row is: The Row
```

Delete data via *--delete* command:
```bash
java -jar target/bootique.jdbc.demo-1.0-SNAPSHOT.jar -c config.yml -d
```