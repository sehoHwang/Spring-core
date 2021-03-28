package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final에 대한 변수들을 주입하여 생성자를 생성한다.
public class OrderServiceImpl implements Orderservice{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowired // 생성자 주입
    //public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //    this.memberRepository = memberRepository;
    //    this.discountPolicy = discountPolicy;
    //}

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
