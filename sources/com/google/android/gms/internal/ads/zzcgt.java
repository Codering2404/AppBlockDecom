package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcgt extends TextureView implements zzchq {
    protected final zzchh zza;
    protected final zzchr zzb;

    public zzcgt(Context context) {
        super(context);
        this.zza = new zzchh();
        this.zzb = new zzchr(context, this);
    }

    public abstract String zza();

    public abstract void zzb(zzcgs zzcgsVar);

    public abstract void zzc(String str);

    public abstract void zzd();

    public abstract void zze();

    public abstract void zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract void zzi(int i3);

    public abstract void zzj(float f3, float f4);

    public abstract int zzk();

    public abstract int zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract int zzp();

    public abstract void zzq();

    public Integer zzw() {
        return null;
    }

    public void zzx(String str, String[] strArr, Integer num) {
        zzc(str);
    }

    public void zzA(int i3) {
    }

    public void zzB(int i3) {
    }

    public void zzC(int i3) {
    }

    public void zzy(int i3) {
    }

    public void zzz(int i3) {
    }
}
