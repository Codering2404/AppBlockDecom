package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdnp implements zzdef, com.google.android.gms.ads.internal.overlay.zzr, zzddl {
    zzeln zza;
    private final Context zzb;
    private final zzcku zzc;
    private final zzfkf zzd;
    private final VersionInfoParcel zze;
    private final zzell zzf;

    public zzdnp(Context context, zzcku zzckuVar, zzfkf zzfkfVar, VersionInfoParcel versionInfoParcel, zzell zzellVar) {
        this.zzb = context;
        this.zzc = zzckuVar;
        this.zzd = zzfkfVar;
        this.zze = versionInfoParcel;
        this.zzf = zzellVar;
    }

    private final boolean zzl() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgn)).booleanValue() && this.zzf.zzb();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdU(int i3) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzcku zzckuVar;
        if (zzl()) {
            this.zzf.zzd();
        } else {
            if (this.zza == null || (zzckuVar = this.zzc) == null) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgq)).booleanValue()) {
                zzckuVar.zze("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        zzcku zzckuVar;
        zzelk zzelkVar;
        zzelj zzeljVar;
        zzfkf zzfkfVar = this.zzd;
        if (!zzfkfVar.zzT || (zzckuVar = this.zzc) == null) {
            return;
        }
        if (com.google.android.gms.ads.internal.zzt.y().zza(this.zzb)) {
            if (zzl()) {
                this.zzf.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            int i3 = versionInfoParcel.f70150b;
            int i4 = versionInfoParcel.f70151c;
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(i4).length());
            sb.append(i3);
            sb.append(".");
            sb.append(i4);
            String string = sb.toString();
            zzflb zzflbVar = zzfkfVar.zzV;
            String strZza = zzflbVar.zza();
            if (zzflbVar.zzc() == 1) {
                zzeljVar = zzelj.VIDEO;
                zzelkVar = zzelk.DEFINED_BY_JAVASCRIPT;
            } else {
                zzelkVar = zzfkfVar.zzY == 2 ? zzelk.UNSPECIFIED : zzelk.BEGIN_TO_RENDER;
                zzeljVar = zzelj.HTML_DISPLAY;
            }
            zzeln zzelnVarZzc = com.google.android.gms.ads.internal.zzt.y().zzc(string, zzckuVar.zzD(), "", "javascript", strZza, zzelkVar, zzeljVar, zzfkfVar.zzal);
            this.zza = zzelnVarZzc;
            if (zzelnVarZzc != null) {
                zzfuk zzfukVarZza = zzelnVarZzc.zza();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgm)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.y().zzh(zzfukVarZza, zzckuVar.zzD());
                    Iterator it = zzckuVar.zzF().iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.zzt.y().zzg(zzfukVarZza, (View) it.next());
                    }
                } else {
                    com.google.android.gms.ads.internal.zzt.y().zzh(zzfukVarZza, zzckuVar.zzE());
                }
                zzckuVar.zzak(this.zza);
                com.google.android.gms.ads.internal.zzt.y().zze(zzfukVarZza);
                zzckuVar.zze("onSdkLoaded", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        zzcku zzckuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgq)).booleanValue() || (zzckuVar = this.zzc) == null) {
            return;
        }
        if (this.zza != null || zzl()) {
            if (this.zza != null) {
                zzckuVar.zze("onSdkImpression", new ArrayMap());
            } else {
                this.zzf.zzd();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
    }
}
