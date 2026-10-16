package com.applovin.impl;

import android.net.Uri;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Charsets;
import com.facebook.ads.AdError;
import java.net.URLDecoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class g5 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k5 f59866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f59867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f59868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f59869h;

    public g5() {
        super(false);
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws i5, ch {
        b(k5Var);
        this.f59866e = k5Var;
        Uri uri = k5Var.f60912a;
        String scheme = uri.getScheme();
        b1.a("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrA = xp.a(uri.getSchemeSpecificPart(), ",");
        if (strArrA.length != 2) {
            throw ch.b("Unexpected URI format: " + uri, null);
        }
        String str = strArrA[1];
        if (strArrA[0].contains(";base64")) {
            try {
                this.f59867f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e3) {
                throw ch.b("Error while parsing Base64 encoded string: " + str, e3);
            }
        } else {
            this.f59867f = xp.c(URLDecoder.decode(str, Charsets.US_ASCII.name()));
        }
        long j3 = k5Var.f60918g;
        byte[] bArr = this.f59867f;
        if (j3 > bArr.length) {
            this.f59867f = null;
            throw new i5(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i3 = (int) j3;
        this.f59868g = i3;
        int length = bArr.length - i3;
        this.f59869h = length;
        long j4 = k5Var.f60919h;
        if (j4 != -1) {
            this.f59869h = (int) Math.min(length, j4);
        }
        c(k5Var);
        long j5 = k5Var.f60919h;
        return j5 != -1 ? j5 : this.f59869h;
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        k5 k5Var = this.f59866e;
        if (k5Var != null) {
            return k5Var.f60912a;
        }
        return null;
    }

    @Override // com.applovin.impl.h5
    public void close() {
        if (this.f59867f != null) {
            this.f59867f = null;
            g();
        }
        this.f59866e = null;
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.f59869h;
        if (i5 == 0) {
            return -1;
        }
        int iMin = Math.min(i4, i5);
        System.arraycopy(xp.a((Object) this.f59867f), this.f59868g, bArr, i3, iMin);
        this.f59868g += iMin;
        this.f59869h -= iMin;
        d(iMin);
        return iMin;
    }
}
