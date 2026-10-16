package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigCacheClient {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f89693d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f89694e = new androidx.credentials.c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f89695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConfigStorageClient f89696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Task f89697c = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f89698a;

        private AwaitListener() {
            this.f89698a = new CountDownLatch(1);
        }

        public boolean a(long j3, TimeUnit timeUnit) {
            return this.f89698a.await(j3, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.f89698a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f89698a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(Object obj) {
            this.f89698a.countDown();
        }
    }

    private ConfigCacheClient(Executor executor, ConfigStorageClient configStorageClient) {
        this.f89695a = executor;
        this.f89696b = configStorageClient;
    }

    public static /* synthetic */ Task a(ConfigCacheClient configCacheClient, boolean z2, ConfigContainer configContainer, Void r3) {
        if (z2) {
            configCacheClient.k(configContainer);
        } else {
            configCacheClient.getClass();
        }
        return Tasks.forResult(configContainer);
    }

    private static Object c(Task task, long j3, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = f89694e;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (!awaitListener.a(j3, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static synchronized ConfigCacheClient h(Executor executor, ConfigStorageClient configStorageClient) {
        String strB;
        Map map;
        try {
            strB = configStorageClient.b();
            map = f89693d;
            if (!map.containsKey(strB)) {
                map.put(strB, new ConfigCacheClient(executor, configStorageClient));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ConfigCacheClient) map.get(strB);
    }

    private synchronized void k(ConfigContainer configContainer) {
        this.f89697c = Tasks.forResult(configContainer);
    }

    public void d() {
        synchronized (this) {
            this.f89697c = Tasks.forResult(null);
        }
        this.f89696b.a();
    }

    public synchronized Task e() {
        try {
            Task task = this.f89697c;
            if (task == null || (task.isComplete() && !this.f89697c.isSuccessful())) {
                Executor executor = this.f89695a;
                final ConfigStorageClient configStorageClient = this.f89696b;
                Objects.requireNonNull(configStorageClient);
                this.f89697c = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return configStorageClient.d();
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f89697c;
    }

    public ConfigContainer f() {
        return g(5L);
    }

    ConfigContainer g(long j3) {
        synchronized (this) {
            try {
                Task task = this.f89697c;
                if (task != null && task.isSuccessful()) {
                    return (ConfigContainer) this.f89697c.getResult();
                }
                try {
                    return (ConfigContainer) c(e(), j3, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e3) {
                    Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e3);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task i(ConfigContainer configContainer) {
        return j(configContainer, true);
    }

    public Task j(final ConfigContainer configContainer, final boolean z2) {
        return Tasks.call(this.f89695a, new Callable() { // from class: com.google.firebase.remoteconfig.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f89806a.f89696b.e(configContainer);
            }
        }).onSuccessTask(this.f89695a, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ConfigCacheClient.a(this.f89808a, z2, configContainer, (Void) obj);
            }
        });
    }
}
