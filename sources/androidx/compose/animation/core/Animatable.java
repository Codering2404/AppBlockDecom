package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class Animatable<T, V extends AnimationVector> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3769m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TwoWayConverter f3770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimationState f3773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f3774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f3775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutatorMutex f3776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SpringSpec f3777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AnimationVector f3778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AnimationVector f3779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AnimationVector f3780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimationVector f3781l;

    public Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str) {
        this.f3770a = twoWayConverter;
        this.f3771b = obj2;
        this.f3772c = str;
        this.f3773d = new AnimationState(twoWayConverter, obj, null, 0L, 0L, false, 60, null);
        this.f3774e = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f3775f = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f3776g = new MutatorMutex();
        this.f3777h = new SpringSpec(0.0f, 0.0f, obj2, 3, null);
        AnimationVector animationVectorP = p();
        AnimationVector animationVector = animationVectorP instanceof AnimationVector1D ? AnimatableKt.f3803e : animationVectorP instanceof AnimationVector2D ? AnimatableKt.f3804f : animationVectorP instanceof AnimationVector3D ? AnimatableKt.f3805g : AnimatableKt.f3806h;
        Intrinsics.checkNotNull(animationVector, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f3778i = animationVector;
        AnimationVector animationVectorP2 = p();
        AnimationVector animationVector2 = animationVectorP2 instanceof AnimationVector1D ? AnimatableKt.f3799a : animationVectorP2 instanceof AnimationVector2D ? AnimatableKt.f3800b : animationVectorP2 instanceof AnimationVector3D ? AnimatableKt.f3801c : AnimatableKt.f3802d;
        Intrinsics.checkNotNull(animationVector2, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f3779j = animationVector2;
        this.f3780k = animationVector;
        this.f3781l = animationVector2;
    }

    public static /* synthetic */ Object f(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation, int i3, Object obj3) {
        if ((i3 & 2) != 0) {
            animationSpec = animatable.f3777h;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            obj2 = animatable.o();
        }
        Object obj4 = obj2;
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        return animatable.e(obj, animationSpec2, obj4, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(Object obj) {
        if (Intrinsics.areEqual(this.f3780k, this.f3778i) && Intrinsics.areEqual(this.f3781l, this.f3779j)) {
            return obj;
        }
        AnimationVector animationVector = (AnimationVector) this.f3770a.a().invoke(obj);
        int iB = animationVector.b();
        boolean z2 = false;
        for (int i3 = 0; i3 < iB; i3++) {
            if (animationVector.a(i3) < this.f3780k.a(i3) || animationVector.a(i3) > this.f3781l.a(i3)) {
                animationVector.e(i3, RangesKt.o(animationVector.a(i3), this.f3780k.a(i3), this.f3781l.a(i3)));
                z2 = true;
            }
        }
        return z2 ? this.f3770a.b().invoke(animationVector) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        AnimationState animationState = this.f3773d;
        animationState.q().d();
        animationState.w(Long.MIN_VALUE);
        s(false);
    }

    private final Object r(Animation animation, Object obj, Function1 function1, Continuation continuation) {
        return MutatorMutex.e(this.f3776g, null, new Animatable$runAnimation$2(this, obj, animation, this.f3773d.i(), function1, null), continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(boolean z2) {
        this.f3774e.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Object obj) {
        this.f3775f.setValue(obj);
    }

    public final Object e(Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation) {
        return r(AnimationKt.b(animationSpec, this.f3770a, n(), obj, obj2), obj2, function1, continuation);
    }

    public final State g() {
        return this.f3773d;
    }

    public final AnimationState j() {
        return this.f3773d;
    }

    public final String k() {
        return this.f3772c;
    }

    public final Object l() {
        return this.f3775f.getValue();
    }

    public final TwoWayConverter m() {
        return this.f3770a;
    }

    public final Object n() {
        return this.f3773d.getValue();
    }

    public final Object o() {
        return this.f3770a.b().invoke(p());
    }

    public final AnimationVector p() {
        return this.f3773d.q();
    }

    public final boolean q() {
        return ((Boolean) this.f3774e.getValue()).booleanValue();
    }

    public final Object u(Object obj, Continuation continuation) {
        Object objE = MutatorMutex.e(this.f3776g, null, new Animatable$snapTo$2(this, obj, null), continuation, 1, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public final Object v(Continuation continuation) {
        Object objE = MutatorMutex.e(this.f3776g, null, new Animatable$stop$2(this, null), continuation, 1, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i3 & 4) != 0 ? null : obj2, (i3 & 8) != 0 ? "Animatable" : str);
    }
}
