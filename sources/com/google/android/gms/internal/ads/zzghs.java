package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzghs {
    public static final Charset zza = StandardCharsets.UTF_8;
    private static Cipher zzb = null;
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();

    private static final Cipher zzc() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzd) {
            try {
                if (zzb == null) {
                    zzb = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) throws zzghr {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrZzb = zzgea.zzb(str, false);
            int length2 = bArrZzb.length;
            if (length2 <= 16) {
                throw new zzghr();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzc) {
                zzc().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = zzc().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new zzghr(e);
        } catch (InvalidAlgorithmParameterException e4) {
            e = e4;
            throw new zzghr(e);
        } catch (InvalidKeyException e5) {
            e = e5;
            throw new zzghr(e);
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            throw new zzghr(e);
        } catch (BadPaddingException e7) {
            e = e7;
            throw new zzghr(e);
        } catch (IllegalBlockSizeException e8) {
            e = e8;
            throw new zzghr(e);
        } catch (NoSuchPaddingException e9) {
            e = e9;
            throw new zzghr(e);
        }
    }

    public final String zzb(byte[] bArr, String str) throws zzghr {
        return new String(zza(bArr, str), zza);
    }
}
