package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f82932a;

    private static long b(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        long jB = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jB += b(file2);
            }
        }
        return jB;
    }

    final long a() {
        return b(new File(this.f82932a.getFilesDir(), "assetpacks"));
    }
}
