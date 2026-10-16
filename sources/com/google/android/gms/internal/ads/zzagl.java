package com.google.android.gms.internal.ads;

import java.nio.ByteOrder;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagl {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzagk zzk;
    private final zzap zzl;

    zzagl(int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, zzagk zzagkVar, zzap zzapVar) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = zzf(i7);
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = zzg(i9);
        this.zzj = j3;
        this.zzk = zzagkVar;
        this.zzl = zzapVar;
    }

    private static int zzf(int i3) {
        switch (i3) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static int zzg(int i3) {
        if (i3 == 8) {
            return 1;
        }
        if (i3 == 12) {
            return 2;
        }
        if (i3 == 16) {
            return 4;
        }
        if (i3 == 20) {
            return 5;
        }
        if (i3 != 24) {
            return i3 != 32 ? -1 : 7;
        }
        return 6;
    }

    public final long zza() {
        long j3 = this.zzj;
        if (j3 == 0) {
            return -9223372036854775807L;
        }
        return (j3 * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j3) {
        String str = zzfl.zza;
        return Math.max(0L, Math.min((j3 * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzv zzc(byte[] bArr, zzap zzapVar) {
        bArr[4] = -128;
        zzap zzapVarZzd = zzd(zzapVar);
        zzt zztVar = new zzt();
        zztVar.zzo("audio/flac");
        int i3 = this.zzd;
        if (i3 <= 0) {
            i3 = -1;
        }
        zztVar.zzp(i3);
        zztVar.zzG(this.zzg);
        zztVar.zzH(this.zze);
        zztVar.zzI(zzfl.zzB(this.zzh, ByteOrder.LITTLE_ENDIAN));
        zztVar.zzr(Collections.singletonList(bArr));
        zztVar.zzl(zzapVarZzd);
        return zztVar.zzO();
    }

    public final zzap zzd(zzap zzapVar) {
        zzap zzapVar2 = this.zzl;
        return zzapVar2 == null ? zzapVar : zzapVar2.zzf(zzapVar);
    }

    public final zzagl zze(zzagk zzagkVar) {
        return new zzagl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzagkVar, this.zzl);
    }

    public zzagl(byte[] bArr, int i3) {
        zzes zzesVar = new zzes(bArr, bArr.length);
        zzesVar.zzf(i3 * 8);
        this.zza = zzesVar.zzj(16);
        this.zzb = zzesVar.zzj(16);
        this.zzc = zzesVar.zzj(24);
        this.zzd = zzesVar.zzj(24);
        int iZzj = zzesVar.zzj(20);
        this.zze = iZzj;
        this.zzf = zzf(iZzj);
        this.zzg = zzesVar.zzj(3) + 1;
        int iZzj2 = zzesVar.zzj(5) + 1;
        this.zzh = iZzj2;
        this.zzi = zzg(iZzj2);
        this.zzj = zzesVar.zzk(36);
        this.zzk = null;
        this.zzl = null;
    }
}
