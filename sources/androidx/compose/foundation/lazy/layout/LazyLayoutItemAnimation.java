package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Lambda;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutItemAnimation {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Companion f8022s = new Companion(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f8023t = 8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f8024u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f8025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GraphicsContext f8026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f8027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FiniteAnimationSpec f8028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FiniteAnimationSpec f8029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FiniteAnimationSpec f8030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f8032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f8033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f8034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f8035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f8036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f8037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private GraphicsLayer f8038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Animatable f8039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Animatable f8040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableState f8041q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f8042r;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f8043a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m48invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m48invoke();
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return LazyLayoutItemAnimation.f8024u;
        }

        private Companion() {
        }
    }

    static {
        long j3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        f8024u = IntOffset.f((j3 & 4294967295L) | (j3 << 32));
    }

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0 function0) {
        this.f8025a = coroutineScope;
        this.f8026b = graphicsContext;
        this.f8027c = function0;
        Boolean bool = Boolean.FALSE;
        this.f8032h = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f8033i = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f8034j = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f8035k = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        long j3 = f8024u;
        this.f8036l = j3;
        IntOffset.Companion companion = IntOffset.f29988b;
        this.f8037m = companion.b();
        this.f8038n = graphicsContext != null ? graphicsContext.a() : null;
        String str = null;
        this.f8039o = new Animatable(IntOffset.c(companion.b()), VectorConvertersKt.g(companion), null, str, 12, null);
        this.f8040p = new Animatable(Float.valueOf(1.0f), VectorConvertersKt.i(FloatCompanionObject.f140130a), str, null, 12, null);
        this.f8041q = SnapshotStateKt__SnapshotStateKt.e(IntOffset.c(companion.b()), null, 2, null);
        this.f8042r = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean z2) {
        this.f8035k.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(boolean z2) {
        this.f8034j.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean z2) {
        this.f8032h.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(long j3) {
        this.f8041q.setValue(IntOffset.c(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean z2) {
        this.f8033i.setValue(Boolean.valueOf(z2));
    }

    public final void C(FiniteAnimationSpec finiteAnimationSpec) {
        this.f8028d = finiteAnimationSpec;
    }

    public final void D(FiniteAnimationSpec finiteAnimationSpec) {
        this.f8030f = finiteAnimationSpec;
    }

    public final void E(long j3) {
        this.f8037m = j3;
    }

    public final void F(long j3) {
        this.f8042r = j3;
    }

    public final void I(FiniteAnimationSpec finiteAnimationSpec) {
        this.f8029e = finiteAnimationSpec;
    }

    public final void J(long j3) {
        this.f8036l = j3;
    }

    public final void k() {
        GraphicsLayer graphicsLayer = this.f8038n;
        FiniteAnimationSpec finiteAnimationSpec = this.f8028d;
        if (t() || finiteAnimationSpec == null || graphicsLayer == null) {
            if (v()) {
                if (graphicsLayer != null) {
                    graphicsLayer.L(1.0f);
                }
                BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$animateAppearance$1(this, null), 3, null);
                return;
            }
            return;
        }
        z(true);
        boolean zV = v();
        boolean z2 = !zV;
        if (!zV) {
            graphicsLayer.L(0.0f);
        }
        BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$animateAppearance$2(z2, this, finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    public final void l() {
        GraphicsLayer graphicsLayer = this.f8038n;
        FiniteAnimationSpec finiteAnimationSpec = this.f8030f;
        if (graphicsLayer == null || v() || finiteAnimationSpec == null) {
            return;
        }
        B(true);
        BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$animateDisappearance$1(this, finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    public final void m(long j3, boolean z2) {
        FiniteAnimationSpec finiteAnimationSpec = this.f8029e;
        if (finiteAnimationSpec == null) {
            return;
        }
        long jN = IntOffset.n(r(), j3);
        H(jN);
        G(true);
        this.f8031g = z2;
        BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, finiteAnimationSpec, jN, null), 3, null);
    }

    public final void n() {
        if (w()) {
            BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$cancelPlacementAnimation$1(this, null), 3, null);
        }
    }

    public final long o() {
        return this.f8037m;
    }

    public final GraphicsLayer p() {
        return this.f8038n;
    }

    public final long q() {
        return this.f8042r;
    }

    public final long r() {
        return ((IntOffset) this.f8041q.getValue()).r();
    }

    public final long s() {
        return this.f8036l;
    }

    public final boolean t() {
        return ((Boolean) this.f8033i.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.f8035k.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) this.f8034j.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) this.f8032h.getValue()).booleanValue();
    }

    public final boolean x() {
        return this.f8031g;
    }

    public final void y() {
        GraphicsContext graphicsContext;
        if (w()) {
            G(false);
            BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$release$1(this, null), 3, null);
        }
        if (t()) {
            z(false);
            BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$release$2(this, null), 3, null);
        }
        if (v()) {
            B(false);
            BuildersKt__Builders_commonKt.d(this.f8025a, null, null, new LazyLayoutItemAnimation$release$3(this, null), 3, null);
        }
        this.f8031g = false;
        H(IntOffset.f29988b.b());
        this.f8036l = f8024u;
        GraphicsLayer graphicsLayer = this.f8038n;
        if (graphicsLayer != null && (graphicsContext = this.f8026b) != null) {
            graphicsContext.b(graphicsLayer);
        }
        this.f8038n = null;
        this.f8028d = null;
        this.f8030f = null;
        this.f8029e = null;
    }
}
