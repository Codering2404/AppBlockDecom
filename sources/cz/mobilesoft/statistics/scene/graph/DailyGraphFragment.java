package cz.mobilesoft.statistics.scene.graph;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import cz.mobilesoft.statistics.model.RecordType;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;

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
public final class DailyGraphFragment extends AbstractGraphFragment<DailyGraphViewModel> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f133799n = 0.83f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f133800o = 23.5f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueFormatter f133801p = new ValueFormatter() { // from class: cz.mobilesoft.statistics.scene.graph.DailyGraphFragment$xAxisFormatter$1
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String a(float f3, AxisBase axisBase) {
            return this.f133810a.I(f3);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueFormatter f133802q = new ValueFormatter() { // from class: cz.mobilesoft.statistics.scene.graph.DailyGraphFragment$yAxisFormatter$1
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String a(float f3, AxisBase axisBase) {
            if (f3 == 0.0f) {
                return "";
            }
            if (this.f133811a.O().I0() != RecordType.f133740a) {
                return String.valueOf((int) f3);
            }
            float f4 = 60;
            return this.f133811a.J((long) (f3 * f4 * f4));
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f133803r;

    public DailyGraphFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.statistics.scene.graph.DailyGraphFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f133803r = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<DailyGraphViewModel>() { // from class: cz.mobilesoft.statistics.scene.graph.DailyGraphFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(DailyGraphViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    public float D() {
        return this.f133799n;
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    public float M() {
        return this.f133800o;
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    protected ValueFormatter P() {
        return this.f133801p;
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    protected ValueFormatter Q() {
        return this.f133802q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public DailyGraphViewModel O() {
        return (DailyGraphViewModel) this.f133803r.getValue();
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    public float y(TreeMap appData, RecordType recordType) {
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        return (O().I0() != RecordType.f133740a || H()) ? super.y(appData, recordType) : G();
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    protected void z(AvgBarChart avgBarChart, BarData barData) {
        Intrinsics.checkNotNullParameter(avgBarChart, "avgBarChart");
        if (O().I0() == RecordType.f133740a) {
            YAxis axisLeft = avgBarChart.getAxisLeft();
            if (H()) {
                axisLeft.G();
            } else {
                axisLeft.I(1.0f);
            }
            axisLeft.J(0.0f);
            YAxis axisRight = avgBarChart.getAxisRight();
            if (H()) {
                axisRight.G();
            } else {
                axisRight.I(1.0f);
            }
            axisRight.J(0.0f);
            avgBarChart.getXAxis().R(6);
        }
    }
}
