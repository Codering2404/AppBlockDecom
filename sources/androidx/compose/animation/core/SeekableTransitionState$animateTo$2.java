package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", l = {599}, m = "invokeSuspend")
final class SeekableTransitionState$animateTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Transition f4090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SeekableTransitionState f4091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f4092d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f4093f;

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", l = {2147, 612, 614, 668, 670}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f4094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f4095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SeekableTransitionState f4097d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f4098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Transition f4099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ FiniteAnimationSpec f4100h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SeekableTransitionState seekableTransitionState, Object obj, Transition transition, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation) {
            super(2, continuation);
            this.f4097d = seekableTransitionState;
            this.f4098f = obj;
            this.f4099g = transition;
            this.f4100h = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f4097d, this.f4098f, this.f4099g, this.f4100h, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x01e8, code lost:
        
            if (r2.Y(r18) != r0) goto L76;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 504
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState$animateTo$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$animateTo$2(Transition transition, SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation) {
        super(1, continuation);
        this.f4090b = transition;
        this.f4091c = seekableTransitionState;
        this.f4092d = obj;
        this.f4093f = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SeekableTransitionState$animateTo$2(this.f4090b, this.f4091c, this.f4092d, this.f4093f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4089a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4091c, this.f4092d, this.f4090b, this.f4093f, null);
            this.f4089a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f4090b.B();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SeekableTransitionState$animateTo$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
