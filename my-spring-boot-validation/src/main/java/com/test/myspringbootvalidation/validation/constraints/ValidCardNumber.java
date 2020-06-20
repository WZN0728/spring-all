/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ValidCardNumber.java
 * @Package com.test.myspringbootvalidation.validation.constraints
 * @Copyright: 2018 All rights reserved.
 */
package com.test.myspringbootvalidation.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.test.myspringbootvalidation.validation.ValidCardNumberConstraintValidator;

/**
 * @ClassName: ValidCardNumber
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年2月28日 下午4:55:50
 */
@Documented
@Target({ ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidCardNumberConstraintValidator.class })
public @interface ValidCardNumber {

	String message() default "{com.test.validation.invalid.card.number.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
