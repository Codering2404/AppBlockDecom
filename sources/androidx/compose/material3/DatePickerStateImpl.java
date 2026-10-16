package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
final class DatePickerStateImpl extends BaseDatePickerStateImpl implements DatePickerState {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f17232g = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MutableState f17233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableState f17234f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final SelectableDates selectableDates, final Locale locale) {
            return ListSaverKt.a(new Function2<SaverScope, DatePickerStateImpl, List<? extends Object>>() { // from class: androidx.compose.material3.DatePickerStateImpl$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final List invoke(SaverScope saverScope, DatePickerStateImpl datePickerStateImpl) {
                    return CollectionsKt.listOf(datePickerStateImpl.i(), Long.valueOf(datePickerStateImpl.f()), Integer.valueOf(datePickerStateImpl.c().g()), Integer.valueOf(datePickerStateImpl.c().h()), Integer.valueOf(datePickerStateImpl.e()));
                }
            }, new Function1<List, DatePickerStateImpl>() { // from class: androidx.compose.material3.DatePickerStateImpl$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DatePickerStateImpl invoke(List list) {
                    Long l3 = (Long) list.get(0);
                    Long l4 = (Long) list.get(1);
                    Object obj = list.get(2);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(3);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    IntRange intRange = new IntRange(iIntValue, ((Integer) obj2).intValue());
                    Object obj3 = list.get(4);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return new DatePickerStateImpl(l3, l4, intRange, DisplayMode.d(((Integer) obj3).intValue()), selectableDates, locale, null);
                }
            });
        }

        private Companion() {
        }
    }

    public /* synthetic */ DatePickerStateImpl(Long l3, Long l4, IntRange intRange, int i3, SelectableDates selectableDates, Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(l3, l4, intRange, i3, selectableDates, locale);
    }

    @Override // androidx.compose.material3.DatePickerState
    public void d(int i3) {
        Long lI = i();
        if (lI != null) {
            a(l().g(lI.longValue()).e());
        }
        this.f17234f.setValue(DisplayMode.c(i3));
    }

    @Override // androidx.compose.material3.DatePickerState
    public int e() {
        return ((DisplayMode) this.f17234f.getValue()).i();
    }

    @Override // androidx.compose.material3.DatePickerState
    public Long i() {
        CalendarDate calendarDate = (CalendarDate) this.f17233e.getValue();
        if (calendarDate != null) {
            return Long.valueOf(calendarDate.d());
        }
        return null;
    }

    @Override // androidx.compose.material3.DatePickerState
    public void k(Long l3) {
        if (l3 == null) {
            this.f17233e.setValue(null);
            return;
        }
        CalendarDate calendarDateB = l().b(l3.longValue());
        if (c().p(calendarDateB.e())) {
            this.f17233e.setValue(calendarDateB);
            return;
        }
        throw new IllegalArgumentException(("The provided date's year (" + calendarDateB.e() + ") is out of the years range of " + c() + '.').toString());
    }

    private DatePickerStateImpl(Long l3, Long l4, IntRange intRange, int i3, SelectableDates selectableDates, Locale locale) {
        CalendarDate calendarDateB;
        super(l4, intRange, selectableDates, locale);
        if (l3 != null) {
            calendarDateB = l().b(l3.longValue());
            if (!intRange.p(calendarDateB.e())) {
                throw new IllegalArgumentException(("The provided initial date's year (" + calendarDateB.e() + ") is out of the years range of " + intRange + '.').toString());
            }
        } else {
            calendarDateB = null;
        }
        this.f17233e = SnapshotStateKt__SnapshotStateKt.e(calendarDateB, null, 2, null);
        this.f17234f = SnapshotStateKt__SnapshotStateKt.e(DisplayMode.c(i3), null, 2, null);
    }
}
