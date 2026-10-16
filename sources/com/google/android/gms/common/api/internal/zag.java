package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zag extends zac {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskApiCall f71835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f71836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StatusExceptionMapper f71837d;

    public zag(int i3, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i3);
        this.f71836c = taskCompletionSource;
        this.f71835b = taskApiCall;
        this.f71837d = statusExceptionMapper;
        if (i3 == 2 && taskApiCall.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(Status status) {
        this.f71836c.trySetException(this.f71837d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(Exception exc) {
        this.f71836c.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(zabq zabqVar) throws DeadObjectException {
        try {
            this.f71835b.b(zabqVar.t(), this.f71836c);
        } catch (DeadObjectException e3) {
            throw e3;
        } catch (RemoteException e4) {
            a(zai.e(e4));
        } catch (RuntimeException e5) {
            this.f71836c.trySetException(e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void d(zaad zaadVar, boolean z2) {
        zaadVar.d(this.f71836c, z2);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(zabq zabqVar) {
        return this.f71835b.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] g(zabq zabqVar) {
        return this.f71835b.e();
    }
}
