package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzcfj implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzcfj f77742d = new zzcfj(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f77743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f77744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient String f77745c;

    public zzcfj(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f77743a = data;
    }

    public final byte[] a() {
        return this.f77743a;
    }

    public final int b() {
        return this.f77744b;
    }

    public final void c(int i3) {
        this.f77744b = i3;
    }

    public final void d(String str) {
        this.f77745c = str;
    }

    public final String e() {
        String str = this.f77745c;
        if (str != null) {
            return str;
        }
        String strA = zzcfy.a(l());
        this.f77745c = strA;
        return strA;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcfj) {
            zzcfj zzcfjVar = (zzcfj) obj;
            int iJ = zzcfjVar.j();
            byte[] bArr = this.f77743a;
            int length = bArr.length;
            return iJ == length && zzcfjVar.o(0, bArr, 0, length);
        }
        return false;
    }

    public final String f() {
        return zzcfa.a(this.f77743a, null, 1, null);
    }

    public String g() {
        byte[] bArr = this.f77743a;
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i3 = 0;
        for (byte b3 : bArr) {
            cArr[i3] = zzcga.a()[(b3 >> 4) & 15];
            cArr[i3 + 1] = zzcga.a()[b3 & Ascii.SI];
            i3 += 2;
        }
        return StringsKt.y(cArr);
    }

    public zzcfj h() {
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f77743a;
            int length = bArr.length;
            if (i3 >= length) {
                return this;
            }
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 65 && b3 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i3] = (byte) (b3 + 32);
                while (i4 < bArrCopyOf.length) {
                    int i5 = i4 + 1;
                    byte b4 = bArrCopyOf[i4];
                    if (b4 >= 65 && b4 <= 90) {
                        bArrCopyOf[i4] = (byte) (b4 + 32);
                    }
                    i4 = i5;
                }
                return new zzcfj(bArrCopyOf);
            }
            i3 = i4;
        }
    }

    public int hashCode() {
        int i3 = this.f77744b;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = Arrays.hashCode(this.f77743a);
        this.f77744b = iHashCode;
        return iHashCode;
    }

    public byte i(int i3) {
        return this.f77743a[i3];
    }

    public int j() {
        return this.f77743a.length;
    }

    public byte[] k() {
        byte[] bArr = this.f77743a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public byte[] l() {
        return this.f77743a;
    }

    public void m(zzcff buffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i5 = zzcga.f77772b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.g0(this.f77743a, 0, i4);
    }

    public boolean n(int i3, zzcfj other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.o(0, this.f77743a, 0, i5);
    }

    public boolean o(int i3, byte[] other, int i4, int i5) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0) {
            return false;
        }
        byte[] bArr = this.f77743a;
        return i3 <= bArr.length - i5 && i4 >= 0 && i4 <= other.length - i5 && zzcfb.b(bArr, i3, other, i4, i5);
    }

    public final boolean p(zzcfj prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return n(0, prefix, 0, prefix.f77743a.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a6, code lost:
    
        r6 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcfj.toString():java.lang.String");
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzcfj zzcfjVar = (zzcfj) obj;
        Intrinsics.checkNotNullParameter(zzcfjVar, pMpIcGE.XyPmxtDZdpq);
        int iJ = j();
        int iJ2 = zzcfjVar.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = i(i3) & 255;
            int i5 = zzcfjVar.i(i3) & 255;
            if (i4 != i5) {
                return i4 >= i5 ? 1 : -1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        return iJ >= iJ2 ? 1 : -1;
    }
}
