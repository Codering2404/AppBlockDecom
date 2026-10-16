package com.google.android.libraries.places.internal;

import com.facebook.GraphRequest;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzl extends zzbmx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f77288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbov f77289b;

    public zzbzl(boolean z2, int i3, int i4, zzbov zzbovVar) {
        this.f77288a = z2;
        this.f77289b = (zzbov) Preconditions.u(zzbovVar, "autoLoadBalancerFactory");
    }

    @Override // com.google.android.libraries.places.internal.zzbmx
    public final zzbms a(Map map) {
        Object objC;
        zzbze zzbzeVar;
        zzbwb zzbwbVar;
        Map mapD;
        try {
            zzbms zzbmsVarA = this.f77289b.a(map);
            zzbvz zzbvzVar = null;
            if (zzbmsVarA == null) {
                objC = null;
            } else {
                if (zzbmsVarA.d() != null) {
                    return zzbms.b(zzbmsVarA.d());
                }
                objC = zzbmsVarA.c();
            }
            boolean z2 = this.f77288a;
            if (!z2 || map == null || (mapD = zzbud.d(map, "retryThrottling")) == null) {
                zzbzeVar = null;
            } else {
                float fFloatValue = zzbud.e(mapD, "maxTokens").floatValue();
                float fFloatValue2 = zzbud.e(mapD, "tokenRatio").floatValue();
                Preconditions.A(fFloatValue > 0.0f, "maxToken should be greater than zero");
                Preconditions.A(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                zzbzeVar = new zzbze(fFloatValue, fFloatValue2);
            }
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            Map mapD2 = map == null ? null : zzbud.d(map, "healthCheckConfig");
            List<Map> listB = zzbud.b(map, "methodConfig");
            if (listB == null) {
                zzbwbVar = new zzbwb(null, map2, map3, zzbzeVar, objC, mapD2);
            } else {
                for (Map map4 : listB) {
                    zzbvz zzbvzVar2 = new zzbvz(map4, z2, 5, 5);
                    List<Map> listB2 = zzbud.b(map4, "name");
                    if (listB2 != null && !listB2.isEmpty()) {
                        for (Map map5 : listB2) {
                            String strG = zzbud.g(map5, "service");
                            String strG2 = zzbud.g(map5, GraphRequest.BATCH_METHOD_PARAM);
                            if (Strings.b(strG)) {
                                Preconditions.m(Strings.b(strG2), "missing service name for method %s", strG2);
                                Preconditions.m(zzbvzVar == null, "Duplicate default method config in service config %s", map);
                                zzbvzVar = zzbvzVar2;
                            } else if (Strings.b(strG2)) {
                                Preconditions.m(!map3.containsKey(strG), "Duplicate service %s", strG);
                                map3.put(strG, zzbvzVar2);
                            } else {
                                String strH = zzbml.h(strG, strG2);
                                Preconditions.m(!map2.containsKey(strH), "Duplicate method name %s", strH);
                                map2.put(strH, zzbvzVar2);
                            }
                        }
                    }
                }
                zzbwbVar = new zzbwb(zzbvzVar, map2, map3, zzbzeVar, objC, mapD2);
            }
            return zzbms.a(zzbwbVar);
        } catch (RuntimeException e3) {
            return zzbms.b(zzbnp.f76490g.e("failed to parse service config").d(e3));
        }
    }
}
