package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfc extends zzem {
    public static final /* synthetic */ int zzb = 0;
    private static final boolean zzc = zzii.zzx();
    Object zza;

    private zzfc() {
        throw null;
    }

    public static int zzx(zzhb zzhbVar) {
        int iZzn = zzhbVar.zzn();
        return zzy(iZzn) + iZzn;
    }

    public static int zzy(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int zzz(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b3) throws IOException;

    public abstract void zzd(int i3, boolean z2) throws IOException;

    abstract void zze(byte[] bArr, int i3, int i4) throws IOException;

    public abstract void zzf(int i3, zzev zzevVar) throws IOException;

    public abstract void zzg(zzev zzevVar) throws IOException;

    public abstract void zzh(int i3, int i4) throws IOException;

    public abstract void zzi(int i3) throws IOException;

    public abstract void zzj(int i3, long j3) throws IOException;

    public abstract void zzk(long j3) throws IOException;

    public abstract void zzl(int i3, int i4) throws IOException;

    public abstract void zzm(int i3) throws IOException;

    public abstract void zzn(zzhb zzhbVar) throws IOException;

    public abstract void zzo(int i3, zzhb zzhbVar) throws IOException;

    public abstract void zzp(int i3, zzev zzevVar) throws IOException;

    public abstract void zzq(int i3, String str) throws IOException;

    public abstract void zzr(String str) throws IOException;

    public abstract void zzs(int i3, int i4) throws IOException;

    public abstract void zzt(int i3, int i4) throws IOException;

    public abstract void zzu(int i3) throws IOException;

    public abstract void zzv(int i3, long j3) throws IOException;

    public abstract void zzw(long j3) throws IOException;

    /* synthetic */ zzfc(zzfb zzfbVar) {
    }
}
