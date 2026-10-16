package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigContainer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Date f89699h = new Date(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f89700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f89701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Date f89702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f89703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f89704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f89705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONArray f89706g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f89707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Date f89708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONArray f89709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f89710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f89711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private JSONArray f89712f;

        public ConfigContainer a() {
            return new ConfigContainer(this.f89707a, this.f89708b, this.f89709c, this.f89710d, this.f89711e, this.f89712f);
        }

        public Builder b(Map map) {
            this.f89707a = new JSONObject(map);
            return this;
        }

        public Builder c(JSONObject jSONObject) {
            try {
                this.f89707a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder d(JSONArray jSONArray) {
            try {
                this.f89709c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder e(Date date) {
            this.f89708b = date;
            return this;
        }

        public Builder f(JSONObject jSONObject) {
            try {
                this.f89710d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder g(JSONArray jSONArray) {
            try {
                this.f89712f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder h(long j3) {
            this.f89711e = j3;
            return this;
        }

        private Builder() {
            this.f89707a = new JSONObject();
            this.f89708b = ConfigContainer.f89699h;
            this.f89709c = new JSONArray();
            this.f89710d = new JSONObject();
            this.f89711e = 0L;
            this.f89712f = new JSONArray();
        }
    }

    static ConfigContainer b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new ConfigContainer(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), jSONArrayOptJSONArray);
    }

    private Map c() throws JSONException {
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < j().length(); i3++) {
            JSONObject jSONObject = j().getJSONObject(i3);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String string3 = jSONArray.getString(i4);
                if (!map.containsKey(string3)) {
                    map.put(string3, new HashMap());
                }
                Map map2 = (Map) map.get(string3);
                if (map2 != null) {
                    map2.put(string, string2);
                }
            }
        }
        return map;
    }

    private static ConfigContainer d(JSONObject jSONObject) {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static Builder l() {
        return new Builder();
    }

    public JSONArray e() {
        return this.f89703d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfigContainer) {
            return this.f89700a.toString().equals(((ConfigContainer) obj).toString());
        }
        return false;
    }

    public Set f(ConfigContainer configContainer) throws JSONException {
        JSONObject jSONObjectG = d(configContainer.f89700a).g();
        Map mapC = c();
        Map mapC2 = configContainer.c();
        HashSet hashSet = new HashSet();
        Iterator<String> itKeys = g().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!configContainer.g().has(next)) {
                hashSet.add(next);
            } else if (!g().get(next).equals(configContainer.g().get(next))) {
                hashSet.add(next);
            } else if ((i().has(next) && !configContainer.i().has(next)) || (!i().has(next) && configContainer.i().has(next))) {
                hashSet.add(next);
            } else if (i().has(next) && configContainer.i().has(next) && !i().getJSONObject(next).toString().equals(configContainer.i().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) != mapC2.containsKey(next)) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) && mapC2.containsKey(next) && !((Map) mapC.get(next)).equals(mapC2.get(next))) {
                hashSet.add(next);
            } else {
                jSONObjectG.remove(next);
            }
        }
        Iterator<String> itKeys2 = jSONObjectG.keys();
        while (itKeys2.hasNext()) {
            hashSet.add(itKeys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.f89701b;
    }

    public Date h() {
        return this.f89702c;
    }

    public int hashCode() {
        return this.f89700a.hashCode();
    }

    public JSONObject i() {
        return this.f89704e;
    }

    public JSONArray j() {
        return this.f89706g;
    }

    public long k() {
        return this.f89705f;
    }

    public String toString() {
        return this.f89700a.toString();
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j3, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j3);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f89701b = jSONObject;
        this.f89702c = date;
        this.f89703d = jSONArray;
        this.f89704e = jSONObject2;
        this.f89705f = j3;
        this.f89706g = jSONArray2;
        this.f89700a = jSONObject3;
    }
}
