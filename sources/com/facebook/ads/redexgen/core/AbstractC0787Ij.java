package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ij, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0787Ij extends RelativeLayout implements XQ {
    public static byte[] A0E;
    public static String[] A0F = {"uUMDphsbcltlMAasrXzhzXIIsD27sBrh", "kD4ASPr1mkkPPQg7686pKphnCznMXNdE", "3u4w9tHTXiQc09zCQQwrpogVyGpuea0B", "uLxjLzdSNqmjg5WlrsUTBNxe2IHJHDsH", "sowIyJkgs7pChNHWV216bYY5IvqkL5", "woZqrf3JBfr8DagdWcXdOyEt75sBOiDm", "mZPGIv6MosabarlDevuwzM4J02qRjqBR", "rZe00TaCIEKWr55DYJNI366SEGcMY1oV"};
    public static final int A0G;
    public String A00;
    public boolean A01;
    public final int A02;
    public final AbstractC1592fo A03;
    public final boolean A04;
    public final boolean A05;
    public final AbstractC1813jd A06;
    public final C1648gi A07;
    public final VA A08;
    public final XS A09;
    public final Y2 A0A;
    public final InterfaceC1189Yh A0B;
    public final ZU A0C;
    public final C1593fp A0D;

    public static String A19(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A1A() {
        A0E = new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.DLE, Ascii.EM, Framer.STDIN_REQUEST_FRAME_PREFIX, 5, 32, 100};
        if (A0F[4].length() == 22) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[2] = "lGg0879wdsNhw7V1Qtd20OQ8gEXobd5O";
        strArr[0] = "a2lydBkKvgM6UKG9QoQR6B5cBx9Kev1F";
    }

    public abstract EnumC0897Mq A1D(String str);

    public abstract void A1G();

    public abstract void A1H();

    public abstract void A1J(boolean z2);

    public abstract void A1K(boolean z2);

    public abstract boolean A1L();

    public abstract boolean A1M();

    public abstract boolean A1N();

    public abstract C1466dk getFullScreenAdStyle();

    static {
        A1A();
        A0G = (int) (XX.A02 * 80.0f);
    }

    public AbstractC0787Ij(C1648gi c1648gi, ZU zu, VA va, AbstractC1813jd abstractC1813jd, int i3, boolean z2, boolean z3, InterfaceC1189Yh interfaceC1189Yh, int i4) {
        super(c1648gi);
        this.A0A = new Y2();
        this.A01 = false;
        this.A00 = A19(0, 0, 48);
        this.A03 = new C0791In(this);
        this.A02 = i3;
        this.A07 = c1648gi;
        this.A05 = z2;
        this.A04 = z3;
        this.A0B = interfaceC1189Yh;
        this.A0C = zu;
        this.A06 = abstractC1813jd;
        this.A08 = va;
        this.A0D = new C1593fp(this, 1, new WeakReference(this.A03), c1648gi);
        this.A0D.A0W(abstractC1813jd.A0m());
        this.A0D.A0X(abstractC1813jd.A0n());
        this.A09 = XS.A00(this.A07, this.A06, this);
        if (this.A06.A1c()) {
            this.A00 = A18(this.A02, i4);
        }
    }

    public static String A18(int i3, int i4) {
        return A19(4, 3, 9) + (i3 + 1) + A19(0, 4, 50) + i4;
    }

    public void A1E() {
        this.A09.A03();
    }

    public final void A1F() {
        if (!this.A01) {
            this.A0D.A0U();
            this.A01 = true;
        }
    }

    public void A1I(boolean z2) {
    }

    public AbstractC1813jd getAdDataBundle() {
        return this.A06;
    }

    public C1593fp getAdViewabilityChecker() {
        return this.A0D;
    }

    public Y2 getTouchDataRecorder() {
        return this.A0A;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
