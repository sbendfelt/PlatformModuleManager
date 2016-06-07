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
 *         &lt;element ref="{}enabled"/>
 *         &lt;element ref="{}businessStatusField"/>
 *         &lt;element ref="{}workflow"/>
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
    "enabled",
    "businessStatusField",
    "workflow"
})
@XmlRootElement(name = "workflowFeature")
public class WorkflowFeature {

    protected boolean enabled;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String businessStatusField;
    @XmlElement(required = true)
    protected Workflow workflow;

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the businessStatusField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessStatusField() {
        return businessStatusField;
    }

    /**
     * Sets the value of the businessStatusField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessStatusField(String value) {
        this.businessStatusField = value;
    }

    /**
     * Gets the value of the workflow property.
     * 
     * @return
     *     possible object is
     *     {@link Workflow }
     *     
     */
    public Workflow getWorkflow() {
        return workflow;
    }

    /**
     * Sets the value of the workflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workflow }
     *     
     */
    public void setWorkflow(Workflow value) {
        this.workflow = value;
    }

}
