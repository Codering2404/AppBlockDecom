package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

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
@LazyGridScopeMarker
@Metadata
public interface LazyGridScope {
    static /* synthetic */ void d(LazyGridScope lazyGridScope, int i3, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i4 & 2) != 0) {
            function1 = null;
        }
        if ((i4 & 4) != 0) {
            function2 = null;
        }
        if ((i4 & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridScope$items$1
                public final Void c(int i5) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return c(((Number) obj2).intValue());
                }
            };
        }
        lazyGridScope.g(i3, function1, function2, function12, function4);
    }

    static /* synthetic */ void f(LazyGridScope lazyGridScope, Object obj, Object obj2, Function4 function4, int i3, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }
        if ((i3 & 1) != 0) {
            obj = null;
        }
        if ((i3 & 2) != 0) {
            obj2 = null;
        }
        lazyGridScope.e(obj, obj2, function4);
    }

    void e(Object obj, Object obj2, Function4 function4);

    void g(int i3, Function1 function1, Function2 function2, Function1 function12, Function4 function4);
}
