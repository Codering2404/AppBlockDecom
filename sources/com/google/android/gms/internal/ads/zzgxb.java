package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgxb extends zzguk {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzgtk zzb;

    zzgxb(Iterator it, zzgtk zzgtkVar) {
        this.zza = it;
        this.zzb = zzgtkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguk
    protected final Object zza() {
        zzgtk zzgtkVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzgtkVar = this.zzb;
            next = it.next();
        } while (!zzgtkVar.zza(next));
        return next;
    }
}
