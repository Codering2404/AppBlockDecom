package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TopicsSubscriber {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f89482i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Metadata f89484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GmsRpc f89485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FirebaseMessaging f89486d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f89488f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TopicsStore f89490h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f89487e = new ArrayMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f89489g = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f89486d = firebaseMessaging;
        this.f89484b = metadata;
        this.f89490h = topicsStore;
        this.f89485c = gmsRpc;
        this.f89483a = context;
        this.f89488f = scheduledExecutorService;
    }

    public static /* synthetic */ TopicsSubscriber a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.a(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private static void b(Task task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e3);
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e4);
            }
            throw ((RuntimeException) cause);
        }
    }

    private void c(String str) throws IOException {
        b(this.f89485c.l(this.f89486d.k(), str));
    }

    private void d(String str) throws IOException {
        b(this.f89485c.m(this.f89486d.k(), str));
    }

    static Task e(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc gmsRpc, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TopicsSubscriber.a(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc);
            }
        });
    }

    static boolean g() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    private void i(TopicOperation topicOperation) {
        synchronized (this.f89487e) {
            try {
                String strE = topicOperation.e();
                if (this.f89487e.containsKey(strE)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f89487e.get(strE);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f89487e.remove(strE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m() {
        if (h()) {
            return;
        }
        p(0L);
    }

    boolean f() {
        return this.f89490h.b() != null;
    }

    synchronized boolean h() {
        return this.f89489g;
    }

    boolean j(TopicOperation topicOperation) throws IOException {
        try {
            String strB = topicOperation.b();
            int iHashCode = strB.hashCode();
            if (iHashCode != 83) {
                if (iHashCode == 85 && strB.equals("U")) {
                    d(topicOperation.c());
                    if (!g()) {
                        return true;
                    }
                    Log.d("FirebaseMessaging", "Unsubscribe from topic: " + topicOperation.c() + " succeeded.");
                    return true;
                }
            } else if (strB.equals("S")) {
                c(topicOperation.c());
                if (!g()) {
                    return true;
                }
                Log.d("FirebaseMessaging", "Subscribe to topic: " + topicOperation.c() + " succeeded.");
                return true;
            }
            if (!g()) {
                return true;
            }
            Log.d("FirebaseMessaging", "Unknown topic operation" + topicOperation + ".");
            return true;
        } catch (IOException e3) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e3.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e3.getMessage()) && !"TOO_MANY_SUBSCRIBERS".equals(e3.getMessage())) {
                if (e3.getMessage() != null) {
                    throw e3;
                }
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            Log.e("FirebaseMessaging", "Topic operation failed: " + e3.getMessage() + ". Will retry Topic operation.");
            return false;
        }
    }

    void k(Runnable runnable, long j3) {
        this.f89488f.schedule(runnable, j3, TimeUnit.SECONDS);
    }

    synchronized void l(boolean z2) {
        this.f89489g = z2;
    }

    void n() {
        if (f()) {
            m();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (g() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean o() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.f89490h     // Catch: java.lang.Throwable -> L17
            com.google.firebase.messaging.TopicOperation r0 = r0.b()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1c
            boolean r0 = g()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = move-exception
            goto L2e
        L19:
            r0 = 1
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.j(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            com.google.firebase.messaging.TopicsStore r1 = r2.f89490h
            r1.d(r0)
            r2.i(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.o():boolean");
    }

    void p(long j3) {
        k(new TopicsSyncTask(this, this.f89483a, this.f89484b, Math.min(Math.max(30L, 2 * j3), f89482i)), j3);
        l(true);
    }
}
