package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzide {
    public static final /* synthetic */ int zze = 0;
    private static volatile int zzf = 100;
    int zza;
    int zzb;
    final int zzc = zzf;
    Object zzd;

    private zzide() {
    }

    public static zzide zzH(InputStream inputStream, int i3) {
        return inputStream == null ? zzI(zzier.zza, 0, 0, false) : new zzidd(inputStream, 4096, null);
    }

    static zzide zzI(byte[] bArr, int i3, int i4, boolean z2) {
        zzidc zzidcVar = new zzidc(bArr, i3, i4, z2, null);
        try {
            zzidcVar.zzB(i4);
            return zzidcVar;
        } catch (zziet e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int zzM(int i3) {
        return (i3 >>> 1) ^ (-(i3 & 1));
    }

    public static long zzN(long j3) {
        return (j3 >>> 1) ^ (-(1 & j3));
    }

    public static int zzO(int i3, InputStream inputStream) throws IOException {
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            return i3;
        }
        int i4 = i3 & 127;
        int i5 = 7;
        while (i5 < 32) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            i4 |= (i6 & 127) << i5;
            if ((i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return i4;
            }
            i5 += 7;
        }
        while (i5 < 64) {
            int i7 = inputStream.read();
            if (i7 == -1) {
                throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return i4;
            }
            i5 += 7;
        }
        throw new zziet("CodedInputStream encountered a malformed varint.");
    }

    public abstract int zzB(int i3) throws zziet;

    public abstract void zzC(int i3);

    public abstract boolean zzD() throws IOException;

    public abstract int zzE();

    public final void zzJ() throws zziet {
        if (this.zza + this.zzb >= this.zzc) {
            throw new zziet("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void zzK() throws zziet {
        if (this.zzb == 0) {
            zzb(0);
        }
    }

    public final void zzL() throws IOException {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzJ();
            this.zzb++;
            this.zzb--;
        } while (zzc(iZza));
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i3) throws zziet;

    public abstract boolean zzc(int i3) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzida zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    public abstract int zzs() throws IOException;

    public abstract long zzt() throws IOException;

    /* synthetic */ zzide(byte[] bArr) {
    }
}
