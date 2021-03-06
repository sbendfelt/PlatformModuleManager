package com.gtnexus.appxpress.cli.option;

import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.gtnexus.appxpress.exception.AppXpressException;
import com.gtnexus.appxpress.pmextractor.exception.PMExtractorException;

/**
 * Wrapper to tie together CLIOptions and the Apache Commons CLI library.
 * 
 * @author jdonovan
 *
 */
public class CLIOptionParser<T extends CLIOption> {

	private final String[] userArgs;
	private final Set<T> cliOptionSet;
	private final Options options;
	private CommandLine cmd;

	public static <M extends CLIOption> CLIOptionParser<M> createParser(Set<M> cliOptSet, String[] userArgs) {
		Options options = new Options();
		for (CLIOption opt : cliOptSet) {
			options.addOption(Option.builder(opt.getFlag())
					.longOpt(opt.getLongName()).type(opt.getType())
					.desc(opt.getDescription()).hasArg(opt.hasArg())
					.required(false).build());
		}
		return new CLIOptionParser<>(userArgs, cliOptSet, options);
	}

	/**
	 * 
	 * @param userArgs
	 *            the args provided to main() by the user when invoking this
	 *            tool
	 * @param cliOptionSet
	 *            the option set defining what can be passed to this tool
	 */
	public CLIOptionParser(String[] userArgs,
			Set<T> cliOptionSet, Options options) {
		if (userArgs == null || cliOptionSet == null) {
			throw new NullPointerException(
					"Cannot parse null args, or null option set.");
		}
		this.userArgs = userArgs;
		this.cliOptionSet = cliOptionSet;
		this.options = options;
	}

	/**
	 * Parses the args provided by the user according to the provided option
	 * set.
	 * 
	 * @throws PMExtractorException
	 *             if input is not parasable.
	 */
	public ParsedOptions<T> parse() throws AppXpressException {
		CommandLineParser parser = new DefaultParser();
		try {
			cmd = parser.parse(options, userArgs);
		} catch (ParseException e) {
			throw new PMExtractorException(
					"Failed to parse args from command line!\n"
							+ e.getMessage());
		}
		return ParsedOptions.createFrom(this);
	}
	
	public CommandLine getCommandLine() {
		return cmd;
	}

	public Set<T> getCliOptionSet() {
		return cliOptionSet;
	}

	public Options getOptions() {
		return options;
	}

}
