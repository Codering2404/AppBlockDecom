package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzckj extends zzcgt {
    private final zzcho zzc;
    private zzckk zzd;
    private Uri zze;
    private zzcgs zzf;
    private boolean zzg;
    private int zzh;

    public zzckj(Context context, zzcho zzchoVar) {
        super(context);
        this.zzh = 1;
        this.zzg = false;
        this.zzc = zzchoVar;
        zzchoVar.zza(this);
    }

    @EnsuresNonNullIf
    private final boolean zzu() {
        int i3 = this.zzh;
        return (i3 == 1 || i3 == 2 || this.zzd == null) ? false : true;
    }

    private final void zzv(int i3) {
        if (i3 == 4) {
            this.zzc.zze();
            this.zzb.zzd();
        } else if (this.zzh == 4) {
            this.zzc.zzf();
            this.zzb.zze();
        }
        this.zzh = i3;
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzckj.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final String zza() {
        return "ImmersivePlayer";
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzb(zzcgs zzcgsVar) {
        this.zzf = zzcgsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzc(String str) {
        if (str != null) {
            Uri uri = Uri.parse(str);
            this.zze = uri;
            this.zzd = new zzckk(uri.toString());
            zzv(3);
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcki
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzd() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView stop");
        zzckk zzckkVar = this.zzd;
        if (zzckkVar != null) {
            zzckkVar.zzd();
            this.zzd = null;
            zzv(1);
        }
        this.zzc.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zze() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView play");
        if (zzu()) {
            this.zzd.zzb();
            zzv(4);
            this.zza.zza();
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzf() {
        com.google.android.gms.ads.internal.util.zze.k("AdImmersivePlayerView pause");
        if (zzu() && this.zzd.zza()) {
            this.zzd.zzc();
            zzv(5);
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzg() {
        return zzu() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzh() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzi(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 27);
        sb.append("AdImmersivePlayerView seek ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzk() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzl() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzm() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzn() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzo() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzp() {
        return zzu() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt, com.google.android.gms.internal.ads.zzchq
    public final void zzq() {
        if (this.zzd != null) {
            this.zzb.zzc();
        }
    }

    final /* synthetic */ void zzr() {
        zzcgs zzcgsVar = this.zzf;
        if (zzcgsVar != null) {
            zzcgsVar.zzb();
        }
    }

    final /* synthetic */ void zzs() {
        zzcgs zzcgsVar = this.zzf;
        if (zzcgsVar != null) {
            if (!this.zzg) {
                zzcgsVar.zzk();
                this.zzg = true;
            }
            this.zzf.zzc();
        }
    }

    final /* synthetic */ void zzt() {
        zzcgs zzcgsVar = this.zzf;
        if (zzcgsVar != null) {
            zzcgsVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzj(float f3, float f4) {
    }
}
