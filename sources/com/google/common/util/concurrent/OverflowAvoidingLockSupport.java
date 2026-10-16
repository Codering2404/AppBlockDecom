package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class OverflowAvoidingLockSupport {
    static void a(Object obj, long j3) {
        LockSupport.parkNanos(obj, Math.min(j3, 2147483647999999999L));
    }
}
