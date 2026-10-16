package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class NP implements InterfaceC1497eG {
    public static byte[] A01;
    public static String[] A02 = {"BHXiYjXxfgjD7yDB", "kPfw5HKETqo8dV", "SlBKzsC69frNfTspgJs5v90302jxH173", "0t7u2eeKUCj5gcxeWZIOCTpidMAeGJtt", "hTXrvsDVbOi3Q9xrUBZOJj7T", "iLbLRTjnBQIJ87KFXaIFUijyWt7EPIGc", "0utayShxEdwMeaV3UZeoWviAuyaBWRmj", "gyVOCm6F1v6TZALkbG"};
    public final /* synthetic */ NO A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.EM, Ascii.ETB, 9, Ascii.SYN, 7, Ascii.DLE, Ascii.CR, 7, Ascii.SI};
    }

    static {
        A01();
    }

    public NP(NO no) {
        this.A00 = no;
    }

    public /* synthetic */ NP(NO no, OV ov) {
        this(no);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1497eG
    public final void ADX() {
        this.A00.A0W(true, A00(0, 9, 106));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1497eG
    public final void AEA() {
        if (!this.A00.A0f) {
            if (!TextUtils.isEmpty(this.A00.A0O.A2E())) {
                this.A00.A0S.ABJ(this.A00.A0O.A2E(), new C1305b9().A03(this.A00.A0B.getViewabilityChecker()).A02(this.A00.A0B.getTouchDataRecorder()).A05());
                C1144Wl.A00(this.A00.A0R).A0E(this.A00.A0X.A8l(), this.A00.A0O.A2E());
                C0912Ng.A07(this.A00.A0O.A2A(), this.A00.A0R);
                AbstractC0932Oa.A02(this.A00.A0O.A0y(), AbstractC1168Xm.A00(this.A00.A0O.A10()));
                this.A00.A0R.A0F().A3L();
                if (this.A00.A0P.A0c()) {
                    this.A00.A0R.A0F().AES();
                }
            }
            NO no = this.A00;
            String[] strArr = A02;
            if (strArr[5].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            A02[4] = "GzK3XL6hk7idJD";
            no.A0W.A4j(this.A00.A0X.A8G());
            return;
        }
        this.A00.A0R.A0F().AET();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1497eG
    public final void AEh() {
        this.A00.A0W.A4j(this.A00.A0X.A81());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1497eG
    public final void AFQ() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1497eG
    public final void AGg() {
        this.A00.A0W.ADJ(15);
    }
}
