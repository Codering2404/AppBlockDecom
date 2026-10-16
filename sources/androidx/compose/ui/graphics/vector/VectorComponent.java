package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class VectorComponent extends VNode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GroupComponent f26445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DrawCache f26448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0 f26449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f26450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorFilter f26451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f26452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f26453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f26454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f26455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Function1 f26456m;

    public VectorComponent(GroupComponent groupComponent) {
        super(null);
        this.f26445b = groupComponent;
        groupComponent.d(new Function1<VNode, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent.1
            {
                super(1);
            }

            public final void c(VNode vNode) {
                VectorComponent.this.h();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((VNode) obj);
                return Unit.f139807a;
            }
        });
        this.f26446c = "";
        this.f26447d = true;
        this.f26448e = new DrawCache();
        this.f26449f = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m221invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m221invoke();
                return Unit.f139807a;
            }
        };
        this.f26450g = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        Size.Companion companion = Size.f25617b;
        this.f26452i = SnapshotStateKt__SnapshotStateKt.e(Size.c(companion.b()), null, 2, null);
        this.f26453j = companion.a();
        this.f26454k = 1.0f;
        this.f26455l = 1.0f;
        this.f26456m = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                GroupComponent groupComponentL = this.f26458a.l();
                VectorComponent vectorComponent = this.f26458a;
                float f3 = vectorComponent.f26454k;
                float f4 = vectorComponent.f26455l;
                long jC = Offset.f25596b.c();
                DrawContext drawContextQ1 = drawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().i(f3, f4, jC);
                    groupComponentL.a(drawScope);
                } finally {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.f26447d = true;
        this.f26449f.invoke();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void a(DrawScope drawScope) {
        i(drawScope, 1.0f, null);
    }

    public final void i(DrawScope drawScope, float f3, ColorFilter colorFilter) {
        DrawScope drawScope2;
        int iA = (this.f26445b.j() && this.f26445b.g() != 16 && VectorKt.g(k()) && VectorKt.g(colorFilter)) ? ImageBitmapConfig.f25784b.a() : ImageBitmapConfig.f25784b.b();
        if (!this.f26447d && Size.f(this.f26453j, drawScope.b()) && ImageBitmapConfig.i(iA, j())) {
            drawScope2 = drawScope;
        } else {
            this.f26451h = ImageBitmapConfig.i(iA, ImageBitmapConfig.f25784b.a()) ? ColorFilter.Companion.c(ColorFilter.f25730b, this.f26445b.g(), 0, 2, null) : null;
            this.f26454k = Float.intBitsToFloat((int) (drawScope.b() >> 32)) / Float.intBitsToFloat((int) (m() >> 32));
            this.f26455l = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / Float.intBitsToFloat((int) (m() & 4294967295L));
            drawScope2 = drawScope;
            this.f26448e.b(iA, IntSize.c((((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.b() & 4294967295L))))) & 4294967295L) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.b() >> 32))))) << 32)), drawScope2, drawScope.getLayoutDirection(), this.f26456m);
            this.f26447d = false;
            this.f26453j = drawScope2.b();
        }
        if (colorFilter == null) {
            colorFilter = k() != null ? k() : this.f26451h;
        }
        this.f26448e.c(drawScope2, f3, colorFilter);
    }

    public final int j() {
        ImageBitmap imageBitmapD = this.f26448e.d();
        return imageBitmapD != null ? imageBitmapD.b() : ImageBitmapConfig.f25784b.b();
    }

    public final ColorFilter k() {
        return (ColorFilter) this.f26450g.getValue();
    }

    public final GroupComponent l() {
        return this.f26445b;
    }

    public final long m() {
        return ((Size) this.f26452i.getValue()).m();
    }

    public final void n(ColorFilter colorFilter) {
        this.f26450g.setValue(colorFilter);
    }

    public final void o(Function0 function0) {
        this.f26449f = function0;
    }

    public final void p(String str) {
        this.f26446c = str;
    }

    public final void q(long j3) {
        this.f26452i.setValue(Size.c(j3));
    }

    public String toString() {
        String str = "Params: \tname: " + this.f26446c + "\n\tviewportWidth: " + Float.intBitsToFloat((int) (m() >> 32)) + "\n\tviewportHeight: " + Float.intBitsToFloat((int) (m() & 4294967295L)) + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }
}
