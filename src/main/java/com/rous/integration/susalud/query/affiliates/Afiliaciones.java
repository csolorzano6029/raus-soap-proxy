//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.5 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package com.rous.integration.susalud.query.affiliates;

import java.util.ArrayList;
import java.util.List;
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
 *         <element name="afiliacion" maxOccurs="unbounded" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="coAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="tiPlanSalud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="dePlanSalud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="coIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="tiIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="deIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="coParentesco" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="coPaisTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="tiDocTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="nuDocTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="feIniAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="feFinAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="feFinCobertura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="feActIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   <element name="feActSunasa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
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
    "afiliacion"
})
@XmlRootElement(name = "Afiliaciones")
public class Afiliaciones {

    protected List<Afiliaciones.Afiliacion> afiliacion;

    /**
     * Gets the value of the afiliacion property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the afiliacion property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAfiliacion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Afiliaciones.Afiliacion }
     * </p>
     * 
     * 
     * @return
     *     The value of the afiliacion property.
     */
    public List<Afiliaciones.Afiliacion> getAfiliacion() {
        if (afiliacion == null) {
            afiliacion = new ArrayList<>();
        }
        return this.afiliacion;
    }


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
     *         <element name="coAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="tiPlanSalud" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="dePlanSalud" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="coIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="tiIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="deIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="coParentesco" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="coPaisTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="tiDocTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="nuDocTitular" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="feIniAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="feFinAfiliacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="feFinCobertura" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="feActIafas" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         <element name="feActSunasa" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "coAfiliacion",
        "tiPlanSalud",
        "dePlanSalud",
        "coIafas",
        "tiIafas",
        "deIafas",
        "coParentesco",
        "coPaisTitular",
        "tiDocTitular",
        "nuDocTitular",
        "feIniAfiliacion",
        "feFinAfiliacion",
        "feFinCobertura",
        "feActIafas",
        "feActSunasa"
    })
    public static class Afiliacion {

        @XmlElement(required = true)
        protected String coAfiliacion;
        @XmlElement(required = true)
        protected String tiPlanSalud;
        @XmlElement(required = true)
        protected String dePlanSalud;
        @XmlElement(required = true)
        protected String coIafas;
        @XmlElement(required = true)
        protected String tiIafas;
        @XmlElement(required = true)
        protected String deIafas;
        @XmlElement(required = true)
        protected String coParentesco;
        @XmlElement(required = true)
        protected String coPaisTitular;
        @XmlElement(required = true)
        protected String tiDocTitular;
        @XmlElement(required = true)
        protected String nuDocTitular;
        @XmlElement(required = true)
        protected String feIniAfiliacion;
        @XmlElement(required = true)
        protected String feFinAfiliacion;
        @XmlElement(required = true)
        protected String feFinCobertura;
        @XmlElement(required = true)
        protected String feActIafas;
        @XmlElement(required = true)
        protected String feActSunasa;

        /**
         * Obtiene el valor de la propiedad coAfiliacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCoAfiliacion() {
            return coAfiliacion;
        }

        /**
         * Define el valor de la propiedad coAfiliacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCoAfiliacion(String value) {
            this.coAfiliacion = value;
        }

        /**
         * Obtiene el valor de la propiedad tiPlanSalud.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTiPlanSalud() {
            return tiPlanSalud;
        }

        /**
         * Define el valor de la propiedad tiPlanSalud.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTiPlanSalud(String value) {
            this.tiPlanSalud = value;
        }

        /**
         * Obtiene el valor de la propiedad dePlanSalud.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDePlanSalud() {
            return dePlanSalud;
        }

        /**
         * Define el valor de la propiedad dePlanSalud.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDePlanSalud(String value) {
            this.dePlanSalud = value;
        }

        /**
         * Obtiene el valor de la propiedad coIafas.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCoIafas() {
            return coIafas;
        }

        /**
         * Define el valor de la propiedad coIafas.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCoIafas(String value) {
            this.coIafas = value;
        }

        /**
         * Obtiene el valor de la propiedad tiIafas.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTiIafas() {
            return tiIafas;
        }

        /**
         * Define el valor de la propiedad tiIafas.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTiIafas(String value) {
            this.tiIafas = value;
        }

        /**
         * Obtiene el valor de la propiedad deIafas.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDeIafas() {
            return deIafas;
        }

        /**
         * Define el valor de la propiedad deIafas.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDeIafas(String value) {
            this.deIafas = value;
        }

        /**
         * Obtiene el valor de la propiedad coParentesco.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCoParentesco() {
            return coParentesco;
        }

        /**
         * Define el valor de la propiedad coParentesco.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCoParentesco(String value) {
            this.coParentesco = value;
        }

        /**
         * Obtiene el valor de la propiedad coPaisTitular.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCoPaisTitular() {
            return coPaisTitular;
        }

        /**
         * Define el valor de la propiedad coPaisTitular.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCoPaisTitular(String value) {
            this.coPaisTitular = value;
        }

        /**
         * Obtiene el valor de la propiedad tiDocTitular.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTiDocTitular() {
            return tiDocTitular;
        }

        /**
         * Define el valor de la propiedad tiDocTitular.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTiDocTitular(String value) {
            this.tiDocTitular = value;
        }

        /**
         * Obtiene el valor de la propiedad nuDocTitular.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNuDocTitular() {
            return nuDocTitular;
        }

        /**
         * Define el valor de la propiedad nuDocTitular.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNuDocTitular(String value) {
            this.nuDocTitular = value;
        }

        /**
         * Obtiene el valor de la propiedad feIniAfiliacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeIniAfiliacion() {
            return feIniAfiliacion;
        }

        /**
         * Define el valor de la propiedad feIniAfiliacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeIniAfiliacion(String value) {
            this.feIniAfiliacion = value;
        }

        /**
         * Obtiene el valor de la propiedad feFinAfiliacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeFinAfiliacion() {
            return feFinAfiliacion;
        }

        /**
         * Define el valor de la propiedad feFinAfiliacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeFinAfiliacion(String value) {
            this.feFinAfiliacion = value;
        }

        /**
         * Obtiene el valor de la propiedad feFinCobertura.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeFinCobertura() {
            return feFinCobertura;
        }

        /**
         * Define el valor de la propiedad feFinCobertura.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeFinCobertura(String value) {
            this.feFinCobertura = value;
        }

        /**
         * Obtiene el valor de la propiedad feActIafas.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeActIafas() {
            return feActIafas;
        }

        /**
         * Define el valor de la propiedad feActIafas.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeActIafas(String value) {
            this.feActIafas = value;
        }

        /**
         * Obtiene el valor de la propiedad feActSunasa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeActSunasa() {
            return feActSunasa;
        }

        /**
         * Define el valor de la propiedad feActSunasa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeActSunasa(String value) {
            this.feActSunasa = value;
        }

    }

}
