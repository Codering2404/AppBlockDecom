package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GlideExperiments {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66069a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f66070a = new HashMap();

        Builder() {
        }

        GlideExperiments b() {
            return new GlideExperiments(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Experiment {
    }

    GlideExperiments(Builder builder) {
        this.f66069a = Collections.unmodifiableMap(new HashMap(builder.f66070a));
    }

    public boolean a(Class cls) {
        return this.f66069a.containsKey(cls);
    }
}
