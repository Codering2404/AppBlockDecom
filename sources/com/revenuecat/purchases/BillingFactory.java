package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.revenuecat.purchases.amazon.AmazonBilling;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.galaxy.GalaxyBillingMode;
import com.revenuecat.purchases.galaxy.GalaxyBillingWrapperFactory;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper;
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
public final class BillingFactory {
    public static final BillingFactory INSTANCE = new BillingFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.TEST_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BillingFactory() {
    }

    public final BillingAbstract createBilling(Store store, Application application, BackendHelper backendHelper, DeviceCache cache, boolean z2, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider stateProvider, boolean z3, GalaxyBillingMode galaxyBillingMode, Backend backend) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(galaxyBillingMode, "galaxyBillingMode");
        Intrinsics.checkNotNullParameter(backend, "backend");
        int i3 = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i3 == 1) {
            return new SimulatedStoreBillingWrapper(cache, new Handler(application.getMainLooper()), stateProvider, backend, null, 16, null);
        }
        if (i3 == 2) {
            return new BillingWrapper(new BillingWrapper.ClientFactory(application, z3), new Handler(application.getMainLooper()), null, cache, diagnosticsTracker, stateProvider, null, 68, null);
        }
        if (i3 == 3) {
            try {
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
                return new AmazonBilling(applicationContext, cache, z2, new Handler(application.getMainLooper()), backendHelper, stateProvider, diagnosticsTracker);
            } catch (NoClassDefFoundError e3) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Make sure purchases-amazon is added as dependency", e3);
                throw e3;
            }
        }
        if (i3 == 4) {
            try {
                GalaxyBillingWrapperFactory galaxyBillingWrapperFactory = GalaxyBillingWrapperFactory.INSTANCE;
                Context applicationContext2 = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "application.applicationContext");
                return galaxyBillingWrapperFactory.createGalaxyBillingWrapper(stateProvider, applicationContext2, galaxyBillingMode, cache);
            } catch (NoClassDefFoundError e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Make sure purchases-galaxy is added as dependency", e4);
                throw e4;
            }
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
