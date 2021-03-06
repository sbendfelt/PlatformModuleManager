package com.gtnexus.appxpress.cli.option;

import java.util.Map;

import com.gtnexus.appxpress.exception.AppXpressException;

public interface CLIOptionInterpreter<T extends CLIOption> {

	public Map<T, String> interpret() throws AppXpressException;
	
}
