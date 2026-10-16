package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import com.sun.jna.Function;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzazo {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    static void zza() {
        synchronized (zzf) {
            try {
                if (!zza) {
                    zza = true;
                    new Thread(new zzazn(null)).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static String zzb(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        zzaze zzazeVarZzc = zzc(bArr, str);
        return zzazi.zza(zzazeVarZzc == null ? zzh(zzg(4096).zzaN(), str, true) : ((zzazf) zzazeVarZzc.zzbu()).zzaN(), true);
    }

    static zzaze zzc(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector vectorZzd = zzd(bArr, 255);
        if (vectorZzd == null || vectorZzd.isEmpty()) {
            return null;
        }
        zzaze zzazeVarZza = zzazf.zza();
        int size = vectorZzd.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzazeVarZza.zza(zzida.zzt(zzh((byte[]) vectorZzd.get(i3), str, false), 0, Function.MAX_NARGS));
        }
        byte[] bArrZze = zze(bArr);
        zzida zzidaVar = zzida.zza;
        zzazeVarZza.zzb(zzida.zzt(bArrZze, 0, bArrZze.length));
        return zzazeVarZza;
    }

    static Vector zzd(byte[] bArr, int i3) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i4 = length + 254;
        Vector vector = new Vector();
        for (int i5 = 0; i5 < i4 / 255; i5++) {
            int i6 = i5 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i6 > 255) {
                    length2 = i6 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i6, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (zze) {
            try {
                zza();
                MessageDigest messageDigest2 = null;
                try {
                    if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = zzd.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    static zzaym zzg(int i3) {
        zzaxm zzaxmVarZzj = zzaym.zzj();
        zzaxmVarZzj.zzl(4096L);
        return (zzaym) zzaxmVarZzj.zzbu();
    }

    private static byte[] zzh(byte[] bArr, String str, boolean z2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int length = bArr.length;
        int i3 = true != z2 ? 255 : 239;
        if (length > i3) {
            bArr = zzg(4096).zzaN();
        }
        int i4 = i3 + 1;
        int length2 = bArr.length;
        byte b3 = (byte) length2;
        if (length2 < i3) {
            byte[] bArr2 = new byte[i3 - length2];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i4).put(b3).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i4).put(b3).put(bArr).array();
        }
        if (z2) {
            bArrArray = ByteBuffer.allocate(Function.MAX_NARGS).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[Function.MAX_NARGS];
        zzazp[] zzazpVarArr = new zzbac().zzcK;
        int length3 = zzazpVarArr.length;
        for (int i5 = 0; i5 < 12; i5++) {
            zzazpVarArr[i5].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzazg(str.getBytes(Utf8Charset.NAME)).zza(bArr3);
        }
        return bArr3;
    }
}
