package com.revenuecat.purchases.ads.events;

import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.ads.events.types.AdDisplayedData;
import com.revenuecat.purchases.ads.events.types.AdFailedToLoadData;
import com.revenuecat.purchases.ads.events.types.AdLoadedData;
import com.revenuecat.purchases.ads.events.types.AdOpenedData;
import com.revenuecat.purchases.ads.events.types.AdRevenueData;
import com.revenuecat.purchases.common.events.EventsManager;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdTracker {
    private final EventsManager eventsManager;

    public AdTracker(EventsManager eventsManager) {
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        this.eventsManager = eventsManager;
    }

    public final void trackAdDisplayed(AdDisplayedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventsManager.track(new AdEvent.Displayed(null, 0, null, 0L, data.getNetworkName(), data.m473getMediatorNameGyoM_N4(), data.m472getAdFormaty0COY5Q(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdFailedToLoad(AdFailedToLoadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventsManager.track(new AdEvent.FailedToLoad(null, 0, null, 0L, data.m475getMediatorNameGyoM_N4(), data.m474getAdFormaty0COY5Q(), data.getPlacement(), data.getAdUnitId(), null, data.getMediatorErrorCode(), 15, null));
    }

    public final void trackAdLoaded(AdLoadedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventsManager.track(new AdEvent.Loaded(null, 0, null, 0L, data.getNetworkName(), data.m492getMediatorNameGyoM_N4(), data.m491getAdFormaty0COY5Q(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdOpened(AdOpenedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventsManager.track(new AdEvent.Open(null, 0, null, 0L, data.getNetworkName(), data.m504getMediatorNameGyoM_N4(), data.m503getAdFormaty0COY5Q(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), 15, null));
    }

    public final void trackAdRevenue(AdRevenueData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventsManager.track(new AdEvent.Revenue(null, 0, null, 0L, data.getNetworkName(), data.m506getMediatorNameGyoM_N4(), data.m505getAdFormaty0COY5Q(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), data.getRevenueMicros(), data.getCurrency(), data.m507getPrecisionrAcPn4k(), 15, null));
    }
}
