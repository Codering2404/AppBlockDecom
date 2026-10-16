package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Component;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Singleton
@Component
abstract class TransportRuntimeComponent implements Closeable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Component.Builder
    interface Builder {
        Builder a(Context context);

        TransportRuntimeComponent build();
    }

    TransportRuntimeComponent() {
    }

    abstract EventStore a();

    abstract TransportRuntime b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
