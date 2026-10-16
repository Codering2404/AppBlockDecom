package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.websocket.CloseCodes;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AD extends C2189pz {
    public static byte[] A07;
    public static final AnonymousClass23<AD> A08;
    public static final String A09;
    public static final String A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final boolean A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C2208qI A04;
    public final C3C A05;
    public final String A06;

    public static /* synthetic */ AD A00(Bundle bundle) {
        return new AD(bundle);
    }

    public static String A05(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{Framer.EXIT_FRAME_PREFIX, -67, -54, -54, -57, -54, -124, Framer.EXIT_FRAME_PREFIX, -63, -58, -68, -67, -48, -107, -83, -95, -25, -16, -13, -18, -30, -11, -66, -37, -49, Ascii.NAK, Ascii.RS, Framer.ENTER_FRAME_PREFIX, Ascii.FS, Ascii.DLE, 35, Ascii.SO, 34, 36, Ascii.US, Ascii.US, Ascii.RS, Framer.ENTER_FRAME_PREFIX, 35, Ascii.DC4, 19, -20, -21, -47, -45, -26, -18, -16, -11, -26, -95, -26, -13, -13, -16, -13, -53, -25, -19, -22, -37, -35, -104, -35, -22, -22, -25, -22, -50, -25, -34, -15, -23, -34, -36, -19, -34, -35, -103, -21, -18, -25, -19, -30, -26, -34, -103, -34, -21, -21, -24, -21};
    }

    static {
        A07();
        A08 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.ot
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return AD.A00(bundle);
            }
        };
        A0E = C5C.A0h(AdError.NO_FILL_ERROR_CODE);
        A0D = C5C.A0h(1002);
        A0C = C5C.A0h(1003);
        A0A = C5C.A0h(1004);
        A0B = C5C.A0h(1005);
        A09 = C5C.A0h(CloseCodes.CLOSED_ABNORMALLY);
    }

    public AD(int i3, Throwable th, int i4) {
        this(i3, th, null, i4, null, -1, null, 4, false);
    }

    public AD(int i3, Throwable th, String str, int i4, String str2, int i5, C2208qI c2208qI, int i6, boolean z2) {
        this(A06(i3, th, str, str2, i5, c2208qI, i6), th, i4, i3, str2, i5, c2208qI, i6, null, SystemClock.elapsedRealtime(), z2);
    }

    public AD(Bundle bundle) {
        C2208qI c2208qI;
        super(bundle);
        this.A03 = bundle.getInt(A0E, 2);
        this.A06 = bundle.getString(A0D);
        this.A02 = bundle.getInt(A0C, -1);
        Bundle bundle2 = bundle.getBundle(A0A);
        if (bundle2 == null) {
            c2208qI = null;
        } else {
            c2208qI = (C2208qI) C2208qI.A0b.A6f(bundle2);
        }
        this.A04 = c2208qI;
        this.A01 = bundle.getInt(A0B, 4);
        this.A00 = bundle.getBoolean(A09, false);
        this.A05 = null;
    }

    public AD(String str, Throwable th, int i3, int i4, String str2, int i5, C2208qI c2208qI, int i6, C3C c3c, long j3, boolean z2) {
        super(str, th, i3, j3);
        AbstractC04323y.A07(!z2 || i4 == 1);
        AbstractC04323y.A07(th != null || i4 == 3);
        this.A03 = i4;
        this.A06 = str2;
        this.A02 = i5;
        this.A04 = c2208qI;
        this.A01 = i6;
        this.A05 = c3c;
        this.A00 = z2;
    }

    public static AD A01(IOException iOException, int i3) {
        return new AD(0, iOException, i3);
    }

    @Deprecated
    public static AD A02(RuntimeException runtimeException) {
        return A03(runtimeException, 1000);
    }

    public static AD A03(RuntimeException runtimeException, int i3) {
        return new AD(2, runtimeException, i3);
    }

    public static AD A04(Throwable th, String str, int i3, C2208qI c2208qI, int i4, boolean z2, int i5) {
        int i6 = i4;
        if (c2208qI == null) {
            i6 = 4;
        }
        return new AD(1, th, null, i5, str, i3, c2208qI, i6, z2);
    }

    public static String A06(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}, value = "Throwable cause - linked with Error reporting") int i3, Throwable th, String str, String str2, int i4, C2208qI c2208qI, int i5) {
        String message;
        String strA05;
        if (str == null) {
            message = th == null ? null : th.getMessage();
        } else {
            message = str;
        }
        if (message != null) {
            return message;
        }
        switch (i3) {
            case 0:
                strA05 = A05(56, 12, 59);
                break;
            case 1:
                StringBuilder sbAppend = new StringBuilder().append(str2);
                String message2 = A05(0, 14, 27);
                StringBuilder sbAppend2 = sbAppend.append(message2).append(i4);
                String message3 = A05(14, 9, 68);
                StringBuilder sbAppend3 = sbAppend2.append(message3).append(c2208qI);
                String message4 = A05(23, 19, 114);
                StringBuilder sbAppend4 = sbAppend3.append(message4);
                String message5 = C5C.A0g(i5);
                strA05 = sbAppend4.append(message5).toString();
                break;
            case 2:
            default:
                strA05 = A05(68, 24, 60);
                break;
            case 3:
                strA05 = A05(44, 12, 68);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbAppend5 = new StringBuilder().append(strA05);
            String message6 = A05(42, 2, 116);
            return sbAppend5.append(message6).append(str).toString();
        }
        return strA05;
    }
}
