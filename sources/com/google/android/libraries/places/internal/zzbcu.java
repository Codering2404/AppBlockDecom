package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbcu extends zzbce {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f76031b = Logger.getLogger(zzbcu.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f76032c = zzbgf.f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f76033d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f76034a;

    private zzbcu() {
        throw null;
    }

    public static zzbcu A(byte[] bArr, int i3, int i4) {
        return new zzbcr(bArr, i3, i4);
    }

    public static int B(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int C(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public static int c(String str) {
        int length;
        try {
            length = zzbgi.a(str);
        } catch (zzbgh unused) {
            length = str.getBytes(zzbeb.f76091a).length;
        }
        return B(length) + length;
    }

    public static int d(zzbex zzbexVar) {
        int iJ = zzbexVar.j();
        return B(iJ) + iJ;
    }

    @Override // com.google.android.libraries.places.internal.zzbce
    public abstract void a(byte[] bArr, int i3, int i4);

    public final void e() {
        if (m() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void f(String str, zzbgh zzbghVar) throws zzbcs {
        f76031b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzbghVar);
        byte[] bytes = str.getBytes(zzbeb.f76091a);
        try {
            int length = bytes.length;
            v(length);
            a(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzbcs(e3);
        }
    }

    public abstract void h(int i3, int i4);

    public abstract void i(int i3, int i4);

    public abstract void j(int i3, int i4);

    public abstract void k(int i3, int i4);

    public abstract void l(int i3, long j3);

    public abstract int m();

    public abstract void n(int i3, long j3);

    public abstract void o(int i3, boolean z2);

    public abstract void p(int i3, String str);

    public abstract void q(int i3, zzbcl zzbclVar);

    public abstract void r(int i3, zzbex zzbexVar);

    public abstract void s(int i3, zzbcl zzbclVar);

    public abstract void t(byte b3);

    public abstract void u(int i3);

    public abstract void v(int i3);

    public abstract void w(int i3);

    public abstract void x(long j3);

    public abstract void y(long j3);

    public abstract void z();

    /* synthetic */ zzbcu(byte[] bArr) {
    }
}
