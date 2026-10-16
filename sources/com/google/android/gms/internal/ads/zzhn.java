package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhn extends zzhh {
    private zzht zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzhn() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.zzd;
        if (i5 == 0) {
            return -1;
        }
        int iMin = Math.min(i4, i5);
        byte[] bArr2 = this.zzb;
        String str = zzfl.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i3, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzh(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws IOException {
        zzf(zzhtVar);
        this.zza = zzhtVar;
        Uri uriNormalizeScheme = zzhtVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzgtj.zzf("data".equals(scheme), "Unsupported scheme: %s", scheme);
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        String str = zzfl.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzat.zza("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str2, 0);
            } catch (IllegalArgumentException e3) {
                throw zzat.zza("Error while parsing Base64 encoded string: ".concat(String.valueOf(str2)), e3);
            }
        } else {
            this.zzb = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j3 = zzhtVar.zze;
        int length = this.zzb.length;
        if (j3 > length) {
            this.zzb = null;
            throw new zzhq(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i3 = (int) j3;
        this.zzc = i3;
        int i4 = length - i3;
        this.zzd = i4;
        long j4 = zzhtVar.zzf;
        if (j4 != -1) {
            this.zzd = (int) Math.min(i4, j4);
        }
        zzg(zzhtVar);
        return j4 != -1 ? j4 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        zzht zzhtVar = this.zza;
        if (zzhtVar != null) {
            return zzhtVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzi();
        }
        this.zza = null;
    }
}
