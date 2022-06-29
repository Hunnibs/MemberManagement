package Spring.Core.Order;

import Spring.Core.member.Grade;
import Spring.Core.member.Member;
import Spring.Core.member.MemberService;
import Spring.Core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "LEE BYUNGHEON", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
