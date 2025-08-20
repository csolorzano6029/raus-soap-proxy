//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package com.raus.integration.susalud.wsdl.affiliates;

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
 *         <element name="coError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="tiDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="nuDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="apPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="apMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="apCasada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="noPersona" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deSexo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="feNacimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deUbigeo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coContinente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deContinente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coPais" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="dePais" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coDepartamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deDepartamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coDistrito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="deDistrito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="inFallecimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="feFallecimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="coPaisEmisor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element ref="{http://www.susalud.gob.pe/ws/consulta/afiliados/schemas}Afiliaciones"/>
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
    "coError",
    "tiDocumento",
    "nuDocumento",
    "apPaterno",
    "apMaterno",
    "apCasada",
    "noPersona",
    "deSexo",
    "feNacimiento",
    "deUbigeo",
    "coContinente",
    "deContinente",
    "coPais",
    "dePais",
    "coDepartamento",
    "deDepartamento",
    "coProvincia",
    "deProvincia",
    "coDistrito",
    "deDistrito",
    "inFallecimiento",
    "feFallecimiento",
    "coPaisEmisor",
    "afiliaciones"
})
@XmlRootElement(name = "ConsultaResponse")
public class ConsultaResponse {

    @XmlElement(required = true)
    protected String coError;
    @XmlElement(required = true)
    protected String tiDocumento;
    @XmlElement(required = true)
    protected String nuDocumento;
    @XmlElement(required = true)
    protected String apPaterno;
    @XmlElement(required = true)
    protected String apMaterno;
    @XmlElement(required = true)
    protected String apCasada;
    @XmlElement(required = true)
    protected String noPersona;
    @XmlElement(required = true)
    protected String deSexo;
    @XmlElement(required = true)
    protected String feNacimiento;
    @XmlElement(required = true)
    protected String deUbigeo;
    @XmlElement(required = true)
    protected String coContinente;
    @XmlElement(required = true)
    protected String deContinente;
    @XmlElement(required = true)
    protected String coPais;
    @XmlElement(required = true)
    protected String dePais;
    @XmlElement(required = true)
    protected String coDepartamento;
    @XmlElement(required = true)
    protected String deDepartamento;
    @XmlElement(required = true)
    protected String coProvincia;
    @XmlElement(required = true)
    protected String deProvincia;
    @XmlElement(required = true)
    protected String coDistrito;
    @XmlElement(required = true)
    protected String deDistrito;
    @XmlElement(required = true)
    protected String inFallecimiento;
    @XmlElement(required = true)
    protected String feFallecimiento;
    @XmlElement(required = true)
    protected String coPaisEmisor;
    @XmlElement(name = "Afiliaciones", required = true)
    protected Afiliaciones afiliaciones;

    /**
     * Obtiene el valor de la propiedad coError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoError() {
        return coError;
    }

    /**
     * Define el valor de la propiedad coError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoError(String value) {
        this.coError = value;
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
     * Obtiene el valor de la propiedad apPaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * Define el valor de la propiedad apPaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApPaterno(String value) {
        this.apPaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad apMaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * Define el valor de la propiedad apMaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApMaterno(String value) {
        this.apMaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad apCasada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApCasada() {
        return apCasada;
    }

    /**
     * Define el valor de la propiedad apCasada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApCasada(String value) {
        this.apCasada = value;
    }

    /**
     * Obtiene el valor de la propiedad noPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoPersona() {
        return noPersona;
    }

    /**
     * Define el valor de la propiedad noPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoPersona(String value) {
        this.noPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad deSexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeSexo() {
        return deSexo;
    }

    /**
     * Define el valor de la propiedad deSexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeSexo(String value) {
        this.deSexo = value;
    }

    /**
     * Obtiene el valor de la propiedad feNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeNacimiento() {
        return feNacimiento;
    }

    /**
     * Define el valor de la propiedad feNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeNacimiento(String value) {
        this.feNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad deUbigeo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeUbigeo() {
        return deUbigeo;
    }

    /**
     * Define el valor de la propiedad deUbigeo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeUbigeo(String value) {
        this.deUbigeo = value;
    }

    /**
     * Obtiene el valor de la propiedad coContinente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoContinente() {
        return coContinente;
    }

    /**
     * Define el valor de la propiedad coContinente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoContinente(String value) {
        this.coContinente = value;
    }

    /**
     * Obtiene el valor de la propiedad deContinente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeContinente() {
        return deContinente;
    }

    /**
     * Define el valor de la propiedad deContinente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeContinente(String value) {
        this.deContinente = value;
    }

    /**
     * Obtiene el valor de la propiedad coPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoPais() {
        return coPais;
    }

    /**
     * Define el valor de la propiedad coPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoPais(String value) {
        this.coPais = value;
    }

    /**
     * Obtiene el valor de la propiedad dePais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDePais() {
        return dePais;
    }

    /**
     * Define el valor de la propiedad dePais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDePais(String value) {
        this.dePais = value;
    }

    /**
     * Obtiene el valor de la propiedad coDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoDepartamento() {
        return coDepartamento;
    }

    /**
     * Define el valor de la propiedad coDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoDepartamento(String value) {
        this.coDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad deDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeDepartamento() {
        return deDepartamento;
    }

    /**
     * Define el valor de la propiedad deDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeDepartamento(String value) {
        this.deDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad coProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoProvincia() {
        return coProvincia;
    }

    /**
     * Define el valor de la propiedad coProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoProvincia(String value) {
        this.coProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad deProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeProvincia() {
        return deProvincia;
    }

    /**
     * Define el valor de la propiedad deProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeProvincia(String value) {
        this.deProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad coDistrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoDistrito() {
        return coDistrito;
    }

    /**
     * Define el valor de la propiedad coDistrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoDistrito(String value) {
        this.coDistrito = value;
    }

    /**
     * Obtiene el valor de la propiedad deDistrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeDistrito() {
        return deDistrito;
    }

    /**
     * Define el valor de la propiedad deDistrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeDistrito(String value) {
        this.deDistrito = value;
    }

    /**
     * Obtiene el valor de la propiedad inFallecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInFallecimiento() {
        return inFallecimiento;
    }

    /**
     * Define el valor de la propiedad inFallecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInFallecimiento(String value) {
        this.inFallecimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad feFallecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeFallecimiento() {
        return feFallecimiento;
    }

    /**
     * Define el valor de la propiedad feFallecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeFallecimiento(String value) {
        this.feFallecimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad coPaisEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoPaisEmisor() {
        return coPaisEmisor;
    }

    /**
     * Define el valor de la propiedad coPaisEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoPaisEmisor(String value) {
        this.coPaisEmisor = value;
    }

    /**
     * Obtiene el valor de la propiedad afiliaciones.
     * 
     * @return
     *     possible object is
     *     {@link Afiliaciones }
     *     
     */
    public Afiliaciones getAfiliaciones() {
        return afiliaciones;
    }

    /**
     * Define el valor de la propiedad afiliaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link Afiliaciones }
     *     
     */
    public void setAfiliaciones(Afiliaciones value) {
        this.afiliaciones = value;
    }

}
