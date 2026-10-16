package com.appsflyer.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFg1qSDK extends FilterInputStream {
    private final byte[] AFLogger;
    private final byte[] AFLogger$LogLevel;
    private int AFVersionDeclaration;
    private final int[] afDebugLog;
    private final int afErrorLog;
    private int afErrorLogForExcManagerOnly;
    private final byte[][] afInfoLog;
    private final int[] afRDLog;
    private int getLevel;
    private static final byte[] valueOf = AFg1uSDK.AFInAppEventParameterName;
    private static final int[] AFInAppEventType = AFg1uSDK.AFKeystoreWrapper;
    private static final int[] AFInAppEventParameterName = AFg1uSDK.valueOf;
    private static final int[] values = AFg1uSDK.AFInAppEventType;
    private static final int[] AFKeystoreWrapper = AFg1uSDK.values;

    public AFg1qSDK(InputStream inputStream, int i3, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.afRDLog = new int[4];
        this.AFLogger = new byte[16];
        this.AFLogger$LogLevel = new byte[16];
        this.AFVersionDeclaration = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.afErrorLogForExcManagerOnly = 16;
        this.getLevel = 16;
        this.afErrorLog = i3;
        this.afDebugLog = AFg1uSDK.AFKeystoreWrapper(bArr, i3);
        this.afInfoLog = values(bArr2);
    }

    private void AFKeystoreWrapper(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.afRDLog;
        char c3 = 1;
        char c4 = 2;
        char c5 = '\b';
        char c6 = 3;
        int i3 = (bArr[0] << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.afDebugLog;
        iArr[0] = i3 ^ iArr2[0];
        char c7 = 5;
        char c8 = 6;
        iArr[1] = ((((bArr[4] << Ascii.CAN) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((bArr[11] & 255) | (((bArr[8] << Ascii.CAN) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8))) ^ iArr2[2];
        char c9 = 14;
        iArr[3] = (((((bArr[13] & 255) << 16) | (bArr[12] << Ascii.CAN)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255)) ^ iArr2[3];
        int i4 = 1;
        int i5 = 4;
        while (i4 < this.afErrorLog) {
            int[] iArr3 = AFInAppEventType;
            int[] iArr4 = this.afRDLog;
            char c10 = c3;
            byte[][] bArr3 = this.afInfoLog;
            byte[] bArr4 = bArr3[0];
            int i6 = iArr3[iArr4[bArr4[0]] >>> 24];
            int[] iArr5 = AFInAppEventParameterName;
            byte[] bArr5 = bArr3[c10];
            char c11 = c4;
            int i7 = i6 ^ iArr5[(iArr4[bArr5[0]] >>> 16) & 255];
            int[] iArr6 = values;
            byte[] bArr6 = bArr3[c11];
            char c12 = c6;
            int i8 = i7 ^ iArr6[(iArr4[bArr6[0]] >>> 8) & 255];
            int[] iArr7 = AFKeystoreWrapper;
            byte[] bArr7 = bArr3[c12];
            char c13 = c5;
            int i9 = i8 ^ iArr7[iArr4[bArr7[0]] & 255];
            int[] iArr8 = this.afDebugLog;
            int i10 = i9 ^ iArr8[i5];
            char c14 = c9;
            char c15 = c7;
            int i11 = (((iArr3[iArr4[bArr4[c10]] >>> 24] ^ iArr5[(iArr4[bArr5[c10]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[c10]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[c10]] & 255]) ^ iArr8[i5 + 1];
            int i12 = (((iArr3[iArr4[bArr4[c11]] >>> 24] ^ iArr5[(iArr4[bArr5[c11]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[c11]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[c11]] & 255]) ^ iArr8[i5 + 2];
            int i13 = (((iArr3[iArr4[bArr4[c12]] >>> 24] ^ iArr5[(iArr4[bArr5[c12]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[c12]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[c12]] & 255]) ^ iArr8[i5 + 3];
            iArr4[0] = i10;
            iArr4[c10] = i11;
            iArr4[c11] = i12;
            iArr4[c12] = i13;
            i4++;
            i5 += 4;
            c3 = c10;
            c4 = c11;
            c6 = c12;
            c5 = c13;
            c7 = c15;
            c9 = c14;
            c8 = c8;
        }
        char c16 = c3;
        char c17 = c4;
        char c18 = c6;
        char c19 = c5;
        char c20 = c9;
        int[] iArr9 = this.afDebugLog;
        int i14 = iArr9[i5];
        byte[] bArr8 = valueOf;
        int[] iArr10 = this.afRDLog;
        byte[][] bArr9 = this.afInfoLog;
        byte[] bArr10 = bArr9[0];
        bArr2[0] = (byte) (bArr8[iArr10[bArr10[0]] >>> 24] ^ (i14 >>> 24));
        byte[] bArr11 = bArr9[c16];
        bArr2[c16] = (byte) (bArr8[(iArr10[bArr11[0]] >>> 16) & 255] ^ (i14 >>> 16));
        byte[] bArr12 = bArr9[c17];
        bArr2[c17] = (byte) (bArr8[(iArr10[bArr12[0]] >>> 8) & 255] ^ (i14 >>> 8));
        byte[] bArr13 = bArr9[c18];
        bArr2[c18] = (byte) (i14 ^ bArr8[iArr10[bArr13[0]] & 255]);
        int i15 = iArr9[i5 + 1];
        bArr2[4] = (byte) (bArr8[iArr10[bArr10[c16]] >>> 24] ^ (i15 >>> 24));
        bArr2[c7] = (byte) (bArr8[(iArr10[bArr11[c16]] >>> 16) & 255] ^ (i15 >>> 16));
        bArr2[c8] = (byte) (bArr8[(iArr10[bArr12[c16]] >>> 8) & 255] ^ (i15 >>> 8));
        bArr2[7] = (byte) (i15 ^ bArr8[iArr10[bArr13[c16]] & 255]);
        int i16 = iArr9[i5 + 2];
        bArr2[c19] = (byte) (bArr8[iArr10[bArr10[c17]] >>> 24] ^ (i16 >>> 24));
        bArr2[9] = (byte) (bArr8[(iArr10[bArr11[c17]] >>> 16) & 255] ^ (i16 >>> 16));
        bArr2[10] = (byte) (bArr8[(iArr10[bArr12[c17]] >>> 8) & 255] ^ (i16 >>> 8));
        bArr2[11] = (byte) (i16 ^ bArr8[iArr10[bArr13[c17]] & 255]);
        int i17 = iArr9[i5 + 3];
        bArr2[12] = (byte) (bArr8[iArr10[bArr10[c18]] >>> 24] ^ (i17 >>> 24));
        bArr2[13] = (byte) (bArr8[(iArr10[bArr11[c18]] >>> 16) & 255] ^ (i17 >>> 16));
        bArr2[c20] = (byte) (bArr8[(iArr10[bArr12[c18]] >>> 8) & 255] ^ (i17 >>> 8));
        bArr2[15] = (byte) (i17 ^ bArr8[iArr10[bArr13[c18]] & 255]);
    }

    private static byte[][] values(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = new byte[bArr[i3].length];
            int i4 = 0;
            while (true) {
                byte[] bArr3 = bArr[i3];
                if (i4 < bArr3.length) {
                    bArr2[i3][bArr3[i4]] = (byte) i4;
                    i4++;
                }
            }
        }
        return bArr2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        values();
        return this.getLevel - this.afErrorLogForExcManagerOnly;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        values();
        int i3 = this.afErrorLogForExcManagerOnly;
        if (i3 >= this.getLevel) {
            return -1;
        }
        byte[] bArr = this.AFLogger$LogLevel;
        this.afErrorLogForExcManagerOnly = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j3) throws IOException {
        long j4 = 0;
        while (j4 < j3 && read() != -1) {
            j4++;
        }
        return j4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            values();
            int i7 = this.afErrorLogForExcManagerOnly;
            if (i7 >= this.getLevel) {
                if (i6 == i3) {
                    return -1;
                }
                return i4 - (i5 - i6);
            }
            byte[] bArr2 = this.AFLogger$LogLevel;
            this.afErrorLogForExcManagerOnly = i7 + 1;
            bArr[i6] = bArr2[i7];
        }
        return i4;
    }

    private int values() throws IOException {
        if (this.AFVersionDeclaration == Integer.MAX_VALUE) {
            this.AFVersionDeclaration = ((FilterInputStream) this).in.read();
        }
        if (this.afErrorLogForExcManagerOnly == 16) {
            byte[] bArr = this.AFLogger;
            int i3 = this.AFVersionDeclaration;
            bArr[0] = (byte) i3;
            if (i3 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = 1;
            do {
                int i5 = ((FilterInputStream) this).in.read(this.AFLogger, i4, 16 - i4);
                if (i5 <= 0) {
                    break;
                }
                i4 += i5;
            } while (i4 < 16);
            if (i4 >= 16) {
                AFKeystoreWrapper(this.AFLogger, this.AFLogger$LogLevel);
                int i6 = ((FilterInputStream) this).in.read();
                this.AFVersionDeclaration = i6;
                this.afErrorLogForExcManagerOnly = 0;
                this.getLevel = i6 < 0 ? 16 - (this.AFLogger$LogLevel[15] & 255) : 16;
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.getLevel;
    }
}
