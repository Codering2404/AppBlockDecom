package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ComposeDragShadowBuilder extends View.DragShadowBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Density f25339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f25341c;

    public /* synthetic */ ComposeDragShadowBuilder(Density density, long j3, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j3, function1);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        Density density = this.f25339a;
        long j3 = this.f25340b;
        LayoutDirection layoutDirection = LayoutDirection.f30001a;
        androidx.compose.ui.graphics.Canvas canvasB = AndroidCanvas_androidKt.b(canvas);
        Function1 function1 = this.f25341c;
        CanvasDrawScope.DrawParams drawParamsO = canvasDrawScope.O();
        Density densityA = drawParamsO.a();
        LayoutDirection layoutDirectionB = drawParamsO.b();
        androidx.compose.ui.graphics.Canvas canvasC = drawParamsO.c();
        long jD = drawParamsO.d();
        CanvasDrawScope.DrawParams drawParamsO2 = canvasDrawScope.O();
        drawParamsO2.j(density);
        drawParamsO2.k(layoutDirection);
        drawParamsO2.i(canvasB);
        drawParamsO2.l(j3);
        canvasB.t();
        function1.invoke(canvasDrawScope);
        canvasB.k();
        CanvasDrawScope.DrawParams drawParamsO3 = canvasDrawScope.O();
        drawParamsO3.j(densityA);
        drawParamsO3.k(layoutDirectionB);
        drawParamsO3.i(canvasC);
        drawParamsO3.l(jD);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        Density density = this.f25339a;
        point.set(density.z0(density.G(Float.intBitsToFloat((int) (this.f25340b >> 32)))), density.z0(density.G(Float.intBitsToFloat((int) (this.f25340b & 4294967295L)))));
        point2.set(point.x / 2, point.y / 2);
    }

    private ComposeDragShadowBuilder(Density density, long j3, Function1 function1) {
        this.f25339a = density;
        this.f25340b = j3;
        this.f25341c = function1;
    }
}
