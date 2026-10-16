package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.revenuecat.purchases.common.Constants;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzil extends zzhh {
    private final Context zza;
    private zzht zzb;
    private AssetFileDescriptor zzc;
    private InputStream zzd;
    private long zze;
    private boolean zzf;

    public zzil(Context context) {
        super(false);
        this.zza = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 15);
        sb.append("rawresource:///");
        sb.append(i3);
        return Uri.parse(sb.toString());
    }

    private static AssetFileDescriptor zzk(Context context, zzht zzhtVar) throws zzik {
        Resources resourcesForApplication;
        int identifier;
        Uri uriNormalizeScheme = zzhtVar.zza.normalizeScheme();
        if (TextUtils.equals("rawresource", uriNormalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 61);
                sb.append("rawresource:// URI must have exactly one path element, found ");
                sb.append(size);
                throw new zzik(sb.toString());
            }
            identifier = zzl(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                String scheme = uriNormalizeScheme.getScheme();
                StringBuilder sb2 = new StringBuilder(String.valueOf(scheme).length() + 62);
                sb2.append("Unsupported URI scheme (");
                sb2.append(scheme);
                sb2.append("). Only android.resource is supported.");
                throw new zzik(sb2.toString(), null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e3) {
                    throw new zzik("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e3, 2005);
                }
            }
            if (path.matches("\\d+")) {
                identifier = zzl(path);
            } else {
                StringBuilder sb3 = new StringBuilder(packageName.length() + 1 + path.length());
                sb3.append(packageName);
                sb3.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb3.append(path);
                identifier = resourcesForApplication.getIdentifier(sb3.toString(), "raw", null);
                if (identifier == 0) {
                    throw new zzik("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new zzik("Resource is compressed: ".concat(String.valueOf(uriNormalizeScheme)), null, AdError.SERVER_ERROR_CODE);
        } catch (Resources.NotFoundException e4) {
            throw new zzik(null, e4, 2005);
        }
    }

    private static int zzl(String str) throws zzik {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new zzik("Resource identifier must be an integer.", null, 1004);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzik {
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
                throw new zzik(null, e3, AdError.SERVER_ERROR_CODE);
            }
        }
        InputStream inputStream = this.zzd;
        String str = zzfl.zza;
        int i5 = inputStream.read(bArr, i3, i4);
        if (i5 == -1) {
            if (this.zze == -1) {
                return -1;
            }
            throw new zzik("End of stream reached having not read sufficient data.", new EOFException(), AdError.SERVER_ERROR_CODE);
        }
        long j4 = this.zze;
        if (j4 != -1) {
            this.zze = j4 - ((long) i5);
        }
        zzh(i5);
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzik {
        long size;
        this.zzb = zzhtVar;
        zzf(zzhtVar);
        AssetFileDescriptor assetFileDescriptorZzk = zzk(this.zza, zzhtVar);
        this.zzc = assetFileDescriptorZzk;
        long length = assetFileDescriptorZzk.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.zzc.getFileDescriptor());
        this.zzd = fileInputStream;
        if (length != -1) {
            try {
                if (zzhtVar.zze > length) {
                    throw new zzik(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            } catch (zzik e3) {
                throw e3;
            } catch (IOException e4) {
                throw new zzik(null, e4, AdError.SERVER_ERROR_CODE);
            }
        }
        long startOffset = this.zzc.getStartOffset();
        long j3 = zzhtVar.zze;
        long jSkip = fileInputStream.skip(startOffset + j3) - startOffset;
        if (jSkip != j3) {
            throw new zzik(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.zze = -1L;
                size = -1;
            } else {
                size = channel.size() - channel.position();
                this.zze = size;
                if (size < 0) {
                    throw new zzik(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
        } else {
            size = length - jSkip;
            this.zze = size;
            if (size < 0) {
                throw new zzhq(AdError.REMOTE_ADS_SERVICE_ERROR);
            }
        }
        long j4 = zzhtVar.zzf;
        if (j4 != -1) {
            this.zze = size == -1 ? j4 : Math.min(size, j4);
        }
        this.zzf = true;
        zzg(zzhtVar);
        return j4 != -1 ? j4 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        zzht zzhtVar = this.zzb;
        if (zzhtVar != null) {
            return zzhtVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzik {
        this.zzb = null;
        try {
            try {
                try {
                    InputStream inputStream = this.zzd;
                    if (inputStream != null) {
                        inputStream.close();
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
                        throw new zzik(null, e3, AdError.SERVER_ERROR_CODE);
                    }
                } catch (IOException e4) {
                    throw new zzik(null, e4, AdError.SERVER_ERROR_CODE);
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
                    throw new zzik(null, e5, AdError.SERVER_ERROR_CODE);
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
