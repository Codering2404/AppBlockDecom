package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
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
public final class AccessPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AccessPolicy f128865a = new AccessPolicy();

    private AccessPolicy() {
    }

    public final Set a(PremiumState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, PremiumState.None.INSTANCE) || (state instanceof PremiumState.OldPartial)) {
            return SetsKt.emptySet();
        }
        if (Intrinsics.areEqual(state, PremiumState.OldFull.INSTANCE)) {
            return SetsKt.setOf(Capability.PremiumAccess);
        }
        if ((state instanceof PremiumState.Subscription) || Intrinsics.areEqual(state, PremiumState.Lifetime.INSTANCE)) {
            return SetsKt.setOf((Object[]) new Capability[]{Capability.PremiumAccess, Capability.SubscriptionFeatures});
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean b(PremiumState state, Product product) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(product, "product");
        return state instanceof PremiumState.OldPartial ? ((PremiumState.OldPartial) state).o().contains(product.getProductId()) : a(state).contains(Capability.PremiumAccess);
    }
}
