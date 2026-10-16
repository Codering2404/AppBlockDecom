package retrofit2.adapter.rxjava2;

import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f147037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Scheduler f147038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f147039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f147040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f147041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f147042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f147043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f147044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f147045i;

    RxJava2CallAdapter(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f147037a = type;
        this.f147038b = scheduler;
        this.f147039c = z2;
        this.f147040d = z3;
        this.f147041e = z4;
        this.f147042f = z5;
        this.f147043g = z6;
        this.f147044h = z7;
        this.f147045i = z8;
    }

    @Override // retrofit2.CallAdapter
    public Type a() {
        return this.f147037a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(retrofit2.Call r2) {
        /*
            r1 = this;
            boolean r0 = r1.f147039c
            if (r0 == 0) goto La
            retrofit2.adapter.rxjava2.CallEnqueueObservable r0 = new retrofit2.adapter.rxjava2.CallEnqueueObservable
            r0.<init>(r2)
            goto Lf
        La:
            retrofit2.adapter.rxjava2.CallExecuteObservable r0 = new retrofit2.adapter.rxjava2.CallExecuteObservable
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.f147040d
            if (r2 == 0) goto L1a
            retrofit2.adapter.rxjava2.ResultObservable r2 = new retrofit2.adapter.rxjava2.ResultObservable
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.f147041e
            if (r2 == 0) goto L24
            retrofit2.adapter.rxjava2.BodyObservable r2 = new retrofit2.adapter.rxjava2.BodyObservable
            r2.<init>(r0)
            goto L18
        L24:
            io.reactivex.Scheduler r2 = r1.f147038b
            if (r2 == 0) goto L2c
            io.reactivex.Observable r0 = r0.v(r2)
        L2c:
            boolean r2 = r1.f147042f
            if (r2 == 0) goto L37
            io.reactivex.BackpressureStrategy r2 = io.reactivex.BackpressureStrategy.LATEST
            io.reactivex.Flowable r2 = r0.x(r2)
            return r2
        L37:
            boolean r2 = r1.f147043g
            if (r2 == 0) goto L40
            io.reactivex.Single r2 = r0.r()
            return r2
        L40:
            boolean r2 = r1.f147044h
            if (r2 == 0) goto L49
            io.reactivex.Maybe r2 = r0.q()
            return r2
        L49:
            boolean r2 = r1.f147045i
            if (r2 == 0) goto L52
            io.reactivex.Completable r2 = r0.f()
            return r2
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.RxJava2CallAdapter.b(retrofit2.Call):java.lang.Object");
    }
}
