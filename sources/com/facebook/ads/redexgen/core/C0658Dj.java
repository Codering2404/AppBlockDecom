package com.facebook.ads.redexgen.core;

import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0658Dj extends TextView implements InterfaceC1536eu {
    public static byte[] A02;
    public static String[] A03 = {"KyDK4ozsSQOI8CeBEp6vN7GPAMaKi3Lj", "3K3dE7OkNcMTAukVEMEsyydi1KZJfoYe", "AKsSDy", "td2HYxymrySRBlk8LVzv2Nj", "9YKsZJjoWB8K3TGCGylWNfB", "C67xSy", "ZVZacBuH1Jrb8cRz3UZ99yjmQBL5sCV1", "zO36dBYDIleQnJstGNGNdS3bkLsuKmlY"};
    public static final int A04;
    public C0685Ek A00;
    public final UN<C4A> A01;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].charAt(28) == strArr[1].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "iGxWfyiSQAQNOwaGoqCiMbtpxtO5GMjZ";
            strArr2[1] = "gQ1pvXOTKlX7L3B8LOaiCsG8OhRO9Yk5";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 61);
            i6++;
        }
    }

    public static void A04() {
        A02 = new byte[]{Ascii.SI, Ascii.SUB, Ascii.CAN, 78, Ascii.DLE, Ascii.SI, Ascii.SUB, Ascii.CAN, 78, Ascii.DC2, Ascii.DC2, Ascii.CAN, Ascii.DC2, Ascii.DC2};
    }

    static {
        A04();
        A04 = (int) (XX.A02 * 6.0f);
    }

    public C0658Dj(C1648gi c1648gi) {
        super(c1648gi);
        this.A01 = new C0659Dk(this);
        YB.A0V(this, YB.A06(855638016, A04));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A02(long j3) {
        if (j3 <= 0) {
            return A01(9, 5, 31);
        }
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j3);
        long minutes2 = TimeUnit.MILLISECONDS.toSeconds(j3 % 60000);
        return String.format(Locale.US, A01(0, 9, 23), Long.valueOf(minutes), Long.valueOf(minutes2));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
        if (this.A00 != null) {
            this.A00.getEventBus().A05(this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
        if (this.A00 != null) {
            this.A00.getEventBus().A06(this.A01);
        }
    }
}
