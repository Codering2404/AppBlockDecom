package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import android.content.res.Resources;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public abstract class AccessMethodConfiguration implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f121080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PremiumFeature f121081b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Approval extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f121082c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Approval(String email) {
            super(Integer.valueOf(R.string.Rc), null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121082c = email;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public String a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return this.f121082c;
        }

        public final String b() {
            return this.f121082c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Approval) && Intrinsics.areEqual(this.f121082c, ((Approval) obj).f121082c);
        }

        public int hashCode() {
            return this.f121082c.hashCode();
        }

        public String toString() {
            return "Approval(email=" + this.f121082c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Cooldown extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f121083c;

        /* JADX WARN: Multi-variable type inference failed */
        public Cooldown(long j3) {
            super(Integer.valueOf(R.string.Lq), null, 2, 0 == true ? 1 : 0);
            this.f121083c = j3;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public String a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String strK = DateHelper.k(context, this.f121083c);
            Intrinsics.checkNotNullExpressionValue(strK, "getRemainingTimeOnlyString(...)");
            return strK;
        }

        public final long b() {
            return this.f121083c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cooldown) && this.f121083c == ((Cooldown) obj).f121083c;
        }

        public int hashCode() {
            return Long.hashCode(this.f121083c);
        }

        public String toString() {
            return "Cooldown(millis=" + this.f121083c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class None extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final None f121084c = new None();

        /* JADX WARN: Multi-variable type inference failed */
        private None() {
            super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        private final Object readResolve() {
            return f121084c;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public /* bridge */ /* synthetic */ String a(Context context) {
            return (String) b(context);
        }

        public Void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PinCode extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f121085c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PinCode(String pinCode) {
            super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(pinCode, "pinCode");
            this.f121085c = pinCode;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public String a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        public final String b() {
            return this.f121085c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PinCode) && Intrinsics.areEqual(this.f121085c, ((PinCode) obj).f121085c);
        }

        public int hashCode() {
            return this.f121085c.hashCode();
        }

        public String toString() {
            return "PinCode(pinCode=" + this.f121085c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Schedules extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f121086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SchedulesBlockingMode f121087d;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SchedulesBlockingMode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ SchedulesBlockingMode[] $VALUES;
            public static final Companion Companion;
            private final int descriptionRes;
            private final long id;
            private final int titleRes;
            public static final SchedulesBlockingMode AllBlockings = new SchedulesBlockingMode("AllBlockings", 0, R.string.fy, R.string.gy, 0);
            public static final SchedulesBlockingMode OnlyFollowed = new SchedulesBlockingMode("OnlyFollowed", 1, R.string.iy, R.string.jy, 1);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final SchedulesBlockingMode a(long j3) {
                    SchedulesBlockingMode next;
                    Iterator<SchedulesBlockingMode> it = SchedulesBlockingMode.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (next.getId() == j3) {
                            break;
                        }
                    }
                    SchedulesBlockingMode schedulesBlockingMode = next;
                    return schedulesBlockingMode == null ? SchedulesBlockingMode.AllBlockings : schedulesBlockingMode;
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f121088a;

                static {
                    int[] iArr = new int[SchedulesBlockingMode.values().length];
                    try {
                        iArr[SchedulesBlockingMode.AllBlockings.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SchedulesBlockingMode.OnlyFollowed.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f121088a = iArr;
                }
            }

            private static final /* synthetic */ SchedulesBlockingMode[] $values() {
                return new SchedulesBlockingMode[]{AllBlockings, OnlyFollowed};
            }

            static {
                SchedulesBlockingMode[] schedulesBlockingModeArr$values = $values();
                $VALUES = schedulesBlockingModeArr$values;
                $ENTRIES = EnumEntriesKt.a(schedulesBlockingModeArr$values);
                Companion = new Companion(null);
            }

            private SchedulesBlockingMode(String str, int i3, int i4, int i5, long j3) {
                this.titleRes = i4;
                this.descriptionRes = i5;
                this.id = j3;
            }

            public static EnumEntries<SchedulesBlockingMode> getEntries() {
                return $ENTRIES;
            }

            public static SchedulesBlockingMode valueOf(String str) {
                return (SchedulesBlockingMode) Enum.valueOf(SchedulesBlockingMode.class, str);
            }

            public static SchedulesBlockingMode[] values() {
                return (SchedulesBlockingMode[]) $VALUES.clone();
            }

            public final String getAnalyticsKey() {
                int i3 = WhenMappings.f121088a[ordinal()];
                if (i3 == 1) {
                    return "all";
                }
                if (i3 == 2) {
                    return "followed";
                }
                throw new NoWhenBranchMatchedException();
            }

            public final int getDescriptionRes() {
                return this.descriptionRes;
            }

            public final long getId() {
                return this.id;
            }

            public final int getTitleRes() {
                return this.titleRes;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Schedules(long[] scheduleIds, SchedulesBlockingMode blockingMode) {
            super(Integer.valueOf(R.string.j4), PremiumFeature.STRICT_MODE_PROFILES, null);
            Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f121086c = scheduleIds;
            this.f121087d = blockingMode;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public String a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int i3 = R.plurals.f95760u;
            long[] jArr = this.f121086c;
            String quantityString = resources.getQuantityString(i3, jArr.length, Integer.valueOf(jArr.length));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            return quantityString;
        }

        public final SchedulesBlockingMode b() {
            return this.f121087d;
        }

        public final long[] c() {
            return this.f121086c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Schedules)) {
                return false;
            }
            Schedules schedules = (Schedules) obj;
            return Intrinsics.areEqual(this.f121086c, schedules.f121086c) && this.f121087d == schedules.f121087d;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f121086c) * 31) + this.f121087d.hashCode();
        }

        public String toString() {
            return "Schedules(scheduleIds=" + Arrays.toString(this.f121086c) + ", blockingMode=" + this.f121087d + ")";
        }

        public /* synthetic */ Schedules(long[] jArr, SchedulesBlockingMode schedulesBlockingMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(jArr, (i3 & 2) != 0 ? SchedulesBlockingMode.AllBlockings : schedulesBlockingMode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Timer extends AccessMethodConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f121089c;

        public Timer(long j3) {
            super(Integer.valueOf(R.string.Lq), PremiumFeature.STRICT_MODE_TIMER, null);
            this.f121089c = j3;
        }

        @Override // cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration
        public String a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String strK = DateHelper.k(context, this.f121089c);
            Intrinsics.checkNotNullExpressionValue(strK, "getRemainingTimeOnlyString(...)");
            return strK;
        }

        public final long b() {
            return this.f121089c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Timer) && this.f121089c == ((Timer) obj).f121089c;
        }

        public int hashCode() {
            return Long.hashCode(this.f121089c);
        }

        public String toString() {
            return "Timer(millis=" + this.f121089c + ")";
        }
    }

    public /* synthetic */ AccessMethodConfiguration(Integer num, PremiumFeature premiumFeature, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, premiumFeature);
    }

    public abstract String a(Context context);

    private AccessMethodConfiguration(Integer num, PremiumFeature premiumFeature) {
        this.f121080a = num;
        this.f121081b = premiumFeature;
    }

    public /* synthetic */ AccessMethodConfiguration(Integer num, PremiumFeature premiumFeature, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : premiumFeature, null);
    }
}
