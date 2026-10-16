package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SettingsJsonParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CurrentTimeProvider f89079a;

    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.f89079a = currentTimeProvider;
    }

    private static SettingsJsonTransform a(int i3) {
        if (i3 == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger.f().d("Could not determine SettingsJsonTransform for settings version " + i3 + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }

    public Settings b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f89079a, jSONObject);
    }
}
