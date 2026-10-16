package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.Utility;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1877kh implements InterfaceC0866Ll {
    public static String A07;
    public static byte[] A08;
    public static String[] A09 = {"76RHNajjOom", "Mjpn3pRzDJalybdRDXibpwNEIm", "yniKdbkjQS3x88FVx9CeVftqblxxQhpu", "Bjsdcl6Zd1aHs", "xxeVE5WeJXBB6h2Smwfm1cLqVC", "jWBIYbGBA8wTLtSAwtOQxldoJ8", "SNbZ6FPeFicMqudBak9DrYkQXr", "PSBHzZzFGATU6u0TdgIgliGoBbccT2bp"};
    public int A00;
    public InputStream A01;
    public HttpURLConnection A02;
    public final String A03;
    public volatile int A04;
    public volatile int A05;
    public volatile String A06;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{43, 98, Framer.EXIT_FRAME_PREFIX, 43, 98, 101, Ascii.DEL, 110, 121, 121, 126, 123, Ascii.DEL, 110, 111, Framer.ENTER_FRAME_PREFIX, 117, 110, Framer.ENTER_FRAME_PREFIX, 102, Framer.STDOUT_FRAME_PREFIX, 47, Framer.STDERR_FRAME_PREFIX, 46, 102, 41, 32, 32, 53, 35, Framer.STDERR_FRAME_PREFIX, 102, 108, 96, 35, 47, 46, 52, 37, 46, 52, 109, 44, 37, 46, 39, 52, 40, 122, 96, 5, Ascii.DC4, Ascii.SO, 77, 65, 64, 64, 75, 77, 90, 71, 65, 64, Ascii.SO, 71, 93, Ascii.SO, 79, 76, 93, 75, 64, 90, Ascii.SI, Ascii.DC4, 56, 57, 35, Framer.STDERR_FRAME_PREFIX, 57, 35, 119, 62, 57, Framer.STDOUT_FRAME_PREFIX, 56, 119, Framer.STDOUT_FRAME_PREFIX, 56, 37, 119, 55, Ascii.CAN, 47, 47, Framer.STDERR_FRAME_PREFIX, 47, 125, 57, 52, 46, 62, Framer.STDERR_FRAME_PREFIX, 51, 51, 56, 62, 41, 52, 51, 58, 125, Ascii.NAK, 41, 41, Framer.STDIN_FRAME_PREFIX, 8, 47, Framer.STDOUT_FRAME_PREFIX, Ascii.RS, Framer.STDERR_FRAME_PREFIX, 51, 51, 56, 62, 41, 52, Framer.STDERR_FRAME_PREFIX, 51, Ascii.NAK, 34, 34, 63, 34, 112, 54, 53, 36, 51, 56, 57, 62, 55, 112, 57, 62, 54, 63, 112, 54, 34, 63, 61, 112, Ascii.ESC, 44, 44, Framer.STDOUT_FRAME_PREFIX, 44, 126, Framer.STDOUT_FRAME_PREFIX, 46, 59, 48, 55, 48, 57, 126, 61, Framer.STDOUT_FRAME_PREFIX, 48, 48, 59, 61, 42, 55, Framer.STDOUT_FRAME_PREFIX, 48, 126, 56, Framer.STDOUT_FRAME_PREFIX, 44, 126, 35, Ascii.DC4, Ascii.DC4, 9, Ascii.DC4, 70, Ascii.DC4, 3, 7, 2, Ascii.SI, 8, 1, 70, 2, 7, Ascii.DC2, 7, 70, 0, Ascii.DC4, 9, Ascii.VT, 70, 92, 96, 96, 100, 65, 102, Framer.EXIT_FRAME_PREFIX, 71, 123, 97, 102, 119, 113, 111, 97, 102, Framer.EXIT_FRAME_PREFIX, 41, 51, 101, 70, 74, 72, 93, 64, 70, 71, 0, 63, 42, Framer.ENTER_FRAME_PREFIX, 111, 44, 32, Framer.ENTER_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 42, 44, 59, 38, 32, Framer.ENTER_FRAME_PREFIX, 111, 85, 102, 105, 96, 98, 109, 90, 94, 91, Ascii.US, 92, 80, 81, 75, 90, 81, 75, Ascii.US, 86, 81, 89, 80, Ascii.US, 89, 77, 80, 82, Ascii.US, 106, 93, 89, 92, 81, 86, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.CAN, 75, 87, 77, 74, 91, 93, Ascii.CAN, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, Ascii.SUB, 85, Ascii.CAN, Ascii.DC4, Ascii.ESC, Ascii.FF, 85, 7, Ascii.DLE, 17, Ascii.FS, 7, Ascii.DLE, Ascii.SYN, 1, 6, 79, 85, 92, 6, Ascii.FS, 81, 85, 81, 89, 6, Ascii.FS, Ascii.RS, 5, 8, Ascii.EM, Ascii.SI, 65, 99};
    }

    static {
        A04();
        A07 = C1877kh.class.getSimpleName();
    }

    public C1877kh(String str) {
        this(str, C0864Lj.A01(str));
    }

    public C1877kh(String str, int i3) {
        this(str);
        this.A00 = i3;
    }

    public C1877kh(String str, String str2) {
        this.A05 = Integer.MIN_VALUE;
        this.A00 = -1;
        this.A03 = (String) AbstractC0865Lk.A00(str);
        this.A06 = str2;
    }

    private int A00(HttpURLConnection httpURLConnection, int i3, int i4) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i4 == 200 ? contentLength : i4 == 206 ? contentLength + i3 : this.A05;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection A02(int r9, int r10) throws com.facebook.ads.redexgen.core.C1883kn, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1877kh.A02(int, int):java.net.HttpURLConnection");
    }

    private void A03() throws C1883kn {
        String str = A01(255, 23, 59) + this.A03;
        HttpURLConnection httpURLConnectionA02 = null;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnectionA02 = A02(0, ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                this.A05 = httpURLConnectionA02.getContentLength();
                this.A06 = httpURLConnectionA02.getContentType();
                inputStream = httpURLConnectionA02.getInputStream();
                Log.i(A07, A01(74, 18, 83) + this.A03 + A01(313, 9, 56) + this.A06 + A01(32, 18, 68) + this.A05);
                C0864Lj.A05(inputStream);
            } catch (IOException e3) {
                Log.e(A07, A01(129, 25, 84) + this.A03, e3);
                C0864Lj.A05(inputStream);
                if (httpURLConnectionA02 != null) {
                }
            }
            if (httpURLConnectionA02 != null) {
                httpURLConnectionA02.disconnect();
            }
        } catch (Throwable th) {
            C0864Lj.A05(inputStream);
            if (httpURLConnectionA02 != null) {
                httpURLConnectionA02.disconnect();
            }
            throw th;
        }
    }

    private final void A05(int i3, int i4) throws C1883kn {
        try {
            this.A02 = A02(i3, i4);
            this.A06 = this.A02.getContentType();
            this.A01 = new BufferedInputStream(this.A02.getInputStream(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            this.A05 = A00(this.A02, i3, this.A02.getResponseCode());
        } catch (IOException e3) {
            throw new C1883kn(A01(154, 29, 90) + this.A03 + A01(19, 13, 66) + i3, e3);
        }
    }

    public final int A06() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0866Ll
    public final void AGj(int i3) throws C1883kn {
        A05(i3, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0866Ll
    public final void close() throws C1883kn {
        if (this.A02 != null) {
            try {
                this.A02.disconnect();
            } catch (NullPointerException e3) {
                throw new C1883kn(A01(92, 37, 89), e3);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0866Ll
    public final synchronized int length() throws C1883kn {
        if (this.A05 == Integer.MIN_VALUE) {
            A03();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0866Ll
    public final int read(byte[] bArr) throws C1883kn {
        InputStream inputStream = this.A01;
        String strA01 = A01(183, 24, 98);
        if (inputStream != null) {
            try {
                return this.A01.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e3) {
                final String str = A01(278, 15, 60) + this.A03 + A01(0, 15, 15);
                throw new C1883kn(str, e3) { // from class: com.facebook.ads.redexgen.X.8K
                };
            } catch (IOException e4) {
                throw new C1883kn(strA01 + this.A03, e4);
            }
        }
        throw new C1883kn(strA01 + this.A03 + A01(51, 23, 42));
    }

    public final String toString() {
        return A01(207, 19, 16) + this.A03 + A01(328, 1, 26);
    }
}
