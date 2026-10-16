package com.revenuecat.purchases.models;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.Store;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class StoreReplacementModeConversionsKt {
    private static final Map<StoreReplacementMode, StoreReplacementModeMapping> storeReplacementModeMappings = MapsKt.mapOf(TuplesKt.a(StoreReplacementMode.WITHOUT_PRORATION, new StoreReplacementModeMapping(3, "IMMEDIATE_WITHOUT_PRORATION", "INSTANT_NO_PRORATION", GoogleReplacementMode.WITHOUT_PRORATION)), TuplesKt.a(StoreReplacementMode.WITH_TIME_PRORATION, new StoreReplacementModeMapping(1, "IMMEDIATE_WITH_TIME_PRORATION", "INSTANT_PRORATED_DATE", GoogleReplacementMode.WITH_TIME_PRORATION)), TuplesKt.a(StoreReplacementMode.CHARGE_FULL_PRICE, new StoreReplacementModeMapping(5, "IMMEDIATE_AND_CHARGE_FULL_PRICE", null, GoogleReplacementMode.CHARGE_FULL_PRICE)), TuplesKt.a(StoreReplacementMode.CHARGE_PRORATED_PRICE, new StoreReplacementModeMapping(2, "IMMEDIATE_AND_CHARGE_PRORATED_PRICE", "INSTANT_PRORATED_CHARGE", GoogleReplacementMode.CHARGE_PRORATED_PRICE)), TuplesKt.a(StoreReplacementMode.DEFERRED, new StoreReplacementModeMapping(6, "DEFERRED", "DEFERRED", GoogleReplacementMode.DEFERRED)));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GoogleReplacementMode.values().length];
            try {
                iArr2[GoogleReplacementMode.WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GoogleReplacementMode.WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GoogleReplacementMode.CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GoogleReplacementMode.CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GoogleReplacementMode.DEFERRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final StoreReplacementModeMapping getMapping(StoreReplacementMode storeReplacementMode) {
        return (StoreReplacementModeMapping) MapsKt.getValue(storeReplacementModeMappings, storeReplacementMode);
    }

    public static final String legacyPlayBackendName(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        return getMapping(storeReplacementMode).getLegacyPlayBackendName();
    }

    public static final String storeBackendName(StoreReplacementMode storeReplacementMode, Store store) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        int i3 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i3 == 1) {
            return legacyPlayBackendName(storeReplacementMode);
        }
        if (i3 != 2) {
            return null;
        }
        return getMapping(storeReplacementMode).getGalaxyBackendName();
    }

    public static final GoogleReplacementMode toGoogleReplacementMode(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        return getMapping(storeReplacementMode).getGoogleReplacementMode();
    }

    public static final StoreReplacementMode toStoreReplacementMode(GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(googleReplacementMode, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$1[googleReplacementMode.ordinal()];
        if (i3 == 1) {
            return StoreReplacementMode.WITHOUT_PRORATION;
        }
        if (i3 == 2) {
            return StoreReplacementMode.WITH_TIME_PRORATION;
        }
        if (i3 == 3) {
            return StoreReplacementMode.CHARGE_FULL_PRICE;
        }
        if (i3 == 4) {
            return StoreReplacementMode.CHARGE_PRORATED_PRICE;
        }
        if (i3 == 5) {
            return StoreReplacementMode.DEFERRED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final StoreReplacementMode toStoreReplacementModeOrNull(ReplacementMode replacementMode) {
        if (replacementMode == null) {
            return null;
        }
        if (replacementMode instanceof StoreReplacementMode) {
            return (StoreReplacementMode) replacementMode;
        }
        if (replacementMode instanceof GoogleReplacementMode) {
            return toStoreReplacementMode((GoogleReplacementMode) replacementMode);
        }
        return null;
    }

    public static final int toPlayBillingClientMode(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, KqqtdetwHMIO.zCGoBIqWrDu);
        return getMapping(storeReplacementMode).getPlayBillingClientMode();
    }
}
