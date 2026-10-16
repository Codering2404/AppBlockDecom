package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
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
@ExperimentalFeatures.Ext10OptIn
@Metadata
public final class GetAdSelectionDataRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdTechIdentifier f51157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f51158b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51159a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest a(GetAdSelectionDataRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = g0.a().setSeller(request.c().a()).build();
                Intrinsics.checkNotNullExpressionValue(getAdSelectionDataRequestBuild, "Builder()\n              …                 .build()");
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext12Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51160a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest a(GetAdSelectionDataRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = g0.a().setSeller(request.c().a()).setCoordinatorOriginUri(request.b()).build();
                Intrinsics.checkNotNullExpressionValue(getAdSelectionDataRequestBuild, "Builder()\n              …                 .build()");
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }
    }

    public final android.adservices.adselection.GetAdSelectionDataRequest a() {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        return (adServicesInfo.a() >= 12 || adServicesInfo.b() >= 12) ? Ext12Impl.f51160a.a(this) : Ext10Impl.f51159a.a(this);
    }

    public final Uri b() {
        return this.f51158b;
    }

    public final AdTechIdentifier c() {
        return this.f51157a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        return Intrinsics.areEqual(this.f51157a, getAdSelectionDataRequest.f51157a) && Intrinsics.areEqual(this.f51158b, getAdSelectionDataRequest.f51158b);
    }

    public int hashCode() {
        int iHashCode = this.f51157a.hashCode() * 31;
        Uri uri = this.f51158b;
        return iHashCode + (uri != null ? uri.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.f51157a + ", coordinatorOriginUri=" + this.f51158b;
    }
}
