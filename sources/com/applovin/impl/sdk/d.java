package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.p6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.uj;
import com.applovin.impl.yl;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f63257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f63258c = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(com.applovin.impl.sdk.ad.b bVar);
    }

    public d(j jVar) {
        this.f63256a = jVar;
        this.f63257b = new c(jVar);
    }

    private void e() {
        String str = (String) this.f63256a.h0().a(uj.C);
        if (str == null) {
            return;
        }
        JSONArray jsonArray = JsonUtils.toJsonArray(str, new JSONArray());
        for (int length = jsonArray.length() - 1; length >= 0; length--) {
            c.a aVarA = c.a.a(JsonUtils.getJSONObject(jsonArray, length, new JSONObject()), this.f63256a);
            if (aVarA != null) {
                if (a(aVarA)) {
                    long jB = aVarA.b() - SystemClock.elapsedRealtime();
                    this.f63256a.D().a(ka.f60969v, CollectionUtils.map("details", "ttl = " + jB + "ms"));
                } else {
                    this.f63258c.add(0, aVarA);
                }
            }
        }
    }

    private void f() {
        this.f63256a.i0().a((yl) new jn(this.f63256a, "loadPersistedAdFilesQueueAndCleanupAsync", new Runnable() { // from class: com.applovin.impl.sdk.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63271a.c();
            }
        }), tm.b.OTHER);
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f63258c) {
            try {
                Iterator it = this.f63258c.iterator();
                while (it.hasNext()) {
                    arrayList.add(((c.a) it.next()).a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f63256a.h0().b(uj.C, new JSONArray((Collection) arrayList).toString());
    }

    public void g() {
        this.f63256a.i0().a((yl) new jn(this.f63256a, "resetManagerState", new Runnable() { // from class: com.applovin.impl.sdk.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63281a.d();
            }
        }), tm.b.OTHER);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        h();
    }

    private void a(a aVar, c.a aVar2, com.applovin.impl.h0 h0Var, String str) {
        if (aVar == null) {
            return;
        }
        this.f63256a.I();
        if (n.a()) {
            this.f63256a.I().a("AdPersistenceManager", str);
        }
        aVar.a(null);
        this.f63257b.b(aVar2);
        this.f63256a.D().a(ka.f60968u, h0Var, new AppLovinError(-1, str));
    }

    private void c(c.a aVar) {
        if (aVar != null && this.f63258c.remove(aVar)) {
            this.f63257b.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f63256a.h0().b(uj.C);
        this.f63257b.a();
    }

    public void b() {
        f();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        e();
        a();
    }

    public void b(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f63256a.D().a(ka.f60963p, bVar);
        this.f63257b.b(bVar, new c.b() { // from class: com.applovin.impl.sdk.g0
            @Override // com.applovin.impl.sdk.c.b
            public final void a(c.a aVar) {
                this.f63308a.b(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(c.a aVar) {
        if (aVar == null) {
            this.f63256a.I();
            if (n.a()) {
                this.f63256a.I().a("AdPersistenceManager", "Ad failed to persist");
                return;
            }
            return;
        }
        this.f63258c.add(aVar);
        if (((Boolean) this.f63256a.a(sj.Z0)).booleanValue()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, c.a aVar2, com.applovin.impl.h0 h0Var, com.applovin.impl.sdk.ad.b bVar, String str) {
        if (bVar != null && !StringUtils.isValidString(str)) {
            a(aVar, bVar, aVar2);
        } else {
            a(aVar, aVar2, h0Var, str);
        }
    }

    public void a(final com.applovin.impl.h0 h0Var, final a aVar) {
        if (aVar == null) {
            this.f63256a.I();
            if (n.a()) {
                this.f63256a.I().b("AdPersistenceManager", "Persisted ad could not be retrieved: listener is null");
            }
            p6.a("Persisted ad could not be retrieved: listener is null", new Object[0]);
            return;
        }
        if (h0Var == null) {
            a(aVar, null, null, "Persisted ad could not be retrieved: adZone is null");
            return;
        }
        this.f63256a.D().a(ka.f60966s, h0Var, (AppLovinError) null);
        final c.a aVarA = a(h0Var.g());
        this.f63257b.a(aVarA, new c.InterfaceC0123c() { // from class: com.applovin.impl.sdk.d0
            @Override // com.applovin.impl.sdk.c.InterfaceC0123c
            public final void a(com.applovin.impl.sdk.ad.b bVar, String str) {
                this.f63259a.a(aVar, aVarA, h0Var, bVar, str);
            }
        });
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        c(c.a.a(bVar));
    }

    private c.a a(AppLovinAdType appLovinAdType) {
        c.a aVar;
        synchronized (this.f63258c) {
            try {
                Iterator it = this.f63258c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    aVar = (c.a) it.next();
                    if (aVar.e().equals(appLovinAdType) && !a(aVar)) {
                        break;
                    }
                }
                this.f63258c.remove(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, c.a aVar2) {
        if (aVar == null) {
            return;
        }
        this.f63256a.I();
        if (n.a()) {
            this.f63256a.I().a("AdPersistenceManager", "Loading persisted ad");
        }
        aVar.a(bVar);
        this.f63257b.b(aVar2);
        this.f63256a.D().a(ka.f60967t, bVar);
    }

    private boolean a(c.a aVar) {
        return SystemClock.elapsedRealtime() + ((Long) this.f63256a.a(sj.f63724b1)).longValue() >= aVar.b();
    }

    private void a() {
        synchronized (this.f63258c) {
            this.f63257b.a(new ArrayList(this.f63258c));
        }
    }
}
