package cz.mobilesoft.coreblock.scene.premium.host;

import com.facebook.internal.ServerProtocol;
import cz.mobilesoft.coreblock.util.monetization.MonetizationConfig;
import cz.mobilesoft.coreblock.util.monetization.PaywallEngine;
import cz.mobilesoft.coreblock.util.monetization.PaywallEngineResolver;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceStore;
import cz.mobilesoft.coreblock.util.paywalltrace.RuleOutcome;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class SuperwallGate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SuperwallGate f113353a = new SuperwallGate();

    private SuperwallGate() {
    }

    public final boolean a(PaywallSpec spec, MonetizationConfig config, Boolean bool, boolean z2, PaywallEngine paywallEngine) {
        PaywallEngine paywallEngine2;
        String str;
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(config, "config");
        if (!spec.b()) {
            return false;
        }
        String id = spec.n().getId();
        PaywallEngineResolver.Decision decisionA = PaywallEngineResolver.f128892a.a(id, config.c(id), bool, true, z2, true, paywallEngine);
        PaywallEngine paywallEngineB = decisionA.b();
        PaywallEngine paywallEngine3 = PaywallEngine.Superwall;
        if (paywallEngineB == paywallEngine3) {
            PaywallTraceStore paywallTraceStore = PaywallTraceStore.f128981a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            PaywallTrace.Stage stage = PaywallTrace.Stage.EngineSelection;
            if (decisionA.a() == paywallEngine3) {
                str = "Superwall on " + id;
            } else {
                str = "Superwall asked for on " + id + " but not available";
            }
            paywallEngine2 = paywallEngine3;
            paywallTraceStore.c(new PaywallTrace(jCurrentTimeMillis, stage, str, id, decisionA.a().getId(), null, null, CollectionsKt.plus((Collection<? extends RuleOutcome>) decisionA.c(), new RuleOutcome("decided before the screen was drawn", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, false, 4, null)), config.d(), null, 0, 1632, null));
        } else {
            paywallEngine2 = paywallEngine3;
        }
        return decisionA.a() == paywallEngine2;
    }
}
