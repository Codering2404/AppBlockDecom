package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcpi {
    private zzcnl zza;
    private zzcqf zzb;
    private zzfpo zzc;
    private zzcqt zzd;
    private zzfmb zze;

    private zzcpi() {
        throw null;
    }

    public final zzcpi zza(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
        return this;
    }

    public final zzcpi zzb(zzcqf zzcqfVar) {
        this.zzb = zzcqfVar;
        return this;
    }

    public final zzcnj zzc() {
        zzinc.zzc(this.zza, zzcnl.class);
        zzinc.zzc(this.zzb, zzcqf.class);
        if (this.zzc == null) {
            this.zzc = new zzfpo();
        }
        if (this.zzd == null) {
            this.zzd = new zzcqt();
        }
        if (this.zze == null) {
            this.zze = new zzfmb();
        }
        return new zzcox(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    /* synthetic */ zzcpi(byte[] bArr) {
    }
}
