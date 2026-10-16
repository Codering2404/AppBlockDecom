package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadc {
    private final Context zza;
    private boolean zzb;
    private zzvv zzc = zzvv.zzb;
    private final zzvh zzd;
    private Handler zze;
    private zzaep zzf;

    public zzadc(Context context) {
        this.zza = context;
        this.zzd = new zzvb(context, null, null);
    }

    public final zzadc zza(zzvv zzvvVar) {
        this.zzc = zzvvVar;
        return this;
    }

    public final zzadc zzb(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzadc zzc(zzaep zzaepVar) {
        this.zzf = zzaepVar;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzade zzd() {
        /*
            r3 = this;
            boolean r0 = r3.zzb
            r1 = 1
            r0 = r0 ^ r1
            com.google.android.gms.internal.ads.zzgtj.zzi(r0)
            android.os.Handler r0 = r3.zze
            if (r0 != 0) goto L12
            com.google.android.gms.internal.ads.zzaep r2 = r3.zzf
            if (r2 == 0) goto L10
            goto L12
        L10:
            r2 = r1
            goto L1a
        L12:
            r2 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzaep r0 = r3.zzf
            if (r0 == 0) goto L1a
            goto L10
        L1a:
            com.google.android.gms.internal.ads.zzgtj.zzi(r2)
            r3.zzb = r1
            com.google.android.gms.internal.ads.zzade r0 = new com.google.android.gms.internal.ads.zzade
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadc.zzd():com.google.android.gms.internal.ads.zzade");
    }

    final /* synthetic */ Context zze() {
        return this.zza;
    }

    final /* synthetic */ zzvv zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzvh zzg() {
        return this.zzd;
    }

    final /* synthetic */ Handler zzh() {
        return this.zze;
    }

    final /* synthetic */ zzaep zzi() {
        return this.zzf;
    }
}
