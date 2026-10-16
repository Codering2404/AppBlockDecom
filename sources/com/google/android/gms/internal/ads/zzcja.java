package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public abstract class zzcja implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzcja(zzchn zzchnVar) {
        Context context = zzchnVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzt.g().P(context, zzchnVar.zzs().f70149a);
        this.zzc = new WeakReference(zzchnVar);
    }

    public abstract boolean zze(String str);

    public boolean zzf(String str, String[] strArr) {
        return zze(str);
    }

    public boolean zzg(String str, String[] strArr, zzcis zzcisVar) {
        return zze(str);
    }

    public abstract void zzl();

    public final void zzm(String str, String str2, long j3, long j4, boolean z2, long j5, long j6, long j7, int i3, int i4) {
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzciv(this, str, str2, j3, j4, j5, j6, j7, z2, i3, i4));
    }

    public final void zzn(String str, String str2, int i3, int i4, long j3, long j4, boolean z2, int i5, int i6) {
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzciw(this, str, str2, i3, i4, j3, j4, z2, i5, i6));
    }

    protected final void zzo(String str, String str2, int i3) {
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzcix(this, str, str2, i3));
    }

    public final void zzp(String str, String str2, long j3) {
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzciy(this, str, str2, j3));
    }

    public final void zzq(String str, String str2, String str3, String str4) {
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzciz(this, str, str2, str3, str4));
    }

    final /* synthetic */ void zzw(String str, Map map) {
        zzchn zzchnVar = (zzchn) this.zzc.get();
        if (zzchnVar != null) {
            zzchnVar.zze("onPrecacheEvent", map);
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    protected void zzh(int i3) {
    }

    protected void zzi(int i3) {
    }

    protected void zzj(int i3) {
    }

    protected void zzk(int i3) {
    }
}
