package cz.mobilesoft.coreblock.dto;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConflictingSchedule {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f96916j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f96917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f96919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f96920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f96921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f96922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f96923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OverlapReason f96924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f96925i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OverlapReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OverlapReason[] $VALUES;
        public static final OverlapReason QuickBlockActive = new OverlapReason("QuickBlockActive", 0);
        public static final OverlapReason UsageLimitOverride = new OverlapReason("UsageLimitOverride", 1);
        public static final OverlapReason TimeScheduleOverride = new OverlapReason("TimeScheduleOverride", 2);
        public static final OverlapReason LaunchCountOverride = new OverlapReason("LaunchCountOverride", 3);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f96926a;

            static {
                int[] iArr = new int[OverlapReason.values().length];
                try {
                    iArr[OverlapReason.QuickBlockActive.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[OverlapReason.UsageLimitOverride.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[OverlapReason.TimeScheduleOverride.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[OverlapReason.LaunchCountOverride.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f96926a = iArr;
            }
        }

        private static final /* synthetic */ OverlapReason[] $values() {
            return new OverlapReason[]{QuickBlockActive, UsageLimitOverride, TimeScheduleOverride, LaunchCountOverride};
        }

        static {
            OverlapReason[] overlapReasonArr$values = $values();
            $VALUES = overlapReasonArr$values;
            $ENTRIES = EnumEntriesKt.a(overlapReasonArr$values);
        }

        private OverlapReason(String str, int i3) {
        }

        public static EnumEntries<OverlapReason> getEntries() {
            return $ENTRIES;
        }

        public static OverlapReason valueOf(String str) {
            return (OverlapReason) Enum.valueOf(OverlapReason.class, str);
        }

        public static OverlapReason[] values() {
            return (OverlapReason[]) $VALUES.clone();
        }

        public final String reason(Context context) {
            int i3;
            Intrinsics.checkNotNullParameter(context, "context");
            int i4 = WhenMappings.f96926a[ordinal()];
            if (i4 == 1) {
                i3 = R.string.gn;
            } else if (i4 == 2) {
                i3 = R.string.mn;
            } else if (i4 == 3) {
                i3 = R.string.an;
            } else {
                if (i4 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                i3 = R.string.en;
            }
            String string = context.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
    }

    public ConflictingSchedule(long j3, String title, int i3, Set applications, Set websites, int i4, List overlapIntervals, OverlapReason overlapReason) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(overlapIntervals, "overlapIntervals");
        Intrinsics.checkNotNullParameter(overlapReason, "overlapReason");
        this.f96917a = j3;
        this.f96918b = title;
        this.f96919c = i3;
        this.f96920d = applications;
        this.f96921e = websites;
        this.f96922f = i4;
        this.f96923g = overlapIntervals;
        this.f96924h = overlapReason;
        this.f96925i = i3 == 64;
    }

    public final Set a() {
        return this.f96920d;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[EDGE_INSN: B:77:0x005f->B:20:0x005f BREAK  A[LOOP:2: B:12:0x003b->B:78:?]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e A[EDGE_INSN: B:74:0x009e->B:35:0x009e BREAK  A[LOOP:1: B:27:0x007a->B:75:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r17) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.dto.ConflictingSchedule.b(android.content.Context):java.lang.String");
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f96925i) {
            String string = context.getString(R.string.Ym);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.Zm, this.f96918b);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConflictingSchedule)) {
            return false;
        }
        ConflictingSchedule conflictingSchedule = (ConflictingSchedule) obj;
        return this.f96917a == conflictingSchedule.f96917a && Intrinsics.areEqual(this.f96918b, conflictingSchedule.f96918b) && this.f96919c == conflictingSchedule.f96919c && Intrinsics.areEqual(this.f96920d, conflictingSchedule.f96920d) && Intrinsics.areEqual(this.f96921e, conflictingSchedule.f96921e) && this.f96922f == conflictingSchedule.f96922f && Intrinsics.areEqual(this.f96923g, conflictingSchedule.f96923g) && this.f96924h == conflictingSchedule.f96924h;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f96917a) * 31) + this.f96918b.hashCode()) * 31) + Integer.hashCode(this.f96919c)) * 31) + this.f96920d.hashCode()) * 31) + this.f96921e.hashCode()) * 31) + Integer.hashCode(this.f96922f)) * 31) + this.f96923g.hashCode()) * 31) + this.f96924h.hashCode();
    }

    public String toString() {
        return "ConflictingSchedule(profileId=" + this.f96917a + ", title=" + this.f96918b + ", typeCombinations=" + this.f96919c + ", applications=" + this.f96920d + ", websites=" + this.f96921e + ", activeDaysMask=" + this.f96922f + ", overlapIntervals=" + this.f96923g + ", overlapReason=" + this.f96924h + ")";
    }
}
