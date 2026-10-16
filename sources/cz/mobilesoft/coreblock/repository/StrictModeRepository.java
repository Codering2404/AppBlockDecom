package cz.mobilesoft.coreblock.repository;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.facebook.internal.NativeProtocol;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class StrictModeRepository implements KoinComponent {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f98230m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f98231n = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictModeDataStore f98232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProfileDao f98233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f98234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StateFlow f98235d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StateFlow f98236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateFlow f98237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StateFlow f98238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f98239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f98240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f98241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f98242l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AccessMethodConfigValues {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f98243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f98244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f98245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f98246d;

        public AccessMethodConfigValues(long j3, long[] profileIds, long j4, String approvalEmail) {
            Intrinsics.checkNotNullParameter(profileIds, "profileIds");
            Intrinsics.checkNotNullParameter(approvalEmail, "approvalEmail");
            this.f98243a = j3;
            this.f98244b = profileIds;
            this.f98245c = j4;
            this.f98246d = approvalEmail;
        }

        public final String a() {
            return this.f98246d;
        }

        public final long b() {
            return this.f98245c;
        }

        public final long[] c() {
            return this.f98244b;
        }

        public final long d() {
            return this.f98243a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AccessMethodConfigValues)) {
                return false;
            }
            AccessMethodConfigValues accessMethodConfigValues = (AccessMethodConfigValues) obj;
            return this.f98243a == accessMethodConfigValues.f98243a && Intrinsics.areEqual(this.f98244b, accessMethodConfigValues.f98244b) && this.f98245c == accessMethodConfigValues.f98245c && Intrinsics.areEqual(this.f98246d, accessMethodConfigValues.f98246d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f98243a) * 31) + Arrays.hashCode(this.f98244b)) * 31) + Long.hashCode(this.f98245c)) * 31) + this.f98246d.hashCode();
        }

        public String toString() {
            return "AccessMethodConfigValues(timeInMillis=" + this.f98243a + ", profileIds=" + Arrays.toString(this.f98244b) + ", cooldownInMillis=" + this.f98245c + ", approvalEmail=" + this.f98246d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class AccessMethodSetupResult {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MissingConfiguration extends AccessMethodSetupResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MissingConfigType f98247a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MissingConfiguration(MissingConfigType type) {
                super(null);
                Intrinsics.checkNotNullParameter(type, "type");
                this.f98247a = type;
            }

            public final MissingConfigType a() {
                return this.f98247a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MissingConfiguration) && this.f98247a == ((MissingConfiguration) obj).f98247a;
            }

            public int hashCode() {
                return this.f98247a.hashCode();
            }

            public String toString() {
                return "MissingConfiguration(type=" + this.f98247a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Ready extends AccessMethodSetupResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Ready f98248a = new Ready();

            private Ready() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Ready);
            }

            public int hashCode() {
                return -1138296469;
            }

            public String toString() {
                return "Ready";
            }
        }

        public /* synthetic */ AccessMethodSetupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AccessMethodSetupResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(List accessMethodsSplit, boolean z2) {
            Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
            return (accessMethodsSplit.contains(StrictModeAccessMethod.FollowSchedules) || accessMethodsSplit.contains(StrictModeAccessMethod.Approval)) && !z2;
        }

        public final Set b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.settings.SETTINGS"), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                String str2 = (str == null || str.length() == 0) ? null : resolveInfo.activityInfo.packageName;
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            Set setMutableSetOf = arrayList.isEmpty() ? SetsKt.mutableSetOf("com.android.settings") : CollectionsKt.toMutableSet(arrayList);
            setMutableSetOf.add("com.miui.securitycenter");
            Set ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE = Constants.f128453k;
            Intrinsics.checkNotNullExpressionValue(ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE, "ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE");
            setMutableSetOf.addAll(ADDITIONAL_SETTINGS_APPS_FOR_STRICT_MODE);
            return setMutableSetOf;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ExtraConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f98249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f98250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f98251c;

        public ExtraConfig(long j3, long j4, boolean z2) {
            this.f98249a = j3;
            this.f98250b = j4;
            this.f98251c = z2;
        }

        public final long a() {
            return this.f98249a;
        }

        public final long b() {
            return this.f98250b;
        }

        public final boolean c() {
            return this.f98251c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtraConfig)) {
                return false;
            }
            ExtraConfig extraConfig = (ExtraConfig) obj;
            return this.f98249a == extraConfig.f98249a && this.f98250b == extraConfig.f98250b && this.f98251c == extraConfig.f98251c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f98249a) * 31) + Long.hashCode(this.f98250b)) * 31) + Boolean.hashCode(this.f98251c);
        }

        public String toString() {
            return "ExtraConfig(deactivationTimeMinutes=" + this.f98249a + ", lastPinUpdate=" + this.f98250b + ", isPremiumActive=" + this.f98251c + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingConfigType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MissingConfigType[] $VALUES;
        public static final MissingConfigType Timer = new MissingConfigType("Timer", 0);
        public static final MissingConfigType Cooldown = new MissingConfigType("Cooldown", 1);
        public static final MissingConfigType Schedules = new MissingConfigType("Schedules", 2);
        public static final MissingConfigType Approval = new MissingConfigType("Approval", 3);
        public static final MissingConfigType PinCode = new MissingConfigType("PinCode", 4);

        private static final /* synthetic */ MissingConfigType[] $values() {
            return new MissingConfigType[]{Timer, Cooldown, Schedules, Approval, PinCode};
        }

        static {
            MissingConfigType[] missingConfigTypeArr$values = $values();
            $VALUES = missingConfigTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(missingConfigTypeArr$values);
        }

        private MissingConfigType(String str, int i3) {
        }

        public static EnumEntries<MissingConfigType> getEntries() {
            return $ENTRIES;
        }

        public static MissingConfigType valueOf(String str) {
            return (MissingConfigType) Enum.valueOf(MissingConfigType.class, str);
        }

        public static MissingConfigType[] values() {
            return (MissingConfigType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f98252a;

        static {
            int[] iArr = new int[StrictModeAccessMethod.values().length];
            try {
                iArr[StrictModeAccessMethod.Timer.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeAccessMethod.TimerAndCharger.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeAccessMethod.TimerAndPin.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StrictModeAccessMethod.FollowSchedules.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StrictModeAccessMethod.SchedulesAndCharger.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StrictModeAccessMethod.SchedulesAndPin.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[StrictModeAccessMethod.Cooldown.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[StrictModeAccessMethod.Approval.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f98252a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StrictModeRepository(StrictModeDataStore strictModeDataStore, ProfileDao profileDao, CoroutineScope applicationScope) {
        Intrinsics.checkNotNullParameter(strictModeDataStore, "strictModeDataStore");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(applicationScope, "applicationScope");
        this.f98232a = strictModeDataStore;
        this.f98233b = profileDao;
        this.f98234c = applicationScope;
        Flow flowF1 = profileDao.f1();
        SharingStarted.Companion companion = SharingStarted.f142210a;
        final Qualifier qualifier = null;
        this.f98235d = FlowKt.h0(flowF1, applicationScope, companion.c(), null);
        StateFlow stateFlowH0 = FlowKt.h0(profileDao.V0(), applicationScope, companion.c(), CollectionsKt.emptyList());
        this.f98236f = stateFlowH0;
        Flow flowU = FlowKt.u(FlowKt.m(stateFlowH0, FlowKt.I(new StrictModeRepository$isStrictModeCurrentlyOnFlow$1(null)), new StrictModeRepository$isStrictModeCurrentlyOnFlow$2(null)));
        SharingStarted sharingStartedC = companion.c();
        Boolean bool = Boolean.FALSE;
        StateFlow stateFlowH02 = FlowKt.h0(flowU, applicationScope, sharingStartedC, bool);
        this.f98237g = stateFlowH02;
        this.f98238h = FlowKt.h0(FlowKt.m(stateFlowH02, strictModeDataStore.m0(), new StrictModeRepository$isStrictModeUninstallCurrentlyOnFlow$1(null)), applicationScope, companion.c(), bool);
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f98239i = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.StrictModeRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f98240j = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.repository.StrictModeRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f98241k = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.repository.StrictModeRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f98242l = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.repository.StrictModeRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr6, objArr7);
            }
        });
    }

    private final Object a(Continuation continuation) {
        Object objO0 = this.f98232a.O0(0L, continuation);
        return objO0 == IntrinsicsKt.f() ? objO0 : Unit.f139807a;
    }

    public static /* synthetic */ StrictModeState d(StrictModeRepository strictModeRepository, List list, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return strictModeRepository.c(list, z2, z3);
    }

    public static /* synthetic */ Object g(StrictModeRepository strictModeRepository, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return strictModeRepository.f(z2, continuation);
    }

    private final ApplicationDao h() {
        return (ApplicationDao) this.f98240j.getValue();
    }

    private final ApplicationProfileRelationDao i() {
        return (ApplicationProfileRelationDao) this.f98239i.getValue();
    }

    private final DevDataStore j() {
        return (DevDataStore) this.f98242l.getValue();
    }

    private final EventDataStore k() {
        return (EventDataStore) this.f98241k.getValue();
    }

    public final Flow b(Flow isPremiumActive, Flow intervalTriggerFlow) {
        Intrinsics.checkNotNullParameter(isPremiumActive, "isPremiumActive");
        Intrinsics.checkNotNullParameter(intervalTriggerFlow, "intervalTriggerFlow");
        Flow flowO = FlowKt.o(this.f98232a.z0(), this.f98232a.s0(), this.f98232a.l0(), this.f98232a.h0(), new StrictModeRepository$combineStrictModeStateFlows$accessMethodConfigValuesFlow$1(null));
        return FlowKt.o(FlowKt.m(FlowKt.u(this.f98233b.V0()), intervalTriggerFlow, new StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1(null)), FlowKt.n(this.f98232a.f0(), this.f98232a.g0(), this.f98232a.m0(), new StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1(null)), flowO, FlowKt.n(this.f98232a.w0(), this.f98232a.x0(), isPremiumActive, new StrictModeRepository$combineStrictModeStateFlows$extraConfigFlow$1(null)), new StrictModeRepository$combineStrictModeStateFlows$1(this, null));
    }

    public final StrictModeState c(List profiles, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        Object next;
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        List<ProfileWithIntervals> list = profiles;
        boolean z6 = list instanceof Collection;
        if (z6 && list.isEmpty()) {
            z4 = false;
        } else {
            for (ProfileWithIntervals profileWithIntervals : list) {
                if (ProfileHelper.C(ProfileHelper.f129250a, profileWithIntervals.b(), profileWithIntervals.a(), null, 2, null)) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        if (!z2 || z4 || (z6 && list.isEmpty())) {
            z5 = false;
        } else {
            for (ProfileWithIntervals profileWithIntervals2 : list) {
                if (profileWithIntervals2.b().S() && !Intrinsics.areEqual(profileWithIntervals2.b().A(), "STRICT_MODE_TAG_V2")) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ProfileWithIntervals) next).b().A(), "STRICT_MODE_TAG_V2")) {
                break;
            }
        }
        ProfileWithIntervals profileWithIntervals3 = (ProfileWithIntervals) next;
        Profile profileB = profileWithIntervals3 != null ? profileWithIntervals3.b() : null;
        return z3 ? StrictModeState.Inactive : profileB != null ? (profileB.y() instanceof Profile.PausedUntil.Time) && profileB.y().a() > TimeHelperExt.f128663a.f() : false ? StrictModeState.Paused : z4 ? StrictModeState.Active : z5 ? StrictModeState.Standby : StrictModeState.Inactive;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0280, code lost:
    
        if (r1.w(r8, r5, r6) != r2) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(android.content.Context r44, kotlin.coroutines.Continuation r45) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.e(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0122, code lost:
    
        if (r1 == r3) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x024f, code lost:
    
        if (r1.W1(r8, r2) != r3) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[PHI: r1 r4
      0x00dd: PHI (r1v6 java.util.List) = (r1v5 java.util.List), (r1v8 java.util.List) binds: [B:29:0x00d9, B:23:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r4v4 boolean) = (r4v2 boolean), (r4v5 boolean) binds: [B:29:0x00d9, B:23:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019f A[PHI: r1 r4 r6 r9 r11 r13
      0x019f: PHI (r1v26 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r1v25 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r1v30 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r4v16 long) = (r4v14 long), (r4v18 long) binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r6v9 boolean) = (r6v7 boolean), (r6v10 boolean) binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r9v12 long) = (r9v10 long), (r9v13 long) binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r11v6 long) = (r11v4 long), (r11v7 long) binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r13v5 java.util.List) = (r13v2 java.util.List), (r13v6 java.util.List) binds: [B:50:0x0166, B:55:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021d A[PHI: r4 r8
      0x021d: PHI (r4v23 boolean) = (r4v21 boolean), (r4v24 boolean) binds: [B:72:0x021a, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x021d: PHI (r8v13 java.util.List) = (r8v10 java.util.List), (r8v15 java.util.List) binds: [B:72:0x021a, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(boolean r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.f(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Profile l() {
        return (Profile) this.f98235d.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r14 == r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
    
        if (r14 == r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0109, code lost:
    
        if (r14 == r1) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1 A[PHI: r12 r13
      0x00f1: PHI (r12v9 boolean) = (r12v6 boolean), (r12v10 boolean) binds: [B:41:0x00cc, B:46:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r13v9 java.util.List) = (r13v6 java.util.List), (r13v10 java.util.List) binds: [B:41:0x00cc, B:46:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0124 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.util.List r12, boolean r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.m(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean n() {
        Iterable<ProfileWithIntervals> iterable = (Iterable) this.f98236f.getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (ProfileWithIntervals profileWithIntervals : iterable) {
            if (ProfileHelper.C(ProfileHelper.f129250a, profileWithIntervals.b(), profileWithIntervals.a(), null, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        if (r12 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnAndNeedsLockService$1
            if (r0 == 0) goto L13
            r0 = r12
            cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnAndNeedsLockService$1 r0 = (cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnAndNeedsLockService$1) r0
            int r1 = r0.f98302c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98302c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnAndNeedsLockService$1 r0 = new cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnAndNeedsLockService$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.f98300a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98302c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r12)
            goto L7b
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            kotlin.ResultKt.b(r12)
            goto L4a
        L38:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r12 = r11.f98232a
            kotlinx.coroutines.flow.Flow r12 = r12.m0()
            r0.f98302c = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r0)
            if (r12 != r1) goto L4a
            goto L7a
        L4a:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r2 = r12 instanceof java.util.Collection
            if (r2 == 0) goto L5a
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5a
            goto Laf
        L5a:
            java.util.Iterator r12 = r12.iterator()
        L5e:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto Laf
            java.lang.Object r2 = r12.next()
            cz.mobilesoft.coreblock.enums.StrictModeOption r2 = (cz.mobilesoft.coreblock.enums.StrictModeOption) r2
            boolean r2 = r2.getRequiresLockService()
            if (r2 == 0) goto L5e
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r12 = r11.f98233b
            r0.f98302c = r3
            java.lang.Object r12 = r12.d1(r0)
            if (r12 != r1) goto L7b
        L7a:
            return r1
        L7b:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r0 = r12 instanceof java.util.Collection
            if (r0 == 0) goto L8b
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L8b
            goto Laf
        L8b:
            java.util.Iterator r12 = r12.iterator()
        L8f:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto Laf
            java.lang.Object r0 = r12.next()
            cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals r0 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals) r0
            cz.mobilesoft.coreblock.util.profile.ProfileHelper r5 = cz.mobilesoft.coreblock.util.profile.ProfileHelper.f129250a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r6 = r0.b()
            java.util.List r7 = r0.a()
            r9 = 2
            r10 = 0
            r8 = 0
            boolean r0 = cz.mobilesoft.coreblock.util.profile.ProfileHelper.C(r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L8f
            goto Lb0
        Laf:
            r4 = 0
        Lb0:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow p() {
        return this.f98237g;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(java.lang.Long r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.q(java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean r() {
        return ((Boolean) this.f98238h.getValue()).booleanValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092 A[PHI: r1 r2 r3 r4 r5 r9 r10 r11
      0x0092: PHI (r1v8 java.lang.Object) = (r1v1 java.lang.Object), (r1v12 java.lang.Object) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r2v6 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1) = 
      (r2v2 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1)
      (r2v7 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1)
     binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r3v26 java.util.List) = (r3v15 java.util.List), (r3v28 java.util.List) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r4v18 cz.mobilesoft.coreblock.enums.StrictModeState) = (r4v11 cz.mobilesoft.coreblock.enums.StrictModeState), (r4v25 cz.mobilesoft.coreblock.enums.StrictModeState) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r5v17 java.util.List) = (r5v9 java.util.List), (r5v19 java.util.List) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r9v17 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration) = 
      (r9v7 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration)
      (r9v19 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration)
     binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r10v16 java.util.Iterator) = (r10v8 java.util.Iterator), (r10v18 java.util.Iterator) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r11v11 java.util.List) = (r11v6 java.util.List), (r11v12 java.util.List) binds: [B:15:0x0077, B:60:0x028a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f7 A[LOOP:1: B:49:0x01f1->B:51:0x01f7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0265 A[PHI: r2 r3 r4 r5 r9 r10 r11
      0x0265: PHI (r2v7 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1) = 
      (r2v2 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1)
      (r2v8 cz.mobilesoft.coreblock.repository.StrictModeRepository$onAccessMethodConfigured$1)
     binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r3v28 java.util.List) = (r3v13 java.util.List), (r3v29 java.util.List) binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r4v25 cz.mobilesoft.coreblock.enums.StrictModeState) = (r4v9 cz.mobilesoft.coreblock.enums.StrictModeState), (r4v26 cz.mobilesoft.coreblock.enums.StrictModeState) binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r5v19 java.util.List) = (r5v7 java.util.List), (r5v20 java.util.List) binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r9v19 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration) = 
      (r9v5 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration)
      (r9v20 cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration)
     binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r10v18 java.util.Iterator) = (r10v6 java.util.Iterator), (r10v19 java.util.Iterator) binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r11v12 java.util.List) = (r11v4 java.util.List), (r11v13 java.util.List) binds: [B:17:0x0099, B:57:0x0261] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x035c -> B:24:0x011c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.util.List r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.s(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        if (r8.e1(r4, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(java.lang.String r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.repository.StrictModeRepository$onPinCodeConfigured$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.repository.StrictModeRepository$onPinCodeConfigured$1 r0 = (cz.mobilesoft.coreblock.repository.StrictModeRepository$onPinCodeConfigured$1) r0
            int r1 = r0.f98334d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98334d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StrictModeRepository$onPinCodeConfigured$1 r0 = new cz.mobilesoft.coreblock.repository.StrictModeRepository$onPinCodeConfigured$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f98332b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98334d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.f98331a
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r8)
            goto L72
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.f98331a
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r8)
            goto L5b
        L40:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration$PinCode r8 = new cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration$PinCode
            r8.<init>(r7)
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r8)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98331a = r2
            r0.f98334d = r4
            java.lang.Object r8 = r6.s(r8, r0)
            if (r8 != r1) goto L5b
            goto L71
        L5b:
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r8 = r6.f98232a
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r2 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r2.f()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98331a = r7
            r0.f98334d = r3
            java.lang.Object r7 = r8.e1(r4, r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        if (r4.Z0(r7, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.util.Collection r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.repository.StrictModeRepository$removeFromProfileIds$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.repository.StrictModeRepository$removeFromProfileIds$1 r0 = (cz.mobilesoft.coreblock.repository.StrictModeRepository$removeFromProfileIds$1) r0
            int r1 = r0.f98340g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98340g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StrictModeRepository$removeFromProfileIds$1 r0 = new cz.mobilesoft.coreblock.repository.StrictModeRepository$removeFromProfileIds$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f98338d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98340g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f98336b
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r6 = r0.f98335a
            java.util.Collection r6 = (java.util.Collection) r6
            kotlin.ResultKt.b(r7)
            goto L82
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.f98335a
            java.util.Collection r6 = (java.util.Collection) r6
            kotlin.ResultKt.b(r7)
            goto L58
        L44:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = r5.f98232a
            kotlinx.coroutines.flow.Flow r7 = r7.s0()
            r0.f98335a = r6
            r0.f98340g = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L58
            goto L81
        L58:
            java.util.Set r7 = (java.util.Set) r7
            r2 = r6
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r7.removeAll(r2)
            if (r2 == 0) goto L85
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r4 = r5.f98232a
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f98335a = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98336b = r6
            r0.f98337c = r2
            r0.f98340g = r3
            java.lang.Object r6 = r4.Z0(r7, r0)
            if (r6 != r1) goto L82
        L81:
            return r1
        L82:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L85:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.u(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AccessMethodConfiguration v(StrictModeAccessMethod strictModeAccessMethod, AccessMethodConfigValues configValues) {
        Intrinsics.checkNotNullParameter(configValues, "configValues");
        switch (strictModeAccessMethod == null ? -1 : WhenMappings.f98252a[strictModeAccessMethod.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new AccessMethodConfiguration.Timer(configValues.d());
            case 4:
            case 5:
            case 6:
                return new AccessMethodConfiguration.Schedules(configValues.c(), null, 2, null);
            case 7:
                return new AccessMethodConfiguration.Cooldown(configValues.b());
            case 8:
                return new AccessMethodConfiguration.Approval(configValues.a());
            default:
                return AccessMethodConfiguration.None.f121084c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x012e, code lost:
    
        if (r10.t(r9, r1) == r3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(android.content.Context r26, java.util.Collection r27, java.util.Collection r28, kotlin.coroutines.Continuation r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.w(android.content.Context, java.util.Collection, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object x(StrictModeAccessMethod strictModeAccessMethod, List list, Continuation continuation) {
        Iterator it = list.iterator();
        Long lE = null;
        String strB = null;
        Set<Long> set = null;
        AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingModeB = null;
        Long lE2 = null;
        String strB2 = null;
        while (it.hasNext()) {
            AccessMethodConfiguration accessMethodConfiguration = (AccessMethodConfiguration) it.next();
            if (accessMethodConfiguration instanceof AccessMethodConfiguration.Timer) {
                lE = Boxing.e(((AccessMethodConfiguration.Timer) accessMethodConfiguration).b());
            } else if (accessMethodConfiguration instanceof AccessMethodConfiguration.PinCode) {
                strB = ((AccessMethodConfiguration.PinCode) accessMethodConfiguration).b();
            } else if (accessMethodConfiguration instanceof AccessMethodConfiguration.Schedules) {
                AccessMethodConfiguration.Schedules schedules = (AccessMethodConfiguration.Schedules) accessMethodConfiguration;
                set = ArraysKt.toSet(schedules.c());
                schedulesBlockingModeB = schedules.b();
            } else if (accessMethodConfiguration instanceof AccessMethodConfiguration.Cooldown) {
                lE2 = Boxing.e(((AccessMethodConfiguration.Cooldown) accessMethodConfiguration).b());
            } else if (accessMethodConfiguration instanceof AccessMethodConfiguration.Approval) {
                strB2 = ((AccessMethodConfiguration.Approval) accessMethodConfiguration).b();
            } else if (!Intrinsics.areEqual(accessMethodConfiguration, AccessMethodConfiguration.None.f121084c)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        Object objQ1 = this.f98232a.q1(strictModeAccessMethod, lE, strB, set, schedulesBlockingModeB, lE2, strB2, continuation);
        return objQ1 == IntrinsicsKt.f() ? objQ1 : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
    
        if (r10.r(r2, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(java.util.Set r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.repository.StrictModeRepository$unstrictDeselectedSchedules$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.repository.StrictModeRepository$unstrictDeselectedSchedules$1 r0 = (cz.mobilesoft.coreblock.repository.StrictModeRepository$unstrictDeselectedSchedules$1) r0
            int r1 = r0.f98366f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98366f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.StrictModeRepository$unstrictDeselectedSchedules$1 r0 = new cz.mobilesoft.coreblock.repository.StrictModeRepository$unstrictDeselectedSchedules$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f98364c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98366f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r9 = r0.f98363b
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r0.f98362a
            java.util.Set r9 = (java.util.Set) r9
            kotlin.ResultKt.b(r10)
            goto Lbc
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r9 = r0.f98362a
            java.util.Set r9 = (java.util.Set) r9
            kotlin.ResultKt.b(r10)
            goto L55
        L45:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r10 = r8.f98233b
            r0.f98362a = r9
            r0.f98366f = r4
            java.lang.Object r10 = r10.T0(r0)
            if (r10 != r1) goto L55
            goto Lbb
        L55:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r10 = r10.iterator()
        L60:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L8b
            java.lang.Object r4 = r10.next()
            r5 = r4
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r5
            int r6 = r5.E()
            cz.mobilesoft.coreblock.enums.ProfileType r7 = cz.mobilesoft.coreblock.enums.ProfileType.STRICT_MODE
            int r7 = r7.mask()
            if (r6 == r7) goto L60
            long r5 = r5.r()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            boolean r5 = r9.contains(r5)
            if (r5 != 0) goto L60
            r2.add(r4)
            goto L60
        L8b:
            boolean r10 = r2.isEmpty()
            if (r10 != 0) goto Lbf
            int r10 = r2.size()
            r4 = 0
            r5 = r4
        L97:
            if (r5 >= r10) goto La5
            java.lang.Object r6 = r2.get(r5)
            int r5 = r5 + 1
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r6 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r6
            r6.q0(r4)
            goto L97
        La5:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r10 = r8.f98233b
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f98362a = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f98363b = r9
            r0.f98366f = r3
            java.lang.Object r9 = r10.r(r2, r0)
            if (r9 != r1) goto Lbc
        Lbb:
            return r1
        Lbc:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        Lbf:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository.y(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StrictModeRepository(StrictModeDataStore strictModeDataStore, ProfileDao profileDao, CoroutineScope applicationScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 4) != 0) {
            applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        }
        this(strictModeDataStore, profileDao, applicationScope);
    }
}
