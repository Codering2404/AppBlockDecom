package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class Jobs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66493a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f66494b = new HashMap();

    Jobs() {
    }

    private Map b(boolean z2) {
        return z2 ? this.f66494b : this.f66493a;
    }

    EngineJob a(Key key, boolean z2) {
        return (EngineJob) b(z2).get(key);
    }

    void c(Key key, EngineJob engineJob) {
        b(engineJob.p()).put(key, engineJob);
    }

    void d(Key key, EngineJob engineJob) {
        Map mapB = b(engineJob.p());
        if (engineJob.equals(mapB.get(key))) {
            mapB.remove(key);
        }
    }
}
