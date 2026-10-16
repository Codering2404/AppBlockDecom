package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzli {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzlj zzc;

    private zzli() {
    }

    public static int zzF(int i3) {
        return (i3 >>> 1) ^ (-(i3 & 1));
    }

    public static long zzG(long j3) {
        return (j3 >>> 1) ^ (-(1 & j3));
    }

    static zzli zzH(byte[] bArr, int i3, int i4, boolean z2) {
        zzlf zzlfVar = new zzlf(bArr, 0, 0, false, null);
        try {
            zzlfVar.zze(0);
            return zzlfVar;
        } catch (zznn e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public abstract void zzA(int i3);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i3) throws IOException;

    public final void zzI() throws IOException {
        int iZzm;
        do {
            iZzm = zzm();
            if (iZzm == 0) {
                return;
            }
            int i3 = this.zza;
            if (i3 >= this.zzb) {
                throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.zza = i3 + 1;
            this.zza--;
        } while (zzE(iZzm));
    }

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i3) throws zznn;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzle zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i3) throws zznn;

    /* synthetic */ zzli(zzlh zzlhVar) {
    }
}
