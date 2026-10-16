package com.google.android.libraries.places.internal;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvi extends zzvk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzut f78684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzut f78685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f78686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f78687e;

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /* synthetic */ zzvi(com.google.android.libraries.places.internal.zzut r9, com.google.android.libraries.places.internal.zzut r10, byte[] r11) {
        /*
            r8 = this;
            r11 = 0
            r8.<init>(r11)
            r8.f78684b = r9
            r8.f78685c = r10
            int r9 = r10.a()
            r10 = 28
            r11 = 0
            r0 = 1
            if (r9 > r10) goto L14
            r10 = r0
            goto L15
        L14:
            r10 = r11
        L15:
            java.lang.String r1 = "metadata size too large"
            com.google.android.libraries.places.internal.zzxb.b(r10, r1)
            int[] r9 = new int[r9]
            r8.f78686d = r9
            r1 = 0
            r10 = r11
            r3 = r10
        L22:
            int r4 = r9.length
            if (r10 >= r4) goto L66
            com.google.android.libraries.places.internal.zztv r4 = r8.e(r10)
            long r5 = r4.i()
            long r5 = r5 | r1
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L5d
            r1 = r11
        L33:
            r2 = -1
            if (r1 >= r3) goto L48
            r7 = r9[r1]
            r7 = r7 & 31
            com.google.android.libraries.places.internal.zztv r7 = r8.e(r7)
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L45
            goto L49
        L45:
            int r1 = r1 + 1
            goto L33
        L48:
            r1 = r2
        L49:
            if (r1 == r2) goto L5d
            boolean r2 = r4.f()
            if (r2 == 0) goto L59
            r2 = r9[r1]
            int r4 = r10 + 4
            int r4 = r0 << r4
            r2 = r2 | r4
            goto L5a
        L59:
            r2 = r10
        L5a:
            r9[r1] = r2
            goto L62
        L5d:
            int r1 = r3 + 1
            r9[r3] = r10
            r3 = r1
        L62:
            int r10 = r10 + 1
            r1 = r5
            goto L22
        L66:
            r8.f78687e = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzvi.<init>(com.google.android.libraries.places.internal.zzut, com.google.android.libraries.places.internal.zzut, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final zztv e(int i3) {
        zzut zzutVar = this.f78684b;
        int iA = zzutVar.a();
        return i3 >= iA ? this.f78685c.b(i3 - iA) : zzutVar.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final Object f(int i3) {
        zzut zzutVar = this.f78684b;
        int iA = zzutVar.a();
        return i3 >= iA ? this.f78685c.c(i3 - iA) : zzutVar.c(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final void a(zzva zzvaVar, Object obj) {
        for (int i3 = 0; i3 < this.f78687e; i3++) {
            int i4 = this.f78686d[i3];
            zztv zztvVarE = e(i4 & 31);
            if (zztvVarE.f()) {
                zzvaVar.b(zztvVarE, new zzvh(this, zztvVarE, i4, null), obj);
            } else {
                zzvaVar.a(zztvVarE, zztvVarE.e(f(i4)), obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final int b() {
        return this.f78687e;
    }

    @Override // com.google.android.libraries.places.internal.zzvk
    public final Set c() {
        return new zzvg(this);
    }

    final /* synthetic */ int[] g() {
        return this.f78686d;
    }

    final /* synthetic */ int h() {
        return this.f78687e;
    }
}
