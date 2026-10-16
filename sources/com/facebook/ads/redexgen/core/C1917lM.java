package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1917lM implements InterfaceC0850Kv {
    public static byte[] A0G;
    public static String[] A0H = {"cAtU07tvAHmpQwteCa8pEQH5gF5iUcfh", "Hjeg7grS71Jm6r5NKbmR8o7Al25NvLrB", "8TbkpeEOwiN436cBQhp4NSePMq1Z0ZNp", "wFA3Sleqv", "yws6lvEdJf3TdH9okNAymdfPd8aH69ii", "xvx7jE251jeLUpmQ5JTTtAODp7RTPAZj", "flKrm8KbmQNj7vJDUwRTOfFPMCPuTaKn", "2PQM5lIFNms8BVmrvHkuPmbcHqu7a2gR"};
    public static final double[] A0I;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public InterfaceC0755Hd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final C04554v A0B;
    public final C0851Kw A0C;
    public final L4 A0D;
    public final LJ A0E;
    public final boolean[] A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<C2208qI, Long> A00(C0851Kw c0851Kw, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(c0851Kw.A02, c0851Kw.A00);
        int i3 = bArrCopyOf[4] & 255;
        int i4 = bArrCopyOf[5] & 255;
        int i5 = (i3 << 4) | (i4 >> 4);
        int i6 = ((i4 & 15) << 8) | (bArrCopyOf[6] & 255);
        float f3 = 1.0f;
        switch ((bArrCopyOf[7] & 240) >> 4) {
            case 2:
                float f4 = i6 * 4;
                float f5 = i5 * 3;
                if (A0H[2].charAt(3) == 'k') {
                    A0H[1] = "IKG5315UEoYuWi8w79ZvxkF28jax6fmF";
                    f3 = f4 / f5;
                    break;
                }
                throw new RuntimeException();
            case 3:
                f3 = (i6 * 16) / (i5 * 9);
                break;
            case 4:
                f3 = (i6 * 121) / (i5 * 100);
                break;
        }
        C2208qI c2208qIA14 = new C03992p().A0y(str).A11(A01(0, 11, 62)).A0r(i5).A0f(i6).A0Y(f3).A12(Collections.singletonList(bArrCopyOf)).A14();
        long j3 = 0;
        int i7 = (bArrCopyOf[7] & Ascii.SI) - 1;
        if (i7 >= 0 && i7 < A0I.length) {
            double d3 = A0I[i7];
            int i8 = c0851Kw.A01;
            int i9 = (bArrCopyOf[i8 + 9] & 96) >> 5;
            int i10 = bArrCopyOf[i8 + 9] & Ascii.US;
            if (i9 != i10) {
                double d4 = i9;
                if (A0H[2].charAt(3) == 'k') {
                    String[] strArr = A0H;
                    strArr[5] = "rAMAKKtXIRKmVhmwxuLKv06bcSnWRDth";
                    strArr[7] = "TlBzrdA8FTcPVEmXq7DzDEHR3QnpW5Am";
                    d3 *= (d4 + 1.0d) / ((double) (i10 + 1));
                }
                throw new RuntimeException();
            }
            j3 = (long) (1000000.0d / d3);
        }
        return Pair.create(c2208qIA14, Long.valueOf(j3));
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 32, Framer.ENTER_FRAME_PREFIX, 43, 107, 41, 52, Framer.ENTER_FRAME_PREFIX, 35, 118};
        if (A0H[4].charAt(19) != 'y') {
            throw new RuntimeException();
        }
        A0H[2] = "5b4kHrs0qMccPUXJRINIqLrMs4aEtqXr";
        A0G = bArr;
    }

    static {
        A02();
        A0I = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public C1917lM() {
        this(null);
    }

    public C1917lM(LJ lj) {
        this.A0E = lj;
        this.A0F = new boolean[4];
        this.A0C = new C0851Kw(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        if (lj != null) {
            this.A0D = new L4(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.A0B = new C04554v();
        } else {
            this.A0D = null;
            this.A0B = null;
        }
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0117  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5A(com.facebook.ads.redexgen.core.C04554v r24) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1917lM.A5A(com.facebook.ads.redexgen.X.4v):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A06 = lg.A04();
        this.A05 = ha.AKS(lg.A03(), 2);
        if (this.A0E != null) {
            this.A0E.A03(ha, lg);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGq(long j3, int i3) {
        this.A01 = j3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AJ5() {
        HS.A0H(this.A0F);
        this.A0C.A00();
        if (this.A0D != null) {
            L4 l4 = this.A0D;
            if (A0H[1].length() != 32) {
                throw new RuntimeException();
            }
            A0H[0] = "joVCJevLOtmtIagsqVBvfxemqq2mA7LA";
            l4.A00();
        }
        this.A04 = 0L;
        this.A0A = false;
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }
}
