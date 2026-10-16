package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.d4;
import com.applovin.impl.je;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class te implements d4.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference f63929m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f63930n = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f63931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f63932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f63933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final se f63934d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f63937h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f63939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map f63940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final y0 f63941l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f63935f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f63936g = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f63938i = 2;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends p {
        a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started mediation debugger");
                if (!te.this.c() || te.f63929m.get() != activity) {
                    MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                    WeakReference unused = te.f63929m = new WeakReference(maxDebuggerActivity);
                    maxDebuggerActivity.setListAdapter(te.this.f63934d, te.this.f63931a.e());
                }
                te.f63930n.set(false);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Mediation debugger destroyed");
                WeakReference unused = te.f63929m = null;
            }
        }
    }

    public te(com.applovin.impl.sdk.j jVar) {
        this.f63931a = jVar;
        this.f63932b = jVar.I();
        Context contextM = com.applovin.impl.sdk.j.m();
        this.f63933c = contextM;
        se seVar = new se(contextM);
        this.f63934d = seVar;
        this.f63941l = new y0(jVar, seVar);
    }

    private void f() {
        this.f63931a.e().a(new a());
    }

    public void e() {
        if (this.f63936g.compareAndSet(false, true)) {
            this.f63931a.i0().a((yl) new mm(this, this.f63931a), tm.b.OTHER);
        }
    }

    public boolean g() {
        return this.f63937h;
    }

    public void h() {
        a((Map) null);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f63934d + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        WeakReference weakReference = f63929m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Activity activityM0 = this.f63931a.m0();
        if (activityM0 == null || activityM0.isFinishing()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
        } else {
            new AlertDialog.Builder(activityM0).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.t50
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f63878a.a(dialogInterface, i3);
                }
            }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    private List a(JSONObject jSONObject, List list, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new z(jSONObject2, this.f63935f, jVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public List a(String str) {
        Map map = this.f63940k;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (List) this.f63940k.get(str);
    }

    private List a(List list, com.applovin.impl.sdk.j jVar) {
        List<String> adUnitIds;
        if (jVar.x0().get()) {
            adUnitIds = jVar.f0().getInitializationAdUnitIds();
        } else {
            adUnitIds = jVar.G() != null ? jVar.G().getAdUnitIds() : null;
        }
        if (adUnitIds != null && !adUnitIds.isEmpty()) {
            ArrayList arrayList = new ArrayList(adUnitIds.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                z zVar = (z) it.next();
                if (adUnitIds.contains(zVar.c())) {
                    arrayList.add(zVar);
                }
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null) {
                je jeVar = new je(jSONObject2, jVar);
                arrayList.add(jeVar);
                this.f63935f.put(jeVar.b(), jeVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : JsonUtils.getList(jSONObject, "required_app_ads_txt_entries", new ArrayList())) {
            x0 x0Var = new x0(str);
            if (x0Var.h()) {
                arrayList.add(x0Var);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f63932b.b("MediationDebuggerService", "app-ads.txt entry passed down for validation is misformatted: " + str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i3) {
        h();
    }

    private void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            je jeVar = (je) it.next();
            if (jeVar.A() && jeVar.q() == je.a.INVALID_INTEGRATION) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.s50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62996a.d();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
                return;
            }
        }
    }

    @Override // com.applovin.impl.d4.e
    public void a(String str, JSONObject jSONObject, int i3) {
        List listA = a(jSONObject, this.f63931a);
        List listA2 = a(jSONObject, listA, this.f63931a);
        List listA3 = a(listA2, this.f63931a);
        List listA4 = a(jSONObject);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        this.f63934d.a(listA, listA2, listA3, listA4, JsonUtils.getString(jSONObject2, "title", null), JsonUtils.getString(jSONObject2, "message", null), JsonUtils.getString(jSONObject, "account_id", null), JsonUtils.getBoolean(jSONObject, "complies_with_google_families_policy", null), JsonUtils.getBoolean(jSONObject, "should_display_cmp_details", Boolean.TRUE).booleanValue(), this.f63931a);
        if (!listA4.isEmpty()) {
            this.f63941l.a();
        }
        if (g()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.r50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62793a.h();
                }
            }, TimeUnit.SECONDS.toMillis(this.f63938i));
        } else {
            a(listA);
        }
    }

    public void a(boolean z2, int i3) {
        this.f63937h = z2;
        this.f63938i = i3;
    }

    public void a(Map map) {
        this.f63940k = map;
        e();
        if (!c() && f63930n.compareAndSet(false, true)) {
            if (!this.f63939j) {
                f();
                this.f63939j = true;
            }
            Intent intent = new Intent(this.f63933c, (Class<?>) MaxDebuggerActivity.class);
            intent.setFlags(268435456);
            com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting mediation debugger...");
            this.f63933c.startActivity(intent);
            return;
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation debugger is already showing");
    }

    @Override // com.applovin.impl.d4.e
    public void a(String str, int i3, String str2, JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f63932b.b("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i3);
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Unable to show mediation debugger.");
        this.f63934d.a(null, null, null, null, null, null, null, null, false, this.f63931a);
        this.f63936g.set(false);
    }
}
