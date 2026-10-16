package androidx.work;

import android.net.Uri;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Constraints {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f54479i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Constraints f54480j = new Constraints(null, false, false, false, 15, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkType f54481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f54482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f54483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f54484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f54485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f54486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f54487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f54488h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f54489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f54490b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f54492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f54493e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private NetworkType f54491c = NetworkType.NOT_REQUIRED;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f54494f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f54495g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Set f54496h = new LinkedHashSet();

        public final Constraints a() {
            Set set = CollectionsKt.toSet(this.f54496h);
            long j3 = this.f54494f;
            long j4 = this.f54495g;
            return new Constraints(this.f54491c, this.f54489a, this.f54490b, this.f54492d, this.f54493e, j3, j4, set);
        }

        public final Builder b(NetworkType networkType) {
            Intrinsics.checkNotNullParameter(networkType, "networkType");
            this.f54491c = networkType;
            return this;
        }

        public final Builder c(boolean z2) {
            this.f54492d = z2;
            return this;
        }

        public final Builder d(boolean z2) {
            this.f54489a = z2;
            return this;
        }

        public final Builder e(boolean z2) {
            this.f54490b = z2;
            return this;
        }

        public final Builder f(boolean z2) {
            this.f54493e = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ContentUriTrigger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f54497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f54498b;

        public ContentUriTrigger(Uri uri, boolean z2) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f54497a = uri;
            this.f54498b = z2;
        }

        public final Uri a() {
            return this.f54497a;
        }

        public final boolean b() {
            return this.f54498b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(ContentUriTrigger.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return Intrinsics.areEqual(this.f54497a, contentUriTrigger.f54497a) && this.f54498b == contentUriTrigger.f54498b;
        }

        public int hashCode() {
            return (this.f54497a.hashCode() * 31) + Boolean.hashCode(this.f54498b);
        }
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4);
    }

    public final long a() {
        return this.f54487g;
    }

    public final long b() {
        return this.f54486f;
    }

    public final Set c() {
        return this.f54488h;
    }

    public final NetworkType d() {
        return this.f54481a;
    }

    public final boolean e() {
        return !this.f54488h.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Constraints.class, obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.f54482b == constraints.f54482b && this.f54483c == constraints.f54483c && this.f54484d == constraints.f54484d && this.f54485e == constraints.f54485e && this.f54486f == constraints.f54486f && this.f54487g == constraints.f54487g && this.f54481a == constraints.f54481a) {
            return Intrinsics.areEqual(this.f54488h, constraints.f54488h);
        }
        return false;
    }

    public final boolean f() {
        return this.f54484d;
    }

    public final boolean g() {
        return this.f54482b;
    }

    public final boolean h() {
        return this.f54483c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f54481a.hashCode() * 31) + (this.f54482b ? 1 : 0)) * 31) + (this.f54483c ? 1 : 0)) * 31) + (this.f54484d ? 1 : 0)) * 31) + (this.f54485e ? 1 : 0)) * 31;
        long j3 = this.f54486f;
        int i3 = (iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f54487g;
        return ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f54488h.hashCode();
    }

    public final boolean i() {
        return this.f54485e;
    }

    public String toString() {
        return "Constraints{requiredNetworkType=" + this.f54481a + ", requiresCharging=" + this.f54482b + ", requiresDeviceIdle=" + this.f54483c + ", requiresBatteryNotLow=" + this.f54484d + rnFwbPAQmQTnL.AkLaKh + this.f54485e + ", contentTriggerUpdateDelayMillis=" + this.f54486f + ", contentTriggerMaxDelayMillis=" + this.f54487g + ", contentUriTriggers=" + this.f54488h + ", }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Constraints(NetworkType requiredNetworkType, boolean z2, boolean z3, boolean z4) {
        this(requiredNetworkType, z2, false, z3, z4);
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Constraints(NetworkType requiredNetworkType, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(requiredNetworkType, z2, z3, z4, z5, -1L, 0L, null, 192, null);
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, Set set, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4, (i3 & 16) != 0 ? false : z5, (i3 & 32) != 0 ? -1L : j3, (i3 & 64) != 0 ? -1L : j4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? SetsKt.emptySet() : set);
    }

    public Constraints(NetworkType requiredNetworkType, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, Set contentUriTriggers) {
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(contentUriTriggers, "contentUriTriggers");
        this.f54481a = requiredNetworkType;
        this.f54482b = z2;
        this.f54483c = z3;
        this.f54484d = z4;
        this.f54485e = z5;
        this.f54486f = j3;
        this.f54487g = j4;
        this.f54488h = contentUriTriggers;
    }

    public Constraints(Constraints other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.f54482b = other.f54482b;
        this.f54483c = other.f54483c;
        this.f54481a = other.f54481a;
        this.f54484d = other.f54484d;
        this.f54485e = other.f54485e;
        this.f54488h = other.f54488h;
        this.f54486f = other.f54486f;
        this.f54487g = other.f54487g;
    }
}
