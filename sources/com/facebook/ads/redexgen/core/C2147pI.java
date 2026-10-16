package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2147pI extends SQLiteOpenHelper implements C5O {
    public static byte[] A00;
    public static String[] A01 = {"YuTOcDzSk33WzGuHUm34fIUZdR6FzBSo", "XTKHU7ykX6HxNiJgN0rgjCseZECTQtra", "VEZqd6OFp5mQyS5r43nHHulMPiVDQ9eW", "aLYnSlPQY916exG9yEmf5vg4GfwoTrU7", "tF23Z6GUlh0Fjg1gJR8XevpVUkpWaXM2", "mepItLhmIU8NS8JNKSf8apCSosOFfjC4", "Cz0Pux5KFog27POOTk7sr9rS4XUT", "HqOHPFLqaLH3svqHIBOSrAzDJwUDQThi"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 44);
            String[] strArr = A01;
            if (strArr[0].charAt(22) == strArr[2].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "n1qaiWHrUpNnLAu01u7Aygvt6fyaUUnG";
            strArr2[3] = "NzqeYJq8DJ4S2vkSjhcMbPo6SDo1HpGr";
            bArrCopyOfRange[i6] = b3;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{104, 1, Ascii.SO, 104, Ascii.CR, Ascii.DLE, 1, Ascii.ESC, Ascii.FS, Ascii.ESC, 104, 80, 70, 91, 68, 52, 94, 105, 105, 116, 105, 59, 126, 99, 126, Framer.EXIT_FRAME_PREFIX, 110, 111, 114, 117, 124, 59, 56, 42, 47, 10, Ascii.US, 10, 9, 10, Ascii.CAN, Ascii.SO, 59, Ascii.EM, 4, Ascii.GS, 2, Ascii.SI, Ascii.SO, Ascii.EM, 116, 105, 126, 97, 125, 112, 104, 116, 99, 78, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 101, 116, 99, Ascii.DEL, 112, 125, 63, 117, 115, 63, 48, 60, 52, Ascii.EM, Ascii.ESC, 6, 3, Ascii.RS, Ascii.SI, 53, 7, Ascii.VT, Ascii.EM, Ascii.RS, Ascii.SI, Ascii.CAN, 34, 32, 61, 56, 37, 52, Ascii.SO, 34, 52, 32, 36, 52, 63, Framer.STDERR_FRAME_PREFIX, 52, 64, 77, 68, 81};
    }

    static {
        A01();
    }

    public C2147pI(Context context) {
        super(context.getApplicationContext(), A00(50, 21, 61), (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void A02(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = sQLiteDatabase.query(A00(75, 13, 70), new String[]{A00(103, 4, 24), A00(71, 4, 125)}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                if (!A00(88, 15, 125).equals(string2)) {
                    String str = A00(11, 5, 56) + string + A00(0, 11, 100) + string2;
                    try {
                        sQLiteDatabase.execSQL(str);
                    } catch (SQLException e3) {
                        String type = A00(32, 18, 71);
                        AbstractC04404g.A08(type, A00(16, 16, 55) + str, e3);
                    }
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        A02(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }
}
