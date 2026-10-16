package com.facebook.ads.redexgen.core;

import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1292aw extends RelativeLayout {
    public static InterfaceC1189Yh A05;
    public static byte[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public AbstractC1696hU A00;
    public C1648gi A01;
    public C0w A02;
    public M1 A03;
    public C1341bj A04;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{2, 32, 51, 46, 52, Framer.STDERR_FRAME_PREFIX, 36, Framer.STDIN_FRAME_PREFIX, 97, Ascii.SI, 32, 53, 40, 55, 36, 97, 55, 40, 36, 54, 97, 32, 37, 36, Framer.STDOUT_FRAME_PREFIX, 53, 36, 51, 97, 40, Framer.STDERR_FRAME_PREFIX, 47, 102, 53, 97, 34, 51, 36, 32, 53, 36, 37, 97, Framer.STDOUT_FRAME_PREFIX, 51, 46, Framer.STDOUT_FRAME_PREFIX, 36, 51, Framer.STDIN_FRAME_PREFIX, 56, 67, 65, 74, 65, 86, 77, 71};
    }

    static {
        A02();
        A08 = XV.A0v;
        A07 = A08 * 10;
        A09 = (int) (XX.A02 * 15.0f);
        A05 = new C0876Lv();
    }

    public C1292aw(C1648gi c1648gi) {
        super(c1648gi);
        this.A01 = c1648gi;
        this.A02 = new C0w(c1648gi);
        YB.A0K(this.A02);
        this.A00 = new C7N();
        this.A00.A0G(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
    }

    private ArrayList<C1486e5> A01(AbstractC1813jd abstractC1813jd) {
        if (abstractC1813jd == null) {
            return new ArrayList<>();
        }
        List<NR> listA2G = abstractC1813jd.A2G();
        ArrayList<C1486e5> arrayList = new ArrayList<>(listA2G.size());
        for (int i3 = 0; i3 < listA2G.size(); i3++) {
            arrayList.add(new C1486e5(i3, listA2G.size(), listA2G.get(i3)));
        }
        return arrayList;
    }

    public final void A04() {
        this.A02.setAdapter(null);
    }

    public final void A05(UK uk, int i3) {
        ArrayList<C1486e5> arrayListA01 = A01(uk.A13());
        this.A02.setCardsInfo(arrayListA01);
        this.A03 = new M1(this.A01, arrayListA01, uk.A13(), this.A01.A02().A0A(), uk, A05, uk.A13().A2E(), this.A02.getCarouselCardBehaviorHelper(), null);
        this.A02.setAdapter(this.A03);
        if (i3 == 0) {
            i3 = XX.A04.widthPixels;
        }
        this.A03.A0O(i3 - A07, 16, 0);
        this.A03.A0G();
        setupDotsLayout(uk, arrayListA01);
    }

    public final void A06(C1593fp c1593fp) {
        if (this.A03 != null) {
            this.A03.A0P(c1593fp);
        } else {
            this.A01.A08().ABC(A00(51, 7, 24), AbstractC1060Td.A1v, new C1061Te(A00(0, 51, 125)));
        }
        this.A02.A20(c1593fp);
    }

    public static InterfaceC1189Yh getDummyListener() {
        return A05;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (z2 && this.A03 != null) {
            this.A03.A0O((i5 - i3) - A07, 16, 0);
        }
        super.onLayout(z2, i3, i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpLayoutForCardAtIndex(int i3) {
        if (this.A04 != null) {
            this.A04.A00(i3);
        }
    }

    private void setupDotsLayout(UK uk, ArrayList<C1486e5> arrayList) {
        this.A02.getCarouselCardBehaviorHelper().A0Y(new C0873Ls(this));
        this.A04 = new C1341bj(this.A01, uk.A13().A28().A01(), arrayList.size());
        YB.A0K(this.A04);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A02.getId());
        layoutParams.setMargins(0, A09, 0, 0);
        addView(this.A04, layoutParams);
    }
}
