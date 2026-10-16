package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakStore$state$2", f = "StreakStore.kt", l = {58}, m = "invokeSuspend", v = 1)
final class StreakStore$state$2 extends SuspendLambda implements Function2<StreakStore.StateInputs, Continuation<? super StreakState>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f120590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakStore f120591c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakStore$state$2(StreakStore streakStore, Continuation continuation) {
        super(2, continuation);
        this.f120591c = streakStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakStore$state$2 streakStore$state$2 = new StreakStore$state$2(this.f120591c, continuation);
        streakStore$state$2.f120590b = obj;
        return streakStore$state$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StreakStore.StateInputs stateInputs, Continuation continuation) {
        return ((StreakStore$state$2) create(stateInputs, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StreakStore.StateInputs stateInputs = (StreakStore.StateInputs) this.f120590b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f120589a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        StreakStore streakStore = this.f120591c;
        List listA = stateInputs.a();
        boolean zB = stateInputs.b();
        this.f120590b = SpillingKt.a(stateInputs);
        this.f120589a = 1;
        Object objI = StreakStore.i(streakStore, listA, zB, 0L, null, this, 12, null);
        return objI == objF ? objF : objI;
    }
}
