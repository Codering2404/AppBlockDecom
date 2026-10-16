package cz.mobilesoft.coreblock.scene.more.notifications;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewEvent;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
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
public final class BlockedNotificationsViewModel extends BaseStatefulViewModel<BlockedNotificationsViewState, BlockedNotificationsViewEvent, BlockedNotificationsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f107864o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f107865p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f107866q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Flow f107867r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$1", f = "BlockedNotificationsViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107868a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02851<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockedNotificationsViewModel f107870a;

            C02851(BlockedNotificationsViewModel blockedNotificationsViewModel) {
                this.f107870a = blockedNotificationsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockedNotificationsViewState f(boolean z2, BlockedNotificationsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockedNotificationsViewState.b(updateState, z2, null, 2, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(PremiumState premiumState, Continuation continuation) {
                BlockedNotificationsViewState blockedNotificationsViewStateT0 = BlockedNotificationsViewModel.T0(this.f107870a);
                final boolean zF = premiumState.f(Product.NOTIFICATIONS);
                if (blockedNotificationsViewStateT0.d() != zF) {
                    this.f107870a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.a0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockedNotificationsViewModel.AnonymousClass1.C02851.f(zF, (BlockedNotificationsViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockedNotificationsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107868a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = BlockedNotificationsViewModel.this.b1().K();
                C02851 c02851 = new C02851(BlockedNotificationsViewModel.this);
                this.f107868a = 1;
                if (stateFlowK.collect(c02851, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$2", f = "BlockedNotificationsViewModel.kt", l = {46}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107871a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockedNotificationsViewModel f107873a;

            AnonymousClass1(BlockedNotificationsViewModel blockedNotificationsViewModel) {
                this.f107873a = blockedNotificationsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockedNotificationsViewState f(List list, BlockedNotificationsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockedNotificationsViewState.b(updateState, false, ExtensionsKt.h(list), 1, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List list, Continuation continuation) {
                this.f107873a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockedNotificationsViewModel.AnonymousClass2.AnonymousClass1.f(list, (BlockedNotificationsViewState) obj);
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
            return BlockedNotificationsViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107871a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowL = BlockedNotificationsViewModel.this.Z0().L(Limit.NOTIFICATION_LIMIT.getLimitValue());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockedNotificationsViewModel.this);
                this.f107871a = 1;
                if (flowL.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockedNotificationsViewModel(Application application) {
        super(application, new BlockedNotificationsViewState(false, null, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107864o = LazyKt.a(lazyThreadSafetyModeB, new Function0<BlockedNotificationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockedNotificationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f107865p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        this.f107866q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockedNotificationsViewModel.X0();
            }
        });
        this.f107867r = CachedPagingDataKt.a(new Pager(new PagingConfig(20, 0, false, 0, 0, 0, 62, null), null, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockedNotificationsViewModel.d1(this.f107960a);
            }
        }, 2, null).a(), ViewModelKt.a(this));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
    }

    public static final /* synthetic */ BlockedNotificationsViewState T0(BlockedNotificationsViewModel blockedNotificationsViewModel) {
        return (BlockedNotificationsViewState) blockedNotificationsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconCache X0() {
        return new AppIconCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockedNotificationDao Z0() {
        return (BlockedNotificationDao) this.f107864o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 b1() {
        return (PremiumRepositoryV2) this.f107865p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource d1(BlockedNotificationsViewModel blockedNotificationsViewModel) {
        return blockedNotificationsViewModel.Z0().M();
    }

    public final AppIconCache Y0() {
        return (AppIconCache) this.f107866q.getValue();
    }

    public final Flow a1() {
        return this.f107867r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void O0(BlockedNotificationsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!Intrinsics.areEqual(event, BlockedNotificationsViewEvent.OnClearConfirmed.f107863a)) {
            throw new NoWhenBranchMatchedException();
        }
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockedNotificationsViewModel$onEvent$1(this, null), 3, null);
    }
}
