package androidx.window.embedding;

import android.content.Intent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class SafeActivityEmbeddingComponentProvider$isClassSplitPlaceholderRuleValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeActivityEmbeddingComponentProvider$isClassSplitPlaceholderRuleValid$1 f54232a = new SafeActivityEmbeddingComponentProvider$isClassSplitPlaceholderRuleValid$1();

    SafeActivityEmbeddingComponentProvider$isClassSplitPlaceholderRuleValid$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() throws NoSuchMethodException {
        Method getPlaceholderIntentMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getPlaceholderIntent", null);
        Method isStickyMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("isSticky", null);
        Method getFinishPrimaryWithSecondaryMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithSecondary", null);
        ReflectionUtils reflectionUtils = ReflectionUtils.f54439a;
        Intrinsics.checkNotNullExpressionValue(getPlaceholderIntentMethod, "getPlaceholderIntentMethod");
        if (reflectionUtils.e(getPlaceholderIntentMethod) && reflectionUtils.b(getPlaceholderIntentMethod, Intent.class)) {
            Intrinsics.checkNotNullExpressionValue(isStickyMethod, "isStickyMethod");
            if (reflectionUtils.e(isStickyMethod)) {
                reflectionUtils.b(isStickyMethod, Boolean.TYPE);
            }
        }
        Intrinsics.checkNotNullExpressionValue(getFinishPrimaryWithSecondaryMethod, "getFinishPrimaryWithSecondaryMethod");
        return Boolean.valueOf(reflectionUtils.e(getFinishPrimaryWithSecondaryMethod) && reflectionUtils.b(getFinishPrimaryWithSecondaryMethod, Integer.TYPE));
    }
}
