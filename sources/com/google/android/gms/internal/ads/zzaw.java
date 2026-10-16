package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaw {
    private final zzr zza = new zzr();

    public final zzaw zza(int i3) {
        this.zza.zza(i3);
        return this;
    }

    public final zzaw zzb(int i3, boolean z2) {
        if (z2) {
            this.zza.zza(i3);
        }
        return this;
    }

    public final zzaw zzc(int... iArr) {
        for (int i3 = 0; i3 < 20; i3++) {
            this.zza.zza(iArr[i3]);
        }
        return this;
    }

    public final zzaw zzd(zzax zzaxVar) {
        zzs zzsVarZza = zzaxVar.zza();
        for (int i3 = 0; i3 < zzsVarZza.zzb(); i3++) {
            this.zza.zza(zzsVarZza.zzc(i3));
        }
        return this;
    }

    public final zzax zze() {
        return new zzax(this.zza.zzb(), null);
    }
}
