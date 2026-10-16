package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f76398c = Logger.getLogger(zzbmg.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbmb f76399d = new zzblz();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final BaseEncoding f76400e = BaseEncoding.b().n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f76401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76402b;

    public zzbmg() {
    }

    private final byte[] h(int i3) {
        return (byte[]) this.f76401a[i3 + i3];
    }

    private final Object i(int i3) {
        return this.f76401a[i3 + i3 + 1];
    }

    private final byte[] j(int i3) {
        Object objI = i(i3);
        if (objI instanceof byte[]) {
            return (byte[]) objI;
        }
        throw null;
    }

    private final int k() {
        Object[] objArr = this.f76401a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private final boolean l() {
        return this.f76402b == 0;
    }

    private final void m(int i3) {
        Object[] objArr = new Object[i3];
        if (!l()) {
            Object[] objArr2 = this.f76401a;
            int i4 = this.f76402b;
            System.arraycopy(objArr2, 0, objArr, 0, i4 + i4);
        }
        this.f76401a = objArr;
    }

    final int a() {
        return this.f76402b;
    }

    public final Object b(zzbmc zzbmcVar) {
        int i3 = this.f76402b;
        do {
            i3--;
            if (i3 < 0) {
                return null;
            }
        } while (!Arrays.equals(zzbmcVar.e(), h(i3)));
        Object objI = i(i3);
        if (objI instanceof byte[]) {
            return zzbmcVar.b((byte[]) objI);
        }
        throw null;
    }

    public final void c(zzbmc zzbmcVar, Object obj) {
        Preconditions.u(zzbmcVar, "key");
        Preconditions.u(obj, "value");
        int i3 = this.f76402b;
        int i4 = i3 + i3;
        if (i4 == 0 || i4 == k()) {
            m(Math.max(i4 + i4, 8));
        }
        int i5 = this.f76402b;
        this.f76401a[i5 + i5] = zzbmcVar.e();
        int i6 = this.f76402b;
        this.f76401a[i6 + i6 + 1] = zzbmcVar.a(obj);
        this.f76402b++;
    }

    public final void d(zzbmc zzbmcVar) {
        if (l()) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.f76402b;
            if (i3 >= i5) {
                Arrays.fill(this.f76401a, i4 + i4, i5 + i5, (Object) null);
                this.f76402b = i4;
                return;
            }
            if (!Arrays.equals(zzbmcVar.e(), h(i3))) {
                int i6 = i4 + i4;
                this.f76401a[i6] = h(i3);
                Object objI = i(i3);
                if (this.f76401a instanceof byte[][]) {
                    m(k());
                }
                this.f76401a[i6 + 1] = objI;
                i4++;
            }
            i3++;
        }
    }

    final byte[][] e() {
        int i3 = this.f76402b;
        int i4 = i3 + i3;
        byte[][] bArr = new byte[i4][];
        Object[] objArr = this.f76401a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, i4);
            return bArr;
        }
        for (int i5 = 0; i5 < this.f76402b; i5++) {
            int i6 = i5 + i5;
            bArr[i6] = h(i5);
            bArr[i6 + 1] = j(i5);
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(com.google.android.libraries.places.internal.zzbmg r6) {
        /*
            r5 = this;
            boolean r0 = r6.l()
            if (r0 == 0) goto L7
            return
        L7:
            int r0 = r5.k()
            int r1 = r5.f76402b
            int r1 = r1 + r1
            int r0 = r0 - r1
            boolean r2 = r5.l()
            if (r2 != 0) goto L1a
            int r2 = r6.f76402b
            int r2 = r2 + r2
            if (r0 >= r2) goto L21
        L1a:
            int r0 = r6.f76402b
            int r0 = r0 + r0
            int r1 = r1 + r0
            r5.m(r1)
        L21:
            java.lang.Object[] r0 = r6.f76401a
            java.lang.Object[] r1 = r5.f76401a
            int r2 = r5.f76402b
            int r2 = r2 + r2
            int r3 = r6.f76402b
            int r3 = r3 + r3
            r4 = 0
            java.lang.System.arraycopy(r0, r4, r1, r2, r3)
            int r0 = r5.f76402b
            int r6 = r6.f76402b
            int r0 = r0 + r6
            r5.f76402b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbmg.f(com.google.android.libraries.places.internal.zzbmg):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i3 = 0; i3 < this.f76402b; i3++) {
            if (i3 != 0) {
                sb.append(',');
            }
            byte[] bArrH = h(i3);
            Charset charset = StandardCharsets.US_ASCII;
            String str = new String(bArrH, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(f76400e.g(j(i3)));
            } else {
                sb.append(new String(j(i3), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    zzbmg(int i3, Object[] objArr) {
        this.f76402b = i3;
        this.f76401a = objArr;
    }
}
