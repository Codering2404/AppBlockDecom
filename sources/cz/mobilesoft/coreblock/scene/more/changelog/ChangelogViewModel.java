package cz.mobilesoft.coreblock.scene.more.changelog;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.AppVersionRepository;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewEvent;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewModel;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class ChangelogViewModel extends BaseStatefulViewModel<ChangelogViewState, ChangelogViewEvent, ChangelogViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f106957o;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewModel$1", f = "ChangelogViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106958a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ChangelogViewState q(List list, PremiumState premiumState, ChangelogViewState changelogViewState) {
            return changelogViewState.a(false, list, SetsKt.setOf(CollectionsKt.first(list)), premiumState);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ChangelogViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f106958a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final List listO = AppVersionRepository.f97355a.o();
            final PremiumState premiumStateJ = ChangelogViewModel.this.U0().J();
            ChangelogViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ChangelogViewModel.AnonymousClass1.q(listO, premiumStateJ, (ChangelogViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChangelogViewModel(Application application) {
        super(application, new ChangelogViewState(false, null, null, null, 15, null));
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106957o = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewModel$special$$inlined$inject$default$1
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
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 U0() {
        return (PremiumRepositoryV2) this.f106957o.getValue();
    }

    private final void W0(final ChangelogVersionItem changelogVersionItem) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChangelogViewModel.X0(changelogVersionItem, (ChangelogViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangelogViewState X0(ChangelogVersionItem changelogVersionItem, ChangelogViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.c());
        if (mutableSet.remove(changelogVersionItem)) {
            AnswersHelper.f128199a.n1();
        } else {
            AnswersHelper.f128199a.o1();
            mutableSet.add(changelogVersionItem);
        }
        Unit unit = Unit.f139807a;
        return ChangelogViewState.b(updateState, false, null, mutableSet, null, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public void O0(ChangelogViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof ChangelogViewEvent.OnItemClicked)) {
            throw new NoWhenBranchMatchedException();
        }
        W0(((ChangelogViewEvent.OnItemClicked) event).a());
    }
}
