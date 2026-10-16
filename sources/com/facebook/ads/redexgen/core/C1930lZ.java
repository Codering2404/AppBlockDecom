package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1930lZ implements InterfaceC0812Jj {
    public static String[] A03 = {"LK8mEMUSnifSCT0YT0fQtLG", "zQWICugnqrmXEq8sMdeIuA9JBPwrta0k", "lKxJonOWK2Axk83UnpUnbJJcLxj", "3DYuz", "CNQNHGpRGAv1E31EB6wcq1FAARNpDgXE", "DpJK", "NUJ585yfBdIWgF7XcRLbZeMVqrhzmgk", "1sPINCYISeoO6PXpnzvAKZkikus6bvvY"};
    public final List<C0834Kf> A00;
    public final long[] A01;
    public final long[] A02;

    /* JADX WARN: Incorrect condition in loop: B:4:0x001d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1930lZ(java.util.List<com.facebook.ads.redexgen.core.C0834Kf> r8) {
        /*
            r7 = this;
            r7.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r7.A00 = r0
            int r0 = r8.size()
            int r0 = r0 * 2
            long[] r0 = new long[r0]
            r7.A01 = r0
            r6 = 0
        L19:
            int r0 = r8.size()
            if (r6 >= r0) goto L38
            java.lang.Object r5 = r8.get(r6)
            com.facebook.ads.redexgen.X.Kf r5 = (com.facebook.ads.redexgen.core.C0834Kf) r5
            int r4 = r6 * 2
            long[] r2 = r7.A01
            long r0 = r5.A01
            r2[r4] = r0
            long[] r3 = r7.A01
            int r2 = r4 + 1
            long r0 = r5.A00
            r3[r2] = r0
            int r6 = r6 + 1
            goto L19
        L38:
            long[] r1 = r7.A01
            long[] r0 = r7.A01
            int r0 = r0.length
            long[] r0 = java.util.Arrays.copyOf(r1, r0)
            r7.A02 = r0
            long[] r0 = r7.A02
            java.util.Arrays.sort(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1930lZ.<init>(java.util.List):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.A00.size(); i3++) {
            if (this.A01[i3 * 2] <= j3) {
                long j4 = this.A01[(i3 * 2) + 1];
                if (A03[2].length() == 27) {
                    A03[5] = "FOcCQTOovqYXamkXPEg";
                    if (j3 < j4) {
                        C0834Kf c0834Kf = this.A00.get(i3);
                        if (c0834Kf.A02.A01 == -3.4028235E38f) {
                            arrayList2.add(c0834Kf);
                        } else {
                            C2158pT c2158pT = c0834Kf.A02;
                            String[] strArr = A03;
                            if (strArr[6].length() != strArr[0].length()) {
                                String[] strArr2 = A03;
                                strArr2[4] = "KriihMM2RWcrEfyoWolOk5PIi1Nv3YmO";
                                strArr2[1] = "gocQSZMmm3PjEWFg0RBonPYHqyNHFxQo";
                                arrayList.add(c2158pT);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                throw new RuntimeException();
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.facebook.ads.redexgen.X.Kp
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((C0834Kf) obj).A01, ((C0834Kf) obj2).A01);
            }
        });
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            arrayList.add(((C0834Kf) arrayList2.get(i4)).A02.A02().A07((-1) - i4, 1).A0H());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        boolean z2 = true;
        AbstractC04323y.A07(i3 >= 0);
        if (i3 >= this.A02.length) {
            z2 = false;
        }
        AbstractC04323y.A07(z2);
        return this.A02[i3];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return this.A02.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        int iA0K = C5C.A0K(this.A02, j3, false, false);
        int index = this.A02.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
