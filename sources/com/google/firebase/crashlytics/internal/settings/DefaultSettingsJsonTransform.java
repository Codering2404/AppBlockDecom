package com.google.firebase.crashlytics.internal.settings;

import com.facebook.AccessTokenManager;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    static Settings b(CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.getCurrentTimeMillis() + ((long) 3600000), new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return b(currentTimeProvider);
    }
}
