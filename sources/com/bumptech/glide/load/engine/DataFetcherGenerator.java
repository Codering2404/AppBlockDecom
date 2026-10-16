package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
interface DataFetcherGenerator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FetcherReadyCallback {
        void a(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource);

        void c();

        void e(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2);
    }

    boolean b();

    void cancel();
}
