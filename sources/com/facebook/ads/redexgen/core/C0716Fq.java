package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0716Fq extends RK implements InterfaceC1196Yo {
    public static String[] A08 = {"biNTtjxa0xULALtZEUOcP", "rMVpYr4hwZgX", "y0rebd1hOaNR", "snwXdVXwO66aPvNuuMD2", "jxkMgVVp1g5", "Dcah1JX", "lglxOXHbCZFpcLf1TWQPAMUDis4zLCZx", "n80A5ryznQOlcAJIvKv7FeLq2ck19EHB"};
    public C0912Ng A00;
    public AbstractC1592fo A01;
    public C1593fp A02;
    public C1593fp A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final C1648gi A06;
    public final C6M A07;

    public C0716Fq(C6M c6m, SparseBooleanArray sparseBooleanArray, C1593fp c1593fp, int i3, C1648gi c1648gi, C0912Ng c0912Ng) {
        super(c6m);
        this.A06 = c1648gi;
        this.A07 = c6m;
        this.A05 = sparseBooleanArray;
        this.A02 = c1593fp;
        this.A04 = i3;
        this.A00 = c0912Ng;
    }

    private void A05(VA va, Y2 y2, String str, C1486e5 c1486e5) {
        if (this.A05.get(c1486e5.A02())) {
            return;
        }
        if (this.A03 != null) {
            this.A03.A0V();
            String[] strArr = A08;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "sEemyGdXpNnP2WRBMWcD";
            strArr2[0] = "kawPFcVLuq3VyedHvbBIc";
            this.A03 = null;
        }
        this.A01 = new C0718Fs(this, str, c1486e5, va, c1486e5.A04(), y2);
        this.A03 = new C1593fp(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new C0717Fr(this, c1486e5));
    }

    public final void A0p(C1486e5 c1486e5, VA va, C1054Sx c1054Sx, Y2 y2, String str, int i3, int i4, int i5) {
        int iA02 = c1486e5.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(iA02));
        this.A07.setupNativeCtaExtension(c1486e5);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, -2);
        int rightMargin = iA02 == 0 ? i5 : i4;
        if (iA02 < this.A04 - 1) {
            i5 = i4;
        }
        String[] strArr = A08;
        if (strArr[1].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[1] = "ng4t5bAKqCWK";
        strArr2[2] = "n9xBZs9SEWUc";
        marginLayoutParams.setMargins(rightMargin, 0, i5, 0);
        String strA08 = c1486e5.A03().A0H().A08();
        String strA09 = c1486e5.A03().A0H().A09();
        this.A07.setIsVideo(!TextUtils.isEmpty(strA09));
        if (this.A07.A1V()) {
            this.A07.setVideoPlaceholderUrl(strA08);
            this.A07.setVideoUrl(c1054Sx.A0T(strA09));
        } else {
            this.A07.setImageUrl(strA08);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(c1486e5.A03().A0J(), c1486e5.A04());
        this.A07.A1W(c1486e5.A04());
        A05(va, y2, str, c1486e5);
    }

    public final void A0q(C1593fp c1593fp) {
        this.A02 = c1593fp;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1196Yo
    public final void AJF() {
        this.A07.A1Q();
    }
}
