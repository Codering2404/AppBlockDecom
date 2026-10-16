package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class IOUtils {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        return c(inputStream, outputStream, false, 1024);
    }

    public static long c(InputStream inputStream, OutputStream outputStream, boolean z2, int i3) {
        byte[] bArr = new byte[i3];
        long j3 = 0;
        while (true) {
            try {
                int i4 = inputStream.read(bArr, 0, i3);
                if (i4 == -1) {
                    break;
                }
                j3 += (long) i4;
                outputStream.write(bArr, 0, i4);
            } catch (Throwable th) {
                if (z2) {
                    a(inputStream);
                    a(outputStream);
                }
                throw th;
            }
        }
        if (z2) {
            a(inputStream);
            a(outputStream);
        }
        return j3;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, true);
    }

    public static byte[] e(InputStream inputStream, boolean z2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c(inputStream, byteArrayOutputStream, z2, 1024);
        return byteArrayOutputStream.toByteArray();
    }
}
