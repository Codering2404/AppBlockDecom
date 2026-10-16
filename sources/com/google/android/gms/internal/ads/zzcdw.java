package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdw implements zzbeq {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzcdw(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final void zza(boolean z2) {
        zzcdz zzcdzVarD = com.google.android.gms.ads.internal.zzt.d();
        Context context = this.zza;
        if (zzcdzVarD.zza(context)) {
            synchronized (this.zzb) {
                try {
                    if (this.zzd == z2) {
                        return;
                    }
                    this.zzd = z2;
                    String str = this.zzc;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (this.zzd) {
                        com.google.android.gms.ads.internal.zzt.d().zzd(context, str);
                    } else {
                        com.google.android.gms.ads.internal.zzt.d().zze(context, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        zza(zzbepVar.zzj);
    }
}
