package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestCoordinator f67174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f67175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Request f67176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Request f67177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RequestCoordinator.RequestState f67178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RequestCoordinator.RequestState f67179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f67180g;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f67178e = requestState;
        this.f67179f = requestState;
        this.f67175b = obj;
        this.f67174a = requestCoordinator;
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f67174a;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f67174a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f67174a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean a() {
        boolean z2;
        synchronized (this.f67175b) {
            try {
                z2 = this.f67177d.a() || this.f67176c.a();
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(Request request) {
        boolean z2;
        synchronized (this.f67175b) {
            try {
                z2 = l() && request.equals(this.f67176c) && !a();
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean z2;
        synchronized (this.f67175b) {
            try {
                z2 = m() && (request.equals(this.f67176c) || this.f67178e != RequestCoordinator.RequestState.SUCCESS);
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f67175b) {
            this.f67180g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f67178e = requestState;
            this.f67179f = requestState;
            this.f67177d.clear();
            this.f67176c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(Request request) {
        synchronized (this.f67175b) {
            try {
                if (!request.equals(this.f67176c)) {
                    this.f67179f = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.f67178e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f67174a;
                if (requestCoordinator != null) {
                    requestCoordinator.d(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z2;
        synchronized (this.f67175b) {
            z2 = this.f67178e == RequestCoordinator.RequestState.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(Request request) {
        synchronized (this.f67175b) {
            try {
                if (request.equals(this.f67177d)) {
                    this.f67179f = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.f67178e = RequestCoordinator.RequestState.SUCCESS;
                RequestCoordinator requestCoordinator = this.f67174a;
                if (requestCoordinator != null) {
                    requestCoordinator.f(this);
                }
                if (!this.f67179f.b()) {
                    this.f67177d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean g() {
        boolean z2;
        synchronized (this.f67175b) {
            z2 = this.f67178e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f67175b) {
            try {
                RequestCoordinator requestCoordinator = this.f67174a;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean h(Request request) {
        if (request instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
            if (this.f67176c != null ? this.f67176c.h(thumbnailRequestCoordinator.f67176c) : thumbnailRequestCoordinator.f67176c == null) {
                if (this.f67177d == null) {
                    if (thumbnailRequestCoordinator.f67177d == null) {
                        return true;
                    }
                } else if (this.f67177d.h(thumbnailRequestCoordinator.f67177d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void i() {
        synchronized (this.f67175b) {
            try {
                this.f67180g = true;
                try {
                    if (this.f67178e != RequestCoordinator.RequestState.SUCCESS) {
                        RequestCoordinator.RequestState requestState = this.f67179f;
                        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState != requestState2) {
                            this.f67179f = requestState2;
                            this.f67177d.i();
                        }
                    }
                    if (this.f67180g) {
                        RequestCoordinator.RequestState requestState3 = this.f67178e;
                        RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState3 != requestState4) {
                            this.f67178e = requestState4;
                            this.f67176c.i();
                        }
                    }
                    this.f67180g = false;
                } catch (Throwable th) {
                    this.f67180g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z2;
        synchronized (this.f67175b) {
            z2 = this.f67178e == RequestCoordinator.RequestState.RUNNING;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean j(Request request) {
        boolean z2;
        synchronized (this.f67175b) {
            try {
                z2 = k() && request.equals(this.f67176c) && this.f67178e != RequestCoordinator.RequestState.f67124c;
            } finally {
            }
        }
        return z2;
    }

    public void n(Request request, Request request2) {
        this.f67176c = request;
        this.f67177d = request2;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f67175b) {
            try {
                if (!this.f67179f.b()) {
                    this.f67179f = RequestCoordinator.RequestState.f67124c;
                    this.f67177d.pause();
                }
                if (!this.f67178e.b()) {
                    this.f67178e = RequestCoordinator.RequestState.f67124c;
                    this.f67176c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
