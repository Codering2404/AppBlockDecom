package com.google.common.escape;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f84893a = new ThreadLocal<char[]>() { // from class: com.google.common.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    };

    static char[] a() {
        char[] cArr = (char[]) f84893a.get();
        Objects.requireNonNull(cArr);
        return cArr;
    }
}
