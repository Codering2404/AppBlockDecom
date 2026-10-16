package com.google.android.libraries.places.internal;

import com.google.common.io.BaseEncoding;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f77332a = Logger.getLogger(zzcah.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f77333b = "-bin".getBytes(StandardCharsets.US_ASCII);

    private zzcah() {
    }

    public static byte[][] a(zzbmg zzbmgVar) {
        int length;
        int i3;
        byte[][] bArrC = zzbkw.c(zzbmgVar);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            length = bArrC.length;
            if (i4 >= length) {
                break;
            }
            byte[] bArr = bArrC[i4];
            byte[] bArr2 = bArrC[i4 + 1];
            if (c(bArr, f77333b)) {
                i3 = i5 + 2;
                bArrC[i5] = bArr;
                bArrC[i5 + 1] = zzbkw.f76357b.g(bArr2).getBytes(StandardCharsets.US_ASCII);
            } else {
                for (byte b3 : bArr2) {
                    if (b3 < 32 || b3 > 126) {
                        String str = new String(bArr, StandardCharsets.US_ASCII);
                        Logger logger = f77332a;
                        Level level = Level.WARNING;
                        String string = Arrays.toString(bArr2);
                        StringBuilder sb = new StringBuilder(str.length() + 21 + String.valueOf(string).length() + 34);
                        sb.append("Metadata key=");
                        sb.append(str);
                        sb.append(", value=");
                        sb.append(string);
                        sb.append(" contains invalid ASCII characters");
                        logger.logp(level, "io.grpc.internal.TransportFrameUtil", "toHttp2Headers", sb.toString());
                        break;
                    }
                }
                i3 = i5 + 2;
                bArrC[i5] = bArr;
                bArrC[i5 + 1] = bArr2;
            }
            i5 = i3;
            i4 += 2;
        }
        return i5 == length ? bArrC : (byte[][]) Arrays.copyOfRange(bArrC, 0, i5);
    }

    public static byte[][] b(byte[][] bArr) {
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            int i4 = i3 + 1;
            byte[] bArr3 = bArr[i4];
            byte[] bArr4 = f77333b;
            if (c(bArr2, bArr4)) {
                for (byte b3 : bArr3) {
                    if (b3 == 44) {
                        ArrayList arrayList = new ArrayList(bArr.length + 10);
                        for (int i5 = 0; i5 < i3; i5++) {
                            arrayList.add(bArr[i5]);
                        }
                        while (i3 < bArr.length) {
                            byte[] bArr5 = bArr[i3];
                            byte[] bArr6 = bArr[i3 + 1];
                            if (c(bArr5, bArr4)) {
                                int i6 = 0;
                                int i7 = 0;
                                while (true) {
                                    int length = bArr6.length;
                                    if (i6 <= length) {
                                        if (i6 == length || bArr6[i6] == 44) {
                                            byte[] bArrC = BaseEncoding.b().c(new String(bArr6, i7, i6 - i7, StandardCharsets.US_ASCII));
                                            arrayList.add(bArr5);
                                            arrayList.add(bArrC);
                                            i7 = i6 + 1;
                                        }
                                        i6++;
                                    }
                                }
                            } else {
                                arrayList.add(bArr5);
                                arrayList.add(bArr6);
                            }
                            i3 += 2;
                        }
                        return (byte[][]) arrayList.toArray(new byte[0][]);
                    }
                }
                bArr[i4] = BaseEncoding.b().c(new String(bArr3, StandardCharsets.US_ASCII));
            }
            i3 += 2;
        }
        return bArr;
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i3 = length; i3 < bArr.length; i3++) {
            if (bArr[i3] != bArr2[i3 - length]) {
                return false;
            }
        }
        return true;
    }
}
