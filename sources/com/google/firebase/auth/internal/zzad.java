package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzad extends FirebaseAuth {
    public zzad(FirebaseApp firebaseApp, Provider provider, Provider provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        super(firebaseApp, provider, provider2, executor, executor2, executor3, scheduledExecutorService, executor4);
    }
}
