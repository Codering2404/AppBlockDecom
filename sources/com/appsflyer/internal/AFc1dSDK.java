package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFc1dSDK<Body> implements ResponseNetwork<Body> {
    private final Body AFInAppEventParameterName;
    public final AFc1kSDK AFInAppEventType;
    final Map<String, List<String>> AFKeystoreWrapper;
    final int valueOf;
    final boolean values;

    public AFc1dSDK(Body body, int i3, boolean z2, Map<String, List<String>> map, AFc1kSDK aFc1kSDK) {
        this.AFInAppEventParameterName = body;
        this.valueOf = i3;
        this.values = z2;
        this.AFKeystoreWrapper = new HashMap(map);
        this.AFInAppEventType = aFc1kSDK;
    }

    public final String AFKeystoreWrapper(String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField == null || headerField.isEmpty()) {
            return null;
        }
        Iterator<String> it = headerField.iterator();
        StringBuilder sb = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFc1dSDK aFc1dSDK = (AFc1dSDK) obj;
        if (this.valueOf == aFc1dSDK.valueOf && this.values == aFc1dSDK.values && this.AFInAppEventParameterName.equals(aFc1dSDK.AFInAppEventParameterName) && this.AFKeystoreWrapper.equals(aFc1dSDK.AFKeystoreWrapper)) {
            return this.AFInAppEventType.equals(aFc1dSDK.AFInAppEventType);
        }
        return false;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public Body getBody() {
        return this.AFInAppEventParameterName;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public List<String> getHeaderField(String str) {
        for (String str2 : this.AFKeystoreWrapper.keySet()) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return this.AFKeystoreWrapper.get(str2);
            }
        }
        return null;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public int getStatusCode() {
        return this.valueOf;
    }

    public int hashCode() {
        return (((((((this.AFInAppEventParameterName.hashCode() * 31) + this.valueOf) * 31) + (this.values ? 1 : 0)) * 31) + this.AFKeystoreWrapper.hashCode()) * 31) + this.AFInAppEventType.hashCode();
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public boolean isSuccessful() {
        return this.values;
    }
}
