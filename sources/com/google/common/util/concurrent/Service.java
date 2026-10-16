package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface Service {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    State state();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Listener {
        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }

        public void a(State state, Throwable th) {
        }
    }
}
