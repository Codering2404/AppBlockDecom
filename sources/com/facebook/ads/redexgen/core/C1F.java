package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C1F extends C7M implements View.OnTouchListener {
    public static byte[] A07;
    public static String[] A08 = {"ySOBxSJ7y2GELC2cR9WRTK6hAhZYocJS", "8dRmuXbfMCidMDGiSpjEcbCkPgx3mm8G", "li61zS9WhZTBvI47lvKtLPcqAcNkij1S", "lH5BfkXLxOyhi", "q0Ccq4Fbg7VKO8sxkIKNcZgKtjQ1fZ14", "ep7ggC7RKpg7Ol5cXUmXF8JhcfOkgUip", "fpgtpMAGWAVh3a0xLZP1kWTjCGk3An57", "s5"};
    public int A00;

    @Nullable
    public C1718hr A01;
    public InterfaceC1483e2 A02;
    public boolean A03;
    public boolean A04;
    public int A05;
    public final int A06;

    public static String A09(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-4, Ascii.ETB, 10, Ascii.EM, -5, Ascii.SO, Ascii.FF, 34, Ascii.FF, Ascii.NAK, Ascii.SO, Ascii.ESC, -1, Ascii.DC2, Ascii.SO, 32, -55, Ascii.CAN, Ascii.ETB, Ascii.NAK, 34, -55, Ascii.FS, Ascii.RS, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.ESC, Ascii.GS, Ascii.FS, -55, -11, Ascii.DC2, Ascii.ETB, Ascii.SO, 10, Ascii.ESC, -11, 10, 34, Ascii.CAN, Ascii.RS, Ascii.GS, -10, 10, Ascii.ETB, 10, Ascii.DLE, Ascii.SO, Ascii.ESC};
    }

    static {
        A0A();
    }

    public C1F(C1648gi c1648gi) {
        super(c1648gi);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C1F(C1648gi c1648gi, AttributeSet attributeSet) {
        super(c1648gi, attributeSet);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C1F(C1648gi c1648gi, AttributeSet attributeSet, int i3) {
        super(c1648gi, attributeSet, i3);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    private int A05() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int A06(int i3) {
        int delta = this.A00 - i3;
        int iA8o = this.A02.A8o(delta);
        int scrollX = this.A06;
        if (delta > scrollX) {
            int scrollX2 = this.A05;
            return A08(scrollX2, iA8o);
        }
        int scrollX3 = this.A06;
        if (delta < (-scrollX3)) {
            int i4 = this.A05;
            if (A08[6].charAt(24) != 67) {
                throw new RuntimeException();
            }
            A08[7] = "Vh4";
            int scrollX4 = A07(i4, iA8o);
            return scrollX4;
        }
        int scrollX5 = this.A05;
        return scrollX5;
    }

    private int A07(int i3, int i4) {
        return Math.max(i3 - i4, 0);
    }

    private int A08(int i3, int i4) {
        return Math.min(i3 + i4, getItemCount() - 1);
    }

    public void A20(int i3, boolean z2) {
        if (getAdapter() == null) {
            return;
        }
        this.A05 = i3;
        if (z2) {
            A1Y(i3);
        } else {
            A1X(i3);
        }
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().A0B();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 6 && actionMasked != 3) {
            int action = A08[7].length();
            if (action == 18) {
                throw new RuntimeException();
            }
            A08[4] = "tIjSEqZVzrzr7cEE0p57iZetopRejSVd";
            if (actionMasked != 4) {
                if (actionMasked == 0 || actionMasked == 5 || (this.A03 && actionMasked == 2)) {
                    this.A00 = rawX;
                    if (this.A03) {
                        this.A03 = false;
                    }
                    this.A04 = true;
                }
                return false;
            }
        }
        if (this.A04) {
            int rawX2 = A06(rawX);
            A20(rawX2, true);
        }
        this.A03 = true;
        this.A04 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.C7M
    public void setLayoutManager(R2 r2) {
        if (r2 instanceof C1718hr) {
            super.setLayoutManager(r2);
            this.A01 = (C1718hr) r2;
            return;
        }
        throw new IllegalArgumentException(A09(0, 50, 59));
    }

    public void setSnapDelegate(InterfaceC1483e2 interfaceC1483e2) {
        this.A02 = interfaceC1483e2;
    }
}
