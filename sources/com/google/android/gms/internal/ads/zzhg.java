package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhg extends zzhh {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzhg(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzhf {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.zzd;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new zzhf(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        InputStream inputStream = this.zzc;
        String str = zzfl.zza;
        int i5 = inputStream.read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.zzd;
        if (j4 != -1) {
            this.zzd = j4 - ((long) i5);
        }
        zzh(i5);
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzhf {
        try {
            Uri uri = zzhtVar.zza;
            this.zzb = uri;
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            zzf(zzhtVar);
            InputStream inputStreamOpen = this.zza.open(path, 1);
            this.zzc = inputStreamOpen;
            long j3 = zzhtVar.zze;
            if (inputStreamOpen.skip(j3) < j3) {
                throw new zzhf(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long j4 = zzhtVar.zzf;
            if (j4 != -1) {
                this.zzd = j4;
            } else {
                long jAvailable = this.zzc.available();
                this.zzd = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.zzd = -1L;
                }
            }
            this.zze = true;
            zzg(zzhtVar);
            return this.zzd;
        } catch (zzhf e3) {
            throw e3;
        } catch (IOException e4) {
            throw new zzhf(e4, true != (e4 instanceof FileNotFoundException) ? AdError.SERVER_ERROR_CODE : 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzhf {
        this.zzb = null;
        try {
            try {
                InputStream inputStream = this.zzc;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.zzc = null;
                if (this.zze) {
                    this.zze = false;
                    zzi();
                }
            } catch (IOException e3) {
                throw new zzhf(e3, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzi();
            }
            throw th;
        }
    }
}
