package hr.pay.karat.kafkapoc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PosData {
    String name;
    String tid;
    MerchantSalePoint merchantSalePoint;
    String currency;
    String address;
    String email;
    String status;
}
