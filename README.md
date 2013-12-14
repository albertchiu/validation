# Validation
This library provides a set of additional JSR-303 constraints and validators.
You find the constraints in the package
`[de.malkusch.validation.constraints}(http://malkusch.github.io/validation/index.html?de/malkusch/validation/constraints/package-summary.html)`.

# Optional Dependencies
Some constraints require further dependencies. If you want to use them you
have to provide those dependencies:

* `de.malkusch.validation.constraints.age.*` requires `joda-time.joda-time`.
* `de.malkusch.validation.constraints.upload.*` requires `org.springframework.web` and `javax.mail.mail`.

# Additional Validators for JSR-303 built-ins
This package extends some JSR-303 built-in constraints with validators for additional types. Look into the
package `de.malkusch.validation.validator.jsr303` to see which validators exist.
If you want to use these validators you have to include the mapping
resource **META-INF/validation/mapping.xml**. This can be done by 
preferably create the file **META-INF/validation.xml**
and add that mapping or you do it programmatically with `Configuration.addMapping(java.io.InputStream)`:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<validation-config
    xmlns="http://jboss.org/xml/ns/javax/validation/configuration"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://jboss.org/xml/ns/javax/validation/configuration validation-configuration-1.0.xsd">
    
    <constraint-mapping>META-INF/validation/mapping.xml</constraint-mapping>
</validation-config>
```

# Maven
You find this package in Maven central:
```xml
<dependency>
    <groupId>de.malkusch.validation</groupId>
    <artifactId>validation</artifactId>
    <version>0.0.1</version>
</dependency>
```