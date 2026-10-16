package com.bumptech.glide.load.engine.executor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class RuntimeCompat {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.executor.RuntimeCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f66649a;

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f66649a.matcher(str).matches();
        }
    }

    static int a() {
        return Runtime.getRuntime().availableProcessors();
    }
}
