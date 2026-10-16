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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
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
public final class WeeklyGraphFragment extends AbstractGraphFragment<WeeklyGraphViewModel> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f133831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueFormatter f133832o;

    public WeeklyGraphFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.statistics.scene.graph.WeeklyGraphFragment$special$$inlined$viewModel$default$1
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
        this.f133831n = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<WeeklyGraphViewModel>() { // from class: cz.mobilesoft.statistics.scene.graph.WeeklyGraphFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(WeeklyGraphViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        this.f133832o = new ValueFormatter() { // from class: cz.mobilesoft.statistics.scene.graph.WeeklyGraphFragment$xAxisFormatter$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String a(float f3, AxisBase axisBase) {
                Calendar calendar = Calendar.getInstance(Locale.getDefault());
                calendar.setTimeInMillis(this.f133839a.O().L0());
                calendar.add(7, (int) f3);
                String str = new SimpleDateFormat("EE", Locale.getDefault()).format(calendar.getTime());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        };
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    protected ValueFormatter P() {
        return this.f133832o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public WeeklyGraphViewModel O() {
        return (WeeklyGraphViewModel) this.f133831n.getValue();
    }

    @Override // cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment
    protected void z(AvgBarChart avgBarChart, BarData barData) {
        float fCeil;
        Intrinsics.checkNotNullParameter(avgBarChart, "avgBarChart");
        Float fValueOf = (Float) O().B0().f();
        if (fValueOf == null) {
            fValueOf = Float.valueOf(0.0f);
        }
        avgBarChart.setAverage(fValueOf);
        YAxis axisLeft = avgBarChart.getAxisLeft();
        axisLeft.J(0.0f);
        axisLeft.R(3);
        if (barData != null) {
            Float fValueOf2 = Float.valueOf(barData.o());
            if (fValueOf2.floatValue() <= 0.0f || O().I0() != RecordType.f133740a) {
                fValueOf2 = null;
            }
            if (fValueOf2 != null) {
                float fFloatValue = fValueOf2.floatValue();
                if (fFloatValue > 1.0f) {
                    int i3 = 2;
                    while (true) {
                        if (i3 >= 5) {
                            fCeil = 0.0f;
                            break;
                        }
                        fCeil = (float) Math.ceil(fFloatValue);
                        if (fCeil % i3 == 0.0f) {
                            axisLeft.R(i3);
                            break;
                        }
                        i3++;
                    }
                    if (fCeil == 0.0f) {
                        float f3 = (int) fFloatValue;
                        float f4 = fFloatValue - f3;
                        axisLeft.O(0.5f);
                        fCeil = f4 <= 0.5f ? 0.5f + f3 : (float) Math.ceil(fFloatValue);
                    }
                } else {
                    axisLeft.O(1 / 6.0f);
                    fCeil = (((int) (fFloatValue * 6.0f)) + 1) / 6.0f;
                }
                axisLeft.I(fCeil);
            }
        }
    }
}
