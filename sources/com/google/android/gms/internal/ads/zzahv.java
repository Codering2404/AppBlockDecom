package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzahv implements zzahq {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzahv(int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.zza = i3;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = i8;
        this.zzf = i9;
    }

    public static zzahv zzb(zzet zzetVar) {
        int iZzC = zzetVar.zzC();
        zzetVar.zzk(12);
        int iZzC2 = zzetVar.zzC();
        int iZzC3 = zzetVar.zzC();
        int iZzC4 = zzetVar.zzC();
        zzetVar.zzk(4);
        int iZzC5 = zzetVar.zzC();
        int iZzC6 = zzetVar.zzC();
        zzetVar.zzk(4);
        return new zzahv(iZzC, iZzC2, iZzC3, iZzC4, iZzC5, iZzC6, zzetVar.zzC());
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return 1752331379;
    }

    public final int zzc() {
        int i3 = this.zza;
        if (i3 == 1935960438) {
            return 2;
        }
        if (i3 == 1935963489) {
            return 1;
        }
        if (i3 == 1937012852) {
            return 3;
        }
        zzeg.zzc("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i3))));
        return -1;
    }

    public final long zzd() {
        return zzfl.zzv(this.zzd, ((long) this.zzb) * 1000000, this.zzc, RoundingMode.DOWN);
    }
}
