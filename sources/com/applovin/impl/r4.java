package com.applovin.impl;

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

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class r4 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f62728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f62729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f62730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileInputStream f62731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f62732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f62733j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {
        public static void a(Bundle bundle) {
            bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", z30.a().addSupportedVideoMimeType("video/hevc").addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b extends i5 {
        public b(IOException iOException, int i3) {
            super(iOException, i3);
        }
    }

    public r4(Context context) {
        super(false);
        this.f62728e = context.getContentResolver();
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws b {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        int i3 = AdError.SERVER_ERROR_CODE;
        try {
            Uri uri = k5Var.f60912a;
            this.f62729f = uri;
            b(k5Var);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(k5Var.f60912a.getScheme())) {
                Bundle bundle = new Bundle();
                if (xp.f65027a >= 31) {
                    a.a(bundle);
                }
                assetFileDescriptorOpenAssetFileDescriptor = this.f62728e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f62728e.openAssetFileDescriptor(uri, "r");
            }
            this.f62730g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new b(new IOException("Could not open file descriptor for: " + uri), AdError.SERVER_ERROR_CODE);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f62731h = fileInputStream;
            if (length != -1 && k5Var.f60918g > length) {
                throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(k5Var.f60918g + startOffset) - startOffset;
            if (jSkip != k5Var.f60918g) {
                throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f62732i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f62732i = jPosition;
                    if (jPosition < 0) {
                        throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j3 = length - jSkip;
                this.f62732i = j3;
                if (j3 < 0) {
                    throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            long jMin = k5Var.f60919h;
            if (jMin != -1) {
                long j4 = this.f62732i;
                if (j4 != -1) {
                    jMin = Math.min(j4, jMin);
                }
                this.f62732i = jMin;
            }
            this.f62733j = true;
            c(k5Var);
            long j5 = k5Var.f60919h;
            return j5 != -1 ? j5 : this.f62732i;
        } catch (b e3) {
            throw e3;
        } catch (IOException e4) {
            if (e4 instanceof FileNotFoundException) {
                i3 = 2005;
            }
            throw new b(e4, i3);
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f62729f;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f62729f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f62731h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f62731h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f62730g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e3) {
                        throw new b(e3, AdError.SERVER_ERROR_CODE);
                    }
                } finally {
                    this.f62730g = null;
                    if (this.f62733j) {
                        this.f62733j = false;
                        g();
                    }
                }
            } catch (IOException e4) {
                throw new b(e4, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.f62731h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f62730g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f62730g = null;
                    if (this.f62733j) {
                        this.f62733j = false;
                        g();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new b(e5, AdError.SERVER_ERROR_CODE);
                }
            } finally {
                this.f62730g = null;
                if (this.f62733j) {
                    this.f62733j = false;
                    g();
                }
            }
        }
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws b {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f62732i;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new b(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((FileInputStream) xp.a((Object) this.f62731h)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.f62732i;
        if (j4 != -1) {
            this.f62732i = j4 - ((long) i5);
        }
        d(i5);
        return i5;
    }
}
