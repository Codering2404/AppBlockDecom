package cz.mobilesoft.coreblock.scene.schedule;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public abstract class ScheduleDescriptor implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f114474a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CombinationOnboardingV2 extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProfileType f114475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConditionDTO f114476c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CombinationOnboardingV2(ProfileType profileType, ConditionDTO conditionDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f114475b = profileType;
            this.f114476c = conditionDTO;
        }

        public final ConditionDTO c() {
            return this.f114476c;
        }

        public final ProfileType d() {
            return this.f114475b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CombinationOnboardingV2)) {
                return false;
            }
            CombinationOnboardingV2 combinationOnboardingV2 = (CombinationOnboardingV2) obj;
            return this.f114475b == combinationOnboardingV2.f114475b && Intrinsics.areEqual(this.f114476c, combinationOnboardingV2.f114476c);
        }

        public int hashCode() {
            int iHashCode = this.f114475b.hashCode() * 31;
            ConditionDTO conditionDTO = this.f114476c;
            return iHashCode + (conditionDTO == null ? 0 : conditionDTO.hashCode());
        }

        public String toString() {
            return "CombinationOnboardingV2(profileType=" + this.f114475b + ", condition=" + this.f114476c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class QuickBlock extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f114484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f114485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f114486d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f114487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Long f114488g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final QuickBlockSource f114489h;

        public QuickBlock(boolean z2, boolean z3, boolean z4, boolean z5, Long l3, QuickBlockSource quickBlockSource) {
            super(null);
            this.f114484b = z2;
            this.f114485c = z3;
            this.f114486d = z4;
            this.f114487f = z5;
            this.f114488g = l3;
            this.f114489h = quickBlockSource;
        }

        public final boolean c() {
            return this.f114487f;
        }

        public final boolean d() {
            return this.f114486d;
        }

        public final boolean e() {
            return this.f114485c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuickBlock)) {
                return false;
            }
            QuickBlock quickBlock = (QuickBlock) obj;
            return this.f114484b == quickBlock.f114484b && this.f114485c == quickBlock.f114485c && this.f114486d == quickBlock.f114486d && this.f114487f == quickBlock.f114487f && Intrinsics.areEqual(this.f114488g, quickBlock.f114488g) && this.f114489h == quickBlock.f114489h;
        }

        public final QuickBlockSource f() {
            return this.f114489h;
        }

        public final Long g() {
            return this.f114488g;
        }

        public final boolean h() {
            return this.f114484b;
        }

        public int hashCode() {
            int iHashCode = ((((((Boolean.hashCode(this.f114484b) * 31) + Boolean.hashCode(this.f114485c)) * 31) + Boolean.hashCode(this.f114486d)) * 31) + Boolean.hashCode(this.f114487f)) * 31;
            Long l3 = this.f114488g;
            int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
            QuickBlockSource quickBlockSource = this.f114489h;
            return iHashCode2 + (quickBlockSource != null ? quickBlockSource.hashCode() : 0);
        }

        public String toString() {
            return rnFwbPAQmQTnL.tGMKJMOnClltLK + this.f114484b + ", showBlockingLevelSettings=" + this.f114485c + ", showAddNewAppsScreen=" + this.f114486d + ", shouldActivate=" + this.f114487f + ", timer=" + this.f114488g + ", sourceType=" + this.f114489h + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ QuickBlock(boolean r2, boolean r3, boolean r4, boolean r5, java.lang.Long r6, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor.QuickBlockSource r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
            /*
                r1 = this;
                r9 = r8 & 1
                if (r9 == 0) goto L5
                r2 = 1
            L5:
                r9 = r8 & 2
                r0 = 0
                if (r9 == 0) goto Lb
                r3 = r0
            Lb:
                r9 = r8 & 4
                if (r9 == 0) goto L10
                r4 = r0
            L10:
                r9 = r8 & 8
                if (r9 == 0) goto L15
                r5 = r0
            L15:
                r9 = r8 & 16
                r0 = 0
                if (r9 == 0) goto L1b
                r6 = r0
            L1b:
                r8 = r8 & 32
                if (r8 == 0) goto L27
                r9 = r0
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                goto L2e
            L27:
                r9 = r7
                r8 = r6
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
            L2e:
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor.QuickBlock.<init>(boolean, boolean, boolean, boolean, java.lang.Long, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor$QuickBlockSource, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class QuickBlockOnboarding extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f114490b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuickBlockOnboarding(List recommendedApps) {
            super(null);
            Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
            this.f114490b = recommendedApps;
        }

        public final List c() {
            return this.f114490b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickBlockOnboarding) && Intrinsics.areEqual(this.f114490b, ((QuickBlockOnboarding) obj).f114490b);
        }

        public int hashCode() {
            return this.f114490b.hashCode();
        }

        public String toString() {
            return "QuickBlockOnboarding(recommendedApps=" + this.f114490b + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class QuickBlockSource {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ QuickBlockSource[] $VALUES;
        public static final QuickBlockSource TIMER = new QuickBlockSource("TIMER", 0);
        public static final QuickBlockSource POMODORO = new QuickBlockSource("POMODORO", 1);

        private static final /* synthetic */ QuickBlockSource[] $values() {
            return new QuickBlockSource[]{TIMER, POMODORO};
        }

        static {
            QuickBlockSource[] quickBlockSourceArr$values = $values();
            $VALUES = quickBlockSourceArr$values;
            $ENTRIES = EnumEntriesKt.a(quickBlockSourceArr$values);
        }

        private QuickBlockSource(String str, int i3) {
        }

        public static EnumEntries<QuickBlockSource> getEntries() {
            return $ENTRIES;
        }

        public static QuickBlockSource valueOf(String str) {
            return (QuickBlockSource) Enum.valueOf(QuickBlockSource.class, str);
        }

        public static QuickBlockSource[] values() {
            return (QuickBlockSource[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleContainer extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ScheduleDTO f114491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f114492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f114493d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduleContainer(ScheduleDTO scheduleDTO, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleDTO, "scheduleDTO");
            this.f114491b = scheduleDTO;
            this.f114492c = l3;
            this.f114493d = true;
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor
        public boolean a() {
            return this.f114493d;
        }

        public final Long c() {
            return this.f114492c;
        }

        public final ScheduleDTO d() {
            return this.f114491b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleContainer)) {
                return false;
            }
            ScheduleContainer scheduleContainer = (ScheduleContainer) obj;
            return Intrinsics.areEqual(this.f114491b, scheduleContainer.f114491b) && Intrinsics.areEqual(this.f114492c, scheduleContainer.f114492c);
        }

        public int hashCode() {
            int iHashCode = this.f114491b.hashCode() * 31;
            Long l3 = this.f114492c;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "ScheduleContainer(scheduleDTO=" + this.f114491b + ", originalId=" + this.f114492c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleId extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f114494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f114495c;

        public ScheduleId(long j3, boolean z2) {
            super(null);
            this.f114494b = j3;
            this.f114495c = z2;
        }

        public final long c() {
            return this.f114494b;
        }

        public final boolean d() {
            return this.f114495c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleId)) {
                return false;
            }
            ScheduleId scheduleId = (ScheduleId) obj;
            return this.f114494b == scheduleId.f114494b && this.f114495c == scheduleId.f114495c;
        }

        public int hashCode() {
            return (Long.hashCode(this.f114494b) * 31) + Boolean.hashCode(this.f114495c);
        }

        public String toString() {
            return "ScheduleId(id=" + this.f114494b + ", isCurrentlyOn=" + this.f114495c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleTemplateDescriptor extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ScheduleTemplate f114496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f114497c;

        public ScheduleTemplateDescriptor(ScheduleTemplate scheduleTemplate) {
            super(null);
            this.f114496b = scheduleTemplate;
            this.f114497c = true;
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor
        public boolean a() {
            return this.f114497c;
        }

        public final ScheduleTemplate c() {
            return this.f114496b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScheduleTemplateDescriptor) && this.f114496b == ((ScheduleTemplateDescriptor) obj).f114496b;
        }

        public int hashCode() {
            ScheduleTemplate scheduleTemplate = this.f114496b;
            if (scheduleTemplate == null) {
                return 0;
            }
            return scheduleTemplate.hashCode();
        }

        public String toString() {
            return "ScheduleTemplateDescriptor(scheduleTemplate=" + this.f114496b + ")";
        }
    }

    public /* synthetic */ ScheduleDescriptor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean a() {
        return this.f114474a;
    }

    public final boolean b() {
        if (this instanceof QuickBlockOnboarding) {
            return true;
        }
        return (this instanceof QuickBlock) && !((QuickBlock) this).h();
    }

    private ScheduleDescriptor() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NewSchedule extends ScheduleDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f114477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f114478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f114479d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f114480f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConditionDTO f114481g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ProfileType f114482h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f114483i;

        public NewSchedule(List list, List list2, boolean z2, boolean z3, ConditionDTO conditionDTO, ProfileType profileType) {
            super(null);
            this.f114477b = list;
            this.f114478c = list2;
            this.f114479d = z2;
            this.f114480f = z3;
            this.f114481g = conditionDTO;
            this.f114482h = profileType;
            this.f114483i = true;
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor
        public boolean a() {
            return this.f114483i;
        }

        public final ConditionDTO c() {
            return this.f114481g;
        }

        public final List d() {
            return this.f114477b;
        }

        public final List e() {
            return this.f114478c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NewSchedule)) {
                return false;
            }
            NewSchedule newSchedule = (NewSchedule) obj;
            return Intrinsics.areEqual(this.f114477b, newSchedule.f114477b) && Intrinsics.areEqual(this.f114478c, newSchedule.f114478c) && this.f114479d == newSchedule.f114479d && this.f114480f == newSchedule.f114480f && Intrinsics.areEqual(this.f114481g, newSchedule.f114481g) && this.f114482h == newSchedule.f114482h;
        }

        public final ProfileType f() {
            return this.f114482h;
        }

        public final boolean g() {
            return this.f114479d;
        }

        public int hashCode() {
            List list = this.f114477b;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List list2 = this.f114478c;
            int iHashCode2 = (((((iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31) + Boolean.hashCode(this.f114479d)) * 31) + Boolean.hashCode(this.f114480f)) * 31;
            ConditionDTO conditionDTO = this.f114481g;
            int iHashCode3 = (iHashCode2 + (conditionDTO == null ? 0 : conditionDTO.hashCode())) * 31;
            ProfileType profileType = this.f114482h;
            return iHashCode3 + (profileType != null ? profileType.hashCode() : 0);
        }

        public String toString() {
            return "NewSchedule(initialApps=" + this.f114477b + ", initialWebs=" + this.f114478c + ", isForStrictMode=" + this.f114479d + ", skipBlockingSelect=" + this.f114480f + ", condition=" + this.f114481g + ", profileType=" + this.f114482h + ")";
        }

        public /* synthetic */ NewSchedule(List list, List list2, boolean z2, boolean z3, ConditionDTO conditionDTO, ProfileType profileType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : list2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? null : conditionDTO, (i3 & 32) != 0 ? null : profileType);
        }
    }
}
