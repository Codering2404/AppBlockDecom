package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class EventBus {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f84898b = Logger.getLogger(EventBus.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f84899a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LoggingHandler implements SubscriberExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final LoggingHandler f84900a = new LoggingHandler();

        LoggingHandler() {
        }
    }

    public String toString() {
        return MoreObjects.c(this).k(this.f84899a).toString();
    }
}
