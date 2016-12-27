package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.ItemDao;


/*
 * @Service 는 기본적으로 @Component임 (하위)
 * Component기능 (해당 멤버, 혹은 클래스를)객체화 + Controller와 Model의 중간 역할.
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired //ItemDao객체를 주입하게 된다. -> 하지만 인터페이스 이기때문에 실제론 그 구현클래스인 ItemDaoImpl객체가 주입됨
	private ItemDao dao;
	
	@Override
	public List<Item> getItemList() {
		return dao.findAll();
	}

	@Override
	public Item getItemById(Integer id) {
		return dao.selectById(id);
	}

	@Override
	public void entryItem(Item item, HttpServletRequest request) {
		//파일 업로드
		if(item.getPicture() != null && !item.getPicture().isEmpty()){
			uploadFileCreate(item.getPicture(),request);
		}
		
		//db에 등록
		dao.create(item);
	}

	//picture: 업로드된 파일의 내용을 저장하고 있는 객체.
	private void uploadFileCreate(MultipartFile picture, HttpServletRequest request) {
		String uploadPath= request.getServletContext().getRealPath("/")+"/img/";
		FileOutputStream fos= null;
		
		try{
			fos = new FileOutputStream(uploadPath + picture.getOriginalFilename());
			InputStream in = picture.getInputStream();
			int data;
			
			while((data=in.read())!=-1){
				fos.write(data);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fos != null){
					fos.flush();
					fos.close();
				}
			}catch(IOException e){}
		}
	}

	@Override
	public void itemUpdate(Item item, HttpServletRequest request) {
		if(item.getPicture() != null && !item.getPicture().isEmpty()){
			uploadFileCreate(item.getPicture(),request);
			item.setPictureUrl(item.getPicture().getOriginalFilename());
		}
		
		dao.update(item);
	}

	@Override
	public void itemDelete(Integer id) {
		dao.delete(id);
	}

}
