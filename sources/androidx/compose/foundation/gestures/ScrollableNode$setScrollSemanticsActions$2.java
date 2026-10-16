package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2", f = "Scrollable.kt", l = {522}, m = "invokeSuspend")
final class ScrollableNode$setScrollSemanticsActions$2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ long f6143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScrollableNode f6144c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableNode$setScrollSemanticsActions$2(ScrollableNode scrollableNode, Continuation continuation) {
        super(2, continuation);
        this.f6144c = scrollableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollableNode$setScrollSemanticsActions$2 scrollableNode$setScrollSemanticsActions$2 = new ScrollableNode$setScrollSemanticsActions$2(this.f6144c, continuation);
        scrollableNode$setScrollSemanticsActions$2.f6143b = ((Offset) obj).u();
        return scrollableNode$setScrollSemanticsActions$2;
    }

    public final Object h(long j3, Continuation continuation) {
        return ((ScrollableNode$setScrollSemanticsActions$2) create(Offset.d(j3), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((Offset) obj).u(), (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6142a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        long j3 = this.f6143b;
        ScrollingLogic scrollingLogic = this.f6144c.f6111s;
        this.f6142a = 1;
        Object objL = ScrollableKt.l(scrollingLogic, j3, this);
        return objL == objF ? objF : objL;
    }
}
