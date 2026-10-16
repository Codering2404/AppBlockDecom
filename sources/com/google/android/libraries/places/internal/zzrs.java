package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzrs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f78530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzrq f78531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzrq f78532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f78533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f78534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f78535f;

    private zzrs(int[] iArr) {
        this.f78530a = iArr;
        zzrq zzrqVar = new zzrq(-1, -1, null);
        this.f78531b = zzrqVar;
        this.f78532c = zzrqVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r6 = r0.f78532c.f78526d;
        r8 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r6.containsKey(r8) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r0.f78532c.f78526d.put(r8, new com.google.android.libraries.places.internal.zzrq(r1, 1073741824, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r5.f78525c = r0.f78532c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r5.f78525c = r0.f78532c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r0.f78533d = r1;
        r0.f78534e++;
        r0.b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.libraries.places.internal.zzrs a(int[] r12) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzrs.a(int[]):com.google.android.libraries.places.internal.zzrs");
    }

    private final void e(zzrq zzrqVar, StringBuilder sb) {
        for (zzrq zzrqVar2 : zzrqVar.f78526d.values()) {
            sb.append("  ");
            sb.append(zzrqVar);
            sb.append(" -> ");
            sb.append(zzrqVar2);
            sb.append(" [label=\"");
            int[] iArr = this.f78530a;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzrqVar2.f78523a, Math.min(iArr.length, zzrqVar2.f78524b + 1))));
            sb.append("\"]\n");
            e(zzrqVar2, sb);
        }
    }

    private final boolean f(int i3, int i4, int i5, int i6) {
        if (i3 >= 0 && i5 >= 0) {
            int[] iArr = this.f78530a;
            int length = iArr.length;
            int iMin = Math.min(length, i4);
            if (iMin - i3 == Math.min(length, i6) - i5) {
                for (int i7 = i3; i7 <= iMin; i7++) {
                    if (iArr[i7] != iArr[(i5 + i7) - i3]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    final void b() {
        if (this.f78534e == 0) {
            return;
        }
        Map map = this.f78532c.f78526d;
        int[] iArr = this.f78530a;
        zzrq zzrqVar = (zzrq) map.get(Integer.valueOf(iArr[this.f78533d]));
        while (true) {
            int i3 = (zzrqVar.f78524b - zzrqVar.f78523a) + 1;
            int i4 = this.f78534e;
            if (i3 > i4) {
                return;
            }
            int i5 = this.f78533d + i3;
            this.f78533d = i5;
            this.f78532c = zzrqVar;
            int i6 = i4 - i3;
            this.f78534e = i6;
            if (i6 > 0) {
                zzrqVar = (zzrq) zzrqVar.f78526d.get(Integer.valueOf(iArr[i5]));
            }
        }
    }

    final void c() {
        zzrq zzrqVar = this.f78532c.f78525c;
        if (zzrqVar != null) {
            this.f78532c = zzrqVar;
        } else {
            this.f78532c = this.f78531b;
            int i3 = this.f78534e;
            if (i3 > 0) {
                this.f78534e = i3 - 1;
            }
            if (this.f78535f > 0) {
                this.f78533d++;
            }
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.libraries.places.internal.zzrr d() {
        /*
            r12 = this;
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            com.google.android.libraries.places.internal.zzrp r1 = new com.google.android.libraries.places.internal.zzrp
            com.google.android.libraries.places.internal.zzrq r2 = r12.f78531b
            r5 = -1
            r6 = 0
            r3 = 0
            r4 = -1
            r1.<init>(r2, r3, r4, r5, r6)
            r0.push(r1)
        L13:
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L7b
            java.lang.Object r3 = r0.pop()
            com.google.android.libraries.places.internal.zzrp r3 = (com.google.android.libraries.places.internal.zzrp) r3
            com.google.android.libraries.places.internal.zzrq r4 = r3.f78522d
            java.util.Map r4 = r4.f78526d
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L2b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L13
            java.lang.Object r5 = r4.next()
            r7 = r5
            com.google.android.libraries.places.internal.zzrq r7 = (com.google.android.libraries.places.internal.zzrq) r7
            int r9 = r3.f78520b
            int r10 = r3.f78521c
            int r5 = r7.f78523a
            r6 = r10
            int r10 = r7.f78524b
            boolean r5 = r12.f(r9, r6, r5, r10)
            if (r5 != 0) goto L5a
            java.util.Map r5 = r7.f78526d
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L5c
            int r5 = r7.f78523a
            int r8 = r5 + r6
            int r8 = r8 - r9
            boolean r5 = r12.f(r9, r6, r5, r8)
            if (r5 == 0) goto L5c
        L5a:
            r10 = r6
            goto L66
        L5c:
            com.google.android.libraries.places.internal.zzrp r6 = new com.google.android.libraries.places.internal.zzrp
            int r9 = r7.f78523a
            r11 = 0
            r8 = 1
            r6.<init>(r7, r8, r9, r10, r11)
            goto L70
        L66:
            com.google.android.libraries.places.internal.zzrp r6 = new com.google.android.libraries.places.internal.zzrp
            int r5 = r3.f78519a
            int r8 = r5 + 1
            r11 = 0
            r6.<init>(r7, r8, r9, r10, r11)
        L70:
            int r5 = r1.f78519a
            int r7 = r6.f78519a
            if (r5 >= r7) goto L77
            r1 = r6
        L77:
            r0.push(r6)
            goto L2b
        L7b:
            int[] r0 = r12.f78530a
            int r3 = r1.f78521c
            int r3 = r3 + 1
            int r4 = r0.length
            int r3 = java.lang.Math.min(r4, r3)
            r4 = 0
        L87:
            int r5 = r1.f78520b
            int r6 = r3 - r5
            int r7 = r4 % r6
            int r7 = r7 + r5
            r7 = r0[r7]
            java.util.Map r2 = r2.f78526d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r2 = r2.get(r7)
            com.google.android.libraries.places.internal.zzrq r2 = (com.google.android.libraries.places.internal.zzrq) r2
            if (r2 != 0) goto L9f
            goto Lb8
        L9f:
            int r7 = r2.f78523a
        La1:
            int r8 = r2.f78524b
            int r8 = r8 + 1
            if (r7 >= r8) goto L87
            int r8 = r0.length
            if (r7 >= r8) goto L87
            int r8 = r4 % r6
            int r8 = r8 + r5
            r8 = r0[r8]
            r9 = r0[r7]
            if (r8 != r9) goto Lb8
            int r4 = r4 + 1
            int r7 = r7 + 1
            goto La1
        Lb8:
            com.google.android.libraries.places.internal.zzrr r0 = new com.google.android.libraries.places.internal.zzrr
            int r4 = r4 / r6
            r0.<init>(r5, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzrs.d():com.google.android.libraries.places.internal.zzrr");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        e(this.f78531b, sb);
        sb.append("}");
        return sb.toString();
    }
}
