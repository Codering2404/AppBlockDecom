package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.fc;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f63513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f63514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f63515d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f63516f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f63517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f63518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f63519i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AppLovinPostbackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f63520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinPostbackListener f63521b;

        a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
            this.f63520a = dVar;
            this.f63521b = appLovinPostbackListener;
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i3) {
            n unused = b.this.f63513b;
            if (n.a()) {
                b.this.f63513b.d("PersistentPostbackManager", "Failed to submit postback: " + this.f63520a + " with error code: " + i3 + "; will retry later...");
            }
            b.this.d(this.f63520a);
            fc.a(this.f63521b, str, i3);
            if (this.f63520a.c() == 1) {
                b.this.f63512a.D().a("dispatchPostback", str, i3);
            }
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            b.this.a(this.f63520a);
            n unused = b.this.f63513b;
            if (n.a()) {
                b.this.f63513b.a("PersistentPostbackManager", "Successfully submit postback: " + this.f63520a);
            }
            b.this.c();
            fc.a(this.f63521b, str);
        }
    }

    public b(j jVar) {
        ArrayList arrayList = new ArrayList();
        this.f63517g = arrayList;
        this.f63518h = new HashSet();
        this.f63519i = new ArrayList();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f63512a = jVar;
        this.f63513b = jVar.I();
        int iIntValue = ((Integer) jVar.a(sj.M2)).intValue();
        this.f63514c = iIntValue;
        if (!((Boolean) jVar.a(sj.P2)).booleanValue()) {
            this.f63515d = null;
            return;
        }
        c cVar = new c(this, jVar);
        this.f63515d = cVar;
        if (yp.a(sj.S0, jVar) && yp.h()) {
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63561a.f();
                }
            }, true, true);
        } else {
            arrayList.addAll(cVar.a(iIntValue));
        }
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        this.f63512a.i0().a((yl) this.f63515d, tm.b.OTHER);
    }

    private void c(d dVar) {
        synchronized (this.f63516f) {
            while (this.f63517g.size() > this.f63514c) {
                try {
                    this.f63517g.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f63517g.add(dVar);
        }
        if (n.a()) {
            this.f63513b.a("PersistentPostbackManager", "Enqueued postback: " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        synchronized (this.f63516f) {
            this.f63517g.addAll(0, this.f63515d.a(this.f63514c));
        }
    }

    protected List d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f63516f) {
            try {
                if (((Boolean) this.f63512a.a(sj.O2)).booleanValue()) {
                    arrayList.ensureCapacity(this.f63519i.size());
                    arrayList.addAll(this.f63519i);
                } else {
                    arrayList.ensureCapacity(this.f63517g.size());
                    arrayList.addAll(this.f63517g);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void e(d dVar) {
        a(dVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.f63516f) {
            c(dVar);
            a(dVar, appLovinPostbackListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        synchronized (this.f63516f) {
            try {
                ArrayList arrayList = new ArrayList(this.f63517g);
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    b((d) obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(d dVar, boolean z2) {
        a(dVar, z2, (AppLovinPostbackListener) null);
    }

    public void a(final d dVar, boolean z2, final AppLovinPostbackListener appLovinPostbackListener) {
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f63513b.b("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
            }
        } else {
            if (z2) {
                dVar.a();
            }
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63557a.b(dVar, appLovinPostbackListener);
                }
            }, yp.h(), dVar.m());
        }
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.sdk.network.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f63560a.e();
            }
        }, true, false);
    }

    private void b(d dVar) {
        a(dVar, (AppLovinPostbackListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f63516f) {
            try {
                Iterator it = this.f63519i.iterator();
                while (it.hasNext()) {
                    b((d) it.next());
                }
                this.f63519i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        synchronized (this.f63516f) {
            this.f63517g.clear();
            this.f63519i.clear();
        }
        this.f63512a.i0().a((yl) this.f63515d, tm.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar) {
        synchronized (this.f63516f) {
            this.f63518h.remove(dVar);
            this.f63519i.add(dVar);
        }
    }

    private void a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        if (n.a()) {
            this.f63513b.a("PersistentPostbackManager", "Preparing to submit postback: " + dVar);
        }
        if (this.f63512a.v0() && !dVar.m()) {
            if (n.a()) {
                this.f63513b.a("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f63513b.b("PersistentPostbackManager", "Skipping empty postback dispatch...");
                return;
            }
            return;
        }
        synchronized (this.f63516f) {
            try {
                if (this.f63518h.contains(dVar)) {
                    if (n.a()) {
                        this.f63513b.a("PersistentPostbackManager", "Skipping in progress postback: " + dVar.k());
                    }
                    return;
                }
                dVar.l();
                Integer num = (Integer) this.f63512a.a(sj.L2);
                if (dVar.c() > num.intValue()) {
                    if (n.a()) {
                        this.f63513b.k("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + num + ". Dequeuing postback: " + dVar);
                    }
                    a(dVar);
                    return;
                }
                synchronized (this.f63516f) {
                    this.f63518h.add(dVar);
                }
                e eVarB = e.b(this.f63512a).b(dVar.k()).a(dVar.d()).b(dVar.i()).c(dVar.h()).a(dVar.g()).a(dVar.j() != null ? new JSONObject(dVar.j()) : null).b(dVar.o()).a(dVar.n()).a(dVar.f()).h(dVar.p()).e(dVar.e()).a();
                if (n.a()) {
                    this.f63513b.a("PersistentPostbackManager", "Submitting postback: " + dVar);
                }
                this.f63512a.X().dispatchPostbackRequest(eVarB, new a(dVar, appLovinPostbackListener));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        synchronized (this.f63516f) {
            this.f63518h.remove(dVar);
            this.f63517g.remove(dVar);
        }
        if (n.a()) {
            this.f63513b.a("PersistentPostbackManager", "Dequeued postback: " + dVar);
        }
    }

    private void a(Runnable runnable, boolean z2, boolean z3) {
        if (z2) {
            this.f63512a.i0().a((yl) new jn(this.f63512a, z3, "runPostbackTask", runnable), tm.b.OTHER);
        } else {
            runnable.run();
        }
    }
}
