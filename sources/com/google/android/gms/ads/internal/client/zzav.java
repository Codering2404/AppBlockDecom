package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbzy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzav extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FrameLayout f69817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FrameLayout f69818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f69819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzaw f69820e;

    zzav(zzaw zzawVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f69817b = frameLayout;
        this.f69818c = frameLayout2;
        this.f69819d = context;
        Objects.requireNonNull(zzawVar);
        this.f69820e = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69819d, "native_ad_view_delegate");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69819d;
        zzbiq.zza(context);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            zzaw zzawVar = this.f69820e;
            return zzawVar.p().zza(this.f69819d, this.f69817b, this.f69818c);
        }
        try {
            return zzbmh.zzdG(((zzbml) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzau.f69816a)).zze(ObjectWrapper.i5(context), ObjectWrapper.i5(this.f69817b), ObjectWrapper.i5(this.f69818c), ModuleDescriptor.MODULE_VERSION));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e3) {
            zzaw zzawVar2 = this.f69820e;
            zzawVar2.s(zzbzy.zza(this.f69819d));
            zzawVar2.r().zzh(e3, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.o2(ObjectWrapper.i5(this.f69817b), ObjectWrapper.i5(this.f69818c));
    }
}
