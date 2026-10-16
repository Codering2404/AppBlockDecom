package com.revenuecat.purchases.utils;

import android.content.Context;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.storage.FileRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OfferingVideoPredownloader {
    private final FileRepository fileRepository;
    private final boolean shouldPredownload;

    public OfferingVideoPredownloader(Context context, boolean z2, FileRepository fileRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        this.fileRepository = fileRepository;
        this.shouldPredownload = z2;
    }

    public final void downloadVideos(Offering offering) {
        Offering.PaywallComponents paywallComponents;
        PaywallComponentsData data;
        ComponentsConfig componentsConfig;
        PaywallComponentsConfig base;
        StackComponent stack;
        List<PaywallComponent> listFilter;
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownload || (paywallComponents = offering.getPaywallComponents()) == null || (data = paywallComponents.getData()) == null || (componentsConfig = data.getComponentsConfig()) == null || (base = componentsConfig.getBase()) == null || (stack = base.getStack()) == null || (listFilter = PaywallComponentFilterExtensionKt.filter(stack, new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.utils.OfferingVideoPredownloader.downloadVideos.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PaywallComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof VideoComponent);
            }
        })) == null) {
            return;
        }
        for (PaywallComponent paywallComponent : listFilter) {
            if (paywallComponent instanceof VideoComponent) {
                this.fileRepository.prefetch(OfferingVideoPredownloaderKt.checkedUrls(((VideoComponent) paywallComponent).getSource()));
            }
        }
    }

    public /* synthetic */ OfferingVideoPredownloader(Context context, boolean z2, FileRepository fileRepository, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? UtilsKt.getCanUsePaywallUI() : z2, (i3 & 4) != 0 ? new DefaultFileRepository(context, null, 2, null) : fileRepository);
    }
}
