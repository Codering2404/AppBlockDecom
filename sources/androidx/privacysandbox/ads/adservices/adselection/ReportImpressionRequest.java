package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
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
public final class ReportImpressionRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSelectionConfig f51173b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51174a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest a(ReportImpressionRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                if (Intrinsics.areEqual(request.b(), AdSelectionConfig.f51115h.a())) {
                    t0.a();
                    return r0.a(request.c());
                }
                t0.a();
                return s0.a(request.c(), request.b().d());
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext4Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51175a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest a(ReportImpressionRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                if (Intrinsics.areEqual(request.b(), AdSelectionConfig.f51115h.a())) {
                    throw new UnsupportedOperationException("adSelectionConfig is mandatory forAPI versions lower than ext 10");
                }
                t0.a();
                return s0.a(request.c(), request.b().d());
            }

            private Companion() {
            }
        }
    }

    public final android.adservices.adselection.ReportImpressionRequest a() {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        return (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) ? Ext10Impl.f51174a.a(this) : Ext4Impl.f51175a.a(this);
    }

    public final AdSelectionConfig b() {
        return this.f51173b;
    }

    public final long c() {
        return this.f51172a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        return this.f51172a == reportImpressionRequest.f51172a && Intrinsics.areEqual(this.f51173b, reportImpressionRequest.f51173b);
    }

    public int hashCode() {
        return (Long.hashCode(this.f51172a) * 31) + this.f51173b.hashCode();
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.f51172a + ", adSelectionConfig=" + this.f51173b;
    }
}
