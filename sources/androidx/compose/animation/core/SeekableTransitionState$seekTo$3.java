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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", l = {488}, m = "invokeSuspend")
final class SeekableTransitionState$seekTo$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f4108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f4109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SeekableTransitionState f4110d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Transition f4111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f4112g;

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", l = {510}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f4114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f4115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f4116d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ SeekableTransitionState f4117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Transition f4118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f4119h;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", f = "Transition.kt", l = {506}, m = "invokeSuspend")
        static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f4120a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SeekableTransitionState f4121b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00021(SeekableTransitionState seekableTransitionState, Continuation continuation) {
                super(2, continuation);
                this.f4121b = seekableTransitionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00021(this.f4121b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f4120a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    SeekableTransitionState seekableTransitionState = this.f4121b;
                    this.f4120a = 1;
                    if (seekableTransitionState.O(this) == objF) {
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
                return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f3, Continuation continuation) {
            super(2, continuation);
            this.f4115c = obj;
            this.f4116d = obj2;
            this.f4117f = seekableTransitionState;
            this.f4118g = transition;
            this.f4119h = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4115c, this.f4116d, this.f4117f, this.f4118g, this.f4119h, continuation);
            anonymousClass1.f4114b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f4113a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f4114b;
                if (Intrinsics.areEqual(this.f4115c, this.f4116d)) {
                    this.f4117f.f4076n = null;
                    if (Intrinsics.areEqual(this.f4117f.a(), this.f4115c)) {
                        return Unit.f139807a;
                    }
                } else {
                    this.f4117f.K();
                }
                if (!Intrinsics.areEqual(this.f4115c, this.f4116d)) {
                    this.f4118g.S(this.f4115c);
                    this.f4118g.K(0L);
                    this.f4117f.V(this.f4115c);
                    this.f4118g.G(this.f4119h);
                }
                this.f4117f.U(this.f4119h);
                if (this.f4117f.f4075m.h()) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C00021(this.f4117f, null), 3, null);
                } else {
                    this.f4117f.f4074l = Long.MIN_VALUE;
                }
                SeekableTransitionState seekableTransitionState = this.f4117f;
                this.f4113a = 1;
                if (seekableTransitionState.Z(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.f4117f.R();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$seekTo$3(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f3, Continuation continuation) {
        super(1, continuation);
        this.f4108b = obj;
        this.f4109c = obj2;
        this.f4110d = seekableTransitionState;
        this.f4111f = transition;
        this.f4112g = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SeekableTransitionState$seekTo$3(this.f4108b, this.f4109c, this.f4110d, this.f4111f, this.f4112g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4107a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4108b, this.f4109c, this.f4110d, this.f4111f, this.f4112g, null);
            this.f4107a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
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
        return ((SeekableTransitionState$seekTo$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
