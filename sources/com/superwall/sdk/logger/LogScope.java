package com.superwall.sdk.logger;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class LogScope {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LogScope[] $VALUES;
    public static final LogScope localizationManager = new LogScope("localizationManager", 0);
    public static final LogScope bounceButton = new LogScope("bounceButton", 1);
    public static final LogScope webEntitlements = new LogScope("webEntitlements", 2);
    public static final LogScope customerInfo = new LogScope("customerInfo", 3);
    public static final LogScope coreData = new LogScope("coreData", 4);
    public static final LogScope configManager = new LogScope("configManager", 5);
    public static final LogScope identityManager = new LogScope("identityManager", 6);
    public static final LogScope debugManager = new LogScope("debugManager", 7);
    public static final LogScope debugView = new LogScope("debugView", 8);
    public static final LogScope localizationView = new LogScope("localizationView", 9);
    public static final LogScope gameControllerManager = new LogScope("gameControllerManager", 10);
    public static final LogScope device = new LogScope(DeviceRequestsHelper.DEVICE_INFO_DEVICE, 11);
    public static final LogScope network = new LogScope("network", 12);
    public static final LogScope paywallEvents = new LogScope("paywallEvents", 13);
    public static final LogScope productsManager = new LogScope("productsManager", 14);
    public static final LogScope storeKitManager = new LogScope("storeKitManager", 15);
    public static final LogScope placements = new LogScope("placements", 16);
    public static final LogScope receipts = new LogScope(cJfnYMIyomoWf.BwtPAlahyt, 17);
    public static final LogScope superwallCore = new LogScope("superwallCore", 18);
    public static final LogScope transactions = new LogScope("transactions", 19);
    public static final LogScope jsEvaluator = new LogScope("jsEvaluator", 20);
    public static final LogScope paywallPresentation = new LogScope("paywallPresentation", 21);
    public static final LogScope paywallTransactions = new LogScope("paywallTransactions", 22);
    public static final LogScope paywallView = new LogScope("paywallView", 23);
    public static final LogScope nativePurchaseController = new LogScope("nativePurchaseController", 24);
    public static final LogScope cache = new LogScope("cache", 25);
    public static final LogScope deepLinks = new LogScope("deepLinks", 26);
    public static final LogScope all = new LogScope("all", 27);

    private static final /* synthetic */ LogScope[] $values() {
        return new LogScope[]{localizationManager, bounceButton, webEntitlements, customerInfo, coreData, configManager, identityManager, debugManager, debugView, localizationView, gameControllerManager, device, network, paywallEvents, productsManager, storeKitManager, placements, receipts, superwallCore, transactions, jsEvaluator, paywallPresentation, paywallTransactions, paywallView, nativePurchaseController, cache, deepLinks, all};
    }

    private LogScope(String str, int i3) {
    }

    public static EnumEntries<LogScope> getEntries() {
        return $ENTRIES;
    }

    public static LogScope valueOf(String str) {
        return (LogScope) Enum.valueOf(LogScope.class, str);
    }

    public static LogScope[] values() {
        return (LogScope[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    static {
        LogScope[] logScopeArr$values = $values();
        $VALUES = logScopeArr$values;
        $ENTRIES = EnumEntriesKt.a(logScopeArr$values);
    }
}
