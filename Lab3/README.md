First Demo Spring Boot Web App Homepage.

![homepage.png](screen%2Fhomepage.png)



### **What is Spring?**

**Spring** is a comprehensive framework for building enterprise-level Java applications. It provides extensive infrastructure support for developing Java applications, including features like dependency injection, aspect-oriented programming, and more. For example, Spring simplifies database access by providing JDBC templates.

### **What is Spring Boot?**
**Spring Boot** is an extension of the **Spring framework** that simplifies the setup and development of Spring-based applications. It offers convention-over-configuration principles and eliminates the need for manual configuration, allowing developers to quickly create production-ready applications. For instance, Spring Boot automatically configures embedded servers like Tomcat, Jetty, or Undertow.

### **What is the relation between Spring platform and Spring Boot?**
**Spring Boot** is built on top of the **Spring platform**. It leverages the capabilities of the **Spring framework** and enhances them by providing a streamlined way to set up and configure Spring applications. Essentially, **Spring Boot** is an extension that simplifies and accelerates the development process using Spring.

### **What is the relation between Spring platform and Spring framework?**
The **Spring platform** encompasses the entire Spring ecosystem, including the core Spring framework and its various extensions and projects like Spring Boot, Spring Security, Spring Data, etc. The **Spring framework**, on the other hand, is the core component of the Spring platform, providing fundamental features such as dependency injection, aspect-oriented programming, and more.

### **What is Dependency Injection and how is it done in the Spring platform/framework?**
**Dependency Injection (DI)** is a design pattern used to manage the dependencies of an object. In Spring, DI is achieved by externally supplying the dependencies of an object rather than creating them within the object itself. This is typically done through constructor injection, setter injection, or field injection. For example, in Spring, you define dependencies in a configuration file (e.g., XML or JavaConfig) or annotate classes with @Autowired to indicate which dependencies should be injected.

### **What is Inversion of Control (IoC) and how is it related to Spring?**
**Inversion of Control (IoC)** is a design principle where the control flow of a program is inverted, meaning the framework manages the lifecycle of objects and controls the flow of program execution. Spring implements IoC by providing a container (ApplicationContext) that manages the creation and configuration of objects (beans) and injects dependencies into them. This allows for loose coupling between components and facilitates easier testing and maintenance.