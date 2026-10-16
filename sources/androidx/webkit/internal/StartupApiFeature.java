package androidx.webkit.internal;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StartupApiFeature {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f53939c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f53940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53941b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoFramework extends StartupApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class P extends StartupApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }
    }

    StartupApiFeature(String str, String str2) {
        this.f53940a = str;
        this.f53941b = str2;
        f53939c.add(this);
    }
}
