package com.facebook.ads.redexgen.core;

import android.database.sqlite.SQLiteDatabase;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class TL {
    public static byte[] A01;
    public final TH A00;

    static {
        A04();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{85, 93, 87, 74, 87, 72, 54, 80, 68, 89, 91, 54, 84, 35, 60, Framer.STDOUT_FRAME_PREFIX, 38, Framer.STDOUT_FRAME_PREFIX, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 4, 8, 79, 94, 73, 77, 88, 73, 44, 88, 77, 78, 64, 73, 44, 6, Ascii.DLE, Ascii.CR, Ascii.DC2, 98, Ascii.SYN, 3, 0, Ascii.SO, 7, 98, Ascii.VT, 4, 98, 7, Ascii.SUB, Ascii.VT, 17, Ascii.SYN, 17, 98, 34, 52, 61, 52, Framer.STDERR_FRAME_PREFIX, 37, 81};
    }

    public abstract String A06();

    public abstract TF[] A0A();

    public TL(TH th) {
        this.A00 = th;
    }

    private String A00() {
        TF[] tfArrA0A = A0A();
        if (tfArrA0A.length < 1) {
            return null;
        }
        String result = A01(0, 0, 12);
        for (int i3 = 0; i3 < tfArrA0A.length - 1; i3++) {
            result = result + tfArrA0A[i3].A02() + A01(20, 2, 43);
        }
        return result + tfArrA0A[tfArrA0A.length - 1].A02();
    }

    public static String A02(String str, TF[] tfArr) {
        StringBuilder sb = new StringBuilder(A01(56, 7, 114));
        for (int i3 = 0; i3 < tfArr.length - 1; i3++) {
            sb.append(tfArr[i3].A01);
            sb.append(A01(20, 2, 43));
        }
        sb.append(tfArr[tfArr.length - 1].A01);
        sb.append(A01(6, 6, 21));
        sb.append(str);
        return sb.toString();
    }

    public static String A03(String str, TF[] tfArr, TF tf) {
        return A02(str, tfArr) + A01(12, 7, 119) + tf.A01 + A01(2, 4, 116);
    }

    public final SQLiteDatabase A05() {
        return this.A00.A0E();
    }

    public final void A07(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(22, 13, 15) + A06() + A01(0, 2, 118) + A00() + A01(19, 1, 117));
    }

    public final void A08(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(35, 21, 65) + A06());
    }

    public final boolean A09() {
        return A05().delete(A06(), null, null) > 0;
    }
}
