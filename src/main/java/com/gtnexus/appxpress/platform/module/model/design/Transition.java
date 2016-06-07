//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.27 at 10:15:51 AM PDT 
//


package com.gtnexus.appxpress.platform.module.model.design;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}fromState"/>
 *         &lt;element ref="{}toState"/>
 *         &lt;element ref="{}action"/>
 *         &lt;element ref="{}roles"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}preconditionFn"/>
 *           &lt;element ref="{}postTransitionFn"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fromState",
    "toState",
    "action",
    "roles",
    "preconditionFn",
    "postTransitionFn"
})
@XmlRootElement(name = "transition")
public class Transition {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fromState;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String toState;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String action;
    @XmlElement(required = true)
    protected String roles;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String preconditionFn;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String postTransitionFn;

    /**
     * Gets the value of the fromState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromState() {
        return fromState;
    }

    /**
     * Sets the value of the fromState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromState(String value) {
        this.fromState = value;
    }

    /**
     * Gets the value of the toState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToState() {
        return toState;
    }

    /**
     * Sets the value of the toState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToState(String value) {
        this.toState = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoles(String value) {
        this.roles = value;
    }

    /**
     * Gets the value of the preconditionFn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreconditionFn() {
        return preconditionFn;
    }

    /**
     * Sets the value of the preconditionFn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreconditionFn(String value) {
        this.preconditionFn = value;
    }

    /**
     * Gets the value of the postTransitionFn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostTransitionFn() {
        return postTransitionFn;
    }

    /**
     * Sets the value of the postTransitionFn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostTransitionFn(String value) {
        this.postTransitionFn = value;
    }

}
