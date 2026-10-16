package com.google.common.hash;

import java.nio.Buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Java8Compatibility {
    static void a(Buffer buffer) {
        buffer.clear();
    }

    static void b(Buffer buffer) {
        buffer.flip();
    }

    static void c(Buffer buffer, int i3) {
        buffer.limit(i3);
    }

    static void d(Buffer buffer, int i3) {
        buffer.position(i3);
    }
}
