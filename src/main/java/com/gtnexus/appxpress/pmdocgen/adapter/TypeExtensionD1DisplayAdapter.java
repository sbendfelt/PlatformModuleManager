package com.gtnexus.appxpress.pmdocgen.adapter;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.gtnexus.appxpress.platform.module.model.typeextension.Callbacks;
import com.gtnexus.appxpress.platform.module.model.typeextension.TypeExtensionD1;

public class TypeExtensionD1DisplayAdapter extends DisplayAdapter<TypeExtensionD1>{

	private static final Function<TypeExtensionD1, String> DOC_TYPE_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			return te.getDocumentType();
		}
	};

	private static final Function<TypeExtensionD1, String> API_VERSION_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			return te.getApiVersion() == null ? "" : te.getApiVersion().toString();
		}
	};

	private static final Function<TypeExtensionD1, String> RANK_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			return te.getRank() == null ? "" : te.getRank().toString();
		}
	};

	private static final Function<TypeExtensionD1, String> EVENT_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			Callbacks cb = te.getCallbacks();
			return cb == null ? "" : cb.getEvent();
		}
	};

	private static final Function<TypeExtensionD1, String> ROLE_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			Callbacks cb = te.getCallbacks();
			return cb == null ? "" : cb.getRole();
		}
	};

	private static final Function<TypeExtensionD1, String> FN_NAME_FN = new PrimitiveDisplayFunction<TypeExtensionD1>() {
		@Override
		public String applyToNonNull(TypeExtensionD1 te) {
			Callbacks cb = te.getCallbacks();
			return cb == null ? "" : cb.getFunctionName();
		}
	};
	
	private static final Map<String, Function<TypeExtensionD1, String>> adapterMap = new ImmutableMap.Builder<String, Function<TypeExtensionD1, String>>()
			.put("Document Type", DOC_TYPE_FN)
			.put("API Version", API_VERSION_FN)
			.put("Rank", RANK_FN)
			.put("Event", EVENT_FN)
			.put("Role", ROLE_FN)
			.put("Function Name", FN_NAME_FN)
			.build();
	
	public TypeExtensionD1DisplayAdapter() {
		super(adapterMap);
	}
}
