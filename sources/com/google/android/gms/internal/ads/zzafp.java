package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafp implements zzafz {
    private final zzj zzb;
    private final long zzc;
    private long zzd;
    private int zzf;
    private int zzg;
    private byte[] zze = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
    private final byte[] zza = new byte[4096];

    static {
        zzal.zzb("media3.extractor");
    }

    public zzafp(zzj zzjVar, long j3, long j4) {
        this.zzb = zzjVar;
        this.zzd = j3;
        this.zzc = j4;
    }

    private final void zzp(int i3) {
        int i4 = this.zzf + i3;
        int length = this.zze.length;
        if (i4 > length) {
            String str = zzfl.zza;
            this.zze = Arrays.copyOf(this.zze, Math.max(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4, Math.min(length + length, i4 + 524288)));
        }
    }

    private final int zzq(int i3) {
        int iMin = Math.min(this.zzg, i3);
        zzs(iMin);
        return iMin;
    }

    private final int zzr(byte[] bArr, int i3, int i4) {
        int i5 = this.zzg;
        if (i5 == 0) {
            return 0;
        }
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.zze, 0, bArr, i3, iMin);
        zzs(iMin);
        return iMin;
    }

    private final void zzs(int i3) {
        int i4 = this.zzg - i3;
        this.zzg = i4;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i4 < bArr.length + (-524288) ? new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4] : bArr;
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        this.zze = bArr2;
    }

    private final int zzt(byte[] bArr, int i3, int i4, int i5, boolean z2) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iZza = this.zzb.zza(bArr, i3 + i5, i4 - i5);
        if (iZza != -1) {
            return i5 + iZza;
        }
        if (i5 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    private final void zzu(int i3) {
        if (i3 != -1) {
            this.zzd += (long) i3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws IOException {
        int iZzr = zzr(bArr, i3, i4);
        if (iZzr == 0) {
            iZzr = zzt(bArr, i3, i4, 0, true);
        }
        zzu(iZzr);
        return iZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zzb(byte[] bArr, int i3, int i4, boolean z2) throws IOException {
        int iZzr = zzr(bArr, i3, i4);
        while (iZzr < i4 && iZzr != -1) {
            iZzr = zzt(bArr, i3, i4, iZzr, z2);
        }
        zzu(iZzr);
        return iZzr != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzc(byte[] bArr, int i3, int i4) throws IOException {
        zzb(bArr, i3, i4, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final int zzd(int i3) throws IOException {
        int iZzq = zzq(1);
        if (iZzq == 0) {
            iZzq = zzt(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzu(iZzq);
        return iZzq;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zze(int i3, boolean z2) throws IOException {
        int iZzq = zzq(i3);
        while (iZzq < i3 && iZzq != -1) {
            iZzq = zzt(this.zza, -iZzq, Math.min(i3, iZzq + 4096), iZzq, z2);
        }
        zzu(iZzq);
        return iZzq != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzf(int i3) throws IOException {
        zze(i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final int zzg(byte[] bArr, int i3, int i4) throws IOException {
        zzafp zzafpVar;
        int iMin;
        zzp(i4);
        int i5 = this.zzg;
        int i6 = this.zzf;
        int i7 = i5 - i6;
        if (i7 == 0) {
            zzafpVar = this;
            iMin = zzafpVar.zzt(this.zze, i6, i4, 0, true);
            if (iMin == -1) {
                return -1;
            }
            zzafpVar.zzg += iMin;
        } else {
            zzafpVar = this;
            iMin = Math.min(i4, i7);
        }
        System.arraycopy(zzafpVar.zze, zzafpVar.zzf, bArr, i3, iMin);
        zzafpVar.zzf += iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final boolean zzh(byte[] bArr, int i3, int i4, boolean z2) throws IOException {
        if (!zzj(i4, z2)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i4, bArr, i3, i4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzi(byte[] bArr, int i3, int i4) throws IOException {
        zzh(bArr, i3, i4, false);
    }

    public final boolean zzj(int i3, boolean z2) throws IOException {
        zzp(i3);
        int iZzt = this.zzg - this.zzf;
        while (iZzt < i3) {
            int i4 = i3;
            boolean z3 = z2;
            iZzt = zzt(this.zze, this.zzf, i4, iZzt, z3);
            if (iZzt == -1) {
                return false;
            }
            this.zzg = this.zzf + iZzt;
            i3 = i4;
            z2 = z3;
        }
        this.zzf += i3;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzk(int i3) throws IOException {
        zzj(i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void zzl() {
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzm() {
        return this.zzd + ((long) this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzn() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzo() {
        return this.zzc;
    }
}
