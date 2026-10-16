package com.google.android.libraries.places.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzbpq extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    zzbqa l1(SocketAddress socketAddress, zzbpp zzbppVar, zzbiv zzbivVar);

    ScheduledExecutorService zzb();
}
