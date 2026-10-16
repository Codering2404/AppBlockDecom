package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.62, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass62 extends FrameLayout implements InterfaceC0795Is {
    public static byte[] A0A;
    public static String[] A0B = {"cNW8ZlUzhquZSz6XSi", "gKIjGDOIeaOzZR9qeyStr8duZ", "mQKfIuNnQZgt5ES8sx19fjwTYxycx0Lp", "WvoZHe7VElSdYX15O8PPMcOC5YskUK4l", "BfRVnLJiFu3hDnD", "WxgvJAZOXh", "crPtNK55mSnLeOXFeJGYeBq3ABMrpYK", "K6RBlZSEjGoukPcRXJY4znE0whNpCjIj"};
    public C1593fp A00;
    public final int A01;
    public final AbstractC1813jd A02;
    public final C1648gi A03;
    public final VA A04;
    public final Y2 A05;
    public final InterfaceC1421d1 A06;
    public final C1432dC A07;
    public final String A08;
    public final boolean A09;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{100, 70, 73, 0, 83, 7, 84, 83, 70, 85, 83, 7, 102, 82, 67, 78, 66, 73, 68, 66, 105, 66, 83, 80, 72, 85, 76, 102, 68, 83, 78, 81, 78, 83, 94, 9, 7, 106, 70, 76, 66, 7, 84, 82, 85, 66, 7, 83, 79, 70, 83, 7, 78, 83, 0, 84, 7, 78, 73, 7, 94, 72, 82, 85, 7, 102, 73, 67, 85, 72, 78, 67, 106, 70, 73, 78, 65, 66, 84, 83, 9, Framer.STDIN_REQUEST_FRAME_PREFIX, 74, 75, 7, 65, 78, 75, 66, 9, Ascii.CAN, Ascii.FS, Ascii.US, 43, 58, 55, 59, 48, 61, 59, Ascii.DLE, 59, 42, 41, Framer.STDOUT_FRAME_PREFIX, 44, 53, 69, 74, 123, 69, 71, 80, 77, 82, 77, 80, 93, 4, Ascii.VT, Ascii.SO, 4, Ascii.FF, 56, Ascii.DC4, 8, Ascii.DC2, Ascii.NAK, 4, 2, 90, 85, 64, 93, 66, 81, 117, 80, 112, 85, 64, 85, 118, 65, 90, 80, 88, 81, Ascii.ESC, Ascii.GS, Ascii.VT, Ascii.FS, Ascii.CR, 2, 7, Ascii.CR, 5, Ascii.SYN, 9, 5, Ascii.ETB, 52, Ascii.EM, Ascii.DLE, 5};
    }

    static {
        A02();
    }

    public AnonymousClass62(C1648gi c1648gi, VA va, InterfaceC1421d1 interfaceC1421d1, AbstractC1813jd abstractC1813jd, String str, int i3, Y2 y2) {
        super(c1648gi);
        this.A03 = c1648gi;
        this.A04 = va;
        this.A02 = abstractC1813jd;
        this.A08 = str;
        this.A06 = interfaceC1421d1;
        this.A01 = i3;
        C1432dC preloadedDynamicWebViewController = AbstractC1433dD.A02(abstractC1813jd.A1D());
        if (preloadedDynamicWebViewController != null) {
            this.A07 = preloadedDynamicWebViewController;
            this.A09 = true;
        } else {
            this.A07 = new C1432dC(this.A03, abstractC1813jd, va, i3);
            AbstractC1433dD.A03(abstractC1813jd, this.A07);
            this.A09 = false;
        }
        if (y2 != null) {
            this.A05 = y2;
            this.A07.A0Z(y2);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new JJ(this));
        this.A07.A0a(interfaceC1421d1);
        EnumC1158Xc.A04(this, EnumC1158Xc.A0B);
        if (C1098Up.A1z(c1648gi)) {
            c1648gi.A0B().AKp(this.A07.A0O(), abstractC1813jd.A2E(), false, false, true);
        }
        A04();
    }

    private final void A03() {
        this.A07.A0d(this);
        if (!this.A09) {
            this.A03.A0F().A66();
            this.A07.A0X();
        } else {
            this.A03.A0F().A67();
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    if (this.A06 != null) {
                        this.A06.ADm(this);
                    }
                    if (C1098Up.A1z(this.A03)) {
                        VM vmA0B = this.A03.A0B();
                        if (A0B[1].length() != 25) {
                            throw new RuntimeException();
                        }
                        A0B[5] = "";
                        vmA0B.ADb();
                    }
                } else {
                    AKD();
                }
            }
        }
        A08();
    }

    private final void A04() {
        C1432dC.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC1813jd abstractC1813jd) {
        intent.putExtra(A01(157, 8, 110), WK.A07);
        intent.putExtra(A01(130, 18, 58), abstractC1813jd);
        intent.addFlags(268435456);
    }

    private final void A06(AbstractC1813jd abstractC1813jd) {
        AdActivityIntent adActivityIntentA05 = C1152Wu.A05(this.A03);
        A05(adActivityIntentA05, abstractC1813jd);
        try {
            C1152Wu.A0B(this.A03, adActivityIntentA05);
        } catch (Exception e3) {
            this.A03.A08().ABC(A01(107, 11, 42), AbstractC1060Td.A0D, new C1061Te(e3));
            Log.e(A01(90, 17, 80), A01(0, 90, 41), e3);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1327bV c1327bV = new C1327bV(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A2A());
        HashMap map = new HashMap();
        map.put(A01(118, 12, 105), A01(148, 9, 96));
        c1327bV.A05(this.A02.A2E(), str, map);
    }

    public final void A08() {
        YB.A0J(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void A9f() {
        A07(this.A02.A29().A0J().A05());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void A9g(String str) {
        A07(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void A9k() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AAm() {
        new Handler(Looper.getMainLooper()).post(new JF(this));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AE0() {
        A06(this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AE4() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AEu(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AFz() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AGX(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AGZ(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AGo(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void AKD() {
        if (this.A06 != null) {
            this.A06.ADm(this);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0795Is
    public final void close() {
    }

    public VA getAdEventManager() {
        return this.A04;
    }

    public C1432dC getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(C1593fp c1593fp) {
        this.A00 = c1593fp;
        this.A07.A0e(c1593fp);
    }
}
