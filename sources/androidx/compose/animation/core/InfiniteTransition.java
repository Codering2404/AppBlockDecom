package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class InfiniteTransition {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3967f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f3969b = new MutableVector(new TransitionAnimationState[16], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f3970c = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3971d = Long.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f3972e = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f3973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f3974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TwoWayConverter f3975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f3976d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MutableState f3977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AnimationSpec f3978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TargetBasedAnimation f3979h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f3980i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f3981j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f3982k;

        public TransitionAnimationState(Object obj, Object obj2, TwoWayConverter twoWayConverter, AnimationSpec animationSpec, String str) {
            this.f3973a = obj;
            this.f3974b = obj2;
            this.f3975c = twoWayConverter;
            this.f3976d = str;
            this.f3977f = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            this.f3978g = animationSpec;
            this.f3979h = new TargetBasedAnimation(this.f3978g, twoWayConverter, this.f3973a, this.f3974b, null, 16, null);
        }

        public final TargetBasedAnimation b() {
            return this.f3979h;
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.f3977f.getValue();
        }

        public final AnimationSpec i() {
            return this.f3978g;
        }

        public final Object n() {
            return this.f3973a;
        }

        public final Object p() {
            return this.f3974b;
        }

        public final TwoWayConverter q() {
            return this.f3975c;
        }

        public final boolean r() {
            return this.f3980i;
        }

        public final void v(long j3) {
            InfiniteTransition.this.n(false);
            if (this.f3981j) {
                this.f3981j = false;
                this.f3982k = j3;
            }
            long j4 = j3 - this.f3982k;
            x(this.f3979h.f(j4));
            this.f3980i = this.f3979h.c(j4);
        }

        public final void w() {
            this.f3981j = true;
        }

        public void x(Object obj) {
            this.f3977f.setValue(obj);
        }

        public final void y() {
            x(this.f3979h.g());
            this.f3981j = true;
        }

        public final void z(Object obj, Object obj2, AnimationSpec animationSpec) {
            this.f3973a = obj;
            this.f3974b = obj2;
            this.f3978g = animationSpec;
            this.f3979h = new TargetBasedAnimation(animationSpec, this.f3975c, obj, obj2, null, 16, null);
            InfiniteTransition.this.n(true);
            this.f3980i = false;
            this.f3981j = true;
        }
    }

    public InfiniteTransition(String str) {
        this.f3968a = str;
    }

    private final boolean i() {
        return ((Boolean) this.f3970c.getValue()).booleanValue();
    }

    private final boolean j() {
        return ((Boolean) this.f3972e.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(long j3) {
        MutableVector mutableVector = this.f3969b;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        boolean z2 = true;
        for (int i3 = 0; i3 < iO; i3++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) objArr[i3];
            if (!transitionAnimationState.r()) {
                transitionAnimationState.v(j3);
            }
            if (!transitionAnimationState.r()) {
                z2 = false;
            }
        }
        o(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean z2) {
        this.f3970c.setValue(Boolean.valueOf(z2));
    }

    private final void o(boolean z2) {
        this.f3972e.setValue(Boolean.valueOf(z2));
    }

    public final void f(TransitionAnimationState transitionAnimationState) {
        this.f3969b.b(transitionAnimationState);
        n(true);
    }

    public final List g() {
        return this.f3969b.h();
    }

    public final String h() {
        return this.f3968a;
    }

    public final void l(TransitionAnimationState transitionAnimationState) {
        this.f3969b.s(transitionAnimationState);
    }

    public final void m(Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-318043801);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-318043801, i4, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:164)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            if (j() || i()) {
                composerK.a0(1719883733);
                boolean zI = composerK.I(this);
                Object objG2 = composerK.G();
                if (zI || objG2 == companion.a()) {
                    objG2 = new InfiniteTransition$run$1$1(mutableState, this, null);
                    composerK.w(objG2);
                }
                EffectsKt.g(this, (Function2) objG2, composerK, i4 & 14);
                composerK.U();
            } else {
                composerK.a0(1721270456);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.core.InfiniteTransition$run$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    this.f3996a.m(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
