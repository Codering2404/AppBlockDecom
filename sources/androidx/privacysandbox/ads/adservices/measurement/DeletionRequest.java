package androidx.privacysandbox.ads.adservices.measurement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DeletionRequest {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f51314g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f51315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f51316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Instant f51317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Instant f51318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f51319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f51320f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface DeletionMode {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final android.adservices.measurement.DeletionRequest a() {
        android.adservices.measurement.DeletionRequest deletionRequestBuild = h.a().setDeletionMode(this.f51315a).setMatchBehavior(this.f51316b).setStart(this.f51317c).setEnd(this.f51318d).setDomainUris(this.f51319e).setOriginUris(this.f51320f).build();
        Intrinsics.checkNotNullExpressionValue(deletionRequestBuild, "Builder()\n            .s…ris)\n            .build()");
        return deletionRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        return this.f51315a == deletionRequest.f51315a && Intrinsics.areEqual(new HashSet(this.f51319e), new HashSet(deletionRequest.f51319e)) && Intrinsics.areEqual(new HashSet(this.f51320f), new HashSet(deletionRequest.f51320f)) && Intrinsics.areEqual(this.f51317c, deletionRequest.f51317c) && Intrinsics.areEqual(this.f51318d, deletionRequest.f51318d) && this.f51316b == deletionRequest.f51316b;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f51315a) * 31) + this.f51319e.hashCode()) * 31) + this.f51320f.hashCode()) * 31) + this.f51317c.hashCode()) * 31) + this.f51318d.hashCode()) * 31) + Integer.hashCode(this.f51316b);
    }

    public String toString() {
        return "DeletionRequest { DeletionMode=" + (this.f51315a == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA") + ", MatchBehavior=" + (this.f51316b == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE") + ", Start=" + this.f51317c + ", End=" + this.f51318d + ", DomainUris=" + this.f51319e + ", OriginUris=" + this.f51320f + " }";
    }
}
