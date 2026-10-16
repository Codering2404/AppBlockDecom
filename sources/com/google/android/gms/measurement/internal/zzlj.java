package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlj extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected zzky f74136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzjp f74137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f74138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f74139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference f74140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f74141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f74142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f74143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzay f74144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzay f74145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PriorityQueue f74146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f74147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private zzjl f74148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicLong f74149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f74150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final zzx f74151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f74152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private zzay f74153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f74154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private zzay f74155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final zzpo f74156w;

    protected zzlj(zzic zzicVar) {
        super(zzicVar);
        this.f74138e = new CopyOnWriteArraySet();
        this.f74141h = new Object();
        this.f74142i = false;
        this.f74143j = 1;
        this.f74152s = true;
        this.f74156w = new zzkn(this);
        this.f74140g = new AtomicReference();
        this.f74148o = zzjl.f74015c;
        this.f74150q = -1L;
        this.f74149p = new AtomicLong(0L);
        this.f74151r = new zzx(zzicVar);
    }

    private final zzlr e0(final zzom zzomVar) {
        try {
            URL url = new URI(zzomVar.f74391c).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strS = this.f73997a.L().s();
            zzic zzicVar = this.f73997a;
            zzgs zzgsVarW = zzicVar.a().w();
            Long lValueOf = Long.valueOf(zzomVar.f74389a);
            zzgsVarW.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, zzomVar.f74391c, Integer.valueOf(zzomVar.f74390b.length));
            if (!TextUtils.isEmpty(zzomVar.f74395h)) {
                zzicVar.a().w().c("[sgtm] Uploading data from app. row_id", lValueOf, zzomVar.f74395h);
            }
            HashMap map = new HashMap();
            Bundle bundle = zzomVar.f74392d;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            zzlo zzloVarF = zzicVar.F();
            byte[] bArr = zzomVar.f74390b;
            zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzkz
                /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
                @Override // com.google.android.gms.measurement.internal.zzll
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final /* synthetic */ void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
                    /*
                        r6 = this;
                        com.google.android.gms.measurement.internal.zzlj r7 = r6.f74117a
                        r7.h()
                        com.google.android.gms.measurement.internal.zzom r10 = r3
                        r11 = 200(0xc8, float:2.8E-43)
                        if (r8 == r11) goto L14
                        r11 = 204(0xcc, float:2.86E-43)
                        if (r8 == r11) goto L14
                        r11 = 304(0x130, float:4.26E-43)
                        if (r8 != r11) goto L2e
                        r8 = r11
                    L14:
                        if (r9 != 0) goto L2e
                        com.google.android.gms.measurement.internal.zzic r8 = r7.f73997a
                        com.google.android.gms.measurement.internal.zzgu r8 = r8.a()
                        com.google.android.gms.measurement.internal.zzgs r8 = r8.w()
                        long r0 = r10.f74389a
                        java.lang.Long r9 = java.lang.Long.valueOf(r0)
                        java.lang.String r11 = "[sgtm] Upload succeeded for row_id"
                        r8.b(r11, r9)
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.SUCCESS
                        goto L69
                    L2e:
                        com.google.android.gms.measurement.internal.zzic r11 = r7.f73997a
                        com.google.android.gms.measurement.internal.zzgu r11 = r11.a()
                        com.google.android.gms.measurement.internal.zzgs r11 = r11.r()
                        long r0 = r10.f74389a
                        java.lang.Long r0 = java.lang.Long.valueOf(r0)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
                        java.lang.String r2 = "[sgtm] Upload failed for row_id. response, exception"
                        r11.d(r2, r0, r1, r9)
                        com.google.android.gms.measurement.internal.zzfx r9 = com.google.android.gms.measurement.internal.zzfy.f73671u
                        r11 = 0
                        java.lang.Object r9 = r9.b(r11)
                        java.lang.String r9 = (java.lang.String) r9
                        java.lang.String r11 = ","
                        java.lang.String[] r9 = r9.split(r11)
                        java.util.List r9 = java.util.Arrays.asList(r9)
                        java.lang.String r8 = java.lang.String.valueOf(r8)
                        boolean r8 = r9.contains(r8)
                        if (r8 == 0) goto L67
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.BACKOFF
                        goto L69
                    L67:
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.FAILURE
                    L69:
                        java.util.concurrent.atomic.AtomicReference r9 = r2
                        com.google.android.gms.measurement.internal.zzic r11 = r7.f73997a
                        com.google.android.gms.measurement.internal.zznl r11 = r11.J()
                        com.google.android.gms.measurement.internal.zzaf r0 = new com.google.android.gms.measurement.internal.zzaf
                        long r1 = r10.f74389a
                        int r3 = r8.zza()
                        long r4 = r10.f74394g
                        r0.<init>(r1, r3, r4)
                        r11.l0(r0)
                        com.google.android.gms.measurement.internal.zzic r7 = r7.f73997a
                        com.google.android.gms.measurement.internal.zzgu r7 = r7.a()
                        com.google.android.gms.measurement.internal.zzgs r7 = r7.w()
                        java.lang.Long r10 = java.lang.Long.valueOf(r1)
                        java.lang.String r11 = "[sgtm] Updated status for row_id"
                        r7.c(r11, r10, r8)
                        monitor-enter(r9)
                        r9.set(r8)     // Catch: java.lang.Throwable -> L9d
                        r9.notifyAll()     // Catch: java.lang.Throwable -> L9d
                        monitor-exit(r9)     // Catch: java.lang.Throwable -> L9d
                        return
                    L9d:
                        r0 = move-exception
                        r7 = r0
                        monitor-exit(r9)     // Catch: java.lang.Throwable -> L9d
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
                }
            };
            zzloVarF.l();
            Preconditions.m(url);
            Preconditions.m(bArr);
            Preconditions.m(zzllVar);
            zzloVarF.f73997a.b().w(new zzln(zzloVarF, strS, url, bArr, map, zzllVar));
            try {
                zzic zzicVar2 = zzicVar.C().f73997a;
                long jCurrentTimeMillis = zzicVar2.e().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long jCurrentTimeMillis2 = 60000; atomicReference.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = jCurrentTimeMillis - zzicVar2.e().currentTimeMillis()) {
                        try {
                            atomicReference.wait(jCurrentTimeMillis2);
                        } finally {
                        }
                    }
                }
            } catch (InterruptedException unused) {
                this.f73997a.a().r().a("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlr.UNKNOWN : (zzlr) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e3) {
            this.f73997a.a().o().d("[sgtm] Bad upload url for row_id", zzomVar.f74391c, Long.valueOf(zzomVar.f74389a), e3);
            return zzlr.FAILURE;
        }
    }

    private final void f0(Boolean bool, boolean z2) {
        h();
        j();
        zzic zzicVar = this.f73997a;
        zzicVar.a().v().b("Setting app measurement enabled (FE)", bool);
        zzicVar.x().s(bool);
        if (z2) {
            zzhh zzhhVarX = zzicVar.x();
            zzic zzicVar2 = zzhhVarX.f73997a;
            zzhhVarX.h();
            SharedPreferences.Editor editorEdit = zzhhVarX.p().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.f73997a.j() || !(bool == null || bool.booleanValue())) {
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public final void Y() {
        zzlj zzljVar;
        h();
        zzic zzicVar = this.f73997a;
        String strA = zzicVar.x().f73820n.a();
        if (strA == null) {
            zzljVar = this;
        } else if ("unset".equals(strA)) {
            zzljVar = this;
            zzljVar.B("app", "_npa", null, zzicVar.e().currentTimeMillis());
        } else {
            B("app", "_npa", Long.valueOf(true != ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(strA) ? 0L : 1L), zzicVar.e().currentTimeMillis());
            zzljVar = this;
        }
        if (!zzljVar.f73997a.g() || !zzljVar.f74152s) {
            zzicVar.a().v().a("Updating Scion state (FE)");
            zzljVar.f73997a.J().X();
        } else {
            zzicVar.a().v().a("Recording app launch after enabling measurement for the first time (FE)");
            H();
            zzljVar.f73997a.z().f74369e.a();
            zzicVar.b().t(new zzjz(this));
        }
    }

    final void A(String str, String str2, long j3, Object obj) {
        this.f73997a.b().t(new zzkd(this, str, str2, obj, j3));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void B(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.g(r10)
            com.google.android.gms.common.internal.Preconditions.g(r11)
            r9.h()
            r9.j()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L74
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L53
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            r12 = 1
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r12 == r11) goto L37
            r11 = 0
            goto L38
        L37:
            r11 = r2
        L38:
            com.google.android.gms.measurement.internal.zzic r4 = r9.f73997a
            java.lang.Long r12 = java.lang.Long.valueOf(r11)
            com.google.android.gms.measurement.internal.zzhh r11 = r4.x()
            com.google.android.gms.measurement.internal.zzhg r11 = r11.f73820n
            long r4 = r12.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r11.b(r0)
        L51:
            r11 = r1
            goto L63
        L53:
            if (r12 != 0) goto L63
            com.google.android.gms.measurement.internal.zzic r11 = r9.f73997a
            com.google.android.gms.measurement.internal.zzhh r11 = r11.x()
            com.google.android.gms.measurement.internal.zzhg r11 = r11.f73820n
            java.lang.String r0 = "unset"
            r11.b(r0)
            goto L51
        L63:
            com.google.android.gms.measurement.internal.zzic r0 = r9.f73997a
            com.google.android.gms.measurement.internal.zzgu r0 = r0.a()
            com.google.android.gms.measurement.internal.zzgs r0 = r0.w()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.c(r1, r2, r12)
        L74:
            r4 = r11
            r7 = r12
            com.google.android.gms.measurement.internal.zzic r11 = r9.f73997a
            boolean r12 = r11.g()
            if (r12 != 0) goto L8e
            com.google.android.gms.measurement.internal.zzic r10 = r9.f73997a
            com.google.android.gms.measurement.internal.zzgu r10 = r10.a()
            com.google.android.gms.measurement.internal.zzgs r10 = r10.w()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.a(r11)
            return
        L8e:
            boolean r11 = r11.m()
            if (r11 != 0) goto L95
            return
        L95:
            com.google.android.gms.measurement.internal.zzic r11 = r9.f73997a
            com.google.android.gms.measurement.internal.zzpl r3 = new com.google.android.gms.measurement.internal.zzpl
            r8 = r10
            r5 = r13
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.zznl r10 = r11.J()
            r10.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.B(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final Map C(String str, String str2, boolean z2) {
        zzic zzicVar = this.f73997a;
        if (zzicVar.b().p()) {
            zzicVar.a().o().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        zzicVar.c();
        if (zzae.a()) {
            zzicVar.a().o().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f73997a.b().u(atomicReference, 5000L, "get user properties", new zzkl(this, atomicReference, null, str, str2, z2));
        List<zzpl> list = (List) atomicReference.get();
        if (list == null) {
            zzicVar.a().o().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z2));
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpl zzplVar : list) {
            Object objZza = zzplVar.zza();
            if (objZza != null) {
                arrayMap.put(zzplVar.f74478b, objZza);
            }
        }
        return arrayMap;
    }

    public final String D() {
        return (String) this.f74140g.get();
    }

    final void E(String str) {
        this.f74140g.set(str);
    }

    public final void F() {
        h();
        zzic zzicVar = this.f73997a;
        if (zzicVar.x().f73827u.a()) {
            zzicVar.a().v().a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jA = zzicVar.x().f73828v.a();
        zzicVar.x().f73828v.b(1 + jA);
        zzicVar.w();
        if (jA >= 5) {
            zzicVar.a().r().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzicVar.x().f73827u.b(true);
        } else {
            if (this.f74153t == null) {
                this.f74153t = new zzkg(this, this.f73997a);
            }
            this.f74153t.b(0L);
        }
    }

    public final void G(long j3) {
        this.f74140g.set(null);
        this.f73997a.b().t(new zzkh(this, j3));
    }

    public final void H() {
        h();
        j();
        if (this.f73997a.m()) {
            zzic zzicVar = this.f73997a;
            zzal zzalVarW = zzicVar.w();
            zzalVarW.f73997a.c();
            Boolean boolJ = zzalVarW.J("google_analytics_deferred_deep_link_enabled");
            if (boolJ != null && boolJ.booleanValue()) {
                zzicVar.a().v().a("Deferred Deep Link feature enabled.");
                zzicVar.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f74133a.F();
                    }
                });
            }
            this.f73997a.J().s();
            this.f74152s = false;
            zzhh zzhhVarX = zzicVar.x();
            zzhhVarX.h();
            String string = zzhhVarX.p().getString("previous_os_version", null);
            zzhhVarX.f73997a.K().l();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzhhVarX.p().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzicVar.K().l();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            t("auto", "_ou", bundle);
        }
    }

    public final void I(zzjp zzjpVar) {
        zzjp zzjpVar2;
        h();
        j();
        if (zzjpVar != null && zzjpVar != (zzjpVar2 = this.f74137d)) {
            Preconditions.r(zzjpVar2 == null, "EventInterceptor already set.");
        }
        this.f74137d = zzjpVar;
    }

    public final void J(zzjq zzjqVar) {
        j();
        Preconditions.m(zzjqVar);
        if (this.f74138e.add(zzjqVar)) {
            return;
        }
        this.f73997a.a().r().a("OnEventListener already registered");
    }

    public final void K(zzjq zzjqVar) {
        j();
        Preconditions.m(zzjqVar);
        if (this.f74138e.remove(zzjqVar)) {
            return;
        }
        this.f73997a.a().r().a("OnEventListener had not been registered");
    }

    public final int L(String str) {
        Preconditions.g(str);
        this.f73997a.w();
        return 25;
    }

    public final void M(Bundle bundle) {
        N(bundle, this.f73997a.e().currentTimeMillis());
    }

    public final void N(Bundle bundle, long j3) {
        Preconditions.m(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f73997a.a().r().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.m(bundle2);
        zzjh.b(bundle2, "app_id", String.class, null);
        zzjh.b(bundle2, "origin", String.class, null);
        zzjh.b(bundle2, "name", String.class, null);
        zzjh.b(bundle2, "value", Object.class, null);
        zzjh.b(bundle2, "trigger_event_name", String.class, null);
        zzjh.b(bundle2, "trigger_timeout", Long.class, 0L);
        zzjh.b(bundle2, "timed_out_event_name", String.class, null);
        zzjh.b(bundle2, "timed_out_event_params", Bundle.class, null);
        zzjh.b(bundle2, "triggered_event_name", String.class, null);
        zzjh.b(bundle2, "triggered_event_params", Bundle.class, null);
        zzjh.b(bundle2, "time_to_live", Long.class, 0L);
        zzjh.b(bundle2, "expired_event_name", String.class, null);
        zzjh.b(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.g(bundle2.getString("name"));
        Preconditions.g(bundle2.getString("origin"));
        Preconditions.m(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j3);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzic zzicVar = this.f73997a;
        if (zzicVar.C().y0(string) != 0) {
            zzicVar.a().o().b("Invalid conditional user property name", zzicVar.D().c(string));
            return;
        }
        if (zzicVar.C().y(string, obj) != 0) {
            zzicVar.a().o().c("Invalid conditional user property value", zzicVar.D().c(string), obj);
            return;
        }
        Object objZ = zzicVar.C().z(string, obj);
        if (objZ == null) {
            zzicVar.a().o().c("Unable to normalize conditional user property value", zzicVar.D().c(string), obj);
            return;
        }
        zzjh.a(bundle2, objZ);
        long j4 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            zzicVar.w();
            if (j4 > 15552000000L || j4 < 1) {
                zzicVar.a().o().c("Invalid conditional user property timeout", zzicVar.D().c(string), Long.valueOf(j4));
                return;
            }
        }
        long j5 = bundle2.getLong("time_to_live");
        zzicVar.w();
        if (j5 > 15552000000L || j5 < 1) {
            zzicVar.a().o().c("Invalid conditional user property time to live", zzicVar.D().c(string), Long.valueOf(j5));
        } else {
            zzicVar.b().t(new zzki(this, bundle2));
        }
    }

    public final void O(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.f73997a;
        long jCurrentTimeMillis = zzicVar.e().currentTimeMillis();
        Preconditions.g(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzicVar.b().t(new zzkj(this, bundle2));
    }

    public final ArrayList P(String str, String str2) {
        zzic zzicVar = this.f73997a;
        if (zzicVar.b().p()) {
            zzicVar.a().o().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzicVar.c();
        if (zzae.a()) {
            zzicVar.a().o().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f73997a.b().u(atomicReference, 5000L, "get conditional user properties", new zzkk(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzpp.h0(list);
        }
        zzicVar.a().o().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final String Q() {
        zzlu zzluVarU = this.f73997a.I().u();
        if (zzluVarU != null) {
            return zzluVarU.f74183a;
        }
        return null;
    }

    public final String R() {
        zzlu zzluVarU = this.f73997a.I().u();
        if (zzluVarU != null) {
            return zzluVarU.f74184b;
        }
        return null;
    }

    public final String S() {
        try {
            return zzlt.a(this.f73997a.d(), "google_app_id", this.f73997a.H());
        } catch (IllegalStateException e3) {
            this.f73997a.a().o().b("getGoogleAppId failed with exception", e3);
            return null;
        }
    }

    final /* synthetic */ void T(SharedPreferences sharedPreferences, String str) {
        zzic zzicVar = this.f73997a;
        if (!zzicVar.w().H(null, zzfy.f73621a1)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzicVar.a().w().a("IABTCF_TCString change picked up in listener.");
                ((zzay) Preconditions.m(this.f74155v)).b(500L);
                return;
            }
            return;
        }
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            zzicVar.a().w().a("IABTCF_TCString change picked up in listener.");
            ((zzay) Preconditions.m(this.f74155v)).b(500L);
        }
    }

    final /* synthetic */ void U(Bundle bundle) {
        Bundle bundle2;
        int i3;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzic zzicVar = this.f73997a;
            bundle2 = new Bundle(zzicVar.x().f73832z.a());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzicVar.C().B0(obj)) {
                        zzicVar.C().B(this.f74156w, null, 27, null, null, 0);
                    }
                    zzicVar.a().t().c("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpp.N(next)) {
                    zzicVar.a().t().b("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzicVar.C().C0("param", next, zzicVar.w().x(null, false), obj)) {
                    zzicVar.C().A(bundle2, next, obj);
                }
            }
            zzicVar.C();
            int iV = zzicVar.w().v();
            if (bundle2.size() > iV) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i3++;
                    if (i3 > iV) {
                        bundle2.remove(str);
                    }
                }
                zzicVar.C().B(this.f74156w, null, 26, null, null, 0);
                zzicVar.a().t().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzic zzicVar2 = this.f73997a;
        zzicVar2.x().f73832z.b(bundle2);
        if (!bundle.isEmpty() || zzicVar2.w().H(null, zzfy.X0)) {
            this.f73997a.J().v(bundle2);
        }
    }

    final /* synthetic */ void V(int i3) {
        if (this.f74144k == null) {
            this.f74144k = new zzjx(this, this.f73997a);
        }
        this.f74144k.b(((long) i3) * 1000);
    }

    final /* synthetic */ void W(Boolean bool, boolean z2) {
        f0(bool, true);
    }

    final /* synthetic */ void X(zzjl zzjlVar, long j3, boolean z2, boolean z3) {
        h();
        j();
        zzic zzicVar = this.f73997a;
        zzjl zzjlVarW = zzicVar.x().w();
        if (j3 <= this.f74150q && zzjl.u(zzjlVarW.b(), zzjlVar.b())) {
            zzicVar.a().u().b("Dropped out-of-date consent setting, proposed settings", zzjlVar);
            return;
        }
        zzhh zzhhVarX = zzicVar.x();
        zzic zzicVar2 = zzhhVarX.f73997a;
        zzhhVarX.h();
        int iB = zzjlVar.b();
        if (!zzhhVarX.v(iB)) {
            zzicVar.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjlVar.b()));
            return;
        }
        zzic zzicVar3 = this.f73997a;
        SharedPreferences.Editor editorEdit = zzhhVarX.p().edit();
        editorEdit.putString("consent_settings", zzjlVar.l());
        editorEdit.putInt("consent_source", iB);
        editorEdit.apply();
        zzicVar.a().w().b("Setting storage consent(FE)", zzjlVar);
        this.f74150q = j3;
        if (zzicVar3.J().D()) {
            zzicVar3.J().Z(z2);
        } else {
            zzicVar3.J().Y(z2);
        }
        if (z3) {
            zzicVar3.J().q(new AtomicReference());
        }
    }

    final /* synthetic */ void Z(boolean z2) {
        this.f74142i = false;
    }

    final /* synthetic */ int a0() {
        return this.f74143j;
    }

    final /* synthetic */ void b0(int i3) {
        this.f74143j = i3;
    }

    final /* synthetic */ zzay c0() {
        return this.f74153t;
    }

    final /* synthetic */ int d0(Throwable th) {
        String message = th.getMessage();
        this.f74147n = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (!message.contains("Background")) {
            return 1;
        }
        this.f74147n = true;
        return 1;
    }

    public final void h0() {
        zzic zzicVar = this.f73997a;
        if (!(zzicVar.d().getApplicationContext() instanceof Application) || this.f74136c == null) {
            return;
        }
        ((Application) zzicVar.d().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f74136c);
    }

    public final Boolean i0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f73997a.b().u(atomicReference, 15000L, "boolean test flag value", new zzke(this, atomicReference));
    }

    public final String j0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f73997a.b().u(atomicReference, 15000L, "String test flag value", new zzko(this, atomicReference));
    }

    public final Long k0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f73997a.b().u(atomicReference, 15000L, "long test flag value", new zzkp(this, atomicReference));
    }

    public final Integer l0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f73997a.b().u(atomicReference, 15000L, "int test flag value", new zzkq(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return false;
    }

    public final Double m0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f73997a.b().u(atomicReference, 15000L, "double test flag value", new zzkr(this, atomicReference));
    }

    public final void n0(Boolean bool) {
        j();
        this.f73997a.b().t(new zzks(this, bool));
    }

    final void o(zzjl zzjlVar) {
        h();
        boolean z2 = (zzjlVar.o(zzjk.ANALYTICS_STORAGE) && zzjlVar.o(zzjk.AD_STORAGE)) || this.f73997a.J().C();
        zzic zzicVar = this.f73997a;
        if (z2 != zzicVar.j()) {
            zzicVar.i(z2);
            zzhh zzhhVarX = this.f73997a.x();
            zzic zzicVar2 = zzhhVarX.f73997a;
            zzhhVarX.h();
            Boolean boolValueOf = zzhhVarX.p().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzhhVarX.p().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z2 || boolValueOf == null || boolValueOf.booleanValue()) {
                f0(Boolean.valueOf(z2), false);
            }
        }
    }

    final void o0(Bundle bundle, int i3, long j3) {
        Object obj;
        String string;
        j();
        zzjl zzjlVar = zzjl.f74015c;
        zzjk[] zzjkVarArrB = zzjj.STORAGE.b();
        int length = zzjkVarArrB.length;
        int i4 = 0;
        while (true) {
            obj = null;
            if (i4 >= length) {
                break;
            }
            String str = zzjkVarArrB[i4].f74014a;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i4++;
        }
        if (obj != null) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().t().b("Ignoring invalid consent setting", obj);
            zzicVar.a().t().a("Valid consent values are 'granted', 'denied'");
        }
        boolean zP = this.f73997a.b().p();
        zzjl zzjlVarE = zzjl.e(bundle, i3);
        if (zzjlVarE.c()) {
            q0(zzjlVarE, zP);
        }
        zzaz zzazVarH = zzaz.h(bundle, i3);
        if (zzazVarH.d()) {
            p0(zzazVarH, zP);
        }
        Boolean boolI = zzaz.i(bundle);
        if (boolI != null) {
            String str2 = i3 == -30 ? "tcf" : "app";
            if (zP) {
                B(str2, "allow_personalized_ads", boolI.toString(), j3);
            } else {
                z(str2, "allow_personalized_ads", boolI.toString(), false, j3);
            }
        }
    }

    public final void p(String str, String str2, Bundle bundle) {
        q(str, str2, bundle, true, true, this.f73997a.e().currentTimeMillis());
    }

    final void p0(zzaz zzazVar, boolean z2) {
        zzkt zzktVar = new zzkt(this, zzazVar);
        if (!z2) {
            this.f73997a.b().t(zzktVar);
        } else {
            h();
            zzktVar.run();
        }
    }

    public final void q(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j3) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, "screen_view")) {
            this.f73997a.I().s(bundle2, j3);
            return;
        }
        boolean z4 = true;
        if (z3 && this.f74137d != null && !zzpp.N(str2)) {
            z4 = false;
        }
        boolean z5 = z4;
        if (str == null) {
            str = "app";
        }
        x(str, str2, j3, bundle2, z3, z5, z2, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:56:0x00d0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void q0(com.google.android.gms.measurement.internal.zzjl r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.q0(com.google.android.gms.measurement.internal.zzjl, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        zzic zzicVar;
        zzod zzodVar;
        zzod zzodVar2;
        com.google.android.gms.internal.measurement.zzkq zzkqVar;
        h();
        zzic zzicVar2 = this.f73997a;
        zzicVar2.a().v().a("Handle tcf update.");
        SharedPreferences sharedPreferencesQ = zzicVar2.x().q();
        HashMap map = new HashMap();
        zzfx zzfxVar = zzfy.f73621a1;
        if (((Boolean) zzfxVar.b(null)).booleanValue()) {
            ImmutableList immutableList = zzof.f74378a;
            com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            zzoe zzoeVar = zzoe.CONSENT;
            Map.Entry entryA = f.a(zzkpVar, zzoeVar);
            int i3 = 2;
            com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            int i4 = 1;
            zzoe zzoeVar2 = zzoe.FLEXIBLE_LEGITIMATE_INTEREST;
            zzicVar = zzicVar2;
            ImmutableMap immutableMapR = ImmutableMap.r(entryA, f.a(zzkpVar2, zzoeVar2), f.a(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzoeVar), f.a(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzoeVar), f.a(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzoeVar2), f.a(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzoeVar2), f.a(com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzoeVar2));
            ImmutableSet immutableSetA = ImmutableSet.A("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesQ.contains("IABTCF_TCString");
            int iB = zzof.b(sharedPreferencesQ, "IABTCF_CmpSdkID");
            int iB2 = zzof.b(sharedPreferencesQ, "IABTCF_PolicyVersion");
            int iB3 = zzof.b(sharedPreferencesQ, "IABTCF_gdprApplies");
            int iB4 = zzof.b(sharedPreferencesQ, "IABTCF_PurposeOneTreatment");
            int iB5 = zzof.b(sharedPreferencesQ, "IABTCF_EnableAdvertiserConsentMode");
            String strA = zzof.a(sharedPreferencesQ, "IABTCF_PublisherCC");
            ImmutableMap.Builder builderA = ImmutableMap.a();
            UnmodifiableIterator it = immutableMapR.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzkp zzkpVar3 = (com.google.android.gms.internal.measurement.zzkp) it.next();
                int iZza = zzkpVar3.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iZza);
                String strA2 = zzof.a(sharedPreferencesQ, sb.toString());
                if (TextUtils.isEmpty(strA2) || strA2.length() < 755) {
                    zzkqVar = com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    zzkqVar = (iDigit < 0 || iDigit > com.google.android.gms.internal.measurement.zzkq.values().length || iDigit == 0) ? com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED : iDigit != i4 ? iDigit != i3 ? com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                }
                builderA.g(zzkpVar3, zzkqVar);
                i3 = 2;
                i4 = 1;
            }
            ImmutableMap immutableMapD = builderA.d();
            String strA3 = zzof.a(sharedPreferencesQ, "IABTCF_PurposeConsents");
            String strA4 = zzof.a(sharedPreferencesQ, "IABTCF_VendorConsents");
            boolean z2 = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = zzof.a(sharedPreferencesQ, "IABTCF_PurposeLegitimateInterests");
            String strA6 = zzof.a(sharedPreferencesQ, "IABTCF_VendorLegitimateInterests");
            boolean z3 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            zzodVar = new zzod(zzof.d(immutableMapR, immutableMapD, immutableSetA, cArr, iB, iB5, iB3, iB2, iB4, strA, strA3, strA5, z2, z3, zContains));
        } else {
            zzicVar = zzicVar2;
            String strA7 = zzof.a(sharedPreferencesQ, "IABTCF_VendorConsents");
            if (!"".equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            int iB6 = zzof.b(sharedPreferencesQ, "IABTCF_gdprApplies");
            if (iB6 != -1) {
                map.put("gdprApplies", String.valueOf(iB6));
            }
            int iB7 = zzof.b(sharedPreferencesQ, "IABTCF_EnableAdvertiserConsentMode");
            if (iB7 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(iB7));
            }
            int iB8 = zzof.b(sharedPreferencesQ, "IABTCF_PolicyVersion");
            if (iB8 != -1) {
                map.put("PolicyVersion", String.valueOf(iB8));
            }
            String strA8 = zzof.a(sharedPreferencesQ, "IABTCF_PurposeConsents");
            if (!"".equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            int iB9 = zzof.b(sharedPreferencesQ, "IABTCF_CmpSdkID");
            if (iB9 != -1) {
                map.put("CmpSdkID", String.valueOf(iB9));
            }
            zzodVar = new zzod(map);
        }
        zzicVar.a().w().b("Tcf preferences read", zzodVar);
        if (!zzicVar.w().H(null, zzfxVar)) {
            if (zzicVar.x().x(zzodVar)) {
                Bundle bundleB = zzodVar.b();
                zzicVar.a().w().b("Consent generated from Tcf", bundleB);
                if (bundleB != Bundle.EMPTY) {
                    o0(bundleB, -30, zzicVar.e().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", zzodVar.e());
                t("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        zzhh zzhhVarX = zzicVar.x();
        zzhhVarX.h();
        String string = zzhhVarX.p().getString("stored_tcf_param", "");
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzodVar2 = new zzod(map2);
        } else {
            for (String str : string.split(";")) {
                String[] strArrSplit = str.split("=");
                if (strArrSplit.length >= 2 && zzof.f74378a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            zzodVar2 = new zzod(map2);
        }
        if (zzicVar.x().x(zzodVar)) {
            Bundle bundleB2 = zzodVar.b();
            zzicVar.a().w().b("Consent generated from Tcf", bundleB2);
            if (bundleB2 != Bundle.EMPTY) {
                o0(bundleB2, -30, zzicVar.e().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfm", zzodVar.d(zzodVar2));
            bundle2.putString("_tcfd2", zzodVar.c());
            bundle2.putString("_tcfd", zzodVar.e());
            t("auto", "_tcf", bundle2);
        }
    }

    final void r0(Runnable runnable) {
        j();
        zzic zzicVar = this.f73997a;
        if (zzicVar.b().p()) {
            zzicVar.a().o().a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        if (zzicVar.b().q()) {
            zzicVar.a().o().a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzicVar.c();
        if (zzae.a()) {
            zzicVar.a().o().a("Cannot retrieve and upload batches from main thread");
            return;
        }
        zzicVar.a().w().a("[sgtm] Started client-side batch upload work.");
        boolean z2 = false;
        int size = 0;
        int i3 = 0;
        while (!z2) {
            zzicVar.a().w().a("[sgtm] Getting upload batches from service (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzicVar.b().u(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzli
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f74134a.f73997a.J().k0(atomicReference, zzoo.M(zzls.SGTM_CLIENT));
                }
            });
            zzoq zzoqVar = (zzoq) atomicReference.get();
            if (zzoqVar == null) {
                break;
            }
            List list = zzoqVar.f74397a;
            if (!list.isEmpty()) {
                zzicVar.a().w().b("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                size += list.size();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    zzlr zzlrVarE0 = e0((zzom) it.next());
                    if (zzlrVarE0 == zzlr.SUCCESS) {
                        i3++;
                    } else if (zzlrVarE0 == zzlr.BACKOFF) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        zzicVar.a().w().c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i3));
        runnable.run();
    }

    public final void s() {
        h();
        zzic zzicVar = this.f73997a;
        zzicVar.a().v().a("Register tcfPrefChangeListener.");
        if (this.f74154u == null) {
            this.f74155v = new zzkb(this, this.f73997a);
            this.f74154u = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzle
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.f74128a.T(sharedPreferences, str);
                }
            };
        }
        zzicVar.x().q().registerOnSharedPreferenceChangeListener(this.f74154u);
    }

    final void s0(long j3) {
        h();
        if (this.f74145l == null) {
            this.f74145l = new zzju(this, this.f73997a);
        }
        this.f74145l.b(j3);
    }

    final void t(String str, String str2, Bundle bundle) {
        h();
        u(str, str2, this.f73997a.e().currentTimeMillis(), bundle);
    }

    final void t0() {
        h();
        zzay zzayVar = this.f74145l;
        if (zzayVar != null) {
            zzayVar.d();
        }
    }

    final void u(String str, String str2, long j3, Bundle bundle) {
        h();
        boolean z2 = true;
        if (this.f74137d != null && !zzpp.N(str2)) {
            z2 = false;
        }
        v(str, str2, j3, bundle, true, z2, true, null);
    }

    final void u0() {
        zzqp.zza();
        zzic zzicVar = this.f73997a;
        if (zzicVar.w().H(null, zzfy.R0)) {
            if (zzicVar.b().p()) {
                zzicVar.a().o().a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            zzicVar.c();
            if (zzae.a()) {
                zzicVar.a().o().a("Cannot get trigger URIs from main thread");
                return;
            }
            j();
            zzicVar.a().w().a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzicVar.b().u(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzlj zzljVar = this.f74122a;
                    zzljVar.f73997a.J().j0(atomicReference, zzljVar.f73997a.x().f73821o.a());
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.a().q().a("Timed out waiting for get trigger URIs");
            } else {
                zzicVar.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzlj zzljVar = this.f74124a;
                        zzljVar.h();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        List<zzoh> list2 = list;
                        SparseArray sparseArrayR = zzljVar.f73997a.x().r();
                        for (zzoh zzohVar : list2) {
                            int i3 = zzohVar.f74383c;
                            if (!sparseArrayR.contains(i3) || ((Long) sparseArrayR.get(i3)).longValue() < zzohVar.f74382b) {
                                zzljVar.w0().add(zzohVar);
                            }
                        }
                        zzljVar.x0();
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void v(String str, String str2, long j3, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        boolean z5;
        int i3;
        zzic zzicVar;
        long j4;
        long j5;
        String str4;
        long j6;
        Bundle[] bundleArr;
        String str5 = str;
        Preconditions.g(str5);
        Preconditions.m(bundle);
        h();
        j();
        zzic zzicVar2 = this.f73997a;
        if (!zzicVar2.g()) {
            this.f73997a.a().v().a("Event not sent since app measurement is disabled");
            return;
        }
        List listW = this.f73997a.L().w();
        if (listW != null && !listW.contains(str2)) {
            this.f73997a.a().v().c("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.f74139f) {
            this.f74139f = true;
            try {
                try {
                    (!zzicVar2.G() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.f73997a.d().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.f73997a.d());
                } catch (Exception e3) {
                    this.f73997a.a().r().b("Failed to invoke Tag Manager's initialize() method", e3);
                }
            } catch (ClassNotFoundException unused) {
                this.f73997a.a().u().a("Tag Manager is not found and thus will not be used");
            }
        }
        zzic zzicVar3 = this.f73997a;
        if (!zzicVar3.w().H(null, zzfy.f73639g1) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            zzicVar3.c();
            B("auto", "_lgclid", bundle.getString("gclid"), zzicVar3.e().currentTimeMillis());
        }
        zzlj zzljVar = this;
        zzicVar3.c();
        if (z2 && zzpp.U(str2)) {
            zzicVar3.C().w(bundle, zzicVar3.x().f73832z.a());
        }
        if (!z4) {
            zzicVar3.c();
            if (!"_iap".equals(str2)) {
                zzic zzicVar4 = zzljVar.f73997a;
                zzpp zzppVarC = zzicVar4.C();
                int i4 = 2;
                if (zzppVarC.t0("event", str2)) {
                    if (zzppVarC.v0("event", zzjm.f74018a, zzjm.f74019b, str2)) {
                        zzppVarC.f73997a.w();
                        if (zzppVarC.w0("event", 40, str2)) {
                            i4 = 0;
                        }
                    } else {
                        i4 = 13;
                    }
                }
                if (i4 != 0) {
                    zzicVar3.a().q().b("Invalid public event name. Event will not be logged (FE)", zzicVar3.D().a(str2));
                    zzpp zzppVarC2 = zzicVar4.C();
                    zzicVar4.w();
                    zzicVar4.C().B(zzljVar.f74156w, null, i4, "_ev", zzppVarC2.q(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzicVar3.c();
        zzic zzicVar5 = zzljVar.f73997a;
        zzlu zzluVarQ = zzicVar5.I().q(false);
        if (zzluVarQ != null && !bundle.containsKey("_sc")) {
            zzluVarQ.f74186d = true;
        }
        zzpp.k0(zzluVarQ, bundle, z2 && !z4);
        boolean zEquals = "am".equals(str5);
        boolean zN = zzpp.N(str2);
        if (!z2 || zzljVar.f74137d == null || zN) {
            z5 = zEquals;
        } else {
            if (!zEquals) {
                zzicVar3.a().v().c("Passing event to registered event handler (FE)", zzicVar3.D().a(str2), zzicVar3.D().e(bundle));
                Preconditions.m(zzljVar.f74137d);
                zzljVar.f74137d.a(str5, str2, bundle, j3);
                return;
            }
            z5 = true;
        }
        zzic zzicVar6 = zzljVar.f73997a;
        if (zzicVar6.m()) {
            int iX0 = zzicVar3.C().x0(str2);
            if (iX0 != 0) {
                zzicVar3.a().q().b("Invalid event name. Event will not be logged (FE)", zzicVar3.D().a(str2));
                zzpp zzppVarC3 = zzicVar3.C();
                zzicVar3.w();
                zzicVar6.C().B(zzljVar.f74156w, str3, iX0, "_ev", zzppVarC3.q(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleT = zzicVar3.C().t(str3, str2, bundle, CollectionUtils.b("_o", "_sn", "_sc", "_si"), z4);
            Preconditions.m(bundleT);
            zzicVar3.c();
            if (zzicVar5.I().q(false) == null || !"_ae".equals(str2)) {
                i3 = 0;
                zzicVar = zzicVar5;
                j4 = 0;
            } else {
                zzoa zzoaVar = zzicVar5.z().f74370f;
                j4 = 0;
                long jA = zzoaVar.f74365d.f73997a.e().a();
                i3 = 0;
                zzicVar = zzicVar5;
                long j7 = jA - zzoaVar.f74363b;
                zzoaVar.f74363b = jA;
                if (j7 > 0) {
                    zzicVar3.C().Z(bundleT, j7);
                }
            }
            if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                zzpp zzppVarC4 = zzicVar3.C();
                String string = bundleT.getString("_ffr");
                if (Strings.b(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                zzic zzicVar7 = zzppVarC4.f73997a;
                if (Objects.equals(string, zzicVar7.x().f73829w.a())) {
                    zzicVar7.a().v().a("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zzicVar7.x().f73829w.b(string);
            } else if ("_ae".equals(str2)) {
                String strA = zzicVar3.C().f73997a.x().f73829w.a();
                if (!TextUtils.isEmpty(strA)) {
                    bundleT.putString("_ffr", strA);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleT);
            boolean zP = zzicVar3.w().H(null, zzfy.V0) ? zzicVar.z().p() : zzicVar3.x().f73826t.a();
            if (zzicVar3.x().f73823q.a() > j4 && zzicVar3.x().A(j3) && zP) {
                zzicVar3.a().w().a("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                j5 = j4;
                B("auto", "_sid", null, zzicVar3.e().currentTimeMillis());
                B("auto", "_sno", null, zzicVar3.e().currentTimeMillis());
                B("auto", "_se", null, zzicVar3.e().currentTimeMillis());
                zzljVar = this;
                zzicVar3.x().f73824r.b(j5);
            } else {
                j5 = j4;
                str4 = "_ae";
            }
            if (bundleT.getLong("extend_session", j5) == 1) {
                zzicVar3.a().w().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                j6 = j3;
                zzicVar6.z().f74369e.b(j6, true);
            } else {
                j6 = j3;
            }
            ArrayList arrayList2 = new ArrayList(bundleT.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i5 = i3; i5 < size; i5++) {
                String str6 = (String) arrayList2.get(i5);
                if (str6 != null) {
                    zzicVar3.C();
                    Object obj = bundleT.get(str6);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[1];
                        bundleArr[i3] = (Bundle) obj;
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleT.putParcelableArray(str6, bundleArr);
                    }
                }
            }
            int i6 = i3;
            while (i6 < arrayList.size()) {
                Bundle bundleQ = (Bundle) arrayList.get(i6);
                String str7 = i6 != 0 ? "_ep" : str2;
                bundleQ.putString("_o", str5);
                if (z3) {
                    bundleQ = zzicVar3.C().Q(bundleQ, null);
                }
                Bundle bundle2 = bundleQ;
                zzicVar.J().c0(new zzbg(str7, new zzbe(bundle2), str5, j6), str3);
                if (!z5) {
                    Iterator it = zzljVar.f74138e.iterator();
                    while (it.hasNext()) {
                        ((zzjq) it.next()).a(str, str2, new Bundle(bundle2), j3);
                    }
                }
                i6++;
                str5 = str;
                j6 = j3;
            }
            zzicVar3.c();
            if (zzicVar.I().q(i3) == null || !str4.equals(str2)) {
                return;
            }
            zzicVar.z().f74370f.d(true, true, zzicVar3.e().a());
        }
    }

    final boolean v0() {
        return this.f74147n;
    }

    public final void w(String str, String str2, Bundle bundle, String str3) {
        zzic.q();
        x("auto", str2, this.f73997a.e().currentTimeMillis(), bundle, false, true, true, str3);
    }

    final PriorityQueue w0() {
        if (this.f74146m == null) {
            this.f74146m = new PriorityQueue(Comparator.comparing(zzlc.f74126a, zzld.f74127a));
        }
        return this.f74146m;
    }

    protected final void x(String str, String str2, long j3, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        int i3 = zzpp.f74491k;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i4 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i4 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i4];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i4] = new Bundle((Bundle) parcelable);
                        }
                        i4++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i4 < list.size()) {
                        Object obj2 = list.get(i4);
                        if (obj2 instanceof Bundle) {
                            list.set(i4, new Bundle((Bundle) obj2));
                        }
                        i4++;
                    }
                }
            }
        }
        this.f73997a.b().t(new zzkc(this, str, str2, j3, bundle2, z2, z3, z4, str3));
    }

    final void x0() {
        zzoh zzohVar;
        h();
        this.f74147n = false;
        if (w0().isEmpty() || this.f74142i || (zzohVar = (zzoh) w0().poll()) == null) {
            return;
        }
        zzic zzicVar = this.f73997a;
        MeasurementManagerFutures measurementManagerFuturesH = zzicVar.C().H();
        if (measurementManagerFuturesH != null) {
            this.f74142i = true;
            zzgs zzgsVarW = zzicVar.a().w();
            String str = zzohVar.f74381a;
            zzgsVarW.b("Registering trigger URI", str);
            ListenableFuture listenableFutureD = measurementManagerFuturesH.d(Uri.parse(str));
            if (listenableFutureD != null) {
                Futures.a(listenableFutureD, new zzjw(this, zzohVar), new zzjv(this));
            } else {
                this.f74142i = false;
                w0().add(zzohVar);
            }
        }
    }

    public final void y(String str, String str2, Object obj, boolean z2) {
        z("auto", "_ldl", obj, true, this.f73997a.e().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(java.lang.String r17, java.lang.String r18, java.lang.Object r19, boolean r20, long r21) {
        /*
            r16 = this;
            r0 = r16
            r2 = r18
            r1 = r19
            r3 = 0
            r4 = 24
            if (r20 == 0) goto L17
            com.google.android.gms.measurement.internal.zzic r5 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpp r5 = r5.C()
            int r5 = r5.y0(r2)
        L15:
            r12 = r5
            goto L41
        L17:
            com.google.android.gms.measurement.internal.zzic r5 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpp r5 = r5.C()
            java.lang.String r6 = "user property"
            boolean r7 = r5.t0(r6, r2)
            r8 = 6
            if (r7 != 0) goto L28
        L26:
            r12 = r8
            goto L41
        L28:
            java.lang.String[] r7 = com.google.android.gms.measurement.internal.zzjo.f74026a
            r9 = 0
            boolean r7 = r5.v0(r6, r7, r9, r2)
            if (r7 != 0) goto L34
            r5 = 15
            goto L15
        L34:
            com.google.android.gms.measurement.internal.zzic r7 = r5.f73997a
            r7.w()
            boolean r5 = r5.w0(r6, r4, r2)
            if (r5 != 0) goto L40
            goto L26
        L40:
            r12 = r3
        L41:
            r5 = 1
            if (r12 == 0) goto L67
            com.google.android.gms.measurement.internal.zzic r1 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpp r6 = r1.C()
            r1.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            if (r2 == 0) goto L57
            int r3 = r2.length()
        L57:
            r15 = r3
            com.google.android.gms.measurement.internal.zzic r1 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpo r10 = r0.f74156w
            com.google.android.gms.measurement.internal.zzpp r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        L67:
            if (r17 != 0) goto L6c
            java.lang.String r6 = "app"
            goto L6e
        L6c:
            r6 = r17
        L6e:
            if (r1 == 0) goto Lbb
            com.google.android.gms.measurement.internal.zzic r7 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpp r8 = r7.C()
            int r12 = r8.y(r2, r1)
            if (r12 == 0) goto Laa
            com.google.android.gms.measurement.internal.zzpp r6 = r7.C()
            r7.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L92
            boolean r2 = r1 instanceof java.lang.CharSequence
            if (r2 == 0) goto L90
            goto L92
        L90:
            r15 = r3
            goto L9b
        L92:
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            goto L90
        L9b:
            com.google.android.gms.measurement.internal.zzic r1 = r0.f73997a
            com.google.android.gms.measurement.internal.zzpo r10 = r0.f74156w
            com.google.android.gms.measurement.internal.zzpp r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        Laa:
            com.google.android.gms.measurement.internal.zzpp r3 = r7.C()
            java.lang.Object r5 = r3.z(r2, r1)
            if (r5 == 0) goto Lba
            r3 = r21
            r1 = r6
            r0.A(r1, r2, r3, r5)
        Lba:
            return
        Lbb:
            r1 = r6
            r5 = 0
            r0 = r16
            r2 = r18
            r3 = r21
            r0.A(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.z(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }
}
