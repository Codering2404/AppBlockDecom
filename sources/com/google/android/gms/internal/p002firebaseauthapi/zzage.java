package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzage implements OnFailureListener {
    zzage(zzagc zzagcVar) {
        Objects.requireNonNull(zzagcVar);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        zzagc.zza.c("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
