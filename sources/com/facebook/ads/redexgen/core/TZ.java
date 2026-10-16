package com.facebook.ads.redexgen.core;

import android.content.pm.PackageManager;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class TZ extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public static String[] A03 = {"rr4pEtDer0K6hYSMypGI4SVA4", "qv2m0fG", "2OIR1Yv9Y7RzsB5MK8fjyIRTaeFBsJy", "02JyCSWW55zn1AQ6h7F4FoBumR9MK", "PV14KCf6Ep37wllo1HHxqudNmgtveNCD", "8xcTKK5W7UNHePnVaLckl2F", "lGpL0wggi73mqN0I3cVtORcNpouSV80j", "84RqxglWV7M6OmuSAB1gnMVf4"};
    public final /* synthetic */ WA A00;
    public final /* synthetic */ WD A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{121, 115, 97, 124, Ascii.DEL, 112, 112, 123, 108, 97, 117, 123, 103, Ascii.DC2, 51, 124, Framer.STDERR_FRAME_PREFIX, 57, 40, 43, 51, 46, 55, 124, 63, 51, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 57, 63, 40, 53, 51, Framer.STDERR_FRAME_PREFIX};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A01.A00 = System.currentTimeMillis();
        if (AbstractC1181Xz.A00(this.A01.A05) == EnumC1180Xy.A07) {
            this.A01.A0A();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String strA00 = A00(13, 21, 62);
            this.A01.A05.A0F().A3W(Y1.A01(this.A01.A01), adErrorType.getErrorCode(), strA00, adErrorType.isPublicError());
            this.A01.A0E(new C1120Vm(adErrorType, strA00));
            return;
        }
        C1070Tn.A08(this.A01.A05);
        SZ.A07(this.A01.A05);
        boolean z2 = true;
        Map<String, String> mapA0A = this.A00.A0A(UG.A00().A01(this.A01.A05, true).A7y(this.A00.A05()));
        this.A01.A03 = mapA0A;
        try {
            PackageManager packageManager = this.A01.A05.getPackageManager();
            if (packageManager != null) {
                mapA0A.put(A00(1, 12, 92), new String(Base64.encode((this.A01.A05.getPackageName() + A00(0, 1, 59) + packageManager.getInstallerPackageName(this.A01.A05.getPackageName())).getBytes(), 2)));
            }
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A07() != EnumC1123Vq.A04 && this.A00.A07() != EnumC1123Vq.A06 && this.A00.A07() != EnumC1123Vq.A05 && this.A00.A07() != null) {
                z2 = false;
            }
            C1617gD.A02(z2, this.A01.A05).AGy(this.A01.A07, new C1613g9().A05(this.A01.A03).A08(), this.A01.A03(Y1.A00(), this.A00));
        } catch (Exception e3) {
            AdErrorType adErrorType2 = AdErrorType.AD_REQUEST_FAILED;
            String message = e3.getMessage();
            this.A01.A05.A0F().A3W(Y1.A01(this.A01.A01), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            WD wd = this.A01;
            C1120Vm c1120VmA01 = C1120Vm.A01(adErrorType2, message);
            if (A03[3].length() != 29) {
                throw new RuntimeException();
            }
            A03[3] = "TysUXKeFt8WChM0CalDFmuBH7ELd8";
            wd.A0E(c1120VmA01);
        }
    }

    static {
        A01();
    }

    public TZ(WD wd, WA wa) {
        this.A01 = wd;
        this.A00 = wa;
    }
}
