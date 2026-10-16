package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzk implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PhoneAuthOptions f88051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f88052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88053c;

    zzk(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.f88051a = phoneAuthOptions;
        this.f88052b = str;
        Objects.requireNonNull(firebaseAuth);
        this.f88053c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            Log.e("FirebaseAuth", "Error while validating application identity: " + (exception != null ? exception.getMessage() : ""));
            if (exception != null && com.google.firebase.auth.internal.zzb.i(exception)) {
                FirebaseAuth.y((FirebaseException) exception, this.f88051a, this.f88052b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
        }
        this.f88053c.E(this.f88051a, task.getResult());
    }
}
