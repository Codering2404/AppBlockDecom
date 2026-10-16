package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AesFlushingCipher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cipher f41784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f41785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f41786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f41787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f41788e;

    public AesFlushingCipher(int i3, byte[] bArr, String str, long j3) {
        this(i3, bArr, a(str), j3);
    }

    private static long a(String str) {
        long j3 = 0;
        if (str == null) {
            return 0L;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            long jCharAt = j3 ^ ((long) str.charAt(i3));
            j3 = jCharAt + (jCharAt << 1) + (jCharAt << 4) + (jCharAt << 5) + (jCharAt << 7) + (jCharAt << 8) + (jCharAt << 40);
        }
        return j3;
    }

    private byte[] b(long j3, long j4) {
        return ByteBuffer.allocate(16).putLong(j3).putLong(j4).array();
    }

    private int c(byte[] bArr, int i3, int i4, byte[] bArr2, int i5) {
        try {
            return this.f41784a.update(bArr, i3, i4, bArr2, i5);
        } catch (ShortBufferException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void d(byte[] bArr, int i3, int i4, byte[] bArr2, int i5) {
        int i6 = i3;
        int i7 = i4;
        int i8 = i5;
        do {
            int i9 = this.f41788e;
            if (i9 <= 0) {
                int iC = c(bArr, i6, i7, bArr2, i8);
                if (i7 == iC) {
                    return;
                }
                int i10 = i7 - iC;
                int i11 = 0;
                Assertions.g(i10 < this.f41785b);
                int i12 = i8 + iC;
                int i13 = this.f41785b - i10;
                this.f41788e = i13;
                Assertions.g(c(this.f41786c, 0, i13, this.f41787d, 0) == this.f41785b);
                while (i11 < i10) {
                    bArr2[i12] = this.f41787d[i11];
                    i11++;
                    i12++;
                }
                return;
            }
            bArr2[i8] = (byte) (bArr[i6] ^ this.f41787d[this.f41785b - i9]);
            i8++;
            i6++;
            this.f41788e = i9 - 1;
            i7--;
        } while (i7 != 0);
    }

    public void e(byte[] bArr, int i3, int i4) {
        d(bArr, i3, i4, bArr, i3);
    }

    public AesFlushingCipher(int i3, byte[] bArr, long j3, long j4) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.f41784a = cipher;
            int blockSize = cipher.getBlockSize();
            this.f41785b = blockSize;
            this.f41786c = new byte[blockSize];
            this.f41787d = new byte[blockSize];
            long j5 = j4 / ((long) blockSize);
            int i4 = (int) (j4 % ((long) blockSize));
            cipher.init(i3, new SecretKeySpec(bArr, Util.i1(cipher.getAlgorithm(), "/")[0]), new IvParameterSpec(b(j3, j5)));
            if (i4 != 0) {
                e(new byte[i4], 0, i4);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
