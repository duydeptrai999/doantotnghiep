package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BrandEntity.class)
public abstract class BrandEntity_ {

	public static volatile SingularAttribute<BrandEntity, String> name;
	public static volatile SingularAttribute<BrandEntity, String> description;
	public static volatile SingularAttribute<BrandEntity, Long> id;
	public static volatile SingularAttribute<BrandEntity, Integer> status;
	public static volatile ListAttribute<BrandEntity, ProductEntity> products;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String PRODUCTS = "products";

}

