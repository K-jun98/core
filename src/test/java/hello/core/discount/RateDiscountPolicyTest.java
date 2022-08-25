package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("VIP일때 할인 금액")
    void VIP_O() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP아닐때 할인 금액")
    void VIP_X() throws Exception {
        //given
        Member member = new Member(2L, "memberA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}