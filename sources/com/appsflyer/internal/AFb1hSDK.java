package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1hSDK {
    public final Map<String, Object> valueOf = new HashMap();
    public Map<String, Object> values = new HashMap();

    public final void AFInAppEventType(Map<String, Object> map) {
        if (!this.valueOf.isEmpty()) {
            map.put("partner_data", this.valueOf);
        }
        if (this.values.isEmpty()) {
            return;
        }
        AFa1bSDK.AFInAppEventParameterName(map).put("partner_data", this.values);
        this.values = new HashMap();
    }
}
