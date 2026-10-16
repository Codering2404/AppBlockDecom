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
final class SafeActivityEmbeddingComponentProvider$isClassSplitAttributesValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeActivityEmbeddingComponentProvider$isClassSplitAttributesValid$1 f54229a = new SafeActivityEmbeddingComponentProvider$isClassSplitAttributesValid$1();

    SafeActivityEmbeddingComponentProvider$isClassSplitAttributesValid$1() {
        super(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
        /*
            r7 = this;
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes> r0 = androidx.window.extensions.embedding.SplitAttributes.class
            java.lang.String r1 = "getLayoutDirection"
            r2 = 0
            java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
            java.lang.String r3 = "getSplitType"
            java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$Builder> r2 = androidx.window.extensions.embedding.SplitAttributes.Builder.class
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r3 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3}
            java.lang.String r4 = "setSplitType"
            java.lang.reflect.Method r3 = r2.getMethod(r4, r3)
            java.lang.Class r4 = java.lang.Integer.TYPE
            java.lang.Class[] r5 = new java.lang.Class[]{r4}
            java.lang.String r6 = "setLayoutDirection"
            java.lang.reflect.Method r2 = r2.getMethod(r6, r5)
            androidx.window.reflection.ReflectionUtils r5 = androidx.window.reflection.ReflectionUtils.f54439a
            java.lang.String r6 = "getLayoutDirectionMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            boolean r6 = r5.e(r1)
            if (r6 == 0) goto L67
            boolean r1 = r5.b(r1, r4)
            if (r1 == 0) goto L67
            java.lang.String r1 = "getSplitTypeMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r5.e(r0)
            if (r1 == 0) goto L67
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r1 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
            boolean r0 = r5.b(r0, r1)
            if (r0 == 0) goto L67
            java.lang.String r0 = "setSplitTypeMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            boolean r0 = r5.e(r3)
            if (r0 == 0) goto L67
            java.lang.String r0 = "setLayoutDirectionMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            boolean r0 = r5.e(r2)
            if (r0 == 0) goto L67
            r0 = 1
            goto L68
        L67:
            r0 = 0
        L68:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isClassSplitAttributesValid$1.invoke():java.lang.Boolean");
    }
}
