package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final CommandLineParser mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new GnuParser());
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) throws DumpException, ParseException {
        CommandLine commandLineA = this.mParser.a(this.mGlobalOptions.options, strArr, true);
        if (commandLineA.d(this.mGlobalOptions.optionHelp.j())) {
            dumpUsage(printStream);
            return 0;
        }
        if (commandLineA.d(this.mGlobalOptions.optionListPlugins.j())) {
            dumpAvailablePlugins(printStream);
            return 0;
        }
        if (commandLineA.c().isEmpty()) {
            dumpUsage(printStream2);
            return 1;
        }
        dumpPluginOutput(inputStream, printStream, printStream2, commandLineA);
        return 0;
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        ArrayList arrayList = new ArrayList();
        Iterator<DumperPlugin> it = this.mDumperPlugins.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            printStream.println((String) obj);
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, CommandLine commandLine) throws DumpException {
        ArrayList arrayList = new ArrayList(commandLine.c());
        if (arrayList.size() < 1) {
            throw new DumpException("Expected plugin argument");
        }
        String str = (String) arrayList.remove(0);
        DumperPlugin dumperPlugin = this.mDumperPlugins.get(str);
        if (dumperPlugin != null) {
            dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
            return;
        }
        throw new DumpException("No plugin named '" + str + "'");
    }

    private void dumpUsage(PrintStream printStream) {
        HelpFormatter helpFormatter = new HelpFormatter();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            helpFormatter.g(printWriter, helpFormatter.f(), this.mGlobalOptions.options, helpFormatter.d(), helpFormatter.c());
        } finally {
            printWriter.flush();
        }
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        HashMap map = new HashMap();
        for (DumperPlugin dumperPlugin : iterable) {
            map.put(dumperPlugin.getName(), dumperPlugin);
        }
        return Collections.unmodifiableMap(map);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        try {
            return doDump(inputStream, printStream, printStream2, strArr);
        } catch (DumpException e3) {
            printStream2.println(e3.getMessage());
            return 1;
        } catch (DumpappOutputBrokenException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e5.printStackTrace(printStream2);
            return 1;
        } catch (ParseException e6) {
            printStream2.println(e6.getMessage());
            dumpUsage(printStream2);
            return 1;
        }
    }

    public Dumper(Iterable<DumperPlugin> iterable, CommandLineParser commandLineParser) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = commandLineParser;
        this.mGlobalOptions = new GlobalOptions();
    }
}
