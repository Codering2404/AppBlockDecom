package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzzy implements Comparator {
    static final /* synthetic */ zzzy zza = new zzzy();

    private /* synthetic */ zzzy() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzzx) Collections.max((List) obj)).compareTo((zzzx) Collections.max((List) obj2));
    }
}
