package androidx.compose.animation.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class AnimatorKt {
    private static final PathNode b(PathNode pathNode, PathNode pathNode2, float f3) {
        if (pathNode instanceof PathNode.RelativeMoveTo) {
            if (!(pathNode2 instanceof PathNode.RelativeMoveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode;
            PathNode.RelativeMoveTo relativeMoveTo2 = (PathNode.RelativeMoveTo) pathNode2;
            return new PathNode.RelativeMoveTo(MathHelpersKt.b(relativeMoveTo.c(), relativeMoveTo2.c(), f3), MathHelpersKt.b(relativeMoveTo.d(), relativeMoveTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.MoveTo) {
            if (!(pathNode2 instanceof PathNode.MoveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode;
            PathNode.MoveTo moveTo2 = (PathNode.MoveTo) pathNode2;
            return new PathNode.MoveTo(MathHelpersKt.b(moveTo.c(), moveTo2.c(), f3), MathHelpersKt.b(moveTo.d(), moveTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.RelativeLineTo) {
            if (!(pathNode2 instanceof PathNode.RelativeLineTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode;
            PathNode.RelativeLineTo relativeLineTo2 = (PathNode.RelativeLineTo) pathNode2;
            return new PathNode.RelativeLineTo(MathHelpersKt.b(relativeLineTo.c(), relativeLineTo2.c(), f3), MathHelpersKt.b(relativeLineTo.d(), relativeLineTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.LineTo) {
            if (!(pathNode2 instanceof PathNode.LineTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode;
            PathNode.LineTo lineTo2 = (PathNode.LineTo) pathNode2;
            return new PathNode.LineTo(MathHelpersKt.b(lineTo.c(), lineTo2.c(), f3), MathHelpersKt.b(lineTo.d(), lineTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.RelativeHorizontalTo) {
            if (pathNode2 instanceof PathNode.RelativeHorizontalTo) {
                return new PathNode.RelativeHorizontalTo(MathHelpersKt.b(((PathNode.RelativeHorizontalTo) pathNode).c(), ((PathNode.RelativeHorizontalTo) pathNode2).c(), f3));
            }
            throw new IllegalArgumentException("start and stop path nodes have different types");
        }
        if (pathNode instanceof PathNode.HorizontalTo) {
            if (pathNode2 instanceof PathNode.HorizontalTo) {
                return new PathNode.HorizontalTo(MathHelpersKt.b(((PathNode.HorizontalTo) pathNode).c(), ((PathNode.HorizontalTo) pathNode2).c(), f3));
            }
            throw new IllegalArgumentException("start and stop path nodes have different types");
        }
        if (pathNode instanceof PathNode.RelativeVerticalTo) {
            if (pathNode2 instanceof PathNode.RelativeVerticalTo) {
                return new PathNode.RelativeVerticalTo(MathHelpersKt.b(((PathNode.RelativeVerticalTo) pathNode).c(), ((PathNode.RelativeVerticalTo) pathNode2).c(), f3));
            }
            throw new IllegalArgumentException("start and stop path nodes have different types");
        }
        if (pathNode instanceof PathNode.VerticalTo) {
            if (pathNode2 instanceof PathNode.VerticalTo) {
                return new PathNode.VerticalTo(MathHelpersKt.b(((PathNode.VerticalTo) pathNode).c(), ((PathNode.VerticalTo) pathNode2).c(), f3));
            }
            throw new IllegalArgumentException("start and stop path nodes have different types");
        }
        if (pathNode instanceof PathNode.RelativeCurveTo) {
            if (!(pathNode2 instanceof PathNode.RelativeCurveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode;
            PathNode.RelativeCurveTo relativeCurveTo2 = (PathNode.RelativeCurveTo) pathNode2;
            return new PathNode.RelativeCurveTo(MathHelpersKt.b(relativeCurveTo.c(), relativeCurveTo2.c(), f3), MathHelpersKt.b(relativeCurveTo.f(), relativeCurveTo2.f(), f3), MathHelpersKt.b(relativeCurveTo.d(), relativeCurveTo2.d(), f3), MathHelpersKt.b(relativeCurveTo.g(), relativeCurveTo2.g(), f3), MathHelpersKt.b(relativeCurveTo.e(), relativeCurveTo2.e(), f3), MathHelpersKt.b(relativeCurveTo.h(), relativeCurveTo2.h(), f3));
        }
        if (pathNode instanceof PathNode.CurveTo) {
            if (!(pathNode2 instanceof PathNode.CurveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode;
            PathNode.CurveTo curveTo2 = (PathNode.CurveTo) pathNode2;
            return new PathNode.CurveTo(MathHelpersKt.b(curveTo.c(), curveTo2.c(), f3), MathHelpersKt.b(curveTo.f(), curveTo2.f(), f3), MathHelpersKt.b(curveTo.d(), curveTo2.d(), f3), MathHelpersKt.b(curveTo.g(), curveTo2.g(), f3), MathHelpersKt.b(curveTo.e(), curveTo2.e(), f3), MathHelpersKt.b(curveTo.h(), curveTo2.h(), f3));
        }
        if (pathNode instanceof PathNode.RelativeReflectiveCurveTo) {
            if (!(pathNode2 instanceof PathNode.RelativeReflectiveCurveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode;
            PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo2 = (PathNode.RelativeReflectiveCurveTo) pathNode2;
            return new PathNode.RelativeReflectiveCurveTo(MathHelpersKt.b(relativeReflectiveCurveTo.c(), relativeReflectiveCurveTo2.c(), f3), MathHelpersKt.b(relativeReflectiveCurveTo.e(), relativeReflectiveCurveTo2.e(), f3), MathHelpersKt.b(relativeReflectiveCurveTo.d(), relativeReflectiveCurveTo2.d(), f3), MathHelpersKt.b(relativeReflectiveCurveTo.f(), relativeReflectiveCurveTo2.f(), f3));
        }
        if (pathNode instanceof PathNode.ReflectiveCurveTo) {
            if (!(pathNode2 instanceof PathNode.ReflectiveCurveTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode;
            PathNode.ReflectiveCurveTo reflectiveCurveTo2 = (PathNode.ReflectiveCurveTo) pathNode2;
            return new PathNode.ReflectiveCurveTo(MathHelpersKt.b(reflectiveCurveTo.c(), reflectiveCurveTo2.c(), f3), MathHelpersKt.b(reflectiveCurveTo.e(), reflectiveCurveTo2.e(), f3), MathHelpersKt.b(reflectiveCurveTo.d(), reflectiveCurveTo2.d(), f3), MathHelpersKt.b(reflectiveCurveTo.f(), reflectiveCurveTo2.f(), f3));
        }
        if (pathNode instanceof PathNode.RelativeQuadTo) {
            if (!(pathNode2 instanceof PathNode.RelativeQuadTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode;
            PathNode.RelativeQuadTo relativeQuadTo2 = (PathNode.RelativeQuadTo) pathNode2;
            return new PathNode.RelativeQuadTo(MathHelpersKt.b(relativeQuadTo.c(), relativeQuadTo2.c(), f3), MathHelpersKt.b(relativeQuadTo.e(), relativeQuadTo2.e(), f3), MathHelpersKt.b(relativeQuadTo.d(), relativeQuadTo2.d(), f3), MathHelpersKt.b(relativeQuadTo.f(), relativeQuadTo2.f(), f3));
        }
        if (pathNode instanceof PathNode.QuadTo) {
            if (!(pathNode2 instanceof PathNode.QuadTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode;
            PathNode.QuadTo quadTo2 = (PathNode.QuadTo) pathNode2;
            return new PathNode.QuadTo(MathHelpersKt.b(quadTo.c(), quadTo2.c(), f3), MathHelpersKt.b(quadTo.e(), quadTo2.e(), f3), MathHelpersKt.b(quadTo.d(), quadTo2.d(), f3), MathHelpersKt.b(quadTo.f(), quadTo2.f(), f3));
        }
        if (pathNode instanceof PathNode.RelativeReflectiveQuadTo) {
            if (!(pathNode2 instanceof PathNode.RelativeReflectiveQuadTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode;
            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo2 = (PathNode.RelativeReflectiveQuadTo) pathNode2;
            return new PathNode.RelativeReflectiveQuadTo(MathHelpersKt.b(relativeReflectiveQuadTo.c(), relativeReflectiveQuadTo2.c(), f3), MathHelpersKt.b(relativeReflectiveQuadTo.d(), relativeReflectiveQuadTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.ReflectiveQuadTo) {
            if (!(pathNode2 instanceof PathNode.ReflectiveQuadTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode;
            PathNode.ReflectiveQuadTo reflectiveQuadTo2 = (PathNode.ReflectiveQuadTo) pathNode2;
            return new PathNode.ReflectiveQuadTo(MathHelpersKt.b(reflectiveQuadTo.c(), reflectiveQuadTo2.c(), f3), MathHelpersKt.b(reflectiveQuadTo.d(), reflectiveQuadTo2.d(), f3));
        }
        if (pathNode instanceof PathNode.RelativeArcTo) {
            if (!(pathNode2 instanceof PathNode.RelativeArcTo)) {
                throw new IllegalArgumentException("start and stop path nodes have different types");
            }
            PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode;
            PathNode.RelativeArcTo relativeArcTo2 = (PathNode.RelativeArcTo) pathNode2;
            return new PathNode.RelativeArcTo(MathHelpersKt.b(relativeArcTo.e(), relativeArcTo2.e(), f3), MathHelpersKt.b(relativeArcTo.g(), relativeArcTo2.g(), f3), MathHelpersKt.b(relativeArcTo.f(), relativeArcTo2.f(), f3), relativeArcTo.h(), relativeArcTo.i(), MathHelpersKt.b(relativeArcTo.c(), relativeArcTo2.c(), f3), MathHelpersKt.b(relativeArcTo.d(), relativeArcTo2.d(), f3));
        }
        if (!(pathNode instanceof PathNode.ArcTo)) {
            PathNode.Close close = PathNode.Close.f26389c;
            if (Intrinsics.areEqual(pathNode, close)) {
                return close;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(pathNode2 instanceof PathNode.ArcTo)) {
            throw new IllegalArgumentException("start and stop path nodes have different types");
        }
        PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
        PathNode.ArcTo arcTo2 = (PathNode.ArcTo) pathNode2;
        return new PathNode.ArcTo(MathHelpersKt.b(arcTo.e(), arcTo2.e(), f3), MathHelpersKt.b(arcTo.g(), arcTo2.g(), f3), MathHelpersKt.b(arcTo.f(), arcTo2.f(), f3), arcTo.h(), arcTo.i(), MathHelpersKt.b(arcTo.c(), arcTo2.c(), f3), MathHelpersKt.b(arcTo.d(), arcTo2.d(), f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(List list, List list2, float f3) {
        int iMin = Math.min(list.size(), list2.size());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(b((PathNode) list.get(i3), (PathNode) list2.get(i3), f3));
        }
        return arrayList;
    }
}
