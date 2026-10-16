package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import android.app.Application;
import android.location.LocationManager;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivationTime;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewCommand;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DirectBootDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import cz.mobilesoft.coreblock.util.runnability.ServiceHelper;
import java.util.Set;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
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
public final class BlockingPreferencesViewModel extends BaseStatefulViewModel<BlockingPreferencesViewState, BlockingPreferencesViewEvent, BlockingPreferencesViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f108081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f108082p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f108083q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f108084r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f108085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f108086t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f108087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f108088v;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$1", f = "BlockingPreferencesViewModel.kt", l = {41}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108089a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02871<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108091a;

            C02871(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108091a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, z2, false, null, null, false, false, null, null, 4079, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108091a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass1.C02871.f(z2, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108089a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowA3 = BlockingPreferencesViewModel.this.f1().a3();
                C02871 c02871 = new C02871(BlockingPreferencesViewModel.this);
                this.f108089a = 1;
                if (flowA3.collect(c02871, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$10", f = "BlockingPreferencesViewModel.kt", l = {139}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108092a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108094a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108094a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, false, null, null, z2, false, null, null, 3839, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108094a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass10.AnonymousClass1.f(z2, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108092a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(CbYNFSEGaQj.WJoAWtEBAPiFxz);
                }
            } else {
                ResultKt.b(obj);
                Flow flowU2 = BlockingPreferencesViewModel.this.f1().u2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108092a = 1;
                if (flowU2.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$11", f = "BlockingPreferencesViewModel.kt", l = {149}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108095a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108097a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108097a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(long j3, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, false, null, null, false, false, null, StrictModeDeactivationTime.Companion.a(j3), 2047, null);
            }

            public final Object b(final long j3, Continuation continuation) {
                this.f108097a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass11.AnonymousClass1.f(j3, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).longValue(), continuation);
            }
        }

        AnonymousClass11(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108095a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowW0 = BlockingPreferencesViewModel.this.l1().w0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108095a = 1;
                if (flowW0.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$2", f = "BlockingPreferencesViewModel.kt", l = {51}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108098a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108100a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108100a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, false, null, null, false, z2, null, null, 3583, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108100a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass2.AnonymousClass1.f(z2, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108098a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowC = BlockingPreferencesViewModel.this.h1().c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108098a = 1;
                if (stateFlowC.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$3", f = "BlockingPreferencesViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108101a;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingPreferencesViewState q(boolean z2, BlockingPreferencesViewState blockingPreferencesViewState) {
            return BlockingPreferencesViewState.b(blockingPreferencesViewState, z2, false, false, false, false, false, null, null, false, false, null, null, 4094, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f108101a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean zN = BlockingPreferencesViewModel.this.t0().n();
            BlockingPreferencesViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.n0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BlockingPreferencesViewModel.AnonymousClass3.q(zN, (BlockingPreferencesViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$4", f = "BlockingPreferencesViewModel.kt", l = {70}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108103a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108105a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108105a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, z2, false, false, null, null, false, false, null, null, 4087, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108105a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.o0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass4.AnonymousClass1.f(z2, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108103a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowI0 = BlockingPreferencesViewModel.this.g1().i0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108103a = 1;
                if (flowI0.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$5", f = "BlockingPreferencesViewModel.kt", l = {80}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108106a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108108a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108108a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, z2, null, null, false, false, null, null, 4063, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108108a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass5.AnonymousClass1.f(z2, (BlockingPreferencesViewState) obj);
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
            return BlockingPreferencesViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108106a;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlowE = DeviceAdminHelper.f129458a.e();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108106a = 1;
                if (mutableStateFlowE.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$6", f = "BlockingPreferencesViewModel.kt", l = {90}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108109a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108111a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108111a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(Set set, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, false, set, null, false, false, null, null, 4031, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Set set, Continuation continuation) {
                this.f108111a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass6.AnonymousClass1.f(set, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108109a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = BlockingPreferencesViewModel.this.g1().e0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108109a = 1;
                if (flowE0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$7", f = "BlockingPreferencesViewModel.kt", l = {100}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108112a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108114a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108114a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, z2, false, false, false, false, null, null, false, false, null, null, 4093, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108114a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass7.AnonymousClass1.f(z2, (BlockingPreferencesViewState) obj);
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
            return BlockingPreferencesViewModel.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108112a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowQ3 = BlockingPreferencesViewModel.this.f1().Q3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108112a = 1;
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$8", f = "BlockingPreferencesViewModel.kt", l = {110}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108115a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108117a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108117a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState g(boolean z2, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, z2, false, false, false, null, null, false, false, null, null, 4091, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState h(Boolean bool, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, bool.booleanValue(), false, false, false, null, null, false, false, null, null, 4091, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Boolean bool, Continuation continuation) {
                if (bool == null) {
                    final boolean z2 = !ServiceHelper.g(this.f108117a.A0());
                    this.f108117a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.s0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingPreferencesViewModel.AnonymousClass8.AnonymousClass1.g(z2, (BlockingPreferencesViewState) obj);
                        }
                    });
                } else {
                    this.f108117a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.t0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingPreferencesViewModel.AnonymousClass8.AnonymousClass1.h(bool, (BlockingPreferencesViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108115a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ2 = BlockingPreferencesViewModel.this.f1().j2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108115a = 1;
                if (flowJ2.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$9", f = "BlockingPreferencesViewModel.kt", l = {129}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108118a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingPreferencesViewModel f108120a;

            AnonymousClass1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
                this.f108120a = blockingPreferencesViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingPreferencesViewState f(Set set, BlockingPreferencesViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, false, null, set, false, false, null, null, 3967, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Set set, Continuation continuation) {
                this.f108120a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.u0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingPreferencesViewModel.AnonymousClass9.AnonymousClass1.f(set, (BlockingPreferencesViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass9(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingPreferencesViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108118a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM0 = BlockingPreferencesViewModel.this.g1().m0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(BlockingPreferencesViewModel.this);
                this.f108118a = 1;
                if (flowM0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockingPreferencesViewModel(Application app) {
        super(app, new BlockingPreferencesViewState(false, false, false, false, false, false, null, null, false, false, null, null, 4095, null));
        Intrinsics.checkNotNullParameter(app, "app");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f108081o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f108082p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f108083q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f108084r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f108085s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f108086t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f108087u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<DirectBootDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DirectBootDataStore.class), objArr12, objArr13);
            }
        });
        this.f108088v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockingPreferencesViewModel.n1(this.f108215a);
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass9(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass10(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass11(null), 3, null);
    }

    public static final /* synthetic */ BlockingPreferencesViewState T0(BlockingPreferencesViewModel blockingPreferencesViewModel) {
        return (BlockingPreferencesViewState) blockingPreferencesViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore f1() {
        return (CoreDataStore) this.f108081o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore g1() {
        return (CoreMultiProcessDataStore) this.f108085s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DirectBootDataStore h1() {
        return (DirectBootDataStore) this.f108087u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore i1() {
        return (EventDataStore) this.f108086t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocationManager j1() {
        return (LocationManager) this.f108088v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao k1() {
        return (ProfileDao) this.f108083q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore l1() {
        return (StrictModeDataStore) this.f108082p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m1(boolean z2, String str, Continuation continuation) {
        if (!z2) {
            Object objP0 = P0(new BlockingPreferencesViewCommand.ShowAvailableSettingsConfirmation(str), continuation);
            return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
        }
        String string = A0().getString(StrictModeTitleAlternatives.Companion.a());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Object objP02 = P0(new BlockingPreferencesViewCommand.ShowSnackBar(string), continuation);
        return objP02 == IntrinsicsKt.f() ? objP02 : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationManager n1(BlockingPreferencesViewModel blockingPreferencesViewModel) {
        Object systemService = blockingPreferencesViewModel.A0().getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return (LocationManager) systemService;
    }

    private final void o1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onBlockPopupClicked$1(this, null), 3, null);
    }

    private final void p1() {
        BlockingPreferencesViewState blockingPreferencesViewState = (BlockingPreferencesViewState) I0();
        if (blockingPreferencesViewState.n() && blockingPreferencesViewState.e()) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onBlockUninstallClicked$1(this, null), 3, null);
            return;
        }
        if (!DeviceAdminHelper.f(A0())) {
            AnswersHelper.f128199a.I5();
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onBlockUninstallClicked$4(this, null), 3, null);
        } else {
            if (blockingPreferencesViewState.e()) {
                AnswersHelper.f128199a.G5();
                BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onBlockUninstallClicked$2(this, null), 3, null);
                return;
            }
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            answersHelper.I5();
            answersHelper.J5();
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BlockingPreferencesViewModel.q1((BlockingPreferencesViewState) obj);
                }
            });
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingPreferencesViewState q1(BlockingPreferencesViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BlockingPreferencesViewState.b(updateState, false, false, false, false, false, true, null, null, false, false, null, null, 4063, null);
    }

    private final void s1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onLocationCheckedChanged$1((BlockingPreferencesViewState) I0(), this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f108084r.getValue();
    }

    private final void t1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onPopupPermissionGiven$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
    public void O0(BlockingPreferencesViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnAvailableSettingsClicked.f108070a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnBlockPopupsClicked.f108075a)) {
            o1();
            Unit unit = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnPopupBlockingPermissionGiven.f108078a)) {
            t1();
            Unit unit2 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnBlockAppUninstallClicked.f108073a)) {
            p1();
            Unit unit3 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnLocationSwitchClicked.f108076a)) {
            s1();
            Unit unit4 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnSchedulePauseClicked.f108079a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$2(this, null), 3, null);
            return;
        }
        if (event instanceof BlockingPreferencesViewEvent.OnAvailableSettingsItemClicked) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$3(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnMindfulEditClicked.f108077a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$4(this, null), 3, null);
        } else if (event instanceof BlockingPreferencesViewEvent.OnStrictDeactivationTimeConfirm) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$5(event, this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, BlockingPreferencesViewEvent.OnBlockPhoneStartupClicked.f108074a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingPreferencesViewModel$onEvent$6(this, null), 3, null);
        }
    }
}
