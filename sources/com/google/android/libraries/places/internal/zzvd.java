package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzvd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzuz f78675a = new zzvb();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzuy f78676b = new zzvc();

    public static zzuw a(Set set) {
        zzuw zzuwVar = new zzuw(f78675a, null);
        zzuwVar.a(f78676b);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzuwVar.b((zztv) it.next());
        }
        return zzuwVar;
    }
}
