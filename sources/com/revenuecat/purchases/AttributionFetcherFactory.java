package com.revenuecat.purchases;

import com.revenuecat.purchases.amazon.attribution.AmazonDeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.galaxy.attribution.GalaxyDeviceIdentifiersFetcher;
import com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AttributionFetcherFactory {
    public static final AttributionFetcherFactory INSTANCE = new AttributionFetcherFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AttributionFetcherFactory() {
    }

    public final DeviceIdentifiersFetcher createAttributionFetcher(Store store, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        int i3 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i3 == 1) {
            return new GoogleDeviceIdentifiersFetcher(dispatcher);
        }
        if (i3 == 2) {
            return new AmazonDeviceIdentifiersFetcher();
        }
        if (i3 == 3) {
            return new GalaxyDeviceIdentifiersFetcher();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
