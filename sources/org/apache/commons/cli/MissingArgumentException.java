package org.apache.commons.cli;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MissingArgumentException extends ParseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Option f145210a;

    public MissingArgumentException(String str) {
        super(str);
    }

    public MissingArgumentException(Option option) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Missing argument for option: ");
        stringBuffer.append(option.h());
        this(stringBuffer.toString());
        this.f145210a = option;
    }
}
