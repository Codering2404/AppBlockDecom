package com.appsflyer.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFg1tSDK extends FilterInputStream {
    private final int AFInAppEventParameterName;
    private byte[] AFInAppEventType;
    private byte[] AFKeystoreWrapper;
    private int AFLogger;
    private int afDebugLog;
    private int afErrorLog;
    private int afInfoLog;
    private int[] afRDLog;
    private AFg1sSDK valueOf;
    private byte[] values;

    public AFg1tSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i3, boolean z2, int i4) throws IOException {
        super(inputStream);
        this.afDebugLog = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(Math.max(i3, 3), 16);
        this.AFInAppEventParameterName = iMin;
        this.values = new byte[8];
        byte[] bArr2 = new byte[8];
        this.AFKeystoreWrapper = bArr2;
        this.AFInAppEventType = new byte[8];
        this.afRDLog = new int[2];
        this.afInfoLog = 8;
        this.afErrorLog = 8;
        this.AFLogger = i4;
        if (i4 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.valueOf = new AFg1sSDK(iArr, iMin, true, false);
    }

    private void AFInAppEventType() {
        if (this.AFLogger == 2) {
            byte[] bArr = this.values;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.values;
        int i3 = ((bArr2[0] << Ascii.CAN) & (-16777216)) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i4 = ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i5 = this.AFInAppEventParameterName;
        AFg1sSDK aFg1sSDK = this.valueOf;
        AFg1vSDK.AFKeystoreWrapper(i3, i4, false, i5, aFg1sSDK.values, aFg1sSDK.AFInAppEventParameterName, this.afRDLog);
        int[] iArr = this.afRDLog;
        int i6 = iArr[0];
        int i7 = iArr[1];
        byte[] bArr3 = this.values;
        bArr3[0] = (byte) (i6 >> 24);
        bArr3[1] = (byte) (i6 >> 16);
        bArr3[2] = (byte) (i6 >> 8);
        bArr3[3] = (byte) i6;
        bArr3[4] = (byte) (i7 >> 24);
        bArr3[5] = (byte) (i7 >> 16);
        bArr3[6] = (byte) (i7 >> 8);
        bArr3[7] = (byte) i7;
        if (this.AFLogger == 2) {
            for (int i8 = 0; i8 < 8; i8++) {
                byte[] bArr4 = this.values;
                bArr4[i8] = (byte) (bArr4[i8] ^ this.AFKeystoreWrapper[i8]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.AFKeystoreWrapper, 0, bArr5.length);
        }
    }

    private int AFKeystoreWrapper() throws IOException {
        if (this.afDebugLog == Integer.MAX_VALUE) {
            this.afDebugLog = ((FilterInputStream) this).in.read();
        }
        if (this.afInfoLog == 8) {
            byte[] bArr = this.values;
            int i3 = this.afDebugLog;
            bArr[0] = (byte) i3;
            if (i3 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = 1;
            do {
                int i5 = ((FilterInputStream) this).in.read(this.values, i4, 8 - i4);
                if (i5 <= 0) {
                    break;
                }
                i4 += i5;
            } while (i4 < 8);
            if (i4 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            AFInAppEventType();
            int i6 = ((FilterInputStream) this).in.read();
            this.afDebugLog = i6;
            this.afInfoLog = 0;
            this.afErrorLog = i6 < 0 ? 8 - (this.values[7] & 255) : 8;
        }
        return this.afErrorLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        AFKeystoreWrapper();
        return this.afErrorLog - this.afInfoLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        AFKeystoreWrapper();
        int i3 = this.afInfoLog;
        if (i3 >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.values;
        this.afInfoLog = i3 + 1;
        return bArr[i3] & 255;
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
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            AFKeystoreWrapper();
            int i7 = this.afInfoLog;
            if (i7 >= this.afErrorLog) {
                if (i6 == i3) {
                    return -1;
                }
                return i4 - (i5 - i6);
            }
            byte[] bArr2 = this.values;
            this.afInfoLog = i7 + 1;
            bArr[i6] = bArr2[i7];
        }
        return i4;
    }
}
