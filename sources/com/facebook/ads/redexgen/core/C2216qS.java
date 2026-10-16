package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2216qS implements AnonymousClass24 {
    public static byte[] A06;
    public static String[] A07 = {"HSHJbKu4LLVwlp8kAtKM", "V6sGPCPiRhBLh6", "pDYVgvWCLxIG9LT", "RWHl9GQtcXYH3V7mNtlpSVait36OCwJs", "0F7", "tg3oN59jNUBk8XSE4kwfd", "NBkHOFenkRKh7SKHrVJVIcIm0kDLsOxD", "OSER18TpRPMUQAQSprsMKIJx0xqzVeT1"};
    public static final C2216qS A08;
    public static final AnonymousClass23<C2216qS> A09;
    public static final C2217qT A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final Object A04;

    @MetaExoPlayerCustomization("Change back to private after AdsMediaSource fully upgraded")
    public final C2217qT[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2216qS A00(Bundle bundle) {
        C2217qT[] c2217qTArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A0B);
        if (parcelableArrayList == null) {
            c2217qTArr = new C2217qT[0];
        } else {
            c2217qTArr = new C2217qT[parcelableArrayList.size()];
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                c2217qTArr[i3] = (C2217qT) C2217qT.A09.A6f((Bundle) parcelableArrayList.get(i3));
            }
        }
        return new C2216qS(null, c2217qTArr, bundle.getLong(A0C, A08.A02), bundle.getLong(A0D, A08.A03), bundle.getInt(A0E, A08.A01));
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] ^ i5;
            String[] strArr = A07;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "7EQT2aPGHNOftenQ9VAvD";
            strArr2[1] = "79Hg5O6oUNL8gh";
            bArrCopyOfRange[i6] = (byte) (i7 ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{70, 74, 63, 51, 114, 119, 84, 97, 124, 102, 99, 96, 46, 72, 116, Framer.EXIT_FRAME_PREFIX, 57, 60, 10, 61, 43, Framer.STDIN_FRAME_PREFIX, 53, 61, 8, 55, 43, Framer.STDOUT_FRAME_PREFIX, 44, Framer.STDOUT_FRAME_PREFIX, 55, 54, Ascii.CR, 43, 101, 47, 35, 98, 103, 112, 62, 88, Ascii.CR, 1, 69, 84, 83, 64, 85, 72, 78, 79, 116, 82, Ascii.FS, 1, 36, Ascii.DLE, 44, Framer.ENTER_FRAME_PREFIX, 57, 34, Framer.ENTER_FRAME_PREFIX, 35, 43, 19, 52, Framer.ENTER_FRAME_PREFIX, 52, 37, 104, Framer.ENTER_FRAME_PREFIX, 36, 51, 9, 36, 125, 80, 36, Ascii.GS, Ascii.CAN, 84, Ascii.SI, 8, Ascii.GS, 8, Ascii.EM, 65, 91, 94, 125, 72, 85, 79, 74, Ascii.DC2, 78, 83, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, 111, 73, 7};
    }

    static {
        A03();
        A08 = new C2216qS(null, new C2217qT[0], 0L, -9223372036854775807L, 0);
        A0A = new C2217qT(0L).A06(0);
        A0B = C5C.A0h(1);
        A0C = C5C.A0h(2);
        A0D = C5C.A0h(3);
        A0E = C5C.A0h(4);
        A09 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qV
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2216qS.A00(bundle);
            }
        };
    }

    public C2216qS(Object obj, C2217qT[] c2217qTArr, long j3, long j4, int i3) {
        this.A04 = obj;
        this.A02 = j3;
        this.A03 = j4;
        this.A00 = c2217qTArr.length + i3;
        this.A05 = c2217qTArr;
        this.A01 = i3;
    }

    private boolean A04(long j3, long j4, int i3) {
        if (j3 == Long.MIN_VALUE) {
            return false;
        }
        long j5 = A07(i3).A03;
        if (j5 != Long.MIN_VALUE) {
            return j3 < j5;
        }
        if (A07[3].charAt(17) != 't') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "6w59Aw8BMojzvOgPymJyT";
        strArr[1] = "Ceso9EO8QL9NfZ";
        return j4 == -9223372036854775807L || j3 < j4;
    }

    public final int A05(long j3, long j4) {
        if (j3 == Long.MIN_VALUE || (j4 != -9223372036854775807L && j3 >= j4)) {
            return -1;
        }
        int index = this.A01;
        while (index < this.A00 && ((A07(index).A03 != Long.MIN_VALUE && A07(index).A03 <= j3) || !A07(index).A08())) {
            index++;
        }
        if (index < this.A00) {
            return index;
        }
        return -1;
    }

    public final int A06(long j3, long j4) {
        int i3 = this.A00 - 1;
        while (i3 >= 0 && A04(j3, j4, i3)) {
            i3--;
        }
        if (i3 < 0 || !A07(i3).A07()) {
            return -1;
        }
        return i3;
    }

    public final C2217qT A07(int i3) {
        if (i3 < this.A01) {
            return A0A;
        }
        return this.A05[i3 - this.A01];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2216qS c2216qS = (C2216qS) obj;
        if (C5C.A1E(this.A04, c2216qS.A04) && this.A00 == c2216qS.A00 && this.A02 == c2216qS.A02 && this.A03 == c2216qS.A03 && this.A01 == c2216qS.A01) {
            C2217qT[] c2217qTArr = this.A05;
            String[] strArr = A07;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "16faulxPxX0sTjyZsuY2d";
            strArr2[1] = "99yT7gYz4zzQy1";
            if (Arrays.equals(c2217qTArr, c2216qS.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A00;
        int i3 = result * 31;
        int result2 = this.A04 == null ? 0 : this.A04.hashCode();
        int i4 = (((i3 + result2) * 31) + ((int) this.A02)) * 31;
        int result3 = (int) this.A03;
        int result4 = (((i4 + result3) * 31) + this.A01) * 31;
        int result5 = Arrays.hashCode(this.A05);
        return result4 + result5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A02(55, 22, 92));
        sb.append(this.A04);
        sb.append(A02(14, 21, 68));
        sb.append(this.A02);
        sb.append(A02(2, 12, 15));
        int i3 = 0;
        while (true) {
            C2217qT[] c2217qTArr = this.A05;
            String[] strArr = A07;
            String str = strArr[0];
            String str2 = strArr[2];
            int i4 = str.length();
            if (i4 == str2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[0] = "HwwbQlKsFzrVvgzZA70k";
            strArr2[2] = "CWSfdfe0R8gD4PU";
            int length = c2217qTArr.length;
            String strA02 = A02(77, 2, 17);
            if (i3 < length) {
                sb.append(A02(88, 15, 38));
                sb.append(this.A05[i3].A03);
                sb.append(A02(35, 7, 31));
                int i5 = 0;
                while (true) {
                    int length2 = this.A05[i3].A05.length;
                    String strA022 = A02(0, 2, 118);
                    if (i5 < length2) {
                        sb.append(A02(79, 9, 96));
                        int i6 = this.A05[i3].A05[i5];
                        switch (i6) {
                            case 0:
                                sb.append('_');
                                break;
                            case 1:
                                sb.append('R');
                                break;
                            case 2:
                                sb.append('S');
                                break;
                            case 3:
                                sb.append('P');
                                break;
                            case 4:
                                sb.append('!');
                                break;
                            default:
                                sb.append('?');
                                break;
                        }
                        sb.append(A02(42, 13, 61));
                        sb.append(this.A05[i3].A06[i5]);
                        sb.append(')');
                        int i7 = this.A05[i3].A05.length;
                        if (i5 < i7 - 1) {
                            sb.append(strA022);
                        }
                        i5++;
                    } else {
                        sb.append(strA02);
                        String[] strArr3 = A07;
                        String str3 = strArr3[5];
                        String str4 = strArr3[1];
                        int i8 = str3.length();
                        if (i8 == str4.length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A07;
                        strArr4[0] = "tpRIwkkikLxaZqXNkXQj";
                        strArr4[2] = "ureQIhKfJpTfNVp";
                        if (i3 < this.A05.length - 1) {
                            sb.append(strA022);
                        }
                        i3++;
                    }
                }
            } else {
                sb.append(strA02);
                return sb.toString();
            }
        }
    }
}
