package androidx.paging;

import androidx.paging.ViewportHint;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class HintHandlerKt {
    public static final boolean a(ViewportHint viewportHint, ViewportHint viewportHint2, LoadType loadType) {
        Intrinsics.checkNotNullParameter(viewportHint, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        if (viewportHint2 == null) {
            return true;
        }
        if ((viewportHint2 instanceof ViewportHint.Initial) && (viewportHint instanceof ViewportHint.Access)) {
            return true;
        }
        if ((viewportHint instanceof ViewportHint.Initial) && (viewportHint2 instanceof ViewportHint.Access)) {
            return false;
        }
        return (viewportHint.a() == viewportHint2.a() && viewportHint.b() == viewportHint2.b() && viewportHint2.e(loadType) <= viewportHint.e(loadType)) ? false : true;
    }
}
