package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1mSDK implements AFf1tSDK {
    private PluginInfo values = new PluginInfo(Plugin.NATIVE, pMpIcGE.mzGKXQAHzgmkvcM, null, 4, null);

    @Override // com.appsflyer.internal.AFf1tSDK
    public final Map<String, Object> AFInAppEventParameterName() {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("platform", this.values.getPlugin().getPluginName()), TuplesKt.a("version", this.values.getVersion()));
        if (!this.values.getAdditionalParams().isEmpty()) {
            mapMutableMapOf.put("extras", this.values.getAdditionalParams());
        }
        return mapMutableMapOf;
    }

    @Override // com.appsflyer.internal.AFf1tSDK
    public final void values(PluginInfo pluginInfo) {
        Intrinsics.checkNotNullParameter(pluginInfo, "");
        this.values = pluginInfo;
    }
}
