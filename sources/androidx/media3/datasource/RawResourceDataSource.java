package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import com.revenuecat.purchases.common.Constants;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RawResourceDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f41976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DataSpec f41977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f41978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private InputStream f41979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f41980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f41981j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RawResourceDataSourceException extends DataSourceException {
        public RawResourceDataSourceException(String str) {
            super(str, null, AdError.SERVER_ERROR_CODE);
        }

        public RawResourceDataSourceException(String str, Throwable th, int i3) {
            super(str, th, i3);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f41976e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i3) {
        return Uri.parse("rawresource:///" + i3);
    }

    private static AssetFileDescriptor r(Context context, DataSpec dataSpec) throws RawResourceDataSourceException {
        Resources resourcesForApplication;
        int identifier;
        Uri uriNormalizeScheme = dataSpec.f41829a.normalizeScheme();
        if (TextUtils.equals("rawresource", uriNormalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new RawResourceDataSourceException("rawresource:// URI must have exactly one path element, found " + pathSegments.size());
            }
            identifier = s(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new RawResourceDataSourceException("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String strSubstring = (String) Assertions.e(uriNormalizeScheme.getPath());
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e3) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e3, 2005);
                }
            }
            if (strSubstring.matches("\\d+")) {
                identifier = s(strSubstring);
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strSubstring, "raw", null);
                if (identifier == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + uriNormalizeScheme, null, AdError.SERVER_ERROR_CODE);
        } catch (Resources.NotFoundException e4) {
            throw new RawResourceDataSourceException(null, e4, 2005);
        }
    }

    private static int s(String str) throws RawResourceDataSourceException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws RawResourceDataSourceException {
        this.f41977f = dataSpec;
        p(dataSpec);
        AssetFileDescriptor assetFileDescriptorR = r(this.f41976e, dataSpec);
        this.f41978g = assetFileDescriptorR;
        long length = assetFileDescriptorR.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f41978g.getFileDescriptor());
        this.f41979h = fileInputStream;
        if (length != -1) {
            try {
                if (dataSpec.f41835g > length) {
                    throw new RawResourceDataSourceException(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            } catch (RawResourceDataSourceException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(null, e4, AdError.SERVER_ERROR_CODE);
            }
        }
        long startOffset = this.f41978g.getStartOffset();
        long jSkip = fileInputStream.skip(dataSpec.f41835g + startOffset) - startOffset;
        if (jSkip != dataSpec.f41835g) {
            throw new RawResourceDataSourceException(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.f41980i = -1L;
            } else {
                long size = channel.size() - channel.position();
                this.f41980i = size;
                if (size < 0) {
                    throw new RawResourceDataSourceException(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
        } else {
            long j3 = length - jSkip;
            this.f41980i = j3;
            if (j3 < 0) {
                throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
            }
        }
        long jMin = dataSpec.f41836h;
        if (jMin != -1) {
            long j4 = this.f41980i;
            if (j4 != -1) {
                jMin = Math.min(j4, jMin);
            }
            this.f41980i = jMin;
        }
        this.f41981j = true;
        q(dataSpec);
        long j5 = dataSpec.f41836h;
        return j5 != -1 ? j5 : this.f41980i;
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41977f = null;
        try {
            try {
                InputStream inputStream = this.f41979h;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f41979h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f41978g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e3) {
                        throw new RawResourceDataSourceException(null, e3, AdError.SERVER_ERROR_CODE);
                    }
                } finally {
                    this.f41978g = null;
                    if (this.f41981j) {
                        this.f41981j = false;
                        o();
                    }
                }
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(null, e4, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.f41979h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f41978g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f41978g = null;
                    if (this.f41981j) {
                        this.f41981j = false;
                        o();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new RawResourceDataSourceException(null, e5, AdError.SERVER_ERROR_CODE);
                }
            } finally {
                this.f41978g = null;
                if (this.f41981j) {
                    this.f41981j = false;
                    o();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        DataSpec dataSpec = this.f41977f;
        if (dataSpec != null) {
            return dataSpec.f41829a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws RawResourceDataSourceException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41980i;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new RawResourceDataSourceException(null, e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((InputStream) Util.k(this.f41979h)).read(bArr, i3, i4);
        if (i5 == -1) {
            if (this.f41980i == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), AdError.SERVER_ERROR_CODE);
        }
        long j4 = this.f41980i;
        if (j4 != -1) {
            this.f41980i = j4 - ((long) i5);
        }
        n(i5);
        return i5;
    }
}
