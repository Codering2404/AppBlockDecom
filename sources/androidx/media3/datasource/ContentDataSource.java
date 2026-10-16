package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Util;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.ads.AdError;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ContentDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f41807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f41808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f41809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileInputStream f41810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f41811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f41812j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ContentDataSourceException extends DataSourceException {
        public ContentDataSourceException(IOException iOException, int i3) {
            super(iOException, i3);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f41807e = context.getContentResolver();
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        int i3 = AdError.SERVER_ERROR_CODE;
        try {
            Uri uriNormalizeScheme = dataSpec.f41829a.normalizeScheme();
            this.f41808f = uriNormalizeScheme;
            p(dataSpec);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(uriNormalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f41807e.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f41807e.openAssetFileDescriptor(uriNormalizeScheme, "r");
            }
            this.f41809g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), AdError.SERVER_ERROR_CODE);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f41810h = fileInputStream;
            if (length != -1 && dataSpec.f41835g > length) {
                throw new ContentDataSourceException(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(dataSpec.f41835g + startOffset) - startOffset;
            if (jSkip != dataSpec.f41835g) {
                throw new ContentDataSourceException(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f41811i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f41811i = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j3 = length - jSkip;
                this.f41811i = j3;
                if (j3 < 0) {
                    throw new ContentDataSourceException(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            long jMin = dataSpec.f41836h;
            if (jMin != -1) {
                long j4 = this.f41811i;
                if (j4 != -1) {
                    jMin = Math.min(j4, jMin);
                }
                this.f41811i = jMin;
            }
            this.f41812j = true;
            q(dataSpec);
            long j5 = dataSpec.f41836h;
            return j5 != -1 ? j5 : this.f41811i;
        } catch (ContentDataSourceException e3) {
            throw e3;
        } catch (IOException e4) {
            if (e4 instanceof FileNotFoundException) {
                i3 = 2005;
            }
            throw new ContentDataSourceException(e4, i3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41808f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f41810h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f41810h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f41809g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e3) {
                        throw new ContentDataSourceException(e3, AdError.SERVER_ERROR_CODE);
                    }
                } finally {
                    this.f41809g = null;
                    if (this.f41812j) {
                        this.f41812j = false;
                        o();
                    }
                }
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.f41810h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f41809g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f41809g = null;
                    if (this.f41812j) {
                        this.f41812j = false;
                        o();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new ContentDataSourceException(e5, AdError.SERVER_ERROR_CODE);
                }
            } finally {
                this.f41809g = null;
                if (this.f41812j) {
                    this.f41812j = false;
                    o();
                }
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41808f;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws ContentDataSourceException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41811i;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new ContentDataSourceException(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((FileInputStream) Util.k(this.f41810h)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.f41811i;
        if (j4 != -1) {
            this.f41811i = j4 - ((long) i5);
        }
        n(i5);
        return i5;
    }
}
