package com.rous.soap.proxy.calculator.client;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "intA", "intB" })
@XmlRootElement(name = "Add", namespace = "http://tempuri.org/")
public class Add {

  @XmlElement(namespace = "http://tempuri.org/")
  protected int intA;

  @XmlElement(namespace = "http://tempuri.org/")
  protected int intB;

  public int getIntA() {
    return intA;
  }

  public void setIntA(int intA) {
    this.intA = intA;
  }

  public int getIntB() {
    return intB;
  }

  public void setIntB(int intB) {
    this.intB = intB;
  }
}
