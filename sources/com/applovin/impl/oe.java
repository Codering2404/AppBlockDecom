package com.applovin.impl;

import android.os.Bundle;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class oe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f62260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f62261b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f62263d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f62265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final tl f62266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final tl f62267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f62268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f62269k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f62262c = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Object f62264f = new Object();

    public oe(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.f62260a = jVar;
        if (((Boolean) jVar.a(sj.i6)).booleanValue()) {
            this.f62266h = new tl(jSONObject2);
            this.f62267i = new tl(jSONObject);
            this.f62261b = null;
            this.f62263d = null;
        } else {
            this.f62261b = jSONObject2;
            this.f62263d = jSONObject;
            this.f62266h = null;
            this.f62267i = null;
        }
        this.f62265g = map;
    }

    private int j() {
        return a("mute_state", b("mute_state", ((Integer) this.f62260a.a(ue.q7)).intValue()));
    }

    protected JSONObject a() {
        JSONObject jSONObject;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a();
        }
        synchronized (this.f62264f) {
            jSONObject = this.f62263d;
        }
        return jSONObject;
    }

    public String b() {
        return a("class", (String) null);
    }

    public String c() {
        return a("name", (String) null);
    }

    public String d() {
        return c("consent_string") ? a("consent_string", (String) null) : d("consent_string") ? b("consent_string", (String) null) : this.f62260a.j0().k();
    }

    public String e() {
        return this.f62269k;
    }

    public Bundle f() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), l());
    }

    public JSONObject g() {
        JSONObject jSONObject;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a();
        }
        synchronized (this.f62262c) {
            jSONObject = this.f62261b;
        }
        return jSONObject;
    }

    public String getAdUnitId() {
        return b("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.f62268j;
    }

    public long h() {
        return a("init_completion_delay_ms", -1L);
    }

    public String k() {
        return c().split("_")[0];
    }

    public Bundle l() {
        Bundle bundle;
        if (e("server_parameters") instanceof JSONObject) {
            tl tlVar = this.f62267i;
            bundle = tlVar != null ? (Bundle) tlVar.a(new Function() { // from class: com.applovin.impl.i00
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return oe.a((tl) obj);
                }
            }) : JsonUtils.toBundle(a("server_parameters", (JSONObject) null));
        } else {
            bundle = new Bundle();
        }
        int iJ = j();
        if (iJ != -1) {
            if (iJ == 2) {
                bundle.putBoolean("is_muted", this.f62260a.f0().isMuted());
            } else {
                bundle.putBoolean("is_muted", iJ == 0);
            }
        }
        if (!bundle.containsKey(AppLovinEventParameters.REVENUE_AMOUNT)) {
            bundle.putLong(AppLovinEventParameters.REVENUE_AMOUNT, b(AppLovinEventParameters.REVENUE_AMOUNT, 0L));
        }
        if (!bundle.containsKey(AppLovinEventParameters.REVENUE_CURRENCY)) {
            bundle.putString(AppLovinEventParameters.REVENUE_CURRENCY, b(AppLovinEventParameters.REVENUE_CURRENCY, ""));
        }
        return bundle;
    }

    public long m() {
        return a("adapter_timeout_ms", ((Long) this.f62260a.a(ue.N6)).longValue());
    }

    public Boolean n() {
        String str = this.f62260a.f0().getExtraParameters().get("huc");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("huc") ? a("huc", Boolean.FALSE) : b("huc", (Boolean) null);
    }

    public Boolean o() {
        String str = this.f62260a.f0().getExtraParameters().get("dns");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("dns") ? a("dns", Boolean.FALSE) : b("dns", (Boolean) null);
    }

    public boolean p() {
        return a("is_testing", Boolean.FALSE).booleanValue();
    }

    public boolean q() {
        return a("reinitialize_if_init_fails", Boolean.FALSE).booleanValue();
    }

    public boolean r() {
        return a("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    public boolean s() {
        return a("eagerly_initialize", Boolean.TRUE).booleanValue();
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + b() + "', adapterName='" + c() + "', isTesting=" + p() + '}';
    }

    protected Boolean b(String str, Boolean bool) {
        Boolean bool2;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str, bool);
        }
        synchronized (this.f62262c) {
            bool2 = JsonUtils.getBoolean(this.f62261b, str, bool);
        }
        return bool2;
    }

    protected boolean c(String str) {
        boolean zHas;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str);
        }
        synchronized (this.f62264f) {
            zHas = this.f62263d.has(str);
        }
        return zHas;
    }

    protected Object e(String str) {
        Object objOpt;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.b(str);
        }
        synchronized (this.f62264f) {
            objOpt = this.f62263d.opt(str);
        }
        return objOpt;
    }

    public void f(String str) {
        this.f62269k = str;
    }

    public Map i() {
        return this.f62265g;
    }

    protected Boolean a(String str, Boolean bool) {
        Boolean bool2;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, bool);
        }
        synchronized (this.f62264f) {
            bool2 = JsonUtils.getBoolean(this.f62263d, str, bool);
        }
        return bool2;
    }

    protected boolean d(String str) {
        boolean zHas;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str);
        }
        synchronized (this.f62262c) {
            zHas = this.f62261b.has(str);
        }
        return zHas;
    }

    public void g(String str) {
        this.f62268j = str;
    }

    protected float b(String str, float f3) {
        float f4;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, f3);
        }
        synchronized (this.f62264f) {
            f4 = JsonUtils.getFloat(this.f62263d, str, f3);
        }
        return f4;
    }

    protected void c(String str, int i3) {
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            tlVar.b(str, i3);
            return;
        }
        synchronized (this.f62264f) {
            JsonUtils.putInt(this.f62263d, str, i3);
        }
    }

    protected double a(String str, float f3) {
        double d3;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, f3);
        }
        synchronized (this.f62264f) {
            d3 = JsonUtils.getDouble(this.f62263d, str, f3);
        }
        return d3;
    }

    protected int b(String str, int i3) {
        int i4;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str, i3);
        }
        synchronized (this.f62262c) {
            i4 = JsonUtils.getInt(this.f62261b, str, i3);
        }
        return i4;
    }

    protected void c(String str, long j3) {
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            tlVar.b(str, j3);
            return;
        }
        synchronized (this.f62264f) {
            JsonUtils.putLong(this.f62263d, str, j3);
        }
    }

    protected int a(String str, int i3) {
        int i4;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, i3);
        }
        synchronized (this.f62264f) {
            i4 = JsonUtils.getInt(this.f62263d, str, i3);
        }
        return i4;
    }

    protected JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str, jSONArray);
        }
        synchronized (this.f62262c) {
            jSONArray2 = JsonUtils.getJSONArray(this.f62261b, str, jSONArray);
        }
        return jSONArray2;
    }

    protected void c(String str, String str2) {
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            tlVar.b(str, str2);
            return;
        }
        synchronized (this.f62264f) {
            JsonUtils.putString(this.f62263d, str, str2);
        }
    }

    protected JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, jSONArray);
        }
        synchronized (this.f62264f) {
            jSONArray2 = JsonUtils.getJSONArray(this.f62263d, str, jSONArray);
        }
        return jSONArray2;
    }

    protected long b(String str, long j3) {
        long j4;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str, j3);
        }
        synchronized (this.f62262c) {
            j4 = JsonUtils.getLong(this.f62261b, str, j3);
        }
        return j4;
    }

    protected JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, jSONObject);
        }
        synchronized (this.f62264f) {
            jSONObject2 = JsonUtils.getJSONObject(this.f62263d, str, jSONObject);
        }
        return jSONObject2;
    }

    public List b(String str) {
        List listOptList;
        List listOptList2;
        if (str != null) {
            tl tlVar = this.f62266h;
            if (tlVar != null) {
                listOptList = tlVar.b(str, Collections.EMPTY_LIST);
            } else {
                listOptList = JsonUtils.optList(b(str, new JSONArray()), Collections.EMPTY_LIST);
            }
            tl tlVar2 = this.f62267i;
            if (tlVar2 != null) {
                listOptList2 = tlVar2.b(str, Collections.EMPTY_LIST);
            } else {
                listOptList2 = JsonUtils.optList(a(str, new JSONArray()), Collections.EMPTY_LIST);
            }
            ArrayList arrayList = new ArrayList(listOptList.size() + listOptList2.size());
            arrayList.addAll(listOptList);
            arrayList.addAll(listOptList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    protected long a(String str, long j3) {
        long j4;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, j3);
        }
        synchronized (this.f62264f) {
            j4 = JsonUtils.getLong(this.f62263d, str, j3);
        }
        return j4;
    }

    public String a(String str) {
        String strA = a(str, "");
        return StringUtils.isValidString(strA) ? strA : b(str, "");
    }

    protected String b(String str, String str2) {
        String string;
        tl tlVar = this.f62266h;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.f62262c) {
            string = JsonUtils.getString(this.f62261b, str, str2);
        }
        return string;
    }

    protected String a(String str, String str2) {
        String string;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.f62264f) {
            string = JsonUtils.getString(this.f62263d, str, str2);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle a(tl tlVar) {
        return JsonUtils.toBundle(tlVar.a("server_parameters", (JSONObject) null));
    }

    protected void a(String str, Object obj) {
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            tlVar.a(str, obj);
            return;
        }
        synchronized (this.f62264f) {
            JsonUtils.putObject(this.f62263d, str, obj);
        }
    }
}
