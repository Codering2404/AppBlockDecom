package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzym {
    private static final zzxf zzb = zzxf.zza;
    protected volatile zzzg zza;
    private volatile zzud zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzym)) {
            return false;
        }
        zzym zzymVar = (zzym) obj;
        zzzg zzzgVar = this.zza;
        zzzg zzzgVar2 = zzymVar.zza;
        if (zzzgVar == null && zzzgVar2 == null) {
            return zzb().equals(zzymVar.zzb());
        }
        if (zzzgVar != null && zzzgVar2 != null) {
            return zzzgVar.equals(zzzgVar2);
        }
        if (zzzgVar != null) {
            zzymVar.zzd(zzzgVar.zzax());
            return zzzgVar.equals(zzymVar.zza);
        }
        zzd(zzzgVar2.zzax());
        return this.zza.equals(zzzgVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzua) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzX();
        }
        return 0;
    }

    public final zzud zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            try {
                if (this.zzc != null) {
                    return this.zzc;
                }
                if (this.zza == null) {
                    this.zzc = zzud.zzb;
                } else {
                    this.zzc = this.zza.zzR();
                }
                return this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzzg zzc(zzzg zzzgVar) {
        zzzg zzzgVar2 = this.zza;
        this.zzc = null;
        this.zza = zzzgVar;
        return zzzgVar2;
    }

    protected final void zzd(zzzg zzzgVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzzgVar;
                    this.zzc = zzud.zzb;
                } catch (zzyg unused) {
                    this.zza = zzzgVar;
                    this.zzc = zzud.zzb;
                }
            }
        }
    }
}
