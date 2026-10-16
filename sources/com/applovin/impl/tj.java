package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class tj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f63944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f63945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SharedPreferences f63946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f63947d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f63948e = new Object();

    public tj(com.applovin.impl.sdk.j jVar) {
        this.f63944a = jVar;
        Context contextM = com.applovin.impl.sdk.j.m();
        this.f63945b = contextM;
        this.f63946c = contextM.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(sj.class.getName());
            Class.forName(ue.class.getName());
        } catch (Throwable unused) {
        }
        d();
    }

    public void a() {
        synchronized (this.f63948e) {
            this.f63947d.clear();
        }
        this.f63944a.a(this.f63946c);
    }

    public List b(sj sjVar) {
        ArrayList arrayList = new ArrayList(6);
        Iterator it = c(sjVar).iterator();
        while (it.hasNext()) {
            arrayList.add(MaxAdFormat.formatFromString((String) it.next()));
        }
        return arrayList;
    }

    public List c(sj sjVar) {
        return CollectionUtils.explode((String) a(sjVar));
    }

    public void d() {
        String strB = b();
        synchronized (this.f63948e) {
            try {
                for (sj sjVar : sj.c()) {
                    try {
                        Object objA = this.f63944a.a(strB + sjVar.b(), null, sjVar.a().getClass(), this.f63946c);
                        if (objA != null) {
                            this.f63947d.put(sjVar.b(), objA);
                        }
                    } catch (Throwable th) {
                        com.applovin.impl.sdk.n.c("SettingsManager", "Unable to load \"" + sjVar.b() + "\"", th);
                        this.f63944a.D().a("SettingsManager", "initSettings", th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e() {
        String strB = b();
        synchronized (this.f63948e) {
            try {
                SharedPreferences.Editor editorEdit = this.f63946c.edit();
                for (sj sjVar : sj.c()) {
                    Object obj = this.f63947d.get(sjVar.b());
                    if (obj != null) {
                        this.f63944a.a(strB + sjVar.b(), obj, editorEdit);
                    }
                }
                editorEdit.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean c() {
        return this.f63944a.f0().isVerboseLoggingEnabled() || ((Boolean) a(sj.f63761l)).booleanValue();
    }

    private String b() {
        return "com.applovin.sdk." + yp.e(this.f63944a.a0()) + ".";
    }

    public Object a(sj sjVar) {
        if (sjVar != null) {
            synchronized (this.f63948e) {
                try {
                    Object obj = this.f63947d.get(sjVar.b());
                    if (obj == null) {
                        return sjVar.a();
                    }
                    return sjVar.a(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Double) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    public void a(JSONObject jSONObject) {
        synchronized (this.f63948e) {
            try {
                boolean zBooleanValue = JsonUtils.getBoolean(jSONObject, sj.f63803x.b(), Boolean.FALSE).booleanValue();
                HashMap map = zBooleanValue ? new HashMap() : null;
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && next.length() > 0) {
                        try {
                            sj sjVarA = a(next, (sj) null);
                            if (sjVarA != null) {
                                Object objA = zBooleanValue ? a(sjVarA) : null;
                                Object objA2 = a(next, jSONObject, sjVarA.a());
                                this.f63947d.put(sjVarA.b(), objA2);
                                if (sjVarA == sj.v5) {
                                    this.f63947d.put(sj.w5.b(), Long.valueOf(System.currentTimeMillis()));
                                }
                                if (zBooleanValue && !objA2.equals(objA)) {
                                    map.put(sjVarA, objA);
                                }
                            }
                        } catch (JSONException e3) {
                            com.applovin.impl.sdk.n.c("SettingsManager", "Unable to parse JSON settingsValues array", e3);
                            this.f63944a.D().a("SettingsManager", "loadSettingsException", e3);
                        } catch (Throwable th) {
                            com.applovin.impl.sdk.n.c("SettingsManager", "Unable to convert setting object ", th);
                            this.f63944a.D().a("SettingsManager", "loadSettingsThrowable", th);
                        }
                    }
                }
                if (zBooleanValue && map.size() > 0) {
                    pc pcVar = new pc();
                    pcVar.a("========== UPDATED SETTINGS ==========");
                    for (sj sjVar : map.keySet()) {
                        pcVar.a(sjVar.b(), a(sjVar) + " (" + map.get(sjVar) + ")");
                    }
                    pcVar.a("========== END ==========");
                    this.f63944a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f63944a.I().a("SettingsManager", pcVar.toString());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public sj a(String str, sj sjVar) {
        synchronized (this.f63948e) {
            try {
                for (sj sjVar2 : sj.c()) {
                    if (sjVar2.b().equals(str)) {
                        return sjVar2;
                    }
                }
                return sjVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(sj sjVar, Object obj) {
        if (sjVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj != null) {
            synchronized (this.f63948e) {
                this.f63947d.put(sjVar.b(), obj);
            }
            return;
        }
        throw new IllegalArgumentException("No new value specified");
    }
}
