package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzic extends zzhh {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzic() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzib {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.zzc;
        if (j3 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            String str = zzfl.zza;
            int i5 = randomAccessFile.read(bArr, i3, (int) Math.min(j3, i4));
            if (i5 > 0) {
                this.zzc -= (long) i5;
                zzh(i5);
            }
            return i5;
        } catch (IOException e3) {
            throw new zzib(e3, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzib {
        Uri uri = zzhtVar.zza;
        this.zzb = uri;
        zzf(zzhtVar);
        int i3 = AdError.INTERNAL_ERROR_2006;
        try {
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                long j3 = zzhtVar.zze;
                randomAccessFile.seek(j3);
                long length = zzhtVar.zzf;
                if (length == -1) {
                    length = this.zza.length() - j3;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzib(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
                this.zzd = true;
                zzg(zzhtVar);
                return this.zzc;
            } catch (IOException e3) {
                throw new zzib(e3, AdError.SERVER_ERROR_CODE);
            }
        } catch (FileNotFoundException e4) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzib(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e4, 1004);
            }
            if (!(e4.getCause() instanceof ErrnoException) || ((ErrnoException) e4.getCause()).errno != OsConstants.EACCES) {
                i3 = 2005;
            }
            throw new zzib(e4, i3);
        } catch (SecurityException e5) {
            throw new zzib(e5, AdError.INTERNAL_ERROR_2006);
        } catch (RuntimeException e6) {
            throw new zzib(e6, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzib {
        this.zzb = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.zza;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.zza = null;
                if (this.zzd) {
                    this.zzd = false;
                    zzi();
                }
            } catch (IOException e3) {
                throw new zzib(e3, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzi();
            }
            throw th;
        }
    }
}
