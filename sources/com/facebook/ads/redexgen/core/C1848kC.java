package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1848kC extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public final /* synthetic */ N8 A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{117, 97, 118, 98, 102, 118, 125, 112, 106, 76, 112, 114, 99, 99, 122, 125, 116};
    }

    public C1848kC(N8 n8, JSONObject jSONObject) {
        this.A00 = n8;
        this.A01 = jSONObject;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        try {
            this.A00.A05.await();
            synchronized (this.A00.A02) {
                this.A00.A02.A0B(this.A01);
                this.A00.A06.countDown();
            }
        } catch (InterruptedException e3) {
            this.A00.A03.A08().ABC(A00(0, 17, 25), AbstractC1060Td.A1B, new C1061Te(e3));
        } catch (JSONException e4) {
            this.A00.A0M();
            this.A00.A03.A08().ABC(A00(0, 17, 25), AbstractC1060Td.A1A, new C1061Te(e4));
        }
    }
}
