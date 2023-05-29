package com.inventario;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
	public static void main(String[] args) {
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		System.out.print(date);

	}

}
