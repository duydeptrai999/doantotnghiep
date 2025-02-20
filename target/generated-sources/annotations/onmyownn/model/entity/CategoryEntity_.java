package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CategoryEntity.class)
public abstract class CategoryEntity_ {

	public static volatile SingularAttribute<CategoryEntity, String> name;
	public static volatile SingularAttribute<CategoryEntity, String> description;
	public static volatile SingularAttribute<CategoryEntity, Long> id;
	public static volatile SingularAttribute<CategoryEntity, Integer> status;
	public static volatile ListAttribute<CategoryEntity, ProductEntity> products;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String PRODUCTS = "products";

}

