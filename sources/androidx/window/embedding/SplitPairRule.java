package androidx.window.embedding;

import androidx.window.embedding.SplitRule;
import java.util.Set;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SplitPairRule extends SplitRule {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set f54288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SplitRule.FinishBehavior f54289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SplitRule.FinishBehavior f54290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f54291n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return Intrinsics.areEqual(this.f54288k, splitPairRule.f54288k) && Intrinsics.areEqual(this.f54289l, splitPairRule.f54289l) && Intrinsics.areEqual(this.f54290m, splitPairRule.f54290m) && this.f54291n == splitPairRule.f54291n;
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f54288k.hashCode()) * 31) + this.f54289l.hashCode()) * 31) + this.f54290m.hashCode()) * 31) + Boolean.hashCode(this.f54291n);
    }

    @Override // androidx.window.embedding.SplitRule
    public String toString() {
        return SplitPairRule.class.getSimpleName() + "{tag=" + a() + ", defaultSplitAttributes=" + e() + ", minWidthDp=" + j() + ", minHeightDp=" + h() + ", minSmallestWidthDp=" + i() + ", maxAspectRatioInPortrait=" + g() + ", maxAspectRatioInLandscape=" + f() + ", clearTop=" + this.f54291n + ", finishPrimaryWithSecondary=" + this.f54289l + ", finishSecondaryWithPrimary=" + this.f54290m + ", filters=" + this.f54288k + '}';
    }
}
