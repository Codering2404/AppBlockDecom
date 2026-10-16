package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.PomodoroSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
public final class QuickBlockRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f97871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f97872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f97873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f97874d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f97875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f97876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f97877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f97878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f97879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f97880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f97881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f97882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CoroutineScope f97883n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StateFlow f97884o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class QuickBlockState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f97885a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Running extends QuickBlockState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Long f97889b;

            /* JADX WARN: Multi-variable type inference failed */
            public Running(Long l3) {
                super(null, 1, 0 == true ? 1 : 0);
                this.f97889b = l3;
            }

            @Override // cz.mobilesoft.coreblock.repository.QuickBlockRepository.QuickBlockState
            public Long a() {
                return this.f97889b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Running) && Intrinsics.areEqual(this.f97889b, ((Running) obj).f97889b);
            }

            public int hashCode() {
                Long l3 = this.f97889b;
                if (l3 == null) {
                    return 0;
                }
                return l3.hashCode();
            }

            public String toString() {
                return "Running(until=" + this.f97889b + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Stopped extends QuickBlockState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final Stopped f97890b = new Stopped();

            /* JADX WARN: Multi-variable type inference failed */
            private Stopped() {
                super(null, 1, 0 == true ? 1 : 0);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Stopped);
            }

            public int hashCode() {
                return 1765276581;
            }

            public String toString() {
                return "Stopped";
            }
        }

        public /* synthetic */ QuickBlockState(Long l3, DefaultConstructorMarker defaultConstructorMarker) {
            this(l3);
        }

        public Long a() {
            return this.f97885a;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Pomodoro extends QuickBlockState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final PomodoroSession f97886b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f97887c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final long f97888d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Pomodoro(PomodoroSession pomodoroSession, boolean z2) {
                super(null, 1, 0 == true ? 1 : 0);
                Intrinsics.checkNotNullParameter(pomodoroSession, "pomodoroSession");
                this.f97886b = pomodoroSession;
                this.f97887c = z2;
                this.f97888d = pomodoroSession.m();
            }

            @Override // cz.mobilesoft.coreblock.repository.QuickBlockRepository.QuickBlockState
            public Long a() {
                return Long.valueOf(this.f97888d);
            }

            public final PomodoroSession b() {
                return this.f97886b;
            }

            public final boolean c() {
                return this.f97887c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Pomodoro)) {
                    return false;
                }
                Pomodoro pomodoro = (Pomodoro) obj;
                return Intrinsics.areEqual(this.f97886b, pomodoro.f97886b) && this.f97887c == pomodoro.f97887c;
            }

            public int hashCode() {
                return (this.f97886b.hashCode() * 31) + Boolean.hashCode(this.f97887c);
            }

            public String toString() {
                return "Pomodoro(pomodoroSession=" + this.f97886b + ", skippedBreak=" + this.f97887c + ")";
            }

            public /* synthetic */ Pomodoro(PomodoroSession pomodoroSession, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(pomodoroSession, (i3 & 2) != 0 ? false : z2);
            }
        }

        private QuickBlockState(Long l3) {
            this.f97885a = l3;
        }

        public /* synthetic */ QuickBlockState(Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : l3, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimerSettings {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TimerSettings[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final TimerSettings ASK = new TimerSettings("ASK", 0, 0);
        public static final TimerSettings NO_TIMER = new TimerSettings("NO_TIMER", 1, 1);
        public static final TimerSettings TIMER = new TimerSettings("TIMER", 2, 2);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final TimerSettings a(int i3) {
                TimerSettings next;
                Iterator<TimerSettings> it = TimerSettings.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getId() == i3) {
                        break;
                    }
                }
                TimerSettings timerSettings = next;
                return timerSettings == null ? TimerSettings.ASK : timerSettings;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ TimerSettings[] $values() {
            return new TimerSettings[]{ASK, NO_TIMER, TIMER};
        }

        static {
            TimerSettings[] timerSettingsArr$values = $values();
            $VALUES = timerSettingsArr$values;
            $ENTRIES = EnumEntriesKt.a(timerSettingsArr$values);
            Companion = new Companion(null);
        }

        private TimerSettings(String str, int i3, int i4) {
            this.id = i4;
        }

        @JvmStatic
        public static final TimerSettings getById(int i3) {
            return Companion.a(i3);
        }

        public static EnumEntries<TimerSettings> getEntries() {
            return $ENTRIES;
        }

        public static TimerSettings valueOf(String str) {
            return (TimerSettings) Enum.valueOf(TimerSettings.class, str);
        }

        public static TimerSettings[] values() {
            return (TimerSettings[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97891a;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f97891a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuickBlockRepository() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f97871a = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f97872b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f97873c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f97874d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PomodoroHistoryDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PomodoroHistoryDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f97875f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<QuickBlockTimerHistoryDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockTimerHistoryDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f97876g = LazyKt.a(lazyThreadSafetyModeB6, new Function0<PomodoroSessionDao>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PomodoroSessionDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f97877h = LazyKt.a(lazyThreadSafetyModeB7, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f97878i = LazyKt.a(lazyThreadSafetyModeB8, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f97879j = LazyKt.a(lazyThreadSafetyModeB9, new Function0<TrialUpsellManager>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialUpsellManager.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f97880k = LazyKt.a(lazyThreadSafetyModeB10, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f97881l = LazyKt.a(lazyThreadSafetyModeB11, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f97882m = LazyKt.a(lazyThreadSafetyModeB12, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr22, objArr23);
            }
        });
        CoroutineScope applicationScope = LockieApplication.f95365k;
        this.f97883n = applicationScope;
        final Flow flowC1 = r().c1();
        Flow<QuickBlockProfileDTO> flow = new Flow<QuickBlockProfileDTO>() { // from class: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f97942a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2", f = "QuickBlockRepository.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f97943a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f97944b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f97945c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f97947f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f97948g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f97949h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f97950i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f97943a = obj;
                        this.f97944b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f97942a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f97944b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f97944b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f97943a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f97944b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f97949h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f97947f
                        cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L6b
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f97942a
                        r2 = r6
                        cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems r2 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems) r2
                        cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO$Companion r4 = cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO.f114030q
                        cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r2 = r4.a(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f97945c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f97947f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f97948g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f97949h = r6
                        r6 = 0
                        r0.f97950i = r6
                        r0.f97944b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L6b
                        return r1
                    L6b:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.QuickBlockRepository$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowC1.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        this.f97884o = FlowKt.h0(flow, applicationScope, SharingStarted.f142210a.c(), null);
    }

    private final WebsiteProfileRelationDao B() {
        return (WebsiteProfileRelationDao) this.f97872b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(long j3, PomodoroSession pomodoroSession, boolean z2) {
        m().n(j3, pomodoroSession, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState J(AppBlockWidgetState updateWidget) {
        Intrinsics.checkNotNullParameter(updateWidget, "$this$updateWidget");
        return AppBlockWidgetState.e(updateWidget, AppBlockWidgetState.QuickBlockWidgetState.NotSetUp.INSTANCE, null, false, 0, 14, null);
    }

    public static /* synthetic */ void N(QuickBlockRepository quickBlockRepository, PomodoroSession pomodoroSession, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        quickBlockRepository.L(pomodoroSession, z2);
    }

    public static /* synthetic */ void O(QuickBlockRepository quickBlockRepository, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        quickBlockRepository.M(l3);
    }

    private final void Q(QuickBlockState quickBlockState) {
        CoroutineScope applicationScope = this.f97883n;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new QuickBlockRepository$updateQuickBlockProfile$1(this, quickBlockState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(PomodoroSession pomodoroSession) {
        m().e(pomodoroSession);
    }

    private final void j(Profile profile) {
        profile.Z(true);
        profile.Y(true);
        profile.V(false);
        profile.a0(false);
        profile.W(false);
        profile.b0(Profile.BlockingMode.Blocklist);
    }

    private final ApplicationProfileRelationDao k() {
        return (ApplicationProfileRelationDao) this.f97873c.getValue();
    }

    private final JobHelperKtx m() {
        return (JobHelperKtx) this.f97878i.getValue();
    }

    private final PomodoroHistoryDao n() {
        return (PomodoroHistoryDao) this.f97874d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PomodoroSessionDao o() {
        return (PomodoroSessionDao) this.f97876g.getValue();
    }

    private final PremiumRepositoryV2 p() {
        return (PremiumRepositoryV2) this.f97880k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao r() {
        return (ProfileDao) this.f97871a.getValue();
    }

    private final QuickBlockDataStore t() {
        return (QuickBlockDataStore) this.f97877h.getValue();
    }

    private final QuickBlockTimerHistoryDao v() {
        return (QuickBlockTimerHistoryDao) this.f97875f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakActivityTracker w() {
        return (StreakActivityTracker) this.f97882m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository x() {
        return (StrictModeRepository) this.f97881l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialUpsellManager z() {
        return (TrialUpsellManager) this.f97879j.getValue();
    }

    public final List A() {
        List listM;
        QuickBlockProfileDTO quickBlockProfileDTOQ = q();
        return (quickBlockProfileDTOQ == null || (listM = quickBlockProfileDTOQ.m()) == null) ? CollectionsKt.emptyList() : listM;
    }

    public final boolean C(ArrayList arrayList) {
        Profile.BlockingMode blockingModeE;
        QuickBlockProfileDTO quickBlockProfileDTOQ = q();
        if (quickBlockProfileDTOQ != null && (blockingModeE = quickBlockProfileDTOQ.e()) != null) {
            int i3 = WhenMappings.f97891a[blockingModeE.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return false;
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                if (Intrinsics.areEqual(((QuickBlockItem) obj).a(), LockieApplication.f95360f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean D() {
        return E(l().size());
    }

    public final boolean E(int i3) {
        return i3 > Limit.APP_WEB_LIMIT_QUICK_BLOCK.getLimitValue() && !p().J().f(Product.APPLICATIONS);
    }

    public final boolean F() {
        return G(A().size());
    }

    public final boolean G(int i3) {
        return i3 > Limit.APP_WEB_LIMIT_QUICK_BLOCK.getLimitValue() && !p().J().f(Product.WEBSITES);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0161, code lost:
    
        if (r3.a(r4, r5, r0) != r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[PHI: r2 r4 r8
      0x00ee: PHI (r2v8 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems) = 
      (r2v5 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
      (r2v10 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
     binds: [B:28:0x00ea, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r4v9 kotlin.jvm.functions.Function0) = (r4v6 kotlin.jvm.functions.Function0), (r4v11 kotlin.jvm.functions.Function0) binds: [B:28:0x00ea, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r8v8 int) = (r8v6 int), (r8v9 int) binds: [B:28:0x00ea, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126 A[PHI: r2 r4 r8
      0x0126: PHI (r2v11 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems) = 
      (r2v8 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
      (r2v13 cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems)
     binds: [B:31:0x0123, B:14:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x0126: PHI (r4v12 kotlin.jvm.functions.Function0) = (r4v9 kotlin.jvm.functions.Function0), (r4v14 kotlin.jvm.functions.Function0) binds: [B:31:0x0123, B:14:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x0126: PHI (r8v10 int) = (r8v8 int), (r8v12 int) binds: [B:31:0x0123, B:14:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I(kotlin.jvm.functions.Function0 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.QuickBlockRepository.I(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void K() {
        CoroutineScope applicationScope = this.f97883n;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new QuickBlockRepository$skipPomodoroBreak$1(this, null), 3, null);
    }

    public final void L(PomodoroSession pomodoroSession, boolean z2) {
        Intrinsics.checkNotNullParameter(pomodoroSession, "pomodoroSession");
        Q(new QuickBlockState.Pomodoro(pomodoroSession, z2));
    }

    public final void M(Long l3) {
        Q(new QuickBlockState.Running(l3));
    }

    public final void P() {
        Q(QuickBlockState.Stopped.f97890b);
    }

    public final List l() {
        List listA;
        QuickBlockProfileDTO quickBlockProfileDTOQ = q();
        return (quickBlockProfileDTOQ == null || (listA = quickBlockProfileDTOQ.a()) == null) ? CollectionsKt.emptyList() : listA;
    }

    public final QuickBlockProfileDTO q() {
        return (QuickBlockProfileDTO) this.f97884o.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final StateFlow s() {
        return this.f97884o;
    }

    public final ArrayList u() {
        ArrayList arrayList = new ArrayList();
        Iterator it = l().iterator();
        while (it.hasNext()) {
            arrayList.add(new QuickBlockItem(Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()), ((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) it.next()).d(), null, null, 12, null));
        }
        for (WebsiteProfileRelation websiteProfileRelation : A()) {
            arrayList.add(new QuickBlockItem(Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId()), websiteProfileRelation.c(), websiteProfileRelation.a(), Boolean.valueOf(websiteProfileRelation.e())));
        }
        return arrayList;
    }

    public final List y() {
        List listL;
        QuickBlockProfileDTO quickBlockProfileDTOQ = q();
        return (quickBlockProfileDTOQ == null || (listL = quickBlockProfileDTOQ.l()) == null) ? CollectionsKt.emptyList() : listL;
    }
}
