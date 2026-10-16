package cz.mobilesoft.coreblock.storage.sharedprefs;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$blockingScreenMessage$4", f = "PrefManager.kt", l = {347}, m = "invokeSuspend", v = 1)
final class PrefManager$blockingScreenMessage$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f126891b;

    PrefManager$blockingScreenMessage$4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PrefManager$blockingScreenMessage$4 prefManager$blockingScreenMessage$4 = new PrefManager$blockingScreenMessage$4(continuation);
        prefManager$blockingScreenMessage$4.f126891b = obj;
        return prefManager$blockingScreenMessage$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = (String) this.f126891b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126890a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableSharedFlow mutableSharedFlowS0 = PrefManager.f126839a.s0();
            this.f126891b = SpillingKt.a(str);
            this.f126890a = 1;
            if (mutableSharedFlowS0.emit(str, this) == objF) {
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
    public final Object invoke(String str, Continuation continuation) {
        return ((PrefManager$blockingScreenMessage$4) create(str, continuation)).invokeSuspend(Unit.f139807a);
    }
}
