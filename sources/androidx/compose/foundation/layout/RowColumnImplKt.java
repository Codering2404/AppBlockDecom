package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

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
public final class RowColumnImplKt {
    public static final CrossAxisAlignment a(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.a();
        }
        return null;
    }

    public static final boolean b(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.b();
        }
        return true;
    }

    public static final RowColumnParentData c(IntrinsicMeasurable intrinsicMeasurable) {
        Object objP = intrinsicMeasurable.p();
        if (objP instanceof RowColumnParentData) {
            return (RowColumnParentData) objP;
        }
        return null;
    }

    public static final RowColumnParentData d(Placeable placeable) {
        Object objP = placeable.p();
        if (objP instanceof RowColumnParentData) {
            return (RowColumnParentData) objP;
        }
        return null;
    }

    public static final float e(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.d();
        }
        return 0.0f;
    }

    public static final boolean f(RowColumnParentData rowColumnParentData) {
        CrossAxisAlignment crossAxisAlignmentA = a(rowColumnParentData);
        if (crossAxisAlignmentA != null) {
            return crossAxisAlignmentA.c();
        }
        return false;
    }
}
