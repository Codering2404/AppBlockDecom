package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f15327d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final State f15328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final State f15329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SnapshotStateMap f15330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15331i;

    public /* synthetic */ CommonRippleIndicationInstance(boolean z2, float f3, State state, State state2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, state, state2);
    }

    private final void j(DrawScope drawScope, long j3) {
        long j4;
        Iterator it = this.f15330h.entrySet().iterator();
        while (it.hasNext()) {
            RippleAnimation rippleAnimation = (RippleAnimation) ((Map.Entry) it.next()).getValue();
            float fD = ((RippleAlpha) this.f15329g.getValue()).d();
            if (fD == 0.0f) {
                j4 = j3;
            } else {
                j4 = j3;
                rippleAnimation.e(drawScope, Color.r(j4, fD, 0.0f, 0.0f, 0.0f, 14, null));
            }
            j3 = j4;
        }
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void a(ContentDrawScope contentDrawScope) {
        this.f15331i = Float.isNaN(this.f15327d) ? RippleAnimationKt.a(contentDrawScope, this.f15326c, contentDrawScope.b()) : contentDrawScope.M1(this.f15327d);
        long jB = ((Color) this.f15328f.getValue()).B();
        contentDrawScope.i2();
        f(contentDrawScope, this.f15327d, jB);
        j(contentDrawScope, jB);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void b(PressInteraction.Press press, CoroutineScope coroutineScope) {
        Iterator it = this.f15330h.entrySet().iterator();
        while (it.hasNext()) {
            ((RippleAnimation) ((Map.Entry) it.next()).getValue()).h();
        }
        RippleAnimation rippleAnimation = new RippleAnimation(this.f15326c ? Offset.d(press.a()) : null, this.f15331i, this.f15326c, null);
        this.f15330h.put(press, rippleAnimation);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new CommonRippleIndicationInstance$addRipple$2(rippleAnimation, this, press, null), 3, null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        this.f15330h.clear();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        this.f15330h.clear();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void g(PressInteraction.Press press) {
        RippleAnimation rippleAnimation = (RippleAnimation) this.f15330h.get(press);
        if (rippleAnimation != null) {
            rippleAnimation.h();
        }
    }

    private CommonRippleIndicationInstance(boolean z2, float f3, State state, State state2) {
        super(z2, state2);
        this.f15326c = z2;
        this.f15327d = f3;
        this.f15328f = state;
        this.f15329g = state2;
        this.f15330h = SnapshotStateKt.h();
        this.f15331i = Float.NaN;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
    }
}
