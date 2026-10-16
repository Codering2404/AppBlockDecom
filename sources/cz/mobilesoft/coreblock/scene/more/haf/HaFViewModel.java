package cz.mobilesoft.coreblock.scene.more.haf;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.CategoryDTO;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
import cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper;
import cz.mobilesoft.coreblock.scene.more.haf.HaFViewEvent;
import cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class HaFViewModel extends BaseStatefulViewModel<HaFViewState, HaFViewEvent, HaFViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private QuestionDTO f107602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f107603p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$1", f = "HaFViewModel.kt", l = {29}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f107604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f107605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f107606c;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HaFViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107606c;
            if (i3 == 0) {
                ResultKt.b(obj);
                QuestionDTO questionDTOB1 = HaFViewModel.this.b1();
                if (questionDTOB1 != null) {
                    AnswersHelper answersHelper = AnswersHelper.f128199a;
                    int iA = questionDTOB1.a();
                    String strB = questionDTOB1.b();
                    if (strB.length() <= 0) {
                        strB = null;
                    }
                    if (strB == null) {
                        strB = questionDTOB1.c();
                    }
                    answersHelper.O1(iA, strB);
                }
                QuestionDTO questionDTOB12 = HaFViewModel.this.b1();
                HaFRequestHelper haFRequestHelper = HaFRequestHelper.f107559a;
                Integer numD = questionDTOB12 != null ? Boxing.d(questionDTOB12.a()) : null;
                this.f107604a = SpillingKt.a(questionDTOB12);
                this.f107605b = 0;
                this.f107606c = 1;
                if (haFRequestHelper.f(numD, true, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$2", f = "HaFViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f107609b;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HaFViewState q(boolean z2, HaFViewState haFViewState) {
            return HaFViewState.b(haFViewState, null, null, null, null, null, false, null, null, null, null, false, z2, 2047, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = HaFViewModel.this.new AnonymousClass2(continuation);
            anonymousClass2.f107609b = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final boolean z2 = this.f107609b;
            IntrinsicsKt.f();
            if (this.f107608a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            HaFViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.d1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return HaFViewModel.AnonymousClass2.q(z2, (HaFViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        public final Object invoke(boolean z2, Continuation continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$3", f = "HaFViewModel.kt", l = {44}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107611a;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107611a;
            if (i3 == 0) {
                ResultKt.b(obj);
                HaFRequestHelper haFRequestHelper = HaFRequestHelper.f107559a;
                if (((HaFRequestHelper.HafState) haFRequestHelper.i().getValue()).c().isEmpty()) {
                    this.f107611a = 1;
                    if (haFRequestHelper.e(this) == objF) {
                        return objF;
                    }
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$4", f = "HaFViewModel.kt", l = {49}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107612a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ HaFViewModel f107614a;

            AnonymousClass1(HaFViewModel haFViewModel) {
                this.f107614a = haFViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final HaFViewState f(HaFRequestHelper.HafState hafState, HaFViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return HaFViewState.b(updateState, hafState.c(), hafState.h(), null, hafState.d(), null, false, null, hafState.g(), hafState.f(), hafState.e(), false, false, 3188, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final HaFRequestHelper.HafState hafState, Continuation continuation) {
                this.f107614a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFViewModel.AnonymousClass4.AnonymousClass1.f(hafState, (HaFViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HaFViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107612a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowI = HaFRequestHelper.f107559a.i();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(HaFViewModel.this);
                this.f107612a = 1;
                if (stateFlowI.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HaFViewModel(Application application, QuestionDTO questionDTO) {
        super(application, new HaFViewState(null, null, null, null, null, false, null, null, null, null, false, false, 4095, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f107602o = questionDTO;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107603p = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$special$$inlined$inject$default$1
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
        if (this.f107602o != null) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        }
        FlowKt.Q(FlowKt.V(a1().y3(), new AnonymousClass2(null)), C0());
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass4(null), 3, null);
    }

    private final void X0() {
        this.f107602o = null;
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HaFViewModel.Y0((HaFViewState) obj);
            }
        });
        HaFRequestHelper.f107559a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewState Y0(HaFViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return HaFViewState.b(updateState, null, null, null, null, null, false, "", null, null, null, false, false, 4031, null);
    }

    private final void Z0(QuestionDTO questionDTO, QuestionDTO questionDTO2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new HaFViewModel$fetchAndUpdateQuestion$1(this, questionDTO, questionDTO2, null), 3, null);
    }

    private final CoreDataStore a1() {
        return (CoreDataStore) this.f107603p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewState d1(HaFViewEvent haFViewEvent, HaFViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return HaFViewState.b(updateState, null, null, ((HaFViewEvent.OnCategorySelected) haFViewEvent).a(), null, null, true, null, null, null, null, false, false, 3547, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewState e1(HaFViewEvent haFViewEvent, HaFViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return HaFViewState.b(updateState, null, null, null, null, null, false, ((HaFViewEvent.OnSearchQueryChanged) haFViewEvent).a(), null, null, null, false, false, 4031, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewState f1(HaFViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return HaFViewState.b(updateState, null, null, null, null, null, false, null, null, null, null, false, false, 3967, null);
    }

    private final void g1() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new HaFViewModel$resetPreselectedQuestion$1(null), 3, null);
    }

    private final void h1(String str) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new HaFViewModel$searchQuestions$1(str, null), 3, null);
    }

    public final QuestionDTO b1() {
        return this.f107602o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void O0(final HaFViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof HaFViewEvent.OnCategorySelected) {
            CategoryDTO categoryDTOA = ((HaFViewEvent.OnCategorySelected) event).a();
            if (categoryDTOA != null) {
                AnswersHelper.f128199a.M1(categoryDTOA.a(), categoryDTOA.b());
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.z0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HaFViewModel.d1(event, (HaFViewState) obj);
                }
            });
            HaFRequestHelper.f107559a.k();
            return;
        }
        if (event instanceof HaFViewEvent.OnQuestionSelected) {
            HaFViewEvent.OnQuestionSelected onQuestionSelected = (HaFViewEvent.OnQuestionSelected) event;
            QuestionDTO questionDTOB = onQuestionSelected.b();
            if (questionDTOB != null) {
                AnswersHelper answersHelper = AnswersHelper.f128199a;
                int iA = questionDTOB.a();
                String strB = questionDTOB.b();
                String strC = strB.length() > 0 ? strB : null;
                if (strC == null) {
                    strC = questionDTOB.c();
                }
                answersHelper.O1(iA, strC);
            }
            Z0(onQuestionSelected.b(), onQuestionSelected.a());
            return;
        }
        if (Intrinsics.areEqual(event, HaFViewEvent.OnRetryClicked.f107600a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new HaFViewModel$onEvent$4(null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, HaFViewEvent.OnContactSupportClicked.f107596a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new HaFViewModel$onEvent$5(this, null), 3, null);
            return;
        }
        if (event instanceof HaFViewEvent.OnSearchQueryChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.a1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HaFViewModel.e1(event, (HaFViewState) obj);
                }
            });
            HaFViewEvent.OnSearchQueryChanged onSearchQueryChanged = (HaFViewEvent.OnSearchQueryChanged) event;
            if (onSearchQueryChanged.a().length() > 2) {
                h1(onSearchQueryChanged.a());
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.b1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFViewModel.f1((HaFViewState) obj);
                    }
                });
                return;
            }
        }
        if (Intrinsics.areEqual(event, HaFViewEvent.ClearSearchQuery.f107593a)) {
            X0();
        } else {
            if (!Intrinsics.areEqual(event, HaFViewEvent.OnResetPresetQuestion.f107599a)) {
                throw new NoWhenBranchMatchedException();
            }
            g1();
        }
    }
}
