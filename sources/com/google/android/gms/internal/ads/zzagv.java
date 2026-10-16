package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagv {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzagv() {
    }

    public final boolean zza(int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (!zzagw.zzl(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
            return false;
        }
        int i8 = i6 - 1;
        this.zza = i4;
        this.zzb = zzagw.zza[3 - i5];
        int i9 = zzagw.zzb[i7];
        this.zzd = i9;
        if (i4 == 2) {
            i9 /= 2;
            this.zzd = i9;
        } else if (i4 == 0) {
            i9 /= 4;
            this.zzd = i9;
        }
        int i10 = (i3 >>> 9) & 1;
        this.zzg = zzagw.zzm(i4, i5);
        if (i5 == 3) {
            int i11 = i4 == 3 ? zzagw.zzc[i8] : zzagw.zzd[i8];
            this.zzf = i11;
            this.zzc = (((i11 * 12) / i9) + i10) * 4;
        } else {
            if (i4 == 3) {
                int i12 = i5 == 2 ? zzagw.zze[i8] : zzagw.zzf[i8];
                this.zzf = i12;
                this.zzc = ((i12 * 144) / i9) + i10;
            } else {
                int i13 = zzagw.zzg[i8];
                this.zzf = i13;
                this.zzc = (((i5 == 1 ? 72 : 144) * i13) / i9) + i10;
            }
        }
        this.zze = ((i3 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }

    public zzagv(zzagv zzagvVar) {
        this.zza = zzagvVar.zza;
        this.zzb = zzagvVar.zzb;
        this.zzc = zzagvVar.zzc;
        this.zzd = zzagvVar.zzd;
        this.zze = zzagvVar.zze;
        this.zzf = zzagvVar.zzf;
        this.zzg = zzagvVar.zzg;
    }
}
