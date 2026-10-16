package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzln extends zzkw {
    private static final Logger zzb = Logger.getLogger(zzln.class.getName());
    private static final boolean zzc = zzps.zzx();
    zzlo zza;

    private zzln() {
        throw null;
    }

    public static int zzA(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int zzB(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    @Deprecated
    static int zzw(int i3, zzoi zzoiVar, zzow zzowVar) {
        int iZzA = zzA(i3 << 3);
        return iZzA + iZzA + ((zzko) zzoiVar).zza(zzowVar);
    }

    public static int zzx(zzoi zzoiVar) {
        int iZzo = zzoiVar.zzo();
        return zzA(iZzo) + iZzo;
    }

    static int zzy(zzoi zzoiVar, zzow zzowVar) {
        int iZza = ((zzko) zzoiVar).zza(zzowVar);
        return zzA(iZza) + iZza;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzpv.zzc(str);
        } catch (zzpu unused) {
            length = str.getBytes(zznl.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzD(String str, zzpu zzpuVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzpuVar);
        byte[] bytes = str.getBytes(zznl.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(e3);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b3) throws IOException;

    public abstract void zzd(int i3, boolean z2) throws IOException;

    public abstract void zze(int i3, zzle zzleVar) throws IOException;

    public abstract void zzf(int i3, int i4) throws IOException;

    public abstract void zzg(int i3) throws IOException;

    public abstract void zzh(int i3, long j3) throws IOException;

    public abstract void zzi(long j3) throws IOException;

    public abstract void zzj(int i3, int i4) throws IOException;

    public abstract void zzk(int i3) throws IOException;

    public abstract void zzl(byte[] bArr, int i3, int i4) throws IOException;

    abstract void zzm(int i3, zzoi zzoiVar, zzow zzowVar) throws IOException;

    public abstract void zzn(int i3, zzoi zzoiVar) throws IOException;

    public abstract void zzo(int i3, zzle zzleVar) throws IOException;

    public abstract void zzp(int i3, String str) throws IOException;

    public abstract void zzr(int i3, int i4) throws IOException;

    public abstract void zzs(int i3, int i4) throws IOException;

    public abstract void zzt(int i3) throws IOException;

    public abstract void zzu(int i3, long j3) throws IOException;

    public abstract void zzv(long j3) throws IOException;

    /* synthetic */ zzln(zzlm zzlmVar) {
    }
}
