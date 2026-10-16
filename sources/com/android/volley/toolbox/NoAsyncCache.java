package com.android.volley.toolbox;

import com.android.volley.AsyncCache;
import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NoAsyncCache extends AsyncCache {
    @Override // com.android.volley.AsyncCache
    public void a(String str, AsyncCache.OnGetCompleteCallback onGetCompleteCallback) {
        onGetCompleteCallback.a(null);
    }

    @Override // com.android.volley.AsyncCache
    public void b(AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.a();
    }

    @Override // com.android.volley.AsyncCache
    public void c(String str, Cache.Entry entry, AsyncCache.OnWriteCompleteCallback onWriteCompleteCallback) {
        onWriteCompleteCallback.a();
    }
}
