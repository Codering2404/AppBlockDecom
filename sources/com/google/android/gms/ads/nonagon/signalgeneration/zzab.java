package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzhbt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzab implements zzhbt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzap f70628a;

    zzab(zzap zzapVar) {
        Objects.requireNonNull(zzapVar);
        this.f70628a = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.l().zzg(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        Pair pair = new Pair("sgf_reason", th.getMessage());
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", AdFormat.BANNER.name());
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        zzap zzapVar = this.f70628a;
        zzv.e(zzapVar.x3(), null, "sgf", pair, pair2, pair3, pair4, pair5, new Pair("sgi_rn", Integer.toString(zzapVar.q5().get())));
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Failed to initialize webview for loading SDKCore. ", th);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzle)).booleanValue() || zzapVar.p5().get()) {
            return;
        }
        if (zzapVar.q5().getAndIncrement() < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlf)).intValue()) {
            zzapVar.zzx();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a(oUcQRqOVfOC.VDSZIgwZHN);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzle)).booleanValue()) {
            zzap zzapVar = this.f70628a;
            zzv.e(zzapVar.x3(), null, "sgs", new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), new Pair("sgi_rn", Integer.toString(zzapVar.q5().get())));
            zzapVar.p5().set(true);
        }
    }
}
