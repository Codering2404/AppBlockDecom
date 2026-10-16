package org.threeten.bp.zone;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ZoneRulesProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList f146644a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap f146645b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        ZoneRulesInitializer.a();
    }

    protected ZoneRulesProvider() {
    }

    public static Set a() {
        return Collections.unmodifiableSet(f146645b.keySet());
    }

    public static ZoneRules c(String str, boolean z2) {
        Jdk8Methods.i(str, "zoneId");
        return b(str).d(str, z2);
    }

    public static void f(ZoneRulesProvider zoneRulesProvider) {
        Jdk8Methods.i(zoneRulesProvider, "provider");
        g(zoneRulesProvider);
        f146644a.add(zoneRulesProvider);
    }

    private static void g(ZoneRulesProvider zoneRulesProvider) {
        for (String str : zoneRulesProvider.e()) {
            Jdk8Methods.i(str, "zoneId");
            if (((ZoneRulesProvider) f146645b.putIfAbsent(str, zoneRulesProvider)) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
    }

    protected abstract ZoneRules d(String str, boolean z2);

    protected abstract Set e();

    private static ZoneRulesProvider b(String str) {
        ConcurrentMap concurrentMap = f146645b;
        ZoneRulesProvider zoneRulesProvider = (ZoneRulesProvider) concurrentMap.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider;
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException(rnFwbPAQmQTnL.doUDsr);
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }
}
