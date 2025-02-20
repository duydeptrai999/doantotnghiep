package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SizeEntity.class)
public abstract class SizeEntity_ {

	public static volatile SingularAttribute<SizeEntity, String> name;
	public static volatile SingularAttribute<SizeEntity, String> description;
	public static volatile SingularAttribute<SizeEntity, Long> id;
	public static volatile ListAttribute<SizeEntity, ProductDetailEntity> productDetails;
	public static volatile SingularAttribute<SizeEntity, Integer> status;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PRODUCT_DETAILS = "productDetails";
	public static final String STATUS = "status";

}

