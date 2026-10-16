package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zad extends zac {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final TaskCompletionSource f71819b;

    public zad(int i3, TaskCompletionSource taskCompletionSource) {
        super(i3);
        this.f71819b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(Status status) {
        this.f71819b.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(Exception exc) {
        this.f71819b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(zabq zabqVar) throws DeadObjectException {
        try {
            h(zabqVar);
        } catch (DeadObjectException e3) {
            a(zai.e(e3));
            throw e3;
        } catch (RemoteException e4) {
            a(zai.e(e4));
        } catch (RuntimeException e5) {
            this.f71819b.trySetException(e5);
        }
    }

    protected abstract void h(zabq zabqVar);

    @Override // com.google.android.gms.common.api.internal.zai
    public void d(zaad zaadVar, boolean z2) {
    }
}
