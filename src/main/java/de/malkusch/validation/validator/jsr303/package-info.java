/**
 * Additional validators for JSR-303 built-in constraints.
 *  
 * You have to add these validators to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 * @see javax.validation.ConstraintValidator
 * @see http://beanvalidation.org/1.0/spec/#xml-mapping-constraintdefinition 
 *  
 * @author Markus Malkusch <markus@malkusch.de>
 */
package de.malkusch.validation.validator.jsr303;
import javax.validation.Configuration;
