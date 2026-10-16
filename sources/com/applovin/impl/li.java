package com.applovin.impl;

import android.content.Context;
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

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class li extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Resources f61229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f61230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Uri f61231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AssetFileDescriptor f61232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InputStream f61233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f61234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f61235k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a extends i5 {
        public a(String str, Throwable th, int i3) {
            super(str, th, i3);
        }
    }

    public li(Context context) {
        super(false);
        this.f61229e = context.getResources();
        this.f61230f = context.getPackageName();
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws a {
        int identifier;
        String str;
        Uri uri = k5Var.f60912a;
        this.f61231g = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) b1.a((Object) uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) b1.a((Object) uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new a("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String strSubstring = (String) b1.a((Object) uri.getPath());
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            }
            sb.append(str);
            sb.append(strSubstring);
            identifier = this.f61229e.getIdentifier(sb.toString(), "raw", this.f61230f);
            if (identifier == 0) {
                throw new a("Resource not found.", null, 2005);
            }
        }
        b(k5Var);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f61229e.openRawResourceFd(identifier);
            this.f61232h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new a("Resource is compressed: " + uri, null, AdError.SERVER_ERROR_CODE);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f61233i = fileInputStream;
            if (length != -1) {
                try {
                    if (k5Var.f60918g > length) {
                        throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                } catch (a e3) {
                    throw e3;
                } catch (IOException e4) {
                    throw new a(null, e4, AdError.SERVER_ERROR_CODE);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(k5Var.f60918g + startOffset) - startOffset;
            if (jSkip != k5Var.f60918g) {
                throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f61234j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f61234j = size;
                    if (size < 0) {
                        throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j3 = length - jSkip;
                this.f61234j = j3;
                if (j3 < 0) {
                    throw new i5(AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            long jMin = k5Var.f60919h;
            if (jMin != -1) {
                long j4 = this.f61234j;
                if (j4 != -1) {
                    jMin = Math.min(j4, jMin);
                }
                this.f61234j = jMin;
            }
            this.f61235k = true;
            c(k5Var);
            long j5 = k5Var.f60919h;
            return j5 != -1 ? j5 : this.f61234j;
        } catch (Resources.NotFoundException e5) {
            throw new a(null, e5, 2005);
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f61231g;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f61231g = null;
        try {
            try {
                InputStream inputStream = this.f61233i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f61233i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f61232h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e3) {
                        throw new a(null, e3, AdError.SERVER_ERROR_CODE);
                    }
                } finally {
                    this.f61232h = null;
                    if (this.f61235k) {
                        this.f61235k = false;
                        g();
                    }
                }
            } catch (IOException e4) {
                throw new a(null, e4, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            this.f61233i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f61232h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f61232h = null;
                    if (this.f61235k) {
                        this.f61235k = false;
                        g();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new a(null, e5, AdError.SERVER_ERROR_CODE);
                }
            } finally {
                this.f61232h = null;
                if (this.f61235k) {
                    this.f61235k = false;
                    g();
                }
            }
        }
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws a {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f61234j;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new a(null, e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((InputStream) xp.a((Object) this.f61233i)).read(bArr, i3, i4);
        if (i5 == -1) {
            if (this.f61234j == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), AdError.SERVER_ERROR_CODE);
        }
        long j4 = this.f61234j;
        if (j4 != -1) {
            this.f61234j = j4 - ((long) i5);
        }
        d(i5);
        return i5;
    }
}
