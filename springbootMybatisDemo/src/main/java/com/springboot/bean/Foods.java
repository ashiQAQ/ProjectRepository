package com.springboot.bean;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 商品表实体
 * 表名 foods
 */
@Log
@Data
public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;

        //商品id 主键自增
        @NotNull
        private Integer id;
        //分类id
        private Integer categoryId;
        //商品name
        private String name;
        //商品价格
        private Double price;
        //商品价格
        private Double oldPrice;
        //商品name
        private String description;
        //销售量
        private Integer sellCount;
        //好评率
        private Integer rating;
        //详情
        private String info;
        //icon_url
        private String icon;
        //image_url
        private String image;
        //商品所包含的评价列表
        private List<Ratings> ratings;

    /**

     Lombok注解
     @Data：注解在类上，将类提供的所有属性都添加get、set方法，并添加、equals、canEquals、hashCode、toString方法
     @Setter：注解在类上，为所有属性添加set方法、注解在属性上为该属性提供set方法
     @Getter：注解在类上，为所有的属性添加get方法、注解在属性上为该属性提供get方法
     @NotNull：在参数中使用时，如果调用时传了null值，就会抛出空指针异常
     @Synchronized 用于方法，可以锁定指定的对象，如果不指定，则默认创建一个对象锁定
     @Log作用于类，创建一个log属性
     @Builder：使用builder模式创建对象
     @NoArgsConstructor：创建一个无参构造函数
     @AllArgsConstructor：创建一个全参构造函数
     @ToStirng：创建一个toString方法
     @Accessors(chain = true)使用链式设置属性，set方法返回的是this对象。
     @RequiredArgsConstructor：创建对象
     @UtilityClass:工具类
     @ExtensionMethod:设置父类
     @FieldDefaults：设置属性的使用范围，如private、public等，也可以设置属性是否被final修饰。
     @Cleanup: 关闭流、连接点。
     @EqualsAndHashCode：重写equals和hashcode方法。
     @toString：创建toString方法。
     */
}
