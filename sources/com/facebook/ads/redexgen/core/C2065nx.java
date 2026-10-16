package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2065nx implements CH {
    public static byte[] A08;
    public static String[] A09 = {"6Pd6msxcVNGBSX02eJXjJuTK1755qRBj", "HohFYYIoFYVFLjySAriRsbI1EyK3MfzH", "CeUiguCmFwn8TW5CDLSIDkbyI8ACimQb", "zlyrIOO0KfkMjpYTb9psfC0NNgHcfA", "hplEZcFLtp2y3xCWfrXOGnyD7Ln2K5MA", "IDL7x3RfZufseciwLxrhiUDjrsxZNied", "XKrD5ajpOT4k5Fxpc35DaF0adCV7zARl", "Sdgzg0MlhPfZZU1TENhiXzUXxxUExQMT"};
    public CG A00;
    public final AbstractC04133d A01;
    public final C04685i A02;
    public final C8B A03;
    public final C0885Me A04;
    public final Executor A05;
    public volatile AbstractRunnableFutureC04584y<Void, IOException> A06;
    public volatile boolean A07;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A09;
            if (strArr[5].charAt(20) == strArr[2].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[1] = "fxMtGUUqqO78zEEYN3IhZEPjI2AJG4xW";
            strArr2[6] = "cS7s2KNWeBHf1m4W4BuqIbsBl519HGHJ";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 68);
            i6++;
        }
    }

    public static void A02() {
        A08 = new byte[]{Ascii.US, 34, 34, Ascii.FS, Ascii.RS, Ascii.ESC, Ascii.SI, 17, 17, Ascii.DLE, Ascii.FF, -1, 7, 9, Ascii.DLE, -1};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.CH
    public final void A63(CG cg) throws InterruptedException, IOException {
        this.A00 = cg;
        if (0 != 0) {
            throw new NullPointerException(A01(0, 3, 122));
        }
        boolean z2 = false;
        while (!z2) {
            try {
                if (this.A07) {
                    break;
                }
                this.A06 = new C2066ny(this);
                if (0 != 0) {
                    throw new NullPointerException(A01(3, 7, 104));
                }
                this.A05.execute(this.A06);
                try {
                    this.A06.get();
                    z2 = true;
                } catch (ExecutionException e3) {
                    Throwable th = (Throwable) AbstractC04323y.A01(e3.getCause());
                    if (0 == 0) {
                        if (th instanceof IOException) {
                            throw ((IOException) th);
                        }
                        C5C.A11(th);
                        throw null;
                    }
                }
            } catch (Throwable th2) {
                ((AbstractRunnableFutureC04584y) AbstractC04323y.A01(this.A06)).A02();
                if (0 == 0) {
                    throw th2;
                }
                throw new NullPointerException(A01(10, 6, 86));
            }
        }
        ((AbstractRunnableFutureC04584y) AbstractC04323y.A01(this.A06)).A02();
        if (0 != 0) {
            throw new NullPointerException(A01(10, 6, 86));
        }
    }

    static {
        A02();
    }

    public C2065nx(C2197q7 c2197q7, C1864kT c1864kT, Executor executor) {
        this.A05 = (Executor) AbstractC04323y.A01(executor);
        AbstractC04323y.A01(c2197q7.A03);
        this.A02 = new C04655f().A06(c2197q7.A03.A00).A08(c2197q7.A03.A04).A02(4).A09();
        this.A03 = c1864kT.A07();
        this.A04 = new C0885Me(this.A03, this.A02, null, new InterfaceC0884Md() { // from class: com.facebook.ads.redexgen.X.nz
            @Override // com.facebook.ads.redexgen.core.InterfaceC0884Md
            public final void AFX(long j3, long j4, long j5) {
                this.A00.A03(j3, j4, j5);
            }
        });
        this.A01 = c1864kT.A02();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(long j3, long j4, long j5) {
        float f3;
        if (this.A00 == null) {
            return;
        }
        if (j3 == -1 || j3 == 0) {
            f3 = -1.0f;
        } else {
            f3 = (j4 * 100.0f) / j3;
        }
        this.A00.AFW(j3, j4, f3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4y != com.facebook.ads.androidx.media3.common.util.RunnableFutureTask<java.lang.Void, java.io.IOException> */
    @Override // com.facebook.ads.redexgen.core.CH
    public final void cancel() {
        this.A07 = true;
        AbstractRunnableFutureC04584y<Void, IOException> abstractRunnableFutureC04584y = this.A06;
        if (abstractRunnableFutureC04584y != null) {
            abstractRunnableFutureC04584y.cancel(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.CH
    public final void remove() {
        this.A03.A0E().AIU(this.A03.A0F().A4l(this.A02));
    }
}
