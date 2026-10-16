package cz.mobilesoft.coreblock.scene.intro.stats;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1", f = "StatsExplanation3Screen.kt", l = {106}, m = "invokeSuspend", v = 1)
final class ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f104914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f104915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f104916d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f104917f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1(float f3, long j3, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f104914b = f3;
        this.f104915c = j3;
        this.f104916d = mutableState;
        this.f104917f = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1(this.f104914b, this.f104915c, this.f104916d, this.f104917f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104913a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f104913a = 1;
            if (DelayKt.b(500L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        ComposableSingletons$StatsExplanation3ScreenKt.s(this.f104916d, this.f104914b * 0.4f);
        ComposableSingletons$StatsExplanation3ScreenKt.u(this.f104917f, this.f104915c);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
