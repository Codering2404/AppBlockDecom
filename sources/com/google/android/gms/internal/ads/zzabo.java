package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabo {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzabp zzabpVar) {
        zzb(zzabpVar);
        this.zza.add(new zzabn(handler, zzabpVar));
    }

    public final void zzb(zzabp zzabpVar) {
        CopyOnWriteArrayList<zzabn> copyOnWriteArrayList = this.zza;
        for (zzabn zzabnVar : copyOnWriteArrayList) {
            if (zzabnVar.zzc() == zzabpVar) {
                zzabnVar.zza();
                copyOnWriteArrayList.remove(zzabnVar);
            }
        }
    }

    public final void zzc(final int i3, final long j3, final long j4) {
        for (final zzabn zzabnVar : this.zza) {
            if (!zzabnVar.zzd()) {
                zzabnVar.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzabnVar.zzc().zzX(i3, j3, j4);
                    }
                });
            }
        }
    }
}
