package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbqw;
import com.google.android.gms.internal.ads.zzbra;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzak extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbvc f69787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnH5AdsEventListener f69788d;

    zzak(zzaw zzawVar, Context context, zzbvc zzbvcVar, OnH5AdsEventListener onH5AdsEventListener) {
        this.f69786b = context;
        this.f69787c = zzbvcVar;
        this.f69788d = onH5AdsEventListener;
        Objects.requireNonNull(zzawVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* synthetic */ Object a() {
        return new zzbra();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69786b;
        try {
            return ((zzbqw) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzaj.f69785a)).zze(ObjectWrapper.i5(context), this.f69787c, ModuleDescriptor.MODULE_VERSION, new zzbqn(this.f69788d));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.L1(ObjectWrapper.i5(this.f69786b), this.f69787c, ModuleDescriptor.MODULE_VERSION, new zzbqn(this.f69788d));
    }
}
