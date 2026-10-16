package androidx.compose.foundation.lazy;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2", f = "LazyListState.kt", l = {481}, m = "invokeSuspend")
final class LazyListState$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f7592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f7593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyListState f7594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f7595d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f7596f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListState$animateScrollToItem$2(LazyListState lazyListState, int i3, int i4, Continuation continuation) {
        super(2, continuation);
        this.f7594c = lazyListState;
        this.f7595d = i3;
        this.f7596f = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LazyListState$animateScrollToItem$2 lazyListState$animateScrollToItem$2 = new LazyListState$animateScrollToItem$2(this.f7594c, this.f7595d, this.f7596f, continuation);
        lazyListState$animateScrollToItem$2.f7593b = obj;
        return lazyListState$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
        return ((LazyListState$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f7592a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LazyLayoutScrollScope lazyLayoutScrollScopeA = LazyListScrollScopeKt.a(this.f7594c, (ScrollScope) this.f7593b);
            int i4 = this.f7595d;
            int i5 = this.f7596f;
            Density densityR = this.f7594c.r();
            this.f7592a = 1;
            if (LazyLayoutScrollScopeKt.b(lazyLayoutScrollScopeA, i4, i5, 100, densityR, this) == objF) {
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
