package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzuq extends zztt {
    private static final Logger zza = Logger.getLogger(zzuq.class.getName());
    private static final boolean zzb = zzaau.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzur zze;

    private zzuq() {
    }

    public static int zzA(zzzg zzzgVar) {
        int iZzX = zzzgVar.zzX();
        return zzD(iZzX) + iZzX;
    }

    static int zzB(zzzg zzzgVar, zzzt zzztVar) {
        int iZzQ = ((zztl) zzzgVar).zzQ(zzztVar);
        return zzD(iZzQ) + iZzQ;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzaaz.zzc(str);
        } catch (zzaay unused) {
            length = str.getBytes(zzye.zzb).length;
        }
        return zzD(length) + length;
    }

    public static int zzD(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        return (i3 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzE(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            j3 >>>= 28;
            i3 = 6;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            j3 >>>= 14;
            i3 += 2;
        }
        return (j3 & (-16384)) != 0 ? i3 + 1 : i3;
    }

    @Deprecated
    static int zzy(int i3, zzzg zzzgVar, zzzt zzztVar) {
        int iZzQ = ((zztl) zzzgVar).zzQ(zzztVar);
        int iZzD = zzD(i3 << 3);
        return iZzD + iZzD + iZzQ;
    }

    public static int zzz(int i3) {
        if (i3 >= 0) {
            return zzD(i3);
        }
        return 10;
    }

    final void zzF(String str, zzaay zzaayVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaayVar);
        byte[] bytes = str.getBytes(zzye.zzb);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzun(e3);
        }
    }

    public abstract void zzJ() throws IOException;

    public abstract void zzK(byte b3) throws IOException;

    public abstract void zzL(int i3, boolean z2) throws IOException;

    public abstract void zzM(int i3, zzud zzudVar) throws IOException;

    @Override // com.google.android.gms.internal.gtm.zztt
    public abstract void zza(byte[] bArr, int i3, int i4) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i3, int i4) throws IOException;

    public abstract void zzi(int i3) throws IOException;

    public abstract void zzj(int i3, long j3) throws IOException;

    public abstract void zzk(long j3) throws IOException;

    public abstract void zzl(int i3, int i4) throws IOException;

    public abstract void zzm(int i3) throws IOException;

    abstract void zzn(int i3, zzzg zzzgVar, zzzt zzztVar) throws IOException;

    public abstract void zzo(int i3, zzzg zzzgVar) throws IOException;

    public abstract void zzp(int i3, zzud zzudVar) throws IOException;

    public abstract void zzq(int i3, String str) throws IOException;

    public abstract void zzs(int i3, int i4) throws IOException;

    public abstract void zzt(int i3, int i4) throws IOException;

    public abstract void zzu(int i3) throws IOException;

    public abstract void zzv(int i3, long j3) throws IOException;

    public abstract void zzw(long j3) throws IOException;

    /* synthetic */ zzuq(zzup zzupVar) {
    }
}
