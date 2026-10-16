package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ht, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0771Ht extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public static String[] A03 = {"eWADjtxb1dWvMuQKHnw5jLkRYtYeIVb9", "vJlKnMrqllT8yqHy3c09kMgmhRavVIVM", "Q4u15erxw2VvJfagpGA99x6fik", "", "DcfdvxQ7qaScGwoUH6bgcK", "LZ3ab3PJnMGJQ4QsgAhwpTw2XWco3njm", "Qn1MQsBbREXEZXLMbJl8WtK7V5qupI", "ZrYMyBGTS8dZg7uAD2wVIzoUAJYVhikw"};
    public final /* synthetic */ C5F A00;
    public final /* synthetic */ C4A A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[6].length() == strArr[4].length()) {
                break;
            }
            String[] strArr2 = A03;
            strArr2[3] = "";
            strArr2[2] = "KjbCoXJ8ChyqWCUKbe1FzcklJu";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 33);
            String[] strArr3 = A03;
            if (strArr3[3].length() == strArr3[2].length()) {
                break;
            }
            String[] strArr4 = A03;
            strArr4[3] = "";
            strArr4[2] = "FepnQiYEGf6Y70BjqDmgAXMgjY";
            i6++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A02 = new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, 104, 123, 123, Framer.EXIT_FRAME_PREFIX, 111, 116, 115, 122, 61, 116, 115, 121, Framer.EXIT_FRAME_PREFIX, 123, 116, 115, 116, 105, Framer.EXIT_FRAME_PREFIX, 113, 100};
    }

    static {
        A01();
    }

    public C0771Ht(C5F c5f, C4A c4a) {
        this.A00 = c5f;
        this.A01 = c4a;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A00.A0b.getState() == EnumC1590fm.A02 && this.A00.A0b.getCurrentPositionInMillis() == A00()) {
            InterfaceC1468dm interfaceC1468dm = this.A00.A0Z;
            String[] strArr = A03;
            if (strArr[5].charAt(23) == strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[3] = "";
            strArr2[2] = "farTWgnk5frdrEZBsMmfrvdmtZ";
            interfaceC1468dm.AGQ(A00(0, 22, 60));
        }
    }
}
