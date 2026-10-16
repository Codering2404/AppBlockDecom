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
final class SafeActivityEmbeddingComponentProvider$isClassSplitTypeValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeActivityEmbeddingComponentProvider$isClassSplitTypeValid$1 f54233a = new SafeActivityEmbeddingComponentProvider$isClassSplitTypeValid$1();

    SafeActivityEmbeddingComponentProvider$isClassSplitTypeValid$1() {
        super(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
        /*
            r9 = this;
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType> r0 = androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType.class
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.Class[] r2 = new java.lang.Class[]{r1}
            java.lang.reflect.Constructor r2 = r0.getDeclaredConstructor(r2)
            java.lang.String r3 = "getRatio"
            r4 = 0
            java.lang.reflect.Method r3 = r0.getMethod(r3, r4)
            java.lang.String r5 = "splitEqually"
            java.lang.reflect.Method r0 = r0.getMethod(r5, r4)
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$HingeSplitType> r5 = androidx.window.extensions.embedding.SplitAttributes.SplitType.HingeSplitType.class
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r6 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
            java.lang.Class[] r6 = new java.lang.Class[]{r6}
            java.lang.reflect.Constructor r6 = r5.getDeclaredConstructor(r6)
            java.lang.String r7 = "getFallbackSplitType"
            java.lang.reflect.Method r5 = r5.getMethod(r7, r4)
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$ExpandContainersSplitType> r7 = androidx.window.extensions.embedding.SplitAttributes.SplitType.ExpandContainersSplitType.class
            java.lang.reflect.Constructor r4 = r7.getDeclaredConstructor(r4)
            androidx.window.reflection.ReflectionUtils r7 = androidx.window.reflection.ReflectionUtils.f54439a
            java.lang.String r8 = "ratioSplitTypeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            boolean r2 = r7.d(r2)
            if (r2 == 0) goto L8d
            java.lang.String r2 = "getRatioMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            boolean r2 = r7.e(r3)
            if (r2 == 0) goto L8d
            boolean r1 = r7.b(r3, r1)
            if (r1 == 0) goto L8d
            java.lang.String r1 = "hingeSplitTypeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            boolean r1 = r7.d(r6)
            if (r1 == 0) goto L8d
            java.lang.String r1 = "splitEquallyMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r7.e(r0)
            if (r1 == 0) goto L8d
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType> r1 = androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType.class
            boolean r0 = r7.b(r0, r1)
            if (r0 == 0) goto L8d
            java.lang.String r0 = "getFallbackSplitTypeMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            boolean r0 = r7.e(r5)
            if (r0 == 0) goto L8d
            java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r0 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
            boolean r0 = r7.b(r5, r0)
            if (r0 == 0) goto L8d
            java.lang.String r0 = "expandContainersSplitTypeConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r0 = r7.d(r4)
            if (r0 == 0) goto L8d
            r0 = 1
            goto L8e
        L8d:
            r0 = 0
        L8e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isClassSplitTypeValid$1.invoke():java.lang.Boolean");
    }
}
