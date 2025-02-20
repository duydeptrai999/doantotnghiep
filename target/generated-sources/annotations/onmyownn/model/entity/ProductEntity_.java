package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductEntity.class)
public abstract class ProductEntity_ {

	public static volatile SingularAttribute<ProductEntity, String> code;
	public static volatile SingularAttribute<ProductEntity, MaterialEntity> material;
	public static volatile SingularAttribute<ProductEntity, String> name;
	public static volatile SingularAttribute<ProductEntity, String> description;
	public static volatile SingularAttribute<ProductEntity, Long> id;
	public static volatile SingularAttribute<ProductEntity, CategoryEntity> category;
	public static volatile ListAttribute<ProductEntity, ProductDetailEntity> productDetails;
	public static volatile SingularAttribute<ProductEntity, BrandEntity> brand;
	public static volatile SingularAttribute<ProductEntity, Integer> status;

	public static final String CODE = "code";
	public static final String MATERIAL = "material";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_DETAILS = "productDetails";
	public static final String BRAND = "brand";
	public static final String STATUS = "status";

}

