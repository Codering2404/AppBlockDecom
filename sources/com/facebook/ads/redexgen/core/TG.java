package com.facebook.ads.redexgen.core;

import android.os.AsyncTask;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class TG<T> extends AsyncTask<Void, Void, T> {
    public static byte[] A04;
    public TJ A00;
    public final C1644ge A01;
    public final TK<T> A02;
    public final UO<T> A03;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{5, 2, Ascii.NAK, 2, 3, 2, Ascii.DC4, 6};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TG != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TK != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UO != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
    public TG(C1644ge c1644ge, TK<T> tk, UO<T> uo) {
        this.A02 = tk;
        this.A03 = uo;
        this.A01 = c1644ge;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TG != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
    private final T A00(Void... voidArr) throws Throwable {
        if (WU.A02(this)) {
            return null;
        }
        T tA03 = null;
        try {
            try {
                tA03 = this.A02.A03();
                this.A00 = this.A02.A00();
                return tA03;
            } catch (Exception e3) {
                this.A01.A08().ABC(A01(0, 8, 89), AbstractC1060Td.A0w, new C1061Te(e3));
                this.A00 = TJ.A08;
                return tA03;
            }
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TG != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) throws Throwable {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A00(voidArr);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TG != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
    @Override // android.os.AsyncTask
    public final void onPostExecute(T result) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00 == null) {
                this.A03.A02(result);
            } else {
                this.A03.A01(this.A00.A03(), this.A00.A04());
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
