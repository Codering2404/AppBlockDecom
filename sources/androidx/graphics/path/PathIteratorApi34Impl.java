package androidx.graphics.path;

import android.graphics.Path;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
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
public final class PathIteratorApi34Impl extends PathIteratorImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final android.graphics.PathIterator f39803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConicConverter f39804g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathIteratorApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f3) {
        super(path, conicEvaluation, f3);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        android.graphics.PathIterator pathIterator = path.getPathIterator();
        Intrinsics.checkNotNullExpressionValue(pathIterator, "path.pathIterator");
        this.f39803f = pathIterator;
        this.f39804g = new ConicConverter();
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean d() {
        return this.f39803f.hasNext();
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type e(float[] points, int i3) {
        Intrinsics.checkNotNullParameter(points, "points");
        if (this.f39804g.b() < this.f39804g.c()) {
            this.f39804g.d(points, i3);
            return PathSegment.Type.Quadratic;
        }
        PathSegment.Type typeC = PathIteratorImplKt.c(this.f39803f.next(points, i3));
        if (typeC != PathSegment.Type.Conic || b() != PathIterator.ConicEvaluation.AsQuadratics) {
            return typeC;
        }
        ConicConverter conicConverter = this.f39804g;
        conicConverter.a(points, points[i3 + 6], c(), i3);
        if (conicConverter.c() > 0) {
            conicConverter.d(points, i3);
        }
        return PathSegment.Type.Quadratic;
    }
}
