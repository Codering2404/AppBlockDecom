package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbzy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzap extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f69806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbvc f69807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzaw f69808e;

    zzap(zzaw zzawVar, Context context, String str, zzbvc zzbvcVar) {
        this.f69805b = context;
        this.f69806c = str;
        this.f69807d = zzbvcVar;
        Objects.requireNonNull(zzawVar);
        this.f69808e = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69805b, "native_ad");
        return new zzff();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69805b;
        zzbiq.zza(context);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            return this.f69808e.n().a(this.f69805b, this.f69806c, this.f69807d);
        }
        try {
            IBinder iBinderZze = ((zzbr) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzao.f69804a)).zze(ObjectWrapper.i5(context), this.f69806c, this.f69807d, ModuleDescriptor.MODULE_VERSION);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(iBinderZze);
        } catch (RemoteException e3) {
            e = e3;
            zzaw zzawVar = this.f69808e;
            zzawVar.s(zzbzy.zza(this.f69805b));
            zzawVar.r().zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            e = e4;
            zzaw zzawVar2 = this.f69808e;
            zzawVar2.s(zzbzy.zza(this.f69805b));
            zzawVar2.r().zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (NullPointerException e5) {
            e = e5;
            zzaw zzawVar22 = this.f69808e;
            zzawVar22.s(zzbzy.zza(this.f69805b));
            zzawVar22.r().zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.c0(ObjectWrapper.i5(this.f69805b), this.f69806c, this.f69807d, ModuleDescriptor.MODULE_VERSION);
    }
}
