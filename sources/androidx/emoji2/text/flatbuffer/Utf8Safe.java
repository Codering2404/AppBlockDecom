package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Utf8Safe extends Utf8 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnpairedSurrogateException extends IllegalArgumentException {
    }

    public static String b(byte[] bArr, int i3, int i4) {
        if ((i3 | i4 | ((bArr.length - i3) - i4)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        int i5 = i3 + i4;
        char[] cArr = new char[i4];
        int i6 = 0;
        while (i3 < i5) {
            byte b3 = bArr[i3];
            if (!Utf8.DecodeUtil.g(b3)) {
                break;
            }
            i3++;
            Utf8.DecodeUtil.b(b3, cArr, i6);
            i6++;
        }
        int i7 = i6;
        while (i3 < i5) {
            int i8 = i3 + 1;
            byte b4 = bArr[i3];
            if (Utf8.DecodeUtil.g(b4)) {
                int i9 = i7 + 1;
                Utf8.DecodeUtil.b(b4, cArr, i7);
                int i10 = i8;
                while (i10 < i5) {
                    byte b5 = bArr[i10];
                    if (!Utf8.DecodeUtil.g(b5)) {
                        break;
                    }
                    i10++;
                    Utf8.DecodeUtil.b(b5, cArr, i9);
                    i9++;
                }
                i7 = i9;
                i3 = i10;
            } else if (Utf8.DecodeUtil.i(b4)) {
                if (i8 >= i5) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i3 += 2;
                Utf8.DecodeUtil.d(b4, bArr[i8], cArr, i7);
                i7++;
            } else if (Utf8.DecodeUtil.h(b4)) {
                if (i8 >= i5 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i11 = i3 + 2;
                i3 += 3;
                Utf8.DecodeUtil.c(b4, bArr[i8], bArr[i11], cArr, i7);
                i7++;
            } else {
                if (i8 >= i5 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b6 = bArr[i8];
                int i12 = i3 + 3;
                byte b7 = bArr[i3 + 2];
                i3 += 4;
                Utf8.DecodeUtil.a(b4, b6, b7, bArr[i12], cArr, i7);
                i7 += 2;
            }
        }
        return new String(cArr, 0, i7);
    }

    public static String c(ByteBuffer byteBuffer, int i3, int i4) {
        if ((i3 | i4 | ((byteBuffer.limit() - i3) - i4)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        int i5 = i3 + i4;
        char[] cArr = new char[i4];
        int i6 = 0;
        while (i3 < i5) {
            byte b3 = byteBuffer.get(i3);
            if (!Utf8.DecodeUtil.g(b3)) {
                break;
            }
            i3++;
            Utf8.DecodeUtil.b(b3, cArr, i6);
            i6++;
        }
        int i7 = i6;
        while (i3 < i5) {
            int i8 = i3 + 1;
            byte b4 = byteBuffer.get(i3);
            if (Utf8.DecodeUtil.g(b4)) {
                int i9 = i7 + 1;
                Utf8.DecodeUtil.b(b4, cArr, i7);
                int i10 = i8;
                while (i10 < i5) {
                    byte b5 = byteBuffer.get(i10);
                    if (!Utf8.DecodeUtil.g(b5)) {
                        break;
                    }
                    i10++;
                    Utf8.DecodeUtil.b(b5, cArr, i9);
                    i9++;
                }
                i7 = i9;
                i3 = i10;
            } else if (Utf8.DecodeUtil.i(b4)) {
                if (i8 >= i5) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i3 += 2;
                Utf8.DecodeUtil.d(b4, byteBuffer.get(i8), cArr, i7);
                i7++;
            } else if (Utf8.DecodeUtil.h(b4)) {
                if (i8 >= i5 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i11 = i3 + 2;
                i3 += 3;
                Utf8.DecodeUtil.c(b4, byteBuffer.get(i8), byteBuffer.get(i11), cArr, i7);
                i7++;
            } else {
                if (i8 >= i5 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b6 = byteBuffer.get(i8);
                int i12 = i3 + 3;
                byte b7 = byteBuffer.get(i3 + 2);
                i3 += 4;
                Utf8.DecodeUtil.a(b4, b6, b7, byteBuffer.get(i12), cArr, i7);
                i7 += 2;
            }
        }
        return new String(cArr, 0, i7);
    }
}
