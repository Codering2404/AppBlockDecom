package androidx.graphics.path;

import android.graphics.Path;
import android.os.Build;
import androidx.graphics.path.PathSegment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PathIterator implements Iterator<PathSegment>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f39796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConicEvaluation f39797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f39798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PathIteratorImpl f39799d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ConicEvaluation {
        AsConic,
        AsQuadratics
    }

    public PathIterator(Path path, ConicEvaluation conicEvaluation, float f3) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        this.f39796a = path;
        this.f39797b = conicEvaluation;
        this.f39798c = f3;
        this.f39799d = Build.VERSION.SDK_INT >= 34 ? new PathIteratorApi34Impl(path, conicEvaluation, f3) : new PathIteratorPreApi34Impl(path, conicEvaluation, f3);
    }

    public final PathSegment.Type a(float[] points, int i3) {
        Intrinsics.checkNotNullParameter(points, "points");
        return this.f39799d.e(points, i3);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PathSegment next() {
        return this.f39799d.f();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f39799d.d();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
