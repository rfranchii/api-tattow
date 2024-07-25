package com.sqav.tattow.support;

import java.util.regex.Pattern;

public class CellphoneValidator {
	
	private static final Pattern PATTERN_CELLPHONE = Pattern.compile("^\\(\\d{2}\\)\\s?[6-9]?\\d{4}-?\\d{4}$");

	private static final Pattern PATTER_PHONE = Pattern.compile("^\\(\\d{2}\\)\\s?\\d{4}-?\\d{4}$");

	private CellphoneValidator() {
		throw new IllegalStateException("Classe utilitária");
	}

	public static boolean isCellphone(String cellphone) {
		if (Strings.isBlankOrNull(cellphone)) {
			return false;
		}
		return PATTERN_CELLPHONE.matcher(cellphone).matches();
	}

	public static boolean isPhone(String phone) {
		if (Strings.isBlankOrNull(phone)) {
			return false;
		}
		return PATTER_PHONE.matcher(phone).matches();
	}
}