package com.revenuecat.purchases.deeplinks;

import android.net.Uri;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class DeepLinkParser {
    public static final DeepLinkParser INSTANCE = new DeepLinkParser();
    private static final String REDEEM_WEB_PURCHASE_HOST = "redeem_web_purchase";

    private DeepLinkParser() {
    }

    public final WebPurchaseRedemption parseWebPurchaseRedemption(Uri data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data.getHost(), REDEEM_WEB_PURCHASE_HOST)) {
            String queryParameter = data.getQueryParameter("redemption_token");
            if (queryParameter != null && !StringsKt.p0(queryParameter)) {
                return new WebPurchaseRedemption(queryParameter);
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Redemption token is missing web redemption deep link. Ignoring.");
            }
            return null;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Unrecognized deep link host: " + data.getHost() + ". Ignoring");
        }
        return null;
    }
}
