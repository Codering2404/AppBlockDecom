package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SimpleCacheSpan extends CacheSpan {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f42118h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f42119i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f42120j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private SimpleCacheSpan(String str, long j3, long j4, long j5, File file) {
        super(str, j3, j4, j5, file);
    }

    public static SimpleCacheSpan e(File file, long j3, long j4, CachedContentIndex cachedContentIndex) {
        String strI;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            file = j(file, cachedContentIndex);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        File file2 = file;
        Matcher matcher = f42120j.matcher(name);
        if (!matcher.matches() || (strI = cachedContentIndex.i(Integer.parseInt((String) Assertions.e(matcher.group(1))))) == null) {
            return null;
        }
        if (j3 == -1) {
            j3 = file2.length();
        }
        long j5 = j3;
        if (j5 == 0) {
            return null;
        }
        return new SimpleCacheSpan(strI, Long.parseLong((String) Assertions.e(matcher.group(2))), j5, j4 == -9223372036854775807L ? Long.parseLong((String) Assertions.e(matcher.group(3))) : j4, file2);
    }

    public static SimpleCacheSpan f(File file, long j3, CachedContentIndex cachedContentIndex) {
        return e(file, j3, -9223372036854775807L, cachedContentIndex);
    }

    public static SimpleCacheSpan g(String str, long j3, long j4) {
        return new SimpleCacheSpan(str, j3, j4, -9223372036854775807L, null);
    }

    public static SimpleCacheSpan h(String str, long j3) {
        return new SimpleCacheSpan(str, j3, -1L, -9223372036854775807L, null);
    }

    public static File i(File file, int i3, long j3, long j4) {
        return new File(file, i3 + "." + j3 + "." + j4 + ".v3.exo");
    }

    private static File j(File file, CachedContentIndex cachedContentIndex) {
        String strS1;
        String name = file.getName();
        Matcher matcher = f42119i.matcher(name);
        if (matcher.matches()) {
            strS1 = Util.s1((String) Assertions.e(matcher.group(1)));
        } else {
            matcher = f42118h.matcher(name);
            strS1 = matcher.matches() ? (String) Assertions.e(matcher.group(1)) : null;
        }
        if (strS1 == null) {
            return null;
        }
        File fileI = i((File) Assertions.i(file.getParentFile()), cachedContentIndex.e(strS1), Long.parseLong((String) Assertions.e(matcher.group(2))), Long.parseLong((String) Assertions.e(matcher.group(3))));
        if (file.renameTo(fileI)) {
            return fileI;
        }
        return null;
    }

    public SimpleCacheSpan d(File file, long j3) {
        Assertions.g(this.f42057d);
        return new SimpleCacheSpan(this.f42054a, this.f42055b, this.f42056c, j3, file);
    }
}
