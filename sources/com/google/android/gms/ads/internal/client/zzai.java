package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyx;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzai extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbvc f69784c;

    zzai(zzaw zzawVar, Context context, zzbvc zzbvcVar) {
        this.f69783b = context;
        this.f69784c = zzbvcVar;
        Objects.requireNonNull(zzawVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Context context = this.f69783b;
        try {
            return ((zzbyx) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzah.f69782a)).zze(ObjectWrapper.i5(context), this.f69784c, ModuleDescriptor.MODULE_VERSION);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.q0(ObjectWrapper.i5(this.f69783b), this.f69784c, ModuleDescriptor.MODULE_VERSION);
    }
}
