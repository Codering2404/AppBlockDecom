package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcda {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcfh f77631b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f77635f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77630a = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    zzccz[] f77634e = new zzccz[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f77636g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f77637h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f77632c = 4096;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77633d = 4096;

    zzcda(int i3, int i4, zzcfv zzcfvVar) {
        this.f77635f = r1.length - 1;
        this.f77631b = zzcfl.c(zzcfvVar);
    }

    private final void f() {
        int i3 = this.f77633d;
        int i4 = this.f77637h;
        if (i3 < i4) {
            if (i3 == 0) {
                g();
            } else {
                h(i4 - i3);
            }
        }
    }

    private final void g() {
        Arrays.fill(this.f77634e, (Object) null);
        this.f77635f = this.f77634e.length - 1;
        this.f77636g = 0;
        this.f77637h = 0;
    }

    private final int h(int i3) {
        int i4;
        int i5 = 0;
        if (i3 > 0) {
            int length = this.f77634e.length;
            while (true) {
                length--;
                i4 = this.f77635f;
                if (length < i4 || i3 <= 0) {
                    break;
                }
                int i6 = this.f77634e[length].f77629c;
                i3 -= i6;
                this.f77637h -= i6;
                this.f77636g--;
                i5++;
            }
            zzccz[] zzcczVarArr = this.f77634e;
            int i7 = i4 + 1;
            System.arraycopy(zzcczVarArr, i7, zzcczVarArr, i7 + i5, this.f77636g);
            this.f77635f += i5;
        }
        return i5;
    }

    private final int i(int i3) {
        return this.f77635f + 1 + i3;
    }

    private final zzcfj j(int i3) throws IOException {
        if (m(i3)) {
            return zzcdc.f77644b[i3].f77627a;
        }
        int length = zzcdc.f77644b.length;
        int i4 = i(i3 - 61);
        if (i4 >= 0) {
            zzccz[] zzcczVarArr = this.f77634e;
            if (i4 < zzcczVarArr.length) {
                return zzcczVarArr[i4].f77627a;
            }
        }
        int i5 = i3 + 1;
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 23);
        sb.append("Header index too large ");
        sb.append(i5);
        throw new IOException(sb.toString());
    }

    private final void k(int i3, zzccz zzcczVar) {
        this.f77630a.add(zzcczVar);
        int i4 = zzcczVar.f77629c;
        int i5 = this.f77633d;
        if (i4 > i5) {
            g();
            return;
        }
        h((this.f77637h + i4) - i5);
        int i6 = this.f77636g + 1;
        zzccz[] zzcczVarArr = this.f77634e;
        int length = zzcczVarArr.length;
        if (i6 > length) {
            zzccz[] zzcczVarArr2 = new zzccz[length + length];
            System.arraycopy(zzcczVarArr, 0, zzcczVarArr2, length, length);
            this.f77635f = this.f77634e.length - 1;
            this.f77634e = zzcczVarArr2;
        }
        int i7 = this.f77635f;
        this.f77635f = i7 - 1;
        this.f77634e[i7] = zzcczVar;
        this.f77636g++;
        this.f77637h += i4;
    }

    private final int l() {
        return this.f77631b.zzj() & 255;
    }

    private static final boolean m(int i3) {
        if (i3 < 0) {
            return false;
        }
        int length = zzcdc.f77644b.length;
        return i3 <= 60;
    }

    final void a(int i3) {
        this.f77632c = i3;
        this.f77633d = i3;
        f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 23);
        r3.append("Header index too large ");
        r3.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        throw new java.io.IOException(r3.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void b() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcda.b():void");
    }

    public final List c() {
        List list = this.f77630a;
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        return arrayList;
    }

    final int d(int i3, int i4) {
        int i5 = i3 & i4;
        if (i5 < i4) {
            return i5;
        }
        int i6 = 0;
        while (true) {
            int iL = l();
            if ((iL & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return i4 + (iL << i6);
            }
            i4 += (iL & 127) << i6;
            i6 += 7;
        }
    }

    final zzcfj e() {
        int iL = l();
        int i3 = iL & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        long jD = d(iL, 127);
        if (i3 != 128) {
            return this.f77631b.z1(jD);
        }
        byte[] bArrB = zzcdj.a().b(this.f77631b.zzr(jD));
        zzcfj zzcfjVar = zzcfj.f77742d;
        return zzcfi.b(bArrB);
    }
}
