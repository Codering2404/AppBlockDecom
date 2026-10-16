package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlinx.coroutines.Job;
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
public final class BlockingModeSettingsViewModel extends BaseStatefulViewModel<BlockingModeSettingsViewState, BlockingModeSettingsViewEvent, BlockingModeSettingsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f115061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Job f115062p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$1", f = "BlockingModeSettingsViewModel.kt", l = {29}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115063a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02991<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BlockingModeSettingsViewModel f115065a;

            C02991(BlockingModeSettingsViewModel blockingModeSettingsViewModel) {
                this.f115065a = blockingModeSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final BlockingModeSettingsViewState f(PremiumState premiumState, BlockingModeSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return BlockingModeSettingsViewState.b(updateState, null, false, false, null, premiumState, false, null, 111, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f115065a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingModeSettingsViewModel.AnonymousClass1.C02991.f(premiumState, (BlockingModeSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BlockingModeSettingsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115063a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = BlockingModeSettingsViewModel.this.W0().K();
                C02991 c02991 = new C02991(BlockingModeSettingsViewModel.this);
                this.f115063a = 1;
                if (stateFlowK.collect(c02991, this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockingModeSettingsViewModel(Application application, ProfileType profileType, boolean z2, Profile.BlockingMode selectedBlockingMode) {
        super(application, new BlockingModeSettingsViewState(null, false, false, selectedBlockingMode, null, z2, profileType, 23, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(selectedBlockingMode, "selectedBlockingMode");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f115061o = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewModel$special$$inlined$inject$default$1
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        Z0();
    }

    public static final /* synthetic */ BlockingModeSettingsViewState S0(BlockingModeSettingsViewModel blockingModeSettingsViewModel) {
        return (BlockingModeSettingsViewState) blockingModeSettingsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 W0() {
        return (PremiumRepositoryV2) this.f115061o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockingModeSettingsViewState Y0(BlockingModeSettingsViewEvent blockingModeSettingsViewEvent, BlockingModeSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List listH = updateState.h();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listH, 10));
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            ((Boolean) it.next()).getClass();
            arrayList.add(Boolean.FALSE);
        }
        return BlockingModeSettingsViewState.b(updateState, arrayList, true, false, ((BlockingModeSettingsViewEvent.OnBlockingModeClicked) blockingModeSettingsViewEvent).a(), null, false, null, 112, null);
    }

    private final void Z0() {
        this.f115062p = BuildersKt__Builders_commonKt.d(B0(), null, null, new BlockingModeSettingsViewModel$startAnimation$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public void O0(final BlockingModeSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, BlockingModeSettingsViewEvent.OnContinueClicked.f115060a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BlockingModeSettingsViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (!(event instanceof BlockingModeSettingsViewEvent.OnBlockingModeClicked)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!((BlockingModeSettingsViewState) I0()).f().g() && ((BlockingModeSettingsViewEvent.OnBlockingModeClicked) event).a() == Profile.BlockingMode.Allowlist) {
            G0(new BlockingModeSettingsViewModel$onEvent$2(this, null));
        } else if (((BlockingModeSettingsViewState) I0()).c() || ((BlockingModeSettingsViewEvent.OnBlockingModeClicked) event).a() != Profile.BlockingMode.Allowlist) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BlockingModeSettingsViewModel.Y0(event, (BlockingModeSettingsViewState) obj);
                }
            });
        } else {
            G0(new BlockingModeSettingsViewModel$onEvent$3(this, null));
        }
        Job job = this.f115062p;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        Z0();
    }
}
