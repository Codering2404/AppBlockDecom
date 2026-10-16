package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.h4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinSdkSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f65607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f65608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f65609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f65610d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f65612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f65613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f65614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f65615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f65616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AppLovinTermsAndPrivacyPolicyFlowSettings f65617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private j f65618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f65619m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f65611e = true;
    private final Map<String, Object> localSettings = new HashMap();

    public AppLovinSdkSettings(Context context) {
        List list = Collections.EMPTY_LIST;
        this.f65614h = list;
        this.f65615i = list;
        this.f65616j = Collections.synchronizedMap(new HashMap());
        this.f65619m = "";
        this.f65609c = true;
        this.f65610d = true;
        if (context == null) {
            n.h("AppLovinSdkSettings", "context cannot be null. Please provide a valid context.");
        }
        Context contextD = yp.d(context);
        this.f65607a = yp.k(contextD);
        this.f65617k = h4.a(contextD);
        this.f65619m = contextD.getPackageName();
        a(contextD);
    }

    private void a(Context context) {
        int identifier = context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName());
        if (identifier == 0) {
            return;
        }
        String strA = yp.a(identifier, context, (j) null);
        this.f65616j.putAll(JsonUtils.tryToStringMap(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject()));
    }

    public void attachAppLovinSdk(j jVar) {
        this.f65618l = jVar;
        if (StringUtils.isValidString(this.f65612f)) {
            jVar.k0().a(Arrays.asList(this.f65612f.split(",")));
            this.f65612f = null;
        }
        if (this.f65613g != null) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinSdkSettings", "Setting user id: " + this.f65613g);
            }
            jVar.o0().a(this.f65613g);
            this.f65613g = null;
        }
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.f65616j) {
            map = CollectionUtils.map(this.f65616j);
        }
        return map;
    }

    @Deprecated
    public List<String> getInitializationAdUnitIds() {
        return this.f65615i;
    }

    public AppLovinTermsAndPrivacyPolicyFlowSettings getTermsAndPrivacyPolicyFlowSettings() {
        return this.f65617k;
    }

    @Deprecated
    public List<String> getTestDeviceAdvertisingIds() {
        return this.f65614h;
    }

    public String getUserIdentifier() {
        j jVar = this.f65618l;
        return jVar == null ? this.f65613g : jVar.o0().c();
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f65609c;
    }

    @Deprecated
    public boolean isExceptionHandlerEnabled() {
        return this.f65610d;
    }

    public boolean isMuted() {
        return this.f65608b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f65607a;
    }

    public void setCreativeDebuggerEnabled(boolean z2) {
        n.e("AppLovinSdkSettings", "setCreativeDebuggerEnabled(creativeDebuggerEnabled=" + z2 + ")");
        if (this.f65609c == z2) {
            return;
        }
        this.f65609c = z2;
        j jVar = this.f65618l;
        if (jVar == null) {
            return;
        }
        if (z2) {
            jVar.v().l();
        } else {
            jVar.v().k();
        }
    }

    @Deprecated
    public void setExceptionHandlerEnabled(boolean z2) {
        n.e("AppLovinSdkSettings", "setExceptionHandlerEnabled(exceptionHandlerEnabled=" + z2 + ")");
        this.f65610d = z2;
    }

    public void setExtraParameter(String str, String str2) {
        n.e("AppLovinSdkSettings", "setExtraParameter(key=" + str + ", value=" + str2 + ")");
        if (TextUtils.isEmpty(str)) {
            n.h("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        String strTrim = str2 != null ? str2.trim() : null;
        if ("test_mode_network".equalsIgnoreCase(str)) {
            if (this.f65618l == null) {
                this.f65612f = strTrim;
            } else if (StringUtils.isValidString(strTrim)) {
                this.f65618l.k0().a(Arrays.asList(strTrim.split(",")));
            } else {
                this.f65618l.k0().a((String) null);
            }
        } else if ("fan".equals(str) || "esc".equals(str)) {
            if (!this.f65619m.startsWith("com.unity.")) {
                return;
            }
        } else if ("disable_all_logs".equals(str)) {
            n.a(Boolean.parseBoolean(strTrim));
        } else if ("package_name_override".equals(str)) {
            k.b(strTrim);
        }
        this.f65616j.put(str, strTrim);
    }

    @Deprecated
    public void setInitializationAdUnitIds(List<String> list) {
        n.e("AppLovinSdkSettings", "setInitializationAdUnitIds(initializationAdUnitIds=" + list + ")");
        if (list == null) {
            this.f65615i = Collections.EMPTY_LIST;
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (StringUtils.isValidString(str) && str.length() > 0) {
                if (str.length() == 16) {
                    arrayList.add(str);
                } else {
                    n.h("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + str + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                }
            }
        }
        this.f65615i = arrayList;
    }

    public void setMuted(boolean z2) {
        n.e("AppLovinSdkSettings", "setMuted(muted=" + z2 + ")");
        this.f65608b = z2;
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z2) {
        n.e("AppLovinSdkSettings", "setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(shouldFailAdDisplayIfDontKeepActivitiesIsEnabled=" + z2 + ")");
        this.f65611e = z2;
    }

    @Deprecated
    public void setTestDeviceAdvertisingIds(List<String> list) {
        n.e("AppLovinSdkSettings", "setTestDeviceAdvertisingIds(testDeviceAdvertisingIds=" + list + ")");
        if (list == null) {
            this.f65614h = Collections.EMPTY_LIST;
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (str == null || str.length() != 36) {
                n.h("AppLovinSdkSettings", "Unable to set test device advertising id (" + str + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
            } else {
                arrayList.add(str);
            }
        }
        this.f65614h = arrayList;
    }

    public void setUserIdentifier(String str) {
        n.e("AppLovinSdkSettings", "setUserIdentifier(userIdentifier=" + str + ")");
        if (StringUtils.isValidString(str) && str.length() > yp.b(8)) {
            n.h("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + yp.b(8) + " maximum)");
        }
        j jVar = this.f65618l;
        if (jVar == null) {
            this.f65613g = str;
            return;
        }
        jVar.I();
        if (n.a()) {
            this.f65618l.I().a("AppLovinSdkSettings", "Setting user id: " + str);
        }
        this.f65618l.o0().a(str);
    }

    public void setVerboseLogging(boolean z2) {
        n.e("AppLovinSdkSettings", "setVerboseLogging(isVerboseLoggingEnabled=" + z2 + ")");
        if (!yp.k()) {
            this.f65607a = z2;
            return;
        }
        n.h("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
        if (yp.k(null) != z2) {
            n.h("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
        }
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.f65611e;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f65607a + ", muted=" + this.f65608b + ", testDeviceAdvertisingIds=" + this.f65614h.toString() + ", initializationAdUnitIds=" + this.f65615i.toString() + ", creativeDebuggerEnabled=" + this.f65609c + ", exceptionHandlerEnabled=" + this.f65610d + '}';
    }
}
