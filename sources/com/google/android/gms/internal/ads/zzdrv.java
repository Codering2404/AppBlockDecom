package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzdrv implements zzdqb, zzdht {
    private final zzbvr zza;
    private final zzddj zzb;
    private final zzdfk zzc;
    private final zzdcp zzd;
    private final zzdkw zze;
    private final Context zzf;
    private final zzfkf zzg;
    private final VersionInfoParcel zzh;
    private final zzfky zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = true;
    private final zzbvn zzm;
    private final zzbvo zzn;

    public zzdrv(zzbvn zzbvnVar, zzbvo zzbvoVar, zzbvr zzbvrVar, zzddj zzddjVar, zzdfk zzdfkVar, zzdcp zzdcpVar, zzdkw zzdkwVar, Context context, zzfkf zzfkfVar, VersionInfoParcel versionInfoParcel, zzfky zzfkyVar) {
        this.zzm = zzbvnVar;
        this.zzn = zzbvoVar;
        this.zza = zzbvrVar;
        this.zzb = zzddjVar;
        this.zzc = zzdfkVar;
        this.zzd = zzdcpVar;
        this.zze = zzdkwVar;
        this.zzf = context;
        this.zzg = zzfkfVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzfkyVar;
    }

    private static final HashMap zzB(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    private final void zzi(View view) {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null && !zzbvrVar.zzu()) {
                zzbvrVar.zzw(ObjectWrapper.i5(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmh)).booleanValue()) {
                    this.zze.zzdu();
                    return;
                }
                return;
            }
            zzbvn zzbvnVar = this.zzm;
            if (zzbvnVar != null && !zzbvnVar.zzq()) {
                zzbvnVar.zzn(ObjectWrapper.i5(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmh)).booleanValue()) {
                    this.zze.zzdu();
                    return;
                }
                return;
            }
            zzbvo zzbvoVar = this.zzn;
            if (zzbvoVar == null || zzbvoVar.zzo()) {
                return;
            }
            zzbvoVar.zzl(ObjectWrapper.i5(view));
            this.zzd.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmh)).booleanValue()) {
                this.zze.zzdu();
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call handleClick", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzA() {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null) {
                zzbvrVar.zzC();
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call destroy", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc A[Catch: RemoteException -> 0x002b, JSONException -> 0x0047, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0047, blocks: (B:49:0x00b4, B:51:0x00cc), top: B:70:0x00b4 }] */
    @Override // com.google.android.gms.internal.ads.zzdqb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(android.view.View r10, java.util.Map r11, java.util.Map r12, android.view.View.OnTouchListener r13, android.view.View.OnClickListener r14) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrv.zza(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzb(View view, Map map) {
        try {
            IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(view);
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar != null) {
                zzbvrVar.zzy(iObjectWrapperI5);
                return;
            }
            zzbvn zzbvnVar = this.zzm;
            if (zzbvnVar != null) {
                zzbvnVar.zzs(iObjectWrapperI5);
                return;
            }
            zzbvo zzbvoVar = this.zzn;
            if (zzbvoVar != null) {
                zzbvoVar.zzq(iObjectWrapperI5);
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call untrackView", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzc(View view, View view2, Map map, Map map2, boolean z2, ImageView.ScaleType scaleType) {
        if (this.zzk && this.zzg.zzL) {
            return;
        }
        zzi(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdH() {
        try {
            zzbvr zzbvrVar = this.zza;
            if (zzbvrVar == null || !zzbvrVar.zzt()) {
                return;
            }
            zzfkf zzfkfVar = this.zzg;
            if (zzfkfVar.zze != 4 && !zzfkfVar.zzaD) {
                return;
            }
            zzbvrVar.zzv();
            this.zzb.zza();
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to report impression from an adapter", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzf(View view, View view2, Map map, Map map2, boolean z2, ImageView.ScaleType scaleType, int i3) {
        if (!this.zzk) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzg.zzL) {
            zzi(view2);
        } else {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzg() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzh() {
        return this.zzg.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final JSONObject zzl(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final JSONObject zzm(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzr(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzs(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzt() {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final int zzu() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzv() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzw(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzj) {
                this.zzj = com.google.android.gms.ads.internal.zzt.s().g(this.zzf, this.zzh.f70149a, this.zzg.zzC.toString(), this.zzi.zzg);
            }
            if (this.zzl) {
                zzbvr zzbvrVar = this.zza;
                if (zzbvrVar == null) {
                    zzbvn zzbvnVar = this.zzm;
                    if (zzbvnVar != null && !zzbvnVar.zzp()) {
                        zzbvnVar.zzm();
                        this.zzb.zza();
                        return;
                    }
                    zzbvo zzbvoVar = this.zzn;
                    if (zzbvoVar == null || zzbvoVar.zzn()) {
                        return;
                    }
                    zzbvoVar.zzk();
                    this.zzb.zza();
                    return;
                }
                zzfkf zzfkfVar = this.zzg;
                if (zzfkfVar.zzaD) {
                    if (zzbvrVar.zzt()) {
                        return;
                    }
                    zzbvrVar.zzv();
                    this.zzb.zza();
                    return;
                }
                if (zzbvrVar.zzt() && zzfkfVar.zze == 4) {
                    this.zzc.zza();
                } else {
                    zzbvrVar.zzv();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call recordImpression", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final boolean zzz(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdht
    public final void zzdI() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zze(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzk(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzo(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzp(zzbns zzbnsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzj(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final void zzx(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
    }
}
