package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ln, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0868Ln {
    public static byte[] A00;
    public static String[] A01 = {"", "5RMLmaPj2fddIFPW54nmiFQPDQKlIy2x", "0506SZgMJJ7sv8mHDOEz9KlkL25eIrXm", "3YZMJbChCuRHZ", "0tP", "k2qiQoSuFgoxV", "", "m4QFNGv2UqCrxsi4qbKPCdwxAuw6y7wM"};

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[4].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "AJnFEtF8h38YXxkoJFDHCzPhEs51Q6lq";
            strArr[1] = "PqTCDiOjjtdJiv33jQVs3cEvP8T1eChE";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 20);
            i6++;
        }
    }

    public static void A06() {
        A00 = new byte[]{-42, -39, -36, -43, -86, -97, -97};
        String[] strArr = A01;
        if (strArr[5].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "";
        strArr2[0] = "";
    }

    static {
        A06();
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
            options.inSampleSize = A00(options, i3, i4);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(c0869Lo, null, options);
        }
        return BitmapFactory.decodeStream(c0869Lo);
    }

    public static Bitmap A02(String str, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = A00(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap A03(String str, int i3, int i4, boolean z2) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            if (i3 > 0 && i4 > 0) {
                if (z2) {
                    Bitmap bitmapA01 = A01(fileInputStream, i3, i4);
                    A07(fileInputStream);
                    return bitmapA01;
                }
                Bitmap bitmapA02 = A02(str, i3, i4);
                A07(fileInputStream);
                return bitmapA02;
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
            A07(fileInputStream);
            return bitmapDecodeStream;
        } catch (Throwable th) {
            A07(null);
            throw th;
        }
    }

    public static String A05(File file) {
        if (file != null) {
            return A04(0, 7, 92) + file.getPath();
        }
        return null;
    }

    public static void A07(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
