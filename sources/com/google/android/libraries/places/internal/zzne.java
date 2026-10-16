package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.ProductData;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzne implements zznf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Integer f78243c = 79508299;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transport f78244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzex f78245b;

    public zzne(Transport transport, zzex zzexVar) {
        this.f78244a = transport;
        this.f78245b = zzexVar;
    }

    public static Transport b(Context context) {
        TransportRuntime.f(context.getApplicationContext());
        return TransportRuntime.c().h("cct").a("LE", zzxp.class, Encoding.b("proto"), zznd.f78242a);
    }

    @Override // com.google.android.libraries.places.internal.zznf
    public final void a(zzaoc zzaocVar) {
        Futures.a(this.f78245b.a(), new zznc(this, zzaocVar), MoreExecutors.a());
    }

    final /* synthetic */ void c(zzaoc zzaocVar) {
        zzaoj zzaojVar = (zzaoj) zzaocVar.zzG();
        zzxn zzxnVarG = zzxp.G();
        zzxnVarG.z(1);
        zzxnVarG.y(zzaojVar);
        this.f78244a.b(Event.g((zzxp) zzxnVarG.zzG(), ProductData.b(f78243c)));
    }
}
