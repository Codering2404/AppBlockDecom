package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.ui.unit.Density;
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
@DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2", f = "LazyStaggeredGridState.kt", l = {364}, m = "invokeSuspend")
final class LazyStaggeredGridState$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f8574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyStaggeredGridState f8575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f8576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f8577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f8578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LazyStaggeredGridMeasureResult f8579h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridState$animateScrollToItem$2(LazyStaggeredGridState lazyStaggeredGridState, int i3, int i4, int i5, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, Continuation continuation) {
        super(2, continuation);
        this.f8575c = lazyStaggeredGridState;
        this.f8576d = i3;
        this.f8577f = i4;
        this.f8578g = i5;
        this.f8579h = lazyStaggeredGridMeasureResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LazyStaggeredGridState$animateScrollToItem$2 lazyStaggeredGridState$animateScrollToItem$2 = new LazyStaggeredGridState$animateScrollToItem$2(this.f8575c, this.f8576d, this.f8577f, this.f8578g, this.f8579h, continuation);
        lazyStaggeredGridState$animateScrollToItem$2.f8574b = obj;
        return lazyStaggeredGridState$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
        return ((LazyStaggeredGridState$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f8573a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LazyLayoutScrollScope lazyLayoutScrollScopeA = LazyStaggeredGridScrollScopeKt.a(this.f8575c, (ScrollScope) this.f8574b);
            int i4 = this.f8576d;
            int i5 = this.f8577f;
            int i6 = this.f8578g;
            Density densityL = this.f8579h.l();
            this.f8573a = 1;
            if (LazyLayoutScrollScopeKt.b(lazyLayoutScrollScopeA, i4, i5, i6, densityL, this) == objF) {
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
