package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference f71826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zacz f71827i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultTransform f71820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zada f71821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile ResultCallbacks f71822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PendingResult f71823d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f71824f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Status f71825g = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f71828j = false;

    public zada(WeakReference weakReference) {
        Preconditions.n(weakReference, "GoogleApiClient reference must not be null");
        this.f71826h = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.f71827i = new zacz(this, googleApiClient != null ? googleApiClient.k() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Status status) {
        synchronized (this.f71824f) {
            this.f71825g = status;
            n(status);
        }
    }

    private final void m() {
        if (this.f71820a == null && this.f71822c == null) {
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f71826h.get();
        if (!this.f71828j && this.f71820a != null && googleApiClient != null) {
            googleApiClient.q(this);
            this.f71828j = true;
        }
        Status status = this.f71825g;
        if (status != null) {
            n(status);
            return;
        }
        PendingResult pendingResult = this.f71823d;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    private final void n(Status status) {
        synchronized (this.f71824f) {
            try {
                ResultTransform resultTransform = this.f71820a;
                if (resultTransform != null) {
                    ((zada) Preconditions.m(this.f71821b)).l((Status) Preconditions.n(resultTransform.a(status), "onFailure must not return null"));
                } else if (o()) {
                    ((ResultCallbacks) Preconditions.m(this.f71822c)).b(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean o() {
        return (this.f71822c == null || ((GoogleApiClient) this.f71826h.get()) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e3) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e3);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(Result result) {
        synchronized (this.f71824f) {
            try {
                if (!result.getStatus().w0()) {
                    l(result.getStatus());
                    p(result);
                } else if (this.f71820a != null) {
                    zaco.a().submit(new zacy(this, result));
                } else if (o()) {
                    ((ResultCallbacks) Preconditions.m(this.f71822c)).c(result);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final TransformedResult b(ResultTransform resultTransform) {
        zada zadaVar;
        synchronized (this.f71824f) {
            Preconditions.r(this.f71820a == null, "Cannot call then() twice.");
            Preconditions.r(this.f71822c == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f71820a = resultTransform;
            zadaVar = new zada(this.f71826h);
            this.f71821b = zadaVar;
            m();
        }
        return zadaVar;
    }

    final void j() {
        this.f71822c = null;
    }

    public final void k(PendingResult pendingResult) {
        synchronized (this.f71824f) {
            this.f71823d = pendingResult;
            m();
        }
    }
}
