package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1860kP implements InterfaceC0888Mh {
    public static byte[] A07;
    public static String[] A08 = {"F3MsLf6P", "OcoAPMR8U6yTwuATNsSjihct3nuq8KFx", "bdE6GcC1kS6ix1fgAcoyQkC9rv", "V0wqj6Me", "EdnIrf", "cKhO3MBZMfPQ2uYBFx142UbqGZ0vcEvq", "x8zWNoAeDf", "YEiR7yHxtXFy2pC0Q9KvxgBtY"};
    public C0895Mo A00;
    public boolean A01;
    public final AnonymousClass40 A02;
    public final SecureRandom A03;
    public final Cipher A04;
    public final SecretKeySpec A05;
    public final boolean A06;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A08;
            if (strArr[2].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[6] = "SFj9nJw9GR";
            strArr2[4] = "liv3w1";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 117);
            i6++;
        }
    }

    public static void A03() {
        A07 = new byte[]{Ascii.VT, Ascii.SI, Ascii.GS};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A05(HashMap<String, C0887Mg> map) throws IOException {
        try {
            C04333z c04333zA03 = this.A02.A03();
            if (this.A00 == null) {
                this.A00 = new C0895Mo(c04333zA03);
            } else {
                this.A00.A00(c04333zA03);
            }
            C0895Mo c0895Mo = this.A00;
            DataOutputStream dataOutputStream = new DataOutputStream(c0895Mo);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(this.A06 ? 1 : 0);
            if (this.A06) {
                byte[] bArr = new byte[16];
                ((SecureRandom) C5C.A0f(this.A03)).nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    ((Cipher) C5C.A0f(this.A04)).init(1, (Key) C5C.A0f(this.A05), new IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new DataOutputStream(new CipherOutputStream(c0895Mo, this.A04));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e3) {
                    throw new IllegalStateException(e3);
                }
            }
            dataOutputStream.writeInt(map.size());
            int iA00 = 0;
            for (C0887Mg c0887Mg : map.values()) {
                A04(c0887Mg, dataOutputStream);
                iA00 += A00(c0887Mg, 2);
            }
            dataOutputStream.writeInt(iA00);
            this.A02.A06(dataOutputStream);
            C5C.A10(null);
        } catch (Throwable th) {
            C5C.A10(null);
            throw th;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private boolean A06(HashMap<String, C0887Mg> map, SparseArray<String> sparseArray) {
        if (!this.A02.A07()) {
            return true;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A02.A04());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int i3 = dataInputStream.readInt();
            if (i3 < 0 || i3 > 2) {
                C5C.A10(dataInputStream);
                return false;
            }
            if ((dataInputStream.readInt() & 1) != 0) {
                if (this.A04 == null) {
                    C5C.A10(dataInputStream);
                    return false;
                }
                byte[] bArr = new byte[16];
                dataInputStream.readFully(bArr);
                try {
                    this.A04.init(2, (Key) C5C.A0f(this.A05), new IvParameterSpec(bArr));
                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A04));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e3) {
                    throw new IllegalStateException(e3);
                }
            } else if (this.A06) {
                this.A01 = true;
            }
            int i4 = dataInputStream.readInt();
            int iA00 = 0;
            for (int i5 = 0; i5 < i4; i5++) {
                C0887Mg c0887MgA01 = A01(i3, dataInputStream);
                map.put(c0887MgA01.A02, c0887MgA01);
                sparseArray.put(c0887MgA01.A01, c0887MgA01.A02);
                iA00 += A00(c0887MgA01, i3);
            }
            int i6 = dataInputStream.readInt();
            boolean z2 = dataInputStream.read() == -1;
            if (i6 == iA00 && z2) {
                C5C.A10(dataInputStream);
                return true;
            }
            C5C.A10(dataInputStream);
            return false;
        } catch (IOException unused) {
            if (0 != 0) {
                C5C.A10(null);
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                C5C.A10(null);
            }
            throw th;
        }
    }

    static {
        A03();
    }

    public C1860kP(File file, byte[] bArr, boolean z2) {
        AbstractC04323y.A08((bArr == null && z2) ? false : true);
        Cipher cipherA05 = null;
        SecretKeySpec secretKeySpec = null;
        if (bArr != null) {
            AbstractC04323y.A07(bArr.length == 16);
            try {
                cipherA05 = C0889Mi.A05();
                secretKeySpec = new SecretKeySpec(bArr, A02(0, 3, 85));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
                throw new IllegalStateException(e3);
            }
        } else {
            AbstractC04323y.A07(!z2);
        }
        this.A06 = z2;
        this.A04 = cipherA05;
        this.A05 = secretKeySpec;
        this.A03 = z2 ? new SecureRandom() : null;
        this.A02 = new AnonymousClass40(file);
    }

    private int A00(C0887Mg c0887Mg, int i3) {
        int result = c0887Mg.A01;
        int i4 = result * 31;
        int result2 = c0887Mg.A02.hashCode();
        int result3 = i4 + result2;
        if (i3 < 2) {
            long jA00 = AbstractC0890Mj.A00(c0887Mg.A03());
            return (result3 * 31) + ((int) ((jA00 >>> 32) ^ jA00));
        }
        return (result3 * 31) + c0887Mg.A03().hashCode();
    }

    private C0887Mg A01(int i3, DataInputStream dataInputStream) throws IOException {
        C1858kN c1858kNA02;
        int i4 = dataInputStream.readInt();
        String utf = dataInputStream.readUTF();
        if (i3 >= 2) {
            c1858kNA02 = C0889Mi.A02(dataInputStream);
        } else {
            long length = dataInputStream.readLong();
            C0892Ml c0892Ml = new C0892Ml();
            C0892Ml.A00(c0892Ml, length);
            c1858kNA02 = C1858kN.A03.A05(c0892Ml);
        }
        return new C0887Mg(i4, utf, c1858kNA02);
    }

    private void A04(C0887Mg c0887Mg, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(c0887Mg.A01);
        dataOutputStream.writeUTF(c0887Mg.A02);
        C0889Mi.A08(c0887Mg.A03(), dataOutputStream);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void A5p() {
        this.A02.A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final boolean A6S() {
        return this.A02.A07();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AAF(long j3) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AAs(HashMap<String, C0887Mg> map, SparseArray<String> sparseArray) {
        AbstractC04323y.A08(!this.A01);
        if (!A06(map, sparseArray)) {
            map.clear();
            String[] strArr = A08;
            if (strArr[2].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A08[7] = "LXlnn5Px";
            sparseArray.clear();
            this.A02.A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AFd(C0887Mg c0887Mg, boolean z2) {
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AGK(C0887Mg c0887Mg) {
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AKI(HashMap<String, C0887Mg> map) throws IOException {
        A05(map);
        this.A01 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0888Mh
    public final void AKJ(HashMap<String, C0887Mg> map) throws IOException {
        if (!this.A01) {
            return;
        }
        AKI(map);
    }
}
