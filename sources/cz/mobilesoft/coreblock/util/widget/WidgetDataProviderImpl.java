package cz.mobilesoft.coreblock.util.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.compose.ui.graphics.ColorKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import cz.mobilesoft.coreblock.util.profile.ProfileItemType;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.WidgetDataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WidgetDataProviderImpl<T extends Activity> implements WidgetDataProvider, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f129959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f129960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CompletableJob f129961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f129962d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f129963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f129964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f129965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f129966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f129967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PremiumState f129968k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1", f = "WidgetDataProviderImpl.kt", l = {75}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f129969a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C03111<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ WidgetDataProviderImpl f129971a;

            C03111(WidgetDataProviderImpl widgetDataProviderImpl) {
                this.f129971a = widgetDataProviderImpl;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AppBlockWidgetState g(boolean z2, AppBlockWidgetState updateWidget) {
                Intrinsics.checkNotNullParameter(updateWidget, "$this$updateWidget");
                return AppBlockWidgetState.e(updateWidget, null, null, z2, 0, 11, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AppBlockWidgetState h(boolean z2, AppBlockWidgetState updateWidget) {
                Intrinsics.checkNotNullParameter(updateWidget, "$this$updateWidget");
                return AppBlockWidgetState.e(updateWidget, null, null, z2, 0, 11, null);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
            
                if (r10.a(r4, r5, r0) == r1) goto L22;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(cz.mobilesoft.coreblock.enums.PremiumState r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r10
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1$emit$1 r0 = (cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1$emit$1) r0
                    int r1 = r0.f129976f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f129976f = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1$emit$1 r0 = new cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$1$1$emit$1
                    r0.<init>(r8, r10)
                L18:
                    java.lang.Object r10 = r0.f129974c
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f129976f
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L42
                    if (r2 == r4) goto L38
                    if (r2 != r3) goto L30
                    java.lang.Object r9 = r0.f129972a
                    cz.mobilesoft.coreblock.enums.PremiumState r9 = (cz.mobilesoft.coreblock.enums.PremiumState) r9
                    kotlin.ResultKt.b(r10)
                    goto L8e
                L30:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L38:
                    boolean r9 = r0.f129973b
                    java.lang.Object r2 = r0.f129972a
                    cz.mobilesoft.coreblock.enums.PremiumState r2 = (cz.mobilesoft.coreblock.enums.PremiumState) r2
                    kotlin.ResultKt.b(r10)
                    goto L70
                L42:
                    kotlin.ResultKt.b(r10)
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl r10 = r8.f129971a
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.w(r10, r9)
                    cz.mobilesoft.coreblock.util.monetization.Capability r10 = cz.mobilesoft.coreblock.util.monetization.Capability.PremiumAccess
                    boolean r10 = cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt.a(r9, r10)
                    cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver$Companion r2 = cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver.f134085h
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl r5 = r8.f129971a
                    android.content.Context r5 = cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.r(r5)
                    cz.mobilesoft.coreblock.util.widget.a r6 = new cz.mobilesoft.coreblock.util.widget.a
                    r6.<init>()
                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
                    r0.f129972a = r7
                    r0.f129973b = r10
                    r0.f129976f = r4
                    java.lang.Object r2 = r2.a(r5, r6, r0)
                    if (r2 != r1) goto L6e
                    goto L8d
                L6e:
                    r2 = r9
                    r9 = r10
                L70:
                    cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion r10 = cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver.f134136h
                    cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl r4 = r8.f129971a
                    android.content.Context r4 = cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.r(r4)
                    cz.mobilesoft.coreblock.util.widget.b r5 = new cz.mobilesoft.coreblock.util.widget.b
                    r5.<init>()
                    java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
                    r0.f129972a = r2
                    r0.f129973b = r9
                    r0.f129976f = r3
                    java.lang.Object r9 = r10.a(r4, r5, r0)
                    if (r9 != r1) goto L8e
                L8d:
                    return r1
                L8e:
                    kotlin.Unit r9 = kotlin.Unit.f139807a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.AnonymousClass1.C03111.emit(cz.mobilesoft.coreblock.enums.PremiumState, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f129969a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = WidgetDataProviderImpl.this.z().K();
                C03111 c03111 = new C03111(WidgetDataProviderImpl.this);
                this.f129969a = 1;
                if (stateFlowK.collect(c03111, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f129978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f129979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f129980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f129981d;

        static {
            int[] iArr = new int[WidgetDataProvider.WidgetIcon.values().length];
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134028a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134031d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134032f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134030c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134029b.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134033g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134034h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134035i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[WidgetDataProvider.WidgetIcon.f134036j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f129978a = iArr;
            int[] iArr2 = new int[WidgetDataProvider.WidgetColor.values().length];
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134020a.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134022c.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134021b.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134024f.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134023d.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[WidgetDataProvider.WidgetColor.f134025g.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            f129979b = iArr2;
            int[] iArr3 = new int[WidgetDataProvider.WidgetQuickTimer.values().length];
            try {
                iArr3[WidgetDataProvider.WidgetQuickTimer.f134043b.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[WidgetDataProvider.WidgetQuickTimer.f134044c.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[WidgetDataProvider.WidgetQuickTimer.f134045d.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            f129980c = iArr3;
            int[] iArr4 = new int[WidgetDataProvider.WidgetPremiumFeature.values().length];
            try {
                iArr4[WidgetDataProvider.WidgetPremiumFeature.f134040b.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[WidgetDataProvider.WidgetPremiumFeature.f134039a.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            f129981d = iArr4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetDataProviderImpl(Context context, Class mainActivityClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainActivityClass, "mainActivityClass");
        this.f129959a = context;
        this.f129960b = mainActivityClass;
        final Qualifier qualifier = null;
        CompletableJob completableJobB = SupervisorKt.b(null, 1, null);
        this.f129961c = completableJobB;
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(Dispatchers.b().plus(completableJobB).plus(CoroutinesHelperExtKt.b()));
        this.f129962d = coroutineScopeA;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f129963f = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f129964g = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f129965h = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f129966i = LazyKt.a(lazyThreadSafetyModeB4, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f129967j = LazyKt.a(lazyThreadSafetyModeB5, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr8, objArr9);
            }
        });
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(null), 3, null);
        FlowExtKt.i(y().Q0(), coroutineScopeA, new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.2
            public final Object a(long j3, Continuation continuation) {
                Object objF = ProfileToViewDTOHelperKt.F(WidgetDataProviderImpl.this.f129959a, null, ProfileItemType.Dashboard.f129300a, continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository A() {
        return (QuickBlockRepository) this.f129967j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository B() {
        return (StrictModeRepository) this.f129965h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C(cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl.C(cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void D(boolean z2, boolean z3, boolean z4, boolean z5, Long l3, boolean z6) {
        Context context = this.f129959a;
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, context, null, null, 6, null);
        intentC.setFlags(268468224);
        intentC.putExtra("IS_FROM_WIDGET", true);
        intentC.putExtra("IS_TILE_SERVICE", true);
        intentC.putExtra("SHOW_STRICT_MODE_SNACK", z2);
        intentC.putExtra("SHOW_TIME_SELECT", z3);
        intentC.putExtra("SHOW_POMODORO", z4);
        intentC.putExtra("OPEN_PERMISSION_SCREEN", z5);
        intentC.putExtra("WIDGET_TIMER", l3);
        intentC.putExtra("SHOW_STRICT_MODE_WARNING", z6);
        context.startActivity(intentC);
    }

    static /* synthetic */ void E(WidgetDataProviderImpl widgetDataProviderImpl, boolean z2, boolean z3, boolean z4, boolean z5, Long l3, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        if ((i3 & 4) != 0) {
            z4 = false;
        }
        if ((i3 & 8) != 0) {
            z5 = false;
        }
        if ((i3 & 16) != 0) {
            l3 = null;
        }
        if ((i3 & 32) != 0) {
            z6 = false;
        }
        widgetDataProviderImpl.D(z2, z3, z4, z5, l3, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x(QuickBlockProfileDTO quickBlockProfileDTO) {
        List listA = quickBlockProfileDTO.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) it.next()).d());
        }
        List<WebsiteProfileRelation> listM = quickBlockProfileDTO.m();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listM, 10));
        for (WebsiteProfileRelation websiteProfileRelation : listM) {
            arrayList2.add(new WebsiteDTO(websiteProfileRelation.c(), websiteProfileRelation.a(), websiteProfileRelation.e(), false, 8, null));
        }
        if (A().E(arrayList.size()) || A().G(arrayList2.size())) {
            return true;
        }
        PremiumState premiumState = null;
        if (quickBlockProfileDTO.h().o() == Profile.BlockingMode.Allowlist) {
            PremiumState premiumState2 = this.f129968k;
            if (premiumState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("premiumState");
                premiumState2 = null;
            }
            if (!premiumState2.g()) {
                return true;
            }
        }
        if (quickBlockProfileDTO.h().i()) {
            PremiumState premiumState3 = this.f129968k;
            if (premiumState3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("premiumState");
                premiumState3 = null;
            }
            if (!AccessPolicyKt.a(premiumState3, Capability.PremiumAccess)) {
                return true;
            }
        }
        if (quickBlockProfileDTO.h().n()) {
            PremiumState premiumState4 = this.f129968k;
            if (premiumState4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("premiumState");
                premiumState4 = null;
            }
            if (!AccessPolicyKt.a(premiumState4, Capability.PremiumAccess)) {
                return true;
            }
        }
        if (!quickBlockProfileDTO.h().j()) {
            return false;
        }
        PremiumState premiumState5 = this.f129968k;
        if (premiumState5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("premiumState");
        } else {
            premiumState = premiumState5;
        }
        return !premiumState.g();
    }

    private final EventDataStore y() {
        return (EventDataStore) this.f129966i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 z() {
        return (PremiumRepositoryV2) this.f129963f.getValue();
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public boolean a(int i3) {
        PremiumState premiumState = this.f129968k;
        if (premiumState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("premiumState");
            premiumState = null;
        }
        return premiumState.f(Product.PROFILE) || i3 < Limit.PROFILE_LIMIT.getLimitValue();
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public Intent c(Context context, boolean z2, boolean z3, boolean z4, WidgetDataProvider.WidgetQuickTimer widgetQuickTimer) {
        Intrinsics.checkNotNullParameter(context, "context");
        ScheduleActivity.Companion companion = ScheduleActivity.f114377m;
        int i3 = widgetQuickTimer == null ? -1 : WhenMappings.f129980c[widgetQuickTimer.ordinal()];
        Intent intentB = ScheduleActivity.Companion.b(companion, context, new ScheduleDescriptor.QuickBlock(z3, false, z4, z2, i3 != 1 ? i3 != 2 ? i3 != 3 ? null : Long.valueOf(TimeHelperExt.f128663a.f() + TimeUnit.HOURS.toMillis(24L)) : Long.valueOf(TimeHelperExt.f128663a.f() + TimeUnit.HOURS.toMillis(1L)) : Long.valueOf(TimeHelperExt.f128663a.f() + TimeUnit.MINUTES.toMillis(25L)), null, 34, null), true, false, 8, null);
        intentB.putExtra("IS_FROM_WIDGET", true);
        intentB.setFlags(268468224);
        return intentB;
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public long d(WidgetDataProvider.WidgetColor widgetColor) {
        Intrinsics.checkNotNullParameter(widgetColor, "widgetColor");
        switch (WhenMappings.f129979b[widgetColor.ordinal()]) {
            case 1:
                return ColorKt.h(ComposeColorsKt.e().N(), ComposeColorsKt.e().e());
            case 2:
                return ComposeColorsKt.e().b();
            case 3:
                return ComposeColorsKt.e().l0();
            case 4:
                return ComposeColorsKt.e().L();
            case 5:
                return ComposeColorsKt.e().Y();
            case 6:
                return ComposeColorsKt.e().P();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public void e(WidgetDataProvider.WidgetQuickTimer quickState) {
        Intrinsics.checkNotNullParameter(quickState, "quickState");
        BuildersKt__Builders_commonKt.d(this.f129962d, null, null, new WidgetDataProviderImpl$startQuickBlock$1(quickState, this, null), 3, null);
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public Intent f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) this.f129960b);
        intent.setFlags(268468224);
        intent.putExtra("IS_TILE_SERVICE", true);
        return intent;
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public Intent g(Context context, WidgetDataProvider.WidgetQuickTimer widgetQuickTimer) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c(context, (widgetQuickTimer == WidgetDataProvider.WidgetQuickTimer.f134047g || widgetQuickTimer == WidgetDataProvider.WidgetQuickTimer.f134048h) ? false : true, false, false, widgetQuickTimer);
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public void i() {
        BuildersKt__Builders_commonKt.d(this.f129962d, null, null, new WidgetDataProviderImpl$skipBreak$1(this, null), 3, null);
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public void j() {
        BuildersKt__Builders_commonKt.d(this.f129962d, null, null, new WidgetDataProviderImpl$stopQuickBlock$1(this, null), 3, null);
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public String k(WidgetDataProvider.WidgetString widgetString) {
        Intrinsics.checkNotNullParameter(widgetString, "widgetString");
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.ApplicationName.f134054a)) {
            String string = this.f129959a.getString(R.string.f95790f1);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.QuickBlockName.f134061a)) {
            String string2 = this.f129959a.getString(R.string.zD);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.TimerFormatCountDown.f134071a)) {
            String string3 = this.f129959a.getString(R.string.K);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Schedules.f134062a)) {
            String string4 = this.f129959a.getString(R.string.j4);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Start.f134064a)) {
            String string5 = this.f129959a.getString(R.string.bA);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Stop.f134065a)) {
            String string6 = this.f129959a.getString(R.string.yA);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Add.f134053a)) {
            String string7 = this.f129959a.getString(R.string.M);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Active.f134052a)) {
            String string8 = this.f129959a.getString(R.string.f95863z);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Timer.f134069a)) {
            String string9 = this.f129959a.getString(R.string.rD);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Premium.f134060a)) {
            String string10 = this.f129959a.getString(R.string.JD);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.WidgetOnlyForPremium.f134072a)) {
            String string11 = this.f129959a.getString(R.string.yv);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Time25m.f134068a)) {
            String string12 = this.f129959a.getString(R.string.yk, 25);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Time1h.f134066a)) {
            String string13 = this.f129959a.getString(R.string.wk, 1);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Time24h.f134067a)) {
            String string14 = this.f129959a.getString(R.string.wk, 24);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        }
        if (widgetString instanceof WidgetDataProvider.WidgetString.PomodoroFocus) {
            String string15 = this.f129959a.getString(R.string.lo, Integer.valueOf(((WidgetDataProvider.WidgetString.PomodoroFocus) widgetString).a()));
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        }
        if (widgetString instanceof WidgetDataProvider.WidgetString.PomodoroFocusWithCountdown) {
            String string16 = this.f129959a.getString(R.string.lo, Integer.valueOf(((WidgetDataProvider.WidgetString.PomodoroFocusWithCountdown) widgetString).a()));
            Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
            return StringHelperExtKt.p(string16, "%s", " • ");
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.PomodoroBreak.f134056a)) {
            String string17 = this.f129959a.getString(R.string.ko);
            Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
            return string17;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.PomodoroBreakWithCountdown.f134057a)) {
            String string18 = this.f129959a.getString(R.string.ko);
            Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
            return StringHelperExtKt.p(string18, "%s", " • ");
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Skip.f134063a)) {
            String string19 = this.f129959a.getString(R.string.wx);
            Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
            return string19;
        }
        if (Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.TimerAndPomodoro.f134070a)) {
            String string20 = this.f129959a.getString(R.string.rD);
            Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
            String string21 = this.f129959a.getString(R.string.jo);
            Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
            return StringHelperExtKt.p(string20, string21, " & ");
        }
        if (!Intrinsics.areEqual(widgetString, WidgetDataProvider.WidgetString.Pomodoro.f134055a)) {
            throw new NoWhenBranchMatchedException();
        }
        String string22 = this.f129959a.getString(R.string.jo);
        Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
        return string22;
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public int l(WidgetDataProvider.WidgetIcon widgetIcon) {
        Intrinsics.checkNotNullParameter(widgetIcon, "widgetIcon");
        switch (WhenMappings.f129978a[widgetIcon.ordinal()]) {
            case 1:
                return R.drawable.r4;
            case 2:
                return R.drawable.k4;
            case 3:
                return R.drawable.J5;
            case 4:
                return R.drawable.r6;
            case 5:
                return R.drawable.f95562s1;
            case 6:
                return R.drawable.f95558r0;
            case 7:
                return R.drawable.s6;
            case 8:
                return R.drawable.n4;
            case 9:
                return R.drawable.m4;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public Intent m(Context context, WidgetDataProvider.WidgetPremiumFeature widgetPremiumFeature) {
        Pair pairA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetPremiumFeature, "widgetPremiumFeature");
        int i3 = WhenMappings.f129981d[widgetPremiumFeature.ordinal()];
        if (i3 == 1) {
            pairA = TuplesKt.a(PremiumFeature.SCHEDULES_WIDGET, "no_of_schedules_limit");
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            pairA = TuplesKt.a(PremiumFeature.QUICK_BLOCK_TIMER, "qb_timer");
        }
        PremiumFeature premiumFeature = (PremiumFeature) pairA.a();
        Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(premiumFeature), "widget", (String) pairA.b(), false, false, false, null, 240, null);
        intentC.setFlags(268468224);
        return intentC;
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public void o(Throwable e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        CrashHelper.j(e3);
    }

    @Override // cz.mobilesoft.widgets.WidgetDataProvider
    public Intent p(Context context, Long l3, boolean z2) {
        ScheduleDescriptor newSchedule;
        Intrinsics.checkNotNullParameter(context, "context");
        ScheduleActivity.Companion companion = ScheduleActivity.f114377m;
        if (l3 != null) {
            newSchedule = new ScheduleDescriptor.ScheduleId(l3.longValue(), z2);
        } else {
            newSchedule = new ScheduleDescriptor.NewSchedule(null, null, false, false, null, null, 63, null);
        }
        Intent intentA = companion.a(context, newSchedule, true, true);
        intentA.putExtra("IS_FROM_WIDGET", true);
        intentA.setFlags(268468224);
        return intentA;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
