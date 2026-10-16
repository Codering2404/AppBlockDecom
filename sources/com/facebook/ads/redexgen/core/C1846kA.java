package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1846kA extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public final /* synthetic */ N8 A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{36, 48, 39, 51, 55, 39, 44, Framer.ENTER_FRAME_PREFIX, 59, Ascii.GS, Framer.ENTER_FRAME_PREFIX, 35, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 43, 44, 37};
    }

    public C1846kA(N8 n8, String str) {
        this.A00 = n8;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        String strA00 = A00(0, 17, 81);
        try {
            this.A00.A06.await();
            if (this.A00.A0J(this.A01)) {
                ((C0911Nf) this.A00.A02.A05().get(this.A01)).A04((int) (System.currentTimeMillis() / 1000));
                this.A00.A02.A07(this.A01);
                this.A00.A02.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e3) {
            this.A00.A03.A08().ABC(strA00, AbstractC1060Td.A1B, new C1061Te(e3));
        } catch (JSONException e4) {
            this.A00.A0M();
            this.A00.A03.A08().ABC(strA00, AbstractC1060Td.A1A, new C1061Te(e4));
        }
    }
}
