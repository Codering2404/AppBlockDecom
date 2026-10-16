package com.facebook.ads.redexgen.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1435dF extends InputStream {
    public static byte[] A04;
    public MessageDigest A00;
    public final C1644ge A01;
    public final InterfaceC1434dE A02;
    public final FileInputStream A03;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-52, -61, -76, -23, -8, -15};
    }

    public C1435dF(C1644ge c1644ge, FileInputStream fileInputStream, InterfaceC1434dE interfaceC1434dE) {
        this.A03 = fileInputStream;
        this.A02 = interfaceC1434dE;
        this.A01 = c1644ge;
        try {
            this.A00 = MessageDigest.getInstance(A00(0, 3, 84));
        } catch (NoSuchAlgorithmException unused) {
            this.A00 = null;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.A03.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b3 = new byte[1];
        return read(b3);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.A03.read(bArr, i3, i4);
        if (this.A00 != null) {
            try {
                if (i5 > 0) {
                    this.A00.update(bArr, i3, i5);
                } else if (i5 == -1) {
                    this.A02.A9s(C1156Xa.A05(this.A00.digest()));
                    this.A00 = null;
                }
            } catch (Exception e3) {
                this.A00 = null;
                this.A01.A08().ABz(A00(3, 3, 90), AbstractC1060Td.A13, new C1061Te(e3));
            }
        }
        return i5;
    }

    @Override // java.io.InputStream
    public final long skip(long j3) throws IOException {
        int actuallyRead = (int) j3;
        byte[] bArr = new byte[1024];
        long j4 = 0;
        while (actuallyRead > 0) {
            int bytesToRead = read(bArr, 0, Math.min(actuallyRead, 1024));
            if (bytesToRead <= 0) {
                break;
            }
            actuallyRead -= bytesToRead;
            j4 += (long) bytesToRead;
        }
        return j4;
    }
}
