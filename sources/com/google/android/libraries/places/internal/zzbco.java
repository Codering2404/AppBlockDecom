package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbco {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile int f76013f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f76014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f76015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f76016c = f76013f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f76017d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object f76018e;

    private zzbco() {
    }

    public static zzbco d(InputStream inputStream, int i3) {
        return new zzbcn(inputStream, 4096, null);
    }

    public static zzbco e(byte[] bArr, int i3, int i4) {
        return f(bArr, 0, i4, false);
    }

    static zzbco f(byte[] bArr, int i3, int i4, boolean z2) {
        zzbcm zzbcmVar = new zzbcm(bArr, 0, i4, z2, null);
        try {
            zzbcmVar.G(i4);
            return zzbcmVar;
        } catch (zzbed e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int k(int i3) {
        return (i3 >>> 1) ^ (-(i3 & 1));
    }

    public static long l(long j3) {
        return (j3 >>> 1) ^ (-(1 & j3));
    }

    public abstract int A();

    public abstract int B();

    public abstract int C();

    public abstract long D();

    public abstract int E();

    public abstract long F();

    public abstract int G(int i3);

    public abstract void a(int i3);

    public abstract boolean b();

    public abstract int c();

    public final void g() throws zzbed {
        if (this.f76014a + this.f76015b >= this.f76016c) {
            throw new zzbed("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void h() {
        if (this.f76015b == 0) {
            n(0);
        }
    }

    public final void i() throws zzbed {
        int iM;
        do {
            iM = m();
            if (iM == 0) {
                return;
            }
            g();
            this.f76015b++;
            this.f76015b--;
        } while (o(iM));
    }

    public final int j(int i3) {
        int i4 = this.f76017d;
        this.f76017d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        return i4;
    }

    public abstract int m();

    public abstract void n(int i3);

    public abstract boolean o(int i3);

    public abstract double p();

    public abstract float q();

    public abstract long r();

    public abstract long s();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract boolean w();

    public abstract String x();

    public abstract String y();

    public abstract zzbcl z();

    /* synthetic */ zzbco(byte[] bArr) {
    }
}
