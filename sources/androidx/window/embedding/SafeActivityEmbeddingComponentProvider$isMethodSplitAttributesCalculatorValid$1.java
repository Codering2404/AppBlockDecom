package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f54240a;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
        /*
            r4 = this;
            androidx.window.embedding.SafeActivityEmbeddingComponentProvider r0 = r4.f54240a
            java.lang.Class r0 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.a(r0)
            java.lang.Class<androidx.window.extensions.core.util.function.Function> r1 = androidx.window.extensions.core.util.function.Function.class
            java.lang.Class[] r1 = new java.lang.Class[]{r1}
            java.lang.String r2 = "setSplitAttributesCalculator"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r1)
            androidx.window.embedding.SafeActivityEmbeddingComponentProvider r1 = r4.f54240a
            java.lang.Class r1 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.a(r1)
            java.lang.String r2 = "clearSplitAttributesCalculator"
            r3 = 0
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)
            androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.f54439a
            java.lang.String r3 = "setSplitAttributesCalculatorMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = r2.e(r0)
            if (r0 == 0) goto L39
            java.lang.String r0 = "clearSplitAttributesCalculatorMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r0 = r2.e(r1)
            if (r0 == 0) goto L39
            r0 = 1
            goto L3a
        L39:
            r0 = 0
        L3a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1.invoke():java.lang.Boolean");
    }
}
