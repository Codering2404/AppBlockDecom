package org.apache.commons.cli;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AlreadySelectedException extends ParseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OptionGroup f145197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Option f145198b;

    public AlreadySelectedException(String str) {
        super(str);
    }

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(option.h());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(optionGroup.b());
        stringBuffer.append("'");
        this(stringBuffer.toString());
        this.f145197a = optionGroup;
        this.f145198b = option;
    }
}
