package androidx.graphics.path;

import androidx.graphics.path.PathSegment;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PathIteratorImplKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PathSegment.Type[] f39811a = PathSegment.Type.values();

    /* JADX INFO: Access modifiers changed from: private */
    public static final PathSegment.Type c(int i3) {
        switch (i3) {
            case 0:
                return PathSegment.Type.Move;
            case 1:
                return PathSegment.Type.Line;
            case 2:
                return PathSegment.Type.Quadratic;
            case 3:
                return PathSegment.Type.Conic;
            case 4:
                return PathSegment.Type.Cubic;
            case 5:
                return PathSegment.Type.Close;
            case 6:
                return PathSegment.Type.Done;
            default:
                throw new IllegalArgumentException("Unknown path segment type " + i3);
        }
    }
}
