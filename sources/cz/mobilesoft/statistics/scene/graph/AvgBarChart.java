package cz.mobilesoft.statistics.scene.graph;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
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
public final class AvgBarChart extends BarChart implements AvgBarDataProvider {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private Float f133796w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private Integer f133797x0;

    public AvgBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AvgBarDataProvider
    public Float getAverage() {
        return this.f133796w0;
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AvgBarDataProvider
    public Integer getAverageColor() {
        return this.f133797x0;
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        ChartAnimator mAnimator = this.f68340v;
        Intrinsics.checkNotNullExpressionValue(mAnimator, "mAnimator");
        ViewPortHandler mViewPortHandler = this.f68339u;
        Intrinsics.checkNotNullExpressionValue(mViewPortHandler, "mViewPortHandler");
        this.f68337s = new AvgBarChartRenderer(this, mAnimator, mViewPortHandler);
    }

    public void setAverage(Float f3) {
        this.f133796w0 = f3;
    }

    public void setAverageColor(Integer num) {
        this.f133797x0 = num;
    }
}
