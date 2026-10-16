package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfvq implements zzfvj {
    private static zzfvq zza;
    private float zzb = 0.0f;
    private zzfve zzc;
    private zzfvi zzd;

    public zzfvq(zzfvf zzfvfVar, zzfvb zzfvbVar) {
    }

    public static zzfvq zza() {
        if (zza == null) {
            zza = new zzfvq(new zzfvf(), new zzfvb());
        }
        return zza;
    }

    public final void zzb(Context context) {
        this.zzc = new zzfve(new Handler(), context, new zzfva(), this);
    }

    public final void zzc() {
        zzfvh.zza().zzg(this);
        zzfvh.zza().zze();
        zzfws.zzb().zzc();
        this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final void zzd(boolean z2) {
        if (z2) {
            zzfws.zzb().zzc();
        } else {
            zzfws.zzb().zze();
        }
    }

    public final void zze() {
        zzfws.zzb().zzd();
        zzfvh.zza().zzf();
        this.zzc.zzb();
    }

    public final void zzf(float f3) {
        this.zzb = f3;
        if (this.zzd == null) {
            this.zzd = zzfvi.zza();
        }
        Iterator it = this.zzd.zzf().iterator();
        while (it.hasNext()) {
            ((zzfuo) it.next()).zzg().zzo(f3);
        }
    }

    public final float zzg() {
        return this.zzb;
    }
}
