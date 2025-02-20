package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductDetailEntity.class)
public abstract class ProductDetailEntity_ {

	public static volatile SingularAttribute<ProductDetailEntity, ProductEntity> product;
	public static volatile ListAttribute<ProductDetailEntity, ImageEntity> images;
	public static volatile SingularAttribute<ProductDetailEntity, Integer> quantity;
	public static volatile SingularAttribute<ProductDetailEntity, String> code;
	public static volatile SingularAttribute<ProductDetailEntity, ColorEntity> color;
	public static volatile SingularAttribute<ProductDetailEntity, SizeEntity> size;
	public static volatile SingularAttribute<ProductDetailEntity, Double> price;
	public static volatile SingularAttribute<ProductDetailEntity, Long> id;
	public static volatile SingularAttribute<ProductDetailEntity, String> productName;
	public static volatile SingularAttribute<ProductDetailEntity, Integer> status;

	public static final String PRODUCT = "product";
	public static final String IMAGES = "images";
	public static final String QUANTITY = "quantity";
	public static final String CODE = "code";
	public static final String COLOR = "color";
	public static final String SIZE = "size";
	public static final String PRICE = "price";
	public static final String ID = "id";
	public static final String PRODUCT_NAME = "productName";
	public static final String STATUS = "status";

}

