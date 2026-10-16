package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzdip {
    protected final Map zza = new HashMap();

    protected zzdip(Set set) {
        zzr(set);
    }

    public final synchronized void zzp(zzdkq zzdkqVar) {
        zzq(zzdkqVar.zza, zzdkqVar.zzb);
    }

    public final synchronized void zzq(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzr(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzp((zzdkq) it.next());
        }
    }

    protected final synchronized void zzs(final zzdio zzdioVar) {
        for (Map.Entry entry : this.zza.entrySet()) {
            final Object key = entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdin
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    try {
                        zzdioVar.zza(key);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.l().zzh(th, "EventEmitter.notify");
                        com.google.android.gms.ads.internal.util.zze.l("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
