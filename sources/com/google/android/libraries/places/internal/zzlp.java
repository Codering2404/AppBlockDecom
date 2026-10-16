package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzlp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Locale f78117c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f78118d = new HashMap();

    zzlp(String str, String str2) {
        this.f78115a = str;
        Preconditions.e(!TextUtils.isEmpty(str2), "API key cannot be empty.");
        this.f78116b = str2;
    }

    final zzlp a(Locale locale) {
        this.f78117c = locale;
        return this;
    }

    final zzlp b(Map map) {
        this.f78118d = new HashMap(map);
        return this;
    }

    public final String c() {
        Uri.Builder builderBuildUpon = Uri.parse("https://maps.googleapis.com/").buildUpon();
        builderBuildUpon.appendEncodedPath("maps/api/place/");
        builderBuildUpon.appendEncodedPath(this.f78115a);
        builderBuildUpon.appendQueryParameter("key", this.f78116b);
        Locale locale = this.f78117c;
        if (locale != null) {
            String languageTag = locale.toLanguageTag();
            if (!TextUtils.isEmpty(languageTag)) {
                builderBuildUpon.appendQueryParameter("language", languageTag);
            }
        }
        Map map = this.f78118d;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return builderBuildUpon.build().toString();
    }
}
