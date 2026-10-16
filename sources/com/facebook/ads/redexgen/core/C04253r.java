package com.facebook.ads.redexgen.core;

import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C04253r extends E2 {
    public static byte[] A01;
    public final /* synthetic */ C04243q A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-63, -43, -60, -55, -49};
    }

    public C04253r(C04243q c04243q) {
        this.A00 = c04243q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.UN
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(E3 e3) {
        if (this.A00.A00 == null || this.A00.A00.get() == null) {
            this.A00.A00 = new WeakReference(new C1548f6(this));
        }
        ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 71))).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) this.A00.A00.get(), 3, 1);
    }
}
