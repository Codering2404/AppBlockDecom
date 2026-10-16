package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcjq implements zzhp {
    private final zzhp zza;
    private final long zzb;
    private final zzhp zzc;
    private long zzd;
    private Uri zze;

    zzcjq(zzhp zzhpVar, int i3, zzhp zzhpVar2) {
        this.zza = zzhpVar;
        this.zzb = i3;
        this.zzc = zzhpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        long j3 = this.zzd;
        long j4 = this.zzb;
        if (j3 < j4) {
            int iZza = this.zza.zza(bArr, i3, (int) Math.min(i4, j4 - j3));
            long j5 = this.zzd + ((long) iZza);
            this.zzd = j5;
            i5 = iZza;
            j3 = j5;
        } else {
            i5 = 0;
        }
        if (j3 < j4) {
            return i5;
        }
        int iZza2 = this.zzc.zza(bArr, i3 + i5, i4 - i5);
        int i6 = i5 + iZza2;
        this.zzd += (long) iZza2;
        return i6;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws IOException {
        Uri uri;
        zzht zzhtVar2;
        Uri uri2 = zzhtVar.zza;
        this.zze = uri2;
        long j3 = zzhtVar.zze;
        long j4 = this.zzb;
        zzht zzhtVar3 = null;
        if (j3 >= j4) {
            uri = uri2;
            zzhtVar2 = null;
        } else {
            long j5 = zzhtVar.zzf;
            long jMin = j4 - j3;
            if (j5 != -1) {
                jMin = Math.min(j5, jMin);
            }
            uri = uri2;
            zzhtVar2 = new zzht(uri, j3, jMin, null);
        }
        long j6 = zzhtVar.zzf;
        if (j6 == -1 || j3 + j6 > j4) {
            zzhtVar3 = new zzht(uri, Math.max(j4, j3), j6 != -1 ? Math.min(j6, (j3 + j6) - j4) : -1L, null);
        }
        long jZzb = zzhtVar2 != null ? this.zza.zzb(zzhtVar2) : 0L;
        long jZzb2 = zzhtVar3 != null ? this.zzc.zzb(zzhtVar3) : 0L;
        this.zzd = j3;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        return zzgwp.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
    }
}
