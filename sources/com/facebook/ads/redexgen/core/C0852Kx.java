package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0852Kx implements XN {
    public static byte[] A0B;
    public int A00;
    public int A01;
    public int A02;
    public AbstractC1183Yb A03;
    public String A04;
    public String A05;
    public ViewOnClickListenerC0846Kr A06;
    public boolean A0A = false;
    public boolean A09 = false;
    public boolean A08 = false;
    public Integer A07 = null;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0B = new byte[]{78, 102, 112, 118, 102, 72, 117, 97, 96, 123, 119, Framer.EXIT_FRAME_PREFIX, 125, 119, Ascii.DEL};
    }

    public C0852Kx(int i3, int i4, int i5, String str, String str2, AbstractC1183Yb abstractC1183Yb, ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        this.A01 = i3;
        this.A00 = i4;
        this.A02 = i5;
        this.A05 = str;
        this.A04 = str2;
        this.A03 = abstractC1183Yb;
        this.A06 = viewOnClickListenerC0846Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (this.A08) {
            A04();
        }
    }

    public final synchronized void A04() {
        if (this.A09) {
            return;
        }
        this.A09 = true;
        if (this.A01 == 1 && this.A03 != null) {
            this.A03.setProgressImage(null);
            this.A03.setProgressClickListener(null);
            this.A03.setToolbarActionMessage(A00(0, 0, 66));
            this.A03.A0A();
            if (this.A07 != null) {
                this.A03.setToolbarActionMode(this.A07.intValue());
            }
            if (this.A06.getColorInfo() != null) {
                this.A03.A0D(this.A06.getColorInfo(), false);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final synchronized void ADS() {
        if (!this.A09) {
            this.A06.A0E(A00(6, 9, 101));
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final synchronized void AFV(float f3) {
        if (!this.A09 && this.A03 != null) {
            if (this.A01 == 1) {
                if (!this.A0A) {
                    this.A07 = Integer.valueOf(this.A03.getToolbarActionMode());
                    this.A03.setProgressClickListener(new ViewOnClickListenerC1319bN(this));
                    this.A03.A0B();
                    this.A03.setToolbarListener(new LB(this));
                    this.A0A = true;
                    if (this.A07 == null || this.A07.intValue() == 4) {
                        this.A03.setToolbarActionMode(5);
                    } else {
                        this.A03.setToolbarActionMode(6);
                    }
                }
                if (f3 <= this.A02) {
                    if (!this.A08) {
                        this.A08 = true;
                        if (this.A07 == null || this.A07.intValue() == 4) {
                            this.A03.setToolbarActionMode(7);
                        } else {
                            this.A03.setProgressImage(YM.CROSS);
                            this.A03.setToolbarActionMode(6);
                        }
                    }
                    this.A03.setToolbarActionMessage(this.A04.replace(A00(0, 6, 100), String.valueOf((int) Math.ceil(f3))));
                } else {
                    this.A03.setToolbarActionMessage(this.A05);
                }
            }
        }
    }
}
