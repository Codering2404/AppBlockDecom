package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class T2 {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{2, 6, 10, Ascii.FF, Ascii.SO};
    }

    public static int A00(BitmapFactory.Options options, int halfWidth, int i3) {
        int width = options.outHeight;
        int height = options.outWidth;
        int halfHeight = 1;
        if (width > i3 || height > halfWidth) {
            int inSampleSize = width / 2;
            int width2 = height / 2;
            while (inSampleSize / halfHeight >= i3 && width2 / halfHeight >= halfWidth) {
                halfHeight *= 2;
            }
        }
        return halfHeight;
    }

    public static Bitmap A01(InputStream inputStream, int i3, int i4) throws IOException {
        C0869Lo c0869Lo = new C0869Lo(inputStream);
        c0869Lo.mark(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c0869Lo, null, options);
        c0869Lo.reset();
        if (!c0869Lo.A00()) {
            options.inSampleSize = A00(options, i4, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(c0869Lo, null, options);
        }
        return BitmapFactory.decodeStream(c0869Lo);
    }

    public static Bitmap A02(String str, int i3, int i4, T8 t8) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = A00(options, i4, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable t2) {
            t8.A08().ABC(A03(0, 5, 116), AbstractC1060Td.A1h, new C1061Te(t2));
            return null;
        }
    }
}
