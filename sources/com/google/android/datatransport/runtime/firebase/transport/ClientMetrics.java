package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientMetrics {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ClientMetrics f69405e = new Builder().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeWindow f69406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f69407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlobalMetrics f69408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f69409d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TimeWindow f69410a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f69411b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private GlobalMetrics f69412c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f69413d = "";

        Builder() {
        }

        public Builder a(LogSourceMetrics logSourceMetrics) {
            this.f69411b.add(logSourceMetrics);
            return this;
        }

        public ClientMetrics b() {
            return new ClientMetrics(this.f69410a, Collections.unmodifiableList(this.f69411b), this.f69412c, this.f69413d);
        }

        public Builder c(String str) {
            this.f69413d = str;
            return this;
        }

        public Builder d(GlobalMetrics globalMetrics) {
            this.f69412c = globalMetrics;
            return this;
        }

        public Builder e(TimeWindow timeWindow) {
            this.f69410a = timeWindow;
            return this;
        }
    }

    ClientMetrics(TimeWindow timeWindow, List list, GlobalMetrics globalMetrics, String str) {
        this.f69406a = timeWindow;
        this.f69407b = list;
        this.f69408c = globalMetrics;
        this.f69409d = str;
    }

    public static Builder e() {
        return new Builder();
    }

    public String a() {
        return this.f69409d;
    }

    public GlobalMetrics b() {
        return this.f69408c;
    }

    public List c() {
        return this.f69407b;
    }

    public TimeWindow d() {
        return this.f69406a;
    }

    public byte[] f() {
        return ProtoEncoderDoNotUse.a(this);
    }
}
