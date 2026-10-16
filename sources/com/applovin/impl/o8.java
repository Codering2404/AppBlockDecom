package com.applovin.impl;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class o8 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RandomAccessFile f62197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f62198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f62199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f62200h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b extends i5 {
        public b(String str, Throwable th, int i3) {
            super(str, th, i3);
        }

        public b(Throwable th, int i3) {
            super(th, i3);
        }
    }

    public o8() {
        super(false);
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws b {
        Uri uri = k5Var.f60912a;
        this.f62198f = uri;
        b(k5Var);
        RandomAccessFile randomAccessFileA = a(uri);
        this.f62197e = randomAccessFileA;
        try {
            randomAccessFileA.seek(k5Var.f60918g);
            long length = k5Var.f60919h;
            if (length == -1) {
                length = this.f62197e.length() - k5Var.f60918g;
            }
            this.f62199g = length;
            if (length < 0) {
                throw new b(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            this.f62200h = true;
            c(k5Var);
            return this.f62199g;
        } catch (IOException e3) {
            throw new b(e3, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f62198f;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f62198f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f62197e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e3) {
                throw new b(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            this.f62197e = null;
            if (this.f62200h) {
                this.f62200h = false;
                g();
            }
        }
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws b {
        if (i4 == 0) {
            return 0;
        }
        if (this.f62199g == 0) {
            return -1;
        }
        try {
            int i5 = ((RandomAccessFile) xp.a((Object) this.f62197e)).read(bArr, i3, (int) Math.min(this.f62199g, i4));
            if (i5 > 0) {
                this.f62199g -= (long) i5;
                d(i5);
            }
            return i5;
        } catch (IOException e3) {
            throw new b(e3, AdError.SERVER_ERROR_CODE);
        }
    }

    private static RandomAccessFile a(Uri uri) throws b {
        int i3 = AdError.INTERNAL_ERROR_2006;
        try {
            return new RandomAccessFile((String) b1.a((Object) uri.getPath()), "r");
        } catch (FileNotFoundException e3) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                if (xp.f65027a < 21 || !a.b(e3.getCause())) {
                    i3 = 2005;
                }
                throw new b(e3, i3);
            }
            throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e3, 1004);
        } catch (SecurityException e4) {
            throw new b(e4, AdError.INTERNAL_ERROR_2006);
        } catch (RuntimeException e5) {
            throw new b(e5, AdError.SERVER_ERROR_CODE);
        }
    }
}
