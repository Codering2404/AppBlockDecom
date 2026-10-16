package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", l = {457}, m = "invokeSuspend")
final class SeekableTransitionState$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SeekableTransitionState f4123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f4124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Transition f4125d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$snapTo$2(SeekableTransitionState seekableTransitionState, Object obj, Transition transition, Continuation continuation) {
        super(1, continuation);
        this.f4123b = seekableTransitionState;
        this.f4124c = obj;
        this.f4125d = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SeekableTransitionState$snapTo$2(this.f4123b, this.f4124c, this.f4125d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4122a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f4123b.E();
            this.f4123b.f4074l = Long.MIN_VALUE;
            this.f4123b.U(0.0f);
            Object obj2 = this.f4124c;
            float f3 = Intrinsics.areEqual(obj2, this.f4123b.a()) ? -4.0f : Intrinsics.areEqual(obj2, this.f4123b.b()) ? -5.0f : -3.0f;
            this.f4125d.S(this.f4124c);
            this.f4125d.K(0L);
            this.f4123b.V(this.f4124c);
            this.f4123b.U(0.0f);
            this.f4123b.d(this.f4124c);
            this.f4125d.G(f3);
            if (f3 == -3.0f) {
                SeekableTransitionState seekableTransitionState = this.f4123b;
                this.f4122a = 1;
                if (seekableTransitionState.Z(this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f4125d.B();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SeekableTransitionState$snapTo$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
