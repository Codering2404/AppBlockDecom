package com.singular.sdk.internal.InstallReferrer;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLSamsungReferrer implements SLInstallReferrerService {
    public void a(Context context, final SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        new SLReflectionInstallReferrer(context, "com.samsung.android.sdk.sinstallreferrer.api", new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.InstallReferrer.SLSamsungReferrer.1
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void a(Map map) {
                if (map == null) {
                    sLInstallReferrerCompletionHandler.a(null);
                    return;
                }
                HashMap map2 = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    map2.put("samsung_" + ((String) entry.getKey()), entry.getValue());
                }
                sLInstallReferrerCompletionHandler.a(map2);
            }
        }).j();
    }
}
