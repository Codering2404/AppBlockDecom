package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KX {
    public static byte[] A02;
    public static String[] A03 = {"WgUeKuj9wfEgVxNwMhsYWmskS6gvsk4u", "lY3t8mYoNwyGRU5cssOmtzsYdTPyfvrC", "tzc0Un4Rz02llsU2wRoiLNj111WzmA0w", "wjCansXDTCdJlU5xzgIWdtLXD8W6m4ff", "dSf2E5RYsrIqqVu4QtCEIfuVexQKgaAl", "hprG2SUWJwqzwErLsBPmt0UTVTrRmWBo", "Dvzgny", "YcbZLjapWumuyxPaIgpkq7v611"};
    public static final Pattern A04;
    public static final Pattern A05;
    public final C04554v A00 = new C04554v();
    public final StringBuilder A01 = new StringBuilder();

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A02 = new byte[]{8, 90, 83, Ascii.ETB, 57, 121, 34, 34, 123, 109, 125, 106, 96, 71, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 69, 64, 77, 9, 79, 70, 71, 93, 4, 90, 64, 83, 76, 19, 9, Ascii.SO, Framer.STDIN_REQUEST_FRAME_PREFIX, 109, 106, 126, 124, 124, 75, 123, 123, 88, 105, 122, 123, 109, 122, 36, 86, Ascii.NAK, Ascii.DC2, 63, 38, 32, 42, 44, 116, 107, 97, Ascii.DC2, Ascii.ETB, 107, Ascii.DC4, 99, 96, 107, Ascii.NAK, Ascii.DC4, 44, 90, 90, 77, 72, 41, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 75, 47, 88, 46, 92, 91, 77, 41, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 75, 47, 89, 91, 90, 2, 10, Ascii.SO, Ascii.ETB, Ascii.US, Ascii.SO, 87, 91, 86, 39, 42, 42, 19, Ascii.DLE, Ascii.DC2, Ascii.SUB, Ascii.SYN, 3, Ascii.RS, 4, Ascii.US, Ascii.NAK, 92, Ascii.DC2, Ascii.RS, Ascii.GS, Ascii.RS, 3, 93, 80, 83, 91, 52, 56, 59, 56, 37, 6, Ascii.VT, 5, Ascii.VT, Ascii.SYN, 17, 116, 124, 51, 58, 59, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 51, 52, 56, 60, 57, 44, 100, 109, 108, 118, 47, 113, 107, Framer.EXIT_FRAME_PREFIX, 103, 111, 102, 103, 125, 36, 122, 125, 112, 101, 108, 40, Framer.ENTER_FRAME_PREFIX, 32, 58, 99, 57, 43, 39, 41, 38, 58, 101, Framer.EXIT_FRAME_PREFIX, 109, 96, 101, 111, Ascii.DC2, Ascii.VT, Ascii.CAN, Ascii.SI, 119, Ascii.DEL, 124, 123, 108, 119, 35, 126, 97, 125, 103, 122, 103, 97, 96, 42, 59, 38, 42, 115, 61, Framer.STDOUT_FRAME_PREFIX, 51, 60, 55, 48, 59, 115, 43, 46, 44, 55, 57, 54, 42, 69, 84, 73, 69, Ascii.FS, 85, 84, 82, 94, 67, 80, 69, 88, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, 117, 110, 100, 101, 114, Ascii.DC2, 9, 3, 2, Ascii.NAK, Ascii.VT, Ascii.SO, 9, 2, 37, 115};
    }

    static {
        A07();
        A05 = Pattern.compile(A01(49, 19, 56));
        A04 = Pattern.compile(A01(68, 32, 3));
    }

    public static char A00(C04554v c04554v, int i3) {
        return (char) c04554v.A0l()[i3];
    }

    public static String A02(C04554v c04554v) {
        int limit = c04554v.A09();
        int iA0A = c04554v.A0A();
        char c3 = 0;
        while (limit < iA0A && c3 == 0) {
            int i3 = limit + 1;
            int position = c04554v.A0l()[limit];
            int limit2 = (char) position;
            c3 = limit2 == 41 ? (char) 1 : (char) 0;
            limit = i3;
        }
        int position2 = c04554v.A09();
        String strTrim = c04554v.A0W((limit - 1) - position2).trim();
        int limit3 = A03[6].length();
        if (limit3 == 22) {
            throw new RuntimeException();
        }
        A03[6] = "T";
        return strTrim;
    }

    public static String A03(C04554v c04554v, StringBuilder sb) {
        sb.setLength(0);
        int iA09 = c04554v.A09();
        int iA0A = c04554v.A0A();
        boolean z2 = false;
        while (iA09 < iA0A && !z2) {
            int position = c04554v.A0l()[iA09];
            char c3 = (char) position;
            if ((c3 >= 'A' && c3 <= 'Z') || ((c3 >= 'a' && c3 <= 'z') || ((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                iA09++;
                sb.append(c3);
            } else {
                z2 = true;
            }
        }
        int position2 = c04554v.A09();
        c04554v.A0g(iA09 - position2);
        return sb.toString();
    }

    public static String A04(C04554v c04554v, StringBuilder sb) {
        A09(c04554v);
        if (c04554v.A07() == 0) {
            return null;
        }
        String strA03 = A03(c04554v, sb);
        String strA01 = A01(0, 0, 111);
        if (!strA01.equals(strA03)) {
            return strA03;
        }
        String identifier = strA01 + ((char) c04554v.A0I());
        return identifier;
    }

    public static String A05(C04554v c04554v, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int iA09 = c04554v.A09();
            String token = A04(c04554v, sb);
            if (token == null) {
                return null;
            }
            if (A01(252, 1, 127).equals(token) || A01(11, 1, 32).equals(token)) {
                c04554v.A0f(iA09);
                z2 = true;
            } else {
                sb2.append(token);
            }
        }
        String token2 = sb2.toString();
        String[] strArr = A03;
        if (strArr[5].charAt(6) == strArr[0].charAt(6)) {
            throw new RuntimeException();
        }
        A03[1] = "H7IbVoVWHhMCEaN9uIz63JDuRBiIUDdu";
        return token2;
    }

    public static String A06(C04554v c04554v, StringBuilder sb) {
        A09(c04554v);
        if (c04554v.A07() < 5) {
            return null;
        }
        String strA0W = c04554v.A0W(5);
        String cueSelector = A01(6, 5, 105);
        if (!cueSelector.equals(strA0W)) {
            return null;
        }
        int iA09 = c04554v.A09();
        String token = A04(c04554v, sb);
        if (token == null) {
            return null;
        }
        String cueSelector2 = A01(251, 1, 47);
        if (cueSelector2.equals(token)) {
            c04554v.A0f(iA09);
            String cueSelector3 = A01(0, 0, 111);
            return cueSelector3;
        }
        String strA02 = null;
        String cueSelector4 = A01(3, 1, 78);
        if (cueSelector4.equals(token)) {
            strA02 = A02(c04554v);
        }
        String target = A04(c04554v, sb);
        if (A03[1].charAt(23) == '0') {
            throw new RuntimeException();
        }
        A03[2] = "kXJ9Slail85MSzeGoJKC016PF6DECpEt";
        String cueSelector5 = A01(4, 1, 97);
        if (cueSelector5.equals(target)) {
            return strA02;
        }
        return null;
    }

    public static void A08(C04554v c04554v) {
        String line;
        do {
            line = c04554v.A0T();
        } while (!TextUtils.isEmpty(line));
    }

    public static void A09(C04554v c04554v) {
        boolean skipping = true;
        while (c04554v.A07() > 0 && skipping) {
            boolean zA0E = A0E(c04554v);
            String[] strArr = A03;
            if (strArr[5].charAt(6) == strArr[0].charAt(6)) {
                throw new RuntimeException();
            }
            A03[4] = "0TKGD6osFOak97huLTwvjNDJFBkvRURl";
            if (!zA0E) {
                boolean skipping2 = A0D(c04554v);
                if (!skipping2) {
                    skipping = false;
                }
            }
            skipping = true;
        }
    }

    public static void A0A(C04554v c04554v, C0830Kb c0830Kb, StringBuilder sb) {
        A09(c04554v);
        String strA03 = A03(c04554v, sb);
        String strA01 = A01(0, 0, 111);
        if (strA01.equals(strA03)) {
            return;
        }
        String property = A03[7];
        if (property.length() != 9) {
            String[] strArr = A03;
            strArr[5] = "0USPULEwqSqheHB8AwvifNHGUwFlc4Dk";
            strArr[0] = "K61Ol0RKHiZGAookV7xLX0vZAqBJUPJk";
            String strA012 = A01(5, 1, 50);
            String property2 = A04(c04554v, sb);
            if (!strA012.equals(property2)) {
                return;
            }
            A09(c04554v);
            String token = A05(c04554v, sb);
            if (token == null || strA01.equals(token)) {
                return;
            }
            int iA09 = c04554v.A09();
            String strA04 = A04(c04554v, sb);
            String property3 = A01(11, 1, 32);
            if (!property3.equals(strA04)) {
                String property4 = A01(252, 1, 127);
                if (property4.equals(strA04)) {
                    c04554v.A0f(iA09);
                } else {
                    return;
                }
            }
            String property5 = A01(123, 5, 38);
            if (property5.equals(strA03)) {
                c0830Kb.A0C(AnonymousClass47.A00(token));
                return;
            }
            String property6 = A01(103, 16, 0);
            if (property6.equals(strA03)) {
                c0830Kb.A0B(AnonymousClass47.A00(token));
                return;
            }
            String property7 = A01(189, 13, 127);
            boolean z2 = true;
            if (property7.equals(strA03)) {
                String property8 = A01(183, 4, 12);
                if (property8.equals(token)) {
                    c0830Kb.A0E(1);
                    return;
                }
                String property9 = A01(237, 5, 113);
                if (!property9.equals(token)) {
                    return;
                }
                c0830Kb.A0E(2);
                return;
            }
            String[] strArr2 = A03;
            String str = strArr2[5];
            String value = strArr2[0];
            int position = str.charAt(6);
            if (position != value.charAt(6)) {
                A03[7] = "r";
                String property10 = A01(202, 20, 47);
                if (property10.equals(strA03)) {
                    String property11 = A01(100, 3, 55);
                    if (!property11.equals(token)) {
                        String property12 = A01(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 6, 19);
                        if (!token.startsWith(property12)) {
                            z2 = false;
                        }
                    }
                    c0830Kb.A0H(z2);
                    return;
                }
                String property13 = A01(222, 15, 64);
                boolean zEquals = property13.equals(strA03);
                int position2 = A03[1].charAt(23);
                if (position2 == 48) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A03;
                strArr3[5] = "yV6z32KBYC5kRTQJBEYXfmL3n0QpULhq";
                strArr3[0] = "ddMdMWLPn2YWu0ZxAW3O28brDgrMgVms";
                if (zEquals) {
                    String property14 = A01(242, 9, 22);
                    if (!property14.equals(token)) {
                        return;
                    }
                    c0830Kb.A0J(true);
                    return;
                }
                String property15 = A01(136, 11, 36);
                if (property15.equals(strA03)) {
                    c0830Kb.A0F(token);
                    return;
                }
                String property16 = A01(166, 11, 63);
                if (property16.equals(strA03)) {
                    String property17 = A01(119, 4, 78);
                    if (!property17.equals(token)) {
                        return;
                    }
                    c0830Kb.A0G(true);
                    return;
                }
                String property18 = A01(156, 10, 120);
                if (property18.equals(strA03)) {
                    String property19 = A01(177, 6, 125);
                    if (!property19.equals(token)) {
                        return;
                    }
                    c0830Kb.A0I(true);
                    return;
                }
                String property20 = A01(147, 9, 115);
                if (!property20.equals(strA03)) {
                    return;
                }
                A0C(token, c0830Kb);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0B(C0830Kb c0830Kb, String str) {
        if (A01(0, 0, 111).equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = A05.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                c0830Kb.A0N((String) AbstractC04323y.A01(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrA1O = C5C.A1O(str, A01(47, 2, 9));
        String str2 = strArrA1O[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            c0830Kb.A0M(str2.substring(0, iIndexOf2));
            int voiceStartIndex = iIndexOf2 + 1;
            c0830Kb.A0L(str2.substring(voiceStartIndex));
        } else {
            c0830Kb.A0M(str2);
        }
        int voiceStartIndex2 = strArrA1O.length;
        if (voiceStartIndex2 > 1) {
            int voiceStartIndex3 = strArrA1O.length;
            c0830Kb.A0O((String[]) C5C.A1J(strArrA1O, 1, voiceStartIndex3));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0C(java.lang.String r6, com.facebook.ads.redexgen.core.C0830Kb r7) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KX.A0C(java.lang.String, com.facebook.ads.redexgen.X.Kb):void");
    }

    public static boolean A0D(C04554v c04554v) {
        int position = c04554v.A09();
        int limit = c04554v.A0A();
        byte[] bArrA0l = c04554v.A0l();
        if (position + 2 > limit) {
            return false;
        }
        int i3 = position + 1;
        if (bArrA0l[position] != 47) {
            return false;
        }
        int i4 = i3 + 1;
        if (bArrA0l[i3] == 42) {
            while (i4 + 1 < limit) {
                int i5 = i4 + 1;
                char skippedChar = (char) bArrA0l[i4];
                if (skippedChar == '*') {
                    char skippedChar2 = bArrA0l[i5];
                    if (skippedChar2 == '/') {
                        limit = i5 + 1;
                        i4 = limit;
                    }
                }
                i4 = i5;
            }
            c04554v.A0g(limit - c04554v.A09());
            return true;
        }
        return false;
    }

    public static boolean A0E(C04554v c04554v) {
        switch (A00(c04554v, c04554v.A09())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                c04554v.A0g(1);
                return true;
            default:
                return false;
        }
    }

    public final List<C0830Kb> A0F(C04554v c04554v) {
        String selector;
        this.A01.setLength(0);
        int iA09 = c04554v.A09();
        A08(c04554v);
        C04554v c04554v2 = this.A00;
        byte[] bArrA0l = c04554v.A0l();
        int initialInputPosition = c04554v.A09();
        c04554v2.A0j(bArrA0l, initialInputPosition);
        this.A00.A0f(iA09);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String selector2 = A06(this.A00, this.A01);
            if (selector2 == null) {
                return arrayList;
            }
            if (!A01(251, 1, 47).equals(A04(this.A00, this.A01))) {
                return arrayList;
            }
            C0830Kb c0830Kb = new C0830Kb();
            A0B(c0830Kb, selector2);
            String strA04 = null;
            boolean z2 = false;
            while (true) {
                selector = A01(252, 1, 127);
                if (z2) {
                    break;
                }
                int iA092 = this.A00.A09();
                strA04 = A04(this.A00, this.A01);
                z2 = strA04 == null || selector.equals(strA04);
                if (!z2) {
                    this.A00.A0f(iA092);
                    A0A(this.A00, c0830Kb, this.A01);
                }
            }
            if (selector.equals(strA04)) {
                arrayList.add(c0830Kb);
            }
        }
    }
}
