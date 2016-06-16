package com.gtnexus.appxpress.cli.option;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.commons.cli.HelpFormatter;

import com.gtnexus.appxpress.cli.CLIOptsAndPropConsolidator;
import com.gtnexus.appxpress.commons.CommandInformation;
import com.gtnexus.appxpress.commons.PMProperties;
import com.gtnexus.appxpress.commons.SimpleShutdown;
import com.gtnexus.appxpress.commons.exception.AppXpressException;

public abstract class AppXpressOptionInterpreter<T extends AppXpressOption>
		implements CLIOptionInterpreter<AppXpressOption> {

	private ParsedOptions parsedOptions;
	private final CommandInformation app;
	protected final SimpleShutdown shutdown;
	protected final PMProperties properties;

	public AppXpressOptionInterpreter(CommandInformation app,
			SimpleShutdown shutdown, ParsedOptions parsedOptions,
			PMProperties properties) {
		this.app = app;
		this.shutdown = shutdown;
		this.parsedOptions = parsedOptions;
		this.properties = properties;
	}

	@Override
	public final Map<AppXpressOption, String> interpret() throws AppXpressException {
		if (parsedOptions.isHelpFlagSet()) {
			HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp(app.getCommandName(), app.getHelpHeader(),
					parsedOptions.getOptions(), app.getHelpFooter());
			shutdown.shutdown();
		}
		parsedOptions = performCustomInterpretation(parsedOptions);
		CLIOptsAndPropConsolidator consolidator = new CLIOptsAndPropConsolidator(
				parsedOptions.getOptionsMap(), parsedOptions.getCliOptionSet(),
				properties);
		Map<AppXpressOption, String> optMap = consolidator.consolidate();
		return optMap;
	}

	protected boolean isCustomerFolder(Path dir, T localDirKey)
			throws AppXpressException {
		final String localDir = resolveLocalDir(localDirKey);
		if (localDir == null || localDir.isEmpty()) {
			throw new AppXpressException(
					"Local Directory property is not set. "
							+ "Please check your AppXpress properties file"
							+ "before trying to run the Select option again.");
		}
		Path parent = dir.getParent();
		Path ld = Paths.get(localDir);
		if (parent.equals(ld)) {
			return true;
		}
		return false;
	}

	private String resolveLocalDir(T localDirKey) {
		if (parsedOptions.hasOption(localDirKey)) {
			return parsedOptions.getOption(localDirKey);
		} 
		return properties.getProperty(localDirKey);
	}

	public abstract ParsedOptions performCustomInterpretation(
			ParsedOptions parsedOpts) throws AppXpressException;

}