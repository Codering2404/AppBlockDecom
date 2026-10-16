package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Build;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1015Rj {
    public static byte[] A04;
    public static String[] A05 = {"MJXAzUwyiLvMzZCrP1QJf8uMs9b", "sHuNTXgsBnW3HGqskl7KH5QkikNWpABj", "q8u9vKEVkpk3dMxroB1EFzM5kwDKfJOq", "eyGwnlQBA4bCraIcft5FxvFgN7f8TC5N", "FmmRYKiwjJl3dX1FB2pV6kIWJpsNLC6h", "flBitaWG3wpDSjkerYNuTkR3r5UhRox3", "xkUQOvOGGj42jMnQjSDdoLzQvdQiYUba", "XqZ9VL6XKZ5Y"};
    public final Intent A00;
    public final C1010Re A01;
    public final C1648gi A02;
    public final VA A03;

    public static String A0K(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0L() {
        A04 = new byte[]{99, Ascii.DEL, 4, 1, 58, 1, 4, 17, 4, 58, 7, Ascii.DLE, Ascii.VT, 1, 9, 0, 43, 41, 36, 36, Framer.STDIN_FRAME_PREFIX, 58, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, 56, Framer.STDIN_FRAME_PREFIX, 119, 124, 117, 125, 122, 113, 112, 85, 112, 80, 117, 96, 117, 86, 97, 122, 112, Framer.EXIT_FRAME_PREFIX, 113, 35, 44, 41, Framer.STDOUT_FRAME_PREFIX, 32, 55, 32, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, 38, 41, 44, 38, 46, Ascii.SUB, Framer.ENTER_FRAME_PREFIX, 32, 41, 36, 60, Ascii.SUB, 40, 54, 123, 97, 77, 100, 32, 77, 118, 119, 97, 123, 117, 124, 116, 123, 110, 115, 108, Ascii.DEL, 91, 126, 94, 123, 110, 123, 88, 111, 116, 126, 118, Ascii.DEL, 32, 55, 37, 51, 32, 54, 55, 54, 4, 59, 54, 55, 61, 19, 54, Ascii.SYN, 51, 38, 51, Ascii.DLE, 39, 60, 54, 62, 55, Ascii.SYN, 9, 4, 5, Ascii.SI, 63, Ascii.DC4, 9, Ascii.CR, 5, 63, Ascii.DLE, Ascii.SI, Ascii.FF, Ascii.FF, 9, Ascii.SO, 7, 63, 9, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, Ascii.SYN, 1, Ascii.FF};
    }

    static {
        A0L();
    }

    public C1015Rj(C1010Re c1010Re, Intent intent, VA va, C1648gi c1648gi) {
        this.A01 = c1010Re;
        this.A00 = intent;
        this.A03 = va;
        this.A02 = c1648gi;
    }

    private AbstractC1813jd A00() {
        int i3 = Build.VERSION.SDK_INT;
        String strA0K = A0K(80, 18, 33);
        if (i3 >= 33) {
            return (AbstractC1813jd) this.A00.getSerializableExtra(strA0K, AbstractC1813jd.class);
        }
        Intent intent = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
            throw new RuntimeException();
        }
        A05[1] = "LmjecX6z1NXmevkMdudhCsYVgseeBlBL";
        return (AbstractC1813jd) intent.getSerializableExtra(strA0K);
    }

    private C1807jT A01() {
        int i3 = Build.VERSION.SDK_INT;
        String strA0K = A0K(26, 19, 47);
        if (i3 >= 33) {
            return (C1807jT) this.A00.getSerializableExtra(strA0K, C1807jT.class);
        }
        return (C1807jT) this.A00.getSerializableExtra(strA0K);
    }

    private C05257n A02() {
        int i3 = Build.VERSION.SDK_INT;
        String strA0K = A0K(2, 14, 94);
        if (i3 >= 33) {
            return (C05257n) this.A00.getSerializableExtra(strA0K, C05257n.class);
        }
        return (C05257n) this.A00.getSerializableExtra(strA0K);
    }

    private C05237l A03() {
        int i3 = Build.VERSION.SDK_INT;
        String strA0K = A0K(98, 25, 105);
        if (i3 >= 33) {
            return (C05237l) this.A00.getSerializableExtra(strA0K, C05237l.class);
        }
        return (C05237l) this.A00.getSerializableExtra(strA0K);
    }

    private InterfaceC1190Yi A05() {
        boolean booleanExtra = this.A00.getBooleanExtra(A0K(68, 12, 41), false);
        boolean isV2Design = C1098Up.A2w(this.A02);
        if (isV2Design) {
            String stringExtra = this.A00.getStringExtra(A0K(45, 23, 126));
            C1010Re c1010Re = this.A01;
            C1648gi c1648gi = this.A02;
            VA va = this.A03;
            C1694hS c1694hS = new C1694hS(this.A01);
            String stringExtra2 = this.A00.getStringExtra(A0K(16, 10, 115));
            if (stringExtra == null) {
                stringExtra = A0K(0, 2, 117);
            }
            int i3 = Integer.parseInt(stringExtra);
            String clickDelayMs = A05[5];
            if (clickDelayMs.charAt(3) != 'i') {
                throw new RuntimeException();
            }
            A05[4] = "YY09SF1W0j6b6KfCSgRusx8TJPca7HgC";
            return new ViewOnClickListenerC05096x(c1010Re, c1648gi, va, c1694hS, stringExtra2, i3);
        }
        return new PZ(this.A01, this.A02, this.A03, new C1694hS(this.A01), booleanExtra);
    }

    private InterfaceC1190Yi A06() {
        C05257n c05257nA02 = A02();
        if (c05257nA02 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), c05257nA02, c05257nA02.A1G(), new MH());
    }

    private InterfaceC1190Yi A07() {
        C05237l c05237lA03 = A03();
        if (c05237lA03 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), c05237lA03, c05237lA03.A1G(), new MG());
    }

    private InterfaceC1190Yi A08(InterfaceC1189Yh interfaceC1189Yh, AbstractC1813jd abstractC1813jd, String str, ZU zu) {
        if (abstractC1813jd.A29().A0H().A07() != null) {
            C0920No c0920NoA07 = abstractC1813jd.A29().A0H().A07();
            if (abstractC1813jd.A1n()) {
                return new MW(this.A02, this.A03, interfaceC1189Yh, abstractC1813jd, c0920NoA07, str, zu);
            }
            return new NO(this.A02, this.A03, interfaceC1189Yh, abstractC1813jd, str, zu);
        }
        interfaceC1189Yh.A4j(zu.A81());
        interfaceC1189Yh.A4j(zu.A7w());
        return null;
    }

    private PJ A09(WK wk) {
        AbstractC1813jd abstractC1813jdA02;
        if (wk == WK.A0G) {
            abstractC1813jdA02 = A03();
            String[] strArr = A05;
            if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "BHjTvXd0Vicw2MzqRZQvpavg35ntNS6w";
            strArr2[2] = "NWBwsXtlP0iXXM4o1NBUiSzzY7vvtUxs";
            if (abstractC1813jdA02 == null) {
                return null;
            }
        } else if (wk != WK.A0A || (abstractC1813jdA02 = A02()) == null) {
            return null;
        }
        abstractC1813jdA02.A1L(this.A01.A08());
        if (abstractC1813jdA02.A1a()) {
            return new C4U(this.A02, this.A03, new C1054Sx(this.A02), new C1694hS(this.A01), abstractC1813jdA02);
        }
        return new C4T(this.A02, this.A03, new C1054Sx(this.A02), new C1694hS(this.A01), abstractC1813jdA02);
    }

    private final MT A0A() {
        return new MT(this.A02, this.A01);
    }

    private MI A0B(RelativeLayout relativeLayout) {
        MI mi = new MI(this.A02, new C1693hR(this), this.A03, new C1694hS(this.A01));
        mi.A05(relativeLayout);
        mi.A04(this.A00.getIntExtra(A0K(123, 27, 91), 200));
        YB.A0N(relativeLayout, -16777216);
        return mi;
    }

    private AnonymousClass66 A0C() {
        C05257n c05257nA02 = A02();
        if (c05257nA02 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1694hS(this.A01), c05257nA02, new MH(), 1);
    }

    private AnonymousClass66 A0D() {
        C05237l c05237lA03 = A03();
        if (c05237lA03 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1694hS(this.A01), c05237lA03, new MG(), 0);
    }

    private JD A0E() {
        C1432dC c1432dCA02;
        AbstractC1813jd abstractC1813jdA00 = A00();
        if (abstractC1813jdA00 == null || (c1432dCA02 = AbstractC1433dD.A02(abstractC1813jdA00.A1D())) == null) {
            return null;
        }
        return new JD(this.A02, new C1694hS(this.A01), c1432dCA02, abstractC1813jdA00.A2E());
    }

    private C0730Ge A0F(WK wk) {
        ZU mg;
        InterfaceC1189Yh anonymousClass77;
        C1807jT c1807jTA01 = A01();
        if (c1807jTA01 == null) {
            return null;
        }
        if (wk == WK.A04) {
            mg = new MH();
            anonymousClass77 = new C1694hS(this.A01);
        } else {
            mg = new MG();
            anonymousClass77 = new AnonymousClass77(this.A01);
        }
        return new C0730Ge(this.A02, mg, this.A03, c1807jTA01, new C1054Sx(this.A02), anonymousClass77);
    }

    private C04574x A0G() {
        C05257n c05257nA02 = A02();
        if (c05257nA02 != null) {
            return new C04574x(this.A02, new MH(), this.A03, c05257nA02, new C1054Sx(this.A02), new C1694hS(this.A01));
        }
        if (A05[1].charAt(5) != 'X') {
            throw new RuntimeException();
        }
        A05[3] = "TvLwsmu9uaa0faVP4fF8b7PGg31O8U7I";
        return null;
    }

    private C4V A0H() {
        C05257n c05257nA02 = A02();
        if (c05257nA02 == null) {
            return null;
        }
        return new C4V(this.A02, new MH(), this.A03, c05257nA02, new C1054Sx(this.A02), new C1694hS(this.A01));
    }

    private C4V A0I() {
        C05237l c05237lA03 = A03();
        if (c05237lA03 == null) {
            return null;
        }
        return new C4V(this.A02, new MG(), this.A03, c05237lA03, new C1054Sx(this.A02), new AnonymousClass77(this.A01));
    }

    private GB A0J(WK wk) {
        AbstractC1813jd abstractC1813jdA02;
        AbstractC1813jd abstractC1813jdA022;
        if (wk == WK.A0J) {
            abstractC1813jdA02 = A03();
            if (abstractC1813jdA02 == null || (abstractC1813jdA022 = A03()) == null) {
                return null;
            }
        } else if (wk != WK.A0E || (abstractC1813jdA02 = A02()) == null || (abstractC1813jdA022 = A02()) == null) {
            return null;
        }
        return new GB(this.A02, this.A03, abstractC1813jdA02, abstractC1813jdA022, new AnonymousClass77(this.A01), this.A01, wk);
    }

    public final InterfaceC1190Yi A0M(WK wk, RelativeLayout relativeLayout) {
        if (wk == null) {
            return null;
        }
        switch (C1014Ri.A00[wk.ordinal()]) {
            case 1:
                if (relativeLayout != null) {
                    return A0B(relativeLayout);
                }
                return null;
            case 2:
            case 3:
                return A09(wk);
            case 4:
                return A0I();
            case 5:
                return A07();
            case 6:
                InterfaceC1190Yi interfaceC1190YiA05 = A05();
                if (A05[4].charAt(13) != '3') {
                    A05[1] = "IIJ0HXviRARge0yizoGTY0JUA2Nzjczv";
                    return interfaceC1190YiA05;
                }
                String[] strArr = A05;
                strArr[6] = "UHMFNKnwuKHYyMbevaCPtufG1H9dhH1t";
                strArr[2] = "s6UgSHR7PtydXMVItCKPjBxPhDp7nABU";
                return interfaceC1190YiA05;
            case 7:
                return A0H();
            case 8:
                return A0G();
            case 9:
                return A06();
            case 10:
                return A0E();
            case 11:
                AnonymousClass66 anonymousClass66A0C = A0C();
                if (A05[5].charAt(3) != 'i') {
                    throw new RuntimeException();
                }
                A05[3] = "7AQwH6OZkLua7JLoKEhUfmskdEmJStMK";
                return anonymousClass66A0C;
            case 12:
                return A0D();
            case 13:
            case 14:
                return A0F(wk);
            case 15:
                return A0A();
            case 16:
            case 17:
                return A0J(wk);
            default:
                return null;
        }
    }
}
