package Spring.Core;

import Spring.Core.Order.OrderService;
import Spring.Core.Order.OrderServiceImpl;
import Spring.Core.discount.DiscountPolicy;
import Spring.Core.discount.RateDiscountPolicy;
import Spring.Core.member.MemberRepository;
import Spring.Core.member.MemberService;
import Spring.Core.member.MemberServiceImpl;
import Spring.Core.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
