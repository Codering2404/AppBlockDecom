package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeDeactivation;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onEvent$8", f = "StrictMode3ViewModel.kt", l = {509}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onEvent$8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewEvent f121340c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onEvent$8(StrictMode3ViewModel strictMode3ViewModel, StrictMode3ViewEvent strictMode3ViewEvent, Continuation continuation) {
        super(1, continuation);
        this.f121339b = strictMode3ViewModel;
        this.f121340c = strictMode3ViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StrictMode3ViewModel$onEvent$8(this.f121339b, this.f121340c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121338a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StrictMode3ViewModel strictMode3ViewModel = this.f121339b;
            boolean z2 = ((StrictMode3ViewEvent.OnStrictModeDeactivation) this.f121340c).a() == StrictModeDeactivation.Pause;
            this.f121338a = 1;
            if (strictMode3ViewModel.w2(z2, this) == objF) {
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
        return ((StrictMode3ViewModel$onEvent$8) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
