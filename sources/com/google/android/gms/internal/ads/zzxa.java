package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxa implements zzhp {
    private final zzhp zza;
    private final int zzb;
    private final zzwz zzc;
    private final byte[] zzd;
    private int zze;

    public zzxa(zzhp zzhpVar, int i3, zzwz zzwzVar) {
        zzgtj.zza(i3 > 0);
        this.zza = zzhpVar;
        this.zzb = i3;
        this.zzc = zzwzVar;
        this.zzd = new byte[1];
        this.zze = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.zze;
        if (i5 == 0) {
            zzhp zzhpVar = this.zza;
            byte[] bArr2 = this.zzd;
            int i6 = 0;
            if (zzhpVar.zza(bArr2, 0, 1) != -1) {
                int i7 = (bArr2[0] & 255) << 4;
                if (i7 != 0) {
                    byte[] bArr3 = new byte[i7];
                    int i8 = i7;
                    while (i8 > 0) {
                        int iZza = zzhpVar.zza(bArr3, i6, i8);
                        if (iZza != -1) {
                            i6 += iZza;
                            i8 -= iZza;
                        }
                    }
                    while (i7 > 0) {
                        int i9 = i7 - 1;
                        if (bArr3[i9] != 0) {
                            break;
                        }
                        i7 = i9;
                    }
                    if (i7 > 0) {
                        this.zzc.zza(new zzet(bArr3, i7));
                    }
                }
                i5 = this.zzb;
                this.zze = i5;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i3, Math.min(i5, i4));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
        zzinVar.getClass();
        this.zza.zze(zzinVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        return this.zza.zzj();
    }
}
