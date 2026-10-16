package org.chromium.support_lib_boundary;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z2);

    void setAllowFileAccess(boolean z2);

    void setBlockNetworkLoads(boolean z2);

    void setCacheMode(int i3);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}
