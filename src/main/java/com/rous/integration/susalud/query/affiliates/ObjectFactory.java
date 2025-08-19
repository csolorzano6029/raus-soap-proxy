//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package com.rous.integration.susalud.query.affiliates;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rous.integration.susalud.query.affiliates package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rous.integration.susalud.query.affiliates
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Afiliaciones }
     * 
     * @return
     *     the new instance of {@link Afiliaciones }
     */
    public Afiliaciones createAfiliaciones() {
        return new Afiliaciones();
    }

    /**
     * Create an instance of {@link ConsultaRequest }
     * 
     * @return
     *     the new instance of {@link ConsultaRequest }
     */
    public ConsultaRequest createConsultaRequest() {
        return new ConsultaRequest();
    }

    /**
     * Create an instance of {@link ConsultaResponse }
     * 
     * @return
     *     the new instance of {@link ConsultaResponse }
     */
    public ConsultaResponse createConsultaResponse() {
        return new ConsultaResponse();
    }

    /**
     * Create an instance of {@link Afiliaciones.Afiliacion }
     * 
     * @return
     *     the new instance of {@link Afiliaciones.Afiliacion }
     */
    public Afiliaciones.Afiliacion createAfiliacionesAfiliacion() {
        return new Afiliaciones.Afiliacion();
    }

}
