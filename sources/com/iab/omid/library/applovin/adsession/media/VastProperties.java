package com.iab.omid.library.applovin.adsession.media;

import com.iab.omid.library.applovin.utils.d;
import com.iab.omid.library.applovin.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f92116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f92117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f92118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f92119d;

    private VastProperties(boolean z2, Float f3, boolean z3, Position position) {
        this.f92116a = z2;
        this.f92117b = f3;
        this.f92118c = z3;
        this.f92119d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z2, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z2, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f3, boolean z2, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f3), z2, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f92116a);
            if (this.f92116a) {
                jSONObject.put("skipOffset", this.f92117b);
            }
            jSONObject.put("autoPlay", this.f92118c);
            jSONObject.put("position", this.f92119d);
            return jSONObject;
        } catch (JSONException e3) {
            d.a("VastProperties: JSON error", e3);
            return jSONObject;
        }
    }

    public Position getPosition() {
        return this.f92119d;
    }

    public Float getSkipOffset() {
        return this.f92117b;
    }

    public boolean isAutoPlay() {
        return this.f92118c;
    }

    public boolean isSkippable() {
        return this.f92116a;
    }
}
