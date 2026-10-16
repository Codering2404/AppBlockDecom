package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1042Sl implements InterfaceC1600fw {
    public static byte[] A03;
    public static String[] A04 = {"vUQacvUb1jgaOB1nXCILUaEr4ItZ5QEs", "N", "ozPzI", "iemFS7qx3ItQSdDQeBrvuJ9y9CMkfIqY", "EwROMxnfRd6F7268i4EpvPtVg3hQf", "a", "qVu8", "3RxrE6NsEsLt8TXu"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ WA A01;
    public final /* synthetic */ WD A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{85, 81, 3, 85, 87, 7, 80, 3, 60, 111, 51, 63, 51, 63, 107, 60, 44, 53, 41, 40, 35, Ascii.RS, 5, 3, Ascii.SYN, Ascii.DC2, Ascii.SI, 9, 8, 92, 70, 78, Framer.EXIT_FRAME_PREFIX, 111, 107, Framer.EXIT_FRAME_PREFIX, 111, 61, Framer.EXIT_FRAME_PREFIX, 111, 111, 114, 111, 61, 114, 126, 126, 104, 111, 111, Framer.EXIT_FRAME_PREFIX, 121, 124, 74, 93, 89, 74, 93, Ascii.SI, 93, 74, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 70, 74, 75, Ascii.SI, 92, 90, 76, 76, 74, 92, 92, 73, 90, 67, 67, 86, 63, 62, 19, 63, 61, 32, 60, 53, 36, 53, Ascii.DLE, 17, 58, Ascii.CR, Ascii.CR, Ascii.DLE, Ascii.CR};
    }

    static {
        A01();
    }

    public C1042Sl(WD wd, WA wa, long j3) {
        this.A02 = wd;
        this.A01 = wa;
        this.A00 = j3;
    }

    private final void A02(C1612g8 c1612g8) {
        W9.A06(this.A01);
        try {
            InterfaceC1598fu response = c1612g8.A00();
            if (response != null) {
                String strA73 = response.A73();
                WG serverResponse = this.A02.A06.A07(this.A02.A05, strA73, this.A00);
                if (serverResponse.A01() == WF.A03) {
                    R4 r4 = (R4) serverResponse;
                    String strA04 = r4.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(r4.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA73 = strA04;
                    }
                    this.A02.A05.A0F().A3W(Y1.A01(this.A02.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA73, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0E(C1120Vm.A01(adErrorTypeAdErrorTypeFromCode, strA73));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1612g8.getMessage();
            InterfaceC0874Lt interfaceC0874LtA0F = this.A02.A05.A0F();
            long jA01 = Y1.A01(this.A02.A01);
            int errorCode = adErrorType.getErrorCode();
            boolean zIsPublicError = adErrorType.isPublicError();
            if (A04[2].length() == 29) {
                throw new RuntimeException();
            }
            A04[4] = "NZ18w";
            interfaceC0874LtA0F.A3W(jA01, errorCode, message, zIsPublicError);
            this.A02.A0E(C1120Vm.A01(adErrorType, message));
        } catch (JSONException e3) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage = c1612g8.getMessage();
            this.A02.A05.A0F().A3W(Y1.A01(this.A02.A01), adErrorType2.getErrorCode(), A00(16, 15, 30) + e3.getMessage(), adErrorType2.isPublicError());
            this.A02.A0E(C1120Vm.A01(adErrorType2, errorMessage));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1600fw
    public final void ADR(InterfaceC1598fu interfaceC1598fu) {
        AbstractC1131Vy.A05(A00(79, 10, 40), A00(52, 27, 87), A00(8, 8, 114));
        if (interfaceC1598fu != null) {
            String strA73 = interfaceC1598fu.A73();
            int iA02 = C1098Up.A02(this.A02.A05);
            String[] strArr = A04;
            String str = strArr[5];
            String response = strArr[1];
            if (str.length() != response.length()) {
                throw new RuntimeException();
            }
            A04[2] = "kblvpkFa8oUK1ItVGqcsW93nH";
            if (iA02 > 0) {
                C1144Wl.A00(this.A02.A05).A0C(strA73);
            }
            W9.A06(this.A01);
            this.A02.A0O(strA73, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1600fw
    public final void ADq(Exception exc) {
        AbstractC1131Vy.A05(A00(89, 7, 7), A00(31, 21, 101), A00(0, 8, 30));
        if (C1612g8.class.equals(exc.getClass())) {
            A02((C1612g8) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        this.A02.A05.A0F().A3W(Y1.A01(this.A02.A01), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0E(C1120Vm.A01(adErrorType, errorMessage));
    }
}
