package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
final class LegacyDragSourceNodeWithDefaultPainter extends DelegatingNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f5365c;

    /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.LegacyDragSourceNodeWithDefaultPainter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.draganddrop.LegacyDragSourceNodeWithDefaultPainter$2", f = "LegacyDragAndDropSourceWithDefaultPainter.android.kt", l = {101}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f5368b;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = LegacyDragSourceNodeWithDefaultPainter.this.new AnonymousClass2(continuation);
            anonymousClass2.f5368b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(DragAndDropSourceScope dragAndDropSourceScope, Continuation continuation) {
            return ((AnonymousClass2) create(dragAndDropSourceScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f5367a;
            if (i3 == 0) {
                ResultKt.b(obj);
                DragAndDropSourceScope dragAndDropSourceScope = (DragAndDropSourceScope) this.f5368b;
                Function2 function2S2 = LegacyDragSourceNodeWithDefaultPainter.this.s2();
                this.f5367a = 1;
                if (function2S2.invoke(dragAndDropSourceScope, this) == objF) {
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

    public LegacyDragSourceNodeWithDefaultPainter(Function2 function2) {
        this.f5365c = function2;
        final CacheDrawScopeDragShadowCallback cacheDrawScopeDragShadowCallback = new CacheDrawScopeDragShadowCallback();
        m2(DrawModifierKt.a(new LegacyDragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(cacheDrawScopeDragShadowCallback)));
        m2(new LegacyDragAndDropSourceNode(new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.LegacyDragSourceNodeWithDefaultPainter.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                cacheDrawScopeDragShadowCallback.c(drawScope);
            }
        }, new AnonymousClass2(null)));
    }

    public final Function2 s2() {
        return this.f5365c;
    }

    public final void t2(Function2 function2) {
        this.f5365c = function2;
    }
}
