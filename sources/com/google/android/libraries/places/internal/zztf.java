package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zztf extends zztv {
    zztf(String str, Class cls, boolean z2) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.libraries.places.internal.zztv
    public final void a(Iterator it, zztu zztuVar) {
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                zztuVar.a(d(), next);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(next);
            do {
                sb.append(',');
                sb.append(it.next());
            } while (it.hasNext());
            String strD = d();
            sb.append(']');
            zztuVar.a(strD, sb.toString());
        }
    }
}
