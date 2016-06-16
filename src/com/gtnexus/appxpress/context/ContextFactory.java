package com.gtnexus.appxpress.context;

import static com.gtnexus.appxpress.commons.AppXpressConstants.PROPERTIES_EXTENSION;

import java.util.Map;

import com.gtnexus.appxpress.cli.CLIOptsAndPropConsolidator;
import com.gtnexus.appxpress.cli.option.AppXpressOption;
import com.gtnexus.appxpress.cli.option.CLIOptionInterpreter;
import com.gtnexus.appxpress.cli.option.CLIOptionParser;
import com.gtnexus.appxpress.cli.option.ParsedOptions;
import com.gtnexus.appxpress.commons.AppXpressDirResolver;
import com.gtnexus.appxpress.commons.CommandInformation;
import com.gtnexus.appxpress.commons.DirectoryHelper;
import com.gtnexus.appxpress.commons.PMProperties;
import com.gtnexus.appxpress.commons.SimpleShutdown;
import com.gtnexus.appxpress.commons.SimpleShutdownImpl;
import com.gtnexus.appxpress.commons.exception.AppXpressException;

public class ContextFactory {

	private final AppXpressDirResolver resolver;
	private final InterpreterFactory interpreterFac;

	public ContextFactory() {
		this.resolver = new AppXpressDirResolver();
		this.interpreterFac = new InterpreterFactory(resolver);
	}

	public AppXpressContext createContext(
			CommandInformation app, String[] args) throws AppXpressException {
		DirectoryHelper dHelper = new DirectoryHelper(app.getCommandName()
				+ PROPERTIES_EXTENSION);
		dHelper.ensureAppXpress();
		PMProperties pmProperties = dHelper.getPmProperties();
		Class<M> contextType = app.getContextType();
		CLIOptionParser<M> parser = CLIOptionParser.createParser(
				app.getCommandName(), args, contextType);
		ParsedOptions parsedOptions = parser.parse();
		SimpleShutdown shutdown = new SimpleShutdownImpl();
		CLIOptionInterpreter<M> interpreter = interpreterFac.createInterpreter(
				app, shutdown, parsedOptions, pmProperties);
		Map<M, String> interpretedOptions = interpreter.interpret();
		CLIOptsAndPropConsolidator<M> consolidator = new CLIOptsAndPropConsolidator(
				interpretedOptions, parsedOptions.getCliOptionSet(),
				pmProperties);
		Map<M, String> optMap = consolidator.consolidate();
		return new AppXpressContext(app, shutdown,
				dHelper, parser.getOptions(), pmProperties, optMap);
	}

}