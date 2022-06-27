package Spring.Core.Order;

import Spring.Core.discount.DiscountPolicy;
import Spring.Core.discount.FixDiscountPolicy;
import Spring.Core.member.Member;
import Spring.Core.member.MemberRepository;
import Spring.Core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
