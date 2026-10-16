package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbzy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzar extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbvc f69811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzaw f69812d;

    zzar(zzaw zzawVar, Context context, zzbvc zzbvcVar) {
        this.f69810b = context;
        this.f69811c = zzbvcVar;
        Objects.requireNonNull(zzawVar);
        this.f69812d = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69810b, "ads_preloader");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object b() {
        zzch zzcfVar;
        Context context = this.f69810b;
        IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(context);
        zzbiq.zza(context);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            return this.f69812d.t().a(this.f69810b, this.f69811c);
        }
        try {
            zzci zzciVar = (zzci) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraAdPreloaderCreatorImpl", zzaq.f69809a);
            zzbvc zzbvcVar = this.f69811c;
            IBinder iBinderX3 = zzciVar.x3(iObjectWrapperI5, zzbvcVar, ModuleDescriptor.MODULE_VERSION);
            if (iBinderX3 == null) {
                zzcfVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderX3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                zzcfVar = iInterfaceQueryLocalInterface instanceof zzch ? (zzch) iInterfaceQueryLocalInterface : new zzcf(iBinderX3);
            }
            zzcfVar.zzl(zzbvcVar);
            return zzcfVar;
        } catch (RemoteException e3) {
            e = e3;
            zzaw zzawVar = this.f69812d;
            zzawVar.s(zzbzy.zza(this.f69810b));
            zzawVar.r().zzh(e, "ClientApiBroker.getAdPreloader");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            e = e4;
            zzaw zzawVar2 = this.f69812d;
            zzawVar2.s(zzbzy.zza(this.f69810b));
            zzawVar2.r().zzh(e, "ClientApiBroker.getAdPreloader");
            return null;
        } catch (NullPointerException e5) {
            e = e5;
            zzaw zzawVar22 = this.f69812d;
            zzawVar22.s(zzbzy.zza(this.f69810b));
            zzawVar22.r().zzh(e, "ClientApiBroker.getAdPreloader");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.Q2(ObjectWrapper.i5(this.f69810b), this.f69811c, ModuleDescriptor.MODULE_VERSION);
    }
}
