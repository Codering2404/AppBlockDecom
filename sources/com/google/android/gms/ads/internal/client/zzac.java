package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzac extends zzax {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f69774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzaw f69775c;

    zzac(zzaw zzawVar, Activity activity) {
        this.f69774b = activity;
        Objects.requireNonNull(zzawVar);
        this.f69775c = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object a() {
        zzaw.l(this.f69774b, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object b() {
        Activity activity = this.f69774b;
        zzbiq.zza(activity);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            zzaw zzawVar = this.f69775c;
            return zzawVar.q().zza(this.f69774b);
        }
        try {
            return zzbza.zzI(((zzbze) com.google.android.gms.ads.internal.util.client.zzs.a(activity, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzab.f69773a)).zze(ObjectWrapper.i5(activity)));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e3) {
            zzaw zzawVar2 = this.f69775c;
            zzawVar2.s(zzbzy.zza(this.f69774b.getApplicationContext()));
            zzawVar2.r().zzh(e3, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object c(zzco zzcoVar) {
        return zzcoVar.zzg(ObjectWrapper.i5(this.f69774b));
    }
}
