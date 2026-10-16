package com.revenuecat.purchases.ui.revenuecatui.workflow;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.WorkflowScreen;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WorkflowScreenMapper {
    public static final int $stable = 0;
    public static final WorkflowScreenMapper INSTANCE = new WorkflowScreenMapper();

    private WorkflowScreenMapper() {
    }

    public final Offering.PaywallComponents toPaywallComponents(WorkflowScreen screen, String screenId, UiConfig uiConfig) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        return new Offering.PaywallComponents(uiConfig, toPaywallComponentsData(screen, screenId));
    }

    public final PaywallComponentsData toPaywallComponentsData(WorkflowScreen screen, String screenId) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        return new PaywallComponentsData(screenId, screen.getTemplateName(), screen.getAssetBaseURL(), screen.getComponentsConfig(), screen.getComponentsLocalizations(), screen.m563getDefaultLocaleIdentifieruqtKvyA(), screen.getRevision(), (List) null, (ExitOffers) null, (ProductChangeConfig) null, 896, (DefaultConstructorMarker) null);
    }
}
