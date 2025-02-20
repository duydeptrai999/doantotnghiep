package onmyownn.model.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VoucherEntity.class)
public abstract class VoucherEntity_ {

	public static volatile SingularAttribute<VoucherEntity, String> code;
	public static volatile SingularAttribute<VoucherEntity, Integer> quantity;
	public static volatile SingularAttribute<VoucherEntity, Double> price;
	public static volatile SingularAttribute<VoucherEntity, String> name;
	public static volatile SingularAttribute<VoucherEntity, Long> id;
	public static volatile SingularAttribute<VoucherEntity, Double> maxPrice;
	public static volatile SingularAttribute<VoucherEntity, Boolean> type;
	public static volatile SingularAttribute<VoucherEntity, LocalDateTime> endAt;
	public static volatile SingularAttribute<VoucherEntity, Double> minimumPrice;
	public static volatile SingularAttribute<VoucherEntity, LocalDateTime> startAt;
	public static volatile SingularAttribute<VoucherEntity, Double> minOrderValue;

	public static final String CODE = "code";
	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String MAX_PRICE = "maxPrice";
	public static final String TYPE = "type";
	public static final String END_AT = "endAt";
	public static final String MINIMUM_PRICE = "minimumPrice";
	public static final String START_AT = "startAt";
	public static final String MIN_ORDER_VALUE = "minOrderValue";

}

