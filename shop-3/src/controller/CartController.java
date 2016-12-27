package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.ShopService;

@Controller
public class CartController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping("cart/cartAdd") //id = 상품 아이디, quantity = 수량
	public ModelAndView add(Integer id, Integer quantity, HttpSession session){ //해당 리퀘스트매핑 메소드에서 request객체를 사용하고싶으면 HttpServletRequest, session객체를 사용하고 싶으면 HttpSession 을 매개변수로 받는다. 
																	//여기선 세션객체에 cart를 등록하기위해 사용
		Item selectedItem = shopService.getItemById(id); //selectedItem : 선택된 상품정보
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null){
			cart=shopService.getCart(); //빈 껍데기 카트를 만듦
			session.setAttribute("CART", cart); //카트를 "세션"에 저장을 해놨음 , cart라는 속성을 등록하지 않은경우(null) 빈 껍데기 카트를 하나 만들어서 세션에 등록
		}
		
		cart.push(new ItemSet(selectedItem, quantity));
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("message", selectedItem.getName() + quantity +"개를 카트에 추가하였습니다.");
		mav.addObject("cart",cart);
		
		return mav;
	}
	@RequestMapping("cart/cartDelete")
	public ModelAndView delete(int index, HttpSession session){
		Cart cart = (Cart)session.getAttribute("CART"); //세션에서 CART 어트리뷰트에 잇는 카트객체를 cart 변수에 담는다.(객체, 인덱스 잘넘어옴)
		String name = cart.remove(index);

		ModelAndView mav = new ModelAndView("/cart/cart");
		mav.addObject("message", name+" 상품이 장바구니에서 삭제되었습니다.");
		mav.addObject("cart",cart);
		return mav;
	}
	@RequestMapping("cart/cartView")
	public ModelAndView cartView(HttpSession session){
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart==null || cart.isEmpty()){
			throw new CartEmptyException("장바구니에 상품이 없습니다.");
		}
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message","장바구니 보기 화면 입니다.");
		mav.addObject("cart",cart);
		return mav;
	}
}
