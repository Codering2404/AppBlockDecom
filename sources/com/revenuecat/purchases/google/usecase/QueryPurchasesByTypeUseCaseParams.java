package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class QueryPurchasesByTypeUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final String productType;

    public QueryPurchasesByTypeUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z2, String productType) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.dateProvider = dateProvider;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.appInBackground = z2;
        this.productType = productType;
    }

    public static /* synthetic */ QueryPurchasesByTypeUseCaseParams copy$default(QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams, DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dateProvider = queryPurchasesByTypeUseCaseParams.dateProvider;
        }
        if ((i3 & 2) != 0) {
            diagnosticsTracker = queryPurchasesByTypeUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        if ((i3 & 4) != 0) {
            z2 = queryPurchasesByTypeUseCaseParams.appInBackground;
        }
        if ((i3 & 8) != 0) {
            str = queryPurchasesByTypeUseCaseParams.productType;
        }
        return queryPurchasesByTypeUseCaseParams.copy(dateProvider, diagnosticsTracker, z2, str);
    }

    public final DateProvider component1() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker component2() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final boolean component3() {
        return this.appInBackground;
    }

    public final String component4() {
        return this.productType;
    }

    public final QueryPurchasesByTypeUseCaseParams copy(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z2, String productType) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new QueryPurchasesByTypeUseCaseParams(dateProvider, diagnosticsTracker, z2, productType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPurchasesByTypeUseCaseParams)) {
            return false;
        }
        QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams = (QueryPurchasesByTypeUseCaseParams) obj;
        return Intrinsics.areEqual(this.dateProvider, queryPurchasesByTypeUseCaseParams.dateProvider) && Intrinsics.areEqual(this.diagnosticsTrackerIfEnabled, queryPurchasesByTypeUseCaseParams.diagnosticsTrackerIfEnabled) && this.appInBackground == queryPurchasesByTypeUseCaseParams.appInBackground && Intrinsics.areEqual(this.productType, queryPurchasesByTypeUseCaseParams.productType);
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final String getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int iHashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        return ((((iHashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + Boolean.hashCode(this.appInBackground)) * 31) + this.productType.hashCode();
    }

    public String toString() {
        return "QueryPurchasesByTypeUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", appInBackground=" + this.appInBackground + ", productType=" + this.productType + ')';
    }

    public /* synthetic */ QueryPurchasesByTypeUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new DefaultDateProvider() : dateProvider, diagnosticsTracker, z2, str);
    }
}
