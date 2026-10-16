package com.google.crypto.tink.monitoring;

import com.google.errorprone.annotations.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class MonitoringAnnotations {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MonitoringAnnotations f86384b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f86385a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HashMap f86386a = new HashMap();

        public MonitoringAnnotations a() {
            if (this.f86386a == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            MonitoringAnnotations monitoringAnnotations = new MonitoringAnnotations(Collections.unmodifiableMap(this.f86386a));
            this.f86386a = null;
            return monitoringAnnotations;
        }
    }

    public static Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj instanceof MonitoringAnnotations) {
            return this.f86385a.equals(((MonitoringAnnotations) obj).f86385a);
        }
        return false;
    }

    public int hashCode() {
        return this.f86385a.hashCode();
    }

    public String toString() {
        return this.f86385a.toString();
    }

    private MonitoringAnnotations(Map map) {
        this.f86385a = map;
    }
}
