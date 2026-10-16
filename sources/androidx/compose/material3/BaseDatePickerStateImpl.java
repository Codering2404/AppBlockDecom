package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

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
public abstract class BaseDatePickerStateImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntRange f15930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CalendarModel f15931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f15932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableState f15933d;

    public BaseDatePickerStateImpl(Long l3, IntRange intRange, SelectableDates selectableDates, Locale locale) {
        CalendarMonth calendarMonthH;
        this.f15930a = intRange;
        CalendarModel calendarModelA = CalendarModel_androidKt.a(locale);
        this.f15931b = calendarModelA;
        this.f15932c = SnapshotStateKt__SnapshotStateKt.e(selectableDates, null, 2, null);
        if (l3 != null) {
            calendarMonthH = calendarModelA.g(l3.longValue());
            if (!intRange.p(calendarMonthH.f())) {
                throw new IllegalArgumentException(("The initial display month's year (" + calendarMonthH.f() + ") is out of the years range of " + intRange + '.').toString());
            }
        } else {
            calendarMonthH = calendarModelA.h(calendarModelA.i());
        }
        this.f15933d = SnapshotStateKt__SnapshotStateKt.e(calendarMonthH, null, 2, null);
    }

    public final void a(long j3) {
        CalendarMonth calendarMonthG = this.f15931b.g(j3);
        if (this.f15930a.p(calendarMonthG.f())) {
            this.f15933d.setValue(calendarMonthG);
            return;
        }
        throw new IllegalArgumentException(("The display month's year (" + calendarMonthG.f() + ") is out of the years range of " + this.f15930a + '.').toString());
    }

    public final SelectableDates b() {
        return (SelectableDates) this.f15932c.getValue();
    }

    public final IntRange c() {
        return this.f15930a;
    }

    public final long f() {
        return ((CalendarMonth) this.f15933d.getValue()).e();
    }

    public final CalendarModel l() {
        return this.f15931b;
    }

    public final void m(SelectableDates selectableDates) {
        this.f15932c.setValue(selectableDates);
    }
}
