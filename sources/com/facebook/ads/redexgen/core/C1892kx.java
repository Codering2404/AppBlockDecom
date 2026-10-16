package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import com.facebook.stetho.dumpapp.Framer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1892kx implements LU<Bitmap> {
    public static byte[] A06;
    public final int A00;
    public final int A01;
    public final String A02 = C1892kx.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-110, -40, -47, -44, 3, 42, 53, 46, 34, Framer.STDOUT_FRAME_PREFIX, -31, 42, 52, -31, 47, 54, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, -55, -4, -25, -23, -12, -8, -19, -13, -14, -92, -24, -7, -10, -19, -14, -21, -92, -22, -19, -16, -23, -92, -25, -13, -15, -12, -10, -23, -9, -9, -19, -13, -14};
    }

    public C1892kx(int i3, int i4, boolean z2, boolean z3, boolean z4) {
        this.A01 = i3;
        this.A00 = i4;
        this.A05 = z2;
        this.A03 = z3;
        this.A04 = z4;
    }

    public static LT<Bitmap> A00(Throwable th) {
        return new LT<>(false, null, th);
    }

    private void A03(File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            ByteArrayOutputStream compressedBitmapOS = new ByteArrayOutputStream();
            byteArrayOutputStream = compressedBitmapOS;
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 25);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    fileOutputStream2.write(bArr, 0, i3);
                } else {
                    file2.delete();
                    return;
                }
            }
        } finally {
            AbstractC0868Ln.A07(byteArrayOutputStream);
            AbstractC0868Ln.A07(fileOutputStream);
            AbstractC0868Ln.A07(fileInputStream);
            AbstractC0868Ln.A07(fileOutputStream2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.LU
    public final LT<Bitmap> A3x(File file, InterfaceC0867Lm interfaceC0867Lm) {
        if (!this.A04) {
            return new LT<>(true, null);
        }
        try {
            Bitmap bitmapA03 = AbstractC0868Ln.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (bitmapA03 != null) {
                return new LT<>(true, bitmapA03);
            }
            interfaceC0867Lm.AB4(new C1883kn(A01(4, 14, 118)));
            return A00(null);
        } catch (Throwable t2) {
            file.delete();
            interfaceC0867Lm.AB4(t2);
            return A00(t2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.LU
    public final void A5D(File file, InterfaceC0867Lm interfaceC0867Lm) throws Throwable {
        if (this.A03) {
            try {
                Bitmap bitmap = AbstractC0868Ln.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (bitmap != null) {
                    A03(file, bitmap);
                } else {
                    file.delete();
                    throw new C1883kn(A01(4, 14, 118));
                }
            } catch (C1883kn e3) {
                interfaceC0867Lm.ABI(e3);
                throw e3;
            } catch (Throwable th) {
                interfaceC0867Lm.ABI(th);
                Throwable t2 = new C1883kn(A01(18, 33, 57), th);
                throw t2;
            }
        }
    }
}
