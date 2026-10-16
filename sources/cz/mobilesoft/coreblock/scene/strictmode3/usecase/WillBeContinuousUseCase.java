package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.helperextension.CollectionsExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class WillBeContinuousUseCase extends SuspendUseCase<Params, ContinuousResult> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f122561d = StrictModeDataStore.A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileDao f122562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntervalDao f122563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StrictModeDataStore f122564c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class ContinuousResult {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Continuous extends ContinuousResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f122565a;

            public Continuous(int i3) {
                super(null);
                this.f122565a = i3;
            }

            public final int a() {
                return this.f122565a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Continuous) && this.f122565a == ((Continuous) obj).f122565a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f122565a);
            }

            public String toString() {
                return "Continuous(messageResId=" + this.f122565a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NotContinuous extends ContinuousResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NotContinuous f122566a = new NotContinuous();

            private NotContinuous() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NotContinuous);
            }

            public int hashCode() {
                return -1498294202;
            }

            public String toString() {
                return "NotContinuous";
            }
        }

        public /* synthetic */ ContinuousResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ContinuousResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f122567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConditionDTO.TimeDTO f122568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f122569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final StrictModeAccessMethod f122570d;

        public /* synthetic */ Params(Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod, DefaultConstructorMarker defaultConstructorMarker) {
            this(l3, timeDTO, num, strictModeAccessMethod);
        }

        public StrictModeAccessMethod a() {
            return this.f122570d;
        }

        public Long b() {
            return this.f122567a;
        }

        public ConditionDTO.TimeDTO c() {
            return this.f122568b;
        }

        public Integer d() {
            return this.f122569c;
        }

        private Params(Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod) {
            this.f122567a = l3;
            this.f122568b = timeDTO;
            this.f122569c = num;
            this.f122570d = strictModeAccessMethod;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FromScheduleIds extends Params {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Collection f122571e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Long f122572f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final ConditionDTO.TimeDTO f122573g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Integer f122574h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final StrictModeAccessMethod f122575i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FromScheduleIds(Collection selectedScheduleIds, Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod) {
                super(l3, timeDTO, num, strictModeAccessMethod, null);
                Intrinsics.checkNotNullParameter(selectedScheduleIds, "selectedScheduleIds");
                this.f122571e = selectedScheduleIds;
                this.f122572f = l3;
                this.f122573g = timeDTO;
                this.f122574h = num;
                this.f122575i = strictModeAccessMethod;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public StrictModeAccessMethod a() {
                return this.f122575i;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public Long b() {
                return this.f122572f;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public ConditionDTO.TimeDTO c() {
                return this.f122573g;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public Integer d() {
                return this.f122574h;
            }

            public final Collection e() {
                return this.f122571e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FromScheduleIds)) {
                    return false;
                }
                FromScheduleIds fromScheduleIds = (FromScheduleIds) obj;
                return Intrinsics.areEqual(this.f122571e, fromScheduleIds.f122571e) && Intrinsics.areEqual(this.f122572f, fromScheduleIds.f122572f) && Intrinsics.areEqual(this.f122573g, fromScheduleIds.f122573g) && Intrinsics.areEqual(this.f122574h, fromScheduleIds.f122574h) && this.f122575i == fromScheduleIds.f122575i;
            }

            public int hashCode() {
                int iHashCode = this.f122571e.hashCode() * 31;
                Long l3 = this.f122572f;
                int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
                ConditionDTO.TimeDTO timeDTO = this.f122573g;
                int iHashCode3 = (iHashCode2 + (timeDTO == null ? 0 : timeDTO.hashCode())) * 31;
                Integer num = this.f122574h;
                int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                StrictModeAccessMethod strictModeAccessMethod = this.f122575i;
                return iHashCode4 + (strictModeAccessMethod != null ? strictModeAccessMethod.hashCode() : 0);
            }

            public String toString() {
                return "FromScheduleIds(selectedScheduleIds=" + this.f122571e + ", editedScheduleId=" + this.f122572f + ", updatedTimeCondition=" + this.f122573g + ", updatedTypeCombinations=" + this.f122574h + ", accessMethod=" + this.f122575i + ")";
            }

            public /* synthetic */ FromScheduleIds(Collection collection, Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(collection, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? null : timeDTO, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : strictModeAccessMethod);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FromSchedules extends Params {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final List f122576e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Long f122577f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final ConditionDTO.TimeDTO f122578g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Integer f122579h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final StrictModeAccessMethod f122580i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FromSchedules(List selectedSchedules, Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod) {
                super(l3, timeDTO, num, strictModeAccessMethod, null);
                Intrinsics.checkNotNullParameter(selectedSchedules, "selectedSchedules");
                this.f122576e = selectedSchedules;
                this.f122577f = l3;
                this.f122578g = timeDTO;
                this.f122579h = num;
                this.f122580i = strictModeAccessMethod;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public StrictModeAccessMethod a() {
                return this.f122580i;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public Long b() {
                return this.f122577f;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public ConditionDTO.TimeDTO c() {
                return this.f122578g;
            }

            @Override // cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params
            public Integer d() {
                return this.f122579h;
            }

            public final List e() {
                return this.f122576e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FromSchedules)) {
                    return false;
                }
                FromSchedules fromSchedules = (FromSchedules) obj;
                return Intrinsics.areEqual(this.f122576e, fromSchedules.f122576e) && Intrinsics.areEqual(this.f122577f, fromSchedules.f122577f) && Intrinsics.areEqual(this.f122578g, fromSchedules.f122578g) && Intrinsics.areEqual(this.f122579h, fromSchedules.f122579h) && this.f122580i == fromSchedules.f122580i;
            }

            public int hashCode() {
                int iHashCode = this.f122576e.hashCode() * 31;
                Long l3 = this.f122577f;
                int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
                ConditionDTO.TimeDTO timeDTO = this.f122578g;
                int iHashCode3 = (iHashCode2 + (timeDTO == null ? 0 : timeDTO.hashCode())) * 31;
                Integer num = this.f122579h;
                int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                StrictModeAccessMethod strictModeAccessMethod = this.f122580i;
                return iHashCode4 + (strictModeAccessMethod != null ? strictModeAccessMethod.hashCode() : 0);
            }

            public String toString() {
                return "FromSchedules(selectedSchedules=" + this.f122576e + ", editedScheduleId=" + this.f122577f + ", updatedTimeCondition=" + this.f122578g + ", updatedTypeCombinations=" + this.f122579h + ", accessMethod=" + this.f122580i + ")";
            }

            public /* synthetic */ FromSchedules(List list, Long l3, ConditionDTO.TimeDTO timeDTO, Integer num, StrictModeAccessMethod strictModeAccessMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? null : timeDTO, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : strictModeAccessMethod);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleDto {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f122581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f122582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f122583c;

        public ScheduleDto(long j3, int i3, int i4) {
            this.f122581a = j3;
            this.f122582b = i3;
            this.f122583c = i4;
        }

        public static /* synthetic */ ScheduleDto b(ScheduleDto scheduleDto, long j3, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j3 = scheduleDto.f122581a;
            }
            if ((i5 & 2) != 0) {
                i3 = scheduleDto.f122582b;
            }
            if ((i5 & 4) != 0) {
                i4 = scheduleDto.f122583c;
            }
            return scheduleDto.a(j3, i3, i4);
        }

        public final ScheduleDto a(long j3, int i3, int i4) {
            return new ScheduleDto(j3, i3, i4);
        }

        public final int c() {
            return this.f122583c;
        }

        public final long d() {
            return this.f122581a;
        }

        public final int e() {
            return this.f122582b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleDto)) {
                return false;
            }
            ScheduleDto scheduleDto = (ScheduleDto) obj;
            return this.f122581a == scheduleDto.f122581a && this.f122582b == scheduleDto.f122582b && this.f122583c == scheduleDto.f122583c;
        }

        public final boolean f(DayFlags dayFlags) {
            Intrinsics.checkNotNullParameter(dayFlags, "dayFlags");
            return (dayFlags.getValue() & this.f122583c) > 0;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f122581a) * 31) + Integer.hashCode(this.f122582b)) * 31) + Integer.hashCode(this.f122583c);
        }

        public String toString() {
            return "ScheduleDto(id=" + this.f122581a + ", typeCombinations=" + this.f122582b + ", dayFlags=" + this.f122583c + ")";
        }
    }

    public WillBeContinuousUseCase(ProfileDao profileDao, IntervalDao intervalDao, StrictModeDataStore strictModeDataStore) {
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(intervalDao, "intervalDao");
        Intrinsics.checkNotNullParameter(strictModeDataStore, "strictModeDataStore");
        this.f122562a = profileDao;
        this.f122563b = intervalDao;
        this.f122564c = strictModeDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Path cross not found for [B:46:0x013a, B:41:0x012c], limit reached: 110 */
    /* JADX WARN: Path cross not found for [B:54:0x014f, B:56:0x0155], limit reached: 110 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0220 -> B:86:0x0225). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.util.List r32, java.lang.Long r33, cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.TimeDTO r34, java.lang.Integer r35, cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r36, kotlin.coroutines.Continuation r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.c(java.util.List, java.lang.Long, cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$TimeDTO, java.lang.Integer, cz.mobilesoft.coreblock.enums.StrictModeAccessMethod, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean e(List list) {
        int iIntValue = 1439;
        int iIntValue2 = 0;
        for (Pair pair : CollectionsKt.sortedWith(list, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase$isDayContinuous$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d((Integer) ((Pair) obj).e(), (Integer) ((Pair) obj2).e());
            }
        })) {
            if (((Number) pair.e()).intValue() > iIntValue2) {
                return false;
            }
            if (((Number) pair.e()).intValue() < iIntValue) {
                iIntValue = ((Number) pair.e()).intValue();
            }
            if (((Number) pair.f()).intValue() > iIntValue2) {
                iIntValue2 = ((Number) pair.f()).intValue();
            }
        }
        return iIntValue <= 0 && ((long) iIntValue2) >= 1439;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b5 -> B:25:0x00bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0159 -> B:39:0x015a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.ScheduleDto r19, java.util.Map r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.f(cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase$ScheduleDto, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void g(ConditionDTO.TimeDTO timeDTO, Map map) {
        for (DayFlags dayFlags : DayFlags.values()) {
            if ((timeDTO.c() & dayFlags.getValue()) > 0) {
                Integer numValueOf = Integer.valueOf(dayFlags.getValue());
                Object arrayList = map.get(numValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(numValueOf, arrayList);
                }
                List list = (List) arrayList;
                Collection<IntervalDTO> collectionD = CollectionsExtKt.d(timeDTO.d());
                if (collectionD != null) {
                    for (IntervalDTO intervalDTO : collectionD) {
                        if (intervalDTO.b() > intervalDTO.a()) {
                            list.add(new Pair(Integer.valueOf((int) intervalDTO.b()), 1439));
                            list.add(new Pair(0, Integer.valueOf((int) intervalDTO.a())));
                        } else {
                            list.add(new Pair(Integer.valueOf((int) intervalDTO.b()), Integer.valueOf((int) intervalDTO.a())));
                        }
                    }
                } else {
                    list.add(new Pair(0, 1439));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r11 == r0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.Params r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase.d(cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
