/**
 * CAdxObjectListXml.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.adonix.awss.stubs;

public interface CAdxObjectListXml extends java.rmi.Remote {
    public com.adonix.awss.stubs.CAdxResultXml query(java.lang.String publicName, com.adonix.awss.stubs.CAdxParamKeyValue[] objectKeys, int listSize) throws java.rmi.RemoteException;
    public com.adonix.awss.stubs.CAdxResultXml getDescription(java.lang.String publicName) throws java.rmi.RemoteException;
}
