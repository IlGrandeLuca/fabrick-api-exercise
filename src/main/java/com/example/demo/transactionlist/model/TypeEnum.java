package com.example.demo.transactionlist.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Type")
@XmlEnum
public enum TypeEnum {

    GBS_TRANSACTION_TYPE;

    public String value() {
        return name();
    }

    public static TypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
