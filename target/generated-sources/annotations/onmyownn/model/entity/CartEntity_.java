package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartEntity.class)
public abstract class CartEntity_ {

	public static volatile ListAttribute<CartEntity, CartDetailEntity> cartDetails;
	public static volatile SingularAttribute<CartEntity, Long> id;
	public static volatile SingularAttribute<CartEntity, AccountEntity> account;

	public static final String CART_DETAILS = "cartDetails";
	public static final String ID = "id";
	public static final String ACCOUNT = "account";

}

