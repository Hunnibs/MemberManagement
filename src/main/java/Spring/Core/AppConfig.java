package Spring.Core;

import Spring.Core.Order.OrderService;
import Spring.Core.Order.OrderServiceImpl;
import Spring.Core.discount.DiscountPolicy;
import Spring.Core.discount.RateDiscountPolicy;
import Spring.Core.member.MemberRepository;
import Spring.Core.member.MemberService;
import Spring.Core.member.MemberServiceImpl;
import Spring.Core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
