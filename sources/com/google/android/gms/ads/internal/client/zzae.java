package com.google.android.gms.ads.internal.client;

import android.content.Context;
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
final class zzae extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbvc f69778c;

    zzae(zzaw zzawVar, Context context, zzbvc zzbvcVar) {
        this.f69777b = context;
        this.f69778c = zzbvcVar;
        Objects.requireNonNull(zzawVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69777b, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69777b;
        IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(context);
        zzbiq.zza(context);
        if (((Boolean) zzba.c().zzd(zzbiq.zzkN)).booleanValue()) {
            try {
                return ((zzdu) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", zzad.f69776a)).x3(iObjectWrapperI5, this.f69778c, ModuleDescriptor.MODULE_VERSION);
            } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e3) {
                zzbzy.zza(this.f69777b).zzh(e3, "ClientApiBroker.getOutOfContextTester");
            }
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        Context context = this.f69777b;
        IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(context);
        zzbiq.zza(context);
        if (((Boolean) zzba.c().zzd(zzbiq.zzkN)).booleanValue()) {
            return zzcoVar.E(iObjectWrapperI5, this.f69778c, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }
}
