package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

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
@Deprecated
@Metadata
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver, RippleHostKey {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f15312d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final State f15313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final State f15314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewGroup f15315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RippleContainer f15316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f15317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f15318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f15319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f15320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Function0 f15321n;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z2, float f3, State state, State state2, ViewGroup viewGroup, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, state, state2, viewGroup);
    }

    private final void k() {
        RippleContainer rippleContainer = this.f15316i;
        if (rippleContainer != null) {
            rippleContainer.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        return ((Boolean) this.f15318k.getValue()).booleanValue();
    }

    private final RippleContainer m() {
        RippleContainer rippleContainer = this.f15316i;
        if (rippleContainer != null) {
            Intrinsics.checkNotNull(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = Ripple_androidKt.c(this.f15315h);
        this.f15316i = rippleContainerC;
        Intrinsics.checkNotNull(rippleContainerC);
        return rippleContainerC;
    }

    private final RippleHostView n() {
        return (RippleHostView) this.f15317j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(boolean z2) {
        this.f15318k.setValue(Boolean.valueOf(z2));
    }

    private final void p(RippleHostView rippleHostView) {
        this.f15317j.setValue(rippleHostView);
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void a(ContentDrawScope contentDrawScope) {
        this.f15319l = contentDrawScope.b();
        this.f15320m = Float.isNaN(this.f15312d) ? MathKt.d(RippleAnimationKt.a(contentDrawScope, this.f15311c, contentDrawScope.b())) : contentDrawScope.z0(this.f15312d);
        long jB = ((Color) this.f15313f.getValue()).B();
        float fD = ((RippleAlpha) this.f15314g.getValue()).d();
        contentDrawScope.i2();
        f(contentDrawScope, this.f15312d, jB);
        Canvas canvasG = contentDrawScope.Q1().g();
        l();
        RippleHostView rippleHostViewN = n();
        if (rippleHostViewN != null) {
            rippleHostViewN.f(contentDrawScope.b(), jB, fD);
            rippleHostViewN.draw(AndroidCanvas_androidKt.d(canvasG));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void b(PressInteraction.Press press, CoroutineScope coroutineScope) {
        RippleHostView rippleHostViewB = m().b(this);
        rippleHostViewB.b(press, this.f15311c, this.f15319l, this.f15320m, ((Color) this.f15313f.getValue()).B(), ((RippleAlpha) this.f15314g.getValue()).d(), this.f15321n);
        p(rippleHostViewB);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        k();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        k();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void g(PressInteraction.Press press) {
        RippleHostView rippleHostViewN = n();
        if (rippleHostViewN != null) {
            rippleHostViewN.e();
        }
    }

    @Override // androidx.compose.material.ripple.RippleHostKey
    public void x1() {
        p(null);
    }

    private AndroidRippleIndicationInstance(boolean z2, float f3, State state, State state2, ViewGroup viewGroup) {
        super(z2, state2);
        this.f15311c = z2;
        this.f15312d = f3;
        this.f15313f = state;
        this.f15314g = state2;
        this.f15315h = viewGroup;
        this.f15317j = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f15318k = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
        this.f15319l = Size.f25617b.b();
        this.f15320m = -1;
        this.f15321n = new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m144invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m144invoke() {
                this.f15322a.o(!r0.l());
            }
        };
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
    }
}
