package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdSettings;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1749iP implements U3 {
    public static byte[] A03;
    public final Bundle A00;
    public final String A01;
    public final String A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{83, 94, 94, 93, 78, 84, 73, 65, 93, 88, 82, 88, 69, 78, 69, 84, 66, 69, 78, 92, 94, 85, 84, 78, 90, 84, 72, 67, 78, 78, 77, 94, 72, 82, 94, 84, 79, 72, 85, 88, Ascii.FF, 1, 1, 2, 17, 3, 7, Ascii.SYN, Ascii.VT, 10, 17, Ascii.SI, Ascii.ESC, 10, 7, Ascii.VT, 0, Ascii.CR, Ascii.VT, 17, 5, Ascii.VT, Ascii.ETB, 32, 37, 48, 37, 59, 52, 54, 43, 39, Framer.ENTER_FRAME_PREFIX, 55, 55, Framer.STDIN_FRAME_PREFIX, 42, 35, 59, 43, 52, 48, Framer.STDIN_FRAME_PREFIX, 43, 42, 55, 59, 39, 43, Framer.STDOUT_FRAME_PREFIX, 42, 48, 54, 61, 59, 47, Framer.ENTER_FRAME_PREFIX, 61, 54, 51, 38, 51, Framer.STDIN_FRAME_PREFIX, 34, 32, 61, Framer.STDOUT_FRAME_PREFIX, 55, Framer.ENTER_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 59, 60, 53, Framer.STDIN_FRAME_PREFIX, 61, 34, 38, 59, 61, 60, Framer.ENTER_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 57, 55, 43, 7, 2, Ascii.ETB, 2, Ascii.FS, 19, 17, Ascii.FF, 0, 6, Ascii.DLE, Ascii.DLE, 10, Ascii.CR, 4, Ascii.FS, Ascii.FF, 19, Ascii.ETB, 10, Ascii.FF, Ascii.CR, Ascii.DLE, Ascii.FS, Ascii.DLE, Ascii.ETB, 2, Ascii.ETB, 6, Ascii.FS, 8, 6, Ascii.SUB, 94, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 76, 73, 82, 89, 72, 94, 89, 82, 89, 84, 93, 72, 82, 70, 72, 84, 84, 83, 85, 88, 74, 66, 67, 78, 70, 83, 78, 72, 73, 88, 84, 66, 85, 81, 78, 68, 66, 88, 76, 66, 94};
    }

    public C1749iP(String str, String str2, Bundle bundle) {
        this.A01 = str;
        this.A02 = str2;
        this.A00 = bundle;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A79() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A7N() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final TM A7m(T8 t8) {
        String[] stringArray = this.A00.getStringArray(A00(98, 27, 121));
        Integer numValueOf = Integer.valueOf(this.A00.getInt(A00(63, 35, 111), -1));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        Integer country = Integer.valueOf(this.A00.getInt(A00(125, 33, 72), -1));
        if (country.intValue() == -1) {
            country = null;
        }
        return new TM(stringArray, numValueOf, country);
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A8W() {
        return this.A00.getString(A00(178, 25, 12));
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final String A9G() {
        String string = this.A00.getString(A00(158, 20, 6));
        String adTestTypeStr = AdSettings.TestAdType.DEFAULT.getAdTypeString();
        if (adTestTypeStr.equals(string)) {
            return null;
        }
        for (AdSettings.TestAdType testAdType : AdSettings.TestAdType.values()) {
            String adTestTypeStr2 = testAdType.getAdTypeString();
            if (adTestTypeStr2.equals(string)) {
                String adTestTypeStr3 = testAdType.getAdTypeString();
                return adTestTypeStr3;
            }
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean AAa() {
        return this.A00.getBoolean(A00(40, 23, 69));
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean AAg() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final Boolean AAk() {
        Set<String> setKeySet = this.A00.keySet();
        String strA00 = A00(27, 13, 10);
        if (setKeySet.contains(strA00)) {
            return Boolean.valueOf(this.A00.getBoolean(strA00));
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.U3
    public final boolean isTestMode(Context context) {
        return this.A00.getBoolean(A00(0, 27, 26)) || AdSettings.isTestMode(context);
    }
}
