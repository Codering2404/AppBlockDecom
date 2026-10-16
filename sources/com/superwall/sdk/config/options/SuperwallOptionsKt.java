package com.superwall.sdk.config.options;

import com.applovin.sdk.AppLovinEventTypes;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.logger.LogScope;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SuperwallOptionsKt {
    public static final Map<String, Object> toMap(SuperwallOptions.NetworkEnvironment networkEnvironment) {
        Intrinsics.checkNotNullParameter(networkEnvironment, "<this>");
        Pair pairA = TuplesKt.a("host_domain", networkEnvironment.getHostDomain());
        Pair pairA2 = TuplesKt.a("base_host", networkEnvironment.getBaseHost());
        Pair pairA3 = TuplesKt.a("collector_host", networkEnvironment.getCollectorHost());
        Pair pairA4 = TuplesKt.a("scheme", networkEnvironment.getScheme());
        Integer port = networkEnvironment.getPort();
        return MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) new Pair[]{pairA, pairA2, pairA3, pairA4, port != null ? TuplesKt.a("port", Integer.valueOf(port.intValue())) : null}));
    }

    public static final Map<String, Object> toMap(SuperwallOptions.Logging logging) {
        Intrinsics.checkNotNullParameter(logging, "<this>");
        Pair pairA = TuplesKt.a(AppLovinEventTypes.USER_COMPLETED_LEVEL, logging.getLevel().toString());
        EnumSet<LogScope> scopes = logging.getScopes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(scopes, 10));
        Iterator<T> it = scopes.iterator();
        while (it.hasNext()) {
            arrayList.add(((LogScope) it.next()).toString());
        }
        return MapsKt.mapOf(pairA, TuplesKt.a("scopes", arrayList));
    }

    public static final Map<String, Object> toMap(SuperwallOptions superwallOptions) {
        Intrinsics.checkNotNullParameter(superwallOptions, "<this>");
        Pair pairA = TuplesKt.a("paywalls", PaywallOptionsKt.toMap(superwallOptions.getPaywalls()));
        Pair pairA2 = TuplesKt.a("network_environment", toMap(superwallOptions.getNetworkEnvironment()));
        Pair pairA3 = TuplesKt.a("event_tracking_behavior", superwallOptions.getEventTrackingBehavior().getDescription());
        Pair pairA4 = TuplesKt.a("is_external_data_collection_enabled", Boolean.valueOf(superwallOptions.getEventTrackingBehavior() == EventTrackingBehavior.ALL));
        String localeIdentifier = superwallOptions.getLocaleIdentifier();
        return MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) new Pair[]{pairA, pairA2, pairA3, pairA4, localeIdentifier != null ? TuplesKt.a("locale_identifier", localeIdentifier) : null, TuplesKt.a("is_game_controller_enabled", Boolean.valueOf(superwallOptions.isGameControllerEnabled())), TuplesKt.a("logging", toMap(superwallOptions.getLogging())), TuplesKt.a("test_mode_behavior", superwallOptions.getTestModeBehavior().name())}));
    }
}
