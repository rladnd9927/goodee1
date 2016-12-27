package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ItemService;

/*
 * @Controller는 기본적으로 @Component에 해당한다.(하위)
 * Component기능 (해당 멤버, 혹은 클래스를)객체화 + Controller기능
 * 
 * 이 ItemController객체가 객체화 될때,필요한 객체가 몇개 있음
 * @Autowired : ItemService객체를 주입하라는 뜻. (실제로는 ItemServiceImpl객체가 주입)
 * 
 * 
 */


@Controller
public class ItemController {
	
	@Autowired //ItemService객체를 주입하게 된다. -> 하지만 인터페이스 이기때문에 실제론 그 구현클래스인 ItemServiceImpl객체가 주입됨
	private ItemService itemService; 
	
	@RequestMapping("item/list") // item/list.shop이 호출 되는경우 shop-3-servlet.xml의 뷰 리졸버와 @Requestmapping과   handlerMapping에 의하여(xml 주석 참고), /WEB-INF/jsp/item/list.jsp를 실행한다.
	public ModelAndView list(){
		
		//itemList : item테이블의 내용을 전부 Item객체에 저장하여 리턴받는다.
		List<Item> itemList = itemService.getItemList();
		
		//ModelAndView : 데이터 + 뷰의 이름을 설정 (리퀘스트 객체를 쓰지 않고도, 데이터를 뷰단으로 전달 가능하다. 아래의 경우 addObject를 통해 itemList에 들어있는 Item객체를 넘겨주게 된다.)
						//이때, 뷰설정을 하는 부분이 없는데, 이 것은 xml설정에 의해서 , '이름'을 기본으로 뷰가 설정이 된다. (여기선 item/list 경로와 shop-3-servlet.xml의 뷰 리졸버 경로에 의해, WEB-INF/jsp/item/list.jsp가 실행됨)
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList",itemList); //뷰단에 어트리뷰트로 등록 el태그로 끌어오도록
		return mav;
	}
	
	@RequestMapping("item/detail")
	public ModelAndView detail(Integer id){ //detail.jsp 뷰단을 불러올때, 파라미터로 id값이 넘어온다
		Item item = itemService.getItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item); //view단에 어트리뷰트로 등록
		return mav;
	}
	
	@RequestMapping("item/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("item/add");
		mav.addObject(new Item());
		return mav;
	}
	@RequestMapping("item/register")
	public ModelAndView register(@Valid Item item, BindingResult bindingResult, HttpServletRequest request){
		
		//@Valid : Item 객체를 생성할때, 유효성 검증도 같이 하라는 뜻이다. Item 클래스에 있는 어노테이션과 연결된다. (기존에 Validator 인터페이스, 구현클래스가 필요없어짐)
		//@Valid를 이용해 검증할때, 반드시 다음 파라미터로는 BindingResult여야 한다.
		ModelAndView mav = new ModelAndView("item/add");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		itemService.entryItem(item,request);
		mav.setViewName("redirect:/item/list.shop");
		return mav;
	}
	
	@RequestMapping("item/edit")
	public ModelAndView edit(Integer id){
		
		return detail(id);
	}
	@RequestMapping("item/update")
	public ModelAndView update(@Valid Item item, BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("item/edit");
		
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav; //수정시 오류가 발생하면 edit.jsp 뷰단에 머물도록 item/edit를 설정해야함(update.jsp 뷰는 없으므로 그자리에 머물도록)
		}
		itemService.itemUpdate(item,request);
		mav.setViewName("redirect:/item/list.shop"); //redirect시 , 데이터를 넘겨주지 않아도 된다. (실제로 데이터 안넘어감)
		return mav;
	}
	@RequestMapping("item/confirm")
	public ModelAndView confirm(Integer id){
		Item item = itemService.getItemById(id);
		ModelAndView mav = new ModelAndView("item/delete");
		
		mav.addObject("item",item);
		return mav;
	}
	
	
	
	/*
	 * delete 의 경우, item객체를 삭제후, 데이터를 다시 리턴해줄 필요가 없다.(삭제했는데 넘겨줄 이유가없음)
	 * 이 경우 아래와같이 item객체 삭제 수행후 바로 redirect 시켜주도록 코드를 작성해도 문제는 없다. (redirect를 하게되면 데이터를 넘기지 않는다.)
	 */
	@RequestMapping("item/delete")
//	public ModelAndView delete(Integer id){
//		ModelAndView mav = new ModelAndView();
//		itemService.itemDelete(id);
//		mav.setViewName("redirect:/item/list.shop");
//		return mav;
//	}

	public String delete(Integer id){
		itemService.itemDelete(id);
		return "redirect:/item/list.shop";
	}
	
	

}
