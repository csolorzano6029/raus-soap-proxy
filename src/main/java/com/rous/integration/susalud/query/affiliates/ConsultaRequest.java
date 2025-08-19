//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package com.rous.integration.susalud.query.affiliates;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.</p>
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idInstitucion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="tiDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="nuDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="doConsultante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idInstitucion",
    "tiDocumento",
    "nuDocumento",
    "doConsultante"
})
@XmlRootElement(name = "ConsultaRequest")
public class ConsultaRequest {

    @XmlElement(required = true)
    protected String idInstitucion;
    @XmlElement(required = true)
    protected String tiDocumento;
    @XmlElement(required = true)
    protected String nuDocumento;
    @XmlElement(required = true)
    protected String doConsultante;

    /**
     * Obtiene el valor de la propiedad idInstitucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdInstitucion() {
        return idInstitucion;
    }

    /**
     * Define el valor de la propiedad idInstitucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdInstitucion(String value) {
        this.idInstitucion = value;
    }

    /**
     * Obtiene el valor de la propiedad tiDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiDocumento() {
        return tiDocumento;
    }

    /**
     * Define el valor de la propiedad tiDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiDocumento(String value) {
        this.tiDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad nuDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuDocumento() {
        return nuDocumento;
    }

    /**
     * Define el valor de la propiedad nuDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuDocumento(String value) {
        this.nuDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad doConsultante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoConsultante() {
        return doConsultante;
    }

    /**
     * Define el valor de la propiedad doConsultante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoConsultante(String value) {
        this.doConsultante = value;
    }

}
