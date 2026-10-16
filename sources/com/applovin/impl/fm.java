package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import com.applovin.impl.yj;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class fm extends yl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static JSONObject f59716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f59717n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Map f59718o = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f59719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f59720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f59721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f59722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f59723l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(JSONArray jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class c implements yj.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f59724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f59725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f59726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f59727d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Collection f59728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f59729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f59730h;

        private c(int i3, b bVar, com.applovin.impl.sdk.j jVar) {
            this.f59726c = i3;
            this.f59724a = bVar;
            this.f59729g = jVar;
            this.f59730h = jVar.I();
            this.f59725b = new Object();
            this.f59728f = new ArrayList(i3);
            this.f59727d = new AtomicBoolean();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f59727d.compareAndSet(false, true)) {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            ArrayList arrayList;
            synchronized (this.f59725b) {
                arrayList = new ArrayList(this.f59728f);
            }
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                yj yjVar = (yj) obj;
                try {
                    JSONObject jSONObject = new JSONObject();
                    zj zjVarF = yjVar.f();
                    jSONObject.put("name", zjVarF.c());
                    jSONObject.put("class", zjVarF.b());
                    jSONObject.put("adapter_version", yjVar.a());
                    jSONObject.put("sdk_version", yjVar.d());
                    JSONObject jSONObject2 = new JSONObject();
                    MaxError maxErrorC = yjVar.c();
                    if (maxErrorC != null) {
                        jSONObject2.put("error_message", maxErrorC.getMessage());
                    } else {
                        jSONObject2.put("signal", yjVar.e());
                    }
                    jSONObject2.put("signal_collection_time_ms", yjVar.b());
                    jSONObject2.put("is_cached", yjVar.g());
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f59730h.a("TaskCollectSignals", "Collected signal from " + zjVarF);
                    }
                } catch (JSONException e3) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f59730h.a("TaskCollectSignals", "Failed to create signal data", e3);
                    }
                    this.f59729g.D().a("TaskCollectSignals", "createSignalsData", e3);
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            b bVar = this.f59724a;
            if (bVar != null) {
                bVar.a(jSONArray);
            }
        }

        @Override // com.applovin.impl.yj.a
        public void a(yj yjVar) {
            boolean z2;
            synchronized (this.f59725b) {
                this.f59728f.add(yjVar);
                int i3 = this.f59726c - 1;
                this.f59726c = i3;
                z2 = i3 < 1;
            }
            if (z2 && this.f59727d.compareAndSet(false, true)) {
                if (yp.h() && ((Boolean) this.f59729g.a(sj.R)).booleanValue()) {
                    this.f59729g.i0().a((yl) new jn(this.f59729g, "handleSignalCollectionCompleted", new Runnable() { // from class: com.applovin.impl.bx
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f58786a.a();
                        }
                    }), tm.b.MEDIATION);
                } else {
                    a();
                }
            }
        }
    }

    public fm(String str, MaxAdFormat maxAdFormat, Map map, Context context, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskCollectSignals", jVar);
        this.f59719h = str;
        this.f59720i = maxAdFormat;
        this.f59721j = map;
        this.f59722k = context;
        this.f59723l = bVar;
    }

    private void a(final zj zjVar, final yj.a aVar) {
        if (zjVar.r()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ax
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58519a.b(zjVar, aVar);
                }
            });
        } else {
            this.f65231a.P().collectSignal(this.f59719h, this.f59720i, zjVar, this.f59722k, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(zj zjVar, yj.a aVar) {
        this.f65231a.P().collectSignal(this.f59719h, this.f59720i, zjVar, this.f59722k, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            synchronized (f59717n) {
                jSONArray = JsonUtils.getJSONArray(f59716m, "signal_providers", null);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                if (f59718o.size() > 0) {
                    b(jSONArray, f59716m);
                    return;
                } else {
                    a(jSONArray, f59716m);
                    return;
                }
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.k(this.f65232b, "Unable to find cached signal providers, fetching signal providers from SharedPreferences.");
            }
            JSONObject jSONObject = new JSONObject((String) this.f65231a.a(uj.F, JsonUtils.EMPTY_JSON));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                if (f59718o.size() > 0) {
                    b(jSONArray2, jSONObject);
                    return;
                } else {
                    a(jSONArray2, jSONObject);
                    return;
                }
            }
            a("No signal providers found", (Throwable) null);
        } catch (InterruptedException e3) {
            a("Failed to wait for signals", e3);
            this.f65231a.D().a("TaskCollectSignals", "waitForSignals", e3);
        } catch (JSONException e4) {
            a("Failed to parse signals JSON", e4);
            this.f65231a.D().a("TaskCollectSignals", "parseSignalsJSON", e4);
        } catch (Throwable th) {
            a("Failed to collect signals", th);
            this.f65231a.D().a("TaskCollectSignals", "collectSignals", th);
        }
    }

    private void b(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Set set = (Set) f59718o.get(this.f59719h);
        if (set == null || set.isEmpty()) {
            a("No signal providers found for ad unit: " + this.f59719h, (Throwable) null);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", null))) {
                jSONArray2.put(jSONObject2);
            }
        }
        a(jSONArray2, jSONObject);
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        c cVar = new c(jSONArray.length(), this.f59723l, this.f65231a);
        this.f65231a.i0().a(new jn(this.f65231a, "timeoutCollectSignal", cVar), tm.b.TIMEOUT, ((Long) this.f65231a.a(ue.M6)).longValue());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            a(new zj(this.f59721j, jSONArray.getJSONObject(i3), jSONObject, this.f65231a), cVar);
        }
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    f59718o.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, null)));
                }
            }
        } catch (JSONException e3) {
            com.applovin.impl.sdk.n.c("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e3);
            jVar.D().a("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e3);
        }
    }

    private void a(String str, Throwable th) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "No signals collected: " + str, th);
        }
        b bVar = this.f59723l;
        if (bVar != null) {
            bVar.a(new JSONArray());
        }
    }

    public static void a(JSONObject jSONObject) {
        synchronized (f59717n) {
            f59716m = jSONObject;
        }
    }
}
