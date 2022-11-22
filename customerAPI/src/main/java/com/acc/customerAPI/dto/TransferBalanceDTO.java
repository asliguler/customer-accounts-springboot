package com.acc.customerAPI.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TransferBalanceDTO {
    private String sourceAccountId;
    private String destinationAccountId;
    private Integer transferAmount;
}
