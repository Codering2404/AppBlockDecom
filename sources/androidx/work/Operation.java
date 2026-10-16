package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Operation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final State.SUCCESS f54551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final State.IN_PROGRESS f54552b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class State {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class FAILURE extends State {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f54553a;

            public FAILURE(Throwable th) {
                this.f54553a = th;
            }

            public Throwable a() {
                return this.f54553a;
            }

            public String toString() {
                return "FAILURE (" + this.f54553a.getMessage() + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }

        State() {
        }
    }

    static {
        f54551a = new State.SUCCESS();
        f54552b = new State.IN_PROGRESS();
    }

    ListenableFuture getResult();
}
