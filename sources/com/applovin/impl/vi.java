package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class vi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f64430a = {-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f64431b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        NONE(-1),
        DEFAULT(0),
        V2(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f64436a;

        a(int i3) {
            this.f64436a = i3;
        }

        public int b() {
            return this.f64436a;
        }

        public static a a(int i3) {
            return i3 == 0 ? DEFAULT : i3 == 1 ? V2 : DEFAULT;
        }
    }

    static {
        byte[] bArr = new byte[32];
        f64431b = bArr;
        System.arraycopy(new byte[]{Ascii.DC2, Ascii.FF, Ascii.FS, Ascii.DC4, 17, Ascii.ETB, Ascii.SUB, 9, Ascii.NAK, 3, Ascii.SO, Ascii.GS, 4, 0, 2, 7, 10, Ascii.GS, 6, Ascii.DC4, 1}, 0, bArr, 0, 21);
    }

    private static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        String str3;
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        try {
            try {
                if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strArrSplit[0]) || strArrSplit.length != 4) {
                    return null;
                }
                String str4 = strArrSplit[1];
                char c3 = 2;
                String str5 = strArrSplit[2];
                char c4 = 3;
                byte[] bArrB = b(strArrSplit[3]);
                if (!str2.endsWith(str5)) {
                    return null;
                }
                byte[] bArr = f64430a;
                if (!a(bArr, jVar).equals(str4)) {
                    return null;
                }
                byte[] bArrA = a(str2.substring(0, 32), bArr, jVar);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrB);
                char c5 = 5;
                str3 = null;
                char c6 = '(';
                try {
                    char c7 = 7;
                    long j3 = (((long) ((byteArrayInputStream.read() ^ bArrA[1]) & 255)) << 8) | ((long) ((byteArrayInputStream.read() ^ bArrA[0]) & 255)) | (((long) ((byteArrayInputStream.read() ^ bArrA[2]) & 255)) << 16) | (((long) ((byteArrayInputStream.read() ^ bArrA[3]) & 255)) << 24) | (((long) ((byteArrayInputStream.read() ^ bArrA[4]) & 255)) << 32) | (((byteArrayInputStream.read() ^ bArrA[5]) & 255) << 40) | (((long) ((byteArrayInputStream.read() ^ bArrA[6]) & 255)) << 48) | (((long) ((byteArrayInputStream.read() ^ bArrA[7]) & 255)) << 56);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[8];
                    int i3 = byteArrayInputStream.read(bArr2);
                    int i4 = 0;
                    while (i3 >= 0) {
                        char c8 = c7;
                        long j4 = ((long) i4) + j3;
                        long j5 = (j4 ^ (j4 >> 33)) * (-4417276706812531889L);
                        long j6 = (j5 ^ (j5 >> 29)) * (-8796714831421723037L);
                        long j7 = j6 ^ (j6 >> 32);
                        byteArrayOutputStream.write((byte) (((long) (bArr2[0] ^ bArrA[i4 % bArrA.length])) ^ (j7 & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[1] ^ bArrA[(i4 + 1) % bArrA.length])) ^ ((j7 >> 8) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[r23] ^ bArrA[(i4 + 2) % bArrA.length])) ^ ((j7 >> 16) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[r27] ^ bArrA[(i4 + 3) % bArrA.length])) ^ ((j7 >> 24) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[4] ^ bArrA[(i4 + 4) % bArrA.length])) ^ ((j7 >> 32) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[r26] ^ bArrA[(i4 + 5) % bArrA.length])) ^ ((j7 >> r28) & 255)));
                        byteArrayOutputStream.write((byte) (((long) (bArr2[6] ^ bArrA[(i4 + 6) % bArrA.length])) ^ ((j7 >> 48) & 255)));
                        byteArrayOutputStream.write((byte) (((j7 >> 56) & 255) ^ ((long) (bArr2[c8] ^ bArrA[(i4 + 7) % bArrA.length]))));
                        i4 += 8;
                        c3 = c3;
                        c5 = c5;
                        c4 = c4;
                        c6 = c6;
                        i3 = byteArrayInputStream.read(bArr2);
                        c7 = c8;
                    }
                    return new String(byteArrayOutputStream.toByteArray(), Utf8Charset.NAME).trim();
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                str3 = null;
            }
            com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to read bytes", e);
            jVar.D().a("AppLovinSdk", "decode", e);
            return str3;
        } catch (UnsupportedEncodingException e5) {
            jVar.D().a("AppLovinSdk", "decode", e5);
            throw new RuntimeException("UTF-8 encoding not found", e5);
        }
    }

    public static String b(String str, long j3, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        }
        if (str2.length() < 86) {
            throw new IllegalArgumentException("SDK key is too short");
        }
        if (TextUtils.isEmpty(str) || a.NONE == aVar) {
            return str;
        }
        byte[] bArrA = a.V2 == aVar ? a(str, j3, true, str2, jVar) : a(str, j3, str2, jVar);
        if (bArrA != null) {
            return new String(bArrA);
        }
        return null;
    }

    private static int c(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        int iA;
        int i3;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || (iA = a(bArr, (byte) 58)) < 0) {
            return 0;
        }
        byte[] bytes = a(f64431b, jVar).getBytes();
        int i4 = iA + 1;
        int length = bytes.length + i4;
        if (bArr.length <= length || bArr[length] != 58 || bArr.length <= (i3 = length + 55) || bArr[i3] != 58 || !Arrays.equals(Arrays.copyOfRange(bArr, i4, bytes.length + i4), bytes)) {
            return 0;
        }
        int i5 = length + 56;
        if (length + 64 > bArr.length) {
            return 0;
        }
        return i5;
    }

    public static a b(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char c3 = (char) bArr[0];
            if (c3 == '2') {
                return a.V2;
            }
            if (c3 == '{') {
                return a.NONE;
            }
            return a.DEFAULT;
        }
        return a.NONE;
    }

    private static String c(byte[] bArr) {
        return a(Base64.encode(bArr, 2));
    }

    public static String b(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        if (str != null) {
            if (str.length() < 86) {
                throw new IllegalArgumentException("SDK key is too short");
            }
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return "";
            }
            a aVarB = b(bArr);
            if (a.NONE == aVarB) {
                return new String(bArr);
            }
            if (aVarB == a.V2) {
                return a(bArr, str, jVar);
            }
            return a(new String(bArr), str, jVar);
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    private static byte[] b(String str) {
        return Base64.decode(a(str), 0);
    }

    private static String a(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', '=');
    }

    private static String a(byte[] bArr, String str, com.applovin.impl.sdk.j jVar) {
        try {
            int iC = c(bArr, str, jVar);
            if (iC == 0) {
                return null;
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, iC, bArr.length);
            if (bArrCopyOfRange.length < 16) {
                return null;
            }
            long jA = yp.a(bArrCopyOfRange, 8);
            byte[] bArrA = a(str.substring(0, 32), f64431b, jVar);
            return new String(yp.d(a(Arrays.copyOfRange(bArrCopyOfRange, 16, bArrCopyOfRange.length), jA ^ yp.c(bArrA), bArrA)), Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e3) {
            jVar.D().a("AppLovinSdk", "decode2", e3);
            throw new RuntimeException("UTF-8 encoding not found", e3);
        } catch (IOException e4) {
            com.applovin.impl.sdk.n.b("AppLovinSdk", "Failed to ungzip decode", e4);
            jVar.D().a("AppLovinSdk", "decode2", e4);
            return null;
        }
    }

    private static byte[] a(String str, long j3, String str2, com.applovin.impl.sdk.j jVar) {
        char c3 = ' ';
        try {
            String strSubstring = str2.substring(32);
            byte b3 = 0;
            String strSubstring2 = str2.substring(0, 32);
            byte[] bytes = str.getBytes(Utf8Charset.NAME);
            byte[] bArrA = a(strSubstring2, f64430a, jVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(((byte) (j3 & 255)) ^ bArrA[0]);
            char c4 = '\b';
            byteArrayOutputStream.write(((byte) ((j3 >> 8) & 255)) ^ bArrA[1]);
            char c5 = 16;
            byteArrayOutputStream.write(((byte) ((j3 >> 16) & 255)) ^ bArrA[2]);
            byteArrayOutputStream.write(((byte) ((j3 >> 24) & 255)) ^ bArrA[3]);
            byteArrayOutputStream.write(((byte) ((j3 >> 32) & 255)) ^ bArrA[4]);
            byteArrayOutputStream.write(((byte) ((j3 >> 40) & 255)) ^ bArrA[5]);
            byteArrayOutputStream.write(((byte) ((j3 >> 48) & 255)) ^ bArrA[6]);
            byteArrayOutputStream.write(((byte) ((j3 >> 56) & 255)) ^ bArrA[7]);
            int i3 = 0;
            while (i3 < bytes.length) {
                char c6 = c4;
                char c7 = c5;
                long j4 = j3 + ((long) i3);
                long j5 = (j4 ^ (j4 >> 33)) * (-4417276706812531889L);
                long j6 = (j5 ^ (j5 >> 29)) * (-8796714831421723037L);
                long j7 = j6 ^ (j6 >> c3);
                char c8 = c3;
                byteArrayOutputStream.write((byte) (((long) ((i3 >= bytes.length ? b3 : bytes[i3]) ^ bArrA[i3 % bArrA.length])) ^ (j7 & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 1 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> c6) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 2 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> c7) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 3 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> 24) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 4 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> c8) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 5 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> 40) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 6 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> 48) & 255)));
                byteArrayOutputStream.write((byte) (((long) (bArrA[r4 % bArrA.length] ^ (i3 + 7 >= bytes.length ? (byte) 0 : bytes[r4]))) ^ ((j7 >> 56) & 255)));
                i3 += 8;
                c4 = c6;
                c5 = c7;
                c3 = c8;
                b3 = 0;
            }
            String strC = c(byteArrayOutputStream.toByteArray());
            return ("1:" + a(f64430a, jVar) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strSubstring + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strC).getBytes(Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e3) {
            jVar.D().a("AppLovinSdk", "encode", e3);
            return null;
        }
    }

    public static byte[] a(String str, long j3, a aVar, String str2, com.applovin.impl.sdk.j jVar) {
        if (str2 != null) {
            if (str2.length() >= 86) {
                if (TextUtils.isEmpty(str)) {
                    return new byte[0];
                }
                if (a.NONE == aVar) {
                    return str.getBytes();
                }
                if (a.V2 == aVar) {
                    return a(str, j3, false, str2, jVar);
                }
                return a(str, j3, str2, jVar);
            }
            throw new IllegalArgumentException("SDK key is too short");
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    private static byte[] a(byte[] bArr, long j3, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        long j4 = j3;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i3 % 8 == 0) {
                long j5 = ((long) i3) + j3;
                long j6 = (j5 ^ (j5 >>> 33)) * (-4417276706812531889L);
                long j7 = (j6 ^ (j6 >>> 29)) * (-8796714831421723037L);
                j4 = j7 ^ (j7 >>> 32);
            }
            byte b3 = bArrCopyOf[i3];
            bArrCopyOf[i3] = (byte) (((long) b3) ^ (((j4 >> (r4 * 8)) & 255) ^ ((long) bArr2[i3 % bArr2.length])));
        }
        return bArrCopyOf;
    }

    private static byte[] a(String str, long j3, boolean z2, String str2, com.applovin.impl.sdk.j jVar) {
        ByteBuffer byteBufferAllocate;
        try {
            byte[] bytes = str.getBytes(Utf8Charset.NAME);
            int length = bytes.length;
            String strSubstring = str2.substring(32);
            String strSubstring2 = str2.substring(0, 32);
            byte[] bArr = f64431b;
            byte[] bArrA = a(strSubstring2, bArr, jVar);
            long jC = yp.c(bArrA) ^ j3;
            byte[] bytes2 = String.format("2:%s:%s:", a(bArr, jVar), strSubstring).getBytes();
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(16);
            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate2.putLong(length);
            byteBufferAllocate2.putLong(jC);
            byteBufferAllocate2.flip();
            byte[] bArrA2 = a(yp.a(bytes), j3, bArrA);
            if (z2) {
                byte[] bytes3 = c(byteBufferAllocate2.array()).getBytes();
                byte[] bytes4 = c(bArrA2).getBytes();
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + bytes3.length + bytes4.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(bytes3);
                byteBufferAllocate.put(bytes4);
            } else {
                byteBufferAllocate = ByteBuffer.allocate(bytes2.length + byteBufferAllocate2.remaining() + bArrA2.length);
                byteBufferAllocate.put(bytes2);
                byteBufferAllocate.put(byteBufferAllocate2);
                byteBufferAllocate.put(bArrA2);
            }
            byteBufferAllocate.flip();
            return byteBufferAllocate.array();
        } catch (UnsupportedEncodingException e3) {
            jVar.D().a("AppLovinSdk", "encode2", e3);
            throw new RuntimeException("UTF-8 encoding not found", e3);
        } catch (IOException e4) {
            jVar.D().a("AppLovinSdk", "encode2", e4);
            return null;
        }
    }

    private static int a(byte[] bArr, byte b3) {
        if (bArr != null && bArr.length != 0) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr[i3] == b3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static byte[] a(String str, byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            messageDigest.update(str.getBytes(Utf8Charset.NAME));
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e3) {
            jVar.D().a("AppLovinSdk", "SHA256", e3);
            throw new RuntimeException("SHA-256 algorithm not found", e3);
        }
    }

    private static String a(byte[] bArr, com.applovin.impl.sdk.j jVar) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e3) {
            jVar.D().a("AppLovinSdk", "SHA1", e3);
            throw new RuntimeException("SHA-1 algorithm not found", e3);
        }
    }

    private static String a(byte[] bArr) {
        return new String(bArr, Utf8Charset.NAME).replace('+', '-').replace('/', '_').replace('=', '*');
    }
}
