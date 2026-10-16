package com.facebook.ads.redexgen.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1861kQ implements InterfaceC0888Mh {
    public static byte[] A04;
    public static final String[] A05;
    public String A00;
    public String A01;
    public final SparseArray<C0887Mg> A02 = new SparseArray<>();
    public final C5O A03;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{55, 43, 106, 103, 35, 74, 77, 87, 70, 68, 70, 81, 35, 83, 81, 74, 78, 66, 81, 90, 35, 72, 70, 90, 35, 77, 76, 87, 35, 77, 86, 79, 79, 47, 104, 102, 122, 35, 87, 70, 91, 87, 35, 77, 76, 87, 35, 77, 86, 79, 79, 47, 110, 102, 119, 98, 103, 98, 119, 98, 35, 65, 79, 76, 65, 35, 77, 76, 87, 35, 77, 86, 79, 79, 42, 46, 63, 40, 44, 57, 40, 77, 57, 44, 47, Framer.ENTER_FRAME_PREFIX, 40, 77, 6, Ascii.DLE, Ascii.CR, Ascii.DC2, 98, Ascii.SYN, 3, 0, Ascii.SO, 7, 98, Ascii.VT, 4, 98, 7, Ascii.SUB, Ascii.VT, 17, Ascii.SYN, 17, 98, 41, Ascii.DC4, 3, 60, 0, Ascii.CR, Ascii.NAK, 9, Ascii.RS, 47, Ascii.CR, Ascii.SI, 4, 9, 37, 2, 8, 9, Ascii.DC4, 88, 85, Ascii.DC2, Ascii.US, 91, 70, 91, 68, 79, 65, 93, 109, 101, 116, 97, 100, 97, 116, 97};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AAs(HashMap<String, C0887Mg> map, SparseArray<String> sparseArray) throws IOException {
        AbstractC04323y.A08(this.A02.size() == 0);
        try {
            if (C5Q.A00(this.A03.getReadableDatabase(), 1, (String) AbstractC04323y.A01(this.A00)) != 1) {
                SQLiteDatabase writableDatabase = this.A03.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    A04(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
            Cursor cursorA00 = A00();
            while (cursorA00.moveToNext()) {
                try {
                    C0887Mg c0887Mg = new C0887Mg(cursorA00.getInt(0), (String) AbstractC04323y.A01(cursorA00.getString(1)), C0889Mi.A02(new DataInputStream(new ByteArrayInputStream(cursorA00.getBlob(2)))));
                    map.put(c0887Mg.A02, c0887Mg);
                    sparseArray.put(c0887Mg.A01, c0887Mg.A02);
                } finally {
                }
            }
            if (cursorA00 != null) {
                cursorA00.close();
            }
        } catch (SQLiteException e3) {
            map.clear();
            sparseArray.clear();
            throw new C5N(e3);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AKJ(HashMap<String, C0887Mg> map) throws IOException {
        if (this.A02.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.A03.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i3 = 0; i3 < this.A02.size(); i3++) {
                try {
                    C0887Mg c0887MgValueAt = this.A02.valueAt(i3);
                    if (c0887MgValueAt == null) {
                        A05(writableDatabase, this.A02.keyAt(i3));
                    } else {
                        A06(writableDatabase, c0887MgValueAt);
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            }
            writableDatabase.setTransactionSuccessful();
            this.A02.clear();
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }

    static {
        A03();
        A05 = new String[]{A01(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 2, 48), A01(136, 3, 37), A01(139, 8, 1)};
    }

    public C1861kQ(C5O c5o) {
        this.A03 = c5o;
    }

    private Cursor A00() {
        return this.A03.getReadableDatabase().query((String) AbstractC04323y.A01(this.A01), A05, null, null, null, null, null);
    }

    public static String A02(String str) {
        return A01(109, 19, 109) + str;
    }

    private void A04(SQLiteDatabase sQLiteDatabase) throws C5N {
        C5Q.A04(sQLiteDatabase, 1, (String) AbstractC04323y.A01(this.A00), 1);
        A07(sQLiteDatabase, (String) AbstractC04323y.A01(this.A01));
        sQLiteDatabase.execSQL(A01(75, 13, 108) + this.A01 + A01(0, 1, 22) + A01(1, 74, 2));
    }

    private void A05(SQLiteDatabase sQLiteDatabase, int i3) {
        sQLiteDatabase.delete((String) AbstractC04323y.A01(this.A01), A01(130, 6, 122), new String[]{Integer.toString(i3)});
    }

    private void A06(SQLiteDatabase sQLiteDatabase, C0887Mg c0887Mg) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0889Mi.A08(c0887Mg.A03(), new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put(A01(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 2, 48), Integer.valueOf(c0887Mg.A01));
        contentValues.put(A01(136, 3, 37), c0887Mg.A02);
        contentValues.put(A01(139, 8, 1), byteArray);
        sQLiteDatabase.replaceOrThrow((String) AbstractC04323y.A01(this.A01), null, contentValues);
    }

    public static void A07(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(A01(88, 21, 67) + str);
    }

    public static void A08(C5O c5o, String str) throws C5N {
        try {
            String strA02 = A02(str);
            SQLiteDatabase writableDatabase = c5o.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                C5Q.A03(writableDatabase, 1, str);
                A07(writableDatabase, strA02);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void A5p() throws C5N {
        A08(this.A03, (String) AbstractC04323y.A01(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final boolean A6S() throws C5N {
        try {
            return C5Q.A00(this.A03.getReadableDatabase(), 1, (String) AbstractC04323y.A01(this.A00)) != -1;
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AAF(long j3) {
        this.A00 = Long.toHexString(j3);
        this.A01 = A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AFd(C0887Mg c0887Mg, boolean z2) {
        if (z2) {
            this.A02.delete(c0887Mg.A01);
        } else {
            this.A02.put(c0887Mg.A01, null);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AGK(C0887Mg c0887Mg) {
        this.A02.put(c0887Mg.A01, c0887Mg);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AKI(HashMap<String, C0887Mg> map) throws IOException {
        try {
            SQLiteDatabase writableDatabase = this.A03.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                A04(writableDatabase);
                Iterator<C0887Mg> it = map.values().iterator();
                while (it.hasNext()) {
                    A06(writableDatabase, it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.A02.clear();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e3) {
            throw new C5N(e3);
        }
    }
}
