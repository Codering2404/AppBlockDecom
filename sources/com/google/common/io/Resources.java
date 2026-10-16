package com.google.common.io;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Resources {

    /* JADX INFO: renamed from: com.google.common.io.Resources$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements LineProcessor<List<String>> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UrlByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final URL f85289a;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return this.f85289a.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.f85289a + ")";
        }
    }
}
