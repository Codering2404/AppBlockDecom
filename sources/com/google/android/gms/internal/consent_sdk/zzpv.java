package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpv extends zzpe {
    private static final Logger zza = Logger.getLogger(zzpv.class.getName());
    private static final boolean zzb = zzsw.zzx();
    public static final /* synthetic */ int zzf = 0;
    Object zze;

    private zzpv() {
        throw null;
    }

    public static int zzA(zzrq zzrqVar) {
        int iZzn = zzrqVar.zzn();
        return zzC(iZzn) + iZzn;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzsy.zzb(str);
        } catch (zzsx unused) {
            length = str.getBytes(zzqs.zza).length;
        }
        return zzC(length) + length;
    }

    public static int zzC(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int zzD(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    final void zzE(String str, zzsx zzsxVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzsxVar);
        byte[] bytes = str.getBytes(zzqs.zza);
        try {
            int length = bytes.length;
            zzw(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzps(e3);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b3) throws IOException;

    public abstract void zzK(int i3, boolean z2) throws IOException;

    abstract void zzL(byte[] bArr, int i3, int i4) throws IOException;

    @Override // com.google.android.gms.internal.consent_sdk.zzpe
    public abstract void zza(byte[] bArr, int i3, int i4) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i3, zzpm zzpmVar) throws IOException;

    public abstract void zzi(zzpm zzpmVar) throws IOException;

    public abstract void zzj(int i3, int i4) throws IOException;

    public abstract void zzk(int i3) throws IOException;

    public abstract void zzl(int i3, long j3) throws IOException;

    public abstract void zzm(long j3) throws IOException;

    public abstract void zzn(int i3, int i4) throws IOException;

    public abstract void zzo(int i3) throws IOException;

    public abstract void zzp(zzrq zzrqVar) throws IOException;

    public abstract void zzq(int i3, zzrq zzrqVar) throws IOException;

    public abstract void zzr(int i3, zzpm zzpmVar) throws IOException;

    public abstract void zzs(int i3, String str) throws IOException;

    public abstract void zzt(String str) throws IOException;

    public abstract void zzu(int i3, int i4) throws IOException;

    public abstract void zzv(int i3, int i4) throws IOException;

    public abstract void zzw(int i3) throws IOException;

    public abstract void zzx(int i3, long j3) throws IOException;

    public abstract void zzy(long j3) throws IOException;

    /* synthetic */ zzpv(zzpu zzpuVar) {
    }
}
