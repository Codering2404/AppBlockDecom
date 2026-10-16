package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1436dG implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ C1439dJ A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.CR, Framer.ENTER_FRAME_PREFIX, 59, 34, 42, 110, 32, Framer.ENTER_FRAME_PREFIX, 58, 110, 62, 47, 60, 61, 43, 110, 61, 43, 60, 56, 43, 60, 110, 35, 43, 61, 61, 47, 41, 43, 72, Ascii.DEL, Ascii.DEL, 98, Ascii.DEL, Framer.STDIN_FRAME_PREFIX, 125, 108, Ascii.DEL, 126, 100, 99, 106, Framer.STDIN_FRAME_PREFIX, 71, 94, 66, 67, Framer.STDIN_FRAME_PREFIX, 100, 99, Framer.STDIN_FRAME_PREFIX, 125, 98, 126, 121, 64, 104, 126, 126, 108, 106, 104, Framer.STDIN_FRAME_PREFIX, 87, 67, 66, 94, 125, 83, 79, 53, 40, 36, 34, Framer.STDOUT_FRAME_PREFIX, Ascii.SI, 52, Framer.STDOUT_FRAME_PREFIX, 36, Framer.STDOUT_FRAME_PREFIX, Ascii.SO, 3, 10, Ascii.US, 58, 60};
    }

    public RunnableC1436dG(C1439dJ c1439dJ, String str) {
        this.A00 = c1439dJ;
        this.A01 = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(this.A01);
                if (this.A00.A05.equals(jSONObject.optString(A00(64, 7, 87)))) {
                    this.A00.A0C(EnumC1437dH.A00(jSONObject.optString(A00(81, 4, 27))), jSONObject.optString(A00(71, 10, 49), A00(85, 2, 32)));
                } else {
                    this.A00.A04.A04(AbstractC1060Td.A11, A00(0, 30, 47));
                }
            } catch (JSONException e3) {
                this.A00.A04.A04(AbstractC1060Td.A15, A00(30, 34, 108) + e3.getMessage());
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
