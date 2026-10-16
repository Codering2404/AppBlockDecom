package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class WithinAppServiceBinder extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntentHandler f89504a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface IntentHandler {
        Task a(Intent intent);
    }

    WithinAppServiceBinder(IntentHandler intentHandler) {
        this.f89504a = intentHandler;
    }

    void b(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.f89504a.a(bindRequest.f89511a).addOnCompleteListener(new androidx.credentials.c(), new OnCompleteListener() { // from class: com.google.firebase.messaging.d0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                bindRequest.d();
            }
        });
    }
}
