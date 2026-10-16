package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.ViewModelKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
import cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakState;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.permissions.AdvancedProtectionHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.graph.DonutChartData;
import cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BlockingScreenViewModel extends BaseStatefulViewModel<BlockingScreenViewState, BlockingScreenViewEvent, BlockingScreenViewCommand> {
    public static final Companion T = new Companion(null);
    public static final int U = 8;
    private static final List V;
    private static final SchedulesSectionViewState W;
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private Job J;
    private Job K;
    private final Lazy L;
    private final MutableStateFlow M;
    private MutableStateFlow N;
    private Mutex O;
    private boolean P;
    private Flow Q;
    private final BroadcastReceiver R;
    private final Lazy S;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f99558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f99559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f99560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f99561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f99562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f99563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f99564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f99565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f99566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f99567x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f99568y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f99569z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99570a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f99570a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            AdvancedProtectionHelper advancedProtectionHelper = AdvancedProtectionHelper.f128991a;
            if (advancedProtectionHelper.c()) {
                AnswersHelper.f128199a.w8(advancedProtectionHelper.b(BlockingScreenViewModel.this.A0()));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$10", f = "BlockingScreenViewModel.kt", l = {268}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f99572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f99573b;

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState y(long j3, BlockingScreenViewState blockingScreenViewState) {
            return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, Long.valueOf(j3), false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870879, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState z(BlockingScreenViewState blockingScreenViewState) {
            return BlockingScreenViewState.b(blockingScreenViewState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870879, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99573b;
            if (i3 != 0 && i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            while (JobKt.p(getContext())) {
                final long jF = TimeHelperExt.f128663a.f();
                if (Math.abs(System.currentTimeMillis() - jF) > TimeUnit.SECONDS.toMillis(1L)) {
                    BlockingScreenViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BlockingScreenViewModel.AnonymousClass10.y(jF, (BlockingScreenViewState) obj2);
                        }
                    });
                } else if (BlockingScreenViewModel.b1(BlockingScreenViewModel.this).d() != null) {
                    BlockingScreenViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BlockingScreenViewModel.AnonymousClass10.z((BlockingScreenViewState) obj2);
                        }
                    });
                }
                this.f99572a = jF;
                this.f99573b = 1;
                if (DelayKt.b(500L, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$11", f = "BlockingScreenViewModel.kt", l = {278}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99575a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$11$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, Set<? extends String>, Continuation<? super Pair<? extends Boolean, ? extends List<? extends HelpItem>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99577a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f99578b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f99579c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(boolean z2, Set set, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99578b = z2;
                anonymousClass1.f99579c = set;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Boolean) obj).booleanValue(), (Set) obj2, (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f99578b;
                Set set = (Set) this.f99579c;
                IntrinsicsKt.f();
                if (this.f99577a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Boolean boolA = Boxing.a(z2);
                Set set2 = set;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    arrayList.add(HelpItem.valueOf((String) it.next()));
                }
                return TuplesKt.a(boolA, arrayList);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$11$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99580a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99580a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState g(boolean z2, SnapshotStateList snapshotStateList, String str, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, z2, snapshotStateList, str, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536867327, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState h(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, z2, CollectionsKt.emptyList(), "", false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536867327, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object emit(Pair pair, Continuation continuation) {
                final boolean zBooleanValue = ((Boolean) pair.a()).booleanValue();
                List list = (List) pair.b();
                RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
                boolean zP = runnabilityHelper.P();
                boolean zK = runnabilityHelper.K();
                if (zK || zP) {
                    String lowerCase = Build.MANUFACTURER;
                    Intrinsics.checkNotNull(lowerCase);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= lowerCase.length()) {
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            lowerCase = lowerCase.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            break;
                        }
                        if (!Character.isUpperCase(lowerCase.charAt(i3))) {
                            break;
                        }
                        i3++;
                    }
                    Intrinsics.checkNotNull(lowerCase);
                    final String strC = StringHelperExtKt.c(lowerCase);
                    final SnapshotStateList snapshotStateListF = SnapshotStateKt.f();
                    if (RunnabilityHelper.O(this.f99580a.A0())) {
                        HelpItem helpItem = HelpItem.XIAOMI_LOCK_APPS;
                        if (!list.contains(helpItem)) {
                            snapshotStateListF.add(helpItem);
                        }
                    }
                    if (RunnabilityHelper.C(this.f99580a.A0())) {
                        HelpItem helpItem2 = HelpItem.BATTERY_OPTIMIZATION;
                        if (!list.contains(helpItem2)) {
                            snapshotStateListF.add(helpItem2);
                        }
                    }
                    if (!zK && RunnabilityHelper.w(this.f99580a.A0())) {
                        HelpItem helpItem3 = HelpItem.AUTOSTART;
                        if (!list.contains(helpItem3)) {
                            snapshotStateListF.add(helpItem3);
                        }
                    }
                    this.f99580a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingScreenViewModel.AnonymousClass11.AnonymousClass2.g(zBooleanValue, snapshotStateListF, strC, (BlockingScreenViewState) obj);
                        }
                    });
                } else {
                    this.f99580a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingScreenViewModel.AnonymousClass11.AnonymousClass2.h(zBooleanValue, (BlockingScreenViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass11(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99575a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(BlockingScreenViewModel.this.W1().d3(), BlockingScreenViewModel.this.W1().m2(), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99575a = 1;
                if (flowJ.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$12", f = "BlockingScreenViewModel.kt", l = {329}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99581a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$12$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$12$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PremiumState, BlockingScreenViewState, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99583a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f99584b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f99585c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PremiumState premiumState, BlockingScreenViewState blockingScreenViewState, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99584b = premiumState;
                anonymousClass1.f99585c = blockingScreenViewState;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                PremiumState premiumState = (PremiumState) this.f99584b;
                BlockingScreenViewState blockingScreenViewState = (BlockingScreenViewState) this.f99585c;
                IntrinsicsKt.f();
                if (this.f99583a != 0) {
                    throw new IllegalStateException(QaXmqxvjHhxVy.OMJjMjxNGx);
                }
                ResultKt.b(obj);
                return Boxing.a(premiumState.f(Product.PROFILE) || (blockingScreenViewState.r().c().size() < Limit.PROFILE_LIMIT.getLimitValue() && !blockingScreenViewState.r().d()));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$12$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99586a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99586a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, z2, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536838143, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99586a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass12.AnonymousClass2.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass12(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99581a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(BlockingScreenViewModel.this.d2().K(), BlockingScreenViewModel.this.M0(), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99581a = 1;
                if (flowJ.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$13", f = "BlockingScreenViewModel.kt", l = {339}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99587a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$13$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$13$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PremiumState, BlockingScreenViewState, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f99590b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f99591c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PremiumState premiumState, BlockingScreenViewState blockingScreenViewState, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99590b = premiumState;
                anonymousClass1.f99591c = blockingScreenViewState;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                PremiumState premiumState = (PremiumState) this.f99590b;
                BlockingScreenViewState blockingScreenViewState = (BlockingScreenViewState) this.f99591c;
                IntrinsicsKt.f();
                if (this.f99589a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                List listC = blockingScreenViewState.r().c();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listC) {
                    if (!((ProfileViewDTO) obj2).B()) {
                        arrayList.add(obj2);
                    }
                }
                return Boxing.a(premiumState.f(Product.PROFILE) || (arrayList.size() < Limit.PROFILE_LIMIT.getLimitValue() && !blockingScreenViewState.r().d()));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$13$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99592a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99592a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, z2, false, false, null, null, null, null, false, false, false, false, 0, null, 536805375, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99592a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass13.AnonymousClass2.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass13(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass13(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99587a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(BlockingScreenViewModel.this.d2().K(), BlockingScreenViewModel.this.M0(), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99587a = 1;
                if (flowJ.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass13) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$14", f = "BlockingScreenViewModel.kt", l = {347, 348}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f99594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewModel f99595c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(boolean z2, BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
            super(2, continuation);
            this.f99594b = z2;
            this.f99595c = blockingScreenViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass14(this.f99594b, this.f99595c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        
            if (r6.P0(r1, r5) != r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f99593a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r6)
                goto L55
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L30
            L1e:
                kotlin.ResultKt.b(r6)
                boolean r6 = r5.f99594b
                if (r6 == 0) goto L55
                r5.f99593a = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
                if (r6 != r0) goto L30
                goto L54
            L30:
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r6 = r5.f99595c
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$ShowStrictModeSnackbar r1 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$ShowStrictModeSnackbar
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r3 = r5.f99595c
                android.content.Context r3 = r3.A0()
                cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives$Companion r4 = cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives.Companion
                int r4 = r4.a()
                java.lang.String r3 = r3.getString(r4)
                java.lang.String r4 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                r1.<init>(r3)
                r5.f99593a = r2
                java.lang.Object r6 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.z1(r6, r1, r5)
                if (r6 != r0) goto L55
            L54:
                return r0
            L55:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.AnonymousClass14.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass14) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$15, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$15", f = "BlockingScreenViewModel.kt", l = {353}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99596a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$15$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99598a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99598a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewModel blockingScreenViewModel, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, z2, false, false, false, false, null, blockingScreenViewModel.d2().I().e(), null, null, false, false, false, false, 0, null, 535805951, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                final BlockingScreenViewModel blockingScreenViewModel = this.f99598a;
                blockingScreenViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass15.AnonymousClass1.f(z2, blockingScreenViewModel, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass15(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass15(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99596a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowJ = BlockingScreenViewModel.this.d2().I().j(true);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99596a = 1;
                if (stateFlowJ.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass15) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$16, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$16", f = "BlockingScreenViewModel.kt", l = {371}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99599a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$16$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$16$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<AutoTrialVariant, Boolean, Continuation<? super AutoTrialVariant>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99601a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f99602b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f99603c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(AutoTrialVariant autoTrialVariant, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99602b = autoTrialVariant;
                anonymousClass1.f99603c = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h((AutoTrialVariant) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                AutoTrialVariant autoTrialVariant = (AutoTrialVariant) this.f99602b;
                boolean z2 = this.f99603c;
                IntrinsicsKt.f();
                if (this.f99601a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return z2 ? AutoTrialVariant.CardWithRetentionFlow : autoTrialVariant;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$16$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99604a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99604a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(AutoTrialVariant autoTrialVariant, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, autoTrialVariant, false, false, false, false, 0, null, 532676607, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final AutoTrialVariant autoTrialVariant, Continuation continuation) {
                this.f99604a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass16.AnonymousClass2.f(autoTrialVariant, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass16(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass16(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99599a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(BlockingScreenViewModel.this.W1().h2(), BuildConfig.f95357b.booleanValue() ? BlockingScreenViewModel.this.X1().D0() : FlowKt.K(Boxing.a(false)), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99599a = 1;
                if (flowM.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass16) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$17", f = "BlockingScreenViewModel.kt", l = {377}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99605a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$17$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99607a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99607a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, z2, false, false, false, 0, null, 528482303, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99607a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass17.AnonymousClass1.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass17(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass17(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99605a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE2 = BlockingScreenViewModel.this.W1().e2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99605a = 1;
                if (flowE2.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass17) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$18, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$18", f = "BlockingScreenViewModel.kt", l = {383}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99608a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$18$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99610a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99610a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, z2, false, 0, null, 503316479, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99610a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass18.AnonymousClass1.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass18(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass18(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99608a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowF2 = BlockingScreenViewModel.this.W1().f2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99608a = 1;
                if (flowF2.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass18) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$19, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$19", f = "BlockingScreenViewModel.kt", l = {402}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass19 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99611a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$19$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$19$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<CustomerInfo, Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99613a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f99614b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f99615c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(CustomerInfo customerInfo, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99614b = customerInfo;
                anonymousClass1.f99615c = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h((CustomerInfo) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                EntitlementInfos entitlements;
                Map<String, EntitlementInfo> all;
                EntitlementInfo entitlementInfo;
                Date expirationDate;
                CustomerInfo customerInfo = (CustomerInfo) this.f99614b;
                boolean z2 = this.f99615c;
                IntrinsicsKt.f();
                if (this.f99613a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (z2) {
                    return Boxing.a(true);
                }
                long jF = TimeHelperExt.f128663a.f();
                Long lE = (customerInfo == null || (entitlements = customerInfo.getEntitlements()) == null || (all = entitlements.getAll()) == null || (entitlementInfo = all.get(Entitlement.FreeMonthPremium.getId())) == null || (expirationDate = entitlementInfo.getExpirationDate()) == null) ? null : Boxing.e(expirationDate.getTime());
                return Boxing.a(lE != null && lE.longValue() <= jF && lE.longValue() > jF - TimeUnit.DAYS.toMillis(30L) && !RevenueCatExtKt.a(customerInfo).contains(Entitlement.Premium));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$19$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99616a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99616a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, z2, false, false, 0, null, 520093695, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99616a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass19.AnonymousClass2.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass19(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass19(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99611a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(BlockingScreenViewModel.this.d2().C(), BuildConfig.f95357b.booleanValue() ? BlockingScreenViewModel.this.X1().D0() : FlowKt.K(Boxing.a(false)), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99611a = 1;
                if (flowM.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass19) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2", f = "BlockingScreenViewModel.kt", l = {195, 196, 203}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99617a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$1", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99619a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f99620b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f99621c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(boolean z2, boolean z3, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99620b = z2;
                anonymousClass1.f99621c = z3;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f99620b;
                boolean z3 = this.f99621c;
                IntrinsicsKt.f();
                if (this.f99619a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(z2 || z3);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$2", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02712 extends SuspendLambda implements Function3<Boolean, QuestionnaireConfig, Continuation<? super AnnouncementCardState>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99622a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f99623b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f99624c;

            C02712(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(boolean z2, QuestionnaireConfig questionnaireConfig, Continuation continuation) {
                C02712 c02712 = new C02712(continuation);
                c02712.f99623b = z2;
                c02712.f99624c = questionnaireConfig;
                return c02712.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Boolean) obj).booleanValue(), (QuestionnaireConfig) obj2, (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f99623b;
                QuestionnaireConfig questionnaireConfig = (QuestionnaireConfig) this.f99624c;
                IntrinsicsKt.f();
                if (this.f99622a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new AnnouncementCardState(z2 || questionnaireConfig != null, questionnaireConfig);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99625a;

            AnonymousClass3(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99625a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(AnnouncementCardState announcementCardState, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, announcementCardState, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870909, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final AnnouncementCardState announcementCardState, Continuation continuation) {
                this.f99625a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass2.AnonymousClass3.f(announcementCardState, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
        
            if (r6.collect(r1, r5) != r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Exception {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f99617a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.b(r6)
                goto L83
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.b(r6)
                goto L4e
            L21:
                kotlin.ResultKt.b(r6)
                goto L39
            L25:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r6 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.this
                cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager r6 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.w1(r6)
                r5.f99617a = r4
                java.lang.String r1 = "app_start"
                java.lang.Object r6 = r6.h(r1, r5)
                if (r6 != r0) goto L39
                goto L82
            L39:
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r6 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.o1(r6)
                cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r1 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
                cz.mobilesoft.coreblock.dto.QuestionnaireConfig r1 = r1.v0()
                r5.f99617a = r3
                java.lang.Object r6 = r6.emit(r1, r5)
                if (r6 != r0) goto L4e
                goto L82
            L4e:
                cz.mobilesoft.coreblock.repository.AppVersionRepository r6 = cz.mobilesoft.coreblock.repository.AppVersionRepository.f97355a
                kotlinx.coroutines.flow.Flow r6 = r6.B()
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r1 = r1.o2()
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$1 r3 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$1
                r4 = 0
                r3.<init>(r4)
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.J(r6, r1, r3)
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r1 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.o1(r1)
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$2 r3 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$2
                r3.<init>(r4)
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.J(r6, r1, r3)
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$3 r1 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$2$3
                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r3 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.this
                r1.<init>(r3)
                r5.f99617a = r2
                java.lang.Object r6 = r6.collect(r1, r5)
                if (r6 != r0) goto L83
            L82:
                return r0
            L83:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20", f = "BlockingScreenViewModel.kt", l = {426}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99626a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99628a;

            AnonymousClass3(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99628a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(Long l3, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, l3, null, false, false, false, false, 0, null, 534773759, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Long l3, Continuation continuation) {
                this.f99628a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass20.AnonymousClass3.f(l3, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass20(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass20(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99626a;
            if (i3 == 0) {
                ResultKt.b(obj);
                final StateFlow stateFlowC = BlockingScreenViewModel.this.d2().C();
                Flow flowM0 = FlowKt.m0(FlowKt.u(new Flow<Long>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final /* synthetic */ FlowCollector f99633a;

                        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata
                        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2", f = "BlockingScreenViewModel.kt", l = {50}, m = "emit", v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            /* synthetic */ Object f99634a;

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            int f99635b;

                            /* JADX INFO: renamed from: c, reason: collision with root package name */
                            Object f99636c;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            Object f99638f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            Object f99639g;

                            /* JADX INFO: renamed from: h, reason: collision with root package name */
                            Object f99640h;

                            /* JADX INFO: renamed from: i, reason: collision with root package name */
                            int f99641i;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.f99634a = obj;
                                this.f99635b |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.f99633a = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
                            /*
                                r7 = this;
                                boolean r0 = r9 instanceof cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r9
                                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.f99635b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f99635b = r1
                                goto L18
                            L13:
                                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r9)
                            L18:
                                java.lang.Object r9 = r0.f99634a
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.f99635b
                                r3 = 1
                                if (r2 == 0) goto L3a
                                if (r2 != r3) goto L32
                                java.lang.Object r8 = r0.f99640h
                                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                                java.lang.Object r8 = r0.f99638f
                                cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1$2$1 r8 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r8
                                kotlin.ResultKt.b(r9)
                                goto Lab
                            L32:
                                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                                r8.<init>(r9)
                                throw r8
                            L3a:
                                kotlin.ResultKt.b(r9)
                                kotlinx.coroutines.flow.FlowCollector r9 = r7.f99633a
                                r2 = r8
                                com.revenuecat.purchases.CustomerInfo r2 = (com.revenuecat.purchases.CustomerInfo) r2
                                r4 = 0
                                if (r2 == 0) goto L87
                                java.util.List r5 = cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt.a(r2)
                                cz.mobilesoft.coreblock.enums.Entitlement r6 = cz.mobilesoft.coreblock.enums.Entitlement.Premium
                                boolean r5 = r5.contains(r6)
                                if (r5 != 0) goto L52
                                goto L53
                            L52:
                                r2 = r4
                            L53:
                                if (r2 == 0) goto L87
                                com.revenuecat.purchases.EntitlementInfos r2 = r2.getEntitlements()
                                if (r2 == 0) goto L87
                                java.util.Map r2 = r2.getAll()
                                if (r2 == 0) goto L87
                                cz.mobilesoft.coreblock.enums.Entitlement r5 = cz.mobilesoft.coreblock.enums.Entitlement.FreeMonthPremium
                                java.lang.String r5 = r5.getId()
                                java.lang.Object r2 = r2.get(r5)
                                com.revenuecat.purchases.EntitlementInfo r2 = (com.revenuecat.purchases.EntitlementInfo) r2
                                if (r2 == 0) goto L87
                                boolean r5 = r2.isActive()
                                if (r5 == 0) goto L76
                                goto L77
                            L76:
                                r2 = r4
                            L77:
                                if (r2 == 0) goto L87
                                java.util.Date r2 = r2.getExpirationDate()
                                if (r2 == 0) goto L87
                                long r4 = r2.getTime()
                                java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.e(r4)
                            L87:
                                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                                r0.f99636c = r2
                                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                                r0.f99638f = r2
                                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                                r0.f99639g = r8
                                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
                                r0.f99640h = r8
                                r8 = 0
                                r0.f99641i = r8
                                r0.f99635b = r3
                                java.lang.Object r8 = r9.emit(r4, r0)
                                if (r8 != r1) goto Lab
                                return r1
                            Lab:
                                kotlin.Unit r8 = kotlin.Unit.f139807a
                                return r8
                            */
                            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = stateFlowC.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                }), new BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1(null));
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(BlockingScreenViewModel.this);
                this.f99626a = 1;
                if (flowM0.collect(anonymousClass3, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass20) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$21, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$21", f = "BlockingScreenViewModel.kt", l = {448}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass21 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f99642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f99643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f99644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f99645d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f99646f;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$21$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99648a;

            AnonymousClass2(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99648a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(DonutChartDataCollection donutChartDataCollection, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, donutChartDataCollection, null, null, null, false, false, false, false, 0, null, 536346623, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List list, Continuation continuation) {
                List list2 = list;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    AppDistractionType appDistractionTypeA = AppDistractionType.Companion.a(((AggregatedRecord) it.next()).a());
                    if (appDistractionTypeA == null) {
                        appDistractionTypeA = AppDistractionType.Neutral;
                    }
                    Pair pairA = TuplesKt.a(appDistractionTypeA, Boxing.b(r7.d()));
                    linkedHashMap.put(pairA.e(), pairA.f());
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.size());
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    arrayList.add(new DonutChartData((float) ((Number) entry.getValue()).doubleValue(), ((AppDistractionType) entry.getKey()).m1357getColor0d7_KjU(), null));
                }
                final DonutChartDataCollection donutChartDataCollection = new DonutChartDataCollection(arrayList);
                this.f99648a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass21.AnonymousClass2.f(donutChartDataCollection, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass21(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass21(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99646f;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowS = BlockingScreenViewModel.this.b2().S(true);
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
                long timeInMillis = calendar.getTimeInMillis();
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
                long timeInMillis2 = calendar.getTimeInMillis();
                Flow flowM0 = FlowKt.m0(flowS, new BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1(null, timeInMillis, timeInMillis2));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(BlockingScreenViewModel.this);
                this.f99642a = SpillingKt.a(flowS);
                this.f99643b = SpillingKt.a(calendar);
                this.f99644c = timeInMillis;
                this.f99645d = timeInMillis2;
                this.f99646f = 1;
                if (flowM0.collect(anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass21) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$22, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$22", f = "BlockingScreenViewModel.kt", l = {468}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass22 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99654a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$22$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99656a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99656a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, z2, null, null, null, null, false, false, false, false, 0, null, 536608767, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99656a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass22.AnonymousClass1.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass22(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass22(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99654a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC3 = BlockingScreenViewModel.this.W1().c3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99654a = 1;
                if (flowC3.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass22) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$23, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$23", f = "BlockingScreenViewModel.kt", l = {480}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass23 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99657a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$23$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99659a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99659a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(StreakState streakState, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, streakState.e(), streakState.d().b(), null, 335544319, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final StreakState streakState, Continuation continuation) {
                this.f99659a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass23.AnonymousClass1.f(streakState, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass23(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass23(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99657a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowG = BlockingScreenViewModel.this.l2().g();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99657a = 1;
                if (flowG.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass23) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$3", f = "BlockingScreenViewModel.kt", l = {211}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99660a;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99660a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowQ0 = BlockingScreenViewModel.this.a2().Q0();
                final BlockingScreenViewModel blockingScreenViewModel = BlockingScreenViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.3.1
                    public final Object a(long j3, Continuation continuation) {
                        blockingScreenViewModel.F2();
                        blockingScreenViewModel.D2(false);
                        return Unit.f139807a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Number) obj2).longValue(), continuation);
                    }
                };
                this.f99660a = 1;
                if (flowQ0.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$4", f = "BlockingScreenViewModel.kt", l = {222}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99663a;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99663a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowW0 = BlockingScreenViewModel.this.Y1().w0();
                final BlockingScreenViewModel blockingScreenViewModel = BlockingScreenViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.4.1
                    public final Object a(long j3, Continuation continuation) {
                        DiscountState discountStateM = BlockingScreenViewModel.b1(blockingScreenViewModel).m();
                        if (discountStateM == null || discountStateM.c() != j3) {
                            blockingScreenViewModel.C2();
                        }
                        return Unit.f139807a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Number) obj2).longValue(), continuation);
                    }
                };
                this.f99663a = 1;
                if (flowW0.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$5", f = "BlockingScreenViewModel.kt", l = {230}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99666a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99668a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99668a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, z2, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870847, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99668a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass5.AnonymousClass1.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99666a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowR3 = BlockingScreenViewModel.this.W1().r3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99666a = 1;
                if (flowR3.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$6", f = "BlockingScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99669a;

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f99669a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BlockingScreenViewModel.this.M1();
            BlockingScreenViewModel.E2(BlockingScreenViewModel.this, false, 1, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$7", f = "BlockingScreenViewModel.kt", l = {241}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99671a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingScreenViewModel f99673a;

            AnonymousClass1(BlockingScreenViewModel blockingScreenViewModel) {
                this.f99673a = blockingScreenViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingScreenViewState f(boolean z2, BlockingScreenViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, z2, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870655, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99673a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.AnonymousClass7.AnonymousClass1.f(z2, (BlockingScreenViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass7(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99671a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowQ3 = BlockingScreenViewModel.this.W1().Q3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingScreenViewModel.this);
                this.f99671a = 1;
                if (flowQ3.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$8", f = "BlockingScreenViewModel.kt", l = {247}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99674a;

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingScreenViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99674a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowU = FlowKt.u(BlockingScreenViewModel.this.a2().d1());
                final BlockingScreenViewModel blockingScreenViewModel = BlockingScreenViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.8.1
                    public final Object a(boolean z2, Continuation continuation) {
                        blockingScreenViewModel.F2();
                        return Unit.f139807a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Boolean) obj2).booleanValue(), continuation);
                    }
                };
                this.f99674a = 1;
                if (flowU.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$9", f = "BlockingScreenViewModel.kt", l = {Function.MAX_NARGS}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function3<String, String, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f99678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f99679c;

        AnonymousClass9(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, String str2, Continuation continuation) {
            AnonymousClass9 anonymousClass9 = BlockingScreenViewModel.this.new AnonymousClass9(continuation);
            anonymousClass9.f99678b = str;
            anonymousClass9.f99679c = str2;
            return anonymousClass9.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str = (String) this.f99678b;
            String str2 = (String) this.f99679c;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99677a;
            if (i3 == 0) {
                ResultKt.b(obj);
                BlockingScreenViewModel blockingScreenViewModel = BlockingScreenViewModel.this;
                this.f99678b = SpillingKt.a(str);
                this.f99679c = SpillingKt.a(str2);
                this.f99677a = 1;
                if (blockingScreenViewModel.I2(str, str2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Profile.BlockingMode blockingMode = Profile.BlockingMode.Blocklist;
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"});
        List listEmptyList = CollectionsKt.emptyList();
        Category category = Category.HEALTH;
        Category category2 = Category.SOCIAL;
        List listListOf2 = CollectionsKt.listOf((Object[]) new Category[]{category, category2});
        ImmutableList immutableListH = ExtensionsKt.h(CollectionsKt.emptyList());
        int i3 = R.drawable.m6;
        ScheduleEmoji scheduleEmoji = ScheduleEmoji.Clock;
        ProfileViewDTO profileViewDTO = new ProfileViewDTO(0L, false, "Active, unlocked, not missing perms but with very very long title of the profile that\nspans multiple lines", blockingMode, true, false, null, false, false, false, false, listListOf, listEmptyList, listListOf2, immutableListH, Integer.valueOf(i3), "Active till 12:00", null, null, true, true, true, false, false, false, null, scheduleEmoji, false, false, false, false, null, null, null, -96075680, 3, null);
        ProfileViewDTO profileViewDTO2 = new ProfileViewDTO(10L, false, "Inactive, unlocked", blockingMode, false, false, null, false, false, false, false, CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"}), CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new Category[]{category, category2}), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(R.drawable.S4), "Start at 12:00", null, null, true, true, true, false, false, false, null, scheduleEmoji, false, false, false, false, null, null, null, -96075680, 3, null);
        List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"});
        List listEmptyList2 = CollectionsKt.emptyList();
        ImmutableList immutableListH2 = ExtensionsKt.h(CollectionsKt.emptyList());
        List listListOf4 = CollectionsKt.listOf((Object[]) new Category[]{category, category2});
        int i4 = R.drawable.Q4;
        ScheduleEmoji scheduleEmoji2 = ScheduleEmoji.Location;
        ProfileViewDTO profileViewDTO3 = new ProfileViewDTO(20L, false, "Deactivated, locked, missing perms", blockingMode, false, false, null, true, false, true, false, listListOf3, listEmptyList2, listListOf4, immutableListH2, Integer.valueOf(i4), null, "Hradec Králové", "Veverkova 1343", true, true, true, false, false, false, null, scheduleEmoji2, false, false, false, false, null, null, null, -96403360, 3, null);
        ProfileViewDTO profileViewDTO4 = new ProfileViewDTO(30L, false, "Deactivated, unlocked, not missing perms", blockingMode, false, false, null, false, false, false, false, CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"}), CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new Category[]{category, category2}), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(i4), null, "Hradec Králové", "Veverkova 1343", true, true, true, false, false, false, null, scheduleEmoji2, false, false, false, false, null, null, null, -96403360, 3, null);
        List listEmptyList3 = CollectionsKt.emptyList();
        List listEmptyList4 = CollectionsKt.emptyList();
        List listListOf5 = CollectionsKt.listOf((Object[]) new Category[]{category, category2});
        ImmutableList immutableListH3 = ExtensionsKt.h(CollectionsKt.emptyList());
        int i5 = R.drawable.P4;
        ProfileViewDTO profileViewDTO5 = new ProfileViewDTO(40L, false, "Active, unlocked, not missing perms, no apps", blockingMode, true, false, null, false, false, false, false, listEmptyList3, listEmptyList4, listListOf5, immutableListH3, Integer.valueOf(i5), null, "Hradec Králové", null, true, true, true, false, false, false, null, scheduleEmoji2, false, false, false, false, null, null, null, -96141216, 3, null);
        Profile.BlockingMode blockingMode2 = Profile.BlockingMode.Allowlist;
        List listListOf6 = CollectionsKt.listOf((Object[]) new ProfileViewDTO[]{profileViewDTO, profileViewDTO2, profileViewDTO3, profileViewDTO4, profileViewDTO5, new ProfileViewDTO(50L, false, "Multi-line profile name which is really long but wait, there is much more, Horst!", blockingMode2, true, false, null, false, false, false, false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(i5), null, "Hradec Králové", null, true, true, true, false, false, false, null, scheduleEmoji2, false, false, false, false, null, null, null, -96141216, 3, null), new ProfileViewDTO(70L, false, "Single line profile name", blockingMode, true, false, null, false, false, false, false, CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"}), CollectionsKt.emptyList(), CollectionsKt.emptyList(), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(i5), null, "Hradec Králové", null, true, true, true, false, false, false, null, scheduleEmoji2, false, false, false, false, null, null, null, -96141216, 3, null), new ProfileViewDTO(80L, false, "Disabled profile name", blockingMode, false, false, null, true, false, false, false, CollectionsKt.listOf((Object[]) new String[]{"jedno", "druhe", "treti"}), CollectionsKt.emptyList(), CollectionsKt.emptyList(), ExtensionsKt.h(CollectionsKt.emptyList()), null, null, "Disabled", null, true, true, true, false, false, false, Profile.PausedUntil.DisabledByUser.f126479b, scheduleEmoji, false, false, false, false, null, null, null, -129662880, 3, null), new ProfileViewDTO(50L, false, "Multi-line profile name which is really long but wait, there is much more, Horst!", blockingMode2, false, false, null, false, false, false, false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(i5), null, "Premium expired", null, true, true, true, false, false, false, Profile.PausedUntil.DisabledByPremium.f126478b, scheduleEmoji2, false, false, false, false, null, null, null, -129695648, 3, null)});
        V = listListOf6;
        SnapshotStateList snapshotStateListF = SnapshotStateKt.f();
        snapshotStateListF.addAll(listListOf6);
        Unit unit = Unit.f139807a;
        W = new SchedulesSectionViewState(false, snapshotStateListF);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockingScreenViewModel(Application application, boolean z2) {
        super(application, new BlockingScreenViewState(null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870911, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.f99558o = LazyKt.a(lazyThreadSafetyModeB, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.f99559p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr3, objArr4);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr5 = 0 == true ? 1 : 0;
        final Object[] objArr6 = 0 == true ? 1 : 0;
        this.f99560q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StreakPauseTracker>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakPauseTracker.class), objArr5, objArr6);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr7 = 0 == true ? 1 : 0;
        final Object[] objArr8 = 0 == true ? 1 : 0;
        this.f99561r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), objArr7, objArr8);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr9 = 0 == true ? 1 : 0;
        final Object[] objArr10 = 0 == true ? 1 : 0;
        this.f99562s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StreakDailyPresenter>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakDailyPresenter.class), objArr9, objArr10);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr11 = 0 == true ? 1 : 0;
        final Object[] objArr12 = 0 == true ? 1 : 0;
        this.f99563t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr11, objArr12);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr13 = 0 == true ? 1 : 0;
        final Object[] objArr14 = 0 == true ? 1 : 0;
        this.f99564u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr13, objArr14);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr15 = 0 == true ? 1 : 0;
        final Object[] objArr16 = 0 == true ? 1 : 0;
        this.f99565v = LazyKt.a(lazyThreadSafetyModeB8, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr15, objArr16);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr17 = 0 == true ? 1 : 0;
        final Object[] objArr18 = 0 == true ? 1 : 0;
        this.f99566w = LazyKt.a(lazyThreadSafetyModeB9, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr17, objArr18);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr19 = 0 == true ? 1 : 0;
        final Object[] objArr20 = 0 == true ? 1 : 0;
        this.f99567x = LazyKt.a(lazyThreadSafetyModeB10, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr19, objArr20);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr21 = 0 == true ? 1 : 0;
        final Object[] objArr22 = 0 == true ? 1 : 0;
        this.f99568y = LazyKt.a(lazyThreadSafetyModeB11, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr21, objArr22);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr23 = 0 == true ? 1 : 0;
        final Object[] objArr24 = 0 == true ? 1 : 0;
        this.f99569z = LazyKt.a(lazyThreadSafetyModeB12, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr23, objArr24);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr25 = 0 == true ? 1 : 0;
        final Object[] objArr26 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB13, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr25, objArr26);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr27 = 0 == true ? 1 : 0;
        final Object[] objArr28 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB14, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr27, objArr28);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr29 = 0 == true ? 1 : 0;
        final Object[] objArr30 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB15, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr29, objArr30);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB16 = koinPlatformTools.b();
        final Object[] objArr31 = 0 == true ? 1 : 0;
        final Object[] objArr32 = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB16, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr31, objArr32);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB17 = koinPlatformTools.b();
        final Object[] objArr33 = 0 == true ? 1 : 0;
        final Object[] objArr34 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB17, new Function0<BlockedNotificationDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockedNotificationDao.class), objArr33, objArr34);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB18 = koinPlatformTools.b();
        final Object[] objArr35 = 0 == true ? 1 : 0;
        final Object[] objArr36 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB18, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr35, objArr36);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB19 = koinPlatformTools.b();
        final Object[] objArr37 = 0 == true ? 1 : 0;
        final Object[] objArr38 = 0 == true ? 1 : 0;
        this.G = LazyKt.a(lazyThreadSafetyModeB19, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr37, objArr38);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB20 = koinPlatformTools.b();
        final Object[] objArr39 = 0 == true ? 1 : 0;
        final Object[] objArr40 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB20, new Function0<TrialUpsellManager>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialUpsellManager.class), objArr39, objArr40);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB21 = koinPlatformTools.b();
        final Object[] objArr41 = 0 == true ? 1 : 0;
        final Object[] objArr42 = 0 == true ? 1 : 0;
        this.I = LazyKt.a(lazyThreadSafetyModeB21, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$inject$default$21
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr41, objArr42);
            }
        });
        this.L = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(BlockingScreenViewModel.J1(this.f100043a));
            }
        });
        this.M = StateFlowKt.a(null);
        this.N = StateFlowKt.a(Boolean.FALSE);
        this.O = MutexKt.b(false, 1, null);
        final Flow flowM0 = M0();
        this.Q = new Flow<Boolean>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f99848a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2", f = "BlockingScreenViewModel.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f99849a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f99850b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f99851c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f99853f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f99854g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f99855h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f99856i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f99849a = obj;
                        this.f99850b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f99848a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:33:0x00ab A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r13
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f99850b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f99850b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r13)
                    L18:
                        java.lang.Object r13 = r0.f99849a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f99850b
                        r3 = 1
                        if (r2 == 0) goto L3a
                        if (r2 != r3) goto L32
                        java.lang.Object r12 = r0.f99855h
                        kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
                        java.lang.Object r12 = r0.f99853f
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1$2$1 r12 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r12
                        kotlin.ResultKt.b(r13)
                        goto Lac
                    L32:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L3a:
                        kotlin.ResultKt.b(r13)
                        kotlinx.coroutines.flow.FlowCollector r13 = r11.f99848a
                        r2 = r12
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState r2 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState) r2
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionViewState r2 = r2.r()
                        java.util.List r2 = r2.c()
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        boolean r4 = r2 instanceof java.util.Collection
                        r5 = 0
                        if (r4 == 0) goto L5c
                        r4 = r2
                        java.util.Collection r4 = (java.util.Collection) r4
                        boolean r4 = r4.isEmpty()
                        if (r4 == 0) goto L5c
                    L5a:
                        r2 = r5
                        goto L85
                    L5c:
                        java.util.Iterator r2 = r2.iterator()
                    L60:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L5a
                        java.lang.Object r4 = r2.next()
                        cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r4 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO) r4
                        java.lang.Long r6 = r4.M()
                        r7 = 0
                        if (r6 == 0) goto L79
                        long r9 = r6.longValue()
                        goto L7a
                    L79:
                        r9 = r7
                    L7a:
                        int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                        if (r6 > 0) goto L84
                        boolean r4 = r4.z()
                        if (r4 == 0) goto L60
                    L84:
                        r2 = r3
                    L85:
                        java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
                        r0.f99851c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f99853f = r4
                        java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
                        r0.f99854g = r12
                        java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
                        r0.f99855h = r12
                        r0.f99856i = r5
                        r0.f99850b = r3
                        java.lang.Object r12 = r13.emit(r2, r0)
                        if (r12 != r1) goto Lac
                        return r1
                    Lac:
                        kotlin.Unit r12 = kotlin.Unit.f139807a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowM0.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$minuteTickReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual("android.intent.action.TIME_TICK", intent.getAction())) {
                    BuildersKt__Builders_commonKt.d(this.f99713a.B0(), null, null, new BlockingScreenViewModel$minuteTickReceiver$1$onReceive$1(this.f99713a, null), 3, null);
                }
            }
        };
        this.R = broadcastReceiver;
        this.S = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockingScreenViewModel.K1();
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass4(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass5(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass6(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass7(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass8(null), 3, null);
        FlowKt.Q(FlowKt.m(FlowKt.u(W1().X2()), FlowKt.u(W1().t2()), new AnonymousClass9(null)), C0());
        if (BuildConfig.f95357b.booleanValue()) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new AnonymousClass10(null), 3, null);
        }
        A0().registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.TIME_TICK"));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass11(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass12(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass13(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass14(z2, this, null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass15(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass16(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass17(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass18(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass19(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass20(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass21(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass22(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass23(null), 3, null);
        L2();
    }

    private final void A2(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$stopManually$1(this, profileViewDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B2() {
        E2(this, false, 1, null);
        C2();
        F2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C2() {
        Job job = this.J;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.J = BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$updateDiscountCountDown$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2(boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$updateMissingPermissions$1(this, z2, null), 3, null);
    }

    static /* synthetic */ void E2(BlockingScreenViewModel blockingScreenViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        blockingScreenViewModel.D2(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void F2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$updateProfiles$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G2(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfilesTickers$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfilesTickers$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfilesTickers$1) r0
            int r1 = r0.f99897f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f99897f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfilesTickers$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateProfilesTickers$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f99895c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f99897f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.f99893a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.b(r6)
            goto L4a
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.O
            r0.f99893a = r6
            r2 = 0
            r0.f99894b = r2
            r0.f99897f = r3
            java.lang.Object r0 = r6.f(r4, r0)
            if (r0 != r1) goto L49
            return r1
        L49:
            r0 = r6
        L4a:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.c r6 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.c     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            r5.Q0(r6)     // Catch: java.lang.Throwable -> L5a
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L5a
            r0.i(r4)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L5a:
            r6 = move-exception
            r0.i(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.G2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState H2(BlockingScreenViewModel blockingScreenViewModel, BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List<ProfileViewDTO> listC = updateState.r().c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
        for (ProfileViewDTO profileViewDTOB : listC) {
            if (profileViewDTOB.M() != null) {
                profileViewDTOB = ProfileViewDTO.b(profileViewDTOB, 0L, false, null, null, false, false, null, false, false, false, false, null, null, null, null, null, StringHelper.s(blockingScreenViewModel.A0(), profileViewDTOB.M().longValue()), null, null, false, false, false, false, false, false, null, null, false, false, false, false, null, null, null, -65537, 3, null);
            } else if (profileViewDTOB.z()) {
                profileViewDTOB = ProfileViewDTO.b(profileViewDTOB, 0L, false, null, null, false, false, null, false, false, false, false, null, null, null, null, null, null, profileViewDTOB.l() instanceof Profile.PausedUntil.Time ? StringHelper.f128649a.j(blockingScreenViewModel.A0(), ((Profile.PausedUntil.Time) profileViewDTOB.l()).b()) : profileViewDTOB.o(), null, false, false, false, false, false, false, null, null, false, false, false, false, null, null, null, -131073, 3, null);
            }
            arrayList.add(profileViewDTOB);
        }
        return BlockingScreenViewState.b(updateState, null, null, SchedulesSectionViewState.b(updateState.r(), false, arrayList, 1, null), false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870907, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I2(final java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateSeasonalScheduleTemplate$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateSeasonalScheduleTemplate$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateSeasonalScheduleTemplate$1) r0
            int r1 = r0.f99902f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f99902f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateSeasonalScheduleTemplate$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateSeasonalScheduleTemplate$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f99900c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f99902f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f99899b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.f99898a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r7)
            goto L5f
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r7 != 0) goto L68
            int r7 = r6.length()
            if (r7 <= 0) goto L5f
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r4.W1()
            r0.f99898a = r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f99899b = r6
            r0.f99902f = r3
            java.lang.String r6 = ""
            java.lang.Object r6 = r7.P4(r6, r0)
            if (r6 != r1) goto L5f
            return r1
        L5f:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.a r6 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.a
            r6.<init>()
            r4.Q0(r6)
            goto L70
        L68:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.b r5 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.b
            r5.<init>()
            r4.Q0(r5)
        L70:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.I2(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J1(BlockingScreenViewModel blockingScreenViewModel) {
        return blockingScreenViewModel.A0().getResources().getInteger(android.R.integer.config_longAnimTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState J2(String str, BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, ScheduleTemplate.Companion.a(str), false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870783, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconCache K1() {
        return new AppIconCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState K2(BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870783, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d8, code lost:
    
        if (P0(r5, r0) == r1) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L1(boolean r13, java.lang.String r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.L1(boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$updateTrialEligibility$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        FlowExtKt.i(f2().B(), C0(), new BlockingScreenViewModel$collectQuickBlockCardState$1(this));
    }

    private final void N1(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$deleteProfile$1(this, profileViewDTO, null), 3, null);
    }

    private final void O1(ScheduleTemplate scheduleTemplate) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1(scheduleTemplate, this, null), 3, null);
    }

    private final void P1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockingScreenViewModel.Q1((BlockingScreenViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState Q1(BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 268435455, null);
    }

    private final void R1(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BlockingScreenViewModel$duplicateProfile$1(this, profileViewDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long S1() {
        return ((Number) this.L.getValue()).longValue();
    }

    private final BlockedNotificationDao U1() {
        return (BlockedNotificationDao) this.E.getValue();
    }

    private final ConsentHelper V1() {
        return (ConsentHelper) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore W1() {
        return (CoreDataStore) this.f99566w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore X1() {
        return (DevDataStore) this.f99564u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore Y1() {
        return (DiscountDataStore) this.f99565v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountRepository Z1() {
        return (DiscountRepository) this.C.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore a2() {
        return (EventDataStore) this.f99567x.getValue();
    }

    public static final /* synthetic */ BlockingScreenViewState b1(BlockingScreenViewModel blockingScreenViewModel) {
        return (BlockingScreenViewState) blockingScreenViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao b2() {
        return (IgnoredStatisticsItemDao) this.I.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobHelperKtx c2() {
        return (JobHelperKtx) this.f99558o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 d2() {
        return (PremiumRepositoryV2) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao e2() {
        return (ProfileDao) this.F.getValue();
    }

    private final QuickBlockDataStore f2() {
        return (QuickBlockDataStore) this.f99563t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository g2() {
        return (QuickBlockRepository) this.G.getValue();
    }

    private final SessionDataStore h2() {
        return (SessionDataStore) this.f99569z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakActivityTracker i2() {
        return (StreakActivityTracker) this.f99559p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakDailyPresenter j2() {
        return (StreakDailyPresenter) this.f99562s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakPauseTracker k2() {
        return (StreakPauseTracker) this.f99560q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore l2() {
        return (StreakStore) this.f99561r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore m2() {
        return (StrictModeDataStore) this.f99568y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialUpsellManager n2() {
        return (TrialUpsellManager) this.H.getValue();
    }

    private final void p2() {
        Job job = this.K;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.K = BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$handlePossibleFutureUsageLimitReset$1(this, null), 3, null);
    }

    private final void q2(QuestionnaireConfig questionnaireConfig) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onAnnouncementCardRemoved$1(questionnaireConfig, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState s2(BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, true, false, false, false, 0, null, 528482303, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.D.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingScreenViewState t2(BlockingScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingScreenViewState.b(updateState, null, null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, true, false, 0, null, 503316479, null);
    }

    private final void u2(ProfileType profileType) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new BlockingScreenViewModel$openProfileCreating$1(this, profileType, null), 3, null);
    }

    static /* synthetic */ void v2(BlockingScreenViewModel blockingScreenViewModel, ProfileType profileType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            profileType = null;
        }
        blockingScreenViewModel.u2(profileType);
    }

    private final void w2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$presentStreakIfNeeded$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(long j3) {
        G0(new BlockingScreenViewModel$resumeProfileManually$1(this, j3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b7, code lost:
    
        if (P0(r2, r6) == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y2(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$showBlockedNotificationSnackBar$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$showBlockedNotificationSnackBar$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$showBlockedNotificationSnackBar$1) r0
            int r1 = r0.f99783g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f99783g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$showBlockedNotificationSnackBar$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$showBlockedNotificationSnackBar$1
            r0.<init>(r9, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f99781d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f99783g
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4b
            if (r1 == r2) goto L43
            if (r1 != r7) goto L3b
            java.lang.Object r10 = r6.f99780c
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r6.f99779b
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r6.f99778a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r10
            kotlin.ResultKt.b(r11)
            goto Lba
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            java.lang.Object r10 = r6.f99778a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r10
            kotlin.ResultKt.b(r11)
            goto L71
        L4b:
            kotlin.ResultKt.b(r11)
            long r3 = r10.r()
            cz.mobilesoft.coreblock.util.runnability.JobHelper.k(r3)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao r1 = r9.U1()
            r11 = r2
            long r2 = r10.r()
            long r4 = r10.s()
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f99778a = r8
            r6.f99783g = r11
            java.lang.Object r11 = r1.N(r2, r4, r6)
            if (r11 != r0) goto L71
            goto Lb9
        L71:
            java.lang.String r11 = (java.lang.String) r11
            int r1 = r11.length()
            if (r1 != 0) goto L7c
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L7c:
            android.content.Context r1 = r9.A0()
            int r2 = cz.mobilesoft.coreblock.R.string.f95838r
            java.lang.String r1 = r1.getString(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "\n"
            r2.append(r1)
            r2.append(r11)
            java.lang.String r1 = r2.toString()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$ShowBlockedNotificationsSnackbar r2 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand$ShowBlockedNotificationsSnackbar
            r2.<init>(r1)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f99778a = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f99779b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r6.f99780c = r10
            r6.f99783g = r7
            java.lang.Object r10 = r9.P0(r2, r6)
            if (r10 != r0) goto Lba
        Lb9:
            return r0
        Lba:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.y2(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void z2(long j3, long j4, boolean z2) {
        AnswersHelper.f128199a.H4(Long.valueOf(j3), j4, z2);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$startManually$1(this, j3, z2, j4, null), 3, null);
    }

    public final AppIconCache T1() {
        return (AppIconCache) this.S.getValue();
    }

    public final MutableStateFlow o2() {
        return this.N;
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        try {
            A0().unregisterReceiver(this.R);
        } catch (Exception unused) {
        }
        super.onCleared();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] */
    public void O0(BlockingScreenViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnStreakBannerDismissed.f99554a)) {
            P1();
            return;
        }
        if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnStreakBannerClicked.f99553a)) {
            P1();
            AnswersHelper.f128199a.X6();
            G0(new BlockingScreenViewModel$onEvent$1(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnResumed.f99552a)) {
            G0(new BlockingScreenViewModel$onEvent$2(this, null));
            p2();
            B2();
            w2();
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (event instanceof BlockingScreenViewEvent.OnAnnouncementCardRemoved) {
            q2(((BlockingScreenViewEvent.OnAnnouncementCardRemoved) event).a());
            return;
        }
        if (!(event instanceof BlockingScreenViewEvent.OnProfileItemEvent)) {
            if (event instanceof BlockingScreenViewEvent.OnNewProfileCreated) {
                BuildersKt__Builders_commonKt.d(B0(), null, null, new BlockingScreenViewModel$onEvent$7(event, this, null), 3, null);
                return;
            }
            if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnTemplatesVisibilityChanged.f99555a)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$8(this, null), 3, null);
                return;
            }
            if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnTroubleshootingCardClicked.f99556a)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$9(this, null), 3, null);
                return;
            }
            if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnTroubleshootingCardClosed.f99557a)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$10(this, null), 3, null);
                return;
            }
            if (event instanceof BlockingScreenViewEvent.OnQuickBlockCustomTimeSet) {
                BlockingScreenViewEvent.OnQuickBlockCustomTimeSet onQuickBlockCustomTimeSet = (BlockingScreenViewEvent.OnQuickBlockCustomTimeSet) event;
                PrefManager.f126839a.s2((int) TimeUnit.MILLISECONDS.toMinutes(onQuickBlockCustomTimeSet.a()));
                Calendar calendarA = TimeHelperExt.A();
                calendarA.setTimeInMillis(calendarA.getTime().getTime() + onQuickBlockCustomTimeSet.a());
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$11(this, calendarA, null), 3, null);
                return;
            }
            if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnPremiumExpiringCardClosed.f99549a)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$12(this, null), 3, null);
                return;
            }
            if (Intrinsics.areEqual(event, BlockingScreenViewEvent.OnAutoTrialCardClosed.f99545a)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$13(this, null), 3, null);
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.s2((BlockingScreenViewState) obj);
                    }
                });
                return;
            } else {
                if (!Intrinsics.areEqual(event, BlockingScreenViewEvent.OnAutoTrialExpiredCardClosed.f99546a)) {
                    throw new NoWhenBranchMatchedException();
                }
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$15(this, null), 3, null);
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenViewModel.t2((BlockingScreenViewState) obj);
                    }
                });
                return;
            }
        }
        BlockingScreenViewEvent.OnProfileItemEvent onProfileItemEvent = (BlockingScreenViewEvent.OnProfileItemEvent) event;
        ProfileItemEvent profileItemEventA = onProfileItemEvent.a();
        if (profileItemEventA instanceof ProfileItemEvent.OnCreateProfile) {
            v2(this, null, 1, null);
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnCreateProfileWithCondition) {
            u2(((ProfileItemEvent.OnCreateProfileWithCondition) onProfileItemEvent.a()).a());
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileDeleted) {
            N1(((ProfileItemEvent.OnProfileDeleted) onProfileItemEvent.a()).a());
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileSelected) {
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileStoppedManually) {
            A2(((ProfileItemEvent.OnProfileStoppedManually) onProfileItemEvent.a()).a());
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileDuplicate) {
            R1(((ProfileItemEvent.OnProfileDuplicate) onProfileItemEvent.a()).a());
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfilePauseSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingScreenViewModel$onEvent$4(this, event, null), 3, null);
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileResumed) {
            x2(((ProfileItemEvent.OnProfileResumed) onProfileItemEvent.a()).a());
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileTemplateSelected) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new BlockingScreenViewModel$onEvent$5(this, event, null), 3, null);
            return;
        }
        if (profileItemEventA instanceof ProfileItemEvent.OnProfileSeasonalTemplateDismissed) {
            O1(((ProfileItemEvent.OnProfileSeasonalTemplateDismissed) onProfileItemEvent.a()).a());
        } else if (profileItemEventA instanceof ProfileItemEvent.OnProfileActionButtonClicked) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new BlockingScreenViewModel$onEvent$6(event, this, null), 3, null);
        } else {
            if (!(profileItemEventA instanceof ProfileItemEvent.OnProfileStartedManually)) {
                throw new NoWhenBranchMatchedException();
            }
            z2(((ProfileItemEvent.OnProfileStartedManually) onProfileItemEvent.a()).a(), ((ProfileItemEvent.OnProfileStartedManually) onProfileItemEvent.a()).b(), ((ProfileItemEvent.OnProfileStartedManually) onProfileItemEvent.a()).c());
        }
    }
}
