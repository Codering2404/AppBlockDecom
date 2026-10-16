package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
public interface Applier<N> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    void a(int i3, int i4);

    Object b();

    void c(int i3, int i4, int i5);

    void clear();

    default void d(Function2 function2, Object obj) {
        function2.invoke(b(), obj);
    }

    void e(int i3, Object obj);

    void g(int i3, Object obj);

    void h(Object obj);

    default void i() {
        Object objB = b();
        ComposeNodeLifecycleCallback composeNodeLifecycleCallback = objB instanceof ComposeNodeLifecycleCallback ? (ComposeNodeLifecycleCallback) objB : null;
        if (composeNodeLifecycleCallback != null) {
            composeNodeLifecycleCallback.i();
        }
    }

    void k();

    default void f() {
    }

    default void j() {
    }
}
