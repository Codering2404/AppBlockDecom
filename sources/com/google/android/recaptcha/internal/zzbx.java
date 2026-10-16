package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbx {
    public static final Deferred zza(Task task) {
        final CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                CompletableDeferred completableDeferred = completableDeferredB;
                Exception exception = task2.getException();
                if (exception != null) {
                    completableDeferred.a(exception);
                } else if (task2.isCanceled()) {
                    Job.DefaultImpls.b(completableDeferred, null, 1, null);
                } else {
                    completableDeferred.J(task2.getResult());
                }
            }
        });
        return new zzbw(completableDeferredB);
    }
}
