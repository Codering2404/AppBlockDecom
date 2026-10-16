package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdug extends zzbmu {
    private final Context zza;
    private final zzdpt zzb;
    private zzdqs zzc;
    private zzdpo zzd;

    public zzdug(Context context, zzdpt zzdptVar, zzdqs zzdqsVar, zzdpo zzdpoVar) {
        this.zza = context;
        this.zzb = zzdptVar;
        this.zzc = zzdqsVar;
        this.zzd = zzdpoVar;
    }

    final /* synthetic */ zzdpo zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final String zze(String str) {
        return (String) this.zzb.zzad().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final zzbme zzf(String str) {
        return (zzbme) this.zzb.zzaa().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final List zzg() {
        try {
            zzdpt zzdptVar = this.zzb;
            SimpleArrayMap simpleArrayMapZzaa = zzdptVar.zzaa();
            SimpleArrayMap simpleArrayMapZzad = zzdptVar.zzad();
            String[] strArr = new String[simpleArrayMapZzaa.size() + simpleArrayMapZzad.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < simpleArrayMapZzaa.size(); i4++) {
                strArr[i3] = (String) simpleArrayMapZzaa.f(i4);
                i3++;
            }
            for (int i5 = 0; i5 < simpleArrayMapZzad.size(); i5++) {
                strArr[i3] = (String) simpleArrayMapZzad.f(i5);
                i3++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final String zzh() {
        return this.zzb.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzi(String str) {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zza(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzj() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final com.google.android.gms.ads.internal.client.zzea zzk() {
        return this.zzb.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzl() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null) {
            zzdpoVar.zzd();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final IObjectWrapper zzm() {
        return ObjectWrapper.i5(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzn(IObjectWrapper iObjectWrapper) {
        zzdqs zzdqsVar;
        Object objH5 = ObjectWrapper.h5(iObjectWrapper);
        if (!(objH5 instanceof ViewGroup) || (zzdqsVar = this.zzc) == null || !zzdqsVar.zzd((ViewGroup) objH5)) {
            return false;
        }
        this.zzb.zzT().zzaq(new zzduf(this, "_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzo() {
        zzdpo zzdpoVar = this.zzd;
        if (zzdpoVar != null && !zzdpoVar.zzM()) {
            return false;
        }
        zzdpt zzdptVar = this.zzb;
        return zzdptVar.zzW() != null && zzdptVar.zzT() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzp() {
        zzdpt zzdptVar = this.zzb;
        zzeln zzelnVarZzZ = zzdptVar.zzZ();
        if (zzelnVarZzZ == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Trying to start OMID session before creation.");
            return false;
        }
        com.google.android.gms.ads.internal.zzt.y().zze(zzelnVarZzZ.zza());
        if (zzdptVar.zzW() == null) {
            return true;
        }
        zzdptVar.zzW().zze("onSdkLoaded", new ArrayMap());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzdpo zzdpoVar;
        Object objH5 = ObjectWrapper.h5(iObjectWrapper);
        if (!(objH5 instanceof View) || this.zzb.zzZ() == null || (zzdpoVar = this.zzd) == null) {
            return;
        }
        zzdpoVar.zzN((View) objH5);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final void zzr() {
        try {
            String strZzac = this.zzb.zzac();
            if (Objects.equals(strZzac, "Google")) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(strZzac)) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdpo zzdpoVar = this.zzd;
                if (zzdpoVar != null) {
                    zzdpoVar.zzL(strZzac, false);
                }
            }
        } catch (NullPointerException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final zzbmb zzs() throws RemoteException {
        try {
            return this.zzd.zzP().zza();
        } catch (NullPointerException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        zzdqs zzdqsVar;
        Object objH5 = ObjectWrapper.h5(iObjectWrapper);
        if (!(objH5 instanceof ViewGroup) || (zzdqsVar = this.zzc) == null || !zzdqsVar.zze((ViewGroup) objH5)) {
            return false;
        }
        this.zzb.zzU().zzaq(new zzduf(this, "_videoMediaView"));
        return true;
    }
}
