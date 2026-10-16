package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1786j3 implements N9 {
    public static byte[] A02;
    public static String[] A03 = {"ebJtInVgM8lwtLsL8CqjQvfHZTFWXyTj", "MRT4Iz3aNiJEaKRUIrDApfghDq01n6sB", "qhIcWii6jOsLbVLe4G", "jd0Ec4CahT7YYBjB568owPC0gY4s3zOU", "RPiMcfQYBdHC0SSG6XvNc0NsjlYurq5U", "E74vSWGMqEH8Jt4WlgBEkdQ8nTEO7fKB", "DEVdv4rr1ByH9p4ezSF9ryFdFyWOGnGy", "23RYwIDt1nJrIBpc57"};
    public final /* synthetic */ C05227k A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{89, 10, Ascii.SO, 83, 89, 91, 92, 92, 32, 3, Ascii.FF, Ascii.FF, 7, Ascii.DLE, 66, Ascii.VT, Ascii.SI, Ascii.DC2, Ascii.DLE, 7, 17, 17, Ascii.VT, Ascii.CR, Ascii.FF, 66, 4, Ascii.VT, Ascii.DLE, 7, 6, Ascii.FS, Ascii.GS, Framer.STDOUT_FRAME_PREFIX, Ascii.DC2, Ascii.GS, Ascii.GS, Ascii.SYN, 1, 63, Ascii.FS, Ascii.DC4, Ascii.DC4, Ascii.SUB, Ascii.GS, Ascii.DC4, 58, Ascii.RS, 3, 1, Ascii.SYN, 0, 0, Ascii.SUB, Ascii.FS, Ascii.GS};
    }

    static {
        A01();
    }

    public C1786j3(C05227k c05227k, Runnable runnable) {
        this.A00 = c05227k;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADC(InterfaceC1844k8 interfaceC1844k8) {
        this.A00.A02.A0F().A4a();
        this.A00.A07.A0C();
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADD(InterfaceC1844k8 interfaceC1844k8, View view) {
        this.A00.A02.A0F().A4Z(interfaceC1844k8 == ((AbstractC1783j0) this.A00).A00);
        if (interfaceC1844k8 != ((AbstractC1783j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        N1 n12 = ((AbstractC1783j0) this.A00).A01;
        C05227k c05227k = this.A00;
        String[] strArr = A03;
        if (strArr[6].charAt(14) != strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "gfJNIdbF2FrCa8qL8kuytpSS0QUlrsrj";
        strArr2[1] = "KzSpIsxhAVssntgB7OlLodebxm4ynnXJ";
        ((AbstractC1783j0) c05227k).A01 = interfaceC1844k8;
        this.A00.A01 = view;
        if (!this.A00.A0C) {
            this.A00.A07.A0F(interfaceC1844k8);
        } else {
            this.A00.A07.A0E(view);
            this.A00.A0Q(n12);
        }
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADE(InterfaceC1844k8 interfaceC1844k8) {
        AbstractC1131Vy.A05(A00(31, 25, 61), A00(8, 23, 44), A00(0, 8, 37));
        this.A00.A02.A0F().A4c();
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void AEN(InterfaceC1844k8 interfaceC1844k8, C1120Vm c1120Vm) {
        this.A00.A02.A0F().A4b(interfaceC1844k8 == ((AbstractC1783j0) this.A00).A00, c1120Vm.A03().getErrorCode());
        if (interfaceC1844k8 != ((AbstractC1783j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(interfaceC1844k8);
        this.A00.ADp(c1120Vm);
    }
}
