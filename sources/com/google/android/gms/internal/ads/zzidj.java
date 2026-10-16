package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzidj extends zzicr {
    public static final /* synthetic */ int zzb = 0;
    private static final boolean zzc = zziha.zza();
    Object zza;

    private zzidj() {
        throw null;
    }

    static int zzE(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
    }

    public static int zzF(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int zzG(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public static int zzH(zzifp zzifpVar) {
        int iZzbr = zzifpVar.zzbr();
        return zzF(iZzbr) + iZzbr;
    }

    public final void zzI() {
        if (zzy() > 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        if (zzy() < 0) {
            throw new IllegalStateException("Wrote more data than expected.");
        }
    }

    public abstract void zzb(int i3, int i4) throws IOException;

    public abstract void zzc(int i3, int i4) throws IOException;

    public abstract void zzd(int i3, int i4) throws IOException;

    public abstract void zze(int i3, int i4) throws IOException;

    public abstract void zzf(int i3, long j3) throws IOException;

    public abstract void zzg(int i3, long j3) throws IOException;

    public abstract void zzh(int i3, boolean z2) throws IOException;

    public abstract void zzi(int i3, String str) throws IOException;

    public abstract void zzj(int i3, zzida zzidaVar) throws IOException;

    public abstract void zzk(zzida zzidaVar) throws IOException;

    abstract void zzl(byte[] bArr, int i3, int i4) throws IOException;

    public abstract void zzm(int i3, zzifp zzifpVar) throws IOException;

    public abstract void zzn(int i3, zzida zzidaVar) throws IOException;

    public abstract void zzo(zzifp zzifpVar) throws IOException;

    public abstract void zzp(byte b3) throws IOException;

    public abstract void zzq(int i3) throws IOException;

    public abstract void zzr(int i3) throws IOException;

    public abstract void zzs(int i3) throws IOException;

    public abstract void zzt(long j3) throws IOException;

    public abstract void zzu(long j3) throws IOException;

    public abstract void zzw(String str) throws IOException;

    public abstract void zzx() throws IOException;

    public abstract int zzy();

    /* synthetic */ zzidj(byte[] bArr) {
    }
}
