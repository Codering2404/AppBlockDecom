package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaro implements zzarn {
    private final zzagb zza;
    private final zzahk zzb;
    private final zzarr zzc;
    private final zzv zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaro(zzagb zzagbVar, zzahk zzahkVar, zzarr zzarrVar, String str, int i3) throws zzat {
        this.zza = zzagbVar;
        this.zzb = zzahkVar;
        this.zzc = zzarrVar;
        int i4 = zzarrVar.zzb * zzarrVar.zze;
        int i5 = zzarrVar.zzd;
        int i6 = i4 / 8;
        if (i5 != i6) {
            StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 28 + String.valueOf(i5).length());
            sb.append("Expected block size: ");
            sb.append(i6);
            sb.append("; got: ");
            sb.append(i5);
            throw zzat.zzb(sb.toString(), null);
        }
        int i7 = zzarrVar.zzc * i6;
        int i8 = i7 * 8;
        int iMax = Math.max(i6, i7 / 10);
        this.zze = iMax;
        zzt zztVar = new zzt();
        zztVar.zzn("audio/wav");
        zztVar.zzo(str);
        zztVar.zzi(i8);
        zztVar.zzj(i8);
        zztVar.zzp(iMax);
        zztVar.zzG(zzarrVar.zzb);
        zztVar.zzH(zzarrVar.zzc);
        zztVar.zzI(i3);
        this.zzd = zztVar.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zza(long j3) {
        this.zzf = j3;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zzb(int i3, long j3) {
        zzaru zzaruVar = new zzaru(this.zzc, 1, i3, j3);
        this.zza.zzw(zzaruVar);
        zzahk zzahkVar = this.zzb;
        zzahkVar.zzA(this.zzd);
        zzahkVar.zzO(zzaruVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final boolean zzc(zzafz zzafzVar, long j3) throws IOException {
        int i3;
        int i4;
        long j4 = j3;
        while (j4 > 0 && (i3 = this.zzg) < (i4 = this.zze)) {
            int iZza = this.zzb.zza(zzafzVar, (int) Math.min(i4 - i3, j4), true);
            if (iZza == -1) {
                j4 = 0;
            } else {
                this.zzg += iZza;
                j4 -= (long) iZza;
            }
        }
        zzarr zzarrVar = this.zzc;
        int i5 = this.zzg;
        int i6 = zzarrVar.zzd;
        int i7 = i5 / i6;
        if (i7 > 0) {
            long jZzv = this.zzf + zzfl.zzv(this.zzh, 1000000L, zzarrVar.zzc, RoundingMode.DOWN);
            int i8 = i7 * i6;
            int i9 = this.zzg - i8;
            this.zzb.zze(jZzv, 1, i8, i9, null);
            this.zzh += (long) i7;
            this.zzg = i9;
        }
        return j4 <= 0;
    }
}
