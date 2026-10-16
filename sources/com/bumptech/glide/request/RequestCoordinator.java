package com.bumptech.glide.request;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface RequestCoordinator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RequestState {
        RUNNING(false),
        f67124c(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f67129a;

        RequestState(boolean z2) {
            this.f67129a = z2;
        }

        boolean b() {
            return this.f67129a;
        }
    }

    boolean a();

    boolean b(Request request);

    boolean c(Request request);

    void d(Request request);

    void f(Request request);

    RequestCoordinator getRoot();

    boolean j(Request request);
}
