package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class S7 extends AsyncTask<S9, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"Er5x4Nf8UA9tVLePD2EX", "DtYF9X90t5u", "I941X6fzqWLmgCmjxes", "iBgQ7OI2DFUGAw4NUel9vSUdaaiAzSqO", "QcmiodlDN7oY3kgnmckrDpvdiERsjn9V", "z", "b", "KLyCCmbDECCjA8c7XM6gY8wQDdZdMwfW"};
    public final S8 A00;
    public final C1648gi A01;
    public final boolean A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final Drawable A00(S9... s9Arr) throws Throwable {
        if (!WU.A02(this) && s9Arr != null) {
            try {
                if (s9Arr.length >= 1) {
                    String str = s9Arr[0].A01;
                    String str2 = s9Arr[0].A00;
                    Bitmap bitmapA0O = null;
                    try {
                        bitmapA0O = new C1054Sx(this.A01).A0O(str, -1, -1);
                    } catch (Throwable th) {
                        this.A01.A08().ABC(A01(0, 7, 4), AbstractC1060Td.A1V, new C1061Te(th));
                    }
                    if (bitmapA0O != null) {
                        return UK.A05(this.A01, bitmapA0O, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                WU.A00(th2, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = (bArrCopyOfRange[i6] ^ i5) ^ 36;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[2] = "XzO4PGfz9rpTObXE3Krp6";
            bArrCopyOfRange[i6] = (byte) i7;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 69, 78, 69, 82, 73, 67};
    }

    static {
        A02();
    }

    public S7(C1648gi c1648gi, S8 s8, boolean z2) {
        this.A01 = c1648gi;
        this.A00 = s8;
        this.A02 = z2;
    }

    public /* synthetic */ S7(C1648gi c1648gi, S8 s8, boolean z2, C1670h4 c1670h4) {
        this(c1648gi, s8, z2);
    }

    private final void A03(Drawable drawable) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.AE8(drawable);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(S9[] s9Arr) throws Throwable {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A00(s9Arr);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
