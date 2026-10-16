package com.google.android.gms.internal.ads;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzarm implements zzarn {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzagb zzc;
    private final zzahk zzd;
    private final zzarr zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzet zzh;
    private final int zzi;
    private final zzv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzarm(zzagb zzagbVar, zzahk zzahkVar, zzarr zzarrVar) throws zzat {
        this.zzc = zzagbVar;
        this.zzd = zzahkVar;
        this.zze = zzarrVar;
        int iMax = Math.max(1, zzarrVar.zzc / 10);
        this.zzi = iMax;
        zzet zzetVar = new zzet(zzarrVar.zzf);
        zzetVar.zzu();
        int iZzu = zzetVar.zzu();
        this.zzf = iZzu;
        int i3 = zzarrVar.zzb;
        int i4 = zzarrVar.zzd;
        int i5 = (((i4 - (i3 * 4)) * 8) / (zzarrVar.zze * i3)) + 1;
        if (iZzu != i5) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 34 + String.valueOf(iZzu).length());
            sb.append("Expected frames per block: ");
            sb.append(i5);
            sb.append("; got: ");
            sb.append(iZzu);
            throw zzat.zzb(sb.toString(), null);
        }
        String str = zzfl.zza;
        int i6 = ((iMax + iZzu) - 1) / iZzu;
        this.zzg = new byte[i4 * i6];
        this.zzh = new zzet(i6 * (iZzu + iZzu) * i3);
        int i7 = ((zzarrVar.zzc * zzarrVar.zzd) * 8) / iZzu;
        zzt zztVar = new zzt();
        zztVar.zzo("audio/raw");
        zztVar.zzi(i7);
        zztVar.zzj(i7);
        zztVar.zzp((iMax + iMax) * i3);
        zztVar.zzG(zzarrVar.zzb);
        zztVar.zzH(zzarrVar.zzc);
        zztVar.zzI(2);
        this.zzj = zztVar.zzO();
    }

    private final void zzd(int i3) {
        long jZzv = this.zzl + zzfl.zzv(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZzf = zzf(i3);
        this.zzd.zze(jZzv, 1, iZzf, this.zzm - iZzf, null);
        this.zzn += (long) i3;
        this.zzm -= iZzf;
    }

    private final int zze(int i3) {
        int i4 = this.zze.zzb;
        return i3 / (i4 + i4);
    }

    private final int zzf(int i3) {
        return (i3 + i3) * this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zza(long j3) {
        this.zzk = 0;
        this.zzl = j3;
        this.zzm = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zzb(int i3, long j3) {
        zzaru zzaruVar = new zzaru(this.zze, this.zzf, i3, j3);
        this.zzc.zzw(zzaruVar);
        zzahk zzahkVar = this.zzd;
        zzahkVar.zzA(this.zzj);
        zzahkVar.zzO(zzaruVar.zza());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzarn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzafz r26, long r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarm.zzc(com.google.android.gms.internal.ads.zzafz, long):boolean");
    }
}
