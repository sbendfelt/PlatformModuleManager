package com.gtnexus.appxpress.pmbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gtnexus.appxpress.pmbuilder.cli.BuilderOption;

public class PlatformModuleBuilderTest {

	@Test
	public void testGetContextType() {
		PlatformModuleBuilder pmb = new PlatformModuleBuilder();
		Class<?> type = pmb.getContextType();
		assertEquals(type, BuilderOption.HELP.getClass());
		String className = type.getName();
		assertTrue("ClassName should have been BuilderOption but was "  + className,
				className.endsWith("BuilderOption"));
	}

}
