package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.zzbhv;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdnt implements zzdcr, zzdkd {
    private final zzcdw zza;
    private final Context zzb;
    private final zzcdz zzc;
    private final View zzd;
    private String zze;
    private final zzbhv.zza.EnumC0141zza zzf;
    private final zzfkf zzg;

    public zzdnt(zzcdw zzcdwVar, Context context, zzcdz zzcdzVar, View view, zzbhv.zza.EnumC0141zza enumC0141zza, zzfkf zzfkfVar) {
        this.zza = zzcdwVar;
        this.zzb = context;
        this.zzc = zzcdzVar;
        this.zzd = view;
        this.zzf = enumC0141zza;
        this.zzg = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    @ParametersAreNonnullByDefault
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
        zzcdz zzcdzVar = this.zzc;
        Context context = this.zzb;
        if (zzcdzVar.zza(context) && this.zzg.zzaG) {
            try {
                zzcdzVar.zzo(context, zzcdzVar.zzj(context), this.zza.zzb(), zzcbpVar.zzb(), zzcbpVar.zzc());
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Remote Exception to get reward item.", e3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        if (this.zzg.zzaG) {
            this.zza.zza(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        if (this.zzg.zzaG) {
            View view = this.zzd;
            if (view != null && this.zze != null) {
                this.zzc.zzg(view.getContext(), this.zze);
            }
            this.zza.zza(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzh() {
        zzbhv.zza.EnumC0141zza enumC0141zza = this.zzf;
        if (enumC0141zza != zzbhv.zza.EnumC0141zza.APP_OPEN && this.zzg.zzaG) {
            String strZzf = this.zzc.zzf(this.zzb);
            this.zze = strZzf;
            this.zze = String.valueOf(strZzf).concat(enumC0141zza == zzbhv.zza.EnumC0141zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdkd
    public final void zzg() {
    }
}
