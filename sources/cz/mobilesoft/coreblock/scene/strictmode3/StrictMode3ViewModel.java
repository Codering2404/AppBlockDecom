package cz.mobilesoft.coreblock.scene.strictmode3;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.ShouldShowLimitedTimerUseCase;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase;
import cz.mobilesoft.coreblock.service.receiver.PowerConnectionReceiver;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictMode3ViewModel extends BaseStatefulViewModel<StrictMode3ViewState, StrictMode3ViewEvent, StrictMode3ViewCommand> implements DefaultLifecycleObserver {
    private static final Companion K = new Companion(null);
    public static final int L = 8;
    private final Lazy A;
    private final Lazy B;
    private Job C;
    private Job D;
    private Job E;
    private Job F;
    private final PowerConnectionReceiver G;
    private CountDownTimer H;
    private boolean I;
    private final MutableStateFlow J;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f121211o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f121212p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f121213q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f121214r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f121215s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f121216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f121217u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f121218v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f121219w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f121220x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f121221y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f121222z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Profile a(List list) {
            Object next;
            Intrinsics.checkNotNullParameter(list, "<this>");
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
            ProfileWithIntervals profileWithIntervals = (ProfileWithIntervals) next;
            if (profileWithIntervals != null) {
                return profileWithIntervals.b();
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PinCodeParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PinCodeScreenType f121223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f121224b;

        public PinCodeParams(PinCodeScreenType screenType, boolean z2) {
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            this.f121223a = screenType;
            this.f121224b = z2;
        }

        public final PinCodeScreenType a() {
            return this.f121223a;
        }

        public final boolean b() {
            return this.f121224b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PinCodeParams)) {
                return false;
            }
            PinCodeParams pinCodeParams = (PinCodeParams) obj;
            return this.f121223a == pinCodeParams.f121223a && this.f121224b == pinCodeParams.f121224b;
        }

        public int hashCode() {
            return (this.f121223a.hashCode() * 31) + Boolean.hashCode(this.f121224b);
        }

        public String toString() {
            return "PinCodeParams(screenType=" + this.f121223a + ", withPause=" + this.f121224b + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PinCodeScreenType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PinCodeScreenType[] $VALUES;
        public static final PinCodeScreenType Activate = new PinCodeScreenType("Activate", 0, PassCodeType.Create);
        public static final PinCodeScreenType Deactivate = new PinCodeScreenType("Deactivate", 1, PassCodeType.Check);
        private final PassCodeType passCodeType;

        private static final /* synthetic */ PinCodeScreenType[] $values() {
            return new PinCodeScreenType[]{Activate, Deactivate};
        }

        static {
            PinCodeScreenType[] pinCodeScreenTypeArr$values = $values();
            $VALUES = pinCodeScreenTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(pinCodeScreenTypeArr$values);
        }

        private PinCodeScreenType(String str, int i3, PassCodeType passCodeType) {
            this.passCodeType = passCodeType;
        }

        public static EnumEntries<PinCodeScreenType> getEntries() {
            return $ENTRIES;
        }

        public static PinCodeScreenType valueOf(String str) {
            return (PinCodeScreenType) Enum.valueOf(PinCodeScreenType.class, str);
        }

        public static PinCodeScreenType[] values() {
            return (PinCodeScreenType[]) $VALUES.clone();
        }

        public final PassCodeType getPassCodeType() {
            return this.passCodeType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121225a;

        static {
            int[] iArr = new int[StrictModeRepository.MissingConfigType.values().length];
            try {
                iArr[StrictModeRepository.MissingConfigType.Timer.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeRepository.MissingConfigType.Cooldown.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeRepository.MissingConfigType.Schedules.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StrictModeRepository.MissingConfigType.Approval.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StrictModeRepository.MissingConfigType.PinCode.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f121225a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrictMode3ViewModel(Application application) {
        super(application, new StrictMode3ViewState(null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2097151, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f121211o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.b3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StrictMode3ViewModel.P1(this.f121823a));
            }
        });
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = null == true ? 1 : 0;
        final Object[] objArr2 = null == true ? 1 : 0;
        this.f121212p = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApprovalRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApprovalRepository.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = null == true ? 1 : 0;
        final Object[] objArr4 = null == true ? 1 : 0;
        this.f121213q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr3, objArr4);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr5 = null == true ? 1 : 0;
        final Object[] objArr6 = null == true ? 1 : 0;
        this.f121214r = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr5, objArr6);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr7 = null == true ? 1 : 0;
        final Object[] objArr8 = null == true ? 1 : 0;
        this.f121215s = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr7, objArr8);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr9 = null == true ? 1 : 0;
        final Object[] objArr10 = null == true ? 1 : 0;
        this.f121216t = LazyKt.a(lazyThreadSafetyModeB5, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr9, objArr10);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr11 = null == true ? 1 : 0;
        final Object[] objArr12 = null == true ? 1 : 0;
        this.f121217u = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr11, objArr12);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr13 = null == true ? 1 : 0;
        final Object[] objArr14 = null == true ? 1 : 0;
        this.f121218v = LazyKt.a(lazyThreadSafetyModeB7, new Function0<ActivateStrictModeUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ActivateStrictModeUseCase.class), objArr13, objArr14);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr15 = null == true ? 1 : 0;
        final Object[] objArr16 = null == true ? 1 : 0;
        this.f121219w = LazyKt.a(lazyThreadSafetyModeB8, new Function0<GetTitleAndSubtitleUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTitleAndSubtitleUseCase.class), objArr15, objArr16);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr17 = null == true ? 1 : 0;
        final Object[] objArr18 = null == true ? 1 : 0;
        this.f121220x = LazyKt.a(lazyThreadSafetyModeB9, new Function0<SetTimerValueUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SetTimerValueUseCase.class), objArr17, objArr18);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr19 = null == true ? 1 : 0;
        final Object[] objArr20 = null == true ? 1 : 0;
        this.f121221y = LazyKt.a(lazyThreadSafetyModeB10, new Function0<GetActiveStateUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetActiveStateUseCase.class), objArr19, objArr20);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr21 = null == true ? 1 : 0;
        final Object[] objArr22 = null == true ? 1 : 0;
        this.f121222z = LazyKt.a(lazyThreadSafetyModeB11, new Function0<ShouldShowLimitedTimerUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ShouldShowLimitedTimerUseCase.class), objArr21, objArr22);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr23 = null == true ? 1 : 0;
        final Object[] objArr24 = null == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB12, new Function0<GetMissingPermissionsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetMissingPermissionsUseCase.class), objArr23, objArr24);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr25 = null == true ? 1 : 0;
        final Object[] objArr26 = null == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB13, new Function0<WillBeContinuousUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WillBeContinuousUseCase.class), objArr25, objArr26);
            }
        });
        this.G = new PowerConnectionReceiver();
        this.J = StateFlowKt.a(0);
        L2();
        p2();
        n2();
        m2();
        o2();
        l2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState B2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2064383, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState C2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2080767, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState D2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2080767, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onExtendTimerClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2(PermissionRequestReason permissionRequestReason) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onMissingPermissionsChanged$1(this, permissionRequestReason, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2() {
        R1(this, true, false, false, 4, null);
    }

    private final void H2(PinCodeScreenType pinCodeScreenType, String str, boolean z2) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onPinConfirmed$1(pinCodeScreenType, this, str, z2, null), 3, null);
    }

    private final void I2(long[] jArr, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onScheduleIdsSet$1(this, jArr, schedulesBlockingMode, null), 3, null);
    }

    private final void J2() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onSelectedAccessMethodClicked$1(this, null), 3, null);
    }

    private final void K2(long j3) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onTimerValueSet$1(this, j3, null), 3, null);
    }

    private final void L2() {
        Context contextA0 = A0();
        PowerConnectionReceiver powerConnectionReceiver = this.G;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        Unit unit = Unit.f139807a;
        contextA0.registerReceiver(powerConnectionReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M2(cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.M2(cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState N2(StrictModeStateDto strictModeStateDto, StrictMode3ViewState.ActiveState activeState, String str, String str2, String str3, StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, activeState, str, str2, null, str3, strictModeStateDto.a(), ExtensionsKt.h(strictModeStateDto.c()), strictModeStateDto.b(), ExtensionsKt.h(strictModeStateDto.g()), null, null, null, strictModeStateDto.f(), false, false, false, null, null, strictModeStateDto.d(), null, strictModeStateDto.e(), 779784, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$activationConfirmed$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(boolean z2, StrictModeStateDto strictModeStateDto) {
        Profile profileA = K.a(strictModeStateDto.h());
        if (z2 && (strictModeStateDto.b() instanceof AccessMethodConfiguration.Timer) && profileA != null) {
            U2(profileA.w());
            return;
        }
        Job job = this.C;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long P1(StrictMode3ViewModel strictMode3ViewModel) {
        return strictMode3ViewModel.A0().getResources().getInteger(R.integer.config_longAnimTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2(boolean z2, StrictModeStateDto strictModeStateDto) {
        Profile profileA = K.a(strictModeStateDto.h());
        if (profileA != null && g2().b(new ShouldShowLimitedTimerUseCase.Params(z2, strictModeStateDto)).booleanValue()) {
            W2(profileA.w());
            return;
        }
        Job job = this.E;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(boolean z2, boolean z3, boolean z4) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$changeActiveState$1(z2, this, z4, z3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2(boolean z2, StrictModeStateDto strictModeStateDto) {
        Profile.PausedUntil pausedUntilY;
        Profile profileA = K.a(strictModeStateDto.h());
        long jA = (profileA == null || (pausedUntilY = profileA.y()) == null) ? 0L : pausedUntilY.a();
        if (z2 && jA > TimeHelperExt.f128663a.f()) {
            b3(jA);
            return;
        }
        Job job = this.D;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
    }

    static /* synthetic */ void R1(StrictMode3ViewModel strictMode3ViewModel, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z4 = false;
        }
        strictMode3ViewModel.Q1(z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictMode3ViewModel.S2((StrictMode3ViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
    
        if (r11.h(r4, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S1(cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r11, java.util.List r12, java.util.List r13, cz.mobilesoft.coreblock.enums.StrictModeState r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.S1(cz.mobilesoft.coreblock.enums.StrictModeAccessMethod, java.util.List, java.util.List, cz.mobilesoft.coreblock.enums.StrictModeState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState S2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, true, null, null, null, null, 0L, 2064383, null);
    }

    private final void T1(boolean z2) {
        CountDownTimer countDownTimer = this.H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.a3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictMode3ViewModel.V1((StrictMode3ViewState) obj);
            }
        });
        if (z2) {
            NotificationHelper.f128940a.G(A0(), cz.mobilesoft.coreblock.R.string.ay, cz.mobilesoft.coreblock.R.string.Zx);
        }
    }

    private final void T2(boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$startCooldownTimer$1(this, z2, null), 3, null);
    }

    static /* synthetic */ void U1(StrictMode3ViewModel strictMode3ViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        strictMode3ViewModel.T1(z2);
    }

    private final void U2(long j3) {
        Flow flowB = TimeHelperExt.f128663a.b(j3, 500L);
        Job job = this.C;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.C = FlowKt.Q(FlowKt.V(FlowKt.g(flowB), new StrictMode3ViewModel$updateCountdown$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState V1(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2088959, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V2(List list) {
        Job job = this.F;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.F = BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$updateIntervalTrigger$1(list, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivateStrictModeUseCase W1() {
        return (ActivateStrictModeUseCase) this.f121218v.getValue();
    }

    private final void W2(long j3) {
        Job job = this.E;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.E = FlowKt.Q(FlowKt.V(FlowKt.g(TimeHelperExt.f128663a.b(j3, 500L)), new StrictMode3ViewModel$updateLimitedCountdown$1(this, null)), B0());
    }

    private final long X1() {
        return ((Number) this.f121211o.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0110, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r10, r3) == r4) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X2(cz.mobilesoft.coreblock.enums.StrictModeState r19, java.util.List r20, java.util.List r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.X2(cz.mobilesoft.coreblock.enums.StrictModeState, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApprovalRepository Y1() {
        return (ApprovalRepository) this.f121212p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState Y2(List list, boolean z2, StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, new StrictMode3ViewState.MissingPermissions(ExtensionsKt.h(list), z2), null, 0L, false, false, false, null, null, null, null, 0L, 2096127, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper Z1() {
        return (ConsentHelper) this.f121215s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState Z2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, StrictMode3ViewState.MissingPermissions.b(updateState.q(), null, false, 1, null), null, 0L, false, false, false, null, null, null, null, 0L, 2096127, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore a2() {
        return (EventDataStore) this.f121214r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState a3(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, new StrictMode3ViewState.MissingPermissions(ExtensionsKt.a(), false), null, 0L, false, false, false, null, null, null, null, 0L, 2096127, null);
    }

    private final GetActiveStateUseCase b2() {
        return (GetActiveStateUseCase) this.f121221y.getValue();
    }

    private final void b3(long j3) {
        Flow flowB = TimeHelperExt.f128663a.b(j3, 500L);
        Job job = this.D;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.D = FlowKt.Q(FlowKt.V(FlowKt.g(flowB), new StrictMode3ViewModel$updatePauseCountdown$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetMissingPermissionsUseCase c2() {
        return (GetMissingPermissionsUseCase) this.A.getValue();
    }

    private final GetTitleAndSubtitleUseCase d2() {
        return (GetTitleAndSubtitleUseCase) this.f121219w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 e2() {
        return (PremiumRepositoryV2) this.f121216t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SetTimerValueUseCase f2() {
        return (SetTimerValueUseCase) this.f121220x.getValue();
    }

    private final ShouldShowLimitedTimerUseCase g2() {
        return (ShouldShowLimitedTimerUseCase) this.f121222z.getValue();
    }

    public static final /* synthetic */ StrictMode3ViewState h1(StrictMode3ViewModel strictMode3ViewModel) {
        return (StrictMode3ViewState) strictMode3ViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeConfigDTO h2(StrictMode3ViewState strictMode3ViewState) {
        return new StrictModeConfigDTO(strictMode3ViewState.r(), strictMode3ViewState.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore i2() {
        return (StrictModeDataStore) this.f121217u.getValue();
    }

    private final WillBeContinuousUseCase j2() {
        return (WillBeContinuousUseCase) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        if (P0(r2, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k2(java.util.List r8, boolean r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$isStrictModeSetUp$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$isStrictModeSetUp$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$isStrictModeSetUp$1) r0
            int r1 = r0.f121250g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121250g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$isStrictModeSetUp$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$isStrictModeSetUp$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f121248d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121250g
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r8 = r0.f121246b
            cz.mobilesoft.coreblock.repository.StrictModeRepository$AccessMethodSetupResult r8 = (cz.mobilesoft.coreblock.repository.StrictModeRepository.AccessMethodSetupResult) r8
            java.lang.Object r8 = r0.f121245a
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.b(r10)
            goto Lae
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            boolean r9 = r0.f121247c
            java.lang.Object r8 = r0.f121245a
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.b(r10)
            goto L60
        L48:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.repository.StrictModeRepository r10 = r7.t0()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f121245a = r2
            r0.f121247c = r9
            r0.f121250g = r5
            java.lang.Object r10 = r10.m(r8, r9, r0)
            if (r10 != r1) goto L60
            goto La0
        L60:
            cz.mobilesoft.coreblock.repository.StrictModeRepository$AccessMethodSetupResult r10 = (cz.mobilesoft.coreblock.repository.StrictModeRepository.AccessMethodSetupResult) r10
            boolean r2 = r10 instanceof cz.mobilesoft.coreblock.repository.StrictModeRepository.AccessMethodSetupResult.MissingConfiguration
            if (r2 == 0) goto Lb3
            r2 = r10
            cz.mobilesoft.coreblock.repository.StrictModeRepository$AccessMethodSetupResult$MissingConfiguration r2 = (cz.mobilesoft.coreblock.repository.StrictModeRepository.AccessMethodSetupResult.MissingConfiguration) r2
            cz.mobilesoft.coreblock.repository.StrictModeRepository$MissingConfigType r2 = r2.a()
            int[] r6 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.WhenMappings.f121225a
            int r2 = r2.ordinal()
            r2 = r6[r2]
            if (r2 == r5) goto Lab
            if (r2 == r4) goto Lab
            r5 = 3
            if (r2 == r5) goto La7
            r5 = 4
            if (r2 == r5) goto La7
            r5 = 5
            if (r2 != r5) goto La1
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowPinCodeScreen r2 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowPinCodeScreen
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$PinCodeScreenType r5 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.PinCodeScreenType.Activate
            r6 = 0
            r2.<init>(r5, r3, r4, r6)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f121245a = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f121246b = r8
            r0.f121247c = r9
            r0.f121250g = r4
            java.lang.Object r8 = r7.P0(r2, r0)
            if (r8 != r1) goto Lae
        La0:
            return r1
        La1:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        La7:
            r7.J2()
            goto Lae
        Lab:
            r7.E2()
        Lae:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r8
        Lb3:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.k2(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void l2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$observeApprovalEvents$1(this, null), 3, null);
    }

    private final void m2() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$observePowerConnectionEvent$1(this, null), 3, null);
    }

    private final void n2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$observePremiumStateFlow$1(this, null), 3, null);
    }

    private final void o2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$observeSignInState$1(this, null), 3, null);
    }

    private final void p2() {
        final StateFlow stateFlowK = e2().K();
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$observeStrictModeStateFlows$1(this, new Flow<Boolean>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f121265a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2", f = "StrictMode3ViewModel.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f121266a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f121267b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f121268c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f121270f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f121271g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f121272h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f121273i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f121266a = obj;
                        this.f121267b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f121265a = flowCollector;
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
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f121267b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f121267b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f121266a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f121267b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f121272h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f121270f
                        cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L6f
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f121265a
                        r2 = r6
                        cz.mobilesoft.coreblock.enums.PremiumState r2 = (cz.mobilesoft.coreblock.enums.PremiumState) r2
                        cz.mobilesoft.coreblock.enums.Product r4 = cz.mobilesoft.coreblock.enums.Product.STRICT_MODE
                        boolean r2 = r2.f(r4)
                        java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f121268c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f121270f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f121271g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f121272h = r6
                        r6 = 0
                        r0.f121273i = r6
                        r0.f121267b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L6f
                        return r1
                    L6f:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeStrictModeStateFlows$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = stateFlowK.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, null), 3, null);
    }

    private final void q2(StrictModeAccessMethod strictModeAccessMethod, List list) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onAccessMethodConfirmed$1(this, strictModeAccessMethod, list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0125, code lost:
    
        if (P0(r5, r2) == r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0143, code lost:
    
        if (r1 != r3) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016f, code lost:
    
        if (P0(r4, r2) == r3) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r2(kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.r2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void s2(boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onActivationConfirmed$1(this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f121213q.getValue();
    }

    static /* synthetic */ void t2(StrictMode3ViewModel strictMode3ViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        strictMode3ViewModel.s2(z2);
    }

    private final void u2() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onActiveStateChangeButtonClicked$1(((StrictMode3ViewState) I0()).g().c(), this, null), 3, null);
    }

    private final void v2(String str) {
        StrictMode3ViewState strictMode3ViewState = (StrictMode3ViewState) I0();
        if (strictMode3ViewState.c() == StrictModeAccessMethod.Approval && strictMode3ViewState.g().e() == StrictModeState.Paused) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictMode3ViewModel$onApprovalEmailChanged$1$1(this, str, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (P0(r10, r0) != r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ed, code lost:
    
        if (r2.o(r4, r0) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w2(boolean r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.w2(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x2(StrictMode3ViewModel strictMode3ViewModel, final ApprovalEvent result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if ((result instanceof ApprovalEvent.Success) || (result instanceof ApprovalEvent.ReadyToActivate)) {
            strictMode3ViewModel.G0(new StrictMode3ViewModel$onDeactivateConfirmed$2$1$1(strictMode3ViewModel, null));
        } else if (Intrinsics.areEqual(result, ApprovalEvent.Loading.f121707a)) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.y2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel.y2((StrictMode3ViewState) obj);
                }
            });
        } else if (result instanceof ApprovalEvent.Error) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.z2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel.z2(result, (StrictMode3ViewState) obj);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState y2(StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Loading.f127895a, null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState z2(ApprovalEvent approvalEvent, StrictMode3ViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, ((ApprovalEvent.Error) approvalEvent).a(), null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: A2, reason: merged with bridge method [inline-methods] */
    public void O0(StrictMode3ViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StrictMode3ViewEvent.OnOptionsClicked) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnActiveStateChangeButtonClicked) {
            u2();
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnActivationConfirmed.f121189a)) {
            t2(this, false, 1, null);
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnDismissActivationConfirmationBottomSheet.f121193a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.h3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel.B2((StrictMode3ViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnAccessMethodsClicked.f121188a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnMissingPermissionsChanged) {
            F2(((StrictMode3ViewEvent.OnMissingPermissionsChanged) event).a());
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnPinConfirmed) {
            StrictMode3ViewEvent.OnPinConfirmed onPinConfirmed = (StrictMode3ViewEvent.OnPinConfirmed) event;
            H2(onPinConfirmed.b(), onPinConfirmed.a(), onPinConfirmed.c());
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnAccessMethodConfirmed) {
            StrictMode3ViewEvent.OnAccessMethodConfirmed onAccessMethodConfirmed = (StrictMode3ViewEvent.OnAccessMethodConfirmed) event;
            q2(onAccessMethodConfirmed.a(), onAccessMethodConfirmed.b());
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnTimerValueSet) {
            K2(((StrictMode3ViewEvent.OnTimerValueSet) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnSelectedAccessMethodClicked.f121207a)) {
            J2();
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnScheduleIdsSet) {
            StrictMode3ViewEvent.OnScheduleIdsSet onScheduleIdsSet = (StrictMode3ViewEvent.OnScheduleIdsSet) event;
            I2(onScheduleIdsSet.b(), onScheduleIdsSet.a());
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnExtendTimerClicked.f121196a)) {
            AnswersHelper.f128199a.q7(((StrictMode3ViewState) I0()).c());
            E2();
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnResumed.f121204a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onEvent$4(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnLearnMoreClicked.f121197a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictMode3ViewModel$onEvent$5(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnDismissCooldownBottomSheet.f121194a)) {
            U1(this, false, 1, null);
            return;
        }
        if (event instanceof StrictMode3ViewEvent.OnApprovalSendUnblockRequest) {
            Y1().r();
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnRefreshClicked.f121203a)) {
            Y1().D(((StrictMode3ViewState) I0()).c());
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnDismissResumeBottomSheet.f121195a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.i3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel.C2((StrictMode3ViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, StrictMode3ViewEvent.OnStrictModeResumed.f121209a)) {
            s2(true);
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.x2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel.D2((StrictMode3ViewState) obj);
                }
            });
        } else if (event instanceof StrictMode3ViewEvent.OnStrictModeDeactivation) {
            G0(new StrictMode3ViewModel$onEvent$8(this, event, null));
        } else {
            if (!(event instanceof StrictMode3ViewEvent.OnApprovalEmailChanged)) {
                throw new NoWhenBranchMatchedException();
            }
            v2(((StrictMode3ViewEvent.OnApprovalEmailChanged) event).a());
        }
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        A0().unregisterReceiver(this.G);
        CountDownTimer countDownTimer = this.H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onCleared();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        if (((StrictMode3ViewState) I0()).k()) {
            T1(true);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        Y1().E(((StrictMode3ViewState) I0()).c(), ((StrictMode3ViewState) I0()).g().e());
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }
}
