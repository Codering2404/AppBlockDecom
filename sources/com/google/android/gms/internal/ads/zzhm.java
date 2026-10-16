package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.ads.AdError;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhm extends zzhh {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzhm(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzhl {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.zze;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new zzhl(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        String str = zzfl.zza;
        int i5 = fileInputStream.read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.zze;
        if (j4 != -1) {
            this.zze = j4 - ((long) i5);
        }
        zzh(i5);
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzhl {
        int i3;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        long jPosition;
        try {
            try {
                Uri uriNormalizeScheme = zzhtVar.zza.normalizeScheme();
                this.zzb = uriNormalizeScheme;
                zzf(zzhtVar);
                if (Objects.equals(uriNormalizeScheme.getScheme(), AppLovinEventTypes.USER_VIEWED_CONTENT)) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.zzc = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    String strValueOf = String.valueOf(uriNormalizeScheme);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                    sb.append("Could not open file descriptor for: ");
                    sb.append(strValueOf);
                    IOException iOException = new IOException(sb.toString());
                    i3 = AdError.SERVER_ERROR_CODE;
                    try {
                        throw new zzhl(iOException, AdError.SERVER_ERROR_CODE);
                    } catch (IOException e3) {
                        e = e3;
                        throw new zzhl(e, true != (e instanceof FileNotFoundException) ? i3 : 2005);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.zzd = fileInputStream;
                if (length != -1 && zzhtVar.zze > length) {
                    throw new zzhl(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long j3 = zzhtVar.zze;
                long jSkip = fileInputStream.skip(startOffset + j3) - startOffset;
                if (jSkip != j3) {
                    throw new zzhl(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.zze = -1L;
                        jPosition = -1;
                    } else {
                        jPosition = size - channel.position();
                        this.zze = jPosition;
                        if (jPosition < 0) {
                            throw new zzhl(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                        }
                    }
                } else {
                    jPosition = length - jSkip;
                    this.zze = jPosition;
                    if (jPosition < 0) {
                        throw new zzhl(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
                long j4 = zzhtVar.zzf;
                if (j4 != -1) {
                    this.zze = jPosition == -1 ? j4 : Math.min(jPosition, j4);
                }
                this.zzf = true;
                zzg(zzhtVar);
                return j4 != -1 ? j4 : this.zze;
            } catch (zzhl e4) {
                throw e4;
            }
        } catch (IOException e5) {
            e = e5;
            i3 = AdError.SERVER_ERROR_CODE;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzhl {
        this.zzb = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = this.zzd;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzi();
                        }
                    } catch (IOException e3) {
                        throw new zzhl(e3, AdError.SERVER_ERROR_CODE);
                    }
                } catch (IOException e4) {
                    throw new zzhl(e4, AdError.SERVER_ERROR_CODE);
                }
            } catch (Throwable th) {
                this.zzd = null;
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.zzc = null;
                    if (this.zzf) {
                        this.zzf = false;
                        zzi();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new zzhl(e5, AdError.SERVER_ERROR_CODE);
                }
            }
        } catch (Throwable th2) {
            this.zzc = null;
            if (this.zzf) {
                this.zzf = false;
                zzi();
            }
            throw th2;
        }
    }
}
