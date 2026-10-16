package com.google.firebase.analytics;

import f.b;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends ThreadPoolExecutor implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        b.a(this);
    }
}
