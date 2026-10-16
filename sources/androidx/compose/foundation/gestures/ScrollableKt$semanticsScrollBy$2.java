package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2", f = "Scrollable.kt", l = {1024}, m = "invokeSuspend")
final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScrollingLogic f6093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f6094d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f6095f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$semanticsScrollBy$2(ScrollingLogic scrollingLogic, long j3, Ref.FloatRef floatRef, Continuation continuation) {
        super(2, continuation);
        this.f6093c = scrollingLogic;
        this.f6094d = j3;
        this.f6095f = floatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(this.f6093c, this.f6094d, this.f6095f, continuation);
        scrollableKt$semanticsScrollBy$2.f6092b = obj;
        return scrollableKt$semanticsScrollBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation continuation) {
        return ((ScrollableKt$semanticsScrollBy$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6091a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.f6092b;
            float F = this.f6093c.F(this.f6094d);
            final Ref.FloatRef floatRef = this.f6095f;
            final ScrollingLogic scrollingLogic = this.f6093c;
            Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void c(float f3, float f4) {
                    float f5 = f3 - floatRef.f140141a;
                    ScrollingLogic scrollingLogic2 = scrollingLogic;
                    floatRef.f140141a += scrollingLogic2.x(scrollingLogic2.F(nestedScrollScope.b(scrollingLogic2.G(scrollingLogic2.x(f5)), NestedScrollSource.f26772b.b())));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                    return Unit.f139807a;
                }
            };
            this.f6091a = 1;
            if (SuspendAnimationKt.e(0.0f, F, 0.0f, null, function2, this, 12, null) == objF) {
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
