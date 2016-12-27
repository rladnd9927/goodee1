package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Cart;
import logic.Sale;
import logic.ShopService;
import logic.User;

@Controller
public class CheckoutController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping("checkout/checkout")
	public ModelAndView checkout(HttpSession session){
		//로그인 상태가 아닌경우 오류 처리하기
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null){
			throw new LoginRequiredException("로그인이 필요한 서비스입니다.");
		}
		
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException("카트에 상품이 없습니다.");
		}
		
		ModelAndView mav = new ModelAndView();
		Integer totalAmount=shopService.calculateTotalAmount(cart.getItemList());  //cart.jsp 뷰에서 상품리스트 찍어줄때처럼 varStatus이용해서 리스트 사용해도되고 지금처럼 컨트롤러 단에서 찍어도됨(일부러 다른방식으로 작성)
		mav.addObject("itemList",cart.getItemList());
		mav.addObject("totalAmount",totalAmount);
		mav.addObject("loginUser",loginUser);
		return mav;
	}
	
	@RequestMapping("checkout/end")
	public ModelAndView end(HttpSession session){
		Cart cart = (Cart)session.getAttribute("CART");
		User loginUser = (User)session.getAttribute("USER");
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException("");
		}
		ModelAndView mav = new ModelAndView();
		
		Sale sale = shopService.checkEnd(loginUser,cart);
		int totalAmount = shopService.calculateTotalAmount(cart.getItemList());
		mav.addObject("itemList",cart.getItemList());
		cart.clearAll(session);
		mav.addObject("totalAmount",totalAmount);
		mav.addObject("loginUser",loginUser);
		mav.addObject("sale",sale);
		return mav;
	}
}
