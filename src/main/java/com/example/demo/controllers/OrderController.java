package com.example.demo.controllers;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.member.service.interfaces.ShoppingOrderProductServiceImpl;
import com.example.demo.domains.member.service.interfaces.ShoppingOrderServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ShoppingOrderProductServiceImpl shoppingOrderProductService;
    private final ShoppingOrderServiceImpl shoppingOrderService;

    // 주문 관리 페이지
    @GetMapping
    public String orderManagementPage(
            @RequestParam(defaultValue = "all") String status,
            Model model,
            HttpSession session) {

        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // 대시보드 정보
        long receivedOrdersCount = shoppingOrderProductService.countByShippingStatus("접수 상태");
        long shippingOrdersCount = shoppingOrderProductService.countByShippingStatus("배송 상태");
        long completedOrdersCount = shoppingOrderProductService.countByShippingStatus("배송 완료");

        model.addAttribute("receivedOrdersCount", receivedOrdersCount);
        model.addAttribute("shippingOrdersCount", shippingOrdersCount);
        model.addAttribute("completedOrdersCount", completedOrdersCount);

        // 주문 목록 필터링
        List<ShoppingOrder> orders;
        if ("pending".equals(status)) {
            orders = shoppingOrderService.findOrdersByStatus("접수 상태");
        } else if ("shipping".equals(status)) {
            orders = shoppingOrderService.findOrdersByStatus("배송 상태");
        } else if ("completed".equals(status)) {
            orders = shoppingOrderService.findOrdersByStatus("배송 완료");
        } else {
            orders = shoppingOrderService.findAllOrders(); // 전체 주문
        }

        model.addAttribute("orders", orders);
        model.addAttribute("selectedStatus", status);

        return "product/product-main"; // 주문 관리 페이지로 이동
    }

    // 주문 상태 일괄 변경 (POST 요청)
    @PostMapping("/admin/orders/bulk-update")
    public String bulkUpdateOrderStatus(
            @RequestParam List<Long> orderIds,
            @RequestParam String newStatus,
            Model model) {

        // 선택된 주문의 상태를 변경하는 로직
        shoppingOrderService.updateOrderStatus(orderIds, newStatus);
//        orderService.updateOrderStatus(orderIds, newStatus);

        return "redirect:/admin/orders"; // 주문 관리 페이지로 리다이렉트
    }
}
