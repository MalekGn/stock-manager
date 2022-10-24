package com.esprit.stockmanager.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeConverter;

public class SpecificAttributeConverter implements AttributeConverter<Set<String>, String> {

	private static final String JOIN_SEPARATOR = ",";

	@Override
	public String convertToDatabaseColumn(Set<String> attribute) {
		return attribute == null ? null : String.join(JOIN_SEPARATOR, attribute);
	}

	@Override
	public Set<String> convertToEntityAttribute(String dbData) {
		return dbData == null ? Collections.emptySet() : new HashSet<>(Arrays.asList(dbData.split(JOIN_SEPARATOR)));
	}
}