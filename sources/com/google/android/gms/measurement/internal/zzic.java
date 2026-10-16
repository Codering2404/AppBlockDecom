package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzic implements zzjg {
    private static volatile zzic E;
    private int A;
    private int B;
    final long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f73886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f73887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzae f73888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzal f73889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzhh f73890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzgu f73891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzhz f73892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzoc f73893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzpp f73894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzgn f73895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Clock f73896k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzmb f73897l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzlj f73898m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzd f73899n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final zzlo f73900o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f73901p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private zzgl f73902q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private zznl f73903r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private zzba f73904s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private zzgi f73905t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private zzlq f73906u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Boolean f73908w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f73909x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile Boolean f73910y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile boolean f73911z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f73907v = false;
    private final AtomicInteger C = new AtomicInteger(0);

    zzic(zzjs zzjsVar) {
        Preconditions.m(zzjsVar);
        Context context = zzjsVar.f74029a;
        zzae zzaeVar = new zzae(context);
        this.f73888c = zzaeVar;
        zzfr.f73606a = zzaeVar;
        this.f73886a = context;
        this.f73887b = zzjsVar.f74033e;
        this.f73910y = zzjsVar.f74030b;
        this.f73901p = zzjsVar.f74035g;
        this.f73911z = true;
        com.google.android.gms.internal.measurement.zzkm.zzb(context);
        Clock clockC = DefaultClock.c();
        this.f73896k = clockC;
        Long l3 = zzjsVar.f74034f;
        this.D = l3 != null ? l3.longValue() : clockC.currentTimeMillis();
        this.f73889d = new zzal(this);
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.m();
        this.f73890e = zzhhVar;
        zzgu zzguVar = new zzgu(this);
        zzguVar.m();
        this.f73891f = zzguVar;
        zzpp zzppVar = new zzpp(this);
        zzppVar.m();
        this.f73894i = zzppVar;
        this.f73895j = new zzgn(new zzjr(zzjsVar, this));
        this.f73899n = new zzd(this);
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.k();
        this.f73897l = zzmbVar;
        zzlj zzljVar = new zzlj(this);
        zzljVar.k();
        this.f73898m = zzljVar;
        zzoc zzocVar = new zzoc(this);
        zzocVar.k();
        this.f73893h = zzocVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.m();
        this.f73900o = zzloVar;
        zzhz zzhzVar = new zzhz(this);
        zzhzVar.m();
        this.f73892g = zzhzVar;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzjsVar.f74032d;
        boolean z2 = zzddVar == null || zzddVar.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            t(zzljVar);
            if (zzljVar.f73997a.f73886a.getApplicationContext() instanceof Application) {
                Application application = (Application) zzljVar.f73997a.f73886a.getApplicationContext();
                if (zzljVar.f74136c == null) {
                    zzljVar.f74136c = new zzky(zzljVar);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzljVar.f74136c);
                    application.registerActivityLifecycleCallbacks(zzljVar.f74136c);
                    zzgu zzguVar2 = zzljVar.f73997a.f73891f;
                    u(zzguVar2);
                    zzguVar2.w().a("Registered activity lifecycle callback");
                }
            }
        } else {
            u(zzguVar);
            zzguVar.r().a("Application context is not an Application");
        }
        zzhzVar.t(new zzia(this, zzjsVar));
    }

    public static zzic O(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l3) {
        Bundle bundle;
        if (zzddVar != null) {
            Bundle bundle2 = zzddVar.zzd;
            zzddVar = new com.google.android.gms.internal.measurement.zzdd(zzddVar.zza, zzddVar.zzb, zzddVar.zzc, bundle2, null);
        }
        Preconditions.m(context);
        Preconditions.m(context.getApplicationContext());
        if (E == null) {
            synchronized (zzic.class) {
                try {
                    if (E == null) {
                        E = new zzic(new zzjs(context, zzddVar, l3));
                    }
                } finally {
                }
            }
        } else if (zzddVar != null && (bundle = zzddVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.m(E);
            E.f73910y = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.m(E);
        return E;
    }

    static final void q() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void r(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void s(zzje zzjeVar) {
        if (zzjeVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void t(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzgVar.i()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgVar.getClass())));
        }
    }

    private static final void u(zzjf zzjfVar) {
        if (zzjfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzjfVar.k()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzjfVar.getClass())));
        }
    }

    final zzhz A() {
        return this.f73892g;
    }

    public final zzlj B() {
        zzlj zzljVar = this.f73898m;
        t(zzljVar);
        return zzljVar;
    }

    public final zzpp C() {
        zzpp zzppVar = this.f73894i;
        s(zzppVar);
        return zzppVar;
    }

    public final zzgn D() {
        return this.f73895j;
    }

    public final zzgl E() {
        t(this.f73902q);
        return this.f73902q;
    }

    public final zzlo F() {
        zzlo zzloVar = this.f73900o;
        u(zzloVar);
        return zzloVar;
    }

    public final boolean G() {
        return this.f73887b;
    }

    public final String H() {
        return this.f73901p;
    }

    public final zzmb I() {
        zzmb zzmbVar = this.f73897l;
        t(zzmbVar);
        return zzmbVar;
    }

    public final zznl J() {
        t(this.f73903r);
        return this.f73903r;
    }

    public final zzba K() {
        u(this.f73904s);
        return this.f73904s;
    }

    public final zzgi L() {
        t(this.f73905t);
        return this.f73905t;
    }

    public final zzd M() {
        zzd zzdVar = this.f73899n;
        r(zzdVar);
        return zzdVar;
    }

    public final zzlq N() {
        r(this.f73906u);
        return this.f73906u;
    }

    final void P(boolean z2) {
        this.f73910y = Boolean.valueOf(z2);
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu a() {
        zzgu zzguVar = this.f73891f;
        u(zzguVar);
        return zzguVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz b() {
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        return zzhzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae c() {
        return this.f73888c;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context d() {
        return this.f73886a;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock e() {
        return this.f73896k;
    }

    public final boolean f() {
        return this.f73910y != null && this.f73910y.booleanValue();
    }

    public final boolean g() {
        return h() == 0;
    }

    public final int h() {
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        zzhzVar.h();
        zzal zzalVar = this.f73889d;
        if (zzalVar.L()) {
            return 1;
        }
        u(zzhzVar);
        zzhzVar.h();
        if (!this.f73911z) {
            return 8;
        }
        zzhh zzhhVar = this.f73890e;
        s(zzhhVar);
        Boolean boolT = zzhhVar.t();
        if (boolT != null) {
            return boolT.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = zzalVar.f73997a.f73888c;
        Boolean boolJ = zzalVar.J("firebase_analytics_collection_enabled");
        return boolJ != null ? boolJ.booleanValue() ? 0 : 4 : (this.f73910y == null || this.f73910y.booleanValue()) ? 0 : 7;
    }

    public final void i(boolean z2) {
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        zzhzVar.h();
        this.f73911z = z2;
    }

    public final boolean j() {
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        zzhzVar.h();
        return this.f73911z;
    }

    final void k() {
        this.A++;
    }

    final void l() {
        this.C.incrementAndGet();
    }

    protected final boolean m() {
        if (!this.f73907v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        zzhzVar.h();
        Boolean bool = this.f73908w;
        if (bool == null || this.f73909x == 0 || (!bool.booleanValue() && Math.abs(this.f73896k.a() - this.f73909x) > 1000)) {
            this.f73909x = this.f73896k.a();
            zzpp zzppVar = this.f73894i;
            s(zzppVar);
            boolean z2 = false;
            if (zzppVar.M("android.permission.INTERNET")) {
                s(zzppVar);
                if (zzppVar.M("android.permission.ACCESS_NETWORK_STATE")) {
                    Context context = this.f73886a;
                    if (Wrappers.a(context).g() || this.f73889d.m() || (zzpp.j0(context) && zzpp.E(context, false))) {
                        z2 = true;
                    }
                }
            }
            Boolean boolValueOf = Boolean.valueOf(z2);
            this.f73908w = boolValueOf;
            if (boolValueOf.booleanValue()) {
                s(zzppVar);
                this.f73908w = Boolean.valueOf(zzppVar.o(L().r()));
            }
        }
        return this.f73908w.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean n() {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzic.n():boolean");
    }

    final /* synthetic */ void o(String str, int i3, Throwable th, byte[] bArr, Map map) {
        int i4;
        if (i3 != 200 && i3 != 204) {
            i4 = RCHTTPStatusCodes.NOT_MODIFIED;
            if (i3 != 304) {
                i4 = i3;
            }
            zzgu zzguVar = this.f73891f;
            u(zzguVar);
            zzguVar.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i4), th);
        }
        i4 = i3;
        if (th == null) {
            zzhh zzhhVar = this.f73890e;
            s(zzhhVar);
            zzhhVar.f73827u.b(true);
            if (bArr == null || bArr.length == 0) {
                zzgu zzguVar2 = this.f73891f;
                u(zzguVar2);
                zzguVar2.v().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
                if (TextUtils.isEmpty(strOptString)) {
                    zzgu zzguVar3 = this.f73891f;
                    u(zzguVar3);
                    zzguVar3.v().a("Deferred Deep Link is empty.");
                    return;
                }
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                String strOptString4 = jSONObject.optString("gad_source", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                zzpp zzppVar = this.f73894i;
                s(zzppVar);
                zzic zzicVar = zzppVar.f73997a;
                if (!TextUtils.isEmpty(strOptString)) {
                    Context context = zzicVar.f73886a;
                    List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                    if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(strOptString3)) {
                            bundle.putString("gbraid", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            bundle.putString("gad_source", strOptString4);
                        }
                        bundle.putString("gclid", strOptString2);
                        bundle.putString("_cis", "ddp");
                        this.f73898m.t("auto", "_cmp", bundle);
                        s(zzppVar);
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            editorEdit.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, strOptString);
                            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                            if (editorEdit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzppVar.f73997a.f73886a;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                } else {
                                    context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                    return;
                                }
                            }
                            return;
                        } catch (RuntimeException e3) {
                            zzgu zzguVar4 = zzppVar.f73997a.f73891f;
                            u(zzguVar4);
                            zzguVar4.o().b("Failed to persist Deferred Deep Link. exception", e3);
                            return;
                        }
                    }
                }
                zzgu zzguVar5 = this.f73891f;
                u(zzguVar5);
                zzguVar5.r().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            } catch (JSONException e4) {
                zzgu zzguVar6 = this.f73891f;
                u(zzguVar6);
                zzguVar6.o().b("Failed to parse the Deferred Deep Link response. exception", e4);
                return;
            }
        }
        zzgu zzguVar7 = this.f73891f;
        u(zzguVar7);
        zzguVar7.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i4), th);
    }

    final /* synthetic */ void p(zzjs zzjsVar) {
        zzhz zzhzVar = this.f73892g;
        u(zzhzVar);
        zzhzVar.h();
        zzal zzalVar = this.f73889d;
        zzalVar.u();
        zzba zzbaVar = new zzba(this);
        zzbaVar.m();
        this.f73904s = zzbaVar;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzjsVar.f74032d;
        zzgi zzgiVar = new zzgi(this, zzjsVar.f74031c, zzddVar == null ? 0L : zzddVar.zza);
        zzgiVar.k();
        this.f73905t = zzgiVar;
        zzgl zzglVar = new zzgl(this);
        zzglVar.k();
        this.f73902q = zzglVar;
        zznl zznlVar = new zznl(this);
        zznlVar.k();
        this.f73903r = zznlVar;
        zzpp zzppVar = this.f73894i;
        zzppVar.n();
        this.f73890e.n();
        this.f73905t.l();
        zzlq zzlqVar = new zzlq(this);
        zzlqVar.k();
        this.f73906u = zzlqVar;
        zzlqVar.l();
        zzgu zzguVar = this.f73891f;
        u(zzguVar);
        zzgs zzgsVarU = zzguVar.u();
        zzalVar.A();
        zzgsVarU.b("App measurement initialized, version", 133005L);
        u(zzguVar);
        zzguVar.u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strQ = zzgiVar.q();
        s(zzppVar);
        if (zzppVar.P(strQ, zzalVar.R())) {
            u(zzguVar);
            zzguVar.u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            u(zzguVar);
            zzguVar.u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strQ)));
        }
        u(zzguVar);
        zzguVar.v().a("Debug-level message logging enabled");
        int i3 = this.A;
        AtomicInteger atomicInteger = this.C;
        if (i3 != atomicInteger.get()) {
            u(zzguVar);
            zzguVar.o().c("Not all components initialized", Integer.valueOf(this.A), Integer.valueOf(atomicInteger.get()));
        }
        this.f73907v = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void v(com.google.android.gms.internal.measurement.zzdd r14) {
        /*
            Method dump skipped, instruction units count: 1043
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzic.v(com.google.android.gms.internal.measurement.zzdd):void");
    }

    public final zzal w() {
        return this.f73889d;
    }

    public final zzhh x() {
        zzhh zzhhVar = this.f73890e;
        s(zzhhVar);
        return zzhhVar;
    }

    public final zzgu y() {
        zzgu zzguVar = this.f73891f;
        if (zzguVar == null || !zzguVar.k()) {
            return null;
        }
        return zzguVar;
    }

    public final zzoc z() {
        zzoc zzocVar = this.f73893h;
        t(zzocVar);
        return zzocVar;
    }
}
