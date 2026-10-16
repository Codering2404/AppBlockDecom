package com.google.crypto.tink.internal;

import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.proto.KeyStatusType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MonitoringUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MonitoringClient.Logger f86250a = new DoNothingLogger(null);

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.MonitoringUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86251a;

        static {
            int[] iArr = new int[KeyStatusType.values().length];
            f86251a = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86251a[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86251a[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DoNothingLogger implements MonitoringClient.Logger {
        private DoNothingLogger() {
        }

        /* synthetic */ DoNothingLogger(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
