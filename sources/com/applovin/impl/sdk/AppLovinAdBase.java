package com.applovin.impl.sdk;

import android.graphics.Color;
import com.applovin.impl.kg;
import com.applovin.impl.lg;
import com.applovin.impl.sdk.array.ArrayDirectDownloadAd;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tl;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppLovinAdBase implements kg, ArrayDirectDownloadAd {
    protected final JSONObject adObject;
    private final long createdAtMillis;
    protected final JSONObject fullResponse;
    protected final j sdk;
    protected final tl synchronizedAdObject;
    protected final tl synchronizedFullResponse;
    protected final Object adObjectLock = new Object();
    protected final Object fullResponseLock = new Object();

    protected AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, j jVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.sdk = jVar;
        if (((Boolean) jVar.a(sj.i6)).booleanValue()) {
            this.synchronizedAdObject = new tl(jSONObject);
            this.synchronizedFullResponse = new tl(jSONObject2);
            this.adObject = null;
            this.fullResponse = null;
        } else {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.synchronizedAdObject = null;
            this.synchronizedFullResponse = null;
        }
        this.createdAtMillis = System.currentTimeMillis();
    }

    protected boolean containsKeyForAdObject(String str) {
        boolean zHas;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str);
        }
        synchronized (this.adObjectLock) {
            zHas = this.adObject.has(str);
        }
        return zHas;
    }

    public String getAdDomain() {
        return getStringFromFullResponse("adomain", "");
    }

    @Override // com.applovin.impl.kg
    public abstract /* synthetic */ lg getAdEventTracker();

    public abstract long getAdIdNumber();

    protected boolean getBooleanFromAdObject(String str, Boolean bool) {
        boolean zBooleanValue;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, bool).booleanValue();
        }
        synchronized (this.adObjectLock) {
            zBooleanValue = JsonUtils.getBoolean(this.adObject, str, bool).booleanValue();
        }
        return zBooleanValue;
    }

    protected boolean getBooleanFromFullResponse(String str, boolean z2) {
        boolean zBooleanValue;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            return tlVar.a(str, Boolean.valueOf(z2)).booleanValue();
        }
        synchronized (this.fullResponseLock) {
            zBooleanValue = JsonUtils.getBoolean(this.fullResponse, str, Boolean.valueOf(z2)).booleanValue();
        }
        return zBooleanValue;
    }

    public String getClCode() {
        String stringFromAdObject = getStringFromAdObject("clcode", "");
        return StringUtils.isValidString(stringFromAdObject) ? stringFromAdObject : getStringFromFullResponse("clcode", "");
    }

    protected int getColorFromAdObject(String str, int i3) {
        String stringFromAdObject = getStringFromAdObject(str, null);
        return StringUtils.isValidString(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : i3;
    }

    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public String getDspId() {
        return getStringFromFullResponse("dsp_id", "");
    }

    public String getDspName() {
        return getStringFromFullResponse("dsp_name", "");
    }

    public long getFetchLatencyMillis() {
        return getLongFromFullResponse("ad_fetch_latency_millis", -1L);
    }

    public long getFetchResponseSize() {
        return getLongFromFullResponse("ad_fetch_response_size", -1L);
    }

    protected float getFloatFromAdObject(String str, float f3) {
        float f4;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, f3);
        }
        synchronized (this.adObjectLock) {
            f4 = JsonUtils.getFloat(this.adObject, str, f3);
        }
        return f4;
    }

    protected int getIntFromAdObject(String str, int i3) {
        int i4;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, i3);
        }
        synchronized (this.adObjectLock) {
            i4 = JsonUtils.getInt(this.adObject, str, i3);
        }
        return i4;
    }

    protected List<Integer> getIntegerListFromAdObject(String str, List<Integer> list) {
        List<Integer> integerList;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, (List) list);
        }
        synchronized (this.adObjectLock) {
            integerList = JsonUtils.getIntegerList(this.adObject, str, list);
        }
        return integerList;
    }

    protected JSONArray getJsonArrayFromAdObject(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, jSONArray);
        }
        synchronized (this.adObjectLock) {
            jSONArray2 = JsonUtils.getJSONArray(this.adObject, str, jSONArray);
        }
        return jSONArray2;
    }

    protected JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, jSONObject);
        }
        synchronized (this.adObjectLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.adObject, str, jSONObject);
        }
        return jSONObject2;
    }

    protected long getLongFromAdObject(String str, long j3) {
        long j4;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, j3);
        }
        synchronized (this.adObjectLock) {
            j4 = JsonUtils.getLong(this.adObject, str, j3);
        }
        return j4;
    }

    protected long getLongFromFullResponse(String str, long j3) {
        long j4;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            return tlVar.a(str, j3);
        }
        synchronized (this.fullResponseLock) {
            j4 = JsonUtils.getLong(this.fullResponse, str, j3);
        }
        return j4;
    }

    @Override // com.applovin.impl.kg
    public abstract /* synthetic */ String getOpenMeasurementContentUrl();

    @Override // com.applovin.impl.kg
    public abstract /* synthetic */ String getOpenMeasurementCustomReferenceData();

    @Override // com.applovin.impl.kg
    public abstract /* synthetic */ List getOpenMeasurementVerificationScriptResources();

    public j getSdk() {
        return this.sdk;
    }

    protected String getStringFromAdObject(String str, String str2) {
        String string;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, str, str2);
        }
        return string;
    }

    protected String getStringFromFullResponse(String str, String str2) {
        String string;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.fullResponseLock) {
            string = JsonUtils.getString(this.fullResponse, str, str2);
        }
        return string;
    }

    protected List<String> getStringListFromAdObject(String str, List<String> list) {
        List<String> stringList;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return tlVar.b(str, list);
        }
        synchronized (this.adObjectLock) {
            stringList = JsonUtils.getStringList(this.adObject, str, list);
        }
        return stringList;
    }

    @Override // com.applovin.impl.kg
    public abstract /* synthetic */ boolean isOpenMeasurementEnabled();
}
