package androidx.webkit;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class UserAgentMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f53897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f53899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f53900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f53901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f53902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f53903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f53904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f53905i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class BrandVersion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f53906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f53907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f53908c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BrandVersion)) {
                return false;
            }
            BrandVersion brandVersion = (BrandVersion) obj;
            return Objects.equals(this.f53906a, brandVersion.f53906a) && Objects.equals(this.f53907b, brandVersion.f53907b) && Objects.equals(this.f53908c, brandVersion.f53908c);
        }

        public int hashCode() {
            return Objects.hash(this.f53906a, this.f53907b, this.f53908c);
        }

        public String toString() {
            return this.f53906a + "," + this.f53907b + "," + this.f53908c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAgentMetadata)) {
            return false;
        }
        UserAgentMetadata userAgentMetadata = (UserAgentMetadata) obj;
        return this.f53903g == userAgentMetadata.f53903g && this.f53904h == userAgentMetadata.f53904h && this.f53905i == userAgentMetadata.f53905i && Objects.equals(this.f53897a, userAgentMetadata.f53897a) && Objects.equals(this.f53898b, userAgentMetadata.f53898b) && Objects.equals(this.f53899c, userAgentMetadata.f53899c) && Objects.equals(this.f53900d, userAgentMetadata.f53900d) && Objects.equals(this.f53901e, userAgentMetadata.f53901e) && Objects.equals(this.f53902f, userAgentMetadata.f53902f);
    }

    public int hashCode() {
        return Objects.hash(this.f53897a, this.f53898b, this.f53899c, this.f53900d, this.f53901e, this.f53902f, Boolean.valueOf(this.f53903g), Integer.valueOf(this.f53904h), Boolean.valueOf(this.f53905i));
    }
}
