package androidx.core.text.util;

import androidx.core.text.util.LinkifyCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LinkifyCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f34301a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator f34302b = new Comparator() { // from class: androidx.core.text.util.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LinkifyCompat.a((LinkifyCompat.LinkSpec) obj, (LinkifyCompat.LinkSpec) obj2);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LinkSpec {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f34303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f34304b;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    public static /* synthetic */ int a(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i3 = linkSpec.f34303a;
        int i4 = linkSpec2.f34303a;
        if (i3 < i4) {
            return -1;
        }
        if (i3 > i4) {
            return 1;
        }
        return Integer.compare(linkSpec2.f34304b, linkSpec.f34304b);
    }
}
