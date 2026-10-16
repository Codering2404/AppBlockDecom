package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaku implements zzakt {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzaku(long[] jArr, long[] jArr2, long j3, long j4, long j5, int i3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j3;
        this.zzd = j5;
        this.zze = i3;
    }

    public static zzaku zze(long j3, long j4, zzagv zzagvVar, zzet zzetVar) {
        int iZzs;
        zzet zzetVar2 = zzetVar;
        zzetVar2.zzk(6);
        int iZzB = zzetVar2.zzB();
        long j5 = zzagvVar.zzc;
        long j6 = iZzB;
        if (zzetVar2.zzB() <= 0) {
            return null;
        }
        long jZzt = zzfl.zzt((((long) r4) * ((long) zzagvVar.zzg)) - 1, zzagvVar.zzd);
        int iZzt = zzetVar2.zzt();
        int iZzt2 = zzetVar2.zzt();
        int iZzt3 = zzetVar2.zzt();
        zzetVar2.zzk(2);
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        int i3 = 0;
        long j7 = j4 + ((long) zzagvVar.zzc);
        while (i3 < iZzt) {
            long j8 = j5;
            jArr[i3] = (((long) i3) * jZzt) / ((long) iZzt);
            jArr2[i3] = j7;
            if (iZzt3 == 1) {
                iZzs = zzetVar2.zzs();
            } else if (iZzt3 == 2) {
                iZzs = zzetVar2.zzt();
            } else if (iZzt3 == 3) {
                iZzs = zzetVar2.zzx();
            } else {
                if (iZzt3 != 4) {
                    return null;
                }
                iZzs = zzetVar2.zzH();
            }
            j7 += ((long) iZzs) * ((long) iZzt2);
            i3++;
            zzetVar2 = zzetVar;
            iZzt = iZzt;
            j5 = j8;
        }
        long j9 = j4 + j5;
        long jMax = j9 + j6;
        if (j3 != -1 && j3 != jMax) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 27 + String.valueOf(jMax).length());
            sb.append("VBRI data size mismatch: ");
            sb.append(j3);
            sb.append(", ");
            sb.append(jMax);
            zzeg.zzc("VbriSeeker", sb.toString());
        }
        if (jMax != j7) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(jMax).length() + 43 + String.valueOf(j7).length() + 28);
            sb2.append("VBRI bytes and ToC mismatch (using max): ");
            sb2.append(jMax);
            sb2.append(", ");
            sb2.append(j7);
            sb2.append("\nSeeking will be inaccurate.");
            zzeg.zzc("VbriSeeker", sb2.toString());
            jMax = Math.max(jMax, j7);
        }
        return new zzaku(jArr, jArr2, jZzt, j9, jMax, zzagvVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        long[] jArr = this.zza;
        int iZzo = zzfl.zzo(jArr, j3, true, true);
        long j4 = jArr[iZzo];
        long[] jArr2 = this.zzb;
        zzahc zzahcVar = new zzahc(j4, jArr2[iZzo]);
        if (zzahcVar.zzb >= j3 || iZzo == jArr.length - 1) {
            return new zzagz(zzahcVar, zzahcVar);
        }
        int i3 = iZzo + 1;
        return new zzagz(zzahcVar, new zzahc(jArr[i3], jArr2[i3]));
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j3) {
        return this.zza[zzfl.zzo(this.zzb, j3, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zze;
    }
}
