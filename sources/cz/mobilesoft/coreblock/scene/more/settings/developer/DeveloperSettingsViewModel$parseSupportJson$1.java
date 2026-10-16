package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$parseSupportJson$1;
import cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$parseSupportJson$1", f = "DeveloperSettingsViewModel.kt", l = {1369}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$parseSupportJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f108899c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$parseSupportJson$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeveloperSettingsViewModel f108900a;

        AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
            this.f108900a = developerSettingsViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DeveloperSettingsViewState h(DeveloperSettingsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, true, null, -1, 393215, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DeveloperSettingsViewState i(DeveloperSettingsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 393215, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DeveloperSettingsViewState j(DeveloperSettingsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 393215, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final Object emit(DataState dataState, Continuation continuation) {
            String message;
            if (dataState instanceof DataState.Loading) {
                this.f108900a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel$parseSupportJson$1.AnonymousClass1.h((DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
            if (dataState instanceof DataState.Success) {
                this.f108900a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel$parseSupportJson$1.AnonymousClass1.i((DeveloperSettingsViewState) obj);
                    }
                });
                Object objP0 = this.f108900a.P0(new DeveloperSettingsViewCommand.ShowToast("JSON parsed successfully"), continuation);
                return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
            }
            if (!(dataState instanceof DataState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f108900a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel$parseSupportJson$1.AnonymousClass1.j((DeveloperSettingsViewState) obj);
                }
            });
            DeveloperSettingsViewModel developerSettingsViewModel = this.f108900a;
            Throwable thC = ((DataState.Error) dataState).c();
            if (thC == null || (message = thC.getMessage()) == null) {
                message = "Error parsing JSON";
            }
            Object objP02 = developerSettingsViewModel.P0(new DeveloperSettingsViewCommand.ShowToast(message), continuation);
            return objP02 == IntrinsicsKt.f() ? objP02 : Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$parseSupportJson$1(DeveloperSettingsViewModel developerSettingsViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f108898b = developerSettingsViewModel;
        this.f108899c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$parseSupportJson$1(this.f108898b, this.f108899c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108897a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowD = this.f108898b.A2().D(new SupportJsonParseUseCase.Params(this.f108899c));
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f108898b);
            this.f108897a = 1;
            if (flowD.collect(anonymousClass1, this) == objF) {
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
        return ((DeveloperSettingsViewModel$parseSupportJson$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
