package cz.mobilesoft.coreblock.storage.sharedprefs;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager$dayNightMode$4", f = "PrefManager.kt", l = {336}, m = "invokeSuspend", v = 1)
final class PrefManager$dayNightMode$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ int f126893b;

    PrefManager$dayNightMode$4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PrefManager$dayNightMode$4 prefManager$dayNightMode$4 = new PrefManager$dayNightMode$4(continuation);
        prefManager$dayNightMode$4.f126893b = ((Number) obj).intValue();
        return prefManager$dayNightMode$4;
    }

    public final Object h(int i3, Continuation continuation) {
        return ((PrefManager$dayNightMode$4) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((Number) obj).intValue(), (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3 = this.f126893b;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f126892a;
        if (i4 == 0) {
            ResultKt.b(obj);
            MutableSharedFlow mutableSharedFlowX0 = PrefManager.f126839a.x0();
            Integer numD = Boxing.d(i3);
            this.f126893b = i3;
            this.f126892a = 1;
            if (mutableSharedFlowX0.emit(numD, this) == objF) {
                return objF;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
