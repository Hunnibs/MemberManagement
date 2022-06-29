package Spring.Core.Discount;

import Spring.Core.discount.RateDiscountPolicy;
import Spring.Core.member.Grade;
import Spring.Core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip 10% 할인 적용.")
    void vip_o() {
        //given
        Member member = new Member(1L, "LEE", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip 10% 할인 적용.")
    void vip_x() {
        //given
        Member member = new Member(1L, "LEE", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}
