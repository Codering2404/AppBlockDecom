package androidx.graphics.path;

import android.graphics.PointF;
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
public final class PathSegmentUtilities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PathSegment f39824a = new PathSegment(PathSegment.Type.Done, new PointF[0], 0.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PathSegment f39825b = new PathSegment(PathSegment.Type.Close, new PointF[0], 0.0f);

    public static final PathSegment a() {
        return f39825b;
    }

    public static final PathSegment b() {
        return f39824a;
    }
}
