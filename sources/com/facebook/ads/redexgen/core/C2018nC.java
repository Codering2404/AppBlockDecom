package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2018nC implements F0 {
    public int A00;
    public int A01;
    public int A02;
    public C0699Ey[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;

    public C2018nC(boolean z2, int i3) {
        this(z2, i3, 0);
    }

    public C2018nC(boolean z2, int i3, int i4) {
        AbstractC04323y.A07(i3 > 0);
        AbstractC04323y.A07(i4 >= 0);
        this.A05 = z2;
        this.A04 = i3;
        this.A01 = i4;
        this.A03 = new C0699Ey[i4 + 100];
        if (i4 > 0) {
            this.A06 = new byte[i4 * i3];
            for (int i5 = 0; i5 < i4; i5++) {
                this.A03[i5] = new C0699Ey(this.A06, i5 * i3);
            }
            return;
        }
        this.A06 = null;
    }

    public final synchronized int A00() {
        return this.A00 * this.A04;
    }

    public final synchronized void A01() {
        if (this.A05) {
            A02(0);
        }
    }

    public final synchronized void A02(int i3) {
        boolean targetBufferSizeReduced = i3 < this.A02;
        this.A02 = i3;
        if (targetBufferSizeReduced) {
            AKT();
        }
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized C0699Ey A49() {
        C0699Ey c0699Ey;
        this.A00++;
        if (this.A01 > 0) {
            C0699Ey[] c0699EyArr = this.A03;
            int i3 = this.A01 - 1;
            this.A01 = i3;
            c0699Ey = (C0699Ey) AbstractC04323y.A01(c0699EyArr[i3]);
            this.A03[this.A01] = null;
        } else {
            c0699Ey = new C0699Ey(new byte[this.A04], 0);
            if (this.A00 > this.A03.length) {
                this.A03 = (C0699Ey[]) Arrays.copyOf(this.A03, this.A03.length * 2);
            }
        }
        return c0699Ey;
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final int A8I() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AHd(C0699Ey c0699Ey) {
        C0699Ey[] c0699EyArr = this.A03;
        int i3 = this.A01;
        this.A01 = i3 + 1;
        c0699EyArr[i3] = c0699Ey;
        this.A00--;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AHe(InterfaceC0700Ez interfaceC0700Ez) {
        while (interfaceC0700Ez != null) {
            C0699Ey[] c0699EyArr = this.A03;
            int i3 = this.A01;
            this.A01 = i3 + 1;
            c0699EyArr[i3] = interfaceC0700Ez.A6u();
            this.A00--;
            interfaceC0700Ez = interfaceC0700Ez.ACc();
        }
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AKT() {
        int iA05 = C5C.A05(this.A02, this.A04);
        int targetAllocationCount = this.A00;
        int iMax = Math.max(0, iA05 - targetAllocationCount);
        int targetAllocationCount2 = this.A01;
        if (iMax >= targetAllocationCount2) {
            return;
        }
        if (this.A06 != null) {
            int lowIndex = 0;
            int targetAllocationCount3 = this.A01;
            int highIndex = targetAllocationCount3 - 1;
            while (lowIndex <= highIndex) {
                C0699Ey highAllocation = (C0699Ey) AbstractC04323y.A01(this.A03[lowIndex]);
                if (highAllocation.A01 == this.A06) {
                    lowIndex++;
                } else {
                    C0699Ey lowAllocation = (C0699Ey) AbstractC04323y.A01(this.A03[highIndex]);
                    if (lowAllocation.A01 != this.A06) {
                        highIndex--;
                    } else {
                        this.A03[lowIndex] = lowAllocation;
                        int targetAllocationCount4 = highIndex - 1;
                        this.A03[highIndex] = highAllocation;
                        highIndex = targetAllocationCount4;
                        lowIndex++;
                    }
                }
            }
            iMax = Math.max(iMax, lowIndex);
            int targetAllocationCount5 = this.A01;
            if (iMax >= targetAllocationCount5) {
                return;
            }
        }
        C0699Ey[] c0699EyArr = this.A03;
        int targetAvailableCount = this.A01;
        Arrays.fill(c0699EyArr, iMax, targetAvailableCount, (Object) null);
        this.A01 = iMax;
    }
}
