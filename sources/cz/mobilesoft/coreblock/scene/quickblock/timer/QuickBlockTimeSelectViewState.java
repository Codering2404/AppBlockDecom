package cz.mobilesoft.coreblock.scene.quickblock.timer;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
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
public final class QuickBlockTimeSelectViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f114311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f114312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f114313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimePickerType f114314d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f114315f;

    public QuickBlockTimeSelectViewState(long j3, Long l3, boolean z2, TimePickerType selectedTimePickerType, List quickBlockTimerHistory) {
        Intrinsics.checkNotNullParameter(selectedTimePickerType, "selectedTimePickerType");
        Intrinsics.checkNotNullParameter(quickBlockTimerHistory, "quickBlockTimerHistory");
        this.f114311a = j3;
        this.f114312b = l3;
        this.f114313c = z2;
        this.f114314d = selectedTimePickerType;
        this.f114315f = quickBlockTimerHistory;
    }

    public static /* synthetic */ QuickBlockTimeSelectViewState b(QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, long j3, Long l3, boolean z2, TimePickerType timePickerType, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = quickBlockTimeSelectViewState.f114311a;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            l3 = quickBlockTimeSelectViewState.f114312b;
        }
        Long l4 = l3;
        if ((i3 & 4) != 0) {
            z2 = quickBlockTimeSelectViewState.f114313c;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            timePickerType = quickBlockTimeSelectViewState.f114314d;
        }
        TimePickerType timePickerType2 = timePickerType;
        if ((i3 & 16) != 0) {
            list = quickBlockTimeSelectViewState.f114315f;
        }
        return quickBlockTimeSelectViewState.a(j4, l4, z3, timePickerType2, list);
    }

    public final QuickBlockTimeSelectViewState a(long j3, Long l3, boolean z2, TimePickerType selectedTimePickerType, List quickBlockTimerHistory) {
        Intrinsics.checkNotNullParameter(selectedTimePickerType, "selectedTimePickerType");
        Intrinsics.checkNotNullParameter(quickBlockTimerHistory, "quickBlockTimerHistory");
        return new QuickBlockTimeSelectViewState(j3, l3, z2, selectedTimePickerType, quickBlockTimerHistory);
    }

    public final List c() {
        return this.f114315f;
    }

    public final TimePickerType d() {
        return this.f114314d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockTimeSelectViewState)) {
            return false;
        }
        QuickBlockTimeSelectViewState quickBlockTimeSelectViewState = (QuickBlockTimeSelectViewState) obj;
        return this.f114311a == quickBlockTimeSelectViewState.f114311a && Intrinsics.areEqual(this.f114312b, quickBlockTimeSelectViewState.f114312b) && this.f114313c == quickBlockTimeSelectViewState.f114313c && this.f114314d == quickBlockTimeSelectViewState.f114314d && Intrinsics.areEqual(this.f114315f, quickBlockTimeSelectViewState.f114315f);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f114311a) * 31;
        Long l3 = this.f114312b;
        return ((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f114313c)) * 31) + this.f114314d.hashCode()) * 31) + this.f114315f.hashCode();
    }

    public String toString() {
        return "QuickBlockTimeSelectViewState(time=" + this.f114311a + ", extendedTime=" + this.f114312b + ", showEndsAtText=" + this.f114313c + ", selectedTimePickerType=" + this.f114314d + ", quickBlockTimerHistory=" + this.f114315f + ")";
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimePickerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TimePickerType[] $VALUES;
        public static final TimePickerType Custom;
        public static final TimePickerType Time1h;
        public static final TimePickerType Time24h;
        public static final TimePickerType Time25m = new TimePickerType("Time25m", 0, Long.valueOf(TimeUnit.MINUTES.toMillis(25)));
        private final Long time;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f114316a;

            static {
                int[] iArr = new int[TimePickerType.values().length];
                try {
                    iArr[TimePickerType.Time25m.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TimePickerType.Time1h.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TimePickerType.Time24h.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TimePickerType.Custom.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f114316a = iArr;
            }
        }

        private static final /* synthetic */ TimePickerType[] $values() {
            return new TimePickerType[]{Time25m, Time1h, Time24h, Custom};
        }

        static {
            TimeUnit timeUnit = TimeUnit.HOURS;
            Time1h = new TimePickerType("Time1h", 1, Long.valueOf(timeUnit.toMillis(1L)));
            Time24h = new TimePickerType("Time24h", 2, Long.valueOf(timeUnit.toMillis(24L)));
            Custom = new TimePickerType("Custom", 3, null, 1, null);
            TimePickerType[] timePickerTypeArr$values = $values();
            $VALUES = timePickerTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(timePickerTypeArr$values);
        }

        private TimePickerType(String str, int i3, Long l3) {
            this.time = l3;
        }

        public static EnumEntries<TimePickerType> getEntries() {
            return $ENTRIES;
        }

        public static TimePickerType valueOf(String str) {
            return (TimePickerType) Enum.valueOf(TimePickerType.class, str);
        }

        public static TimePickerType[] values() {
            return (TimePickerType[]) $VALUES.clone();
        }

        public final String getText(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i3 = WhenMappings.f114316a[ordinal()];
            if (i3 == 1) {
                String string = context.getString(R.string.yk, 25);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (i3 == 2) {
                String string2 = context.getString(R.string.wk, 1);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (i3 == 3) {
                String string3 = context.getString(R.string.wk, 24);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            }
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            String string4 = context.getString(R.string.N8);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }

        public final Long getTime() {
            return this.time;
        }

        /* synthetic */ TimePickerType(String str, int i3, Long l3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i4 & 1) != 0 ? null : l3);
        }
    }

    public /* synthetic */ QuickBlockTimeSelectViewState(long j3, Long l3, boolean z2, TimePickerType timePickerType, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? TimePickerType.Time1h : timePickerType, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[PHI: r5
      0x0050: PHI (r5v4 cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType) = 
      (r5v1 cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType)
      (r5v0 cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType)
     binds: [B:27:0x0065, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QuickBlockTimeSelectViewState(java.util.List r12) {
        /*
            r11 = this;
            java.lang.String r0 = "history"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory) r0
            if (r0 == 0) goto L13
            long r0 = r0.d()
        L11:
            r3 = r0
            goto L23
        L13:
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r0 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Time1h
            java.lang.Long r0 = r0.getTime()
            if (r0 == 0) goto L20
            long r0 = r0.longValue()
            goto L11
        L20:
            r0 = 0
            goto L11
        L23:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory) r0
            if (r0 == 0) goto L34
            long r0 = r0.d()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 != 0) goto L3b
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r0 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Time1h
        L39:
            r7 = r0
            goto L82
        L3b:
            long r1 = r0.longValue()
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r5 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Time25m
            java.lang.Long r6 = r5.getTime()
            if (r6 != 0) goto L48
            goto L52
        L48:
            long r6 = r6.longValue()
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L52
        L50:
            r7 = r5
            goto L82
        L52:
            long r1 = r0.longValue()
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r5 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Time1h
            java.lang.Long r6 = r5.getTime()
            if (r6 != 0) goto L5f
            goto L68
        L5f:
            long r6 = r6.longValue()
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L68
            goto L50
        L68:
            long r0 = r0.longValue()
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r2 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Time24h
            java.lang.Long r5 = r2.getTime()
            if (r5 != 0) goto L75
            goto L7f
        L75:
            long r5 = r5.longValue()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L7f
            r7 = r2
            goto L82
        L7f:
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState$TimePickerType r0 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.TimePickerType.Custom
            goto L39
        L82:
            r9 = 6
            r10 = 0
            r5 = 0
            r6 = 0
            r2 = r11
            r8 = r12
            r2.<init>(r3, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState.<init>(java.util.List):void");
    }
}
