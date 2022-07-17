package kau.isabu.web_project.order;

public interface OrderService {
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
