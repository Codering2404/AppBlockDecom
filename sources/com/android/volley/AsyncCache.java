package com.android.volley;

import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnGetCompleteCallback {
        void a(Cache.Entry entry);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnWriteCompleteCallback {
        void a();
    }

    public abstract void a(String str, OnGetCompleteCallback onGetCompleteCallback);

    public abstract void b(OnWriteCompleteCallback onWriteCompleteCallback);

    public abstract void c(String str, Cache.Entry entry, OnWriteCompleteCallback onWriteCompleteCallback);
}
