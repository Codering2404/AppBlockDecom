package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzjp f78046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbgv f78047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzjc f78048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f78049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Long f78050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    zzbgs f78051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f78052h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzmp f78053i;

    zzjw(Context context, zzblw zzblwVar, zzmp zzmpVar, zzjc zzjcVar, zzjp zzjpVar) {
        this.f78045a = context;
        this.f78047c = zzbgw.c(zzblwVar);
        this.f78048d = zzjcVar;
        this.f78053i = zzmpVar;
        this.f78046b = zzjpVar;
    }

    public final ListenableFuture a(final zzbgs zzbgsVar) {
        if (zzbgsVar == zzbgs.PLACE_AUTOCOMPLETE) {
            throw new IllegalArgumentException("Autocomplete widget should call getOrRefreshToken()");
        }
        if (this.f78049e != null && e()) {
            throw new IllegalStateException("Token is expired");
        }
        zzbgs zzbgsVar2 = this.f78051g;
        if (zzbgsVar2 != null && zzbgsVar2 != zzbgsVar) {
            throw new IllegalArgumentException(String.format("Token type %s does not match requested type %s", zzbgsVar2.name(), zzbgsVar.name()));
        }
        String str = this.f78049e;
        return str != null ? Futures.f(str) : FluentFuture.F(this.f78046b.a()).H(new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzjv
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f78043a.d((String) obj, zzbgsVar);
            }
        }, MoreExecutors.a()).G(zzjt.f78040a, MoreExecutors.a());
    }

    public final ListenableFuture b(final zzbgs zzbgsVar) {
        String str;
        if (zzbgsVar != zzbgs.PLACE_AUTOCOMPLETE) {
            throw new IllegalArgumentException("Only Autocomplete widget should call getOrRefreshToken()");
        }
        zzbgs zzbgsVar2 = this.f78051g;
        if (zzbgsVar2 == null || zzbgsVar2 == zzbgsVar) {
            return (e() || (str = this.f78049e) == null) ? FluentFuture.F(this.f78046b.a()).H(new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzju
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final /* synthetic */ ListenableFuture apply(Object obj) {
                    return this.f78041a.d((String) obj, zzbgsVar);
                }
            }, MoreExecutors.a()).G(zzjs.f78039a, MoreExecutors.a()) : Futures.f(str);
        }
        throw new IllegalArgumentException(String.format("Token type %s does not match requested type %s", zzbgsVar2.name(), zzbgsVar.name()));
    }

    public final void c() {
        this.f78049e = null;
        this.f78050f = null;
        this.f78051g = null;
    }

    final ListenableFuture d(String str, zzbgs zzbgsVar) {
        if (this.f78052h) {
            throw new IllegalStateException("Too many concurrent requests");
        }
        this.f78052h = true;
        zzbgr zzbgrVarG = zzbgt.G();
        zzbgrVarG.y(zzbgsVar);
        zzbgrVarG.z(str);
        zzbgrVarG.A(this.f78045a.getPackageName());
        zzbgrVarG.B(4);
        zzbgt zzbgtVar = (zzbgt) zzbgrVarG.zzG();
        zzbgv zzbgvVar = (zzbgv) this.f78047c.d(zzcei.a(this.f78048d.a(this.f78053i.c(), "")));
        ListenableFuture listenableFutureB = zzcef.b(zzbgvVar.b().d(zzbgw.b(), zzbgvVar.c()), zzbgtVar);
        Futures.a(listenableFutureB, new zzjr(this, zzbgsVar), MoreExecutors.a());
        return listenableFutureB;
    }

    final boolean e() {
        Long l3 = this.f78050f;
        if (l3 == null) {
            return true;
        }
        return Instant.ofEpochSecond(l3.longValue()).isBefore(Instant.now());
    }

    final /* synthetic */ void f(boolean z2) {
        this.f78052h = false;
    }
}
