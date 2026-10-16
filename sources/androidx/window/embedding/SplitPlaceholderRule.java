package androidx.window.embedding;

import android.content.Intent;
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
public final class SplitPlaceholderRule extends SplitRule {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set f54292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Intent f54293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f54294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SplitRule.FinishBehavior f54295n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return Intrinsics.areEqual(this.f54293l, splitPlaceholderRule.f54293l) && this.f54294m == splitPlaceholderRule.f54294m && Intrinsics.areEqual(this.f54295n, splitPlaceholderRule.f54295n) && Intrinsics.areEqual(this.f54292k, splitPlaceholderRule.f54292k);
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f54293l.hashCode()) * 31) + Boolean.hashCode(this.f54294m)) * 31) + this.f54295n.hashCode()) * 31) + this.f54292k.hashCode();
    }

    @Override // androidx.window.embedding.SplitRule
    public String toString() {
        return "SplitPlaceholderRule{tag=" + a() + ", defaultSplitAttributes=" + e() + ", minWidthDp=" + j() + ", minHeightDp=" + h() + ", minSmallestWidthDp=" + i() + ", maxAspectRatioInPortrait=" + g() + ", maxAspectRatioInLandscape=" + f() + ", placeholderIntent=" + this.f54293l + ", isSticky=" + this.f54294m + ", finishPrimaryWithPlaceholder=" + this.f54295n + ", filters=" + this.f54292k + '}';
    }
}
