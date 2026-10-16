package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbbq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbbs zzb;

    zzbbq(zzbbs zzbbsVar, int i3, boolean z2) {
        this.zza = i3;
        Objects.requireNonNull(zzbbsVar);
        this.zzb = zzbbsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaym zzaymVarZza;
        int i3 = this.zza;
        zzbbs zzbbsVar = this.zzb;
        if (i3 > 0) {
            try {
                Thread.sleep(i3 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzbbsVar.zza;
            zzaymVarZza = zzfxn.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzaymVarZza = null;
        }
        zzbbs zzbbsVar2 = this.zzb;
        zzbbsVar2.zzs(zzaymVarZza);
        int i4 = this.zza;
        if (i4 < 4) {
            if (zzaymVarZza != null && zzaymVarZza.zza() && !zzaymVarZza.zzb().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzaymVarZza.zzg() && zzaymVarZza.zzh().zza() && zzaymVarZza.zzh().zzb() != -2) {
                return;
            }
            zzbbsVar2.zzp(i4 + 1, true);
        }
    }
}
