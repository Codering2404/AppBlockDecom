package cz.mobilesoft.statistics.scene.graph;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AvgBarChartRenderer extends BarChartRenderer {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AvgBarDataProvider f133798n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvgBarChartRenderer(AvgBarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNullParameter(viewPortHandler, "viewPortHandler");
        this.f133798n = chart;
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        Float average = this.f133798n.getAverage();
        if (average != null) {
            float fFloatValue = average.floatValue();
            float xChartMin = this.f68670h.getXChartMin();
            float xChartMax = this.f68670h.getXChartMax();
            Paint paint = new Paint();
            Integer averageColor = this.f133798n.getAverageColor();
            paint.setColor(averageColor != null ? averageColor.intValue() : -16777216);
            paint.setStyle(Paint.Style.STROKE);
            paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f, 10.0f, 5.0f}, 3.0f));
            Path path = new Path();
            path.moveTo(xChartMin, fFloatValue);
            path.lineTo(xChartMax, fFloatValue);
            this.f68670h.a(YAxis.AxisDependency.LEFT).i(path);
            if (canvas != null) {
                canvas.drawPath(path, paint);
            }
        }
    }
}
