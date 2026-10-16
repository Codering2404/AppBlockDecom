package com.facebook.stetho.dumpapp;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ArgsHelper {
    public static String[] drainToArray(Iterator<String> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String nextArg(Iterator<String> it, String str) throws DumpUsageException {
        if (it.hasNext()) {
            return it.next();
        }
        throw new DumpUsageException(str);
    }

    public static String nextOptionalArg(Iterator<String> it, String str) {
        return it.hasNext() ? it.next() : str;
    }
}
