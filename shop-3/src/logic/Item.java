package logic;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Item {
   private Integer id;
   @NotEmpty //not null + 빈문자열 허용 X
   private String name;
   
   @NotNull //null 허용 X
   @Min(100)
   @Max(10000)
   private Integer price;
   
   /*
    * 어노테이션을 통해 Validation을 바로 할 수 있다.
    */
   @NotEmpty
   private String description;
   private String pictureUrl;
   private MultipartFile picture;   //파일업로드할때 사용. 파일 내용이 저장된다.
   
   //getter,setter,toString
   public Integer getId() {
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Integer getPrice() {
      return price;
   }
   public void setPrice(Integer price) {
      this.price = price;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public String getPictureUrl() {
      return pictureUrl;
   }
   public void setPictureUrl(String pictureUrl) {
      this.pictureUrl = pictureUrl;
   }
   public MultipartFile getPicture() {
      return picture;
   }
   public void setPicture(MultipartFile picture) {
      this.picture = picture;
   }
   @Override
   public String toString() {
      return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
            + ", pictureUrl=" + pictureUrl + ", picture=" + picture + "]";
   }
   
}