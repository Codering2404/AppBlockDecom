package cz.mobilesoft.coreblock.util.analytics;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.LockieApplication;
import java.util.HashMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppsFlyerLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppsFlyerLogger f128214a = new AppsFlyerLogger();

    private AppsFlyerLogger() {
    }

    public final void a(StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        try {
            HashMap map = new HashMap();
            map.put(AFInAppEventParameterName.REVENUE, Double.valueOf(product.getPrice().getAmountMicros() / 1000000.0d));
            map.put(AFInAppEventParameterName.CURRENCY, product.getPrice().getCurrencyCode());
            AppsFlyerLib.getInstance().logEvent(LockieApplication.g(), AFInAppEventType.SUBSCRIBE, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
