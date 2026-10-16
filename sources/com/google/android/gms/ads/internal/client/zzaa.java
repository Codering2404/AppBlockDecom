package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzccu;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaa extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f69770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f69771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbvc f69772d;

    zzaa(zzaw zzawVar, Context context, String str, zzbvc zzbvcVar) {
        this.f69770b = context;
        this.f69771c = str;
        this.f69772d = zzbvcVar;
        Objects.requireNonNull(zzawVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69770b, "rewarded");
        return new zzfm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        return zzccu.zza(this.f69770b, this.f69771c, this.f69772d);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.J4(ObjectWrapper.i5(this.f69770b), this.f69771c, this.f69772d, ModuleDescriptor.MODULE_VERSION);
    }
}
