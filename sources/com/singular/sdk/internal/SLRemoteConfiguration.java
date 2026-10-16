package com.singular.sdk.internal;

import com.facebook.GraphRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLRemoteConfiguration implements SLJsonSerializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SingularLog f92650d = SingularLog.f(SLRemoteConfiguration.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdmonBatching f92651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f92652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Resolve f92653c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AdmonBatching implements SLJsonSerializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f92654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f92655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f92656c;

        AdmonBatching(JSONObject jSONObject) {
            this.f92654a = false;
            this.f92655b = false;
            this.f92656c = 0;
            try {
                this.f92654a = jSONObject.optBoolean("AggregateAdmonEvents", false);
                this.f92655b = jSONObject.optBoolean(GraphRequest.DEBUG_PARAM, false);
                this.f92656c = Math.max(0, jSONObject.optInt("AggregateAdmonMinIntervalSeconds", 0));
            } catch (Throwable th) {
                SLRemoteConfiguration.f92650d.c("failed parsing admon batching json with error: " + Utils.l(th));
            }
        }

        public int a() {
            return this.f92656c;
        }

        public boolean b() {
            return this.f92654a;
        }

        public boolean c() {
            return this.f92655b;
        }

        public JSONObject d() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("AggregateAdmonEvents", this.f92654a);
                jSONObject.put(GraphRequest.DEBUG_PARAM, this.f92655b);
                jSONObject.put("AggregateAdmonMinIntervalSeconds", this.f92656c);
                return jSONObject;
            } catch (Throwable th) {
                SLRemoteConfiguration.f92650d.c("failed to create json object with error: " + Utils.l(th));
                return new JSONObject();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Constants {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Resolve implements SLJsonSerializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f92657a;

        public Resolve(JSONObject jSONObject) {
            try {
                if (jSONObject.has("sdid")) {
                    this.f92657a = jSONObject.getString("sdid");
                }
            } catch (Throwable th) {
                SLRemoteConfiguration.f92650d.c("failed parsing identifiers json with error: " + Utils.l(th));
            }
        }

        public String a() {
            return this.f92657a;
        }

        public JSONObject b() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (Utils.U(this.f92657a)) {
                    return jSONObject;
                }
                jSONObject.put("sdid", this.f92657a);
                return jSONObject;
            } catch (Throwable th) {
                SLRemoteConfiguration.f92650d.c("failed to create json object with error: " + Utils.l(th));
                return new JSONObject();
            }
        }
    }

    SLRemoteConfiguration(JSONObject jSONObject) {
        this.f92652b = false;
        try {
            if (jSONObject.has("admon_batching")) {
                this.f92651a = new AdmonBatching(jSONObject.getJSONObject("admon_batching"));
            } else {
                this.f92651a = new AdmonBatching(new JSONObject());
            }
            if (jSONObject.has("set_sdid_enabled")) {
                this.f92652b = jSONObject.getBoolean("set_sdid_enabled");
            }
            if (jSONObject.has("resolve")) {
                this.f92653c = new Resolve(jSONObject.getJSONObject("resolve"));
            } else {
                this.f92653c = new Resolve(new JSONObject());
            }
        } catch (Throwable th) {
            f92650d.c("failed parsing remote configuration json with error: " + Utils.l(th));
        }
    }

    public static SLRemoteConfiguration b() {
        return new SLRemoteConfiguration(new JSONObject());
    }

    public int c() {
        AdmonBatching admonBatching = this.f92651a;
        return admonBatching == null ? b().c() : admonBatching.a();
    }

    public String d() {
        Resolve resolve = this.f92653c;
        return resolve == null ? b().d() : resolve.a();
    }

    public boolean e() {
        AdmonBatching admonBatching = this.f92651a;
        return admonBatching == null ? b().e() : admonBatching.c();
    }

    public boolean f() {
        AdmonBatching admonBatching = this.f92651a;
        return admonBatching == null ? b().f() : admonBatching.b();
    }

    public boolean g() {
        return this.f92652b;
    }

    public JSONObject h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("set_sdid_enabled", this.f92652b);
            AdmonBatching admonBatching = this.f92651a;
            if (admonBatching != null) {
                jSONObject.put("admon_batching", admonBatching.d());
            }
            Resolve resolve = this.f92653c;
            if (resolve != null) {
                jSONObject.put("resolve", resolve.b());
            }
            return jSONObject;
        } catch (Throwable th) {
            f92650d.c("failed to create json object with error: " + Utils.l(th));
            return new JSONObject();
        }
    }
}
