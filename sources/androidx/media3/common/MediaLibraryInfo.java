package androidx.media3.common;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaLibraryInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet f40851a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f40852b = "media3.common";

    public static synchronized void a(String str) {
        if (f40851a.add(str)) {
            f40852b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f40852b;
    }
}
