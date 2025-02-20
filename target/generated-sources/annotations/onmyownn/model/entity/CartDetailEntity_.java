package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartDetailEntity.class)
public abstract class CartDetailEntity_ {

	public static volatile SingularAttribute<CartDetailEntity, Integer> quantity;
	public static volatile SingularAttribute<CartDetailEntity, ProductDetailEntity> productDetail;
	public static volatile SingularAttribute<CartDetailEntity, Long> id;
	public static volatile SingularAttribute<CartDetailEntity, CartEntity> cart;
	public static volatile SingularAttribute<CartDetailEntity, Integer> status;

	public static final String QUANTITY = "quantity";
	public static final String PRODUCT_DETAIL = "productDetail.jsp";
	public static final String ID = "id";
	public static final String CART = "cart";
	public static final String STATUS = "status";

}

