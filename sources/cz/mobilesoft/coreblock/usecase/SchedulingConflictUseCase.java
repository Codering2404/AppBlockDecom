package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.dto.ConflictingSchedule;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class SchedulingConflictUseCase extends SuspendUseCase<Params, List<? extends ConflictingSchedule>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileDao f127243a;

    public SchedulingConflictUseCase(ProfileDao profileDao) {
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        this.f127243a = profileDao;
    }

    private final Set a(Iterable iterable, Iterable iterable2) {
        return CollectionsKt.toSet(CollectionsKt.minus((Iterable) CollectionsKt.plus(iterable, iterable2), (Iterable) CollectionsKt.intersect(iterable, iterable2)));
    }

    private final List b(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IntervalDTO intervalDTO = (IntervalDTO) it.next();
            long jB = intervalDTO.b();
            long jA = intervalDTO.a();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                IntervalDTO intervalDTO2 = (IntervalDTO) it2.next();
                long jB2 = intervalDTO2.b();
                long jA2 = intervalDTO2.a();
                if (jB <= jA2 && jA >= jB2) {
                    arrayList.add(new IntervalDTO(Math.max(jB, jB2), Math.min(jA, jA2), null, null, 12, null));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase.Params r33, kotlin.coroutines.Continuation r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase.c(cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f127244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Profile.BlockingMode f127245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f127246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f127247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f127248e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f127249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConditionDTO.TimeDTO f127250g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ConditionDTO.LaunchCountDTO f127251h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ConditionDTO.UsageLimitDTO f127252i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f127253j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f127254k;

        public Params(Long l3, Profile.BlockingMode blockingMode, List applications, List websites, List keywords, boolean z2, ConditionDTO.TimeDTO timeDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.UsageLimitDTO usageLimitDTO) {
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(websites, "websites");
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            this.f127244a = l3;
            this.f127245b = blockingMode;
            this.f127246c = applications;
            this.f127247d = websites;
            this.f127248e = keywords;
            this.f127249f = z2;
            this.f127250g = timeDTO;
            this.f127251h = launchCountDTO;
            this.f127252i = usageLimitDTO;
            boolean z3 = false;
            this.f127253j = timeDTO == null && launchCountDTO == null && usageLimitDTO == null;
            if (timeDTO != null && launchCountDTO == null && usageLimitDTO == null) {
                z3 = true;
            }
            this.f127254k = z3;
        }

        public final List a() {
            return this.f127246c;
        }

        public final Profile.BlockingMode b() {
            return this.f127245b;
        }

        public final Long c() {
            return this.f127244a;
        }

        public final List d() {
            return this.f127248e;
        }

        public final ConditionDTO.LaunchCountDTO e() {
            return this.f127251h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127244a, params.f127244a) && this.f127245b == params.f127245b && Intrinsics.areEqual(this.f127246c, params.f127246c) && Intrinsics.areEqual(this.f127247d, params.f127247d) && Intrinsics.areEqual(this.f127248e, params.f127248e) && this.f127249f == params.f127249f && Intrinsics.areEqual(this.f127250g, params.f127250g) && Intrinsics.areEqual(this.f127251h, params.f127251h) && Intrinsics.areEqual(this.f127252i, params.f127252i);
        }

        public final ConditionDTO.TimeDTO f() {
            return this.f127250g;
        }

        public final ConditionDTO.UsageLimitDTO g() {
            return this.f127252i;
        }

        public final List h() {
            return this.f127247d;
        }

        public int hashCode() {
            Long l3 = this.f127244a;
            int iHashCode = (((((((((((l3 == null ? 0 : l3.hashCode()) * 31) + this.f127245b.hashCode()) * 31) + this.f127246c.hashCode()) * 31) + this.f127247d.hashCode()) * 31) + this.f127248e.hashCode()) * 31) + Boolean.hashCode(this.f127249f)) * 31;
            ConditionDTO.TimeDTO timeDTO = this.f127250g;
            int iHashCode2 = (iHashCode + (timeDTO == null ? 0 : timeDTO.hashCode())) * 31;
            ConditionDTO.LaunchCountDTO launchCountDTO = this.f127251h;
            int iHashCode3 = (iHashCode2 + (launchCountDTO == null ? 0 : launchCountDTO.hashCode())) * 31;
            ConditionDTO.UsageLimitDTO usageLimitDTO = this.f127252i;
            return iHashCode3 + (usageLimitDTO != null ? usageLimitDTO.hashCode() : 0);
        }

        public final boolean i() {
            return this.f127253j;
        }

        public final boolean j() {
            return this.f127254k;
        }

        public final boolean k() {
            return this.f127249f;
        }

        public String toString() {
            return "Params(id=" + this.f127244a + ", blockingMode=" + this.f127245b + ", applications=" + this.f127246c + ", websites=" + this.f127247d + ", keywords=" + this.f127248e + ", isQuickBlock=" + this.f127249f + ", time=" + this.f127250g + ", launchCount=" + this.f127251h + ", usageLimit=" + this.f127252i + ")";
        }

        public /* synthetic */ Params(Long l3, Profile.BlockingMode blockingMode, List list, List list2, List list3, boolean z2, ConditionDTO.TimeDTO timeDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.UsageLimitDTO usageLimitDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? null : timeDTO, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : launchCountDTO, (i3 & Function.MAX_NARGS) != 0 ? null : usageLimitDTO);
        }
    }
}
