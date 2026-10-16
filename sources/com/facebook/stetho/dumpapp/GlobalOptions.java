package com.facebook.stetho.dumpapp;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GlobalOptions {
    public final Option optionHelp;
    public final Option optionListPlugins;
    public final Option optionProcess;
    public final Options options;

    public GlobalOptions() {
        Option option = new Option("h", "help", false, "Print this help");
        this.optionHelp = option;
        Option option2 = new Option("l", "list", false, "List available plugins");
        this.optionListPlugins = option2;
        Option option3 = new Option("p", "process", true, "Specify target process");
        this.optionProcess = option3;
        Options options = new Options();
        this.options = options;
        options.a(option);
        options.a(option2);
        options.a(option3);
    }
}
