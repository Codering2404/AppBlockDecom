package com.singular.sdk.internal;

import android.content.SharedPreferences;
import com.singular.sdk.internal.ApiConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ConfigManager implements ApiConfig.ApiConfigCompletionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConfigManager f92519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92520c = SingularLog.f(ConfigManager.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SLRemoteConfiguration f92521a;

    private ConfigManager() {
    }

    private void a() {
        try {
            f92520c.a("enqueueing config request");
            ApiConfig apiConfig = new ApiConfig(Utils.y());
            apiConfig.e(ApiConfig.Params.m(SingularInstance.u()));
            SingularInstance.u().n().c(apiConfig);
        } catch (Throwable th) {
            f92520c.c("could not send and update local config from remote: " + Utils.l(th));
        }
    }

    public static ConfigManager c() {
        if (f92519b == null) {
            f92519b = new ConfigManager();
        }
        return f92519b;
    }

    private long g() {
        try {
            return SingularInstance.u().o().getSharedPreferences("singular-pref-config-manager", 0).getLong("config_manager_config_request_last_enqueued", -1L);
        } catch (Throwable th) {
            f92520c.a("failed to verify is config enqueued " + Utils.l(th));
            return -1L;
        }
    }

    private SLRemoteConfiguration i() {
        try {
            String string = SingularInstance.u().o().getSharedPreferences("singular-pref-config-manager", 0).getString("config_manager_config", null);
            if (!Utils.U(string)) {
                return new SLRemoteConfiguration(new JSONObject(string));
            }
            f92520c.c("local config is empty or null. returning default config");
            return SLRemoteConfiguration.b();
        } catch (Throwable th) {
            f92520c.c("failed loading config from shared pref with error: " + Utils.l(th));
            return SLRemoteConfiguration.b();
        }
    }

    private void l() {
        n(-1L);
    }

    private void m(SLRemoteConfiguration sLRemoteConfiguration, SingularInstance singularInstance) {
        try {
            SharedPreferences.Editor editorEdit = singularInstance.o().getSharedPreferences("singular-pref-config-manager", 0).edit();
            editorEdit.putString("config_manager_config", sLRemoteConfiguration.h().toString());
            editorEdit.commit();
        } catch (Throwable th) {
            f92520c.c("could not save config locally: " + Utils.l(th));
        }
    }

    private void n(long j3) {
        try {
            SharedPreferences.Editor editorEdit = SingularInstance.u().o().getSharedPreferences("singular-pref-config-manager", 0).edit();
            editorEdit.putLong("config_manager_config_request_last_enqueued", j3);
            editorEdit.commit();
        } catch (Throwable th) {
            f92520c.a("failed to persist is config enqueued " + Utils.l(th));
        }
    }

    public int b() {
        SLRemoteConfiguration sLRemoteConfiguration = this.f92521a;
        return sLRemoteConfiguration != null ? sLRemoteConfiguration.c() : SLRemoteConfiguration.b().c();
    }

    public String d() {
        SLRemoteConfiguration sLRemoteConfiguration = this.f92521a;
        if (sLRemoteConfiguration != null && !Utils.U(sLRemoteConfiguration.d())) {
            return this.f92521a.d();
        }
        SingularLog singularLog = f92520c;
        StringBuilder sb = new StringBuilder();
        sb.append("getResolvedSdid: returning null, ");
        sb.append(this.f92521a == null ? "config == null" : "SDID is EmptyOrNull");
        singularLog.a(sb.toString());
        return null;
    }

    public boolean e() {
        SLRemoteConfiguration sLRemoteConfiguration = this.f92521a;
        return sLRemoteConfiguration != null ? sLRemoteConfiguration.e() : SLRemoteConfiguration.b().e();
    }

    public boolean f() {
        SLRemoteConfiguration sLRemoteConfiguration = this.f92521a;
        return sLRemoteConfiguration != null ? sLRemoteConfiguration.f() : SLRemoteConfiguration.b().f();
    }

    public boolean h() {
        SLRemoteConfiguration sLRemoteConfiguration = this.f92521a;
        return sLRemoteConfiguration != null ? sLRemoteConfiguration.g() : SLRemoteConfiguration.b().g();
    }

    public void j(String str) {
        f92520c.c(str);
    }

    public void k(SLRemoteConfiguration sLRemoteConfiguration, SingularInstance singularInstance) {
        if (sLRemoteConfiguration != null) {
            try {
                this.f92521a = sLRemoteConfiguration;
                m(sLRemoteConfiguration, singularInstance);
                l();
            } catch (Throwable th) {
                f92520c.c("failed to handle config on success: " + Utils.l(th));
            }
        }
    }

    public synchronized void o() {
        this.f92521a = i();
        if (g() < 0) {
            a();
            n(Utils.y());
        }
    }
}
