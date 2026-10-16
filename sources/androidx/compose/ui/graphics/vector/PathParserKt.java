package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.List;
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
public final class PathParserKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f26443a = new float[0];

    private static final void a(Path path, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d11 * d12) / 3.141592653589793d));
        double dCos = Math.cos(d9);
        double dSin = Math.sin(d9);
        double dCos2 = Math.cos(d10);
        double dSin2 = Math.sin(d10);
        double d13 = -d5;
        double d14 = d13 * dCos;
        double d15 = d6 * dSin;
        double d16 = (d14 * dSin2) - (d15 * dCos2);
        double d17 = d13 * dSin;
        double d18 = d6 * dCos;
        double d19 = (dSin2 * d17) + (dCos2 * d18);
        double d20 = d11 / ((double) iCeil);
        double d21 = d19;
        double d22 = d16;
        int i3 = 0;
        double d23 = d7;
        double d24 = d8;
        double d25 = d10;
        while (i3 < iCeil) {
            double d26 = d25 + d20;
            double dSin3 = Math.sin(d26);
            double dCos3 = Math.cos(d26);
            int i4 = i3;
            double d27 = (d3 + ((d5 * dCos) * dCos3)) - (d15 * dSin3);
            double d28 = d12;
            double d29 = d4 + (d5 * dSin * dCos3) + (d18 * dSin3);
            double d30 = (d14 * dSin3) - (d15 * dCos3);
            double d31 = (dSin3 * d17) + (dCos3 * d18);
            double d32 = d26 - d25;
            int i5 = iCeil;
            double dTan = Math.tan(d32 / ((double) 2));
            double dSin4 = (Math.sin(d32) * (Math.sqrt(d28 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.b((float) (d23 + (d22 * dSin4)), (float) (d24 + (d21 * dSin4)), (float) (d27 - (dSin4 * d30)), (float) (d29 - (dSin4 * d31)), (float) d27, (float) d29);
            dSin = dSin;
            d20 = d20;
            d23 = d27;
            d24 = d29;
            i3 = i4 + 1;
            d25 = d26;
            d21 = d31;
            iCeil = i5;
            d22 = d30;
            dCos = dCos;
            d12 = d28;
        }
    }

    private static final void b(Path path, double d3, double d4, double d5, double d6, double d7, double d8, double d9, boolean z2, boolean z3) {
        double d10;
        double d11;
        double d12 = (d9 / ((double) SensibleDefaults.X_OFFSET)) * 3.141592653589793d;
        double dCos = Math.cos(d12);
        double dSin = Math.sin(d12);
        double d13 = ((d3 * dCos) + (d4 * dSin)) / d7;
        double d14 = (((-d3) * dSin) + (d4 * dCos)) / d8;
        double d15 = ((d5 * dCos) + (d6 * dSin)) / d7;
        double d16 = (((-d5) * dSin) + (d6 * dCos)) / d8;
        double d17 = d13 - d15;
        double d18 = d14 - d16;
        double d19 = 2;
        double d20 = (d13 + d15) / d19;
        double d21 = (d14 + d16) / d19;
        double d22 = (d17 * d17) + (d18 * d18);
        if (d22 == 0.0d) {
            return;
        }
        double d23 = (1.0d / d22) - 0.25d;
        if (d23 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d22) / 1.99999d);
            b(path, d3, d4, d5, d6, d7 * dSqrt, d8 * dSqrt, d9, z2, z3);
            return;
        }
        double dSqrt2 = Math.sqrt(d23);
        double d24 = d17 * dSqrt2;
        double d25 = dSqrt2 * d18;
        if (z2 == z3) {
            d10 = d20 - d25;
            d11 = d21 + d24;
        } else {
            d10 = d20 + d25;
            d11 = d21 - d24;
        }
        double dAtan2 = Math.atan2(d14 - d11, d13 - d10);
        double dAtan22 = Math.atan2(d16 - d11, d15 - d10) - dAtan2;
        if (z3 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d26 = d10 * d7;
        double d27 = d11 * d8;
        a(path, (d26 * dCos) - (d27 * dSin), (d26 * dSin) + (d27 * dCos), d7, d8, d3, d4, d12, dAtan2, dAtan22);
    }

    public static final Path c(List list, Path path) {
        int i3;
        float f3;
        int i4;
        PathNode pathNode;
        float f4;
        float f5;
        float fC;
        float fD;
        float f6;
        float f7;
        float f8;
        float f9;
        float fC2;
        float fE;
        float f10;
        List list2 = list;
        Path path2 = path;
        int iT = path2.t();
        path2.r();
        path2.k(iT);
        PathNode pathNode2 = list2.isEmpty() ? PathNode.Close.f26389c : (PathNode) list2.get(0);
        int size = list2.size();
        float f11 = 0.0f;
        int i5 = 0;
        float fC3 = 0.0f;
        float fD2 = 0.0f;
        float fC4 = 0.0f;
        float fD3 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (i5 < size) {
            PathNode pathNode3 = (PathNode) list2.get(i5);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                i3 = size;
                f3 = f11;
                i4 = i5;
                pathNode = pathNode3;
                fC3 = f12;
                fC4 = fC3;
                fD2 = f13;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    fC4 += relativeMoveTo.c();
                    fD3 += relativeMoveTo.d();
                    path2.f(relativeMoveTo.c(), relativeMoveTo.d());
                    i3 = size;
                    f3 = f11;
                    i4 = i5;
                    f12 = fC4;
                    f13 = fD3;
                } else {
                    if (pathNode3 instanceof PathNode.MoveTo) {
                        PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                        float fC5 = moveTo.c();
                        float fD4 = moveTo.d();
                        path2.a(moveTo.c(), moveTo.d());
                        fC4 = fC5;
                        f12 = fC4;
                        fD3 = fD4;
                        f13 = fD3;
                    } else {
                        if (pathNode3 instanceof PathNode.RelativeLineTo) {
                            PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                            path2.x(relativeLineTo.c(), relativeLineTo.d());
                            fC4 += relativeLineTo.c();
                            f7 = relativeLineTo.d();
                        } else {
                            if (pathNode3 instanceof PathNode.LineTo) {
                                PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                                path2.c(lineTo.c(), lineTo.d());
                                fD = lineTo.c();
                                f6 = lineTo.d();
                            } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.x(relativeHorizontalTo.c(), f11);
                                fC4 += relativeHorizontalTo.c();
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.c(horizontalTo.c(), fD3);
                                fC4 = horizontalTo.c();
                            } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                path2.x(f11, relativeVerticalTo.c());
                                f7 = relativeVerticalTo.c();
                            } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                path2.c(fC4, verticalTo.c());
                                fD3 = verticalTo.c();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                    PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                    path2.g(relativeCurveTo.c(), relativeCurveTo.f(), relativeCurveTo.d(), relativeCurveTo.g(), relativeCurveTo.e(), relativeCurveTo.h());
                                    fC2 = relativeCurveTo.d() + fC4;
                                    fE = relativeCurveTo.g() + fD3;
                                    fC4 += relativeCurveTo.e();
                                    f10 = relativeCurveTo.h();
                                } else {
                                    if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.b(curveTo.c(), curveTo.f(), curveTo.d(), curveTo.g(), curveTo.e(), curveTo.h());
                                        float fD5 = curveTo.d();
                                        float fG = curveTo.g();
                                        float fE2 = curveTo.e();
                                        float fH = curveTo.h();
                                        fC4 = fE2;
                                        fD3 = fH;
                                        i3 = size;
                                        f3 = f11;
                                        i4 = i5;
                                        pathNode = pathNode3;
                                        fC3 = fD5;
                                        fD2 = fG;
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.a()) {
                                            float f14 = fC4 - fC3;
                                            f9 = fD3 - fD2;
                                            f8 = f14;
                                        } else {
                                            f8 = f11;
                                            f9 = f8;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.g(f8, f9, relativeReflectiveCurveTo.c(), relativeReflectiveCurveTo.e(), relativeReflectiveCurveTo.d(), relativeReflectiveCurveTo.f());
                                        fC2 = relativeReflectiveCurveTo.c() + fC4;
                                        fE = relativeReflectiveCurveTo.e() + fD3;
                                        fC4 += relativeReflectiveCurveTo.d();
                                        f10 = relativeReflectiveCurveTo.f();
                                    } else {
                                        if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                            if (pathNode2.a()) {
                                                float f15 = 2;
                                                fC4 = (fC4 * f15) - fC3;
                                                fD3 = (f15 * fD3) - fD2;
                                            }
                                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                            path.b(fC4, fD3, reflectiveCurveTo.c(), reflectiveCurveTo.e(), reflectiveCurveTo.d(), reflectiveCurveTo.f());
                                            fC = reflectiveCurveTo.c();
                                            float fE3 = reflectiveCurveTo.e();
                                            float fD6 = reflectiveCurveTo.d();
                                            float f16 = reflectiveCurveTo.f();
                                            fC4 = fD6;
                                            fD3 = f16;
                                            i3 = size;
                                            f3 = f11;
                                            i4 = i5;
                                            pathNode = pathNode3;
                                            fD2 = fE3;
                                        } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                            path.q(relativeQuadTo.c(), relativeQuadTo.e(), relativeQuadTo.d(), relativeQuadTo.f());
                                            fC3 = relativeQuadTo.c() + fC4;
                                            fD2 = relativeQuadTo.e() + fD3;
                                            fC4 += relativeQuadTo.d();
                                            f7 = relativeQuadTo.f();
                                        } else if (pathNode3 instanceof PathNode.QuadTo) {
                                            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                            path.m(quadTo.c(), quadTo.e(), quadTo.d(), quadTo.f());
                                            fC3 = quadTo.c();
                                            fD2 = quadTo.e();
                                            fD = quadTo.d();
                                            f6 = quadTo.f();
                                        } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                            if (pathNode2.b()) {
                                                f4 = fC4 - fC3;
                                                f5 = fD3 - fD2;
                                            } else {
                                                f4 = f11;
                                                f5 = f4;
                                            }
                                            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                            path.q(f4, f5, relativeReflectiveQuadTo.c(), relativeReflectiveQuadTo.d());
                                            fC = f4 + fC4;
                                            float f17 = f5 + fD3;
                                            fC4 += relativeReflectiveQuadTo.c();
                                            fD3 += relativeReflectiveQuadTo.d();
                                            fD2 = f17;
                                            i3 = size;
                                            f3 = f11;
                                            i4 = i5;
                                            pathNode = pathNode3;
                                        } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                            if (pathNode2.b()) {
                                                float f18 = 2;
                                                fC4 = (fC4 * f18) - fC3;
                                                fD3 = (f18 * fD3) - fD2;
                                            }
                                            PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                            path.m(fC4, fD3, reflectiveQuadTo.c(), reflectiveQuadTo.d());
                                            float f19 = fC4;
                                            fC4 = reflectiveQuadTo.c();
                                            fC3 = f19;
                                            i3 = size;
                                            f3 = f11;
                                            i4 = i5;
                                            fD2 = fD3;
                                            pathNode = pathNode3;
                                            fD3 = reflectiveQuadTo.d();
                                        } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                            PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                            float fC6 = relativeArcTo.c() + fC4;
                                            float fD7 = relativeArcTo.d() + fD3;
                                            f3 = f11;
                                            pathNode = pathNode3;
                                            i3 = size;
                                            i4 = i5;
                                            b(path, fC4, fD3, fC6, fD7, relativeArcTo.e(), relativeArcTo.g(), relativeArcTo.f(), relativeArcTo.h(), relativeArcTo.i());
                                            fC3 = fC6;
                                            fC4 = fC3;
                                            fD2 = fD7;
                                        } else {
                                            i3 = size;
                                            f3 = f11;
                                            i4 = i5;
                                            pathNode = pathNode3;
                                            if (pathNode instanceof PathNode.ArcTo) {
                                                PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                                b(path, fC4, fD3, arcTo.c(), arcTo.d(), arcTo.e(), arcTo.g(), arcTo.f(), arcTo.h(), arcTo.i());
                                                fC3 = arcTo.c();
                                                fC4 = fC3;
                                                fD2 = arcTo.d();
                                            }
                                        }
                                        fC3 = fC;
                                    }
                                    i5 = i4 + 1;
                                    path2 = path;
                                    pathNode2 = pathNode;
                                    size = i3;
                                    f11 = f3;
                                    list2 = list;
                                }
                                fD3 += f10;
                                fC3 = fC2;
                                fD2 = fE;
                            }
                            fD3 = f6;
                            fC4 = fD;
                        }
                        fD3 += f7;
                    }
                    i3 = size;
                    f3 = f11;
                    i4 = i5;
                }
                pathNode = pathNode3;
                i5 = i4 + 1;
                path2 = path;
                pathNode2 = pathNode;
                size = i3;
                f11 = f3;
                list2 = list;
            }
            fD3 = fD2;
            i5 = i4 + 1;
            path2 = path;
            pathNode2 = pathNode;
            size = i3;
            f11 = f3;
            list2 = list;
        }
        return path;
    }
}
