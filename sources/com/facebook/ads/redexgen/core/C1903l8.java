package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1903l8 implements H1 {
    public static String[] A04 = {"sdKdmhexVnrlWGhX9TH5KtuHBxlX2", "B98Zkm438dg3YkwTFsWcwjYsIqopE2cW", "q7DFl2FydsE0DWNk8QJk98tFdBPGU17r", "uw89PlDwsU5CTp5ALy1o", "HmpI", "x0Unc4LQNUVImDERNKiE", "Klo4tVDdc3zNBBgsT3eAMryjwXw3w", "mmy2vPNb8zCZX"};
    public final int A00;
    public final int A01;
    public final C04554v A02 = new C04554v();
    public final AnonymousClass53 A03;

    public C1903l8(int i3, AnonymousClass53 anonymousClass53, int i4) {
        this.A00 = i3;
        this.A03 = anonymousClass53;
        this.A01 = i4;
    }

    private C0751Gz A00(C04554v c04554v, long j3, long j4) {
        int iA00;
        int iA002;
        int iA0A = c04554v.A0A();
        long j5 = -1;
        long j6 = -1;
        long lastPcrTimeUsInRange = -9223372036854775807L;
        while (c04554v.A07() >= 188 && (iA002 = (iA00 = LI.A00(c04554v.A0l(), c04554v.A09(), iA0A)) + 188) <= iA0A) {
            long jA01 = LI.A01(c04554v, iA00, this.A00);
            if (jA01 != -9223372036854775807L) {
                long jA06 = this.A03.A06(jA01);
                if (jA06 > j3) {
                    String[] strArr = A04;
                    if (strArr[1].charAt(12) == strArr[2].charAt(12)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[3] = "aExFpEIrb6zE8t35yvld";
                    strArr2[5] = "jMLoot3yN0lnttWSwPI3";
                    if (lastPcrTimeUsInRange == -9223372036854775807L) {
                        return C0751Gz.A04(jA06, j4);
                    }
                    return C0751Gz.A03(j4 + j5);
                }
                long j7 = jA06 + 100000;
                String[] strArr3 = A04;
                if (strArr3[1].charAt(12) != strArr3[2].charAt(12)) {
                    String[] strArr4 = A04;
                    strArr4[3] = "ZHgwZuqrkfLn2FTfbKUV";
                    strArr4[5] = "99YI6qOyfmrUQVvNk1ZB";
                    if (j7 > j3) {
                        return C0751Gz.A03(((long) iA00) + j4);
                    }
                    j5 = iA00;
                    lastPcrTimeUsInRange = jA06;
                } else {
                    A04[4] = "5ynNf";
                    if (j7 > j3) {
                        return C0751Gz.A03(((long) iA00) + j4);
                    }
                    j5 = iA00;
                    lastPcrTimeUsInRange = jA06;
                }
            }
            c04554v.A0f(iA002);
            j6 = iA002;
        }
        if (lastPcrTimeUsInRange != -9223372036854775807L) {
            return C0751Gz.A05(lastPcrTimeUsInRange, j4 + j6);
        }
        return C0751Gz.A03;
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final void AFs() {
        this.A02.A0i(C5C.A07);
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final C0751Gz AIw(InterfaceC1999ms interfaceC1999ms, long j3) throws IOException {
        long jA8n = interfaceC1999ms.A8n();
        int iMin = (int) Math.min(this.A01, interfaceC1999ms.A8O() - jA8n);
        this.A02.A0d(iMin);
        interfaceC1999ms.AGt(this.A02.A0l(), 0, iMin);
        return A00(this.A02, j3, jA8n);
    }
}
