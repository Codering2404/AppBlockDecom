package com.facebook.ads.redexgen.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C5Q {
    public static byte[] A00;
    public static String[] A01 = {"ftBSrscYCZrU1XGsUffOBJlxDQfDqofj", "6A6pNCV2uhgoYcLypb", "8GOV2FUSZps1pTbJ4je5MwftASUnZkM1", "4wRLkwVxN17llLy", "8LQiKKC5rqzUsPzG", "bVt1RMPFhi5Vk9jMxK8mGuGgg99xJtg4", "bUya0H86JSXRIIoahVHYTIdtcqgWtSBf", "i4ePvK4hrBrPNKxpSWALXVVM3"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A00(SQLiteDatabase sQLiteDatabase, int i3, String str) throws C5N {
        try {
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
        if (!C5C.A19(sQLiteDatabase, A01(159, 17, 73))) {
            return -1;
        }
        Cursor cursorQuery = sQLiteDatabase.query(A01(159, 17, 73), new String[]{A01(244, 7, 93)}, A01(183, 32, 22), A05(i3, str), null, null, null);
        try {
            if (cursorQuery.getCount() == 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return -1;
            }
            cursorQuery.moveToNext();
            int i4 = cursorQuery.getInt(0);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return i4;
        } finally {
        }
        throw new C5N(e3);
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{53, 36, 51, 55, 34, 51, 86, 34, 55, 52, 58, 51, 86, 63, 48, 86, 56, 57, 34, 86, 51, 46, 63, 37, 34, 37, 86, 51, Ascii.SO, Ascii.EM, 38, Ascii.SUB, Ascii.ETB, Ascii.SI, 19, 4, 32, 19, 4, 5, Ascii.US, Ascii.EM, Ascii.CAN, 5, 86, 94, Ascii.DLE, 19, Ascii.ETB, 2, 3, 4, 19, 86, 63, 56, 34, 51, Framer.STDOUT_FRAME_PREFIX, 51, 36, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, Ascii.US, Ascii.CAN, 5, 2, Ascii.ETB, Ascii.CAN, Ascii.NAK, 19, 41, 3, Ascii.US, Ascii.DC2, 86, 34, 51, 46, 34, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, 0, 19, 4, 5, Ascii.US, Ascii.EM, Ascii.CAN, 86, 63, 56, 34, 51, Framer.STDOUT_FRAME_PREFIX, 51, 36, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, 38, 36, 63, 59, 55, 36, 47, 86, 61, 51, 47, 86, 94, Ascii.DLE, 19, Ascii.ETB, 2, 3, 4, 19, 90, 86, Ascii.US, Ascii.CAN, 5, 2, Ascii.ETB, Ascii.CAN, Ascii.NAK, 19, 41, 3, Ascii.US, Ascii.DC2, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.GS, 32, 55, 8, 52, 57, Framer.ENTER_FRAME_PREFIX, 61, 42, Ascii.SO, 61, 42, 43, Framer.STDOUT_FRAME_PREFIX, 55, 54, 43, 103, 100, 96, 117, 116, 115, 100, 97, 98, 102, 115, 114, 117, 98, 39, 58, 39, 56, 39, 70, 73, 67, 39, 110, 105, 116, 115, 102, 105, 100, 98, 88, 114, 110, 99, 39, 58, 39, 56, 64, 72, 72, 64, 9, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 9, 67, 70, 83, 70, 69, 70, 84, 66, 9, Ascii.SO, 19, Ascii.DC4, 1, Ascii.SO, 3, 5, 63, Ascii.NAK, 9, 4, 58, 41, 62, 63, 37, 35, 34};
        String[] strArr = A01;
        if (strArr[6].charAt(14) == strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        A01[7] = "SNjSmBwt36dpbjCWXjm4KdaDp";
    }

    static {
        A02();
        AnonymousClass35.A03(A01(215, 17, 54));
    }

    public static void A03(SQLiteDatabase sQLiteDatabase, int i3, String str) throws C5N {
        String strA01 = A01(159, 17, 73);
        try {
            if (!C5C.A19(sQLiteDatabase, strA01)) {
                return;
            }
            sQLiteDatabase.delete(strA01, A01(183, 32, 22), A05(i3, str));
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }

    public static void A04(SQLiteDatabase sQLiteDatabase, int i3, String str, int i4) throws C5N {
        try {
            sQLiteDatabase.execSQL(A01(0, 159, 103));
            ContentValues contentValues = new ContentValues();
            contentValues.put(A01(176, 7, 16), Integer.valueOf(i3));
            contentValues.put(A01(232, 12, 113), str);
            contentValues.put(A01(244, 7, 93), Integer.valueOf(i4));
            sQLiteDatabase.replaceOrThrow(A01(159, 17, 73), null, contentValues);
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }

    public static String[] A05(int i3, String str) {
        return new String[]{Integer.toString(i3), str};
    }
}
