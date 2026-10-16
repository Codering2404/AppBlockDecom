package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TimePickerState {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f133049k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Saver f133050l = ListSaverKt.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.a1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return TimePickerState.c((SaverScope) obj, (TimePickerState) obj2);
        }
    }, new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.b1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return TimePickerState.d((List) obj);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f133051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f133052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f133053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f133054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f133055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f133056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f133057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f133058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f133059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f133060j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return TimePickerState.f133050l;
        }

        private Companion() {
        }
    }

    public TimePickerState(List list, List list2, List list3, List list4, int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
        this.f133051a = list;
        this.f133052b = list2;
        this.f133053c = list3;
        this.f133054d = list4;
        this.f133055e = i3;
        this.f133056f = i4;
        this.f133057g = i5;
        this.f133058h = i6;
        this.f133059i = z2;
        this.f133060j = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(SaverScope listSaver, TimePickerState it) {
        Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(it.f133051a, it.f133052b, it.f133053c, it.f133054d, Integer.valueOf(it.f133055e), Integer.valueOf(it.f133056f), Integer.valueOf(it.f133057g), Integer.valueOf(it.f133058h), Boolean.valueOf(it.f133059i), Boolean.valueOf(it.f133060j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerState d(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.get(0);
        List list = obj instanceof List ? (List) obj : null;
        Object obj2 = it.get(1);
        List list2 = obj2 instanceof List ? (List) obj2 : null;
        Object obj3 = it.get(2);
        List list3 = obj3 instanceof List ? (List) obj3 : null;
        Object obj4 = it.get(3);
        List list4 = obj4 instanceof List ? (List) obj4 : null;
        Object obj5 = it.get(4);
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj5).intValue();
        Object obj6 = it.get(5);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj6).intValue();
        Object obj7 = it.get(6);
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue3 = ((Integer) obj7).intValue();
        Object obj8 = it.get(7);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue4 = ((Integer) obj8).intValue();
        Object obj9 = it.get(8);
        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj9).booleanValue();
        Object obj10 = it.get(9);
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Boolean");
        return new TimePickerState(list, list2, list3, list4, iIntValue, iIntValue2, iIntValue3, iIntValue4, zBooleanValue, ((Boolean) obj10).booleanValue());
    }

    private final long f(long j3, boolean z2) {
        if (j3 == 12 && !z2) {
            return 0L;
        }
        if (j3 == 12 && z2) {
            return 12L;
        }
        return z2 ? j3 + 12 : j3;
    }

    public static /* synthetic */ TimePickerState h(TimePickerState timePickerState, List list, List list2, List list3, List list4, int i3, int i4, int i5, int i6, boolean z2, boolean z3, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            list = timePickerState.f133051a;
        }
        if ((i7 & 2) != 0) {
            list2 = timePickerState.f133052b;
        }
        if ((i7 & 4) != 0) {
            list3 = timePickerState.f133053c;
        }
        if ((i7 & 8) != 0) {
            list4 = timePickerState.f133054d;
        }
        if ((i7 & 16) != 0) {
            i3 = timePickerState.f133055e;
        }
        if ((i7 & 32) != 0) {
            i4 = timePickerState.f133056f;
        }
        if ((i7 & 64) != 0) {
            i5 = timePickerState.f133057g;
        }
        if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i6 = timePickerState.f133058h;
        }
        if ((i7 & Function.MAX_NARGS) != 0) {
            z2 = timePickerState.f133059i;
        }
        if ((i7 & 512) != 0) {
            z3 = timePickerState.f133060j;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        int i8 = i5;
        int i9 = i6;
        int i10 = i3;
        int i11 = i4;
        return timePickerState.g(list, list2, list3, list4, i10, i11, i8, i9, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimePickerState)) {
            return false;
        }
        TimePickerState timePickerState = (TimePickerState) obj;
        return Intrinsics.areEqual(this.f133051a, timePickerState.f133051a) && Intrinsics.areEqual(this.f133052b, timePickerState.f133052b) && Intrinsics.areEqual(this.f133053c, timePickerState.f133053c) && Intrinsics.areEqual(this.f133054d, timePickerState.f133054d) && this.f133055e == timePickerState.f133055e && this.f133056f == timePickerState.f133056f && this.f133057g == timePickerState.f133057g && this.f133058h == timePickerState.f133058h && this.f133059i == timePickerState.f133059i && this.f133060j == timePickerState.f133060j;
    }

    public final TimePickerState g(List list, List list2, List list3, List list4, int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
        return new TimePickerState(list, list2, list3, list4, i3, i4, i5, i6, z2, z3);
    }

    public int hashCode() {
        List list = this.f133051a;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List list2 = this.f133052b;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.f133053c;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List list4 = this.f133054d;
        return ((((((((((((iHashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + Integer.hashCode(this.f133055e)) * 31) + Integer.hashCode(this.f133056f)) * 31) + Integer.hashCode(this.f133057g)) * 31) + Integer.hashCode(this.f133058h)) * 31) + Boolean.hashCode(this.f133059i)) * 31) + Boolean.hashCode(this.f133060j);
    }

    public final long i(TimePickerState other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long jS = s() - other.s();
        return jS < 0 ? jS + TimeUnit.HOURS.toMillis(24L) : jS;
    }

    public final List j() {
        return this.f133054d;
    }

    public final List k() {
        return this.f133051a;
    }

    public final List l() {
        return this.f133052b;
    }

    public final List m() {
        return this.f133053c;
    }

    public final long n() {
        Long l3;
        List list = this.f133053c;
        if (list == null || (l3 = (Long) CollectionsKt.getOrNull(list, this.f133057g)) == null) {
            return 0L;
        }
        return TimeUnit.MINUTES.toMillis(l3.longValue());
    }

    public final int o() {
        return this.f133058h;
    }

    public final int p() {
        return this.f133055e;
    }

    public final int q() {
        return this.f133056f;
    }

    public final int r() {
        return this.f133057g;
    }

    public final long s() {
        Long l3;
        Long l4;
        Long l5;
        Long l6;
        Long l7;
        Long l8;
        long millis = 0;
        if (!this.f133059i) {
            List list = this.f133051a;
            long millis2 = (list == null || (l5 = (Long) CollectionsKt.getOrNull(list, this.f133055e)) == null) ? 0L : TimeUnit.DAYS.toMillis(l5.longValue());
            List list2 = this.f133052b;
            long millis3 = (list2 == null || (l4 = (Long) CollectionsKt.getOrNull(list2, this.f133056f)) == null) ? 0L : TimeUnit.HOURS.toMillis(l4.longValue());
            List list3 = this.f133053c;
            if (list3 != null && (l3 = (Long) CollectionsKt.getOrNull(list3, this.f133057g)) != null) {
                millis = TimeUnit.MINUTES.toMillis(l3.longValue());
            }
            return millis2 + millis3 + millis;
        }
        List list4 = this.f133052b;
        long jLongValue = (list4 == null || (l8 = (Long) CollectionsKt.getOrNull(list4, this.f133056f)) == null) ? 0L : l8.longValue();
        List list5 = this.f133053c;
        long jLongValue2 = (list5 == null || (l7 = (Long) CollectionsKt.getOrNull(list5, this.f133057g)) == null) ? 0L : l7.longValue();
        if (this.f133060j) {
            List list6 = this.f133054d;
            if (list6 != null && (l6 = (Long) CollectionsKt.getOrNull(list6, this.f133058h)) != null) {
                millis = l6.longValue();
            }
            jLongValue = f(jLongValue, millis == 1);
        }
        return TimeUnit.HOURS.toMillis(jLongValue) + TimeUnit.MINUTES.toMillis(jLongValue2);
    }

    public final boolean t() {
        return this.f133059i;
    }

    public String toString() {
        return "TimePickerState(days=" + this.f133051a + ", hours=" + this.f133052b + ", minutes=" + this.f133053c + ", custom=" + this.f133054d + ", selectedDayIndex=" + this.f133055e + ", selectedHourIndex=" + this.f133056f + ", selectedMinuteIndex=" + this.f133057g + ", selectedCustomIndex=" + this.f133058h + ", selectingTimeOfDay=" + this.f133059i + ", use12HourFormat=" + this.f133060j + ")";
    }

    public final boolean u() {
        return this.f133060j;
    }

    public /* synthetic */ TimePickerState(List list, List list2, List list3, List list4, int i3, int i4, int i5, int i6, boolean z2, boolean z3, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? null : list, (i7 & 2) != 0 ? null : list2, (i7 & 4) != 0 ? null : list3, (i7 & 8) != 0 ? null : list4, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? 0 : i4, (i7 & 64) != 0 ? 0 : i5, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i6, (i7 & Function.MAX_NARGS) != 0 ? false : z2, (i7 & 512) != 0 ? false : z3);
    }
}
