package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TopicsStore {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference f89478d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f89479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferencesQueue f89480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f89481c;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.f89481c = executor;
        this.f89479a = sharedPreferences;
    }

    public static synchronized TopicsStore a(Context context, Executor executor) {
        TopicsStore topicsStore;
        try {
            WeakReference weakReference = f89478d;
            topicsStore = weakReference != null ? (TopicsStore) weakReference.get() : null;
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                topicsStore.c();
                f89478d = new WeakReference(topicsStore);
            }
        } catch (Throwable th) {
            throw th;
        }
        return topicsStore;
    }

    private synchronized void c() {
        this.f89480b = SharedPreferencesQueue.c(this.f89479a, "topic_operation_queue", ",", this.f89481c);
    }

    synchronized TopicOperation b() {
        return TopicOperation.a(this.f89480b.e());
    }

    synchronized boolean d(TopicOperation topicOperation) {
        return this.f89480b.f(topicOperation.e());
    }
}
