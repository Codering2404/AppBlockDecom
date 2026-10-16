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
final class SafeActivityEmbeddingComponentProvider$isClassSplitInfoValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeActivityEmbeddingComponentProvider$isClassSplitInfoValid$1 f54230a = new SafeActivityEmbeddingComponentProvider$isClassSplitInfoValid$1();

    SafeActivityEmbeddingComponentProvider$isClassSplitInfoValid$1() {
        super(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
        /*
            r5 = this;
            java.lang.Class<androidx.window.extensions.embedding.SplitInfo> r0 = androidx.window.extensions.embedding.SplitInfo.class
            java.lang.String r1 = "getPrimaryActivityStack"
            r2 = 0
            java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
            java.lang.String r3 = "getSecondaryActivityStack"
            java.lang.reflect.Method r3 = r0.getMethod(r3, r2)
            java.lang.String r4 = "getSplitRatio"
            java.lang.reflect.Method r0 = r0.getMethod(r4, r2)
            androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.f54439a
            java.lang.String r4 = "getPrimaryActivityStackMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            boolean r4 = r2.e(r1)
            if (r4 == 0) goto L52
            java.lang.Class<androidx.window.extensions.embedding.ActivityStack> r4 = androidx.window.extensions.embedding.ActivityStack.class
            boolean r1 = r2.b(r1, r4)
            if (r1 == 0) goto L52
            java.lang.String r1 = "getSecondaryActivityStackMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            boolean r1 = r2.e(r3)
            if (r1 == 0) goto L52
            java.lang.Class<androidx.window.extensions.embedding.ActivityStack> r1 = androidx.window.extensions.embedding.ActivityStack.class
            boolean r1 = r2.b(r3, r1)
            if (r1 == 0) goto L52
            java.lang.String r1 = "getSplitRatioMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r2.e(r0)
            if (r1 == 0) goto L52
            java.lang.Class r1 = java.lang.Float.TYPE
            boolean r0 = r2.b(r0, r1)
            if (r0 == 0) goto L52
            r0 = 1
            goto L53
        L52:
            r0 = 0
        L53:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isClassSplitInfoValid$1.invoke():java.lang.Boolean");
    }
}
