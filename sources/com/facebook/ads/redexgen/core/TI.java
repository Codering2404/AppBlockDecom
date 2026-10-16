package com.facebook.ads.redexgen.core;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class TI extends SQLiteOpenHelper {
    public static byte[] A01;
    public static String[] A02 = {"XfAyR2vU0BibGbkW5sl", "72EQRqCB7z", "pQj0Q1BmcNSJNmsLpeVJ6qN75i73IOus", "lsxje2C6xdGld5UPkxYO", "GgAbEVzt1AOENmbxI3KXH96Z5ccDQ2lY", "3OXRqiMUeM1s", "WQkJsHQStWfxe", "yOid3ecrxpkgxviYKYk6NUThnYl"};
    public static final String A03;
    public final TH A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-105, 101, -119, -118, -117, -122, -102, -111, -103, 101, 117, 0, Ascii.VT, 19, 4, 17, -33, 19, 0, 1, Ascii.VT, 4, -33, 36, 53, 36, Framer.STDIN_FRAME_PREFIX, 51, Framer.STDERR_FRAME_PREFIX, -33, 0, 3, 3, -33, 2, Ascii.SO, Ascii.VT, Ascii.DC4, Ascii.FF, Ascii.CR, -33, -122, -87, -119, -90, -71, -90, -89, -90, -72, -86, -115, -86, -79, -75, -86, -73, 101, -88, -90, -77, 101, -77, -76, -71, 101, -89, -86, 101, -77, -70, -79, -79, -16, -2, -5, -4, -52, 0, -19, -18, -8, -15, -52, -11, -14, -52, -15, 4, -11, -1, 0, -1, -52, Ascii.SI, Ascii.RS, Ascii.CR, Ascii.US, Ascii.DC4, 17, Ascii.US, -10, -8, -25, -19, -13, -25, -58, Ascii.FF, Ascii.NAK, Ascii.CAN, Ascii.VT, Ascii.SI, Ascii.CR, Ascii.DC4, 5, 17, Ascii.VT, Ascii.US, Ascii.EM, -58, -29, -58, -11, -12, -31, -51, -48, -33, -111, -33, -102, -48, -50};
        if (A02[7].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "z4ETzKVSWwABxmvmOp0bWtQm6ZVGd83i";
        strArr[2] = "IiBR5v01IEKLzmVqyabUzMw7zaZ4VOx3";
    }

    static {
        A02();
        A03 = TI.class.getSimpleName();
    }

    public TI(C1644ge c1644ge, TH th) {
        super(c1644ge, A01(c1644ge), (SQLiteDatabase.CursorFactory) null, 4);
        if (th != null) {
            this.A00 = th;
            return;
        }
        throw new IllegalArgumentException(A00(41, 32, 2));
    }

    public static String A01(C1644ge c1644ge) {
        Locale locale = Locale.US;
        Object[] objArr = {A00(0, 0, 19)};
        String strA00 = A00(126, 8, 41);
        String str = String.format(locale, strA00, objArr);
        if (!C1098Up.A2k(c1644ge)) {
            return str;
        }
        String defaultDbName = c1644ge.getPackageName();
        String processName = ProcessUtils.getProcessName(c1644ge);
        if (!defaultDbName.equals(processName) && !TextUtils.isEmpty(processName)) {
            String defaultDbName2 = String.format(Locale.US, strA00, '_' + processName);
            return defaultDbName2;
        }
        return str;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (TL tl : this.A00.A0M()) {
            tl.A07(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        for (TL tl : this.A00.A0M()) {
            tl.A08(sQLiteDatabase);
            tl.A07(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL(A00(101, 25, 99));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        if (i3 == 2 && i4 >= 3) {
            sQLiteDatabase.execSQL(A00(73, 28, 105));
        }
        if (i3 <= 3 && i4 >= 4) {
            TF tf = C1596fs.A02;
            sQLiteDatabase.execSQL(A00(11, 30, 124) + tf.A01 + A00(0, 1, 52) + tf.A02 + A00(1, 10, 2));
        }
    }
}
