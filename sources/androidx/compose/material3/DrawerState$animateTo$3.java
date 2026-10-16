package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.DraggableAnchors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
@DebugMetadata(c = "androidx.compose.material3.DrawerState$animateTo$3", f = "NavigationDrawer.kt", l = {254}, m = "invokeSuspend")
final class DrawerState$animateTo$3 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<DrawerValue>, DrawerValue, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f17502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f17503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f17504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f17505d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DrawerState f17506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f17507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f17508h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerState$animateTo$3(DrawerState drawerState, float f3, AnimationSpec animationSpec, Continuation continuation) {
        super(4, continuation);
        this.f17506f = drawerState;
        this.f17507g = f3;
        this.f17508h = animationSpec;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, DrawerValue drawerValue, Continuation continuation) {
        DrawerState$animateTo$3 drawerState$animateTo$3 = new DrawerState$animateTo$3(this.f17506f, this.f17507g, this.f17508h, continuation);
        drawerState$animateTo$3.f17503b = anchoredDragScope;
        drawerState$animateTo$3.f17504c = draggableAnchors;
        drawerState$animateTo$3.f17505d = drawerValue;
        return drawerState$animateTo$3.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f17502a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f17503b;
            float fC = ((DraggableAnchors) this.f17504c).c((DrawerValue) this.f17505d);
            if (!Float.isNaN(fC)) {
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                float f3 = Float.isNaN(this.f17506f.f()) ? 0.0f : this.f17506f.f();
                floatRef.f140141a = f3;
                float f4 = this.f17507g;
                AnimationSpec animationSpec = this.f17508h;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material3.DrawerState$animateTo$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final void c(float f5, float f6) {
                        anchoredDragScope.a(f5, f6);
                        floatRef.f140141a = f5;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.f139807a;
                    }
                };
                this.f17503b = null;
                this.f17504c = null;
                this.f17502a = 1;
                if (SuspendAnimationKt.b(f3, fC, f4, animationSpec, function2, this) == objF) {
                    return objF;
                }
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
