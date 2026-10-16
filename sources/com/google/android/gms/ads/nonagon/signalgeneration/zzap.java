package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbap;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzceq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcnj;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfqg;
import com.google.android.gms.internal.ads.zzfqj;
import com.google.android.gms.internal.ads.zzfsc;
import com.google.android.gms.internal.ads.zzgta;
import com.google.android.gms.internal.ads.zzgua;
import com.google.android.gms.internal.ads.zzhbd;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbo;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzhcg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzap extends zzcel {
    protected static final List H = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List I = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List J = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List K = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private final List A;
    private final zzbjv E;
    private final zzj F;
    private final zza G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcnj f70652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f70653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbap f70654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzflc f70655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzflx f70656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzhcg f70657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f70658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbzt f70659i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzdzq f70662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzfsc f70663m;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final VersionInfoParcel f70671u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f70672v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List f70674x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f70675y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f70676z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Point f70660j = new Point();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Point f70661k = new Point();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicInteger f70670t = new AtomicInteger(0);
    private final AtomicBoolean B = new AtomicBoolean(false);
    private final AtomicBoolean C = new AtomicBoolean(false);
    private final AtomicInteger D = new AtomicInteger(0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f70664n = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzik)).booleanValue();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f70665o = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzij)).booleanValue();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f70666p = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzim)).booleanValue();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f70667q = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzio)).booleanValue();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f70668r = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzin);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f70669s = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzip);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f70673w = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziq);

    zzap(zzcnj zzcnjVar, Context context, zzbap zzbapVar, zzflx zzflxVar, zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, zzdzq zzdzqVar, zzfsc zzfscVar, VersionInfoParcel versionInfoParcel, zzbjv zzbjvVar, zzflc zzflcVar, zzj zzjVar, zza zzaVar) {
        List listC5;
        this.f70652a = zzcnjVar;
        this.f70653b = context;
        this.f70654c = zzbapVar;
        this.f70655d = zzflcVar;
        this.f70656f = zzflxVar;
        this.f70657g = zzhcgVar;
        this.f70658h = scheduledExecutorService;
        this.f70662l = zzdzqVar;
        this.f70663m = zzfscVar;
        this.f70671u = versionInfoParcel;
        this.E = zzbjvVar;
        this.F = zzjVar;
        this.G = zzaVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzir)).booleanValue()) {
            this.f70674x = C5((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzis));
            this.f70675y = C5((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzit));
            this.f70676z = C5((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziu));
            listC5 = C5((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziv));
        } else {
            this.f70674x = H;
            this.f70675y = I;
            this.f70676z = J;
            listC5 = K;
        }
        this.A = listC5;
    }

    private final boolean A5() {
        Map map;
        zzbzt zzbztVar = this.f70659i;
        return (zzbztVar == null || (map = zzbztVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri B5(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i3 = iIndexOf + 1;
        return Uri.parse(string.substring(0, i3) + str + "=" + str2 + "&" + string.substring(i3));
    }

    private static final List C5(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzgua.zzc(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* synthetic */ zzfqg O5(ListenableFuture listenableFuture, zzceq zzceqVar) {
        if (!zzfqj.zza() || !((Boolean) zzbkj.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfqg zzfqgVarZzb = ((zzx) zzhbw.zzs(listenableFuture)).zzb();
            zzfqgVarZzb.zzb(new ArrayList(Collections.singletonList(zzceqVar.zzb)));
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzceqVar.zzd;
            zzfqgVarZzb.zzc(zzmVar == null ? "" : zzmVar.f69979q);
            zzfqgVarZzb.zzd(zzmVar.f69976n);
            return zzfqgVarZzb;
        } catch (ExecutionException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    static final /* synthetic */ Uri s5(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? B5(uri, "nas", str) : uri;
    }

    private final void t5(final List list, final IObjectWrapper iObjectWrapper, zzbzq zzbzqVar, boolean z2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziA)).booleanValue()) {
            try {
                zzbzqVar.zzf("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                return;
            }
        }
        zzhcg zzhcgVar = this.f70657g;
        ListenableFuture listenableFutureSubmit = zzhcgVar.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzad
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.f70630a.G5(list, iObjectWrapper);
            }
        });
        if (A5()) {
            listenableFutureSubmit = zzhbw.zzj(listenableFutureSubmit, new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaf
                @Override // com.google.android.gms.internal.ads.zzhbe
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.f70635a.H5((ArrayList) obj);
                }
            }, zzhcgVar);
        } else {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Asset view map is empty.");
        }
        zzhbw.zzr(listenableFutureSubmit, new zzz(this, zzbzqVar, z2), this.f70652a.zzb());
    }

    private final void u5(List list, final IObjectWrapper iObjectWrapper, zzbzq zzbzqVar, boolean z2) {
        ListenableFuture listenableFutureSubmit;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziA)).booleanValue()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The updating URL feature is not enabled.");
            try {
                zzbzqVar.zzf("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                return;
            }
        }
        Iterator it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (E5((Uri) it.next())) {
                i4++;
            }
        }
        if (i4 > 1) {
            String strValueOf = String.valueOf(list);
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Multiple google urls found: ".concat(strValueOf));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (E5(uri)) {
                zzhcg zzhcgVar = this.f70657g;
                listenableFutureSubmit = zzhcgVar.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzag
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return this.f70636a.I5(uri, iObjectWrapper);
                    }
                });
                if (A5()) {
                    listenableFutureSubmit = zzhbw.zzj(listenableFutureSubmit, new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzah
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return this.f70639a.J5((Uri) obj);
                        }
                    }, zzhcgVar);
                } else {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.e("Asset view map is empty.");
                }
            } else {
                String strValueOf2 = String.valueOf(uri);
                int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Not a Google URL: ".concat(strValueOf2));
                listenableFutureSubmit = zzhbw.zza(uri);
            }
            arrayList.add(listenableFutureSubmit);
        }
        zzhbw.zzr(zzhbw.zzm(arrayList), new zzaa(this, zzbzqVar, z2), this.f70652a.zzb());
    }

    private final void v5() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkX)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzla)).booleanValue()) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzle)).booleanValue() && this.B.getAndSet(true)) {
                return;
            }
            zzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: w5, reason: merged with bridge method [inline-methods] */
    public final void zzx() {
        zzap zzapVar;
        ListenableFuture listenableFutureZzc;
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            this.F.a();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmy)).booleanValue()) {
            listenableFutureZzc = zzhbw.zzf(new zzhbd() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzai
                @Override // com.google.android.gms.internal.ads.zzhbd
                public final /* synthetic */ ListenableFuture zza() {
                    return this.f70640a.K5();
                }
            }, zzcfr.zza);
            zzapVar = this;
        } else {
            try {
                zzapVar = this;
                try {
                    listenableFutureZzc = zzapVar.y5(this.f70653b, null, AdFormat.BANNER.name(), null, null, new Bundle()).zza();
                } catch (NullPointerException e3) {
                    e = e3;
                    listenableFutureZzc = zzhbw.zzc(e);
                }
            } catch (NullPointerException e4) {
                e = e4;
                zzapVar = this;
            }
        }
        zzhbw.zzr(listenableFutureZzc, new zzab(this), zzapVar.f70652a.zzb());
    }

    private static boolean x5(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzx y5(android.content.Context r6, java.lang.String r7, java.lang.String r8, com.google.android.gms.ads.internal.client.zzr r9, com.google.android.gms.ads.internal.client.zzm r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzap.y5(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.client.zzm, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzx");
    }

    private final ListenableFuture z5(final String str) {
        final zzdux[] zzduxVarArr = new zzdux[1];
        ListenableFuture listenableFutureZzb = this.f70656f.zzb();
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.f70646a.M5(zzduxVarArr, str, (zzdux) obj);
            }
        };
        zzhcg zzhcgVar = this.f70657g;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZzb, zzhbeVar, zzhcgVar);
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzae
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70633a.N5(zzduxVarArr);
            }
        }, zzhcgVar);
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk((zzhbo) zzhbw.zzi(zzhbo.zzw(listenableFutureZzj), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziB)).intValue(), TimeUnit.MILLISECONDS, this.f70658h), zzal.f70644a, zzhcgVar), Exception.class, zzam.f70645a, zzhcgVar);
    }

    final boolean D5(Uri uri) {
        return x5(uri, this.f70676z, this.A);
    }

    final boolean E5(Uri uri) {
        return x5(uri, this.f70674x, this.f70675y);
    }

    final /* synthetic */ zzx F5(zzceq zzceqVar, Bundle bundle) {
        return y5(this.f70653b, zzceqVar.zza, zzceqVar.zzb, zzceqVar.zzc, zzceqVar.zzd, bundle);
    }

    final /* synthetic */ ArrayList G5(List list, IObjectWrapper iObjectWrapper) throws Exception {
        zzbap zzbapVar = this.f70654c;
        String strZzj = zzbapVar.zzb() != null ? zzbapVar.zzb().zzj(this.f70653b, (View) ObjectWrapper.h5(iObjectWrapper), null) : "";
        if (TextUtils.isEmpty(strZzj)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (D5(uri)) {
                arrayList.add(B5(uri, "ms", strZzj));
            } else {
                String strValueOf = String.valueOf(uri);
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Not a Google URL: ".concat(strValueOf));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    final /* synthetic */ ListenableFuture H5(final ArrayList arrayList) {
        return zzhbw.zzk(z5("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzgta() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.f70641a.L5(arrayList, (String) obj);
            }
        }, this.f70657g);
    }

    final /* synthetic */ Uri I5(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzflc zzflcVar;
        try {
            uri = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznw)).booleanValue() || (zzflcVar = this.f70655d) == null) ? this.f70654c.zzd(uri, this.f70653b, (View) ObjectWrapper.h5(iObjectWrapper), null) : zzflcVar.zza(uri, this.f70653b, (View) ObjectWrapper.h5(iObjectWrapper), null);
        } catch (zzbaq e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    final /* synthetic */ ListenableFuture J5(final Uri uri) {
        return zzhbw.zzk(z5("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzgta(this) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzak
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return zzap.s5(uri, (String) obj);
            }
        }, this.f70657g);
    }

    final /* synthetic */ ListenableFuture K5() {
        try {
            return y5(this.f70653b, null, AdFormat.BANNER.name(), null, null, new Bundle()).zza();
        } catch (NullPointerException e3) {
            return zzhbw.zzc(e3);
        }
    }

    final /* synthetic */ ArrayList L5(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!D5(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(B5(uri, "nas", str));
            }
        }
        return arrayList;
    }

    final /* synthetic */ ListenableFuture M5(zzdux[] zzduxVarArr, String str, zzdux zzduxVar) throws JSONException {
        zzduxVarArr[0] = zzduxVar;
        Context context = this.f70653b;
        zzbzt zzbztVar = this.f70659i;
        Map map = zzbztVar.zzb;
        JSONObject jSONObjectE = zzbs.e(context, map, map, zzbztVar.zza, null);
        JSONObject jSONObjectB = zzbs.b(this.f70653b, this.f70659i.zza);
        JSONObject jSONObjectC = zzbs.c(this.f70659i.zza);
        JSONObject jSONObjectD = zzbs.d(this.f70653b, this.f70659i.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectE);
        jSONObject.put("ad_view_signal", jSONObjectB);
        jSONObject.put("scroll_view_signal", jSONObjectC);
        jSONObject.put("lock_screen_signal", jSONObjectD);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbs.f(null, this.f70653b, this.f70661k, this.f70660j));
        }
        return zzduxVar.zzc(str, jSONObject);
    }

    final /* synthetic */ void N5(zzdux[] zzduxVarArr) {
        zzdux zzduxVar = zzduxVarArr[0];
        if (zzduxVar != null) {
            this.f70656f.zzc(zzhbw.zza(zzduxVar));
        }
    }

    final /* synthetic */ Context P5() {
        return this.f70653b;
    }

    final /* synthetic */ zzfsc h5() {
        return this.f70663m;
    }

    final /* synthetic */ String i5() {
        return this.f70668r;
    }

    final /* synthetic */ String j5() {
        return this.f70669s;
    }

    final /* synthetic */ AtomicInteger k5() {
        return this.f70670t;
    }

    final /* synthetic */ VersionInfoParcel l5() {
        return this.f70671u;
    }

    final /* synthetic */ String m5() {
        return this.f70672v;
    }

    final /* synthetic */ void n5(String str) {
        this.f70672v = str;
    }

    final /* synthetic */ String o5() {
        return this.f70673w;
    }

    final /* synthetic */ AtomicBoolean p5() {
        return this.C;
    }

    final /* synthetic */ AtomicInteger q5() {
        return this.D;
    }

    final /* synthetic */ zzdzq x3() {
        return this.f70662l;
    }

    final /* synthetic */ boolean zzC() {
        return this.f70664n;
    }

    final /* synthetic */ boolean zzD() {
        return this.f70665o;
    }

    final /* synthetic */ boolean zzE() {
        return this.f70666p;
    }

    final /* synthetic */ boolean zzF() {
        return this.f70667q;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b5  */
    @Override // com.google.android.gms.internal.ads.zzcem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(com.google.android.gms.dynamic.IObjectWrapper r9, final com.google.android.gms.internal.ads.zzceq r10, com.google.android.gms.internal.ads.zzcej r11) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzap.zze(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzceq, com.google.android.gms.internal.ads.zzcej):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzf(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziA)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.h5(iObjectWrapper);
            zzbzt zzbztVar = this.f70659i;
            this.f70660j = zzbs.h(motionEvent, zzbztVar == null ? null : zzbztVar.zza);
            if (motionEvent.getAction() == 0) {
                this.f70661k = this.f70660j;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.f70660j;
            motionEventObtain.setLocation(point.x, point.y);
            this.f70654c.zzc(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        t5(list, iObjectWrapper, zzbzqVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        u5(list, iObjectWrapper, zzbzqVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzi(zzbzt zzbztVar) {
        this.f70659i = zzbztVar;
        this.f70656f.zza(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkW)).booleanValue()) {
            zzbih zzbihVar = zzbiq.zziy;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue()) {
                v5();
            }
            WebView webView = (WebView) ObjectWrapper.h5(iObjectWrapper);
            if (webView == null) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.c("The webView cannot be null.");
                return;
            }
            zza zzaVar = this.G;
            zze zzeVar = new zze(webView, zzaVar, zzcfr.zzf);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.f70654c, this.f70662l, this.f70663m, this.f70655d, this.F, zzaVar, zzeVar), "gmaSdk");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlg)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzm();
            }
            if (((Boolean) zzbkv.zzc.zze()).booleanValue()) {
                zzaVar.a(webView);
                if (((Boolean) zzbkv.zzd.zze()).booleanValue()) {
                    zzeVar.zza();
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue()) {
                v5();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        t5(list, iObjectWrapper, zzbzqVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) {
        u5(list, iObjectWrapper, zzbzqVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlk)).booleanValue()) {
            return ObjectWrapper.i5(null);
        }
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        CustomTabsClient customTabsClient = (CustomTabsClient) ObjectWrapper.h5(iObjectWrapper2);
        CustomTabsCallback customTabsCallback = (CustomTabsCallback) ObjectWrapper.h5(iObjectWrapper3);
        zzbjv zzbjvVar = this.E;
        zzbjvVar.zza(context, customTabsClient, str, customTabsCallback);
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            this.F.a();
        }
        if (((Boolean) zzbkv.zzc.zze()).booleanValue()) {
            this.G.a(null);
        }
        return ObjectWrapper.i5(zzbjvVar.zzb());
    }

    final /* synthetic */ void zzw(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (E5((Uri) it.next())) {
                this.f70670t.getAndIncrement();
                return;
            }
        }
    }
}
