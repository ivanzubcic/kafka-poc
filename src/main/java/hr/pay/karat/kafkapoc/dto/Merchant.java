package hr.pay.karat.kafkapoc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
    String name;
    String shortName;
    String oib;
    String address;
    String status;
}
