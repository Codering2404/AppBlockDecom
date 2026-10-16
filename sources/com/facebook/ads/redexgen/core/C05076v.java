package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05076v extends C1718hr {
    public static String[] A08 = {"3Z4oVcBXIxTGfHDkJENHcNR3oKWZn0O4", "rFv82zPhlr6ageKpcxYW53i7WQEhI", "2tYR0SC80tVMegpE61nD", "NxUbiyfiYIyXyrFLuBvPtjT94e88s", "0hjSAQsR9gnR7LOOW", "3YJcpQnZmcsLDiaVOnEQeEpmcgGPkAOH", "Bqc2ZUTwiywYobMvaWapE1roD64Q2E5u", "7wlgBc9wtLyqXjV7RP"};
    public float A00;
    public int A01;
    public int A02;
    public C05086w A03;
    public int[] A04;
    public final C1648gi A05;
    public final C1480dz A06;
    public final C1481e0 A07;

    public C05076v(C1648gi c1648gi, C1481e0 c1481e0, C1480dz c1480dz) {
        super(c1648gi);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c1648gi;
        this.A07 = c1481e0;
        this.A06 = c1480dz;
        this.A01 = -1;
        this.A03 = new C05086w(this, this.A05);
    }

    @Override // com.facebook.ads.redexgen.core.R2
    public final void A1L(RA ra, RH rh, int i3, int widthMode) {
        int[] iArrA02;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(widthMode);
        if ((mode == 1073741824 && A28() == 1) || (mode2 == 1073741824 && A28() == 0)) {
            super.A1L(ra, rh, i3, widthMode);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(widthMode);
        if (this.A06.A01(this.A01)) {
            iArrA02 = this.A06.A02(this.A01);
        } else {
            iArrA02 = new int[]{0, 0};
            if (rh.A03() >= 1) {
                int i4 = A0Y() > 0 ? 1 : A0Y();
                for (int heightMode = 0; heightMode < i4; heightMode++) {
                    View viewA1o = A1o(heightMode);
                    if (viewA1o == null) {
                        break;
                    }
                    this.A04 = this.A07.A00(viewA1o, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (A28() == 0) {
                        iArrA02[0] = iArrA02[0] + this.A04[0];
                        if (heightMode == 0) {
                            iArrA02[1] = this.A04[1] + A0i() + A0f();
                        }
                    } else {
                        iArrA02[1] = iArrA02[1] + this.A04[1];
                        if (heightMode == 0) {
                            iArrA02[0] = this.A04[0] + A0g() + A0h();
                        }
                    }
                }
                int i5 = this.A01;
                String[] strArr = A08;
                if (strArr[1].length() != strArr[3].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[0] = "c7gaApi93PYPuTyj4vut3Dl9rZW6DyZw";
                strArr2[7] = "eCokdcVdwhThfuMVf9";
                if (i5 != -1) {
                    this.A06.A00(this.A01, iArrA02);
                }
            }
        }
        if (mode == 1073741824) {
            iArrA02[0] = size;
        }
        if (mode2 == 1073741824) {
            iArrA02[1] = size2;
        }
        A15(iArrA02[0], iArrA02[1]);
    }

    @Override // com.facebook.ads.redexgen.core.C1718hr, com.facebook.ads.redexgen.core.R2
    public final void A1r(int i3) {
        A2D(i3, this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.C1718hr, com.facebook.ads.redexgen.core.R2
    public final void A1z(C7M c7m, RH rh, int i3) {
        this.A03.A0A(i3);
        A1N(this.A03);
    }

    public final void A2I(double d3) {
        if (d3 <= 0.0d) {
            d3 = 1.0d;
        }
        this.A00 = (float) (50.0d / d3);
        this.A03 = new C05086w(this, this.A05);
    }

    public final void A2J(int i3) {
        this.A01 = i3;
    }

    public final void A2K(int i3) {
        this.A02 = i3;
    }
}
