package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhk extends zzhh {
    private final zzhj zza;
    private Uri zzb;
    private byte[] zzc;
    private int zzd;
    private int zze;
    private boolean zzf;

    public zzhk(final byte[] bArr) {
        zzhj zzhjVar = new zzhj() { // from class: com.google.android.gms.internal.ads.zzhi
            @Override // com.google.android.gms.internal.ads.zzhj
            public final /* synthetic */ byte[] zza(Uri uri) {
                return bArr;
            }
        };
        super(false);
        this.zza = zzhjVar;
        zzgtj.zza(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.zze;
        if (i5 == 0) {
            return -1;
        }
        int iMin = Math.min(i4, i5);
        byte[] bArr2 = this.zzc;
        bArr2.getClass();
        System.arraycopy(bArr2, this.zzd, bArr, i3, iMin);
        this.zzd += iMin;
        this.zze -= iMin;
        zzh(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws IOException {
        zzf(zzhtVar);
        Uri uri = zzhtVar.zza;
        this.zzb = uri;
        byte[] bArrZza = this.zza.zza(uri);
        this.zzc = bArrZza;
        long j3 = zzhtVar.zze;
        int length = bArrZza.length;
        if (j3 > length) {
            throw new zzhq(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i3 = (int) j3;
        this.zzd = i3;
        int i4 = length - i3;
        this.zze = i4;
        long j4 = zzhtVar.zzf;
        if (j4 != -1) {
            this.zze = (int) Math.min(i4, j4);
        }
        this.zzf = true;
        zzg(zzhtVar);
        return j4 != -1 ? j4 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
            zzi();
        }
        this.zzb = null;
        this.zzc = null;
    }
}
