package com.google.android.play.integrity.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            Bundle bundle = new Bundle();
            bundle.putInt("event_type", fVar.a());
            bundle.putLong("event_timestamp", fVar.b());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static final void b(int i3, List list) {
        list.add(f.c(i3, System.currentTimeMillis()));
    }
}
