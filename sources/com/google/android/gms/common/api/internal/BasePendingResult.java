package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal zaa = new zaq();
    public static final /* synthetic */ int zad = 0;
    private zas resultGuardian;
    protected final CallbackHandler zab;
    protected final WeakReference zac;
    private ResultCallback zah;
    private Result zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private ICancelToken zao;
    private volatile zada zap;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CallbackHandler<R extends Result> extends com.google.android.gms.internal.base.zau {
        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public final void a(ResultCallback resultCallback, Result result) {
            int i3 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.m(resultCallback), result)));
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f71540j);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i3, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.a(result);
            } catch (RuntimeException e3) {
                BasePendingResult.zal(result);
                throw e3;
            }
        }
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zab = new CallbackHandler(googleApiClient != null ? googleApiClient.k() : Looper.getMainLooper());
        this.zac = new WeakReference(googleApiClient);
    }

    private final Result a() {
        Result result;
        synchronized (this.zae) {
            Preconditions.r(!this.zal, "Result has already been consumed.");
            Preconditions.r(isReady(), "Result is not ready.");
            result = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        zadb zadbVar = (zadb) this.zai.getAndSet(null);
        if (zadbVar != null) {
            zadbVar.f71829a.f71831a.remove(this);
        }
        return (Result) Preconditions.m(result);
    }

    private final void b(Result result) {
        this.zaj = result;
        this.zak = result.getStatus();
        zar zarVar = null;
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            ResultCallback resultCallback = this.zah;
            if (resultCallback != null) {
                this.zab.removeMessages(2);
                this.zab.a(resultCallback, a());
            } else if (this.zaj instanceof Releasable) {
                this.resultGuardian = new zas(this, zarVar);
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((PendingResult.StatusListener) arrayList.get(i3)).a(this.zak);
        }
        this.zag.clear();
    }

    public static void zal(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e3) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e3);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    statusListener.a(this.zak);
                } else {
                    this.zag.add(statusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    public final R await() {
        Preconditions.l("await must not be called on the UI thread");
        Preconditions.r(!this.zal, "Result has already been consumed");
        Preconditions.r(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f71538h);
        }
        Preconditions.r(isReady(), "Result is not ready.");
        return (R) a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zae) {
            if (!this.zam && !this.zal) {
                ICancelToken iCancelToken = this.zao;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zal(this.zaj);
                this.zam = true;
                b(createFailedResult(Status.f71541k));
            }
        }
    }

    protected abstract Result createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z2;
        synchronized (this.zae) {
            z2 = this.zam;
        }
        return z2;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    protected final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zae) {
            this.zao = iCancelToken;
        }
    }

    public final void setResult(R r2) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r2);
                    return;
                }
                isReady();
                Preconditions.r(!isReady(), "Results have already been set");
                Preconditions.r(!this.zal, "Result has already been consumed");
                b(r2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.zae) {
            try {
                if (resultCallback == null) {
                    this.zah = null;
                    return;
                }
                boolean z2 = true;
                Preconditions.r(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z2 = false;
                }
                Preconditions.r(z2, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(resultCallback, a());
                } else {
                    this.zah = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> transformedResultB;
        Preconditions.r(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                Preconditions.r(this.zap == null, "Cannot call then() twice.");
                Preconditions.r(this.zah == null, "Cannot call then() if callbacks are set.");
                Preconditions.r(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new zada(this.zac);
                transformedResultB = this.zap.b(resultTransform);
                if (isReady()) {
                    this.zab.a(this.zap, a());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return transformedResultB;
    }

    public final void zak() {
        boolean z2 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z2 = false;
        }
        this.zaq = z2;
    }

    public final boolean zam() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            try {
                if (((GoogleApiClient) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                zIsCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsCanceled;
    }

    public final void zan(zadb zadbVar) {
        this.zai.set(zadbVar);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @ResultIgnorabilityUnspecified
    public final R await(long j3, TimeUnit timeUnit) {
        if (j3 > 0) {
            Preconditions.l("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.r(!this.zal, "Result has already been consumed.");
        Preconditions.r(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j3, timeUnit)) {
                forceFailureUnlessReady(Status.f71540j);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f71538h);
        }
        Preconditions.r(isReady(), "Result is not ready.");
        return (R) a();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j3, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (resultCallback == null) {
                    this.zah = null;
                    return;
                }
                boolean z2 = true;
                Preconditions.r(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z2 = false;
                }
                Preconditions.r(z2, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(resultCallback, a());
                } else {
                    this.zah = resultCallback;
                    CallbackHandler callbackHandler = this.zab;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
