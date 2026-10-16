package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0x, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0x extends C1F implements InterfaceC1483e2 {
    public static byte[] A07;
    public static String[] A08 = {"J7yX0QGw9CwhbXJlOgK1AZPNtt2UF0On", "oXMSY1TARkqssgt6s8jHvILUEU9", "ivvOLLZvAzFcQQYEM", "46hEJr0dkjUa2YxjnqHHZtVzHBYgDtfX", "qOyhICr4SrTKnx9gG6JsVKrXp45uLK", "kbgvhlczlSdLn8qANYfrfCagYhnCySOb", "Z6RoLzaVoBLmlhzvAeWOPUTl5laN13sF", "YB9cTMd7bVO"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public InterfaceC1200Ys A04;
    public boolean A05;
    public final C05076v A06;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 46);
            if (A08[0].charAt(21) != 'Z') {
                throw new RuntimeException();
            }
            A08[3] = "76s3uTgYoGqvxE8PFJZmOuk3NB8C1jhQ";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-68, -69, -99, -82, -76, -78, -112, -75, -82, -69, -76, -78, -79};
    }

    static {
        A03();
    }

    public C0x(C1648gi c1648gi) {
        super(c1648gi);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C05076v(c1648gi, new C1481e0(), new C1480dz());
        A02();
    }

    public C0x(C1648gi c1648gi, AttributeSet attributeSet) {
        super(c1648gi, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C05076v(c1648gi, new C1481e0(), new C1480dz());
        A02();
    }

    public C0x(C1648gi c1648gi, AttributeSet attributeSet, int i3) {
        super(c1648gi, attributeSet, i3);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C05076v(c1648gi, new C1481e0(), new C1480dz());
        A02();
    }

    private int A00(int i3) {
        int i4 = this.A00 * 2;
        int measuredWidth = getMeasuredWidth();
        int spacing = getPaddingLeft();
        int i5 = (measuredWidth - spacing) - i4;
        int itemSize = getAdapter().A0B();
        int numFullItems = 0;
        int spacing2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        while (spacing2 > i3) {
            numFullItems++;
            if (numFullItems >= itemSize) {
                return i3;
            }
            int spacing3 = numFullItems * i4;
            spacing2 = (int) ((i5 - spacing3) / (numFullItems + 0.333f));
        }
        return spacing2;
    }

    private void A02() {
        this.A06.A2C(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        YB.A0K(this);
    }

    private void A04(int i3, int i4) {
        if (i3 == this.A03 && i4 == this.A02) {
            return;
        }
        this.A03 = i3;
        this.A02 = i4;
        if (A08[3].charAt(25) != 'B') {
            throw new RuntimeException();
        }
        A08[2] = "arB2ao";
        if (0 != 0) {
            throw new NullPointerException(A01(0, 13, 31));
        }
    }

    @Override // com.facebook.ads.redexgen.core.C1F
    public final void A20(int i3, boolean z2) {
        super.A20(i3, z2);
        A04(i3, 0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1483e2
    public final int A8o(int i3) {
        int iAbs = Math.abs(i3);
        int scrollXAbs = ((C1F) this).A06;
        if (iAbs <= scrollXAbs) {
            return 0;
        }
        int scrollXAbs2 = this.A01;
        if (scrollXAbs2 == 0) {
            return 1;
        }
        int scrollXAbs3 = this.A01;
        return 1 + (iAbs / scrollXAbs3);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.C7M, android.view.View
    public final void onMeasure(int i3, int i4) {
        int height;
        int itemSize;
        super.onMeasure(i3, i4);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A05) {
            int i5 = (int) XX.A02;
            int verticalPadding = C1098Up.A0F(getContext());
            height = (i5 * verticalPadding) + paddingTop;
        } else {
            int verticalPadding2 = getMeasuredWidth();
            height = Math.round(verticalPadding2 / 1.91f);
        }
        int verticalPadding3 = View.MeasureSpec.getMode(i4);
        switch (verticalPadding3) {
            case Integer.MIN_VALUE:
                int verticalPadding4 = View.MeasureSpec.getSize(i4);
                height = Math.min(verticalPadding4, height);
                break;
            case 1073741824:
                height = View.MeasureSpec.getSize(i4);
                break;
        }
        int height2 = height - paddingTop;
        if (this.A05) {
            int verticalPadding5 = C1195Yn.A09;
            itemSize = Math.min(verticalPadding5, height2);
        } else {
            itemSize = A00(height2);
        }
        int height3 = getMeasuredWidth();
        int verticalPadding6 = itemSize + paddingTop;
        setMeasuredDimension(height3, verticalPadding6);
        if (!this.A05) {
            int verticalPadding7 = this.A00;
            setChildWidth((verticalPadding7 * 2) + itemSize);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C7M
    public void setAdapter(AbstractC0996Qq abstractC0996Qq) {
        this.A06.A2J(abstractC0996Qq == null ? -1 : abstractC0996Qq.hashCode());
        super.setAdapter(abstractC0996Qq);
    }

    public void setChildSpacing(int i3) {
        this.A00 = i3;
    }

    public void setChildWidth(int i3) {
        this.A01 = i3;
        int measuredWidth = getMeasuredWidth();
        int pageWidth = getPaddingLeft();
        int i4 = measuredWidth - pageWidth;
        int pageWidth2 = getPaddingRight();
        int i5 = i4 - pageWidth2;
        C05076v c05076v = this.A06;
        int pageWidth3 = this.A01;
        c05076v.A2K((i5 - pageWidth3) / 2);
        C05076v c05076v2 = this.A06;
        int pageWidth4 = this.A01;
        c05076v2.A2I(((double) pageWidth4) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i3) {
        A20(i3, false);
    }

    public void setOnPageChangedListener(InterfaceC1200Ys interfaceC1200Ys) {
        this.A04 = interfaceC1200Ys;
    }

    public void setShowTextInCarousel(boolean z2) {
        this.A05 = z2;
    }
}
