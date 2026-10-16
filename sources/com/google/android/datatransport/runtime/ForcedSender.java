package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.logging.Logging;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ForcedSender {
    public static void a(Transport transport, Priority priority) {
        if (!(transport instanceof TransportImpl)) {
            Logging.f("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", transport);
        } else {
            TransportRuntime.c().e().l(((TransportImpl) transport).d().f(priority), 1);
        }
    }
}
