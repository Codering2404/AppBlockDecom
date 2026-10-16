package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", f = "PullRefreshState.kt", l = {187}, m = "invokeSuspend")
final class PullRefreshState$animateIndicatorTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PullRefreshState f15301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f15302c;

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1", f = "PullRefreshState.kt", l = {188}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PullRefreshState f15304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f15305c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PullRefreshState pullRefreshState, float f3, Continuation continuation) {
            super(1, continuation);
            this.f15304b = pullRefreshState;
            this.f15305c = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f15304b, this.f15305c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f15303a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(YvFRmou.cltbYJ);
                }
            } else {
                ResultKt.b(obj);
                float fM = this.f15304b.m();
                float f3 = this.f15305c;
                final PullRefreshState pullRefreshState = this.f15304b;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState.animateIndicatorTo.1.1.1
                    {
                        super(2);
                    }

                    public final void c(float f4, float f5) {
                        pullRefreshState.w(f4);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.f139807a;
                    }
                };
                this.f15303a = 1;
                if (SuspendAnimationKt.e(fM, f3, 0.0f, null, function2, this, 12, null) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullRefreshState$animateIndicatorTo$1(PullRefreshState pullRefreshState, float f3, Continuation continuation) {
        super(2, continuation);
        this.f15301b = pullRefreshState;
        this.f15302c = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PullRefreshState$animateIndicatorTo$1(this.f15301b, this.f15302c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f15300a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutatorMutex mutatorMutex = this.f15301b.f15298i;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f15301b, this.f15302c, null);
            this.f15300a = 1;
            if (MutatorMutex.e(mutatorMutex, null, anonymousClass1, this, 1, null) == objF) {
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
        return ((PullRefreshState$animateIndicatorTo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
