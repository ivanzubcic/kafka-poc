package hr.pay.karat.kafkapoc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantSalePoint {
    String name;
    String mid;
    Merchant merchant;
    String address;
    String status;
}
