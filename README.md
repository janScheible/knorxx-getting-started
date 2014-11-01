# Getting started with the Knorxx Framework

This repository allows getting started with the Knorxx Framework very easily. After cloning the repository the project can be opened in Netbeans 8 (version 8 is needed for the Java 8 support). The getting started project uses Spring Boot and therefore must be started by running Maven with `spring-boot:run`. The project also contains a predefined custom action for that which is called 'Run with Spring Boot'.

After the embedded Tomcat finished starting the class `GettingStartedWebPage` can be edited and changes are immediately visible after a reload in the browser. For more information about how to write the Java code which can be translated to JavaScript see [Writing ST-JS code].

[Writing ST-JS code]: http://st-js.github.io/reference.html#writing

## Project overview

![Project structure](https://raw.githubusercontent.com/janScheible/knorxx-getting-started/master/projectStructure.png)

1. Pretty compact Spring Boot Maven POM with support for JSP rendering (is used internally by the Knorxx Framework). Other dependencies are only the Knorxx Framework itself and the st-js Java 8 support.
2. The `nbactions.xml` contains custom Netbeans actions for running/debugging the project with the Spring Boot plugin.
3. The Spring Boot main class which also acts as the Knorxx HTTP controller (by extending the abstract class `KnorxxController`).
4. A marker class indicating the root package of all JavaScript generatable Java classes.
5. The getting started web page. It features the usage of JQuery, JQueryUI and Java 8 lambdas.
  ```java
  @Override
  public void render() {
  	ButtonOptions buttonOptions = new ButtonOptions();
  	buttonOptions.label = "Click me";
  		
  	$(CONTAINER_ID)
  		.append((JQuery) $("<h1>I'm a Knorxx Framework application!</h1>"))
  		.append($("<div>").button(buttonOptions).click((Event event, Element elmnt) -> {
  			alert("Hello Knorxx!");
  			return true;
  		}));
  }
  ```
6. Every Knorxx Application must provide a client side error handler. In the case of the getting started application the default error handler behavior is used.
7. Also mandatory are JSON serialization/deserialization helper on the server as well on the client side. The default implementation supports plain JSON plus Joda Time ```DateTime``` instances.
