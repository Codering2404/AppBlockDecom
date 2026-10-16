package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class VectorPainterKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.graphics.vector.VectorGroup r23, java.util.Map r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.a(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final VectorPainter b(VectorPainter vectorPainter, long j3, long j4, String str, ColorFilter colorFilter, boolean z2) {
        vectorPainter.B(j3);
        vectorPainter.w(z2);
        vectorPainter.y(colorFilter);
        vectorPainter.C(j4);
        vectorPainter.A(str);
        return vectorPainter;
    }

    private static final ColorFilter c(long j3, int i3) {
        if (j3 != 16) {
            return ColorFilter.f25730b.b(j3, i3);
        }
        return null;
    }

    public static final GroupComponent d(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int iO = vectorGroup.o();
        for (int i3 = 0; i3 < iO; i3++) {
            VectorNode vectorNodeB = vectorGroup.b(i3);
            if (vectorNodeB instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNodeB;
                pathComponent.k(vectorPath.e());
                pathComponent.l(vectorPath.f());
                pathComponent.j(vectorPath.d());
                pathComponent.h(vectorPath.a());
                pathComponent.i(vectorPath.b());
                pathComponent.m(vectorPath.g());
                pathComponent.n(vectorPath.h());
                pathComponent.r(vectorPath.p());
                pathComponent.o(vectorPath.l());
                pathComponent.p(vectorPath.n());
                pathComponent.q(vectorPath.o());
                pathComponent.u(vectorPath.t());
                pathComponent.s(vectorPath.q());
                pathComponent.t(vectorPath.s());
                groupComponent.i(i3, pathComponent);
            } else if (vectorNodeB instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNodeB;
                groupComponent2.r(vectorGroup2.e());
                groupComponent2.u(vectorGroup2.h());
                groupComponent2.v(vectorGroup2.l());
                groupComponent2.w(vectorGroup2.n());
                groupComponent2.x(vectorGroup2.p());
                groupComponent2.y(vectorGroup2.q());
                groupComponent2.s(vectorGroup2.f());
                groupComponent2.t(vectorGroup2.g());
                groupComponent2.q(vectorGroup2.d());
                d(groupComponent2, vectorGroup2);
                groupComponent.i(i3, groupComponent2);
            }
        }
        return groupComponent;
    }

    public static final VectorPainter e(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long jF = f(density, imageVector.f(), imageVector.e());
        return b(new VectorPainter(groupComponent), jF, g(jF, imageVector.m(), imageVector.l()), imageVector.h(), c(imageVector.k(), imageVector.j()), imageVector.d());
    }

    private static final long f(Density density, float f3, float f4) {
        float fM1 = density.M1(f3);
        float fM12 = density.M1(f4);
        return Size.d((((long) Float.floatToRawIntBits(fM1)) << 32) | (((long) Float.floatToRawIntBits(fM12)) & 4294967295L));
    }

    private static final long g(long j3, float f3, float f4) {
        if (Float.isNaN(f3)) {
            f3 = Float.intBitsToFloat((int) (j3 >> 32));
        }
        if (Float.isNaN(f4)) {
            f4 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        }
        return Size.d((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    public static final VectorPainter h(ImageVector imageVector, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1413834416, i3, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        float fG = imageVector.g();
        boolean zF = composer.f((((long) Float.floatToRawIntBits(density.getDensity())) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
        Object objG = composer.G();
        if (zF || objG == Composer.f23746a.a()) {
            GroupComponent groupComponent = new GroupComponent();
            d(groupComponent, imageVector.i());
            Unit unit = Unit.f139807a;
            objG = e(density, imageVector, groupComponent);
            composer.w(objG);
        }
        VectorPainter vectorPainter = (VectorPainter) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return vectorPainter;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.graphics.vector.VectorPainter i(float r17, float r18, float r19, float r20, java.lang.String r21, long r22, int r24, boolean r25, final kotlin.jvm.functions.Function4 r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.i(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }
}
