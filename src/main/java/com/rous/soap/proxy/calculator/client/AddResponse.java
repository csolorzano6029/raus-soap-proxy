package com.rous.soap.proxy.calculator.client;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "addResult" })
@XmlRootElement(name = "AddResponse", namespace = "http://tempuri.org/")
public class AddResponse {

  @XmlElement(name = "AddResult", namespace = "http://tempuri.org/")
  protected int addResult;

  public int getAddResult() {
    return addResult;
  }

  public void setAddResult(int addResult) {
    this.addResult = addResult;
  }
}
