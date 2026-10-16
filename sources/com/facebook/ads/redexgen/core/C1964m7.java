package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Rename the class for A/B Testing")
public final class C1964m7 implements H9 {
    public static byte[] A0Z;
    public static String[] A0a = {"vtb", "vbKonC", "9ohrxt3rIVPnhyMUHrYVmyK7bOK5FZ2r", "2NigTWH0ge82u7sbUdSeL8Wtj6iQtHIS", "zZrcpvCeqeJUqHmK3YGTET67EQVL4Dlr", "FEfAuyU", "TXQt6Bb5wsq1E0rpiydPRGzBJonmO6nW", "L3NiJ083BoYvWzKRwautviQbODBNEwGW"};
    public static final HD A0b;
    public static final C2208qI A0c;
    public static final byte[] A0d;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;

    @MetaExoPlayerCustomization("New field")
    public long A0A;
    public long A0B;
    public long A0C;
    public C04554v A0D;
    public HA A0E;
    public JA A0F;
    public boolean A0G;
    public boolean A0H;
    public InterfaceC0755Hd[] A0I;
    public InterfaceC0755Hd[] A0J;
    public final int A0K;
    public final SparseArray<JA> A0L;
    public final C04554v A0M;
    public final C04554v A0N;
    public final C04554v A0O;
    public final C04554v A0P;
    public final C04554v A0Q;
    public final AnonymousClass53 A0R;
    public final InterfaceC0755Hd A0S;
    public final I0 A0T;
    public final JO A0U;
    public final ArrayDeque<C1971mE> A0V;
    public final ArrayDeque<J9> A0W;
    public final List<C2208qI> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(JA ja, int i3, int i4, C04554v c04554v, int i5) throws C3K {
        int iA0C;
        int i6 = i5;
        c04554v.A0f(8);
        int iA00 = AbstractC0797Iu.A00(c04554v.A0C());
        JO jo = ja.A05.A03;
        JQ jq = ja.A09;
        J1 j12 = (J1) C5C.A0f(jq.A06);
        jq.A0C[i3] = c04554v.A0L();
        jq.A0E[i3] = jq.A04;
        if ((iA00 & 1) != 0) {
            long[] jArr = jq.A0E;
            jArr[i3] = jArr[i3] + ((long) c04554v.A0C());
        }
        boolean z2 = (iA00 & 4) != 0;
        int iA0C2 = j12.A01;
        if (z2) {
            iA0C2 = c04554v.A0C();
        }
        boolean z3 = (iA00 & Function.MAX_NARGS) != 0;
        boolean z4 = (iA00 & 512) != 0;
        boolean z5 = (iA00 & 1024) != 0;
        boolean z6 = (iA00 & 2048) != 0;
        long j3 = A0a(jo) ? ((long[]) C5C.A0f(jo.A09))[0] : 0L;
        int[] iArr = jq.A0B;
        long[] jArr2 = jq.A0D;
        boolean[] zArr = jq.A0G;
        boolean z7 = jo.A03 == 2 && (i4 & 1) != 0;
        int i7 = i6 + jq.A0C[i3];
        long j4 = jo.A06;
        long j5 = jq.A05;
        while (i6 < i7) {
            if (z3) {
                iA0C = c04554v.A0C();
                if (A0a[5].length() == 30) {
                    throw new RuntimeException();
                }
                A0a[0] = "Vvd";
            } else {
                iA0C = j12.A00;
            }
            int iA002 = A00(iA0C);
            int iA003 = A00(z4 ? c04554v.A0C() : j12.A03);
            int iA0C3 = z5 ? c04554v.A0C() : (i6 == 0 && z2) ? iA0C2 : j12.A01;
            jArr2[i6] = C5C.A0U((((long) (z6 ? c04554v.A0C() : 0)) + j5) - j3, 1000000L, j4);
            if (!jq.A09) {
                jArr2[i6] = jArr2[i6] + ja.A05.A02;
            }
            iArr[i6] = iA003;
            zArr[i6] = ((iA0C3 >> 16) & 1) == 0 && (!z7 || i6 == 0);
            j5 += (long) iA002;
            i6++;
        }
        jq.A05 = j5;
        return i7;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, C2004my> A05(C04554v c04554v, long j3) throws C3K {
        long jA0R;
        long jA0R2;
        c04554v.A0f(8);
        int iA01 = AbstractC0797Iu.A01(c04554v.A0C());
        c04554v.A0g(4);
        long jA0Q = c04554v.A0Q();
        if (iA01 == 0) {
            jA0R = c04554v.A0Q();
            jA0R2 = j3 + c04554v.A0Q();
        } else {
            jA0R = c04554v.A0R();
            jA0R2 = j3 + c04554v.A0R();
        }
        long jA0U = C5C.A0U(jA0R, 1000000L, jA0Q);
        c04554v.A0g(2);
        int iA0M = c04554v.A0M();
        int[] iArr = new int[iA0M];
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        long[] jArr3 = new long[iA0M];
        long jA0U2 = jA0U;
        for (int i3 = 0; i3 < iA0M; i3++) {
            int iA0C = c04554v.A0C();
            if ((Integer.MIN_VALUE & iA0C) != 0) {
                throw C3K.A01(A0A(756, 28, 79), null);
            }
            long jA0Q2 = c04554v.A0Q();
            iArr[i3] = Integer.MAX_VALUE & iA0C;
            jArr[i3] = jA0R2;
            jArr3[i3] = jA0U2;
            jA0R += jA0Q2;
            jA0U2 = C5C.A0U(jA0R, 1000000L, jA0Q);
            jArr2[i3] = jA0U2 - jArr3[i3];
            c04554v.A0g(4);
            jA0R2 += (long) iArr[i3];
        }
        return Pair.create(Long.valueOf(jA0U), new C2004my(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JA A09(C04554v c04554v, SparseArray<JA> sparseArray, boolean z2) {
        c04554v.A0f(8);
        int iA00 = AbstractC0797Iu.A00(c04554v.A0C());
        JA jaValueAt = z2 ? sparseArray.valueAt(0) : sparseArray.get(c04554v.A0C());
        if (jaValueAt == null) {
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[1] = "jDobgNhtM";
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0R = c04554v.A0R();
            jaValueAt.A09.A04 = jA0R;
            jaValueAt.A09.A03 = jA0R;
        }
        J1 j12 = jaValueAt.A04;
        jaValueAt.A09.A06 = new J1((iA00 & 2) != 0 ? c04554v.A0C() - 1 : j12.A02, (iA00 & 8) != 0 ? c04554v.A0C() : j12.A00, (iA00 & 16) != 0 ? c04554v.A0C() : j12.A03, (iA00 & 32) != 0 ? c04554v.A0C() : j12.A01);
        return jaValueAt;
    }

    public static String A0A(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Z, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[5] = "p0M5dFs6dnHIC4r2oiX9lIp2";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 74);
            i6++;
        }
    }

    public static void A0D() {
        A0Z = new byte[]{8, 65, 91, 8, 76, 65, 78, 78, 77, 90, 77, 70, 92, 8, 78, 90, 71, 69, 8, 78, 90, 73, 79, 69, 77, 70, 92, 8, 91, 73, 69, 88, 68, 77, 8, 75, 71, 93, 70, 92, 109, 36, 62, 109, 42, 63, 40, 44, 57, 40, 63, 109, 57, 37, 44, 35, 109, 43, 63, 44, 42, 32, 40, 35, 57, 109, 62, 44, 32, 61, Framer.ENTER_FRAME_PREFIX, 40, 109, 46, 34, 56, 35, 57, 47, Ascii.SUB, 1, 3, 78, Ascii.GS, 7, Ascii.DC4, Ascii.VT, 78, 2, Ascii.VT, Ascii.GS, Ascii.GS, 78, Ascii.SUB, 6, Ascii.SI, 0, 78, 6, Ascii.VT, Ascii.SI, 10, Ascii.VT, Ascii.FS, 78, 2, Ascii.VT, 0, 9, Ascii.SUB, 6, 78, 70, Ascii.ESC, 0, Ascii.GS, Ascii.ESC, Ascii.RS, Ascii.RS, 1, Ascii.FS, Ascii.SUB, Ascii.VT, 10, 71, 64, 70, 109, 119, 113, 122, 35, 96, 108, 118, 109, 119, 35, 106, 109, 35, 112, 97, 100, 115, 35, 34, 62, 35, Framer.STDERR_FRAME_PREFIX, 35, 43, 118, 109, 112, 118, 115, 115, 108, 113, 119, 102, 103, 42, Framer.STDIN_FRAME_PREFIX, Ascii.GS, 54, 44, 42, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 59, 55, Framer.STDIN_FRAME_PREFIX, 54, 44, Framer.EXIT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 54, Framer.EXIT_FRAME_PREFIX, 43, 63, 40, 60, Framer.EXIT_FRAME_PREFIX, 121, 101, Framer.EXIT_FRAME_PREFIX, 105, Framer.EXIT_FRAME_PREFIX, 112, Framer.STDIN_FRAME_PREFIX, 54, 43, Framer.STDIN_FRAME_PREFIX, 40, 40, 55, 42, 44, 61, 60, 113, 118, 71, 115, 96, 102, 108, 100, 111, 117, 100, 101, 76, 113, 53, 68, 121, 117, 115, 96, 98, 117, 110, 115, Ascii.SO, 32, 41, 40, 53, 46, 41, 32, 103, 41, 34, 32, 38, 51, 46, Framer.STDOUT_FRAME_PREFIX, 34, 103, 40, Framer.ENTER_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 52, 34, 51, 103, 51, 40, 103, 52, 38, 42, 55, 43, 34, 103, 35, 38, 51, 38, 105, 118, 81, 73, 94, 83, 86, 91, Ascii.US, 113, 126, 115, Ascii.US, 83, 90, 81, 88, 75, 87, 0, 41, Framer.STDIN_FRAME_PREFIX, 42, 108, Framer.STDIN_FRAME_PREFIX, 56, 35, Framer.ENTER_FRAME_PREFIX, 108, 40, 41, 42, 37, 34, 41, 63, 108, 41, 52, 56, 41, 34, 40, 41, 40, 108, Framer.STDIN_FRAME_PREFIX, 56, 35, Framer.ENTER_FRAME_PREFIX, 108, 63, 37, 54, 41, 108, 100, 57, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 101, 98, 75, 98, 102, 97, 39, 102, 115, 104, 106, 39, 112, 110, 115, 111, 39, 107, 98, 105, 96, 115, 111, 39, 57, 39, 53, 54, 51, 48, 51, 63, 52, Framer.STDOUT_FRAME_PREFIX, 51, 48, 39, 47, 114, 105, 116, 114, 119, 119, 104, 117, 115, 98, 99, 46, 41, 62, Ascii.ETB, Ascii.ETB, 2, Ascii.DC4, 5, 81, 5, Ascii.RS, 81, Ascii.DC4, Ascii.US, Ascii.DC2, 3, 8, 1, 5, Ascii.CAN, Ascii.RS, Ascii.US, 81, Ascii.NAK, Ascii.DLE, 5, Ascii.DLE, 81, 6, Ascii.DLE, 2, 81, Ascii.US, Ascii.DC4, Ascii.SYN, Ascii.DLE, 5, Ascii.CAN, 7, Ascii.DC4, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 81, 81, 68, 82, 67, Ascii.ETB, 67, 88, Ascii.ETB, 82, 89, 83, Ascii.ETB, 88, 81, Ascii.ETB, 90, 83, 86, 67, Ascii.ETB, 64, 86, 68, Ascii.ETB, 89, 82, 80, 86, 67, 94, 65, 82, Ascii.EM, Ascii.ESC, 34, Framer.STDOUT_FRAME_PREFIX, 38, 38, 61, 48, 61, 58, 51, 116, 0, 38, 53, 55, 63, 17, 58, 55, 38, Framer.STDIN_FRAME_PREFIX, 36, 32, 61, 59, 58, Ascii.SYN, 59, 44, 116, 36, 53, 38, 53, 57, Framer.STDOUT_FRAME_PREFIX, 32, Framer.STDOUT_FRAME_PREFIX, 38, 39, 116, 61, 39, 116, Framer.ENTER_FRAME_PREFIX, 58, 39, Framer.ENTER_FRAME_PREFIX, 36, 36, 59, 38, 32, Framer.STDOUT_FRAME_PREFIX, 48, 122, 35, 17, Ascii.EM, 10, 80, 3, 17, Ascii.GS, 0, Ascii.FS, Ascii.NAK, 80, 19, Ascii.US, 5, Ascii.RS, 4, 80, 70, 112, 123, 118, 53, 102, 116, Framer.EXIT_FRAME_PREFIX, 101, 121, 112, 53, 118, 122, 96, 123, 97, 53, 5, 61, 63, 38, 38, 51, Framer.STDERR_FRAME_PREFIX, 118, 38, 37, 37, 62, 118, 55, 34, 57, 59, 118, 126, 48, 55, 63, 58, 51, Framer.STDERR_FRAME_PREFIX, 118, 34, 57, 118, 51, 46, 34, 36, 55, 53, 34, 118, 35, 35, 63, Framer.STDERR_FRAME_PREFIX, Ascii.DEL, 78, 118, 116, 109, 109, 116, 115, 122, 61, 124, 105, 114, 112, 61, 106, 116, 105, 117, 61, 113, Framer.EXIT_FRAME_PREFIX, 115, 122, 105, 117, 61, 35, 61, 47, 44, 41, 42, 41, 37, 46, 43, 41, 42, 61, 53, 104, 115, 110, 104, 109, 109, 114, 111, 105, Framer.EXIT_FRAME_PREFIX, 121, 52, 51, 1, 57, 59, 34, 34, 59, 60, 53, 114, 39, 60, Framer.ENTER_FRAME_PREFIX, 39, 34, 34, 61, 32, 38, 55, 54, 114, 55, 63, Framer.ENTER_FRAME_PREFIX, 53, 114, 36, 55, 32, Framer.ENTER_FRAME_PREFIX, 59, 61, 60, 104, 114, Ascii.ETB, 44, 39, 58, Framer.STDERR_FRAME_PREFIX, 39, Framer.ENTER_FRAME_PREFIX, 54, 39, 38, 98, 47, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 52, 98, 32, Framer.STDIN_FRAME_PREFIX, 58, 108, 92, 103, 108, 113, 121, 108, 106, 125, 108, 109, 41, 103, 108, 110, 104, 125, 96, Ascii.DEL, 108, 41, Ascii.DEL, 104, 101, 124, 108, 51, 41, 35, Ascii.CAN, 19, Ascii.SO, 6, 19, Ascii.NAK, 2, 19, Ascii.DC2, 86, 5, Ascii.ETB, Ascii.US, Ascii.EM, 86, 19, Ascii.CAN, 2, 4, Ascii.SI, 86, Ascii.NAK, Ascii.EM, 3, Ascii.CAN, 2, 76, 86, 80, 107, 109, 100, 107, 97, 105, 96, 97, 37, 108, 107, 97, 108, 119, 96, 102, 113, 37, 119, 96, 99, 96, 119, 96, 107, 102, 96, 114, 69, 86, 77, 69, 70, 72, 65, 4, 72, 65, 74, 67, 80, 76, 4, 64, 65, 87, 71, 86, 77, 84, 80, 77, 75, 74, 4, 77, 74, 4, 87, 67, 84, 64, 4, 66, 75, 81, 74, 64, 4, Ascii.FF, 81, 74, 87, 81, 84, 84, 75, 86, 80, 65, 64, Ascii.CR, 102, 119, 119, 107, 110, 100, 102, 115, 110, 104, 105, 40, Ascii.DEL, 42, 98, 106, 116, 96, 88, 73, 73, 85, 80, 90, 88, 77, 80, 86, 87, Ascii.SYN, 65, Ascii.DC4, 84, 73, Ascii.CR, Ascii.DC4, 79, 77, 77, 52, 32, Framer.STDOUT_FRAME_PREFIX, 60, 58, 122, 52, 54, 97, 72, 87, 90, 91, 81, 17, 86, 91, 72, 93, 126, 97, 108, 109, 103, 39, 101, Framer.EXIT_FRAME_PREFIX, 60};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0H(C04554v c04554v, Uri uri) {
        String str;
        String str2;
        long jA05;
        long jA0U;
        long jA0Q;
        if (this.A0J.length == 0) {
            return;
        }
        c04554v.A0f(8);
        if (A0a[3].charAt(19) != 'e') {
            throw new RuntimeException();
        }
        A0a[1] = "i2btDlVidn";
        int iA01 = AbstractC0797Iu.A01(c04554v.A0C());
        long jA0U2 = -9223372036854775807L;
        switch (iA01) {
            case 0:
                str = (String) AbstractC04323y.A01(c04554v.A0U());
                str2 = (String) AbstractC04323y.A01(c04554v.A0U());
                long jA0Q2 = c04554v.A0Q();
                jA0U2 = C5C.A0U(c04554v.A0Q(), 1000000L, jA0Q2);
                jA05 = this.A0C != -9223372036854775807L ? this.A0C + jA0U2 : -9223372036854775807L;
                jA0U = C5C.A0U(c04554v.A0Q(), 1000L, jA0Q2);
                jA0Q = c04554v.A0Q();
                break;
            case 1:
                long jA0Q3 = c04554v.A0Q();
                jA05 = C5C.A0U(c04554v.A0R(), 1000000L, jA0Q3);
                jA0U = C5C.A0U(c04554v.A0Q(), 1000L, jA0Q3);
                jA0Q = c04554v.A0Q();
                str = (String) AbstractC04323y.A01(c04554v.A0U());
                str2 = (String) AbstractC04323y.A01(c04554v.A0U());
                break;
            default:
                AbstractC04404g.A07(A0A(204, 22, 75), A0A(645, 35, 24) + iA01);
                return;
        }
        byte[] bArr = new byte[c04554v.A07()];
        c04554v.A0k(bArr, 0, c04554v.A07());
        int i3 = 0;
        C04554v c04554v2 = new C04554v(this.A0T.A01(new EventMessage(str, str2, jA0U, jA0Q, bArr)));
        int iA07 = c04554v2.A07();
        InterfaceC0755Hd[] interfaceC0755HdArr = this.A0J;
        int length = interfaceC0755HdArr.length;
        int i4 = 0;
        while (i4 < length) {
            InterfaceC0755Hd interfaceC0755Hd = interfaceC0755HdArr[i4];
            c04554v2.A0f(i3);
            interfaceC0755Hd.AKf(uri);
            interfaceC0755Hd.AIr(c04554v2, iA07);
            i4++;
            i3 = 0;
        }
        if (jA05 == -9223372036854775807L) {
            this.A0W.addLast(new J9(jA0U2, true, iA07));
            this.A03 += iA07;
            return;
        }
        if (!this.A0W.isEmpty()) {
            this.A0W.addLast(new J9(jA05, false, iA07));
            this.A03 += iA07;
            return;
        }
        if (this.A0R != null) {
            AnonymousClass53 anonymousClass53 = this.A0R;
            if (A0a[1].length() != 3) {
                String[] strArr = A0a;
                strArr[4] = "dSij3ZZr7drragDO7KaW8OWZIZwByPGb";
                strArr[6] = "O4MuDOrrUt3KGtyHElmFzP2mmpN9Ut0I";
                jA05 = anonymousClass53.A05(jA05);
            } else {
                jA05 = anonymousClass53.A05(jA05);
            }
        }
        if (this.A0A != -9223372036854775807L && !MetaExoPlayerUpgradeConfig.A03(EnumC1808jX.A11)) {
            jA05 = this.A0A;
        }
        InterfaceC0755Hd[] interfaceC0755HdArr2 = this.A0J;
        if (A0a[0].length() != 3) {
            throw new RuntimeException();
        }
        A0a[2] = "lJ55r5gDB38Ao7rNsYIhv4IUy3LH5Ini";
        for (InterfaceC0755Hd interfaceC0755Hd2 : interfaceC0755HdArr2) {
            interfaceC0755Hd2.AIu(jA05, 1, iA07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0R(C1971mE c1971mE, SparseArray<JA> sparseArray, boolean z2, int i3, byte[] bArr) throws C3K {
        JA jaA09 = A09(((C1970mD) AbstractC04323y.A01(c1971mE.A07(1952868452))).A00, sparseArray, z2);
        if (jaA09 == null) {
            return;
        }
        JQ jq = jaA09.A09;
        long j3 = jq.A05;
        boolean z3 = jq.A09;
        jaA09.A08();
        jaA09.A06 = true;
        C1970mD c1970mDA07 = c1971mE.A07(1952867444);
        if (c1970mDA07 == null || (i3 & 2) != 0) {
            jq.A05 = j3;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[7] = "mrSj0GzHTHwkPK2z0oCyoB4jTU17nK7M";
            jq.A09 = z3;
        } else {
            jq.A05 = A03(c1970mDA07.A00);
            jq.A09 = true;
        }
        A0S(c1971mE, jaA09, i3);
        JO jo = jaA09.A05.A03;
        Object objA01 = AbstractC04323y.A01(jq.A06);
        String[] strArr2 = A0a;
        if (strArr2[4].charAt(20) == strArr2[6].charAt(20)) {
            throw new RuntimeException();
        }
        A0a[1] = "vW8YzoDO1k8YQphW8Ysx";
        JP jpA00 = jo.A00(((J1) objA01).A02);
        C1970mD c1970mDA072 = c1971mE.A07(1935763834);
        if (c1970mDA072 != null) {
            A0V((JP) AbstractC04323y.A01(jpA00), c1970mDA072.A00, jq);
        }
        C1970mD c1970mDA073 = c1971mE.A07(1935763823);
        if (c1970mDA073 != null) {
            A0I(c1970mDA073.A00, jq);
        }
        C1970mD c1970mDA074 = c1971mE.A07(1936027235);
        if (c1970mDA074 != null) {
            A0J(c1970mDA074.A00, jq);
        }
        A0T(c1971mE, jpA00 != null ? jpA00.A02 : null, jq);
        int size = c1971mE.A02.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1970mD c1970mD = c1971mE.A02.get(i4);
            if (((AbstractC0797Iu) c1970mD).A00 == 1970628964) {
                A0K(c1970mD.A00, jq, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0T(C1971mE c1971mE, String str, JQ jq) throws C3K {
        C04554v c04554v = null;
        C04554v c04554v2 = null;
        for (int i3 = 0; i3 < c1971mE.A02.size(); i3++) {
            C1970mD c1970mD = c1971mE.A02.get(i3);
            C04554v c04554v3 = c1970mD.A00;
            if (((AbstractC0797Iu) c1970mD).A00 == 1935828848) {
                c04554v3.A0f(12);
                if (c04554v3.A0C() == 1936025959) {
                    c04554v = c04554v3;
                }
            } else if (((AbstractC0797Iu) c1970mD).A00 == 1936158820) {
                c04554v3.A0f(12);
                if (c04554v3.A0C() == 1936025959) {
                    c04554v2 = c04554v3;
                }
            }
        }
        if (c04554v == null || c04554v2 == null) {
            return;
        }
        c04554v.A0f(8);
        int iA01 = AbstractC0797Iu.A01(c04554v.A0C());
        c04554v.A0g(4);
        if (iA01 == 1) {
            c04554v.A0g(4);
        }
        if (c04554v.A0C() != 1) {
            throw C3K.A00(A0A(126, 39, 73));
        }
        c04554v2.A0f(8);
        int iA012 = AbstractC0797Iu.A01(c04554v2.A0C());
        c04554v2.A0g(4);
        if (iA012 == 1) {
            if (c04554v2.A0Q() == 0) {
                throw C3K.A00(A0A(784, 55, 110));
            }
        } else if (iA012 >= 2) {
            c04554v2.A0g(4);
        }
        if (c04554v2.A0Q() != 1) {
            throw C3K.A00(A0A(165, 39, 18));
        }
        c04554v2.A0g(1);
        int iA0I = c04554v2.A0I();
        int i4 = (iA0I & 240) >> 4;
        int i5 = iA0I & 15;
        boolean z2 = c04554v2.A0I() == 1;
        if (z2) {
            int iA0I2 = c04554v2.A0I();
            byte[] bArr = new byte[16];
            c04554v2.A0k(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (iA0I2 == 0) {
                int iA0I3 = c04554v2.A0I();
                bArr2 = new byte[iA0I3];
                c04554v2.A0k(bArr2, 0, iA0I3);
            }
            jq.A08 = true;
            jq.A07 = new JP(z2, str, iA0I2, bArr, i4, i5, bArr2);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0V(JP jp, C04554v c04554v, JQ jq) throws C3K {
        int i3 = jp.A00;
        c04554v.A0f(8);
        if ((AbstractC0797Iu.A00(c04554v.A0C()) & 1) == 1) {
            c04554v.A0g(8);
        }
        int iA0I = c04554v.A0I();
        int iA0L = c04554v.A0L();
        if (iA0L > jq.A00) {
            throw C3K.A01(A0A(514, 18, 58) + iA0L + A0A(40, 38, 7) + jq.A00, null);
        }
        int i4 = 0;
        if (iA0I == 0) {
            boolean[] zArr = jq.A0F;
            if (A0a[1].length() == 3) {
                throw new RuntimeException();
            }
            A0a[0] = "ACu";
            for (int i5 = 0; i5 < iA0L; i5++) {
                int iA0I2 = c04554v.A0I();
                i4 += iA0I2;
                zArr[i5] = iA0I2 > i3;
            }
        } else {
            i4 = 0 + (iA0I * iA0L);
            Arrays.fill(jq.A0F, 0, iA0L, iA0I > i3);
        }
        Arrays.fill(jq.A0F, iA0L, jq.A00, false);
        if (i4 > 0) {
            jq.A02(i4);
        }
    }

    static {
        A0D();
        A0b = new HD() { // from class: com.facebook.ads.redexgen.X.m8
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1964m7.A0b();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0d = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0c = new C03992p().A11(A0A(839, 18, 77)).A14();
    }

    public C1964m7() {
        this(0);
    }

    public C1964m7(int i3) {
        this(i3, null);
    }

    public C1964m7(int i3, AnonymousClass53 anonymousClass53) {
        this(i3, anonymousClass53, null, Collections.emptyList());
    }

    public C1964m7(int i3, AnonymousClass53 anonymousClass53, JO jo, List<C2208qI> list) {
        this(i3, anonymousClass53, jo, list, null);
    }

    @MetaExoPlayerCustomization("Additional fields for custom behaviors")
    public C1964m7(int i3, AnonymousClass53 anonymousClass53, JO jo, List<C2208qI> list, InterfaceC0755Hd interfaceC0755Hd) {
        this.A0A = -9223372036854775807L;
        this.A0K = i3;
        this.A0R = anonymousClass53;
        this.A0U = jo;
        this.A0X = Collections.unmodifiableList(list);
        this.A0S = interfaceC0755Hd;
        this.A0T = new I0();
        this.A0M = new C04554v(16);
        this.A0P = new C04554v(HS.A03);
        this.A0O = new C04554v(5);
        this.A0N = new C04554v();
        this.A0Y = new byte[16];
        this.A0Q = new C04554v(this.A0Y);
        this.A0V = new ArrayDeque<>();
        this.A0W = new ArrayDeque<>();
        this.A0L = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        this.A0C = -9223372036854775807L;
        this.A0E = HA.A00;
        this.A0J = new InterfaceC0755Hd[0];
        this.A0I = new InterfaceC0755Hd[0];
    }

    public static int A00(int i3) throws C3K {
        if (i3 >= 0) {
            return i3;
        }
        throw C3K.A01(A0A(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 27, 67) + i3, null);
    }

    public static long A02(C04554v c04554v) {
        c04554v.A0f(8);
        int fullAtom = c04554v.A0C();
        return AbstractC0797Iu.A01(fullAtom) == 0 ? c04554v.A0Q() : c04554v.A0R();
    }

    public static long A03(C04554v c04554v) {
        c04554v.A0f(8);
        int fullAtom = c04554v.A0C();
        int version = AbstractC0797Iu.A01(fullAtom);
        return version == 1 ? c04554v.A0R() : c04554v.A0Q();
    }

    public static Pair<Integer, J1> A04(C04554v c04554v) {
        c04554v.A0f(12);
        int defaultSampleDescriptionIndex = c04554v.A0C();
        int trackId = c04554v.A0C();
        int defaultSampleFlags = c04554v.A0C();
        int defaultSampleSize = c04554v.A0C();
        int defaultSampleDuration = c04554v.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new J1(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A06(List<C1970mD> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            C1970mD c1970mD = list.get(i3);
            int leafChildrenSize = ((AbstractC0797Iu) c1970mD).A00;
            if (leafChildrenSize == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrA0l = c1970mD.A00.A0l();
                UUID uuidA02 = JH.A02(bArrA0l);
                if (uuidA02 == null) {
                    AbstractC04404g.A07(A0A(204, 22, 75), A0A(550, 42, 28));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0A(897, 9, 66), bArrA0l));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private J1 A07(SparseArray<J1> sparseArray, int i3) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (J1) AbstractC04323y.A01(sparseArray.get(i3));
    }

    public static JA A08(SparseArray<JA> sparseArray) {
        JA ja = null;
        long j3 = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            JA jaValueAt = sparseArray.valueAt(i3);
            if (jaValueAt.A06 || jaValueAt.A01 != jaValueAt.A05.A01) {
                boolean z2 = jaValueAt.A06;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "bWFL5LbHycaN2QeAwKakifUxbxentXmn";
                if (!z2 || jaValueAt.A02 != jaValueAt.A09.A01) {
                    long nextSampleOffset = jaValueAt.A05();
                    if (nextSampleOffset < j3) {
                        ja = jaValueAt;
                        j3 = nextSampleOffset;
                    }
                }
            }
        }
        return ja;
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r7 = this;
            r5 = 100
            r0 = 2
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC0755Hd[r0]
            r7.A0J = r0
            r6 = 0
            com.facebook.ads.redexgen.X.Hd r0 = r7.A0S
            if (r0 == 0) goto L15
            com.facebook.ads.redexgen.X.Hd[] r2 = r7.A0J
            int r1 = r6 + 1
            com.facebook.ads.redexgen.X.Hd r0 = r7.A0S
            r2[r6] = r0
            r6 = r1
        L15:
            int r0 = r7.A0K
            r0 = r0 & 4
            if (r0 == 0) goto L2c
            com.facebook.ads.redexgen.X.Hd[] r4 = r7.A0J
            int r3 = r6 + 1
            com.facebook.ads.redexgen.X.HA r2 = r7.A0E
            int r1 = r5 + 1
            r0 = 5
            com.facebook.ads.redexgen.X.Hd r0 = r2.AKS(r5, r0)
            r4[r6] = r0
            r6 = r3
            r5 = r1
        L2c:
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0J
            java.lang.Object[] r0 = com.facebook.ads.redexgen.core.C5C.A1I(r0, r6)
            com.facebook.ads.redexgen.X.Hd[] r0 = (com.facebook.ads.redexgen.core.InterfaceC0755Hd[]) r0
            r7.A0J = r0
            com.facebook.ads.redexgen.X.Hd[] r4 = r7.A0J
            int r3 = r4.length
            r2 = 0
        L3a:
            if (r2 >= r3) goto L46
            r1 = r4[r2]
            com.facebook.ads.redexgen.X.qI r0 = com.facebook.ads.redexgen.core.C1964m7.A0c
            r1.A6e(r0)
            int r2 = r2 + 1
            goto L3a
        L46:
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r7.A0X
            int r0 = r0.size()
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC0755Hd[r0]
            r7.A0I = r0
            r3 = 0
        L51:
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0I
            int r0 = r0.length
            if (r3 >= r0) goto L72
            com.facebook.ads.redexgen.X.HA r1 = r7.A0E
            int r2 = r5 + 1
            r0 = 3
            com.facebook.ads.redexgen.X.Hd r1 = r1.AKS(r5, r0)
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r7.A0X
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.qI r0 = (com.facebook.ads.redexgen.core.C2208qI) r0
            r1.A6e(r0)
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0I
            r0[r3] = r1
            int r3 = r3 + 1
            r5 = r2
            goto L51
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1964m7.A0C():void");
    }

    private void A0E(long j3) {
        while (!this.A0W.isEmpty()) {
            J9 j9RemoveFirst = this.A0W.removeFirst();
            this.A03 -= j9RemoveFirst.A00;
            if (A0a[7].charAt(28) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A0a;
            strArr[4] = "VR2FeNKrGWLUx6XQMfWHox9ZNtks2zuu";
            strArr[6] = "s2y9CEVkGFcMGmJDsuNOnRFQ2pMNKAx2";
            long jA05 = j9RemoveFirst.A01;
            if (j9RemoveFirst.A02) {
                jA05 += j3;
            }
            if (this.A0R != null) {
                jA05 = this.A0R.A05(jA05);
            }
            for (InterfaceC0755Hd interfaceC0755Hd : this.A0J) {
                interfaceC0755Hd.AIu(jA05, 1, j9RemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0F(long j3) throws C3K {
        while (!this.A0V.isEmpty() && this.A0V.peek().A00 == j3) {
            A0N(this.A0V.pop());
        }
        A0B();
    }

    public static void A0G(C04554v c04554v, int i3, JQ jq) throws C3K {
        c04554v.A0f(i3 + 8);
        int fullAtom = c04554v.A0C();
        int flags = AbstractC0797Iu.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z2 = fullAtom3 != 0;
            int sampleCount = c04554v.A0L();
            if (sampleCount == 0) {
                boolean[] zArr = jq.A0F;
                int fullAtom4 = jq.A00;
                Arrays.fill(zArr, 0, fullAtom4, false);
                return;
            }
            int fullAtom5 = jq.A00;
            if (sampleCount == fullAtom5) {
                Arrays.fill(jq.A0F, 0, sampleCount, z2);
                int fullAtom6 = c04554v.A07();
                jq.A02(fullAtom6);
                jq.A04(c04554v);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0A(532, 18, 95)).append(sampleCount).append(A0A(0, 40, 98));
            int fullAtom7 = jq.A00;
            throw C3K.A01(sbAppend.append(fullAtom7).toString(), null);
        }
        throw C3K.A00(A0A(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 56, 30));
    }

    public static void A0I(C04554v c04554v, JQ jq) throws C3K {
        c04554v.A0f(8);
        int flags = c04554v.A0C();
        int fullAtom = AbstractC0797Iu.A00(flags) & 1;
        if (fullAtom == 1) {
            c04554v.A0g(8);
        }
        int iA0L = c04554v.A0L();
        if (iA0L == 1) {
            int entryCount = AbstractC0797Iu.A01(flags);
            jq.A03 += entryCount == 0 ? c04554v.A0Q() : c04554v.A0R();
            return;
        }
        throw C3K.A01(A0A(727, 29, 60) + iA0L, null);
    }

    public static void A0J(C04554v c04554v, JQ jq) throws C3K {
        A0G(c04554v, 0, jq);
    }

    public static void A0K(C04554v c04554v, JQ jq, byte[] bArr) throws C3K {
        c04554v.A0f(8);
        c04554v.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0d)) {
            return;
        }
        A0G(c04554v, 16, jq);
    }

    @MetaExoPlayerCustomization("New parameter for getUri()")
    private void A0L(InterfaceC1999ms interfaceC1999ms) throws IOException {
        int i3 = ((int) this.A07) - this.A00;
        C04554v c04554v = this.A0D;
        if (c04554v != null) {
            interfaceC1999ms.readFully(c04554v.A0l(), 8, i3);
            A0U(new C1970mD(this.A01, c04554v), interfaceC1999ms.A8n(), interfaceC1999ms.A9P());
        } else {
            interfaceC1999ms.AK3(i3);
        }
        A0F(interfaceC1999ms.A8n());
    }

    private void A0M(InterfaceC1999ms interfaceC1999ms) throws IOException {
        JA jaValueAt = null;
        long j3 = Long.MAX_VALUE;
        int size = this.A0L.size();
        for (int i3 = 0; i3 < size; i3++) {
            JA nextTrackBundle = this.A0L.valueAt(i3);
            JQ jq = nextTrackBundle.A09;
            if (jq.A0A && jq.A03 < j3) {
                j3 = jq.A03;
                jaValueAt = this.A0L.valueAt(i3);
            }
        }
        if (jaValueAt == null) {
            this.A02 = 3;
            return;
        }
        int iA8n = (int) (j3 - interfaceC1999ms.A8n());
        if (iA8n >= 0) {
            interfaceC1999ms.AK3(iA8n);
            jaValueAt.A09.A05(interfaceC1999ms);
            return;
        }
        throw C3K.A01(A0A(384, 39, 59), null);
    }

    private void A0N(C1971mE c1971mE) throws C3K {
        if (((AbstractC0797Iu) c1971mE).A00 == 1836019574) {
            A0P(c1971mE);
            return;
        }
        if (((AbstractC0797Iu) c1971mE).A00 == 1836019558) {
            A0O(c1971mE);
            return;
        }
        if (this.A0V.isEmpty()) {
            return;
        }
        C1971mE c1971mEPeek = this.A0V.peek();
        if (A0a[1].length() == 3) {
            throw new RuntimeException();
        }
        A0a[5] = "pjYwVuiFyV8fJrHeJXv5AlOqs";
        c1971mEPeek.A08(c1971mE);
    }

    private void A0O(C1971mE c1971mE) throws C3K {
        A0Q(c1971mE, this.A0L, this.A0U != null, this.A0K, this.A0Y);
        DrmInitData drmInitDataA06 = A06(c1971mE.A02);
        if (drmInitDataA06 != null) {
            int i3 = this.A0L.size();
            for (int trackCount = 0; trackCount < i3; trackCount++) {
                this.A0L.valueAt(trackCount).A0B(drmInitDataA06);
            }
        }
        long j3 = this.A0B;
        if (A0a[5].length() != 30) {
            String[] strArr = A0a;
            strArr[4] = "qdUBZHhFhQeTbxiPtlDH0srS7WoJbCtx";
            strArr[6] = "eg1L367OGrFS41anHFQFHM93YBMqVnGW";
            if (j3 != -9223372036854775807L) {
                int size = this.A0L.size();
                for (int i4 = 0; i4 < size; i4++) {
                    JA jaValueAt = this.A0L.valueAt(i4);
                    long j4 = this.A0B;
                    int trackCount2 = A0a[5].length();
                    if (trackCount2 != 30) {
                        A0a[3] = "ExaTttTG7QLu5ZnLvMbeVx0ab4jt6cU8";
                        jaValueAt.A0A(j4);
                    }
                }
                this.A0B = -9223372036854775807L;
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0P(C1971mE c1971mE) throws C3K {
        AbstractC04323y.A0A(this.A0U == null, A0A(680, 20, 8));
        DrmInitData drmInitDataA06 = A06(c1971mE.A02);
        C1971mE c1971mE2 = (C1971mE) AbstractC04323y.A01(c1971mE.A06(1836475768));
        SparseArray<J1> sparseArray = new SparseArray<>();
        long jA02 = -9223372036854775807L;
        int size = c1971mE2.A02.size();
        for (int i3 = 0; i3 < size; i3++) {
            C1970mD c1970mD = c1971mE2.A02.get(i3);
            if (((AbstractC0797Iu) c1970mD).A00 == 1953654136) {
                Pair<Integer, J1> pairA04 = A04(c1970mD.A00);
                Object obj = pairA04.first;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "1hJqa9Igz9YM2Xn7uSuVVZMPlDpSi7YR";
                sparseArray.put(((Integer) obj).intValue(), (J1) pairA04.second);
            } else if (((AbstractC0797Iu) c1970mD).A00 == 1835362404) {
                jA02 = A02(c1970mD.A00);
            }
        }
        List<JR> listA0O = J0.A0O(c1971mE, new HK(), jA02, drmInitDataA06, (this.A0K & 16) != 0, false, new InterfaceC1859kO() { // from class: com.facebook.ads.redexgen.X.m9
            @Override // com.facebook.ads.redexgen.core.InterfaceC1859kO
            public final Object A4B(Object obj2) {
                return this.A00.A0c((JO) obj2);
            }
        });
        int size2 = listA0O.size();
        if (this.A0L.size() == 0) {
            for (int i4 = 0; i4 < size2; i4++) {
                JR jr = listA0O.get(i4);
                JO jo = jr.A03;
                this.A0L.put(jo.A00, new JA(this.A0E.AKS(i4, jo.A03), jr, A07(sparseArray, jo.A00)));
                this.A08 = Math.max(this.A08, jo.A04);
            }
            this.A0E.A6O();
            return;
        }
        AbstractC04323y.A08(this.A0L.size() == size2);
        for (int i5 = 0; i5 < size2; i5++) {
            JR jr2 = listA0O.get(i5);
            JO jo2 = jr2.A03;
            this.A0L.get(jo2.A00).A0C(jr2, A07(sparseArray, jo2.A00));
        }
    }

    public static void A0Q(C1971mE c1971mE, SparseArray<JA> sparseArray, boolean z2, int i3, byte[] bArr) throws C3K {
        int size = c1971mE.A01.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1971mE child = c1971mE.A01.get(i4);
            int i5 = ((AbstractC0797Iu) child).A00;
            if (i5 == 1953653094) {
                A0R(child, sparseArray, z2, i3, bArr);
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0S(com.facebook.ads.redexgen.core.C1971mE r8, com.facebook.ads.redexgen.core.JA r9, int r10) throws com.facebook.ads.redexgen.core.C3K {
        /*
            r4 = 0
            r3 = 0
            java.util.List<com.facebook.ads.redexgen.X.mD> r8 = r8.A02
            int r7 = r8.size()
            r5 = 0
        L9:
            r6 = 1953658222(0x7472756e, float:7.683823E31)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1964m7.A0a
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 30
            if (r1 == r0) goto L67
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1964m7.A0a
            java.lang.String r1 = "g5KWW"
            r0 = 1
            r2[r0] = r1
            if (r5 >= r7) goto L3f
            java.lang.Object r1 = r8.get(r5)
            com.facebook.ads.redexgen.X.mD r1 = (com.facebook.ads.redexgen.core.C1970mD) r1
            int r0 = r1.A00
            if (r0 != r6) goto L3c
            com.facebook.ads.redexgen.X.4v r1 = r1.A00
            r0 = 12
            r1.A0f(r0)
            int r0 = r1.A0L()
            if (r0 <= 0) goto L3c
            int r3 = r3 + r0
            int r4 = r4 + 1
        L3c:
            int r5 = r5 + 1
            goto L9
        L3f:
            r0 = 0
            r9.A02 = r0
            r9.A00 = r0
            r9.A01 = r0
            com.facebook.ads.redexgen.X.JQ r0 = r9.A09
            r0.A03(r4, r3)
            r5 = 0
            r0 = 0
            r4 = 0
        L4e:
            if (r4 >= r7) goto L66
            java.lang.Object r3 = r8.get(r4)
            com.facebook.ads.redexgen.X.mD r3 = (com.facebook.ads.redexgen.core.C1970mD) r3
            int r1 = r3.A00
            if (r1 != r6) goto L63
            int r2 = r5 + 1
            com.facebook.ads.redexgen.X.4v r1 = r3.A00
            int r0 = A01(r9, r5, r10, r1, r0)
            r5 = r2
        L63:
            int r4 = r4 + 1
            goto L4e
        L66:
            return
        L67:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1964m7.A0S(com.facebook.ads.redexgen.X.mE, com.facebook.ads.redexgen.X.JA, int):void");
    }

    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0U(C1970mD c1970mD, long j3, Uri uri) throws C3K {
        if (!this.A0V.isEmpty()) {
            this.A0V.peek().A09(c1970mD);
            return;
        }
        if (((AbstractC0797Iu) c1970mD).A00 == 1936286840) {
            Pair<Long, C2004my> pairA05 = A05(c1970mD.A00, j3);
            Long l3 = (Long) pairA05.first;
            if (A0a[2].charAt(14) == 'D') {
                throw new RuntimeException();
            }
            A0a[2] = "KqHjYmkkmLRftUSzBx7x8q1P7pbSwwaZ";
            this.A0C = l3.longValue();
            this.A0E.AJ7((HY) pairA05.second);
            this.A0G = true;
            return;
        }
        if (((AbstractC0797Iu) c1970mD).A00 != 1701671783 || uri == null) {
            return;
        }
        A0H(c1970mD.A00, uri);
    }

    public static boolean A0W(int i3) {
        return i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1836019558 || i3 == 1953653094 || i3 == 1836475768 || i3 == 1701082227;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0X(int r4) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1964m7.A0X(int):boolean");
    }

    private boolean A0Y(InterfaceC1999ms interfaceC1999ms) throws IOException {
        int trackCount;
        int i3;
        if (this.A00 == 0) {
            C04554v c04554v = this.A0M;
            if (A0a[2].charAt(14) != 'D') {
                A0a[5] = "Du9yMjOrUhZNFJE5GgCY";
                if (!interfaceC1999ms.AHR(c04554v.A0l(), 0, 8, true)) {
                    return false;
                }
                this.A00 = 8;
                this.A0M.A0f(0);
                this.A07 = this.A0M.A0Q();
                int iA0C = this.A0M.A0C();
                if (A0a[5].length() != 30) {
                    A0a[0] = "Nk2";
                    this.A01 = iA0C;
                }
            }
            throw new RuntimeException();
        }
        if (this.A07 == 1) {
            interfaceC1999ms.readFully(this.A0M.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A07 = this.A0M.A0R();
        } else if (this.A07 == 0) {
            long jA8O = interfaceC1999ms.A8O();
            if (jA8O == -1 && !this.A0V.isEmpty()) {
                jA8O = this.A0V.peek().A00;
            }
            if (jA8O != -1) {
                long jA8n = jA8O - interfaceC1999ms.A8n();
                int trackCount2 = this.A00;
                this.A07 = jA8n + ((long) trackCount2);
            }
        }
        if (this.A07 >= this.A00) {
            long jA8n2 = interfaceC1999ms.A8n() - ((long) this.A00);
            if ((this.A01 == 1836019558 || this.A01 == 1835295092) && !this.A0G) {
                this.A0E.AJ7(new C1994mn(this.A08, jA8n2));
                this.A0G = true;
            }
            if (this.A01 == 1836019558) {
                SparseArray<JA> sparseArray = this.A0L;
                if (A0a[0].length() != 3) {
                    A0a[7] = "3NdiubR5fLBwA18U1YAUjfhOdAcmjZCx";
                    trackCount = sparseArray.size();
                    i3 = 0;
                } else {
                    A0a[0] = "3Yh";
                    trackCount = sparseArray.size();
                    i3 = 0;
                }
                while (i3 < trackCount) {
                    JQ jq = this.A0L.valueAt(i3).A09;
                    jq.A02 = jA8n2;
                    jq.A03 = jA8n2;
                    jq.A04 = jA8n2;
                    i3++;
                }
            }
            int trackCount3 = this.A01;
            if (trackCount3 == 1835295092) {
                this.A0F = null;
                this.A09 = this.A07 + jA8n2;
                this.A02 = 2;
                return true;
            }
            if (A0W(this.A01)) {
                long jA8n3 = (interfaceC1999ms.A8n() + this.A07) - 8;
                this.A0V.push(new C1971mE(this.A01, jA8n3));
                if (this.A07 == this.A00) {
                    A0F(jA8n3);
                } else {
                    A0B();
                }
            } else if (A0X(this.A01)) {
                if (this.A00 != 8) {
                    throw C3K.A00(A0A(284, 51, 6));
                }
                if (this.A07 <= 2147483647L) {
                    C04554v c04554v2 = new C04554v((int) this.A07);
                    C04554v atomData = this.A0M;
                    System.arraycopy(atomData.A0l(), 0, c04554v2.A0l(), 0, 8);
                    this.A0D = c04554v2;
                    this.A02 = 1;
                } else {
                    throw C3K.A00(A0A(335, 49, 77));
                }
            } else if (this.A07 <= 2147483647L) {
                this.A0D = null;
                this.A02 = 1;
            } else {
                throw C3K.A00(A0A(592, 53, 87));
            }
            return true;
        }
        throw C3K.A00(A0A(78, 48, 36));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r19.AK3(r3);
        A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0246, code lost:
    
        throw com.facebook.ads.redexgen.core.C3K.A01(A0A(423, 35, 125), null);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ba  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Mark text samples as sync frames")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0Z(com.facebook.ads.redexgen.core.InterfaceC1999ms r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1964m7.A0Z(com.facebook.ads.redexgen.X.ms):boolean");
    }

    public static boolean A0a(JO jo) {
        if (jo.A08 == null || jo.A08.length != 1 || jo.A09 == null) {
            return false;
        }
        if (jo.A08[0] == 0) {
            return true;
        }
        long editListEndMediaTimeUs = C5C.A0U(jo.A08[0] + jo.A09[0], 1000000L, jo.A05);
        if (A0a[2].charAt(14) == 'D') {
            throw new RuntimeException();
        }
        A0a[1] = "wHdUW";
        return editListEndMediaTimeUs >= jo.A04;
    }

    public static /* synthetic */ H9[] A0b() {
        return new H9[]{new C1963m6()};
    }

    public final JO A0c(JO jo) {
        return jo;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0E = ha;
        A0B();
        A0C();
        if (this.A0U != null) {
            this.A0L.put(0, new JA(ha.AKS(0, this.A0U.A03), new JR(this.A0U, new long[0], new int[0], 0, new long[0], new int[0], 0L), new J1(0, 0, 0, 0)));
            this.A0E.A6O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        while (true) {
            switch (this.A02) {
                case 0:
                    if (!A0Y(interfaceC1999ms)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0L(interfaceC1999ms);
                    break;
                case 2:
                    A0M(interfaceC1999ms);
                    break;
                default:
                    if (A0Z(interfaceC1999ms)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j3, long j4) {
        int size = this.A0L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.A0L.valueAt(i3).A08();
        }
        this.A0W.clear();
        this.A03 = 0;
        this.A0B = j4;
        this.A0V.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        return JM.A01(interfaceC1999ms);
    }
}
