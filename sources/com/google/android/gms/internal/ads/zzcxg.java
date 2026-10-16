package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcxg implements zzdef, zzddl {
    private final Context zza;
    private final zzcku zzb;
    private final zzfkf zzc;
    private final VersionInfoParcel zzd;
    private zzeln zze;
    private boolean zzf;
    private final zzell zzg;

    public zzcxg(Context context, zzcku zzckuVar, zzfkf zzfkfVar, VersionInfoParcel versionInfoParcel, zzell zzellVar) {
        this.zza = context;
        this.zzb = zzckuVar;
        this.zzc = zzfkfVar;
        this.zzd = versionInfoParcel;
        this.zzg = zzellVar;
    }

    private final synchronized void zza() {
        zzcku zzckuVar;
        zzelk zzelkVar;
        zzelj zzeljVar;
        try {
            zzfkf zzfkfVar = this.zzc;
            if (zzfkfVar.zzT && (zzckuVar = this.zzb) != null) {
                if (com.google.android.gms.ads.internal.zzt.y().zza(this.zza)) {
                    VersionInfoParcel versionInfoParcel = this.zzd;
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
                        int i5 = zzfkfVar.zze;
                        zzelj zzeljVar2 = zzelj.HTML_DISPLAY;
                        zzelkVar = i5 == 1 ? zzelk.ONE_PIXEL : zzelk.BEGIN_TO_RENDER;
                        zzeljVar = zzeljVar2;
                    }
                    zzeln zzelnVarZzc = com.google.android.gms.ads.internal.zzt.y().zzc(string, zzckuVar.zzD(), "", "javascript", strZza, zzelkVar, zzeljVar, zzfkfVar.zzal);
                    this.zze = zzelnVarZzc;
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
                        zzckuVar.zzak(this.zze);
                        com.google.android.gms.ads.internal.zzt.y().zze(zzfukVarZza);
                        this.zzf = true;
                        zzckuVar.zze("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        } finally {
        }
    }

    private final boolean zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgn)).booleanValue() && this.zzg.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final synchronized void zzdr() {
        zzcku zzckuVar;
        if (zzb()) {
            this.zzg.zzd();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzckuVar = this.zzb) == null) {
            return;
        }
        zzckuVar.zze("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final synchronized void zzg() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}
