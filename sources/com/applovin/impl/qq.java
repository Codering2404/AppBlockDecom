package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class qq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f62664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f62665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f62666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f62667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f62668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f62669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f62670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f62671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f62672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f62673j;

    public qq(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().d("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        }
        this.f62664a = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 64);
        this.f62665b = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 7);
        this.f62666c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.f62667d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.f62668e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f62669f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f62670g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f62671h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f62672i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f62673j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    public float a() {
        return this.f62672i;
    }

    public long b() {
        return this.f62670g;
    }

    public float c() {
        return this.f62673j;
    }

    public long d() {
        return this.f62671h;
    }

    public int e() {
        return this.f62667d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            qq qqVar = (qq) obj;
            if (this.f62664a == qqVar.f62664a && this.f62665b == qqVar.f62665b && this.f62666c == qqVar.f62666c && this.f62667d == qqVar.f62667d && this.f62668e == qqVar.f62668e && this.f62669f == qqVar.f62669f && this.f62670g == qqVar.f62670g && this.f62671h == qqVar.f62671h && Float.compare(qqVar.f62672i, this.f62672i) == 0 && Float.compare(qqVar.f62673j, this.f62673j) == 0) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f62665b;
    }

    public int g() {
        return this.f62666c;
    }

    public long h() {
        return this.f62669f;
    }

    public int hashCode() {
        int i3 = ((((((((((((((this.f62664a * 31) + this.f62665b) * 31) + this.f62666c) * 31) + this.f62667d) * 31) + (this.f62668e ? 1 : 0)) * 31) + this.f62669f) * 31) + this.f62670g) * 31) + this.f62671h) * 31;
        float f3 = this.f62672i;
        int iFloatToIntBits = (i3 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.f62673j;
        return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public int i() {
        return this.f62664a;
    }

    public boolean j() {
        return this.f62668e;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f62664a + ", heightPercentOfScreen=" + this.f62665b + ", margin=" + this.f62666c + ", gravity=" + this.f62667d + ", tapToFade=" + this.f62668e + ", tapToFadeDurationMillis=" + this.f62669f + ", fadeInDurationMillis=" + this.f62670g + ", fadeOutDurationMillis=" + this.f62671h + ", fadeInDelay=" + this.f62672i + ", fadeOutDelay=" + this.f62673j + '}';
    }
}
