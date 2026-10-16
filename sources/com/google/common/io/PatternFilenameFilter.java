package com.google.common.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class PatternFilenameFilter implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f85280a;

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f85280a.matcher(str).matches();
    }
}
