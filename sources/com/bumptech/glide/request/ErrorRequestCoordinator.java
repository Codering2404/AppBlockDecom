package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f67117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestCoordinator f67118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Request f67119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Request f67120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RequestCoordinator.RequestState f67121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RequestCoordinator.RequestState f67122f;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f67121e = requestState;
        this.f67122f = requestState;
        this.f67117a = obj;
        this.f67118b = requestCoordinator;
    }

    private boolean k(Request request) {
        RequestCoordinator.RequestState requestState = this.f67121e;
        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.FAILED;
        if (requestState != requestState2) {
            return request.equals(this.f67119c);
        }
        if (!request.equals(this.f67120d)) {
            return false;
        }
        RequestCoordinator.RequestState requestState3 = this.f67122f;
        return requestState3 == RequestCoordinator.RequestState.SUCCESS || requestState3 == requestState2;
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f67118b;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f67118b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f67118b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean a() {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                z2 = this.f67119c.a() || this.f67120d.a();
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(Request request) {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                z2 = m() && k(request);
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean zN;
        synchronized (this.f67117a) {
            zN = n();
        }
        return zN;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.f67121e = requestState;
                this.f67119c.clear();
                if (this.f67122f != requestState) {
                    this.f67122f = requestState;
                    this.f67120d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(Request request) {
        synchronized (this.f67117a) {
            try {
                if (request.equals(this.f67120d)) {
                    this.f67122f = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator requestCoordinator = this.f67118b;
                    if (requestCoordinator != null) {
                        requestCoordinator.d(this);
                    }
                    return;
                }
                this.f67121e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f67122f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f67122f = requestState2;
                    this.f67120d.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = this.f67121e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z2 = requestState == requestState2 && this.f67122f == requestState2;
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(Request request) {
        synchronized (this.f67117a) {
            try {
                if (request.equals(this.f67119c)) {
                    this.f67121e = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.f67120d)) {
                    this.f67122f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.f67118b;
                if (requestCoordinator != null) {
                    requestCoordinator.f(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean g() {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = this.f67121e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                z2 = requestState == requestState2 || this.f67122f == requestState2;
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f67117a) {
            try {
                RequestCoordinator requestCoordinator = this.f67118b;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean h(Request request) {
        if (request instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            if (this.f67119c.h(errorRequestCoordinator.f67119c) && this.f67120d.h(errorRequestCoordinator.f67120d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void i() {
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = this.f67121e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f67121e = requestState2;
                    this.f67119c.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = this.f67121e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                z2 = requestState == requestState2 || this.f67122f == requestState2;
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean j(Request request) {
        boolean z2;
        synchronized (this.f67117a) {
            try {
                z2 = l() && request.equals(this.f67119c);
            } finally {
            }
        }
        return z2;
    }

    public void o(Request request, Request request2) {
        this.f67119c = request;
        this.f67120d = request2;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f67117a) {
            try {
                RequestCoordinator.RequestState requestState = this.f67121e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.f67121e = RequestCoordinator.RequestState.f67124c;
                    this.f67119c.pause();
                }
                if (this.f67122f == requestState2) {
                    this.f67122f = RequestCoordinator.RequestState.f67124c;
                    this.f67120d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
