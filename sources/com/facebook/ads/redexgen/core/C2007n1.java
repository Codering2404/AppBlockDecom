package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2007n1 implements G5, DisplayManager.DisplayListener {
    public static byte[] A02;
    public G4 A00;
    public final DisplayManager A01;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{Ascii.SI, Ascii.DC4, Ascii.RS, Ascii.ESC, Ascii.ETB, Ascii.FF, 36};
    }

    public C2007n1(DisplayManager displayManager) {
        this.A01 = displayManager;
    }

    private Display A00() {
        return this.A01.getDisplay(0);
    }

    public static C2007n1 A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 65));
        if (displayManager != null) {
            return new C2007n1(displayManager);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.G5
    public final void AHX(G4 g4) {
        this.A00 = g4;
        this.A01.registerDisplayListener(this, C5C.A0Y());
        g4.ADd(A00());
    }

    @Override // com.facebook.ads.redexgen.core.G5
    public final void AKW() {
        this.A01.unregisterDisplayListener(this);
        this.A00 = null;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i3) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i3) {
        if (this.A00 != null && i3 == 0) {
            this.A00.ADd(A00());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i3) {
    }
}
