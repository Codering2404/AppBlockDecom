package androidx.graphics.path;

import android.graphics.Path;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
import dalvik.annotation.optimization.FastNative;
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
public final class PathIteratorPreApi34Impl extends PathIteratorImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f39812f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathIteratorPreApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f3) {
        super(path, conicEvaluation, f3);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        this.f39812f = createInternalPathIterator(path, conicEvaluation.ordinal(), f3);
    }

    private final native long createInternalPathIterator(Path path, int i3, float f3);

    private final native void destroyInternalPathIterator(long j3);

    @FastNative
    private final native boolean internalPathIteratorHasNext(long j3);

    @FastNative
    private final native int internalPathIteratorNext(long j3, float[] fArr, int i3);

    @FastNative
    private final native int internalPathIteratorPeek(long j3);

    @FastNative
    private final native int internalPathIteratorRawSize(long j3);

    @FastNative
    private final native int internalPathIteratorSize(long j3);

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean d() {
        return internalPathIteratorHasNext(this.f39812f);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type e(float[] points, int i3) {
        Intrinsics.checkNotNullParameter(points, "points");
        return PathIteratorImplKt.f39811a[internalPathIteratorNext(this.f39812f, points, i3)];
    }

    protected final void finalize() {
        destroyInternalPathIterator(this.f39812f);
    }
}
