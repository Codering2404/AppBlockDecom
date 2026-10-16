package cz.mobilesoft.coreblock.util.monetization;

import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallEngineResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PaywallEngineResolver f128892a = new PaywallEngineResolver();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Decision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PaywallEngine f128893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PaywallEngine f128894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f128895c;

        public Decision(PaywallEngine engine, PaywallEngine requestedEngine, List rules) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            Intrinsics.checkNotNullParameter(requestedEngine, "requestedEngine");
            Intrinsics.checkNotNullParameter(rules, "rules");
            this.f128893a = engine;
            this.f128894b = requestedEngine;
            this.f128895c = rules;
        }

        public final PaywallEngine a() {
            return this.f128893a;
        }

        public final PaywallEngine b() {
            return this.f128894b;
        }

        public final List c() {
            return this.f128895c;
        }

        public final boolean d() {
            return this.f128893a == PaywallEngine.RcHosted;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Decision)) {
                return false;
            }
            Decision decision = (Decision) obj;
            return this.f128893a == decision.f128893a && this.f128894b == decision.f128894b && Intrinsics.areEqual(this.f128895c, decision.f128895c);
        }

        public int hashCode() {
            return (((this.f128893a.hashCode() * 31) + this.f128894b.hashCode()) * 31) + this.f128895c.hashCode();
        }

        public String toString() {
            return "Decision(engine=" + this.f128893a + ", requestedEngine=" + this.f128894b + ", rules=" + this.f128895c + ")";
        }
    }

    private PaywallEngineResolver() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.util.monetization.PaywallEngineResolver.Decision a(java.lang.String r16, cz.mobilesoft.coreblock.util.monetization.PaywallEngine r17, java.lang.Boolean r18, boolean r19, boolean r20, boolean r21, cz.mobilesoft.coreblock.util.monetization.PaywallEngine r22) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.monetization.PaywallEngineResolver.a(java.lang.String, cz.mobilesoft.coreblock.util.monetization.PaywallEngine, java.lang.Boolean, boolean, boolean, boolean, cz.mobilesoft.coreblock.util.monetization.PaywallEngine):cz.mobilesoft.coreblock.util.monetization.PaywallEngineResolver$Decision");
    }
}
