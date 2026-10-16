package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbe {
    public static final Object zza = new Object();
    private static final zzak zzp;

    @Deprecated
    public Object zzc;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    public zzaf zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;
    public Object zzb = zza;
    public zzak zzd = zzp;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("androidx.media3.common.Timeline");
        zzzVar.zzb(Uri.EMPTY);
        zzp = zzzVar.zzc();
        String str = zzfl.zza;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbe.class.equals(obj.getClass())) {
            zzbe zzbeVar = (zzbe) obj;
            if (Objects.equals(this.zzb, zzbeVar.zzb) && Objects.equals(this.zzd, zzbeVar.zzd) && Objects.equals(this.zzj, zzbeVar.zzj) && this.zze == zzbeVar.zze && this.zzf == zzbeVar.zzf && this.zzg == zzbeVar.zzg && this.zzh == zzbeVar.zzh && this.zzi == zzbeVar.zzi && this.zzk == zzbeVar.zzk && this.zzm == zzbeVar.zzm && this.zzn == zzbeVar.zzn && this.zzo == zzbeVar.zzo) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zzb.hashCode() + 217) * 31) + this.zzd.hashCode();
        zzaf zzafVar = this.zzj;
        int iHashCode2 = ((iHashCode * 961) + (zzafVar == null ? 0 : zzafVar.hashCode())) * 31;
        long j3 = this.zze;
        int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.zzf;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.zzg;
        int i5 = ((((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
        long j6 = this.zzm;
        return ((((((i5 * 961) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzbe zza(Object obj, zzak zzakVar, Object obj2, long j3, long j4, long j5, boolean z2, boolean z3, zzaf zzafVar, long j6, long j7, int i3, int i4, long j8) {
        this.zzb = obj;
        if (zzakVar == null) {
            zzakVar = zzp;
        }
        this.zzd = zzakVar;
        this.zzc = null;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = zzafVar;
        this.zzl = 0L;
        this.zzm = j7;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        return this.zzj != null;
    }
}
