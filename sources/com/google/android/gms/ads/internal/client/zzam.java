package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzam extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f69795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f69796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzbvc f69797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzaw f69798f;

    zzam(zzaw zzawVar, Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        this.f69794b = context;
        this.f69795c = zzrVar;
        this.f69796d = str;
        this.f69797e = zzbvcVar;
        Objects.requireNonNull(zzawVar);
        this.f69798f = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69794b, "app_open");
        return new zzfh();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        return this.f69798f.m().a(this.f69794b, this.f69795c, this.f69796d, this.f69797e, 4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.V0(ObjectWrapper.i5(this.f69794b), this.f69795c, this.f69796d, this.f69797e, ModuleDescriptor.MODULE_VERSION);
    }
}
