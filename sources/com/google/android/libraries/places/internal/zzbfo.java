package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfo extends zzbfs {
    zzbfo() {
        super(null);
    }

    @Override // com.google.android.libraries.places.internal.zzbfs
    public final void a() {
        if (!b()) {
            for (int i3 = 0; i3 < c(); i3++) {
                ((zzbdf) ((zzbfp) d(i3)).a()).zzd();
            }
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((zzbdf) ((Map.Entry) it.next()).getKey()).zzd();
            }
        }
        super.a();
    }
}
