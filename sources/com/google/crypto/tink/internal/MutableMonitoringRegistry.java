package com.google.crypto.tink.internal;

import com.google.crypto.tink.monitoring.MonitoringClient;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MutableMonitoringRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableMonitoringRegistry f86252b = new MutableMonitoringRegistry();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DoNothingClient f86253c = new DoNothingClient();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f86254a = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DoNothingClient implements MonitoringClient {
        private DoNothingClient() {
        }
    }
}
