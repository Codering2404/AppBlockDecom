package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class VectorPainter extends Painter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f26531p = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f26532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f26533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final VectorComponent f26534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Composition f26535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableIntState f26536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f26537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorFilter f26538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f26539o;

    public VectorPainter(GroupComponent groupComponent) {
        this.f26532h = SnapshotStateKt__SnapshotStateKt.e(Size.c(Size.f25617b.b()), null, 2, null);
        this.f26533i = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.o(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m222invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m222invoke() {
                if (this.f26540a.f26539o == this.f26540a.t()) {
                    VectorPainter vectorPainter = this.f26540a;
                    vectorPainter.z(vectorPainter.t() + 1);
                }
            }
        });
        this.f26534j = vectorComponent;
        this.f26536l = SnapshotIntStateKt.a(0);
        this.f26537m = 1.0f;
        this.f26539o = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        return this.f26536l.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int i3) {
        this.f26536l.a(i3);
    }

    public final void A(String str) {
        this.f26534j.p(str);
    }

    public final void B(long j3) {
        this.f26532h.setValue(Size.c(j3));
    }

    public final void C(long j3) {
        this.f26534j.q(j3);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        this.f26537m = f3;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        this.f26538n = colorFilter;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return u();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        VectorComponent vectorComponent = this.f26534j;
        ColorFilter colorFilterK = this.f26538n;
        if (colorFilterK == null) {
            colorFilterK = vectorComponent.k();
        }
        if (r() && drawScope.getLayoutDirection() == LayoutDirection.f30002b) {
            long jV1 = drawScope.V1();
            DrawContext drawContextQ1 = drawScope.Q1();
            long jB = drawContextQ1.b();
            drawContextQ1.g().t();
            try {
                drawContextQ1.e().i(-1.0f, 1.0f, jV1);
                vectorComponent.i(drawScope, this.f26537m, colorFilterK);
            } finally {
                drawContextQ1.g().k();
                drawContextQ1.h(jB);
            }
        } else {
            vectorComponent.i(drawScope, this.f26537m, colorFilterK);
        }
        this.f26539o = t();
    }

    public final boolean r() {
        return ((Boolean) this.f26533i.getValue()).booleanValue();
    }

    public final Composition s() {
        return this.f26535k;
    }

    public final long u() {
        return ((Size) this.f26532h.getValue()).m();
    }

    public final VectorComponent v() {
        return this.f26534j;
    }

    public final void w(boolean z2) {
        this.f26533i.setValue(Boolean.valueOf(z2));
    }

    public final void x(Composition composition) {
        this.f26535k = composition;
    }

    public final void y(ColorFilter colorFilter) {
        this.f26534j.n(colorFilter);
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GroupComponent() : groupComponent);
    }
}
