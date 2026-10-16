package com.google.firebase.crashlytics.internal.settings;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SettingsV3JsonTransform implements SettingsJsonTransform {
    SettingsV3JsonTransform() {
    }

    private static Settings.FeatureFlagData b(JSONObject jSONObject) {
        return new Settings.FeatureFlagData(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false), jSONObject.optBoolean("collect_build_ids", false));
    }

    private static Settings.SessionData c(JSONObject jSONObject) {
        return new Settings.SessionData(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    private static long d(CurrentTimeProvider currentTimeProvider, long j3, JSONObject jSONObject) {
        return jSONObject.has(AccessToken.EXPIRES_AT_KEY) ? jSONObject.optLong(AccessToken.EXPIRES_AT_KEY) : currentTimeProvider.getCurrentTimeMillis() + (j3 * 1000);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS);
        return new Settings(d(currentTimeProvider, iOptInt2, jSONObject), jSONObject.has("session") ? c(jSONObject.getJSONObject("session")) : c(new JSONObject()), b(jSONObject.getJSONObject("features")), iOptInt, iOptInt2, jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d), jSONObject.optDouble("on_demand_backoff_base", 1.2d), jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60));
    }
}
