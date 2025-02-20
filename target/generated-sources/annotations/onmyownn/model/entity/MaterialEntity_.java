package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MaterialEntity.class)
public abstract class MaterialEntity_ {

	public static volatile SingularAttribute<MaterialEntity, String> name;
	public static volatile SingularAttribute<MaterialEntity, String> description;
	public static volatile SingularAttribute<MaterialEntity, Long> id;
	public static volatile SingularAttribute<MaterialEntity, Integer> status;
	public static volatile ListAttribute<MaterialEntity, ProductEntity> products;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String PRODUCTS = "products";

}

