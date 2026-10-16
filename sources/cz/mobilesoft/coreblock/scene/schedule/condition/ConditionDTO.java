package cz.mobilesoft.coreblock.scene.schedule.condition;

import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class ConditionDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileType f115191a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CombinationDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set f115192b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CombinationDTO(Set conditions) {
            super(ProfileType.COMBINED, null);
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.f115192b = conditions;
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return f();
        }

        public final Set c() {
            return this.f115192b;
        }

        public final LaunchCountDTO d() {
            Object next;
            Iterator it = this.f115192b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ConditionDTO) next).a() == ProfileType.LAUNCH_COUNT) {
                    break;
                }
            }
            if (next instanceof LaunchCountDTO) {
                return (LaunchCountDTO) next;
            }
            return null;
        }

        public final LocationDTO e() {
            Object next;
            Iterator it = this.f115192b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ConditionDTO) next).a() == ProfileType.LOCATION) {
                    break;
                }
            }
            if (next instanceof LocationDTO) {
                return (LocationDTO) next;
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CombinationDTO) && Intrinsics.areEqual(this.f115192b, ((CombinationDTO) obj).f115192b);
        }

        public final TimeDTO f() {
            Object next;
            Iterator it = this.f115192b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ConditionDTO) next).a() == ProfileType.TIME) {
                    break;
                }
            }
            if (next instanceof TimeDTO) {
                return (TimeDTO) next;
            }
            return null;
        }

        public final UsageLimitDTO g() {
            Object next;
            Iterator it = this.f115192b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ConditionDTO) next).a() == ProfileType.USAGE_LIMIT) {
                    break;
                }
            }
            if (next instanceof UsageLimitDTO) {
                return (UsageLimitDTO) next;
            }
            return null;
        }

        public final WifisDTO h() {
            Object next;
            Iterator it = this.f115192b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ConditionDTO) next).a() == ProfileType.WIFI) {
                    break;
                }
            }
            if (next instanceof WifisDTO) {
                return (WifisDTO) next;
            }
            return null;
        }

        public int hashCode() {
            return this.f115192b.hashCode();
        }

        public String toString() {
            return "CombinationDTO(conditions=" + this.f115192b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LocationDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final GeoAddressDTO f115198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeDTO f115199c;

        public /* synthetic */ LocationDTO(GeoAddressDTO geoAddressDTO, TimeDTO timeDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : geoAddressDTO, (i3 & 2) != 0 ? null : timeDTO);
        }

        public static /* synthetic */ LocationDTO d(LocationDTO locationDTO, GeoAddressDTO geoAddressDTO, TimeDTO timeDTO, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                geoAddressDTO = locationDTO.f115198b;
            }
            if ((i3 & 2) != 0) {
                timeDTO = locationDTO.f115199c;
            }
            return locationDTO.c(geoAddressDTO, timeDTO);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return this.f115199c;
        }

        public final LocationDTO c(GeoAddressDTO geoAddressDTO, TimeDTO timeDTO) {
            return new LocationDTO(geoAddressDTO, timeDTO);
        }

        public final GeoAddressDTO e() {
            return this.f115198b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationDTO)) {
                return false;
            }
            LocationDTO locationDTO = (LocationDTO) obj;
            return Intrinsics.areEqual(this.f115198b, locationDTO.f115198b) && Intrinsics.areEqual(this.f115199c, locationDTO.f115199c);
        }

        public final TimeDTO f() {
            return this.f115199c;
        }

        public int hashCode() {
            GeoAddressDTO geoAddressDTO = this.f115198b;
            int iHashCode = (geoAddressDTO == null ? 0 : geoAddressDTO.hashCode()) * 31;
            TimeDTO timeDTO = this.f115199c;
            return iHashCode + (timeDTO != null ? timeDTO.hashCode() : 0);
        }

        public String toString() {
            return "LocationDTO(geoAddress=" + this.f115198b + ", timeCondition=" + this.f115199c + ")";
        }

        public LocationDTO(GeoAddressDTO geoAddressDTO, TimeDTO timeDTO) {
            super(ProfileType.LOCATION, null);
            this.f115198b = geoAddressDTO;
            this.f115199c = timeDTO;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WifisDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f115209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeDTO f115210c;

        public /* synthetic */ WifisDTO(ArrayList arrayList, TimeDTO timeDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, (i3 & 2) != 0 ? null : timeDTO);
        }

        public static /* synthetic */ WifisDTO d(WifisDTO wifisDTO, ArrayList arrayList, TimeDTO timeDTO, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                arrayList = wifisDTO.f115209b;
            }
            if ((i3 & 2) != 0) {
                timeDTO = wifisDTO.f115210c;
            }
            return wifisDTO.c(arrayList, timeDTO);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return this.f115210c;
        }

        public final WifisDTO c(ArrayList wifis, TimeDTO timeDTO) {
            Intrinsics.checkNotNullParameter(wifis, "wifis");
            return new WifisDTO(wifis, timeDTO);
        }

        public final TimeDTO e() {
            return this.f115210c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WifisDTO)) {
                return false;
            }
            WifisDTO wifisDTO = (WifisDTO) obj;
            return Intrinsics.areEqual(this.f115209b, wifisDTO.f115209b) && Intrinsics.areEqual(this.f115210c, wifisDTO.f115210c);
        }

        public final ArrayList f() {
            return this.f115209b;
        }

        public int hashCode() {
            int iHashCode = this.f115209b.hashCode() * 31;
            TimeDTO timeDTO = this.f115210c;
            return iHashCode + (timeDTO == null ? 0 : timeDTO.hashCode());
        }

        public String toString() {
            return "WifisDTO(wifis=" + this.f115209b + ", timeCondition=" + this.f115210c + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WifisDTO(ArrayList wifis, TimeDTO timeDTO) {
            super(ProfileType.WIFI, null);
            Intrinsics.checkNotNullParameter(wifis, "wifis");
            this.f115209b = wifis;
            this.f115210c = timeDTO;
        }
    }

    public /* synthetic */ ConditionDTO(ProfileType profileType, DefaultConstructorMarker defaultConstructorMarker) {
        this(profileType);
    }

    public final ProfileType a() {
        return this.f115191a;
    }

    public abstract TimeDTO b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchCountDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f115193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f115194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f115195d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final UsageLimit.PeriodType f115196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final TimeDTO f115197g;

        public /* synthetic */ LaunchCountDTO(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? 0L : j4, (i3 & 8) != 0 ? UsageLimit.PeriodType.DAILY : periodType, (i3 & 16) != 0 ? null : timeDTO);
        }

        public static /* synthetic */ LaunchCountDTO d(LaunchCountDTO launchCountDTO, long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = launchCountDTO.f115193b;
            }
            long j5 = j3;
            if ((i3 & 2) != 0) {
                l3 = launchCountDTO.f115194c;
            }
            Long l4 = l3;
            if ((i3 & 4) != 0) {
                j4 = launchCountDTO.f115195d;
            }
            long j6 = j4;
            if ((i3 & 8) != 0) {
                periodType = launchCountDTO.f115196f;
            }
            UsageLimit.PeriodType periodType2 = periodType;
            if ((i3 & 16) != 0) {
                timeDTO = launchCountDTO.f115197g;
            }
            return launchCountDTO.c(j5, l4, j6, periodType2, timeDTO);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return this.f115197g;
        }

        public final LaunchCountDTO c(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO) {
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            return new LaunchCountDTO(j3, l3, j4, periodType, timeDTO);
        }

        public final long e() {
            return this.f115193b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LaunchCountDTO)) {
                return false;
            }
            LaunchCountDTO launchCountDTO = (LaunchCountDTO) obj;
            return this.f115193b == launchCountDTO.f115193b && Intrinsics.areEqual(this.f115194c, launchCountDTO.f115194c) && this.f115195d == launchCountDTO.f115195d && this.f115196f == launchCountDTO.f115196f && Intrinsics.areEqual(this.f115197g, launchCountDTO.f115197g);
        }

        public final Long f() {
            return this.f115194c;
        }

        public final UsageLimit.PeriodType g() {
            return this.f115196f;
        }

        public final long h() {
            long j3 = this.f115193b - this.f115195d;
            if (j3 < 0) {
                return 0L;
            }
            return j3;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.f115193b) * 31;
            Long l3 = this.f115194c;
            int iHashCode2 = (((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f115195d)) * 31) + this.f115196f.hashCode()) * 31;
            TimeDTO timeDTO = this.f115197g;
            return iHashCode2 + (timeDTO != null ? timeDTO.hashCode() : 0);
        }

        public final TimeDTO i() {
            return this.f115197g;
        }

        public final long j() {
            return this.f115195d;
        }

        public String toString() {
            return "LaunchCountDTO(allowedCount=" + this.f115193b + ", originalAllowedCount=" + this.f115194c + ", usedCount=" + this.f115195d + ", periodType=" + this.f115196f + ", timeCondition=" + this.f115197g + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LaunchCountDTO(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO) {
            super(ProfileType.LAUNCH_COUNT, null);
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            this.f115193b = j3;
            this.f115194c = l3;
            this.f115195d = j4;
            this.f115196f = periodType;
            this.f115197g = timeDTO;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimeDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f115200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList f115201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f115202d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class EntriesMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f115203a = EnumEntriesKt.a(DayOfWeek.values());
        }

        public /* synthetic */ TimeDTO(int i3, ArrayList arrayList, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0 : i3, (i5 & 2) != 0 ? new ArrayList(0) : arrayList, (i5 & 4) != 0 ? 0 : i4);
        }

        public final int c() {
            return this.f115200b;
        }

        public final ArrayList d() {
            return this.f115201c;
        }

        public final ImmutableSet e() {
            return g(this.f115202d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeDTO)) {
                return false;
            }
            TimeDTO timeDTO = (TimeDTO) obj;
            return this.f115200b == timeDTO.f115200b && Intrinsics.areEqual(this.f115201c, timeDTO.f115201c) && this.f115202d == timeDTO.f115202d;
        }

        public final ImmutableSet f() {
            return g(this.f115200b);
        }

        public final ImmutableSet g(int i3) {
            EnumEntries enumEntries = EntriesMappings.f115203a;
            ArrayList arrayList = new ArrayList();
            for (Object obj : enumEntries) {
                if ((DayFlags.Companion.b((DayOfWeek) obj).getValue() & i3) > 0) {
                    arrayList.add(obj);
                }
            }
            return ExtensionsKt.j(arrayList);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f115200b) * 31) + this.f115201c.hashCode()) * 31) + Integer.hashCode(this.f115202d);
        }

        public String toString() {
            return "TimeDTO(dayFlags=" + this.f115200b + ", intervals=" + this.f115201c + ", originalDayFlags=" + this.f115202d + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimeDTO(int i3, ArrayList intervals, int i4) {
            super(ProfileType.TIME, null);
            Intrinsics.checkNotNullParameter(intervals, "intervals");
            this.f115200b = i3;
            this.f115201c = intervals;
            this.f115202d = i4;
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UsageLimitDTO extends ConditionDTO {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f115204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f115205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f115206d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final UsageLimit.PeriodType f115207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final TimeDTO f115208g;

        public /* synthetic */ UsageLimitDTO(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? 0L : j4, (i3 & 8) != 0 ? UsageLimit.PeriodType.DAILY : periodType, (i3 & 16) != 0 ? null : timeDTO);
        }

        public static /* synthetic */ UsageLimitDTO d(UsageLimitDTO usageLimitDTO, long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = usageLimitDTO.f115204b;
            }
            long j5 = j3;
            if ((i3 & 2) != 0) {
                l3 = usageLimitDTO.f115205c;
            }
            Long l4 = l3;
            if ((i3 & 4) != 0) {
                j4 = usageLimitDTO.f115206d;
            }
            long j6 = j4;
            if ((i3 & 8) != 0) {
                periodType = usageLimitDTO.f115207f;
            }
            UsageLimit.PeriodType periodType2 = periodType;
            if ((i3 & 16) != 0) {
                timeDTO = usageLimitDTO.f115208g;
            }
            return usageLimitDTO.c(j5, l4, j6, periodType2, timeDTO);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO
        public TimeDTO b() {
            return this.f115208g;
        }

        public final UsageLimitDTO c(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO) {
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            return new UsageLimitDTO(j3, l3, j4, periodType, timeDTO);
        }

        public final long e() {
            return this.f115204b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UsageLimitDTO)) {
                return false;
            }
            UsageLimitDTO usageLimitDTO = (UsageLimitDTO) obj;
            return this.f115204b == usageLimitDTO.f115204b && Intrinsics.areEqual(this.f115205c, usageLimitDTO.f115205c) && this.f115206d == usageLimitDTO.f115206d && this.f115207f == usageLimitDTO.f115207f && Intrinsics.areEqual(this.f115208g, usageLimitDTO.f115208g);
        }

        public final Long f() {
            return this.f115205c;
        }

        public final UsageLimit.PeriodType g() {
            return this.f115207f;
        }

        public final long h() {
            long j3 = this.f115204b - this.f115206d;
            if (j3 < 0) {
                return 0L;
            }
            return j3;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.f115204b) * 31;
            Long l3 = this.f115205c;
            int iHashCode2 = (((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f115206d)) * 31) + this.f115207f.hashCode()) * 31;
            TimeDTO timeDTO = this.f115208g;
            return iHashCode2 + (timeDTO != null ? timeDTO.hashCode() : 0);
        }

        public final TimeDTO i() {
            return this.f115208g;
        }

        public final long j() {
            return this.f115206d;
        }

        public String toString() {
            return "UsageLimitDTO(allowedTime=" + this.f115204b + ", originalAllowedTime=" + this.f115205c + ", usedTime=" + this.f115206d + ", periodType=" + this.f115207f + ", timeCondition=" + this.f115208g + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsageLimitDTO(long j3, Long l3, long j4, UsageLimit.PeriodType periodType, TimeDTO timeDTO) {
            super(ProfileType.USAGE_LIMIT, null);
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            this.f115204b = j3;
            this.f115205c = l3;
            this.f115206d = j4;
            this.f115207f = periodType;
            this.f115208g = timeDTO;
        }
    }

    private ConditionDTO(ProfileType profileType) {
        this.f115191a = profileType;
    }
}
