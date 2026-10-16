package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdData;
import android.net.Uri;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.Set;
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
public final class AdData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f51189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f51191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdFilters f51192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f51193e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51194a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.common.AdData a(AdData adData) {
                Intrinsics.checkNotNullParameter(adData, "adData");
                AdData.Builder adCounterKeys = a.a().setMetadata(adData.e()).setRenderUri(adData.f()).setAdCounterKeys(adData.b());
                AdFilters adFiltersC = adData.c();
                android.adservices.common.AdData adDataBuild = adCounterKeys.setAdFilters(adFiltersC != null ? adFiltersC.a() : null).setAdRenderId(adData.d()).build();
                Intrinsics.checkNotNullExpressionValue(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext4Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51195a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.common.AdData a(AdData adData) {
                Intrinsics.checkNotNullParameter(adData, "adData");
                if (!adData.b().isEmpty()) {
                    Log.w("AdData", "adCounterKeys is ignored. Min version to use adCounterKeys is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.c() != null) {
                    Log.w("AdData", "adFilters is ignored. Min version to use adFilters is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.d() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                android.adservices.common.AdData adDataBuild = a.a().setMetadata(adData.e()).setRenderUri(adData.f()).build();
                Intrinsics.checkNotNullExpressionValue(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext8Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51196a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.common.AdData a(AdData adData) {
                Intrinsics.checkNotNullParameter(adData, "adData");
                if (adData.d() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                AdData.Builder adCounterKeys = a.a().setMetadata(adData.e()).setRenderUri(adData.f()).setAdCounterKeys(adData.b());
                AdFilters adFiltersC = adData.c();
                android.adservices.common.AdData adDataBuild = adCounterKeys.setAdFilters(adFiltersC != null ? adFiltersC.a() : null).build();
                Intrinsics.checkNotNullExpressionValue(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }
    }

    public final android.adservices.common.AdData a() {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        return (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) ? Ext10Impl.f51194a.a(this) : (adServicesInfo.a() >= 8 || adServicesInfo.b() >= 9) ? Ext8Impl.f51196a.a(this) : Ext4Impl.f51195a.a(this);
    }

    public final Set b() {
        return this.f51191c;
    }

    public final AdFilters c() {
        return this.f51192d;
    }

    public final String d() {
        return this.f51193e;
    }

    public final String e() {
        return this.f51190b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return Intrinsics.areEqual(this.f51189a, adData.f51189a) && Intrinsics.areEqual(this.f51190b, adData.f51190b) && Intrinsics.areEqual(this.f51191c, adData.f51191c) && Intrinsics.areEqual(this.f51192d, adData.f51192d) && Intrinsics.areEqual(this.f51193e, adData.f51193e);
    }

    public final Uri f() {
        return this.f51189a;
    }

    public int hashCode() {
        int iHashCode = ((((this.f51189a.hashCode() * 31) + this.f51190b.hashCode()) * 31) + this.f51191c.hashCode()) * 31;
        AdFilters adFilters = this.f51192d;
        int iHashCode2 = (iHashCode + (adFilters != null ? adFilters.hashCode() : 0)) * 31;
        String str = this.f51193e;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AdData: renderUri=" + this.f51189a + ", metadata='" + this.f51190b + "', adCounterKeys=" + this.f51191c + ", adFilters=" + this.f51192d + ", adRenderId=" + this.f51193e;
    }
}
