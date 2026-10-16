package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.WindowManager;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2008n2 implements G5 {
    public static byte[] A01;
    public final WindowManager A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-7, -21, -16, -26, -15, -7};
    }

    public C2008n2(WindowManager windowManager) {
        this.A00 = windowManager;
    }

    public static C2008n2 A00(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(A01(0, 6, 15));
        if (windowManager != null) {
            return new C2008n2(windowManager);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.G5
    public final void AHX(G4 g4) {
        g4.ADd(this.A00.getDefaultDisplay());
    }

    @Override // com.facebook.ads.redexgen.core.G5
    public final void AKW() {
    }
}
