package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class DateRangePickerStateImpl extends BaseDatePickerStateImpl implements DateRangePickerState {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f17431h = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MutableState f17432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableState f17433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableState f17434g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ DateRangePickerStateImpl(Long l3, Long l4, Long l5, IntRange intRange, int i3, SelectableDates selectableDates, Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(l3, l4, l5, intRange, i3, selectableDates, locale);
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public void d(int i3) {
        Long lJ = j();
        if (lJ != null) {
            a(l().g(lJ.longValue()).e());
        }
        this.f17434g.setValue(DisplayMode.c(i3));
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public int e() {
        return ((DisplayMode) this.f17434g.getValue()).i();
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long g() {
        CalendarDate calendarDate = (CalendarDate) this.f17433f.getValue();
        if (calendarDate != null) {
            return Long.valueOf(calendarDate.d());
        }
        return null;
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public void h(Long l3, Long l4) {
        CalendarDate calendarDateB = l3 != null ? l().b(l3.longValue()) : null;
        CalendarDate calendarDateB2 = l4 != null ? l().b(l4.longValue()) : null;
        if (calendarDateB != null && !c().p(calendarDateB.e())) {
            throw new IllegalArgumentException(("The provided start date year (" + calendarDateB.e() + ") is out of the years range of " + c() + '.').toString());
        }
        if (calendarDateB2 != null && !c().p(calendarDateB2.e())) {
            throw new IllegalArgumentException(("The provided end date year (" + calendarDateB2.e() + ") is out of the years range of " + c() + '.').toString());
        }
        if (calendarDateB2 != null) {
            if (calendarDateB == null) {
                throw new IllegalArgumentException("An end date was provided without a start date.");
            }
            if (calendarDateB.d() > calendarDateB2.d()) {
                throw new IllegalArgumentException("The provided end date appears before the start date.");
            }
        }
        this.f17432e.setValue(calendarDateB);
        this.f17433f.setValue(calendarDateB2);
    }

    @Override // androidx.compose.material3.DateRangePickerState
    public Long j() {
        CalendarDate calendarDate = (CalendarDate) this.f17432e.getValue();
        if (calendarDate != null) {
            return Long.valueOf(calendarDate.d());
        }
        return null;
    }

    private DateRangePickerStateImpl(Long l3, Long l4, Long l5, IntRange intRange, int i3, SelectableDates selectableDates, Locale locale) {
        super(l5, intRange, selectableDates, locale);
        this.f17432e = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f17433f = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        h(l3, l4);
        this.f17434g = SnapshotStateKt__SnapshotStateKt.e(DisplayMode.c(i3), null, 2, null);
    }
}
