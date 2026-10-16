package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzche {
    private static final AtomicInteger zza = new AtomicInteger(0);
    private static final AtomicInteger zzb = new AtomicInteger(0);

    public static int zzP() {
        return zza.get();
    }

    public static int zzQ() {
        return zzb.get();
    }

    protected static AtomicInteger zzf() {
        return zza;
    }

    protected static AtomicInteger zzi() {
        return zzb;
    }

    public abstract void zzA(int i3);

    public abstract boolean zzB();

    public abstract int zzC();

    public abstract long zzD();

    public abstract void zzE(boolean z2);

    public abstract void zzF(int i3);

    public abstract void zzG(int i3);

    public abstract long zzH();

    public abstract long zzI();

    public abstract long zzJ();

    public abstract long zzK();

    public abstract int zzL();

    public abstract void zzM(boolean z2);

    public abstract long zzN();

    public abstract long zzO();

    public abstract Integer zzj();

    public abstract void zzn(Integer num);

    public abstract void zzq(Uri[] uriArr, String str);

    public abstract void zzr(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z2);

    public abstract void zzs(zzchd zzchdVar);

    public abstract void zzt();

    public abstract void zzu(Surface surface, boolean z2) throws IOException;

    public abstract void zzv(float f3, boolean z2) throws IOException;

    public abstract void zzw();

    public abstract void zzx(long j3);

    public abstract void zzy(int i3);

    public abstract void zzz(int i3);
}
