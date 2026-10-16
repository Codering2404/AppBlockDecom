package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbga extends zzbfs {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzbga(int i3) {
        int i4 = i3 >> 3;
        this.zzc = (i3 & 7) > 0 ? i4 + 1 : i4;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final byte[] zza(String str) {
        synchronized (this.zza) {
            try {
                MessageDigest messageDigestZzb = zzb();
                this.zzb = messageDigestZzb;
                if (messageDigestZzb == null) {
                    return new byte[0];
                }
                messageDigestZzb.reset();
                this.zzb.update(str.getBytes(StandardCharsets.UTF_8));
                byte[] bArrDigest = this.zzb.digest();
                int length = bArrDigest.length;
                int i3 = this.zzc;
                if (length > i3) {
                    length = i3;
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bArrDigest, 0, bArr, 0, length);
                int i4 = this.zzd & 7;
                if (i4 > 0) {
                    long j3 = 0;
                    for (int i5 = 0; i5 < length; i5++) {
                        if (i5 > 0) {
                            j3 <<= 8;
                        }
                        j3 += (long) (bArr[i5] & 255);
                    }
                    long j4 = j3 >>> (8 - i4);
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                        bArr[i3] = (byte) (255 & j4);
                        j4 >>>= 8;
                    }
                }
                return bArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
