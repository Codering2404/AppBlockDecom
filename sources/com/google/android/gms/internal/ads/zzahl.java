package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahl {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzb(zzafz zzafzVar) throws IOException {
        if (this.zzb) {
            return;
        }
        byte[] bArr = this.zza;
        zzafzVar.zzi(bArr, 0, 10);
        zzafzVar.zzl();
        int i3 = zzaey.zza;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }

    public final void zzc(zzahk zzahkVar, long j3, int i3, int i4, int i5, zzahj zzahjVar) {
        zzgtj.zzj(this.zzg <= i4 + i5, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.zzb) {
            int i6 = this.zzc;
            int i7 = i6 + 1;
            this.zzc = i7;
            if (i6 == 0) {
                this.zzd = j3;
                this.zze = i3;
                this.zzf = 0;
            }
            this.zzf += i4;
            this.zzg = i5;
            if (i7 >= 16) {
                zzd(zzahkVar, zzahjVar);
            }
        }
    }

    public final void zzd(zzahk zzahkVar, zzahj zzahjVar) {
        if (this.zzc > 0) {
            zzahkVar.zze(this.zzd, this.zze, this.zzf, this.zzg, zzahjVar);
            this.zzc = 0;
        }
    }
}
