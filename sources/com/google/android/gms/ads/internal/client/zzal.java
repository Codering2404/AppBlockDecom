package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzal extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f69790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f69791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzbvc f69792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzaw f69793f;

    zzal(zzaw zzawVar, Context context, zzr zzrVar, String str, zzbvc zzbvcVar) {
        this.f69789b = context;
        this.f69790c = zzrVar;
        this.f69791d = str;
        this.f69792e = zzbvcVar;
        Objects.requireNonNull(zzawVar);
        this.f69793f = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69789b, "banner");
        return new zzfh();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        return this.f69793f.m().a(this.f69789b, this.f69790c, this.f69791d, this.f69792e, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.i4(ObjectWrapper.i5(this.f69789b), this.f69790c, this.f69791d, this.f69792e, ModuleDescriptor.MODULE_VERSION);
    }
}
