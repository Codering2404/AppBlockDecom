package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzlm extends zzkz {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzlm.class.getName());
    private static final boolean zzd = zzop.zza();
    zzln zza;

    private zzlm() {
        throw null;
    }

    public static int zzA(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzos.zzb(str);
        } catch (zzor unused) {
            length = str.getBytes(zzmp.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzC(zznm zznmVar) {
        int iZzcn = zznmVar.zzcn();
        return zzz(iZzcn) + iZzcn;
    }

    static int zzD(zznm zznmVar, zznx zznxVar) {
        int iZzcd = ((zzks) zznmVar).zzcd(zznxVar);
        return zzz(iZzcd) + iZzcd;
    }

    @Deprecated
    static int zzG(int i3, zznm zznmVar, zznx zznxVar) {
        int iZzz = zzz(i3 << 3);
        return iZzz + iZzz + ((zzks) zznmVar).zzcd(zznxVar);
    }

    public static int zzz(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzF(String str, zzor zzorVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzorVar);
        byte[] bytes = str.getBytes(zzmp.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(e3);
        }
    }

    public abstract void zza(int i3, int i4) throws IOException;

    public abstract void zzb(int i3, int i4) throws IOException;

    public abstract void zzc(int i3, int i4) throws IOException;

    public abstract void zzd(int i3, int i4) throws IOException;

    public abstract void zze(int i3, long j3) throws IOException;

    public abstract void zzf(int i3, long j3) throws IOException;

    public abstract void zzg(int i3, boolean z2) throws IOException;

    public abstract void zzh(int i3, String str) throws IOException;

    public abstract void zzi(int i3, zzlh zzlhVar) throws IOException;

    public abstract void zzj(zzlh zzlhVar) throws IOException;

    abstract void zzk(byte[] bArr, int i3, int i4) throws IOException;

    abstract void zzl(int i3, zznm zznmVar, zznx zznxVar) throws IOException;

    public abstract void zzm(int i3, zznm zznmVar) throws IOException;

    public abstract void zzn(int i3, zzlh zzlhVar) throws IOException;

    public abstract void zzo(zznm zznmVar) throws IOException;

    public abstract void zzp(byte b3) throws IOException;

    public abstract void zzq(int i3) throws IOException;

    public abstract void zzr(int i3) throws IOException;

    public abstract void zzs(int i3) throws IOException;

    public abstract void zzt(long j3) throws IOException;

    public abstract void zzu(long j3) throws IOException;

    public abstract void zzw(byte[] bArr, int i3, int i4) throws IOException;

    public abstract void zzx(String str) throws IOException;

    public abstract int zzy();

    /* synthetic */ zzlm(byte[] bArr) {
    }
}
