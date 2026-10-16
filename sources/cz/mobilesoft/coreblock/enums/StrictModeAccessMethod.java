package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class StrictModeAccessMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeAccessMethod[] $VALUES;
    public static final StrictModeAccessMethod Approval;
    public static final StrictModeAccessMethod Charger;
    public static final Companion Companion;
    public static final StrictModeAccessMethod Cooldown;
    public static final StrictModeAccessMethod FollowSchedules;
    public static final StrictModeAccessMethod PinCode;
    public static final StrictModeAccessMethod SchedulesAndCharger;
    public static final StrictModeAccessMethod SchedulesAndPin;
    public static final StrictModeAccessMethod Timer;
    public static final StrictModeAccessMethod TimerAndCharger;
    public static final StrictModeAccessMethod TimerAndPin;
    private final String analyticsKey;
    private final int confirmationDescription;
    private final Integer gradientIconRes;
    private final int icon;
    private final boolean isNew;
    private final int mask;
    private final PremiumFeature premiumFeature;
    private final float strictness;
    private final Integer subtitle;
    private final StrictModeStrictnessTag tag;
    private final Integer title;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.listOf((Object[]) new StrictModeAccessMethod[]{StrictModeAccessMethod.Timer, StrictModeAccessMethod.FollowSchedules, StrictModeAccessMethod.Approval, StrictModeAccessMethod.Charger, StrictModeAccessMethod.Cooldown, StrictModeAccessMethod.PinCode});
        }

        public final List b(int i3) {
            List listA = a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (((StrictModeAccessMethod) obj).isSetTo(i3)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final StrictModeAccessMethod c(int i3) {
            StrictModeAccessMethod next;
            Iterator<StrictModeAccessMethod> it = StrictModeAccessMethod.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getMask() == i3) {
                    break;
                }
            }
            return next;
        }

        public final List d() {
            return CollectionsKt.listOf((Object[]) new StrictModeAccessMethod[]{StrictModeAccessMethod.TimerAndPin, StrictModeAccessMethod.TimerAndCharger, StrictModeAccessMethod.SchedulesAndPin, StrictModeAccessMethod.SchedulesAndCharger});
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StrictModeAccessMethod[] $values() {
        return new StrictModeAccessMethod[]{Timer, FollowSchedules, Approval, Charger, PinCode, Cooldown, TimerAndPin, TimerAndCharger, SchedulesAndPin, SchedulesAndCharger};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Integer numValueOf = Integer.valueOf(R.string.rD);
        Integer numValueOf2 = Integer.valueOf(R.string.Mz);
        StrictModeStrictnessTag strictModeStrictnessTag = StrictModeStrictnessTag.Hard;
        int i3 = 1;
        Timer = new StrictModeAccessMethod("Timer", 0, numValueOf, numValueOf2, strictModeStrictnessTag, R.drawable.f95542n0, i3, 0.8f, R.string.Lz, PremiumFeature.STRICT_MODE_TIMER, "timer", Integer.valueOf(R.drawable.f95546o0), false, 1024, null);
        int i4 = 1024;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        FollowSchedules = new StrictModeAccessMethod("FollowSchedules", i3, Integer.valueOf(R.string.MB), Integer.valueOf(R.string.hy), strictModeStrictnessTag, R.drawable.f95526j0, 2, 0.6f, R.string.Dz, PremiumFeature.STRICT_MODE_PROFILES, "schedule", Integer.valueOf(R.drawable.f95530k0), z2, i4, defaultConstructorMarker);
        Approval = new StrictModeAccessMethod("Approval", 2, Integer.valueOf(R.string.H1), Integer.valueOf(R.string.Kx), strictModeStrictnessTag, R.drawable.f95494b0, 32, 0.8f, R.string.Jx, PremiumFeature.STRICT_MODE_APPROVAL, "approval", Integer.valueOf(R.drawable.f95498c0), z2, i4, defaultConstructorMarker);
        Integer numValueOf3 = Integer.valueOf(R.string.r7);
        Integer numValueOf4 = Integer.valueOf(R.string.Tx);
        StrictModeStrictnessTag strictModeStrictnessTag2 = StrictModeStrictnessTag.Medium;
        Charger = new StrictModeAccessMethod("Charger", 3, numValueOf3, numValueOf4, strictModeStrictnessTag2, R.drawable.f95502d0, 4, 0.4f, R.string.Sx, null, "charger", Integer.valueOf(R.drawable.f95506e0), false, 1152, null);
        Integer numValueOf5 = Integer.valueOf(R.string.Bw);
        Integer numValueOf6 = Integer.valueOf(R.string.xz);
        StrictModeStrictnessTag strictModeStrictnessTag3 = StrictModeStrictnessTag.Easy;
        PinCode = new StrictModeAccessMethod("PinCode", 4, numValueOf5, numValueOf6, strictModeStrictnessTag3, R.drawable.f95534l0, 8, 0.2f, R.string.wz, null, "pin", Integer.valueOf(R.drawable.f95538m0), false, 1152, null);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        float f3 = 0.4f;
        PremiumFeature premiumFeature = null;
        boolean z3 = false;
        Cooldown = new StrictModeAccessMethod("Cooldown", 5, Integer.valueOf(R.string.s8), Integer.valueOf(R.string.Yx), strictModeStrictnessTag2, R.drawable.f95518h0, 16, f3, R.string.Xx, premiumFeature, "cooldown", Integer.valueOf(R.drawable.f95522i0), z3, 1152, defaultConstructorMarker2);
        int i5 = R.drawable.f95510f0;
        Integer num = null;
        Integer num2 = null;
        float f4 = 0.2f;
        PremiumFeature premiumFeature2 = null;
        TimerAndPin = new StrictModeAccessMethod("TimerAndPin", 6, num, num2, strictModeStrictnessTag3, i5, 9, f4, R.string.Nz, premiumFeature2, "timer_and_pin", null, false, 1664, null);
        int i6 = R.drawable.f95514g0;
        int i7 = 1664;
        Integer num3 = null;
        Object[] objArr = 0 == true ? 1 : 0;
        TimerAndCharger = new StrictModeAccessMethod("TimerAndCharger", 7, null, objArr, strictModeStrictnessTag2, i6, 5, f3, R.string.Kz, premiumFeature, "timer_and_charger", num3, z3, i7, defaultConstructorMarker2);
        SchedulesAndPin = new StrictModeAccessMethod("SchedulesAndPin", 8, num, num2, strictModeStrictnessTag3, i5, 10, f4, R.string.Ez, premiumFeature2, "schedule_and_pin", null, false, 1664, 0 == true ? 1 : 0);
        Object[] objArr2 = 0 == true ? 1 : 0;
        SchedulesAndCharger = new StrictModeAccessMethod("SchedulesAndCharger", 9, null, objArr2, strictModeStrictnessTag2, i6, 6, f3, R.string.Cz, premiumFeature, "schedules_and_charger", num3, z3, i7, defaultConstructorMarker2);
        StrictModeAccessMethod[] strictModeAccessMethodArr$values = $values();
        $VALUES = strictModeAccessMethodArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeAccessMethodArr$values);
        Companion = new Companion(null);
    }

    private StrictModeAccessMethod(String str, int i3, Integer num, Integer num2, StrictModeStrictnessTag strictModeStrictnessTag, int i4, int i5, float f3, int i6, PremiumFeature premiumFeature, String str2, Integer num3, boolean z2) {
        this.title = num;
        this.subtitle = num2;
        this.tag = strictModeStrictnessTag;
        this.icon = i4;
        this.mask = i5;
        this.strictness = f3;
        this.confirmationDescription = i6;
        this.premiumFeature = premiumFeature;
        this.analyticsKey = str2;
        this.gradientIconRes = num3;
        this.isNew = z2;
    }

    public static EnumEntries<StrictModeAccessMethod> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeAccessMethod valueOf(String str) {
        return (StrictModeAccessMethod) Enum.valueOf(StrictModeAccessMethod.class, str);
    }

    public static StrictModeAccessMethod[] values() {
        return (StrictModeAccessMethod[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final int getConfirmationDescription() {
        return this.confirmationDescription;
    }

    public final int getGradientIcon() {
        Integer num = this.gradientIconRes;
        return num != null ? num.intValue() : this.icon;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getMask() {
        return this.mask;
    }

    public final PremiumFeature getPremiumFeature() {
        return this.premiumFeature;
    }

    public final float getStrictness() {
        return this.strictness;
    }

    public final Integer getSubtitle() {
        return this.subtitle;
    }

    public final StrictModeStrictnessTag getTag() {
        return this.tag;
    }

    public final Integer getTitle() {
        return this.title;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isSetTo(int i3) {
        return (i3 & this.mask) != 0;
    }

    public final String getTitle(Context context) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num2 = this.title;
        if (num2 != null) {
            String string = context.getString(num2.intValue());
            Intrinsics.checkNotNull(string);
            return string;
        }
        ArrayList arrayList = new ArrayList();
        for (StrictModeAccessMethod strictModeAccessMethod : Companion.a()) {
            if (strictModeAccessMethod.isSetTo(this.mask) && (num = strictModeAccessMethod.title) != null) {
                String string2 = context.getString(num.intValue());
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                arrayList.add(string2);
            }
        }
        return StringHelperExtKt.p((String) arrayList.get(0), (String) arrayList.get(1), " & ");
    }

    /* synthetic */ StrictModeAccessMethod(String str, int i3, Integer num, Integer num2, StrictModeStrictnessTag strictModeStrictnessTag, int i4, int i5, float f3, int i6, PremiumFeature premiumFeature, String str2, Integer num3, boolean z2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, num, num2, strictModeStrictnessTag, i4, i5, f3, i6, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : premiumFeature, str2, (i7 & 512) != 0 ? null : num3, (i7 & 1024) != 0 ? false : z2);
    }
}
