package cz.mobilesoft.coreblock.scene.dev_events;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewEvent;
import cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewModel;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

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
public final class DevEventsViewModel extends BaseStatefulViewModel<DevEventsViewState, DevEventsViewEvent, DevEventsViewCommand> {

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewModel$1", f = "DevEventsViewModel.kt", l = {17}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101662a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02761<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DevEventsViewModel f101664a;

            C02761(DevEventsViewModel devEventsViewModel) {
                this.f101664a = devEventsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DevEventsViewState f(List list, DevEventsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DevEventsViewState.b(updateState, list, false, 2, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List list, Continuation continuation) {
                this.f101664a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DevEventsViewModel.AnonymousClass1.C02761.f(list, (DevEventsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DevEventsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101662a;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlowR = AnswersHelper.f128199a.r();
                C02761 c02761 = new C02761(DevEventsViewModel.this);
                this.f101662a = 1;
                if (mutableStateFlowR.collect(c02761, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevEventsViewModel(Application application) {
        super(application, new DevEventsViewState(null, false, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        G0(new AnonymousClass1(null));
    }

    private final void V0() {
        ContextExtKt.a(A0(), "Events", CollectionsKt.joinToString$default(((DevEventsViewState) I0()).c(), "\n", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevEventsViewModel.W0((AnswersHelper.Event) obj);
            }
        }, 30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence W0(AnswersHelper.Event it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    private final void X0(AnswersHelper.Event event) {
        ContextExtKt.a(A0(), "Event", event.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DevEventsViewState Z0(DevEventsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DevEventsViewState.b(updateState, null, true, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DevEventsViewState a1(DevEventsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DevEventsViewState.b(updateState, null, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void O0(DevEventsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, DevEventsViewEvent.ShowConfirmRow.f101661a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DevEventsViewModel.Z0((DevEventsViewState) obj);
                }
            });
            return;
        }
        if (event instanceof DevEventsViewEvent.OnConfirmRowButtonClicked) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DevEventsViewModel.a1((DevEventsViewState) obj);
                }
            });
            if (((DevEventsViewEvent.OnConfirmRowButtonClicked) event).a()) {
                AnswersHelper.f128199a.q();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, DevEventsViewEvent.CopyEventsToClipboard.f101659a)) {
            V0();
        } else {
            if (!(event instanceof DevEventsViewEvent.CopyEventToClipboard)) {
                throw new NoWhenBranchMatchedException();
            }
            X0(((DevEventsViewEvent.CopyEventToClipboard) event).a());
        }
    }
}
