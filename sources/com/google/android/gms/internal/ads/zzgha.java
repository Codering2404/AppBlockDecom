package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgha {
    private MessageDigest zza;
    private final zzgqh zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private SecureRandom zze;

    public zzgha(zzgqh zzgqhVar) {
        this.zzb = zzgqhVar;
    }

    public final void zza() {
        if (zzc()) {
            return;
        }
        zzb(new SecureRandom());
    }

    final synchronized void zzb(SecureRandom secureRandom) {
        zzgqf zzgqfVarZza = this.zzb.zza(202);
        try {
            try {
                try {
                    zzgqfVarZza.zza();
                    this.zze = secureRandom;
                    this.zza = MessageDigest.getInstance("MD5");
                    this.zzd = true;
                } catch (Throwable th) {
                    zzgqfVarZza.zzb(th);
                    throw th;
                }
            } catch (NoSuchAlgorithmException e3) {
                zzgqfVarZza.zzb(e3);
            }
            zzgqfVarZza.zzc();
        } catch (Throwable th2) {
            zzgqfVarZza.zzc();
            throw th2;
        }
    }

    public final synchronized boolean zzc() {
        return this.zzd;
    }

    final byte[] zzd(byte[] bArr, String str, boolean z2) {
        int length = bArr.length;
        int i3 = true != z2 ? 255 : 239;
        zzgtj.zza(length <= i3);
        ByteBuffer byteBufferPut = ByteBuffer.allocate(i3 + 1).put((byte) length);
        if (length < i3) {
            int i4 = i3 - length;
            byte[] bArr2 = new byte[i4];
            this.zze.nextBytes(bArr2);
            bArr = Arrays.copyOf(bArr, length + i4);
            System.arraycopy(bArr2, 0, bArr, length, i4);
        }
        byte[] bArrArray = byteBufferPut.put(bArr).array();
        if (z2) {
            bArrArray = ByteBuffer.allocate(Function.MAX_NARGS).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[Function.MAX_NARGS];
        zzghd[] zzghdVarArr = new zzghq().zzcK;
        int length2 = zzghdVarArr.length;
        for (int i5 = 0; i5 < 12; i5++) {
            zzghdVarArr[i5].zza(bArrArray, bArr3);
        }
        if (!zzgua.zzc(str)) {
            new zzghc(str.length() > 32 ? str.substring(0, 32).getBytes(StandardCharsets.UTF_8) : str.getBytes(StandardCharsets.UTF_8)).zza(bArr3);
        }
        return bArr3;
    }

    public final byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (this.zzc) {
            this.zza.reset();
            this.zza.update(bArr);
            bArrDigest = this.zza.digest();
        }
        return bArrDigest;
    }

    public final zzaze zzf(byte[] bArr, String str) {
        zzaze zzazeVarZza = zzazf.zza();
        byte[] bArrZze = zze(bArr);
        zzida zzidaVar = zzida.zza;
        zzazeVarZza.zzb(zzida.zzt(bArrZze, 0, bArrZze.length));
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int length = bArr.length;
            if (i3 >= ((length - 1) / 255) + 1) {
                break;
            }
            int i4 = i3 * 255;
            int i5 = i4 + 255;
            if (length > i5) {
                length = i5;
            }
            arrayList.add(Arrays.copyOfRange(bArr, i4, length));
            i3++;
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            zzazeVarZza.zza(zzida.zzt(zzd((byte[]) obj, str, false), 0, Function.MAX_NARGS));
        }
        return zzazeVarZza;
    }

    public final String zzg(int i3, String str) {
        zzaxm zzaxmVarZzj = zzaym.zzj();
        zzaxmVarZzj.zzl(i3);
        return Base64.encodeToString(zzd(((zzaym) zzaxmVarZzj.zzbu()).zzaN(), str, true), 11);
    }
}
