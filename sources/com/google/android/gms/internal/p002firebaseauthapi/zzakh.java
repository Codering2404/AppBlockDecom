package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzakh {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakl zzc;
    private int zze;
    private int zzf;

    public static int zza(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i3) throws zzall;

    public abstract int zzc();

    public abstract void zzc(int i3) throws zzall;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i3);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i3) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzajv zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public final void zzt() throws zzall {
        if (this.zza + this.zze >= this.zzf) {
            throw zzall.zzh();
        }
    }

    public final void zzu() throws zzall {
        if (this.zze == 0) {
            zzc(0);
        }
    }

    public final void zzv() throws IOException {
        int iZzi;
        do {
            iZzi = zzi();
            if (iZzi == 0) {
                return;
            }
            zzt();
            this.zze++;
            this.zze--;
        } while (zze(iZzi));
    }

    public abstract boolean zzw() throws IOException;

    public abstract boolean zzx() throws IOException;

    private zzakh() {
        this.zzf = zzd;
        this.zzb = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static long zza(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    static zzakh zza(byte[] bArr, int i3, int i4, boolean z2) {
        zzakk zzakkVar = new zzakk(bArr, i3, i4, z2);
        try {
            zzakkVar.zzb(i4);
            return zzakkVar;
        } catch (zzall e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
