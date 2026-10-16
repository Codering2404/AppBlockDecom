package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzaj;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcem;
import com.google.android.gms.internal.ads.zzcnj;
import com.google.android.gms.internal.ads.zzdqm;
import com.google.android.gms.internal.ads.zzdqo;
import com.google.android.gms.internal.ads.zzebc;
import com.google.android.gms.internal.ads.zzesd;
import com.google.android.gms.internal.ads.zzffg;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfjy;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ClientApi extends zzcn {
    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcbs C3(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzfjy zzfjyVarZzq = zzcnj.zza(context, zzbvcVar, i3).zzq();
        zzfjyVarZzq.zzc(context);
        return zzfjyVarZzq.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzdt E(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) {
        return zzcnj.zza((Context) ObjectWrapper.h5(iObjectWrapper), zzbvcVar, i3).zzC();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcci J4(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzfjy zzfjyVarZzq = zzcnj.zza(context, zzbvcVar, i3).zzq();
        zzfjyVarZzq.zzc(context);
        zzfjyVarZzq.zzb(str);
        return zzfjyVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbqt L1(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3, zzbqq zzbqqVar) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzebc zzebcVarZzA = zzcnj.zza(context, zzbvcVar, i3).zzA();
        zzebcVarZzA.zzc(context);
        zzebcVarZzA.zzb(zzbqqVar);
        return zzebcVarZzA.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu M3(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzfik zzfikVarZzn = zzcnj.zza(context, zzbvcVar, i3).zzn();
        zzfikVarZzn.zzd(context);
        zzfikVarZzn.zzb(zzrVar);
        zzfikVarZzn.zzc(str);
        return zzfikVarZzn.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu O1(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i3) {
        return new zzs((Context) ObjectWrapper.h5(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i3, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcem P0(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) {
        return zzcnj.zza((Context) ObjectWrapper.h5(iObjectWrapper), zzbvcVar, i3).zzs();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzch Q2(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) {
        return zzcnj.zza((Context) ObjectWrapper.h5(iObjectWrapper), zzbvcVar, i3).zzf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcy U1(IObjectWrapper iObjectWrapper, int i3) {
        return zzcnj.zza((Context) ObjectWrapper.h5(iObjectWrapper), null, i3).zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu V0(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzffg zzffgVarZzl = zzcnj.zza(context, zzbvcVar, i3).zzl();
        zzffgVarZzl.zzb(str);
        zzffgVarZzl.zzc(context);
        return zzffgVarZzl.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbq c0(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        return new zzesd(zzcnj.zza(context, zzbvcVar, i3), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbmn h4(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdqm((View) ObjectWrapper.h5(iObjectWrapper), (HashMap) ObjectWrapper.h5(iObjectWrapper2), (HashMap) ObjectWrapper.h5(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu i4(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbvc zzbvcVar, int i3) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        zzfgu zzfguVarZzj = zzcnj.zza(context, zzbvcVar, i3).zzj();
        zzfguVarZzj.zzd(context);
        zzfguVarZzj.zzb(zzrVar);
        zzfguVarZzj.zzc(str);
        return zzfguVarZzj.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbmi o2(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdqo((FrameLayout) ObjectWrapper.h5(iObjectWrapper), (FrameLayout) ObjectWrapper.h5(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbyu q0(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) {
        return zzcnj.zza((Context) ObjectWrapper.h5(iObjectWrapper), zzbvcVar, i3).zzu();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbzb zzg(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.h5(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelM = AdOverlayInfoParcel.M(activity.getIntent());
        if (adOverlayInfoParcelM == null) {
            return new zzw(activity);
        }
        int i3 = adOverlayInfoParcelM.f70051l;
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? new zzw(activity) : new zzag(activity) : new zzac(activity, adOverlayInfoParcelM) : new zzaj(activity) : new zzai(activity) : new zzv(activity);
    }
}
