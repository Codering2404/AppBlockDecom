package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LogSourceMetrics {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LogSourceMetrics f69431c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f69433b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f69434a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f69435b = new ArrayList();

        Builder() {
        }

        public LogSourceMetrics a() {
            return new LogSourceMetrics(this.f69434a, Collections.unmodifiableList(this.f69435b));
        }

        public Builder b(List list) {
            this.f69435b = list;
            return this;
        }

        public Builder c(String str) {
            this.f69434a = str;
            return this;
        }
    }

    LogSourceMetrics(String str, List list) {
        this.f69432a = str;
        this.f69433b = list;
    }

    public static Builder c() {
        return new Builder();
    }

    public List a() {
        return this.f69433b;
    }

    public String b() {
        return this.f69432a;
    }
}
