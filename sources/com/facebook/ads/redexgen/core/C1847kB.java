package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1847kB extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public final /* synthetic */ N8 A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-77, -65, -78, -66, -62, -78, -69, -80, -58, -84, -80, -82, -67, -67, -74, -69, -76};
    }

    public C1847kB(N8 n8, String str) {
        this.A00 = n8;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        try {
            this.A00.A06.await();
            synchronized (this.A00.A02) {
                Iterator<String> itKeys = this.A00.A02.A05().keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (this.A00.A0J(this.A01)) {
                        this.A00.A0E((C0911Nf) this.A00.A02.A05().get(next), next, next.equals(this.A01));
                    }
                }
                this.A00.A02.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e3) {
            InterfaceC1059Tc interfaceC1059TcA08 = this.A00.A03.A08();
            String encryptedId = A00(0, 17, 22);
            interfaceC1059TcA08.ABC(encryptedId, AbstractC1060Td.A1B, new C1061Te(e3));
        } catch (JSONException e4) {
            this.A00.A0M();
            InterfaceC1059Tc interfaceC1059TcA082 = this.A00.A03.A08();
            String encryptedId2 = A00(0, 17, 22);
            interfaceC1059TcA082.ABC(encryptedId2, AbstractC1060Td.A1A, new C1061Te(e4));
        }
    }
}
