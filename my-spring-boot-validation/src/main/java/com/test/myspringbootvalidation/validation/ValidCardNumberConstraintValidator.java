/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ValidCardNumberConstraintValidator.java
 * @Package com.test.myspringbootvalidation.validation
 * @Copyright: 2018 All rights reserved.
 */
package com.test.myspringbootvalidation.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.test.myspringbootvalidation.validation.constraints.ValidCardNumber;

/**
 * @ClassName: ValidCardNumberConstraintValidator
 * @Description:TODO {@link ValidCardNumber.java} {@link }
 * @author: 吴停
 * @date: 2018年2月28日 下午4:54:57
 */
public class ValidCardNumberConstraintValidator implements ConstraintValidator<ValidCardNumber, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(ValidCardNumber constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		String[] parts = value.split("-");
		String prefix = parts[0];
		String suffix = parts[1];
		boolean isValidPrefix = Objects.equals(prefix, "LXR");
		boolean isValidNumber = StringUtils.isNumeric(suffix);
		return isValidPrefix && isValidNumber;
	}

}
