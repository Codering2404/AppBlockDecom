package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import org.threeten.bp.DayOfWeek;

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
public final class Configuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableSet f115679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableSet f115680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f115681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f115682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f115683e;

    public Configuration(ImmutableSet selectedDays, ImmutableSet originalSelectedDays, ImmutableList intervals, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(selectedDays, "selectedDays");
        Intrinsics.checkNotNullParameter(originalSelectedDays, "originalSelectedDays");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.f115679a = selectedDays;
        this.f115680b = originalSelectedDays;
        this.f115681c = intervals;
        this.f115682d = z2;
        this.f115683e = z3;
    }

    public static /* synthetic */ Configuration b(Configuration configuration, ImmutableSet immutableSet, ImmutableSet immutableSet2, ImmutableList immutableList, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            immutableSet = configuration.f115679a;
        }
        if ((i3 & 2) != 0) {
            immutableSet2 = configuration.f115680b;
        }
        if ((i3 & 4) != 0) {
            immutableList = configuration.f115681c;
        }
        if ((i3 & 8) != 0) {
            z2 = configuration.f115682d;
        }
        if ((i3 & 16) != 0) {
            z3 = configuration.f115683e;
        }
        boolean z4 = z3;
        ImmutableList immutableList2 = immutableList;
        return configuration.a(immutableSet, immutableSet2, immutableList2, z2, z4);
    }

    public final Configuration a(ImmutableSet selectedDays, ImmutableSet originalSelectedDays, ImmutableList intervals, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(selectedDays, "selectedDays");
        Intrinsics.checkNotNullParameter(originalSelectedDays, "originalSelectedDays");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        return new Configuration(selectedDays, originalSelectedDays, intervals, z2, z3);
    }

    public final long c() {
        long jA = 0;
        for (IntervalDTO intervalDTO : g()) {
            jA += intervalDTO.a() - intervalDTO.b();
        }
        return TimeUnit.MINUTES.toMillis(jA);
    }

    public final IntervalDTO d(List intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Calendar calendarA = TimeHelperExt.A();
        DayOfWeek dayOfWeekL = DayOfWeek.l(calendarA.get(7) != 1 ? calendarA.get(7) - 1 : 7);
        long j3 = ((long) calendarA.get(12)) + (((long) calendarA.get(11)) * 60);
        if (!this.f115679a.contains(dayOfWeekL)) {
            return null;
        }
        Iterator it = intervals.iterator();
        while (it.hasNext()) {
            IntervalDTO intervalDTO = (IntervalDTO) it.next();
            if (intervalDTO.b() > intervalDTO.a()) {
                if (j3 >= intervalDTO.b() || j3 < intervalDTO.a()) {
                    return intervalDTO;
                }
            } else if (j3 >= intervalDTO.b() && j3 < intervalDTO.a()) {
                return intervalDTO;
            }
        }
        return null;
    }

    public final ImmutableList e() {
        return this.f115681c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return Intrinsics.areEqual(this.f115679a, configuration.f115679a) && Intrinsics.areEqual(this.f115680b, configuration.f115680b) && Intrinsics.areEqual(this.f115681c, configuration.f115681c) && this.f115682d == configuration.f115682d && this.f115683e == configuration.f115683e;
    }

    public final long f() {
        IntervalDTO intervalDTO = (IntervalDTO) CollectionsKt.lastOrNull((List) this.f115681c);
        if (intervalDTO != null) {
            return intervalDTO.a();
        }
        Calendar calendarA = TimeHelperExt.A();
        return ((long) calendarA.get(12)) + (((long) calendarA.get(11)) * 60);
    }

    public final List g() {
        if (this.f115682d) {
            return CollectionsKt.listOf(new IntervalDTO(0L, TimeUnit.HOURS.toMinutes(24L), null, null, 12, null));
        }
        if (this.f115681c.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (IntervalDTO intervalDTO : this.f115681c) {
            if (IntervalsHelperKt.m(intervalDTO)) {
                arrayList.add(new IntervalDTO(0L, intervalDTO.a(), null, null, 12, null));
                arrayList.add(IntervalDTO.d(intervalDTO, 0L, 1440L, null, null, 13, null));
            } else {
                arrayList.add(intervalDTO);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration$getMergedIntervals$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Long.valueOf(((IntervalDTO) obj).b()), Long.valueOf(((IntervalDTO) obj2).b()));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        IntervalDTO intervalDTO2 = (IntervalDTO) CollectionsKt.first(listSortedWith);
        int size = listSortedWith.size();
        IntervalDTO intervalDTO3 = intervalDTO2;
        for (int i3 = 1; i3 < size; i3++) {
            IntervalDTO intervalDTOD = (IntervalDTO) listSortedWith.get(i3);
            if (intervalDTOD.b() <= intervalDTO3.a()) {
                intervalDTOD = IntervalDTO.d(intervalDTO3, 0L, Math.max(intervalDTO3.a(), intervalDTOD.a()), null, null, 13, null);
            } else {
                arrayList2.add(intervalDTO3);
            }
            intervalDTO3 = intervalDTOD;
        }
        arrayList2.add(intervalDTO3);
        return arrayList2;
    }

    public final IntervalDTO h() {
        long jF = f() + ((long) 10);
        long j3 = ((long) 120) + jF;
        if (j3 > 1440) {
            j3 -= 1440;
        }
        return new IntervalDTO(jF, j3, null, null, 12, null);
    }

    public int hashCode() {
        return (((((((this.f115679a.hashCode() * 31) + this.f115680b.hashCode()) * 31) + this.f115681c.hashCode()) * 31) + Boolean.hashCode(this.f115682d)) * 31) + Boolean.hashCode(this.f115683e);
    }

    public final ImmutableSet i() {
        return this.f115680b;
    }

    public final boolean j() {
        return this.f115683e;
    }

    public final ImmutableSet k() {
        return this.f115679a;
    }

    public final boolean l() {
        return this.f115682d;
    }

    public String toString() {
        return "Configuration(selectedDays=" + this.f115679a + ", originalSelectedDays=" + this.f115680b + ", intervals=" + this.f115681c + ", isAllDayLong=" + this.f115682d + ", originallyAllDayLong=" + this.f115683e + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Configuration(kotlinx.collections.immutable.ImmutableSet r2, kotlinx.collections.immutable.ImmutableSet r3, kotlinx.collections.immutable.ImmutableList r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            kotlinx.collections.immutable.PersistentSet r2 = kotlinx.collections.immutable.ExtensionsKt.c()
        L8:
            r8 = r7 & 2
            if (r8 == 0) goto L10
            kotlinx.collections.immutable.PersistentSet r3 = kotlinx.collections.immutable.ExtensionsKt.c()
        L10:
            r8 = r7 & 4
            if (r8 == 0) goto L18
            kotlinx.collections.immutable.PersistentList r4 = kotlinx.collections.immutable.ExtensionsKt.a()
        L18:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L1e
            r5 = r0
        L1e:
            r7 = r7 & 16
            if (r7 == 0) goto L29
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2f
        L29:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2f:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration.<init>(kotlinx.collections.immutable.ImmutableSet, kotlinx.collections.immutable.ImmutableSet, kotlinx.collections.immutable.ImmutableList, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
