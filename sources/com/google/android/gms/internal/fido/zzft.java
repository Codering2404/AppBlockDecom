package com.google.android.gms.internal.fido;

import com.applovin.exoplayer2.common.base.Ascii;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzft {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    zzft() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            if (zzb() == zzftVar.zzb() && zzc(zzftVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] bArrZze = zze();
        int i3 = bArrZze[0] & 255;
        for (int i4 = 1; i4 < bArrZze.length; i4++) {
            i3 |= (bArrZze[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    public final String toString() {
        byte[] bArrZze = zze();
        int length = bArrZze.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b3 : bArrZze) {
            char[] cArr = zza;
            sb.append(cArr[(b3 >> 4) & 15]);
            sb.append(cArr[b3 & Ascii.SI]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    abstract boolean zzc(zzft zzftVar);

    public abstract byte[] zzd();

    byte[] zze() {
        throw null;
    }
}
