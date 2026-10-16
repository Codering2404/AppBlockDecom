package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.sun.jna.Function;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.km, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1882km {
    public static byte[] A03;
    public File A00;
    public RandomAccessFile A01;
    public final InterfaceC0857Lc A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-90, -25, -7, -90, -22, -17, -7, -23, -90, -23, -25, -23, -18, -21, -112, -42, -33, -30, -112, -45, -33, -35, -32, -36, -43, -28, -39, -33, -34, -111, -33, 40, Framer.STDERR_FRAME_PREFIX, -33, 34, 46, 44, 47, 43, 36, 51, 36, 35, -32, -44, 40, 35, -44, -50, 4, Ascii.SI, Ascii.ETB, Ascii.SO, Ascii.FF, Ascii.SI, 1, 4, -62, -32, -19, -90, -13, -97, -30, -21, -28, -32, -19, -97, -27, -24, -21, -28, -51, -6, -6, -9, -6, -88, -23, -8, -8, -19, -10, -20, -88, -21, -23, -21, -16, -19, -62, -88, -21, -23, -21, -16, -19, -88, -18, -15, -12, -19, -88, -29, Ascii.DLE, Ascii.DLE, Ascii.CR, Ascii.DLE, -66, 1, 10, Ascii.CR, 17, 7, Ascii.FF, 5, -66, 4, 7, 10, 3, -66, -72, -27, -27, -30, -27, -109, -30, -29, -40, -31, -36, -31, -38, -109, -44, 1, 1, -2, 1, -81, 1, -12, -16, -13, -8, -3, -10, -81, -5, -12, -3, -10, 3, -9, -81, -2, -11, -81, -11, -8, -5, -12, -81, -119, -74, -74, -77, -74, 100, -74, -87, -78, -91, -79, -83, -78, -85, 100, -86, -83, -80, -87, 100, -68, -23, -23, -26, -23, -105, -20, -22, -32, -27, -34, -105, -35, -32, -29, -36, -105, -50, -5, -5, -8, -5, -87, 0, -5, -14, -3, -14, -9, -16, -87, -82, -19, -87, -21, 2, -3, -18, -4, -87, -3, -8, -87, -82, -4, -87, -17, -5, -8, -10, -87, -21, -2, -17, -17, -18, -5, -87, 0, -14, -3, -15, -87, -4, -14, 3, -18, -87, -82, -19, -16, -11, -6};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A07() throws C1876kg {
        if (A09()) {
            return;
        }
        A06();
        File file = new File(this.A00.getParentFile(), this.A00.getName().substring(0, this.A00.getName().length() - A00(48, 9, 95).length()));
        if (!this.A00.renameTo(file)) {
            throw new C1876kg(A00(166, 20, 3) + this.A00 + A00(44, 4, 115) + file + A00(14, 16, 47));
        }
        this.A00 = file;
        try {
            this.A01 = new RandomAccessFile(this.A00, A00(Function.MAX_NARGS, 1, 61));
        } catch (IOException e3) {
            throw new C1876kg(A00(123, 14, 50) + this.A00 + A00(0, 14, 69), e3);
        }
    }

    public C1882km(File file, InterfaceC0857Lc interfaceC0857Lc) throws C1876kg {
        try {
            if (interfaceC0857Lc != null) {
                this.A02 = interfaceC0857Lc;
                File directory = file.getParentFile();
                C0860Lf.A06(directory);
                boolean zExists = file.exists();
                this.A00 = zExists ? file : new File(file.getParentFile(), file.getName() + A00(48, 9, 95));
                this.A01 = new RandomAccessFile(this.A00, zExists ? A00(Function.MAX_NARGS, 1, 61) : A00(257, 2, 66));
                return;
            }
            throw new NullPointerException();
        } catch (IOException e3) {
            throw new C1876kg(A00(186, 17, 54) + file + A00(0, 14, 69), e3);
        }
    }

    private boolean A02(File file) {
        return file.getName().endsWith(A00(48, 9, 95));
    }

    public final synchronized int A03() throws C1876kg {
        try {
        } catch (IOException e3) {
            throw new C1876kg(A00(137, 29, 78) + this.A00, e3);
        }
        return (int) this.A01.length();
    }

    public final File A04() {
        return this.A00;
    }

    public final synchronized void A05() throws C1876kg {
        try {
            this.A01.setLength(0L);
        } catch (IOException e3) {
            throw new C1876kg(A00(57, 16, 62), e3);
        }
    }

    public final synchronized void A06() throws C1876kg {
        try {
            this.A01.close();
            this.A02.AKR(this.A00);
        } catch (IOException e3) {
            throw new C1876kg(A00(104, 19, 93) + this.A00, e3);
        }
    }

    public final synchronized void A08(byte[] bArr, int i3) throws C1876kg {
        try {
            if (!A09()) {
                this.A01.seek(A03());
                this.A01.write(bArr, 0, i3);
            } else {
                throw new C1876kg(A00(73, 31, 71) + this.A00 + A00(30, 14, 126));
            }
        } catch (IOException e3) {
            throw new C1876kg(String.format(Locale.US, A00(203, 53, 72), Integer.valueOf(i3), this.A01, Integer.valueOf(bArr.length)), e3);
        }
    }

    public final synchronized boolean A09() {
        return !A02(this.A00);
    }
}
