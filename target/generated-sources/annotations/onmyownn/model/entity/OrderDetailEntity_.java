package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderDetailEntity.class)
public abstract class OrderDetailEntity_ {

	public static volatile SingularAttribute<OrderDetailEntity, Integer> quantity;
	public static volatile SingularAttribute<OrderDetailEntity, String> code;
	public static volatile SingularAttribute<OrderDetailEntity, ProductDetailEntity> productDetail;
	public static volatile SingularAttribute<OrderDetailEntity, Double> price;
	public static volatile SingularAttribute<OrderDetailEntity, Long> id;
	public static volatile SingularAttribute<OrderDetailEntity, Integer> status;
	public static volatile SingularAttribute<OrderDetailEntity, OrderEntity> order;

	public static final String QUANTITY = "quantity";
	public static final String CODE = "code";
	public static final String PRODUCT_DETAIL = "productDetail";
	public static final String PRICE = "price";
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String ORDER = "order";

}

