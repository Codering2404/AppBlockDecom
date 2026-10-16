package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f70745a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f70746b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f70747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdzq f70748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f70749e;

    zzj(Context context, zzdzq zzdzqVar, ExecutorService executorService) {
        this.f70747c = context;
        this.f70748d = zzdzqVar;
        this.f70749e = executorService;
    }

    private final void h(final boolean z2) {
        Map map = this.f70746b;
        Boolean boolValueOf = Boolean.valueOf(z2);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.f70749e.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.f70737a.f(z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final synchronized void e(boolean z2, boolean z3) throws Throwable {
        Throwable th;
        try {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("query_info_type", "requester_type_6");
                bundle.putBoolean("accept_3p_cookie", z2);
                Map map = this.f70745a;
                Boolean boolValueOf = Boolean.valueOf(z2);
                zzl zzlVar = (zzl) map.get(boolValueOf);
                int iD = 0;
                if (z3 && zzlVar != null) {
                    try {
                        iD = zzlVar.d() + 1;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                zzl zzlVar2 = (zzl) map.get(boolValueOf);
                final zzk zzkVar = new zzk(this, z2, iD, zzlVar2 == null ? null : Boolean.valueOf(zzlVar2.e()), this.f70748d);
                final AdRequest adRequestM = ((AdRequest.Builder) new AdRequest.Builder().c(AdMobAdapter.class, bundle)).m();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmy)).booleanValue()) {
                    this.f70749e.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzh
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            return this.f70739a.g(adRequestM, zzkVar);
                        }
                    });
                } else {
                    QueryInfo.a(this.f70747c, AdFormat.BANNER, adRequestM, zzkVar);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final void j(zzl zzlVar, Pair pair, boolean z2) {
        zzlVar.f();
        QueryInfo queryInfoA = zzlVar.a();
        if (queryInfoA != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(queryInfoA);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzlVar.b());
        }
        zzv.e(this.f70748d, null, "sgpcr", new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - ((Long) pair.second).longValue())), new Pair("sgpc_h", Boolean.toString(z2)), new Pair("sgpc_rs", Boolean.toString(zzlVar.a() != null)));
    }

    public final synchronized void a() {
        h(true);
        h(false);
    }

    public final synchronized void b(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()));
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70742a.d(obj, pair);
            }
        });
    }

    final synchronized void c(final boolean z2, zzl zzlVar) {
        try {
            Map map = this.f70745a;
            Boolean boolValueOf = Boolean.valueOf(z2);
            zzl zzlVar2 = (zzl) map.get(boolValueOf);
            if (zzlVar2 == null || zzlVar2.c() || zzlVar2.a() == null || zzlVar.a() != null) {
                map.put(boolValueOf, zzlVar);
            }
            long jLongValue = (zzlVar.a() != null ? (Long) zzbkv.zzf.zze() : (Long) zzbkv.zzg.zze()).longValue();
            final boolean z3 = zzlVar.a() == null;
            zzcfr.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws Throwable {
                    this.f70734a.e(z2, z3);
                }
            }, jLongValue, TimeUnit.SECONDS);
            Map map2 = this.f70746b;
            List list = (List) map2.get(boolValueOf);
            map2.put(boolValueOf, new ArrayList());
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    j(zzlVar, (Pair) it.next(), false);
                }
            }
        } finally {
        }
    }

    final /* synthetic */ void d(Object obj, Pair pair) {
        boolean zAcceptThirdPartyCookies = false;
        if (obj instanceof WebView) {
            CookieManager cookieManagerA = com.google.android.gms.ads.internal.zzt.j().a(this.f70747c);
            if (cookieManagerA != null) {
                zAcceptThirdPartyCookies = cookieManagerA.acceptThirdPartyCookies((WebView) obj);
            }
        }
        Map map = this.f70745a;
        Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
        zzl zzlVar = (zzl) map.get(boolValueOf);
        if (zzlVar != null && !zzlVar.c()) {
            j(zzlVar, pair, true);
            return;
        }
        Map map2 = this.f70746b;
        List arrayList = (List) map2.get(boolValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(boolValueOf, arrayList);
        }
        arrayList.add(pair);
    }

    final /* synthetic */ void f(boolean z2) throws Throwable {
        e(z2, false);
    }

    final /* synthetic */ Object g(AdRequest adRequest, zzk zzkVar) {
        QueryInfo.a(this.f70747c, AdFormat.BANNER, adRequest, zzkVar);
        return Boolean.TRUE;
    }
}
