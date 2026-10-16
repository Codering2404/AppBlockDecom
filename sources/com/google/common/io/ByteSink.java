package com.google.common.io;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ByteSink {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AsCharSink extends CharSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f85223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ByteSink f85224b;

        public String toString() {
            return this.f85224b.toString() + ".asCharSink(" + this.f85223a + ")";
        }
    }
}
