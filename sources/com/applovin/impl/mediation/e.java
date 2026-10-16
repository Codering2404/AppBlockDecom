package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.am;
import com.applovin.impl.an;
import com.applovin.impl.fi;
import com.applovin.impl.ka;
import com.applovin.impl.la;
import com.applovin.impl.oe;
import com.applovin.impl.p6;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.uj;
import com.applovin.mediation.adapter.MaxAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f61707c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f61708d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f61709e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JSONArray f61710f = new JSONArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedHashMap f61711g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f61712h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f61713i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f61714j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f61715k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f61716l;

    public e(com.applovin.impl.sdk.j jVar) {
        this.f61705a = jVar;
        this.f61706b = jVar.I();
    }

    private void c(oe oeVar) {
        String strB = oeVar.b();
        synchronized (this.f61709e) {
            try {
                if (this.f61708d.contains(strB)) {
                    return;
                }
                this.f61708d.add(strB);
                this.f61705a.D().a(ka.f60970w, la.a(oeVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void a(oe oeVar, long j3, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean zB;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.f61712h) {
            try {
                zB = b(oeVar);
                if (!zB) {
                    this.f61711g.put(oeVar.b(), Integer.valueOf(initializationStatus.getCode()));
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, "class", oeVar.b());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putLong(jSONObject, "init_time_ms", j3);
                    JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                    this.f61710f.put(jSONObject);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zB) {
            return;
        }
        this.f61705a.a(oeVar);
        this.f61705a.P().processAdapterInitializationPostback(oeVar, j3, initializationStatus, str);
        this.f61705a.q().a(initializationStatus, oeVar.b());
    }

    public void b(oe oeVar, Activity activity) {
        List list;
        if (((Boolean) this.f61705a.a(ue.J7)).booleanValue()) {
            a(oeVar, activity);
            return;
        }
        if (((Boolean) this.f61705a.a(ue.I7)).booleanValue()) {
            oe oeVar2 = (oe) this.f61713i.get(oeVar.b());
            if (oeVar2 != null) {
                oeVar = oeVar2;
            }
        } else {
            if (this.f61705a.k0().c() && (list = this.f61716l) != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        oeVar = null;
                        break;
                    }
                    oe oeVar3 = (oe) it.next();
                    if (oeVar3.b().equals(oeVar.b())) {
                        oeVar = oeVar3;
                        break;
                    }
                }
            }
            if (oeVar == null) {
                return;
            }
        }
        g gVarA = this.f61705a.L().a(oeVar);
        if (gVarA == null) {
            com.applovin.impl.sdk.n.h("MediationAdapterInitializationManager", "Mediation adapter could not be initialized, double check that the adapter is included in your build. Adapter spec: " + oeVar);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61706b.d("MediationAdapterInitializationManager", "Initializing adapter " + oeVar);
        }
        c(oeVar);
        gVarA.a(MaxAdapterParametersImpl.a(oeVar), activity, (MaxAdapter.OnCompletionListener) null);
    }

    public boolean c() {
        return this.f61707c.get();
    }

    boolean b(oe oeVar) {
        boolean zContainsKey;
        synchronized (this.f61712h) {
            zContainsKey = this.f61711g.containsKey(oeVar.b());
        }
        return zContainsKey;
    }

    private oe a(oe oeVar) {
        List<oe> list;
        if (((Boolean) this.f61705a.a(ue.I7)).booleanValue()) {
            oe oeVar2 = (oe) this.f61713i.get(oeVar.b());
            return oeVar2 != null ? oeVar2 : oeVar;
        }
        if (!this.f61705a.k0().c() || (list = this.f61716l) == null) {
            return oeVar;
        }
        for (oe oeVar3 : list) {
            if (oeVar3.b().equals(oeVar.b())) {
                return oeVar3;
            }
        }
        return null;
    }

    public JSONArray b() {
        JSONArray jSONArrayShallowCopy;
        synchronized (this.f61712h) {
            jSONArrayShallowCopy = JsonUtils.shallowCopy(this.f61710f);
        }
        return jSONArrayShallowCopy;
    }

    public fi a(oe oeVar, Activity activity) {
        oe oeVarA = a(oeVar);
        if (oeVarA == null) {
            return fi.a("AdapterInitialization:" + oeVar.c(), MaxAdapter.InitializationStatus.DOES_NOT_APPLY);
        }
        String strB = oeVar.b();
        synchronized (this.f61715k) {
            try {
                fi fiVar = (fi) this.f61714j.get(strB);
                if (fiVar == null || (fiVar.d() && oeVarA.q())) {
                    final fi fiVar2 = new fi("AdapterInitialization:" + oeVar.c());
                    this.f61714j.put(strB, fiVar2);
                    g gVarA = this.f61705a.L().a(oeVarA);
                    if (gVarA == null) {
                        fiVar2.a("Adapter implementation not found");
                        return fiVar2;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61706b.d("MediationAdapterInitializationManager", "Initializing adapter " + oeVarA);
                    }
                    c(oeVarA);
                    gVarA.a(MaxAdapterParametersImpl.a(oeVarA), activity, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.t
                        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                        public final void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
                            e.a(fiVar2, initializationStatus, str);
                        }
                    });
                    an.a(oeVarA.m(), fiVar2, "The adapter (" + oeVar.c() + ") timed out initializing", "MediationAdapterInitializationManager", this.f61705a);
                    return fiVar2;
                }
                return fiVar;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(fi fiVar, MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            if (initializationStatus == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE) {
                fiVar.a(str);
                return;
            } else {
                fiVar.b(initializationStatus);
                return;
            }
        }
        p6.a("Adapters should never report a null or INITIALIZING status.", new Object[0]);
        fiVar.a("Adapter reported INITIALIZING");
    }

    public void a(Activity activity) {
        if (this.f61707c.compareAndSet(false, true)) {
            String str = (String) this.f61705a.a(uj.G);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<oe> listA = a(JsonUtils.getJSONArray(jSONObject, this.f61705a.k0().c() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.f61716l = listA;
                    for (oe oeVar : listA) {
                        this.f61713i.put(oeVar.b(), oeVar);
                    }
                    long j3 = StringUtils.parseLong(this.f61705a.f0().getExtraParameters().get("adapter_initialization_delay_ms"), -1L);
                    am amVar = new am(listA, activity, this.f61705a);
                    if (j3 > 0) {
                        this.f61705a.i0().a(amVar, tm.b.MEDIATION, j3);
                    } else {
                        this.f61705a.i0().a(amVar);
                    }
                } catch (JSONException e3) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61706b.a("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e3);
                    }
                    p6.a((Throwable) e3);
                }
            }
        }
    }

    public Integer a(String str) {
        Integer num;
        synchronized (this.f61712h) {
            num = (Integer) this.f61711g.get(str);
        }
        return num;
    }

    public Set a() {
        HashSet hashSet;
        synchronized (this.f61712h) {
            hashSet = new HashSet(this.f61711g.keySet());
        }
        return hashSet;
    }

    private List a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(new oe(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jSONObject, this.f61705a));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.f61712h) {
            this.f61711g.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.f61705a.q().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
