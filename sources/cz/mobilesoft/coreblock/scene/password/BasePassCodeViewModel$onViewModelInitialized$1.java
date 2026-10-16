package cz.mobilesoft.coreblock.scene.password;

import cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onViewModelInitialized$1;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onViewModelInitialized$1", f = "BasePassCodeViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class BasePassCodeViewModel$onViewModelInitialized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BasePassCodeViewModel f111656b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onViewModelInitialized$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BasePassCodeViewModel f111657a;

        AnonymousClass1(BasePassCodeViewModel basePassCodeViewModel) {
            this.f111657a = basePassCodeViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PassCodeViewState f(int i3, PassCodeViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return PassCodeViewState.b(updateState, null, null, null, false, i3, 0L, null, 111, null);
        }

        public final Object b(final int i3, Continuation continuation) {
            this.f111657a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.password.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BasePassCodeViewModel$onViewModelInitialized$1.AnonymousClass1.f(i3, (PassCodeViewState) obj);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return b(((Number) obj).intValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePassCodeViewModel$onViewModelInitialized$1(BasePassCodeViewModel basePassCodeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f111656b = basePassCodeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasePassCodeViewModel$onViewModelInitialized$1(this.f111656b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f111655a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        FlowExtKt.i(this.f111656b.i1(), this.f111656b.C0(), new AnonymousClass1(this.f111656b));
        Flow flowH1 = this.f111656b.h1();
        CoroutineScope coroutineScopeC0 = this.f111656b.C0();
        final BasePassCodeViewModel basePassCodeViewModel = this.f111656b;
        FlowExtKt.i(flowH1, coroutineScopeC0, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onViewModelInitialized$1.2
            public final Object a(long j3, Continuation continuation) {
                basePassCodeViewModel.v1(j3);
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                return a(((Number) obj2).longValue(), continuation);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BasePassCodeViewModel$onViewModelInitialized$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
