package com.google.android.libraries.places.internal;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzhu {
    public static String a(List list, List list2) {
        return c(list, true, list2);
    }

    public static String b(List list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add("attributions");
        return c(arrayList, false, new ArrayList());
    }

    private static String c(List list, boolean z2, List list2) {
        if (list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strConcat = (String) it.next();
            if (z2) {
                strConcat = "places.".concat(String.valueOf(strConcat));
            }
            arrayList.add(strConcat);
        }
        if (!list.contains("attributions")) {
            arrayList.add(true == z2 ? "places.attributions" : "attributions");
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(((zzht) it2.next()).toString());
        }
        return Joiner.i(",").e(arrayList);
    }
}
