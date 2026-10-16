package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdro {
    private final zzdwi zza;
    private final zzdux zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdro(zzdwi zzdwiVar, zzdux zzduxVar) {
        this.zza = zzdwiVar;
        this.zzb = zzduxVar;
    }

    private static final int zzf(Context context, String str, int i3) {
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzay.a();
        return com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
    }

    public final View zza(final View view, final WindowManager windowManager) throws zzclj {
        zzcku zzckuVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.N(), null, null);
        zzckuVarZza.zzE().setVisibility(4);
        zzckuVarZza.zzE().setContentDescription("policy_validator");
        zzckuVarZza.zzab("/sendMessageToSdk", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrn
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzb((zzcku) obj, map);
            }
        });
        zzckuVarZza.zzab("/hideValidatorOverlay", new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdri
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzc(windowManager, view, (zzcku) obj, map);
            }
        });
        zzckuVarZza.zzab("/open", new zzbqd(null, null, null, null, null, null));
        WeakReference weakReference = new WeakReference(zzckuVarZza);
        zzbpq zzbpqVar = new zzbpq() { // from class: com.google.android.gms.internal.ads.zzdrj
            @Override // com.google.android.gms.internal.ads.zzbpq
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzd(view, windowManager, (zzcku) obj, map);
            }
        };
        zzdux zzduxVar = this.zzb;
        zzduxVar.zzh(weakReference, "/loadNativeAdPolicyViolations", zzbpqVar);
        zzduxVar.zzh(new WeakReference(zzckuVarZza), "/showValidatorOverlay", zzdrk.zza);
        return zzckuVarZza.zzE();
    }

    final /* synthetic */ void zzb(zzcku zzckuVar, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcku zzckuVar, Map map) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Hide native ad policy validator overlay.");
        zzckuVar.zzE().setVisibility(8);
        if (zzckuVar.zzE().getWindowToken() != null) {
            windowManager.removeView(zzckuVar.zzE());
        }
        zzckuVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzc);
    }

    final /* synthetic */ void zzd(final View view, final WindowManager windowManager, zzcku zzckuVar, final Map map) {
        final zzcku zzckuVar2;
        zzckuVar.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdrm
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z2, int i3, String str, String str2) {
                this.zza.zze(map, z2, i3, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjq)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjr)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzckuVar.zzaf(zzcne.zzc(iZzf, iZzf2));
        try {
            zzckuVar.zzD().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjs)).booleanValue());
            zzckuVar.zzD().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjt)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsK = com.google.android.gms.ads.internal.util.zzbs.k();
        layoutParamsK.x = iZzf3;
        layoutParamsK.y = iZzf4;
        windowManager.updateViewLayout(zzckuVar.zzE(), layoutParamsK);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i3 = ((AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - iZzf4;
            zzckuVar2 = zzckuVar;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdrl
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final /* synthetic */ void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcku zzckuVar3 = zzckuVar2;
                        if (zzckuVar3.zzE().getWindowToken() == null) {
                            return;
                        }
                        int i4 = i3;
                        WindowManager.LayoutParams layoutParams = layoutParamsK;
                        String str2 = str;
                        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i4;
                        } else {
                            layoutParams.y = rect2.top - i4;
                        }
                        windowManager.updateViewLayout(zzckuVar3.zzE(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        } else {
            zzckuVar2 = zzckuVar;
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzckuVar2.loadUrl(str2);
    }

    final /* synthetic */ void zze(Map map, boolean z2, int i3, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", map2);
    }
}
