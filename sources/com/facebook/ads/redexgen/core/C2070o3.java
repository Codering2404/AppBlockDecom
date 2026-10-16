package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2070o3 implements CJ {
    public static byte[] A02;
    public static final SparseArray<Constructor<? extends CH>> A03;
    public final C1864kT A00;
    public final Executor A01;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 117);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Constructor<? extends CH> A03(Class<?> cls) {
        try {
            return cls.asSubclass(CH.class).getConstructor(C2197q7.class, C1864kT.class, Executor.class);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException(A02(0, 30, 5), e3);
        }
    }

    public static void A04() {
        A02 = new byte[]{-66, -23, -15, -24, -26, -23, -37, -34, -33, -20, -102, -35, -23, -24, -19, -18, -20, -17, -35, -18, -23, -20, -102, -25, -29, -19, -19, -29, -24, -31, -10, 17, Ascii.EM, Ascii.FS, Ascii.NAK, Ascii.DC4, -48, 36, Ascii.US, -48, Ascii.EM, Ascii.RS, 35, 36, 17, Ascii.RS, 36, Ascii.EM, 17, 36, Ascii.NAK, -48, Ascii.DC4, Ascii.US, 39, Ascii.RS, Ascii.FS, Ascii.US, 17, Ascii.DC4, Ascii.NAK, 34, -48, Ascii.SYN, Ascii.US, 34, -48, 19, Ascii.US, Ascii.RS, 36, Ascii.NAK, Ascii.RS, 36, -48, 36, 41, 32, Ascii.NAK, -48, 34, 68, 57, 74, 65, 58, -11, 66, 62, 72, 72, 62, 67, 60, -11, 59, 68, 71, -11, 56, 68, 67, 73, 58, 67, 73, -11, 73, 78, 69, 58, -11, -2, Ascii.ETB, Ascii.FS, Ascii.RS, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.ESC, Ascii.GS, Ascii.SO, Ascii.CR, -55, Ascii.GS, 34, Ascii.EM, Ascii.SO, -29, -55, 46, 58, 56, -7, Framer.STDOUT_FRAME_PREFIX, 44, 46, 48, Framer.STDIN_FRAME_PREFIX, 58, 58, 54, -7, 44, 47, 62, -7, 44, 57, 47, 61, 58, 52, 47, 67, -7, 56, 48, 47, 52, 44, -2, -7, 48, 67, 58, 59, 55, 44, 68, 48, 61, -7, 62, 58, 64, 61, 46, 48, -7, 47, 44, 62, 51, -7, 58, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 55, 52, 57, 48, -7, Ascii.SI, 44, 62, 51, Ascii.SI, 58, 66, 57, 55, 58, 44, 47, 48, 61, 40, 52, Framer.STDERR_FRAME_PREFIX, -13, 43, 38, 40, 42, 39, 52, 52, 48, -13, 38, 41, 56, -13, 38, 51, 41, 55, 52, 46, 41, 61, -13, Framer.STDERR_FRAME_PREFIX, 42, 41, 46, 38, -8, -13, 42, 61, 52, 53, Framer.STDOUT_FRAME_PREFIX, 38, 62, 42, 55, -13, 56, 52, 58, 55, 40, 42, -13, Framer.STDIN_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 56, -13, 52, 43, 43, Framer.STDOUT_FRAME_PREFIX, 46, 51, 42, -13, Ascii.CR, Framer.STDOUT_FRAME_PREFIX, 56, 9, 52, 60, 51, Framer.STDOUT_FRAME_PREFIX, 52, 38, 41, 42, 55, 87, 99, 97, 34, 90, 85, 87, 89, 86, 99, 99, Framer.STDIN_REQUEST_FRAME_PREFIX, 34, 85, 88, 103, 34, 85, 98, 88, 102, 99, 93, 88, 108, 34, 97, 89, 88, 93, 85, 39, 34, 89, 108, 99, 100, 96, 85, 109, 89, 102, 34, 103, 99, 105, 102, 87, 89, 34, 103, 97, 99, 99, 104, 92, 103, 104, 102, 89, 85, 97, 93, 98, 91, 34, 99, 90, 90, 96, 93, 98, 89, 34, 71, 103, 56, 99, 107, 98, 96, 99, 85, 88, 89, 102};
    }

    static {
        A04();
        A03 = A00();
    }

    public C2070o3(C1864kT c1864kT, Executor executor) {
        this.A00 = (C1864kT) AbstractC04323y.A01(c1864kT);
        this.A01 = (Executor) AbstractC04323y.A01(executor);
    }

    public static SparseArray<Constructor<? extends CH>> A00() {
        SparseArray<Constructor<? extends CH>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, A03(Class.forName(A02(130, 77, 86))));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, A03(Class.forName(A02(207, 75, 80))));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, A03(Class.forName(A02(282, 86, 127))));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private CH A01(DownloadRequest downloadRequest, int i3) {
        Constructor<? extends CH> constructor = A03.get(i3);
        if (constructor != null) {
            try {
                return constructor.newInstance(new C04042u().A00(downloadRequest.A00).A04(downloadRequest.A04).A02(downloadRequest.A01).A05(), this.A00, this.A01);
            } catch (Exception e3) {
                throw new IllegalStateException(A02(30, 50, 59) + i3, e3);
            }
        }
        throw new IllegalStateException(A02(80, 32, 96) + i3);
    }

    @Override // com.facebook.ads.redexgen.core.CJ
    public final CH A5M(DownloadRequest downloadRequest) {
        int iA0B = C5C.A0B(downloadRequest.A00, downloadRequest.A03);
        switch (iA0B) {
            case 0:
            case 1:
            case 2:
                return A01(downloadRequest, iA0B);
            case 3:
            default:
                throw new IllegalArgumentException(A02(112, 18, 52) + iA0B);
            case 4:
                return new C2065nx(new C04042u().A00(downloadRequest.A00).A02(downloadRequest.A01).A05(), this.A00, this.A01);
        }
    }
}
