package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1004Qy {
    public static byte[] A06;
    public static String[] A07 = {"7", "BOchn05cOqPQPKgaZhD7MWqYHqoCKx7o", "EPTevQXo6AzOyuxFlfcAvx5eJdnVP8", "v", "6fNY9lNhy7nUhuOGP7YDUX6WqdzgNzMN", "SLjIMlZrt8LApw5SyAUFDc4ipDag7tTu", "zXvx6U5xIRhnU3fWG5rnYTWUnq20aSrc", "c4GOdlXhzm3270NA43EFNLoVECdVoF38"};
    public InterfaceC1002Qw A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = (byte) ((bArrCopyOfRange[i6] - i5) - 109);
            String[] strArr = A07;
            if (strArr[6].charAt(25) == strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            A07[2] = "awpTB9u15TkHVvPjjOCd09Fy8dol99E";
            bArrCopyOfRange[i6] = b3;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A06 = new byte[]{76, 75, Ascii.RS, 75, 70, 74, 62, 81, 70, 76, 75, 80, 35, 70, 75, 70, 80, 69, 66, 65};
    }

    public abstract void A0H();

    public abstract void A0I();

    public abstract void A0L(RK rk);

    public abstract boolean A0M();

    public abstract boolean A0N(RK rk);

    public abstract boolean A0O(RK rk, C1003Qx c1003Qx, C1003Qx c1003Qx2);

    public abstract boolean A0P(RK rk, C1003Qx c1003Qx, C1003Qx c1003Qx2);

    public abstract boolean A0Q(RK rk, C1003Qx c1003Qx, C1003Qx c1003Qx2);

    public abstract boolean A0R(RK rk, RK rk2, C1003Qx c1003Qx, C1003Qx c1003Qx2);

    static {
        A09();
    }

    public static int A06(RK rk) {
        int i3 = rk.A0C & 14;
        if (rk.A0f()) {
            return 4;
        }
        int flags = i3 & 4;
        if (flags == 0) {
            int pos = rk.A0P();
            int oldPos = rk.A0M();
            if (pos != -1 && oldPos != -1 && pos != oldPos) {
                return i3 | 2048;
            }
            return i3;
        }
        return i3;
    }

    private final C1003Qx A07() {
        return new C1003Qx();
    }

    public final long A0A() {
        return this.A00;
    }

    public final long A0B() {
        return this.A01;
    }

    public final long A0C() {
        return this.A02;
    }

    public final long A0D() {
        return this.A03;
    }

    public final C1003Qx A0E(RH rh, RK rk) {
        return A07().A01(rk);
    }

    public final C1003Qx A0F(RH rh, RK rk, int i3, List<Object> payloads) {
        return A07().A01(rk);
    }

    public final void A0G() {
        int count = this.A05.size();
        if (0 < count) {
            this.A05.get(0);
            throw new NullPointerException(A08(0, 20, 112));
        }
        this.A05.clear();
    }

    public final void A0J(InterfaceC1002Qw interfaceC1002Qw) {
        this.A04 = interfaceC1002Qw;
    }

    public final void A0K(RK rk) {
        if (this.A04 != null) {
            this.A04.ACv(rk);
        }
    }

    public boolean A0S(RK rk, List<Object> payloads) {
        return A0N(rk);
    }
}
