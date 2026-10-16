package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0724Fy extends R7 {
    public static byte[] A0H;
    public static String[] A0I = {"oHxG", "", "w7XeyG7wcXlBDThCLG4YobF5JePdGcu8", "IQ8LgqWvoXOpUTXgnww89j6rU6uuZ1nj", "", "WKMwHhIum9", "0nm7H4VWCUBWNiJwCQAonSVvBZFyt", "hLsDwSpuFLAE"};
    public InterfaceC1409cp A02;
    public C1593fp A04;
    public List<C1486e5> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C1718hr A0C;
    public final RF A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final InterfaceC1413ct A0F = new G1(this);
    public InterfaceC1411cr A03 = new G0(this);
    public final InterfaceC1412cs A0E = new C0725Fz(this);

    public static String A05(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        String[] strArr = A0I;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[7] = "Cbp585p0FHy9";
        strArr2[6] = "QC7w158vCCR5KGktiGCBodiqPhNZq";
        A0H = new byte[]{-122, -102, -103, -108, -92, -107, -111, -122, -98, -92, -118, -109, -122, -121, -111, -118, -119, -92, -107, -122, -105, -122, -110, 81, 91, 103, 78, 81, 90, 91, 92, 103, 94, 81, 76, 77, 87, 103, 88, 73, 90, 73, 85, -51, -58, -61, -52, -60, -68, -42, -61, -68, -51, -68, -61, -42, -57, -72, -55, -72, -60};
    }

    static {
        A08();
    }

    public C0724Fy(C1J c1j, int i3, List<C1486e5> list, C1593fp c1593fp, Bundle bundle) {
        this.A0C = c1j.getLayoutManager();
        this.A0A = i3;
        this.A05 = list;
        this.A04 = c1593fp;
        this.A0D = new C1717hq(c1j.getContext());
        this.A0B = c1j.getContext();
        c1j.A1h(this);
        A0D(bundle);
    }

    private AbstractC0809Jg A03(int i3, int i4) {
        return A04(i3, i4, true);
    }

    private AbstractC0809Jg A04(int i3, int i4, boolean z2) {
        AbstractC0809Jg abstractC0809Jg = null;
        while (i3 <= i4) {
            AbstractC0809Jg abstractC0809Jg2 = (AbstractC0809Jg) this.A0C.A1o(i3);
            if (abstractC0809Jg2 == null || abstractC0809Jg2.A1U()) {
                return null;
            }
            boolean zA0a = A0a(abstractC0809Jg2);
            if (abstractC0809Jg == null && abstractC0809Jg2.A1V() && zA0a && !this.A0G.contains(Integer.valueOf(i3)) && (!z2 || A0I(abstractC0809Jg2, this.A0A))) {
                abstractC0809Jg = abstractC0809Jg2;
            }
            if (abstractC0809Jg2.A1V() && !zA0a) {
                A0C(i3, false);
            }
            i3++;
        }
        return abstractC0809Jg;
    }

    private void A06() {
        if (!this.A07) {
            return;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        AbstractC0809Jg abstractC0809JgA03 = A03(lastVisibleItem, firstVisibleItem);
        if (abstractC0809JgA03 != null) {
            abstractC0809JgA03.A1S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA25 = this.A0C.A25();
        if (iA25 != -1) {
            int curPos = this.A05.size();
            if (iA25 < curPos - 1) {
                int curPos2 = iA25 + 1;
                A0U(curPos2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i3) {
        AbstractC0809Jg abstractC0809JgA04 = A04(i3 + 1, this.A0C.A27(), false);
        if (abstractC0809JgA04 != null) {
            abstractC0809JgA04.A1S();
            A0U(((Integer) abstractC0809JgA04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i3, int i4) {
        while (i3 <= i4) {
            A0T(i3);
            i3++;
        }
    }

    private final void A0B(int i3, int i4) {
        A0S(i3);
        A0S(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i3, boolean z2) {
        if (z2) {
            this.A0G.add(Integer.valueOf(i3));
        } else {
            this.A0G.remove(Integer.valueOf(i3));
        }
    }

    private void A0D(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 112), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 62), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 1), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return this.A0A == 1;
    }

    public static boolean A0I(AbstractC1361c3 abstractC1361c3, int i3) {
        int allowedAreaMaxX;
        int furthestX;
        if (i3 == 2) {
            allowedAreaMaxX = XX.A04.widthPixels - 1;
        } else {
            int width = abstractC1361c3.getWidth();
            int allowedAreaMinX = XX.A04.widthPixels;
            allowedAreaMaxX = (int) (((width + allowedAreaMinX) * 1.3f) / 2.0f);
        }
        if (i3 == 2) {
            furthestX = 1;
        } else {
            int i4 = XX.A04.widthPixels;
            int allowedAreaMinX2 = abstractC1361c3.getWidth();
            furthestX = (int) (((i4 - allowedAreaMinX2) * 0.7f) / 2.0f);
        }
        float x2 = abstractC1361c3.getX();
        int allowedAreaMinX3 = abstractC1361c3.getWidth();
        return ((int) (x2 + ((float) allowedAreaMinX3))) <= allowedAreaMaxX && abstractC1361c3.getX() >= ((float) furthestX);
    }

    private boolean A0J(AbstractC0809Jg abstractC0809Jg) {
        if (!this.A08 || !abstractC0809Jg.A1V()) {
            return false;
        }
        this.A08 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public void A0L(C7M c7m, int i3) {
        super.A0L(c7m, i3);
        if (i3 == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public void A0M(C7M c7m, int i3, int i4) {
        super.A0M(c7m, i3, i4);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int lastVisibleItem = this.A0C.A26();
        int firstVisibleItem = this.A0C.A27();
        A0B(lastVisibleItem, firstVisibleItem);
        A0A(lastVisibleItem, firstVisibleItem);
        A0V(lastVisibleItem, firstVisibleItem, i3);
    }

    public final InterfaceC1411cr A0N() {
        return this.A03;
    }

    public final InterfaceC1412cs A0O() {
        return this.A0E;
    }

    public final InterfaceC1413ct A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int iA27 = this.A0C.A27();
        for (int iA26 = this.A0C.A26(); iA26 <= iA27 && iA26 >= 0; iA26++) {
            AbstractC0809Jg card = (AbstractC0809Jg) this.A0C.A1o(iA26);
            String[] strArr = A0I;
            String str = strArr[1];
            String str2 = strArr[4];
            int lastPos = str.length();
            int firstPos = str2.length();
            if (lastPos != firstPos) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[0] = "4n0r";
            strArr2[5] = "UAml839wpr";
            if (card != null && card.A1U()) {
                this.A01 = iA26;
                card.A1R();
                return;
            }
        }
    }

    public final void A0R() {
        AbstractC0809Jg abstractC0809Jg = (AbstractC0809Jg) this.A0C.A1o(this.A01);
        if (abstractC0809Jg != null && this.A01 >= 0) {
            abstractC0809Jg.A1S();
        }
    }

    public final void A0S(int i3) {
        AbstractC0809Jg abstractC0809Jg = (AbstractC0809Jg) this.A0C.A1o(i3);
        if (abstractC0809Jg != null && !A0a(abstractC0809Jg)) {
            A0Z(abstractC0809Jg, false);
        }
    }

    public final void A0T(int i3) {
        AbstractC0809Jg abstractC0809Jg = (AbstractC0809Jg) this.A0C.A1o(i3);
        if (abstractC0809Jg == null) {
            return;
        }
        if (A0a(abstractC0809Jg)) {
            A0Z(abstractC0809Jg, true);
        }
        if (A0J(abstractC0809Jg) && this.A05 != null) {
            this.A0F.setVolume(this.A05.get(((Integer) abstractC0809Jg.getTag(-1593835536)).intValue()).A03().A0H().A0A() ? 0.0f : 1.0f);
        }
    }

    public final void A0U(int i3) {
        this.A0D.A0A(i3);
        this.A0C.A1N(this.A0D);
    }

    public final void A0V(int i3, int i4, int i5) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int recomputeFrom = this.A0C.A25();
        if (recomputeFrom == -1) {
            recomputeFrom = i5 < 0 ? i3 : i4;
        }
        this.A02.AKa(recomputeFrom);
    }

    public final void A0W(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 112), this.A00);
        bundle.putBoolean(A05(0, 23, 62), this.A07);
        bundle.putBoolean(A05(23, 20, 1), this.A08);
    }

    public void A0X(View view, boolean z2) {
        view.setAlpha(z2 ? 1.0f : 0.5f);
    }

    public final void A0Y(InterfaceC1409cp interfaceC1409cp) {
        this.A02 = interfaceC1409cp;
    }

    public void A0Z(AbstractC0809Jg abstractC0809Jg, boolean z2) {
        if (A0H()) {
            A0X(abstractC0809Jg, z2);
        }
        if (!z2 && abstractC0809Jg.A1U()) {
            abstractC0809Jg.A1R();
        }
    }

    public boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}
