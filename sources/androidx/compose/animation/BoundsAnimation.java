package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class BoundsAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedTransitionScope f3394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transition f3395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f3396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f3397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FiniteAnimationSpec f3398e = BoundsAnimationKt.f3408a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f3399f = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    public BoundsAnimation(SharedTransitionScope sharedTransitionScope, Transition transition, Transition.DeferredAnimation deferredAnimation, BoundsTransform boundsTransform) {
        this.f3394a = sharedTransitionScope;
        this.f3395b = transition;
        this.f3396c = SnapshotStateKt__SnapshotStateKt.e(deferredAnimation, null, 2, null);
        this.f3397d = SnapshotStateKt__SnapshotStateKt.e(boundsTransform, null, 2, null);
    }

    private final BoundsTransform e() {
        return (BoundsTransform) this.f3397d.getValue();
    }

    private final void j(Transition.DeferredAnimation deferredAnimation) {
        this.f3396c.setValue(deferredAnimation);
    }

    private final void l(BoundsTransform boundsTransform) {
        this.f3397d.setValue(boundsTransform);
    }

    public final void a(final Rect rect, final Rect rect2) {
        if (this.f3394a.p()) {
            if (d() == null) {
                this.f3398e = e().a(rect, rect2);
            }
            k(b().a(new Function1<Transition.Segment<Boolean>, FiniteAnimationSpec<Rect>>() { // from class: androidx.compose.animation.BoundsAnimation$animate$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                    return this.f3400a.c();
                }
            }, new Function1<Boolean, Rect>() { // from class: androidx.compose.animation.BoundsAnimation$animate$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Rect c(boolean z2) {
                    return z2 == ((Boolean) this.f3401a.g().q()).booleanValue() ? rect2 : rect;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return c(((Boolean) obj).booleanValue());
                }
            }));
        }
    }

    public final Transition.DeferredAnimation b() {
        return (Transition.DeferredAnimation) this.f3396c.getValue();
    }

    public final FiniteAnimationSpec c() {
        return this.f3398e;
    }

    public final State d() {
        return (State) this.f3399f.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.f3395b.q()).booleanValue();
    }

    public final Transition g() {
        return this.f3395b;
    }

    public final Rect h() {
        State stateD;
        if (!this.f3394a.p() || (stateD = d()) == null) {
            return null;
        }
        return (Rect) stateD.getValue();
    }

    public final boolean i() {
        Transition transitionM = this.f3395b;
        while (transitionM.m() != null) {
            transitionM = transitionM.m();
            Intrinsics.checkNotNull(transitionM);
        }
        return !Intrinsics.areEqual(transitionM.i(), transitionM.q());
    }

    public final void k(State state) {
        this.f3399f.setValue(state);
    }

    public final void m(Transition.DeferredAnimation deferredAnimation, BoundsTransform boundsTransform) {
        if (!Intrinsics.areEqual(b(), deferredAnimation)) {
            j(deferredAnimation);
            k(null);
            this.f3398e = BoundsAnimationKt.f3408a;
        }
        l(boundsTransform);
    }
}
