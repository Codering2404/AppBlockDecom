package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

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
public final class PaywallEngineDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PaywallEngineDefaults f128889a = new PaywallEngineDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f128890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f128891c;

    static {
        String id = RevenueCatPlacement.LimitScreen.getId();
        PaywallEngine paywallEngine = PaywallEngine.Native;
        f128890b = MapsKt.mapOf(TuplesKt.a(id, paywallEngine), TuplesKt.a(RevenueCatPlacement.Onboarding.getId(), paywallEngine));
        f128891c = 8;
    }

    private PaywallEngineDefaults() {
    }

    public final PaywallEngine a(String str) {
        PaywallEngine paywallEngine;
        return (str == null || (paywallEngine = (PaywallEngine) f128890b.get(str)) == null) ? PaywallEngine.RcHosted : paywallEngine;
    }
}
