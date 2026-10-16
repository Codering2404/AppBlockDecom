package com.google.android.libraries.places.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcff f77638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    zzccz[] f77639b = new zzccz[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f77640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f77642e;

    zzcdb(int i3, boolean z2, zzcff zzcffVar) {
        this.f77641d = r1.length - 1;
        this.f77638a = zzcffVar;
    }

    private final void d(zzccz zzcczVar) {
        int i3;
        int i4 = zzcczVar.f77629c;
        if (i4 > 4096) {
            Arrays.fill(this.f77639b, (Object) null);
            this.f77641d = this.f77639b.length - 1;
            this.f77640c = 0;
            this.f77642e = 0;
            return;
        }
        int i5 = (this.f77642e + i4) - 4096;
        if (i5 > 0) {
            int length = this.f77639b.length - 1;
            int i6 = 0;
            while (true) {
                i3 = this.f77641d;
                if (length < i3 || i5 <= 0) {
                    break;
                }
                int i7 = this.f77639b[length].f77629c;
                i5 -= i7;
                this.f77642e -= i7;
                this.f77640c--;
                i6++;
                length--;
            }
            zzccz[] zzcczVarArr = this.f77639b;
            int i8 = i3 + 1;
            System.arraycopy(zzcczVarArr, i8, zzcczVarArr, i8 + i6, this.f77640c);
            this.f77641d += i6;
        }
        int i9 = this.f77640c + 1;
        zzccz[] zzcczVarArr2 = this.f77639b;
        int length2 = zzcczVarArr2.length;
        if (i9 > length2) {
            zzccz[] zzcczVarArr3 = new zzccz[length2 + length2];
            System.arraycopy(zzcczVarArr2, 0, zzcczVarArr3, length2, length2);
            this.f77641d = this.f77639b.length - 1;
            this.f77639b = zzcczVarArr3;
        }
        int i10 = this.f77641d;
        this.f77641d = i10 - 1;
        this.f77639b[i10] = zzcczVar;
        this.f77640c++;
        this.f77642e += i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(java.util.List r13) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcdb.a(java.util.List):void");
    }

    final void b(int i3, int i4, int i5) {
        if (i3 < i4) {
            this.f77638a.a(i3 | i5);
            return;
        }
        zzcff zzcffVar = this.f77638a;
        zzcffVar.a(i5 | i4);
        int i6 = i3 - i4;
        while (i6 >= 128) {
            zzcffVar.a(128 | (i6 & 127));
            i6 >>>= 7;
        }
        zzcffVar.a(i6);
    }

    final void c(zzcfj zzcfjVar) {
        b(zzcfjVar.j(), 127, 0);
        this.f77638a.M(zzcfjVar);
    }
}
