package cz.mobilesoft.coreblock.scene.more.backup.progress;

import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$collectProgressStateWaitingFlow$1", f = "BackupProgressViewModel.kt", l = {238}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$collectProgressStateWaitingFlow$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BackupProgressViewModel f106486b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$collectProgressStateWaitingFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$collectProgressStateWaitingFlow$1$1", f = "BackupProgressViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<ViewModelState, Float, Continuation<? super ViewModelState>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f106487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f106488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ float f106489c;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        public final Object h(ViewModelState viewModelState, float f3, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f106488b = viewModelState;
            anonymousClass1.f106489c = f3;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((ViewModelState) obj, ((Number) obj2).floatValue(), (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ViewModelState viewModelState = (ViewModelState) this.f106488b;
            float f3 = this.f106489c;
            IntrinsicsKt.f();
            if (this.f106487a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!Intrinsics.areEqual(viewModelState, Success.f128020a) || f3 == 1.0f) {
                return viewModelState;
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$collectProgressStateWaitingFlow$1(BackupProgressViewModel backupProgressViewModel, Continuation continuation) {
        super(1, continuation);
        this.f106486b = backupProgressViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BackupProgressViewModel$collectProgressStateWaitingFlow$1(this.f106486b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f106485a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowJ = FlowKt.J(this.f106486b.f106479m, this.f106486b.W0(), new AnonymousClass1(null));
            final BackupProgressViewModel backupProgressViewModel = this.f106486b;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$collectProgressStateWaitingFlow$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(ViewModelState viewModelState, Continuation continuation) {
                    Object objEmit;
                    return (viewModelState == null || (objEmit = backupProgressViewModel.X0().emit(viewModelState, continuation)) != IntrinsicsKt.f()) ? Unit.f139807a : objEmit;
                }
            };
            this.f106485a = 1;
            if (flowJ.collect(flowCollector, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BackupProgressViewModel$collectProgressStateWaitingFlow$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
