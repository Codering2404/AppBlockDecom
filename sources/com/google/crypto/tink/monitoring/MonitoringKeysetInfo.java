package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.KeyStatus;
import com.google.errorprone.annotations.Immutable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class MonitoringKeysetInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MonitoringAnnotations f86387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f86388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f86389c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KeyStatus f86390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f86391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f86392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f86393d;

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f86390a == entry.f86390a && this.f86391b == entry.f86391b && this.f86392c.equals(entry.f86392c) && this.f86393d.equals(entry.f86393d);
        }

        public int hashCode() {
            return Objects.hash(this.f86390a, Integer.valueOf(this.f86391b), this.f86392c, this.f86393d);
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.f86390a, Integer.valueOf(this.f86391b), this.f86392c, this.f86393d);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MonitoringKeysetInfo)) {
            return false;
        }
        MonitoringKeysetInfo monitoringKeysetInfo = (MonitoringKeysetInfo) obj;
        return this.f86387a.equals(monitoringKeysetInfo.f86387a) && this.f86388b.equals(monitoringKeysetInfo.f86388b) && Objects.equals(this.f86389c, monitoringKeysetInfo.f86389c);
    }

    public int hashCode() {
        return Objects.hash(this.f86387a, this.f86388b);
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.f86387a, this.f86388b, this.f86389c);
    }
}
