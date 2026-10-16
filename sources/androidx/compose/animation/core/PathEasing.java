package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import kotlin.KotlinNothingValueException;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PathEasing implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f4050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntervalTree f4051b;

    private final void b() {
        float[] fArr = new float[5];
        IntervalTree intervalTree = new IntervalTree();
        PathIterator pathIteratorI = this.f4050a.i(PathIterator.ConicEvaluation.f25842b, 2.0E-4f);
        while (true) {
            if (!pathIteratorI.hasNext()) {
                break;
            }
            PathSegment next = pathIteratorI.next();
            if (!(next.b() != PathSegment.Type.f25860g)) {
                PreconditionsKt.a("The path cannot contain a close() command.");
            }
            if (next.b() != PathSegment.Type.f25855a && next.b() != PathSegment.Type.f25861h) {
                long jD = BezierKt.d(next, fArr, 0, 4, null);
                intervalTree.a(Float.intBitsToFloat((int) (jD >> 32)), Float.intBitsToFloat((int) (jD & 4294967295L)), next);
            }
        }
        if (!(intervalTree.b(0.0f) && intervalTree.b(1.0f))) {
            PreconditionsKt.a("The easing path must start at 0.0f and end at 1.0f.");
        }
        this.f4051b = intervalTree;
    }

    @Override // androidx.compose.animation.core.Easing
    public float a(float f3) {
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (this.f4051b == null) {
            b();
        }
        IntervalTree intervalTree = this.f4051b;
        if (intervalTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intervals");
            intervalTree = null;
        }
        Object objA = IntervalTree.d(intervalTree, f3, 0.0f, 2, null).a();
        if (objA == null) {
            PreconditionsKt.c("The easing path is invalid. Make sure it is continuous on the x axis.");
            throw new KotlinNothingValueException();
        }
        PathSegment pathSegment = (PathSegment) objA;
        float fN = BezierKt.n(pathSegment, f3);
        if (Float.isNaN(fN)) {
            PreconditionsKt.b("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
        }
        return BezierKt.j(pathSegment, fN);
    }
}
