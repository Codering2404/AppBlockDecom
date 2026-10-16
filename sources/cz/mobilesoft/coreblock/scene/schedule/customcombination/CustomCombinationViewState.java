package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.util.List;
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
public final class CustomCombinationViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f116337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f116338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f116339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f116340d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LaunchCountConditionConfigurationViewState f116341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final UsageLimitConfigurationViewState f116342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LocationConfigurationViewState f116343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WifiConfigurationViewState f116344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f116345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f116346k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116347a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f116347a = iArr;
        }
    }

    public CustomCombinationViewState(boolean z2, boolean z3, boolean z4, TimeConditionConfigurationViewState timeConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, List selectedConditions) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(launchCountConfigurationViewState, "launchCountConfigurationViewState");
        Intrinsics.checkNotNullParameter(usageLimitConfigurationViewState, "usageLimitConfigurationViewState");
        Intrinsics.checkNotNullParameter(locationConfigurationViewState, "locationConfigurationViewState");
        Intrinsics.checkNotNullParameter(wifiConfigurationViewState, "wifiConfigurationViewState");
        Intrinsics.checkNotNullParameter(selectedConditions, "selectedConditions");
        this.f116337a = z2;
        this.f116338b = z3;
        this.f116339c = z4;
        this.f116340d = timeConfigurationViewState;
        this.f116341f = launchCountConfigurationViewState;
        this.f116342g = usageLimitConfigurationViewState;
        this.f116343h = locationConfigurationViewState;
        this.f116344i = wifiConfigurationViewState;
        this.f116345j = selectedConditions;
        this.f116346k = ProfileHelper.f129250a.y();
    }

    public static /* synthetic */ CustomCombinationViewState b(CustomCombinationViewState customCombinationViewState, boolean z2, boolean z3, boolean z4, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = customCombinationViewState.f116337a;
        }
        if ((i3 & 2) != 0) {
            z3 = customCombinationViewState.f116338b;
        }
        if ((i3 & 4) != 0) {
            z4 = customCombinationViewState.f116339c;
        }
        if ((i3 & 8) != 0) {
            timeConditionConfigurationViewState = customCombinationViewState.f116340d;
        }
        if ((i3 & 16) != 0) {
            launchCountConditionConfigurationViewState = customCombinationViewState.f116341f;
        }
        if ((i3 & 32) != 0) {
            usageLimitConfigurationViewState = customCombinationViewState.f116342g;
        }
        if ((i3 & 64) != 0) {
            locationConfigurationViewState = customCombinationViewState.f116343h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            wifiConfigurationViewState = customCombinationViewState.f116344i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            list = customCombinationViewState.f116345j;
        }
        WifiConfigurationViewState wifiConfigurationViewState2 = wifiConfigurationViewState;
        List list2 = list;
        UsageLimitConfigurationViewState usageLimitConfigurationViewState2 = usageLimitConfigurationViewState;
        LocationConfigurationViewState locationConfigurationViewState2 = locationConfigurationViewState;
        LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState2 = launchCountConditionConfigurationViewState;
        boolean z5 = z4;
        return customCombinationViewState.a(z2, z3, z5, timeConditionConfigurationViewState, launchCountConditionConfigurationViewState2, usageLimitConfigurationViewState2, locationConfigurationViewState2, wifiConfigurationViewState2, list2);
    }

    public final CustomCombinationViewState a(boolean z2, boolean z3, boolean z4, TimeConditionConfigurationViewState timeConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, List selectedConditions) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(launchCountConfigurationViewState, "launchCountConfigurationViewState");
        Intrinsics.checkNotNullParameter(usageLimitConfigurationViewState, "usageLimitConfigurationViewState");
        Intrinsics.checkNotNullParameter(locationConfigurationViewState, "locationConfigurationViewState");
        Intrinsics.checkNotNullParameter(wifiConfigurationViewState, "wifiConfigurationViewState");
        Intrinsics.checkNotNullParameter(selectedConditions, "selectedConditions");
        return new CustomCombinationViewState(z2, z3, z4, timeConfigurationViewState, launchCountConfigurationViewState, usageLimitConfigurationViewState, locationConfigurationViewState, wifiConfigurationViewState, selectedConditions);
    }

    public final List c() {
        return this.f116346k;
    }

    public final LaunchCountConditionConfigurationViewState d() {
        return this.f116341f;
    }

    public final LocationConfigurationViewState e() {
        return this.f116343h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomCombinationViewState)) {
            return false;
        }
        CustomCombinationViewState customCombinationViewState = (CustomCombinationViewState) obj;
        return this.f116337a == customCombinationViewState.f116337a && this.f116338b == customCombinationViewState.f116338b && this.f116339c == customCombinationViewState.f116339c && Intrinsics.areEqual(this.f116340d, customCombinationViewState.f116340d) && Intrinsics.areEqual(this.f116341f, customCombinationViewState.f116341f) && Intrinsics.areEqual(this.f116342g, customCombinationViewState.f116342g) && Intrinsics.areEqual(this.f116343h, customCombinationViewState.f116343h) && Intrinsics.areEqual(this.f116344i, customCombinationViewState.f116344i) && Intrinsics.areEqual(this.f116345j, customCombinationViewState.f116345j);
    }

    public final List f() {
        return this.f116345j;
    }

    public final TimeConditionConfigurationViewState g() {
        return this.f116340d;
    }

    public final UsageLimitConfigurationViewState h() {
        return this.f116342g;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.f116337a) * 31) + Boolean.hashCode(this.f116338b)) * 31) + Boolean.hashCode(this.f116339c)) * 31) + this.f116340d.hashCode()) * 31) + this.f116341f.hashCode()) * 31) + this.f116342g.hashCode()) * 31) + this.f116343h.hashCode()) * 31) + this.f116344i.hashCode()) * 31) + this.f116345j.hashCode();
    }

    public final ConditionConfiguration i(ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        int i3 = WhenMappings.f116347a[profileType.ordinal()];
        if (i3 == 1) {
            return this.f116340d;
        }
        if (i3 == 2) {
            return this.f116341f;
        }
        if (i3 == 3) {
            return this.f116342g;
        }
        if (i3 == 4) {
            return this.f116343h;
        }
        if (i3 != 5) {
            return null;
        }
        return this.f116344i;
    }

    public final WifiConfigurationViewState j() {
        return this.f116344i;
    }

    public final boolean k() {
        return l(ProfileType.LOCATION) || l(ProfileType.WIFI);
    }

    public final boolean l(ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        return this.f116345j.contains(profileType);
    }

    public final boolean m() {
        return this.f116337a;
    }

    public final boolean n(ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        int i3 = WhenMappings.f116347a[profileType.ordinal()];
        return ((i3 == 2 || i3 == 3) && this.f116339c) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean o() {
        /*
            r4 = this;
            java.util.List r0 = r4.f116345j
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L3f
            java.util.List r0 = r4.f116345j
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L1d
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1d
        L1b:
            r0 = r2
            goto L3c
        L1d:
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1b
            java.lang.Object r3 = r0.next()
            cz.mobilesoft.coreblock.enums.ProfileType r3 = (cz.mobilesoft.coreblock.enums.ProfileType) r3
            cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration r3 = r4.i(r3)
            if (r3 == 0) goto L38
            boolean r3 = r3.a()
            goto L39
        L38:
            r3 = r2
        L39:
            if (r3 != 0) goto L21
            r0 = r1
        L3c:
            if (r0 == 0) goto L3f
            return r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewState.o():boolean");
    }

    public final boolean p() {
        return this.f116338b;
    }

    public String toString() {
        return "CustomCombinationViewState(isNewSchedule=" + this.f116337a + ", isStrictModeActive=" + this.f116338b + ", isAllowlist=" + this.f116339c + ", timeConfigurationViewState=" + this.f116340d + ", launchCountConfigurationViewState=" + this.f116341f + ", usageLimitConfigurationViewState=" + this.f116342g + ", locationConfigurationViewState=" + this.f116343h + ", wifiConfigurationViewState=" + this.f116344i + ", selectedConditions=" + this.f116345j + ")";
    }

    public /* synthetic */ CustomCombinationViewState(boolean z2, boolean z3, boolean z4, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) == 0 ? z4 : false, (i3 & 8) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState, (i3 & 16) != 0 ? new LaunchCountConditionConfigurationViewState(0L, null, 0L, false, null, 31, null) : launchCountConditionConfigurationViewState, (i3 & 32) != 0 ? new UsageLimitConfigurationViewState(null, 0L, false, null, null, 31, null) : usageLimitConfigurationViewState, (i3 & 64) != 0 ? new LocationConfigurationViewState(0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null) : locationConfigurationViewState, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new WifiConfigurationViewState(null, false, false, null, null, null, null, false, false, false, 1023, null) : wifiConfigurationViewState, (i3 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list);
    }
}
