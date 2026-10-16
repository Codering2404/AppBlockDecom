package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbzy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzat extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzaw f69815c;

    zzat(zzaw zzawVar, Context context) {
        this.f69814b = context;
        Objects.requireNonNull(zzawVar);
        this.f69815c = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69814b, "mobile_ads_settings");
        return new zzfj();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69814b;
        zzbiq.zza(context);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            return this.f69815c.o().a(this.f69814b);
        }
        try {
            IBinder iBinderX3 = ((zzcz) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzas.f69813a)).x3(ObjectWrapper.i5(context), ModuleDescriptor.MODULE_VERSION);
            if (iBinderX3 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderX3.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return iInterfaceQueryLocalInterface instanceof zzcy ? (zzcy) iInterfaceQueryLocalInterface : new zzcw(iBinderX3);
        } catch (RemoteException e3) {
            e = e3;
            zzaw zzawVar = this.f69815c;
            zzawVar.s(zzbzy.zza(this.f69814b));
            zzawVar.r().zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            e = e4;
            zzaw zzawVar2 = this.f69815c;
            zzawVar2.s(zzbzy.zza(this.f69814b));
            zzawVar2.r().zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (NullPointerException e5) {
            e = e5;
            zzaw zzawVar22 = this.f69815c;
            zzawVar22.s(zzbzy.zza(this.f69814b));
            zzawVar22.r().zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.U1(ObjectWrapper.i5(this.f69814b), ModuleDescriptor.MODULE_VERSION);
    }
}
