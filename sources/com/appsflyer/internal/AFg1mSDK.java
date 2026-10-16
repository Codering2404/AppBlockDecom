package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFg1mSDK extends FilterInputStream {
    private long[] AFInAppEventParameterName;
    private long[] AFInAppEventType;
    private short AFKeystoreWrapper;
    private int afDebugLog;
    private int afErrorLog;
    private int afRDLog;
    private final int valueOf;
    private byte[] values;

    public AFg1mSDK(InputStream inputStream, int i3, int i4, short s2, int i5, int i6) throws IOException {
        super(inputStream);
        this.afDebugLog = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(Math.max((int) s2, 4), 8);
        this.valueOf = iMin;
        this.values = new byte[iMin];
        this.AFInAppEventParameterName = new long[4];
        this.AFInAppEventType = new long[4];
        this.afErrorLog = iMin;
        this.afRDLog = iMin;
        this.AFInAppEventParameterName = AFg1nSDK.AFInAppEventParameterName(i3 ^ i6, iMin ^ i6);
        this.AFInAppEventType = AFg1nSDK.AFInAppEventParameterName(i4 ^ i6, i5 ^ i6);
    }

    private int AFInAppEventParameterName() throws IOException {
        int i3;
        if (this.afDebugLog == Integer.MAX_VALUE) {
            this.afDebugLog = ((FilterInputStream) this).in.read();
        }
        if (this.afErrorLog == this.valueOf) {
            byte[] bArr = this.values;
            int i4 = this.afDebugLog;
            bArr[0] = (byte) i4;
            if (i4 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i5 = 1;
            do {
                int i6 = ((FilterInputStream) this).in.read(this.values, i5, this.valueOf - i5);
                if (i6 <= 0) {
                    break;
                }
                i5 += i6;
            } while (i5 < this.valueOf);
            if (i5 < this.valueOf) {
                throw new IllegalStateException("unexpected block size");
            }
            AFKeystoreWrapper();
            int i7 = ((FilterInputStream) this).in.read();
            this.afDebugLog = i7;
            this.afErrorLog = 0;
            if (i7 < 0) {
                int i8 = this.valueOf;
                i3 = i8 - (this.values[i8 - 1] & 255);
            } else {
                i3 = this.valueOf;
            }
            this.afRDLog = i3;
        }
        return this.afRDLog;
    }

    private void AFKeystoreWrapper() {
        long[] jArr = this.AFInAppEventParameterName;
        long[] jArr2 = this.AFInAppEventType;
        short s2 = this.AFKeystoreWrapper;
        long j3 = jArr[s2 % 4] * 2147483085;
        long j4 = jArr2[(s2 + 2) % 4];
        int i3 = (s2 + 3) % 4;
        jArr2[i3] = ((jArr[i3] * 2147483085) + j4) / 2147483647L;
        jArr[i3] = (j3 + j4) % 2147483647L;
        for (int i4 = 0; i4 < this.valueOf; i4++) {
            this.values[i4] = (byte) (((long) r1[i4]) ^ ((this.AFInAppEventParameterName[this.AFKeystoreWrapper] >> (i4 << 3)) & 255));
        }
        this.AFKeystoreWrapper = (short) ((this.AFKeystoreWrapper + 1) % 4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        AFInAppEventParameterName();
        return this.afRDLog - this.afErrorLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        AFInAppEventParameterName();
        int i3 = this.afErrorLog;
        if (i3 >= this.afRDLog) {
            return -1;
        }
        byte[] bArr = this.values;
        this.afErrorLog = i3 + 1;
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
            AFInAppEventParameterName();
            int i7 = this.afErrorLog;
            if (i7 >= this.afRDLog) {
                if (i6 == i3) {
                    return -1;
                }
                return i4 - (i5 - i6);
            }
            byte[] bArr2 = this.values;
            this.afErrorLog = i7 + 1;
            bArr[i6] = bArr2[i7];
        }
        return i4;
    }
}
