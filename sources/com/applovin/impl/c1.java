package com.applovin.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class c1 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssetManager f58801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f58802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputStream f58803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f58804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f58805i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends i5 {
        public a(Throwable th, int i3) {
            super(th, i3);
        }
    }

    public c1(Context context) {
        super(false);
        this.f58801e = context.getAssets();
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws a {
        try {
            Uri uri = k5Var.f60912a;
            this.f58802f = uri;
            String strSubstring = (String) b1.a((Object) uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            b(k5Var);
            InputStream inputStreamOpen = this.f58801e.open(strSubstring, 1);
            this.f58803g = inputStreamOpen;
            if (inputStreamOpen.skip(k5Var.f60918g) < k5Var.f60918g) {
                throw new a(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long j3 = k5Var.f60919h;
            if (j3 != -1) {
                this.f58804h = j3;
            } else {
                long jAvailable = this.f58803g.available();
                this.f58804h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f58804h = -1L;
                }
            }
            this.f58805i = true;
            c(k5Var);
            return this.f58804h;
        } catch (a e3) {
            throw e3;
        } catch (IOException e4) {
            throw new a(e4, e4 instanceof FileNotFoundException ? 2005 : AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f58802f;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f58802f = null;
        try {
            try {
                InputStream inputStream = this.f58803g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e3) {
                throw new a(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            this.f58803g = null;
            if (this.f58805i) {
                this.f58805i = false;
                g();
            }
        }
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws a {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f58804h;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new a(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((InputStream) xp.a((Object) this.f58803g)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.f58804h;
        if (j4 != -1) {
            this.f58804h = j4 - ((long) i5);
        }
        d(i5);
        return i5;
    }
}
