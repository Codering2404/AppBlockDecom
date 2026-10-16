package com.facebook.ads.redexgen.core;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0859Le implements Comparator<File> {
    public C0859Le() {
    }

    private int A00(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 == j4 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compare(File file, File file2) {
        return A00(file.lastModified(), file2.lastModified());
    }
}
