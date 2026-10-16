package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwh extends zzbvq {
    private final NativeAdMapper zza;

    public zzbwh(NativeAdMapper nativeAdMapper) {
        this.zza = nativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final float zzA() {
        return this.zza.g();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final float zzB() {
        return this.zza.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final void zzC() {
        this.zza.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zze() {
        return this.zza.i();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final List zzf() {
        List<NativeAd.Image> listK = this.zza.k();
        ArrayList arrayList = new ArrayList();
        if (listK != null) {
            for (NativeAd.Image image : listK) {
                arrayList.add(new zzblp(image.getDrawable(), image.getUri(), image.getScale(), image.zza(), image.zzb(), null));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zzg() {
        return this.zza.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final zzbme zzh() {
        NativeAd.Image imageJ = this.zza.j();
        if (imageJ != null) {
            return new zzblp(imageJ.getDrawable(), imageJ.getUri(), imageJ.getScale(), imageJ.zza(), imageJ.zzb(), null);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zzi() {
        return this.zza.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zzj() {
        return this.zza.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final double zzk() {
        NativeAdMapper nativeAdMapper = this.zza;
        if (nativeAdMapper.p() != null) {
            return nativeAdMapper.p().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zzl() {
        return this.zza.q();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final String zzm() {
        return this.zza.o();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final com.google.android.gms.ads.internal.client.zzea zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final zzblx zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final IObjectWrapper zzp() {
        View viewB = this.zza.b();
        if (viewB == null) {
            return null;
        }
        return ObjectWrapper.i5(viewB);
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final IObjectWrapper zzq() {
        View viewG = this.zza.G();
        if (viewG == null) {
            return null;
        }
        return ObjectWrapper.i5(viewG);
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final IObjectWrapper zzr() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final Bundle zzs() {
        return this.zza.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final boolean zzt() {
        return this.zza.n();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final boolean zzu() {
        return this.zza.m();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final void zzv() {
        this.zza.s();
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.r((View) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        HashMap map = (HashMap) ObjectWrapper.h5(iObjectWrapper2);
        HashMap map2 = (HashMap) ObjectWrapper.h5(iObjectWrapper3);
        this.zza.E((View) ObjectWrapper.h5(iObjectWrapper), map, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zza.F((View) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbvr
    public final float zzz() {
        return this.zza.l();
    }
}
