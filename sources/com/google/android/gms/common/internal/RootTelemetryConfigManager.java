package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RootTelemetryConfigManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static RootTelemetryConfigManager f72014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RootTelemetryConfiguration f72015c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RootTelemetryConfiguration f72016a;

    private RootTelemetryConfigManager() {
    }

    public static synchronized RootTelemetryConfigManager b() {
        try {
            if (f72014b == null) {
                f72014b = new RootTelemetryConfigManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f72014b;
    }

    public RootTelemetryConfiguration a() {
        return this.f72016a;
    }

    public final synchronized void c(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f72016a = f72015c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f72016a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.d1() < rootTelemetryConfiguration.d1()) {
            this.f72016a = rootTelemetryConfiguration;
        }
    }
}
