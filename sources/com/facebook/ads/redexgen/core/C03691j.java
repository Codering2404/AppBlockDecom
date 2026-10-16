package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03691j extends AQ {
    public static byte[] A04;
    public static String[] A05 = {"EpUFNdKyF", "ElnVCWkanZ28CNZmVbXI8Cgdfk8l0", "X39VUuGfeiZ7XA2vCr", "EABpQNGHZAa4ZPAJBF04BZM7WLurFTC9", "chwMXTauvlPIh4ZEXg6aw7fxDLbtX6Fs", "XZGBORnRKKQlpHrvvOBFjnqbRPoZpqW4", "uC2aRCtD", "rZqfEylCjzpizgmEVXgae15ipmvYBT3W"};
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {99, 108, 105, 96, 86, 119, 102, 87, 96, 100, 97, 74, 117, 96, 107, 111, 96, 101, 108, 90, 123, 106, 91, 108, 104, 109, 91, 72, 79, 47, 36, 35, 56, 113, 57, 48, 34, 113, 32, 36, 52, 35, 40, 113, 48, 63, 53, 126, 62, 35, 113, 55, 35, 48, 54, 60, 52, 63, 37, 125, 113, 38, 57, 56, Framer.STDERR_FRAME_PREFIX, 57, 113, 48, 35, 52, 113, 63, 62, 37, 113, 34, 36, Framer.ENTER_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, 62, 35, 37, 52, 53, Ascii.DEL, 113, Ascii.NAK, 56, 53, 113, 40, 62, 36, 113, Framer.STDERR_FRAME_PREFIX, 48, 61, 61, 113, 4, 35, 56, Ascii.DEL, Framer.ENTER_FRAME_PREFIX, 48, 35, 34, 52, 121, Framer.EXIT_FRAME_PREFIX, 113, 62, 63, 113, 48, 113, 34, 37, 35, 56, 63, 54, 113, Framer.STDERR_FRAME_PREFIX, 62, 63, 37, 48, 56, 63, 56, 63, 54, 113, 118, 110, 118, 113, 62, 35, 113, 118, 114, 118, 110, 113, 4, 34, 52, 113, 4, 35, 56, Ascii.DEL, 55, 35, 62, 60, Ascii.ETB, 56, 61, 52, 121, 63, 52, 38, 113, Ascii.ETB, 56, 61, 52, 121, Framer.ENTER_FRAME_PREFIX, 48, 37, 57, Framer.EXIT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 113, 37, 62, 113, 48, 39, 62, 56, 53, 113, 37, 57, 56, 34, Ascii.DEL, 113, Framer.ENTER_FRAME_PREFIX, 48, 37, 57, 108, 116, 34, 125, 32, 36, 52, 35, 40, 108, 116, 34, 125, 55, 35, 48, 54, 60, 52, 63, 37, 108, 116, 34};
        String[] strArr = A05;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[3] = "X0VoZl0WlZuonvRnqv5GR18rztIlLTBl";
        strArr2[7] = "XOIDFuTAWw0P55lYRHi5z3HfEt22MTH0";
        A04 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    @MetaExoPlayerCustomization("FB tracing added in D4783963 for calls to TraceUtil.beginSection and TraceUtil.endSection")
    public final long AGi(C04685i c04685i) throws C2139pA {
        AnonymousClass54.A02(A01(0, 15, 71));
        Uri uri = c04685i.A06;
        this.A01 = uri;
        A0G(c04685i);
        this.A02 = A00(uri);
        try {
            try {
                this.A02.seek(c04685i.A04);
                this.A00 = c04685i.A03 == -1 ? this.A02.length() - c04685i.A04 : c04685i.A03;
                AnonymousClass54.A00();
                if (this.A00 < 0) {
                    throw new C2139pA(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
                this.A03 = true;
                A0H(c04685i);
                long j3 = this.A00;
                if (A05[1].length() == 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[0] = "xa7zJISj9";
                strArr[2] = "YSvWE2PgVF009LXgrm";
                return j3;
            } catch (IOException e3) {
                throw new C2139pA(e3, AdError.SERVER_ERROR_CODE);
            }
        } catch (Throwable th) {
            AnonymousClass54.A00();
            throw th;
        }
    }

    static {
        A02();
    }

    public C03691j() {
        super(false);
    }

    public static RandomAccessFile A00(Uri uri) throws C2139pA {
        int i3 = AdError.INTERNAL_ERROR_2006;
        try {
            return new RandomAccessFile((String) AbstractC04323y.A01(uri.getPath()), A01(29, 1, 31));
        } catch (FileNotFoundException e3) {
            boolean zIsEmpty = TextUtils.isEmpty(uri.getQuery());
            String[] strArr = A05;
            if (strArr[3].charAt(29) != strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            A05[1] = "uF4";
            if (zIsEmpty && TextUtils.isEmpty(uri.getFragment())) {
                if (C5C.A02 < 21 || !C04705k.A00(e3.getCause())) {
                    i3 = 2005;
                }
                throw new C2139pA(e3, i3);
            }
            throw new C2139pA(String.format(A01(30, 192, 19), uri.getPath(), uri.getQuery(), uri.getFragment()), e3, 1004);
        } catch (SecurityException e4) {
            throw new C2139pA(e4, AdError.INTERNAL_ERROR_2006);
        } catch (RuntimeException e5) {
            throw new C2139pA(e5, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Uri A9P() {
        return this.A01;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.facebook.ads.redexgen.core.C2139pA {
        /*
            r6 = this;
            r4 = 0
            r6.A01 = r4
            r3 = 0
            java.io.RandomAccessFile r0 = r6.A02     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
            if (r0 == 0) goto Ld
            java.io.RandomAccessFile r0 = r6.A02     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
            r0.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
        Ld:
            r6.A02 = r4
            boolean r4 = r6.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03691j.A05
            r0 = 0
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L37
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03691j.A05
            java.lang.String r1 = "OaGc5WGUg2QUkWgGCbKJpnMVI4k73TqR"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "7y85lWdOal5lz5BxO7mJ0PPL1NIIxTrt"
            r0 = 7
            r2[r0] = r1
            if (r4 == 0) goto L36
            r6.A03 = r3
            r6.A0E()
        L36:
            return
        L37:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3d:
            r2 = move-exception
            r1 = 2000(0x7d0, float:2.803E-42)
            com.facebook.ads.redexgen.X.pA r0 = new com.facebook.ads.redexgen.X.pA     // Catch: java.lang.Throwable -> L46
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L46
            throw r0     // Catch: java.lang.Throwable -> L46
        L46:
            r5 = move-exception
            r6.A02 = r4
            boolean r4 = r6.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03691j.A05
            r0 = 3
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 29
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L73
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03691j.A05
            java.lang.String r1 = "Vm3YcALUN"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "c4edS4Kr4EVyTdnKAl"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L72
        L6d:
            r6.A03 = r3
            r6.A0E()
        L72:
            throw r5
        L73:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03691j.A05
            java.lang.String r1 = "xGGiO6aoc87d3bdrOM0514KxVU6xxq2z"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "rL55lenIs2jXGgYduJCww9Rx5eQkWv1P"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto L72
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C03691j.close():void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
    @MetaExoPlayerCustomization("FB tracing added in D4783963 for calls to TraceUtil.beginSection and TraceUtil.endSection")
    public final int read(byte[] bArr, int i3, int i4) throws C2139pA {
        if (i4 == 0) {
            return 0;
        }
        try {
            if (this.A00 == 0) {
                return -1;
            }
            try {
                AnonymousClass54.A02(A01(15, 14, 75));
                int i5 = ((RandomAccessFile) C5C.A0f(this.A02)).read(bArr, i3, (int) Math.min(this.A00, i4));
                if (i5 > 0) {
                    this.A00 -= (long) i5;
                    A0F(i5);
                }
                return i5;
            } catch (IOException e3) {
                throw new C2139pA(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            AnonymousClass54.A00();
        }
    }
}
