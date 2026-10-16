package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.facebook.stetho.common.Utf8Charset;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdrg {
    private final zzdwi zza;
    private final zzdux zzb;
    private final zzcuq zzc;
    private final zzdqb zzd;

    public zzdrg(zzdwi zzdwiVar, zzdux zzduxVar, zzcuq zzcuqVar, zzdqb zzdqbVar) {
        this.zza = zzdwiVar;
        this.zzb = zzduxVar;
        this.zzc = zzcuqVar;
        this.zzd = zzdqbVar;
    }

    public final View zza() throws zzclj {
        zzcku zzckuVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.N(), null, null);
        zzckuVarZza.zzE().setVisibility(8);
        zzckuVarZza.zzab("/sendMessageToSdk", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrf
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzb((zzcku) obj, map);
            }
        });
        zzckuVarZza.zzab("/adMuted", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdra
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzc((zzcku) obj, map);
            }
        });
        WeakReference weakReference = new WeakReference(zzckuVarZza);
        zzbpq zzbpqVar = new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrb
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, final Map map) {
                zzcku zzckuVar = (zzcku) obj;
                zzcms zzcmsVarZzP = zzckuVar.zzP();
                final zzdrg zzdrgVar = this.zza;
                zzcmsVarZzP.zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdre
                    @Override // com.google.android.gms.internal.ads.zzcmq
                    public final /* synthetic */ void zza(boolean z2, int i3, String str, String str2) {
                        zzdrgVar.zzf(map, z2, i3, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzckuVar.loadData(str, "text/html", Utf8Charset.NAME);
                } else {
                    zzckuVar.loadDataWithBaseURL(str2, str, "text/html", Utf8Charset.NAME, null);
                }
            }
        };
        zzdux zzduxVar = this.zzb;
        zzduxVar.zzh(weakReference, "/loadHtml", zzbpqVar);
        zzduxVar.zzh(new WeakReference(zzckuVarZza), "/showOverlay", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrc
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzd((zzcku) obj, map);
            }
        });
        zzduxVar.zzh(new WeakReference(zzckuVarZza), "/hideOverlay", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrd
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zze((zzcku) obj, map);
            }
        });
        return zzckuVarZza.zzE();
    }

    final /* synthetic */ void zzb(zzcku zzckuVar, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(zzcku zzckuVar, Map map) {
        this.zzd.zzt();
    }

    final /* synthetic */ void zzd(zzcku zzckuVar, Map map) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("Showing native ads overlay.");
        zzckuVar.zzE().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zze(zzcku zzckuVar, Map map) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("Hiding native ads overlay.");
        zzckuVar.zzE().setVisibility(8);
        this.zzc.zze(false);
    }

    final /* synthetic */ void zzf(Map map, boolean z2, int i3, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", map2);
    }
}
