package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$animateScrollToPage$3", f = "PagerState.kt", l = {619}, m = "invokeSuspend")
final class PagerState$animateScrollToPage$3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f8875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagerState f8876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f8877d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f8878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f8879g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$animateScrollToPage$3(PagerState pagerState, int i3, float f3, AnimationSpec animationSpec, Continuation continuation) {
        super(2, continuation);
        this.f8876c = pagerState;
        this.f8877d = i3;
        this.f8878f = f3;
        this.f8879g = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PagerState$animateScrollToPage$3 pagerState$animateScrollToPage$3 = new PagerState$animateScrollToPage$3(this.f8876c, this.f8877d, this.f8878f, this.f8879g, continuation);
        pagerState$animateScrollToPage$3.f8875b = obj;
        return pagerState$animateScrollToPage$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
        return ((PagerState$animateScrollToPage$3) create(scrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f8874a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LazyLayoutScrollScope lazyLayoutScrollScopeA = PagerScrollScopeKt.a(this.f8876c, (ScrollScope) this.f8875b);
            int i4 = this.f8877d;
            float f3 = this.f8878f;
            AnimationSpec animationSpec = this.f8879g;
            final PagerState pagerState = this.f8876c;
            Function2<ScrollScope, Integer, Unit> function2 = new Function2<ScrollScope, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerState$animateScrollToPage$3.1
                {
                    super(2);
                }

                public final void c(ScrollScope scrollScope, int i5) {
                    pagerState.q0(scrollScope, i5);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c((ScrollScope) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }
            };
            this.f8874a = 1;
            if (PagerStateKt.e(lazyLayoutScrollScopeA, i4, f3, animationSpec, function2, this) == objF) {
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
}
