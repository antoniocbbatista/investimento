package com.empresa.investimento.model.entity;

import lombok.Getter;


@Getter
public enum LoanStatus {

    ACTIVE("active"),
    PAID("paid"),
    OVERDUE("overdue");

    private String status;

    LoanStatus(String status){
        this.status = status;
    }

}
