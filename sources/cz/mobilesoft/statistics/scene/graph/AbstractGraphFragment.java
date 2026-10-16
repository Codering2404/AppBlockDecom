package cz.mobilesoft.statistics.scene.graph;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import cz.mobilesoft.statistics.R;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import cz.mobilesoft.statistics.model.RecordType;
import cz.mobilesoft.statistics.scene.graph.GraphViewModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class AbstractGraphFragment<M extends GraphViewModel> extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map f133775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Pair f133776i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f133778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Integer f133779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f133780m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f133769a = -0.5f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f133770b = 6.5f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133771c = "data";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f133772d = 0.55f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f133773f = 0.02f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ValueFormatter f133774g = new ValueFormatter() { // from class: cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment$yAxisFormatter$1
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String a(float f3, AxisBase axisBase) {
            if (f3 == 0.0f) {
                return "";
            }
            if (this.f133794a.O().I0() != RecordType.f133740a) {
                return String.valueOf((int) f3);
            }
            float f4 = 60;
            return this.f133794a.L((long) (f3 * f4 * f4));
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f133777j = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f133781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f133782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map f133783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Pair f133784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer[] f133785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String[] f133786f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f133787g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Integer f133789i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Integer f133790j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f133793m;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private RecordType f133788h = RecordType.f133740a;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f133791k = R.color.f133528a;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f133792l = true;

        public final DailyGraphFragment a() {
            DailyGraphFragment dailyGraphFragment = new DailyGraphFragment();
            dailyGraphFragment.setArguments(c());
            return dailyGraphFragment;
        }

        public final WeeklyGraphFragment b() {
            WeeklyGraphFragment weeklyGraphFragment = new WeeklyGraphFragment();
            weeklyGraphFragment.setArguments(c());
            return weeklyGraphFragment;
        }

        public final Builder d(int i3) {
            this.f133789i = Integer.valueOf(i3);
            return this;
        }

        public final Builder e(int i3, int i4) {
            this.f133784d = TuplesKt.a(Integer.valueOf(i3), Integer.valueOf(i4));
            return this;
        }

        public final Builder f(long j3) {
            this.f133782b = j3;
            return this;
        }

        public final Builder g(int i3) {
            this.f133790j = Integer.valueOf(i3);
            return this;
        }

        public final Builder h(String[] strArr) {
            this.f133787g = strArr;
            return this;
        }

        public final Builder i(String[] namesList) {
            Intrinsics.checkNotNullParameter(namesList, "namesList");
            this.f133786f = namesList;
            return this;
        }

        public final Builder j(long j3) {
            this.f133781a = j3;
            return this;
        }

        public final Builder k(RecordType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.f133788h = type;
            return this;
        }

        public final Builder l(Integer[] numArr) {
            this.f133785e = numArr;
            return this;
        }

        private final Bundle c() {
            return BundleKt.b(TuplesKt.a("ARG_START", Long.valueOf(this.f133781a)), TuplesKt.a("ARG_END", Long.valueOf(this.f133782b)), TuplesKt.a("ARG_COLOR_MAP", this.f133783c), TuplesKt.a("ARG_COLOR_GRADIENT", this.f133784d), TuplesKt.a("ARG_TYPE_LIST", this.f133785e), TuplesKt.a("ARG_NAMES_LIST", this.f133786f), TuplesKt.a("ARG_IGNORED_NAMES_LIST", this.f133787g), TuplesKt.a("ARG_TYPE", this.f133788h), TuplesKt.a("ARG_AVG_COLOR", this.f133789i), TuplesKt.a("ARG_GRID_COLOR", this.f133790j), TuplesKt.a("ARG_BACKGROUND_COLOR", Integer.valueOf(this.f133791k)), TuplesKt.a(KqqtdetwHMIO.asZacMNSs, Boolean.valueOf(this.f133792l)), TuplesKt.a("ARG_FILL_GRAPH", Boolean.valueOf(this.f133793m)));
        }
    }

    private final List A(Map map, Function1 function1) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Iterable) ((Map.Entry) it.next()).getValue()).iterator();
            while (it2.hasNext()) {
                linkedHashSet.add(function1.invoke(it2.next()));
            }
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.github.mikephil.charting.data.BarData B(java.util.TreeMap r20) {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment.B(java.util.TreeMap):com.github.mikephil.charting.data.BarData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(AggregatedRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.g();
    }

    private final int E(int i3) {
        return i3 % 2 == 1 ? ContextCompat.getColor(requireContext(), android.R.color.transparent) : i3 == 0 ? ContextCompat.getColor(requireContext(), R.color.f133529b) : ContextCompat.getColor(requireContext(), R.color.f133530c);
    }

    private final void R(TreeMap treeMap) {
        AvgBarChart avgBarChart;
        ImageView imageView;
        View view = getView();
        if (view == null || (avgBarChart = (AvgBarChart) view.findViewById(R.id.f133536c)) == null) {
            return;
        }
        avgBarChart.setNoDataText("");
        avgBarChart.setTouchEnabled(false);
        Context contextRequireContext = requireContext();
        Bundle arguments = getArguments();
        int color = ContextCompat.getColor(contextRequireContext, arguments != null ? arguments.getInt("ARG_BACKGROUND_COLOR", R.color.f133528a) : R.color.f133528a);
        Typeface typefaceI = ResourcesCompat.i(avgBarChart.getContext(), R.font.f133533a);
        avgBarChart.setBackgroundColor(color);
        avgBarChart.t(0.0f, 0.0f, 0.0f, 0.0f);
        avgBarChart.setDrawBorders(false);
        avgBarChart.setDrawGridBackground(false);
        avgBarChart.setDrawMarkers(false);
        avgBarChart.getLegend().I(new LegendEntry[0]);
        XAxis xAxis = avgBarChart.getXAxis();
        xAxis.j(0.0f);
        xAxis.i(typefaceI);
        xAxis.h(13.0f);
        xAxis.J(N());
        xAxis.I(M());
        xAxis.L(false);
        xAxis.K(false);
        xAxis.M(false);
        Context contextRequireContext2 = requireContext();
        int i3 = R.color.f133531d;
        xAxis.g(ContextCompat.getColor(contextRequireContext2, i3));
        xAxis.Y(XAxis.XAxisPosition.BOTTOM);
        xAxis.U(P());
        xAxis.P(false);
        YAxis axisLeft = avgBarChart.getAxisLeft();
        axisLeft.k(0.0f);
        axisLeft.i(typefaceI);
        axisLeft.h(13.0f);
        axisLeft.G();
        axisLeft.H();
        axisLeft.L(false);
        axisLeft.M(this.f133777j);
        axisLeft.l0(false);
        axisLeft.N(this.f133777j);
        axisLeft.k0(true);
        axisLeft.g(ContextCompat.getColor(requireContext(), i3));
        Context contextRequireContext3 = requireContext();
        Integer num = this.f133779l;
        axisLeft.Q(ContextCompat.getColor(contextRequireContext3, num != null ? num.intValue() : R.color.f133532e));
        axisLeft.P(false);
        axisLeft.R(2);
        axisLeft.U(Q());
        YAxis axisRight = avgBarChart.getAxisRight();
        axisRight.k(16.0f);
        axisRight.i(typefaceI);
        axisRight.h(13.0f);
        axisRight.G();
        axisRight.H();
        axisRight.L(false);
        axisRight.M(false);
        axisRight.l0(false);
        axisRight.N(false);
        Description description = new Description();
        description.o("");
        avgBarChart.setDescription(description);
        Integer num2 = this.f133778k;
        if (num2 != null) {
            avgBarChart.setAverageColor(Integer.valueOf(ContextCompat.getColor(requireContext(), num2.intValue())));
        }
        BarData barDataB = B(treeMap);
        z(avgBarChart, barDataB);
        avgBarChart.setData(barDataB);
        avgBarChart.setVisibility(avgBarChart.getData() != 0 ? 0 : 8);
        View view2 = getView();
        if (view2 != null && (imageView = (ImageView) view2.findViewById(R.id.f133535b)) != null) {
            imageView.setVisibility(avgBarChart.getData() == 0 ? 0 : 8);
        }
        avgBarChart.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(AbstractGraphFragment abstractGraphFragment, TreeMap treeMap) {
        Intrinsics.checkNotNull(treeMap);
        abstractGraphFragment.R(treeMap);
        return Unit.f139807a;
    }

    public float D() {
        return this.f133772d;
    }

    public String F() {
        return this.f133771c;
    }

    public float G() {
        return this.f133773f;
    }

    protected final boolean H() {
        return this.f133780m;
    }

    public final String I(float f3) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(O().L0());
        calendar.add(10, (int) f3);
        String str = new SimpleDateFormat(DateFormat.is24HourFormat(getContext()) ? "H" : "h", Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String J(long j3) {
        String str = ((int) (j3 / ((long) 60))) + "m";
        Intrinsics.checkNotNullExpressionValue(str, "with(...)");
        return str;
    }

    public final String L(long j3) {
        StringBuilder sb = new StringBuilder();
        int i3 = (int) (j3 / ((long) 60));
        int i4 = i3 / 60;
        int i5 = i3 - (i4 * 60);
        if (i4 > 0) {
            sb.append(i4);
            sb.append("h ");
        }
        if (i5 > 0) {
            sb.append(i5);
            sb.append("m");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "with(...)");
        return string;
    }

    public float M() {
        return this.f133770b;
    }

    public float N() {
        return this.f133769a;
    }

    protected abstract GraphViewModel O();

    protected abstract ValueFormatter P();

    protected ValueFormatter Q() {
        return this.f133774g;
    }

    public final void T(Integer[] numArr, RecordType usageRecordType) {
        Intrinsics.checkNotNullParameter(usageRecordType, "usageRecordType");
        O().Q0(numArr, usageRecordType);
    }

    public final void U(String[] strArr) {
        O().R0(strArr);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.f133537a, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O().P0();
    }

    public float y(TreeMap appData, RecordType recordType) {
        Object next;
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Collection collectionValues = appData.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator it = collectionValues.iterator();
        Float fValueOf = null;
        float fH = 0.0f;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                List list = (List) next;
                Intrinsics.checkNotNull(list);
                Iterator it2 = list.iterator();
                float fH2 = 0.0f;
                while (it2.hasNext()) {
                    fH2 += ((AggregatedRecord) it2.next()).h(recordType);
                }
                do {
                    Object next2 = it.next();
                    List list2 = (List) next2;
                    Intrinsics.checkNotNull(list2);
                    Iterator it3 = list2.iterator();
                    float fH3 = 0.0f;
                    while (it3.hasNext()) {
                        fH3 += ((AggregatedRecord) it3.next()).h(recordType);
                    }
                    if (Float.compare(fH2, fH3) < 0) {
                        next = next2;
                        fH2 = fH3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        if (next != null) {
            List list3 = (List) next;
            Intrinsics.checkNotNull(list3);
            Iterator it4 = list3.iterator();
            while (it4.hasNext()) {
                fH += ((AggregatedRecord) it4.next()).h(recordType);
            }
            fValueOf = Float.valueOf(fH);
        }
        return (fValueOf != null ? fValueOf.floatValue() : 1.0f) * G();
    }

    protected void z(AvgBarChart avgBarChart, BarData barData) {
        Intrinsics.checkNotNullParameter(avgBarChart, "avgBarChart");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, KrzujOtzIk.ahmJo);
        super.onViewCreated(view, bundle);
        O().N0().j(getViewLifecycleOwner(), new AbstractGraphFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.statistics.scene.graph.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AbstractGraphFragment.S(this.f133843a, (TreeMap) obj);
            }
        }));
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((ViewGroup) view.findViewById(R.id.f133534a)).setBackgroundColor(ContextCompat.getColor(requireContext(), arguments.getInt("ARG_BACKGROUND_COLOR", R.color.f133528a)));
            Serializable serializable = arguments.getSerializable("ARG_COLOR_MAP");
            this.f133775h = serializable instanceof Map ? (Map) serializable : null;
            Serializable serializable2 = arguments.getSerializable("ARG_COLOR_GRADIENT");
            this.f133776i = serializable2 instanceof Pair ? (Pair) serializable2 : null;
            this.f133777j = arguments.getBoolean("ARG_WITH_Y_LABELS", true);
            Serializable serializable3 = arguments.getSerializable("ARG_AVG_COLOR");
            this.f133778k = serializable3 instanceof Integer ? (Integer) serializable3 : null;
            Serializable serializable4 = arguments.getSerializable("ARG_GRID_COLOR");
            this.f133779l = serializable4 instanceof Integer ? (Integer) serializable4 : null;
            this.f133780m = arguments.getBoolean("ARG_FILL_GRAPH", false);
            GraphViewModel graphViewModelO = O();
            Object serializable5 = arguments.getSerializable("ARG_TYPE_LIST");
            Integer[] numArr = serializable5 instanceof Integer[] ? (Integer[]) serializable5 : null;
            Object serializable6 = arguments.getSerializable("ARG_NAMES_LIST");
            String[] strArr = serializable6 instanceof String[] ? (String[]) serializable6 : null;
            Object serializable7 = arguments.getSerializable("ARG_IGNORED_NAMES_LIST");
            String[] strArr2 = serializable7 instanceof String[] ? (String[]) serializable7 : null;
            long j3 = arguments.getLong("ARG_START");
            long j4 = arguments.getLong("ARG_END");
            Serializable serializable8 = arguments.getSerializable("ARG_TYPE");
            graphViewModelO.O0(numArr, strArr, strArr2, j3, j4, serializable8 instanceof RecordType ? (RecordType) serializable8 : null);
        }
    }
}
