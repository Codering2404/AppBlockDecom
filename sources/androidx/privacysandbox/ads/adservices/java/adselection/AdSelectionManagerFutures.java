package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

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
public abstract class AdSelectionManagerFutures {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f51239a = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AdSelectionManager f51240b;

        public ListenableFuture<GetAdSelectionDataOutcome> b(GetAdSelectionDataRequest getAdSelectionDataRequest) {
            Intrinsics.checkNotNullParameter(getAdSelectionDataRequest, "getAdSelectionDataRequest");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, null), 3, null), null, 1, null);
        }

        public ListenableFuture<AdSelectionOutcome> c(PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            Intrinsics.checkNotNullParameter(persistAdSelectionResultRequest, "persistAdSelectionResultRequest");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, null), 3, null), null, 1, null);
        }

        public ListenableFuture<Unit> d(ReportEventRequest reportEventRequest) {
            Intrinsics.checkNotNullParameter(reportEventRequest, "reportEventRequest");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, null), 3, null), null, 1, null);
        }

        public ListenableFuture<Unit> e(ReportImpressionRequest reportImpressionRequest) {
            Intrinsics.checkNotNullParameter(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null), 3, null), null, 1, null);
        }

        public ListenableFuture<AdSelectionOutcome> g(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            Intrinsics.checkNotNullParameter(adSelectionFromOutcomesConfig, "adSelectionFromOutcomesConfig");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, null), 3, null), null, 1, null);
        }

        public ListenableFuture<Unit> h(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            Intrinsics.checkNotNullParameter(updateAdCounterHistogramRequest, "updateAdCounterHistogramRequest");
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, null), 3, null), null, 1, null);
        }

        public ListenableFuture<AdSelectionOutcome> f(AdSelectionConfig adSelectionConfig) {
            Intrinsics.checkNotNullParameter(adSelectionConfig, vfptEEmYY.wwWTGDkYv);
            return CoroutineAdapterKt.c(BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.a()), null, null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null), 3, null), null, 1, null);
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
}
