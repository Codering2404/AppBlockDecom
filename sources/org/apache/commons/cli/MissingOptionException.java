package org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MissingOptionException extends ParseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f145211a;

    public MissingOptionException(String str) {
        super(str);
    }

    private static String a(List list) {
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        stringBuffer.append(list.size() == 1 ? "" : "s");
        stringBuffer.append(": ");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    public MissingOptionException(List list) {
        this(a(list));
        this.f145211a = list;
    }
}
