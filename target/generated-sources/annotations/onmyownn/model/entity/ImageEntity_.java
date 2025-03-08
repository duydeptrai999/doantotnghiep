package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImageEntity.class)
public abstract class ImageEntity_ {

	public static volatile SingularAttribute<ImageEntity, ProductDetailEntity> productDetail;
	public static volatile SingularAttribute<ImageEntity, Long> id;
	public static volatile SingularAttribute<ImageEntity, String> source;

	public static final String PRODUCT_DETAIL = "productDetail";
	public static final String ID = "id";
	public static final String SOURCE = "source";

}

