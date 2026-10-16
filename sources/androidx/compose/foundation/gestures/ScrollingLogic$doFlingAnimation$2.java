package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", l = {814}, m = "invokeSuspend")
final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f6164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f6165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f6166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6167d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f6168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScrollingLogic f6169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f6170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f6171i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref.LongRef longRef, long j3, Continuation continuation) {
        super(2, continuation);
        this.f6169g = scrollingLogic;
        this.f6170h = longRef;
        this.f6171i = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.f6169g, this.f6170h, this.f6171i, continuation);
        scrollingLogic$doFlingAnimation$2.f6168f = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ScrollingLogic scrollingLogic;
        Ref.LongRef longRef;
        ScrollingLogic scrollingLogic2;
        long j3;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6167d;
        if (i3 == 0) {
            ResultKt.b(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.f6168f;
            final ScrollingLogic scrollingLogic3 = this.f6169g;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$reverseScope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public float d(float f3) {
                    if (ComposeFoundationFlags.f4886b && Math.abs(f3) != 0.0f && scrollingLogic3.A(f3)) {
                        throw new FlingCancellationException();
                    }
                    ScrollingLogic scrollingLogic4 = scrollingLogic3;
                    return scrollingLogic4.x(scrollingLogic4.F(nestedScrollScope.a(scrollingLogic4.y(scrollingLogic4.G(f3)), NestedScrollSource.f26772b.a())));
                }
            };
            scrollingLogic = this.f6169g;
            Ref.LongRef longRef2 = this.f6170h;
            long j4 = this.f6171i;
            FlingBehavior flingBehavior = scrollingLogic.f6149c;
            long j5 = longRef2.f140143a;
            float fX = scrollingLogic.x(scrollingLogic.E(j4));
            this.f6168f = scrollingLogic;
            this.f6164a = scrollingLogic;
            this.f6165b = longRef2;
            this.f6166c = j5;
            this.f6167d = 1;
            Object objA = flingBehavior.a(scrollScope, fX, this);
            if (objA == objF) {
                return objF;
            }
            longRef = longRef2;
            obj = objA;
            scrollingLogic2 = scrollingLogic;
            j3 = j5;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.f6166c;
            longRef = (Ref.LongRef) this.f6165b;
            scrollingLogic = (ScrollingLogic) this.f6164a;
            scrollingLogic2 = (ScrollingLogic) this.f6168f;
            ResultKt.b(obj);
        }
        longRef.f140143a = scrollingLogic.J(j3, scrollingLogic2.x(((Number) obj).floatValue()));
        return Unit.f139807a;
    }
}
