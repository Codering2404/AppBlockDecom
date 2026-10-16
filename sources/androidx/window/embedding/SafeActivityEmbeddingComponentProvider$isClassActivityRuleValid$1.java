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
final class SafeActivityEmbeddingComponentProvider$isClassActivityRuleValid$1 extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeActivityEmbeddingComponentProvider$isClassActivityRuleValid$1 f54228a = new SafeActivityEmbeddingComponentProvider$isClassActivityRuleValid$1();

    SafeActivityEmbeddingComponentProvider$isClassActivityRuleValid$1() {
        super(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
        /*
            r5 = this;
            java.lang.Class<androidx.window.extensions.embedding.ActivityRule> r0 = androidx.window.extensions.embedding.ActivityRule.class
            java.lang.String r1 = "shouldAlwaysExpand"
            r2 = 0
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)
            java.lang.Class<androidx.window.extensions.embedding.ActivityRule$Builder> r1 = androidx.window.extensions.embedding.ActivityRule.Builder.class
            java.lang.Class r2 = java.lang.Boolean.TYPE
            java.lang.Class[] r3 = new java.lang.Class[]{r2}
            java.lang.String r4 = "setShouldAlwaysExpand"
            java.lang.reflect.Method r1 = r1.getMethod(r4, r3)
            androidx.window.reflection.ReflectionUtils r3 = androidx.window.reflection.ReflectionUtils.f54439a
            java.lang.String r4 = "shouldAlwaysExpandMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            boolean r4 = r3.e(r0)
            if (r4 == 0) goto L37
            boolean r0 = r3.b(r0, r2)
            if (r0 == 0) goto L37
            java.lang.String r0 = "setShouldAlwaysExpandMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r0 = r3.e(r1)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = 0
        L38:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isClassActivityRuleValid$1.invoke():java.lang.Boolean");
    }
}
