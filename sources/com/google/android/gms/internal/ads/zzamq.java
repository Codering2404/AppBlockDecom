package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamq extends zzamz {
    private zzagl zza;
    private zzamp zzb;

    zzamq() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zza(boolean z2) {
        super.zza(z2);
        if (z2) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final long zzb(zzet zzetVar) {
        if (!zzd(zzetVar.zzi())) {
            return -1L;
        }
        int i3 = (zzetVar.zzi()[2] & 255) >> 4;
        if (i3 == 6) {
            zzetVar.zzk(4);
            zzetVar.zzO();
        } else if (i3 == 7) {
            i3 = 7;
            zzetVar.zzk(4);
            zzetVar.zzO();
        }
        int iZzc = zzagg.zzc(zzetVar, i3);
        zzetVar.zzh(0);
        return iZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    @EnsuresNonNullIf
    protected final boolean zzc(zzet zzetVar, long j3, zzamx zzamxVar) {
        byte[] bArrZzi = zzetVar.zzi();
        zzagl zzaglVar = this.zza;
        if (zzaglVar == null) {
            zzagl zzaglVar2 = new zzagl(bArrZzi, 17);
            this.zza = zzaglVar2;
            zzt zztVarZza = zzaglVar2.zzc(Arrays.copyOfRange(bArrZzi, 9, zzetVar.zze()), null).zza();
            zztVarZza.zzn("audio/ogg");
            zzamxVar.zza = zztVarZza.zzO();
            return true;
        }
        if ((bArrZzi[0] & Ascii.DEL) == 3) {
            zzagk zzagkVarZzc = zzagi.zzc(zzetVar);
            zzagl zzaglVarZze = zzaglVar.zze(zzagkVarZzc);
            this.zza = zzaglVarZze;
            this.zzb = new zzamp(zzaglVarZze, zzagkVarZzc);
            return true;
        }
        if (!zzd(bArrZzi)) {
            return true;
        }
        zzamp zzampVar = this.zzb;
        if (zzampVar != null) {
            zzampVar.zzd(j3);
            zzamxVar.zzb = this.zzb;
        }
        zzamxVar.zza.getClass();
        return false;
    }
}
