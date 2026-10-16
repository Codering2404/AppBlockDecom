package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbc extends AsyncTaskLoader implements SignInConnectionListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Semaphore f71249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Set f71250q;

    public zbc(Context context, Set set) {
        super(context);
        this.f71249p = new Semaphore(0);
        this.f71250q = set;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final /* bridge */ /* synthetic */ Object F() {
        Iterator it = this.f71250q.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((GoogleApiClient) it.next()).m(this)) {
                i3++;
            }
        }
        try {
            this.f71249p.tryAcquire(i3, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e3) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e3);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.f71249p.release();
    }

    @Override // androidx.loader.content.Loader
    protected final void r() {
        this.f71249p.drainPermits();
        h();
    }
}
