package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", l = {507}, m = "invokeSuspend")
final class PagerState$scrollToPage$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagerState f8892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f8893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f8894d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$scrollToPage$2(PagerState pagerState, float f3, int i3, Continuation continuation) {
        super(2, continuation);
        this.f8892b = pagerState;
        this.f8893c = f3;
        this.f8894d = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagerState$scrollToPage$2(this.f8892b, this.f8893c, this.f8894d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
        return ((PagerState$scrollToPage$2) create(scrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f8891a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PagerState pagerState = this.f8892b;
            this.f8891a = 1;
            if (pagerState.q(this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        float f3 = this.f8893c;
        double d3 = f3;
        boolean z2 = false;
        if (-0.5d <= d3 && d3 <= 0.5d) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("pageOffsetFraction " + f3 + " is not within the range -0.5 to 0.5");
        }
        this.f8892b.o0(this.f8892b.s(this.f8894d), this.f8893c, true);
        return Unit.f139807a;
    }
}
