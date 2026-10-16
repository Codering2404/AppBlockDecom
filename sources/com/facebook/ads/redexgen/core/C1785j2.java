package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1785j2 extends AbstractRunnableC1135Wc {
    public static byte[] A03;
    public static String[] A04 = {"7HAtzWHHqocdVWrHWLF7dHgS7Bm2h12C", "DbOr4ijtOwCAaeVmvR816jBzMEkuu4t1", "lnUtOUEm1wuvoR9nZTKEc7Wj6", "rgunTSV1g2reSAbvPi4FwUaf05Z1esdk", "lf9TdmWUJKPBCDTsH0x6g9hItkASR1Wu", "rzwaJSO2zPm7h9LPx5qAuh7aJhmBGJeQ", "21sK4Gi1tfVdwS7GyFfEScwosNwGd1WZ", "FSSaRzfmWACYGxNNk9yD6VAWr"};
    public N1 A00;
    public String A01;
    public final /* synthetic */ C05227k A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-64, -29, -32, -17, -13, -28, -15, -97, -13, -24, -20, -28, -18, -12, -13, -83};
        String[] strArr = A04;
        if (strArr[6].charAt(4) != strArr[1].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[5] = "osBBqT7uNXEQnnthAEoQEGxFzU3x5jcE";
        strArr2[0] = "83ZlJzScQovvXu1byfPC9cIolLTrcwle";
        A03 = bArr;
    }

    static {
        A01();
    }

    public C1785j2(C05227k c05227k, N1 n12, String str) {
        this.A02 = c05227k;
        this.A00 = n12;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A02.A0V(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.ADp(new C1120Vm(AdErrorType.NETWORK_ERROR, A00(0, 16, 123)));
    }
}
