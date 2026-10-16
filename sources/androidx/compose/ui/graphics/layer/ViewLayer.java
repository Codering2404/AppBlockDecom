package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ViewLayer extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f26258l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ViewOutlineProvider f26259m = new ViewOutlineProvider() { // from class: androidx.compose.ui.graphics.layer.ViewLayer$Companion$LayerOutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Outline outline2;
            if (!(view instanceof ViewLayer) || (outline2 = ((ViewLayer) view).f26264f) == null) {
                return;
            }
            outline.set(outline2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f26260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CanvasHolder f26261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CanvasDrawScope f26262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26263d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Outline f26264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Density f26266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LayoutDirection f26267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Function1 f26268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GraphicsLayer f26269k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ViewLayer(View view, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(view.getContext());
        this.f26260a = view;
        this.f26261b = canvasHolder;
        this.f26262c = canvasDrawScope;
        setOutlineProvider(f26259m);
        this.f26265g = true;
        this.f26266h = DrawContextKt.a();
        this.f26267i = LayoutDirection.f30001a;
        this.f26268j = GraphicsLayerImpl.f26149a.a();
        setWillNotDraw(false);
        setClipBounds(null);
    }

    public final boolean b() {
        return this.f26263d;
    }

    public final void c(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        this.f26266h = density;
        this.f26267i = layoutDirection;
        this.f26268j = function1;
        this.f26269k = graphicsLayer;
    }

    public final boolean d(Outline outline) {
        this.f26264f = outline;
        return OutlineUtils.f26250a.a(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        CanvasHolder canvasHolder = this.f26261b;
        Canvas canvasB = canvasHolder.a().B();
        canvasHolder.a().C(canvas);
        AndroidCanvas androidCanvasA = canvasHolder.a();
        CanvasDrawScope canvasDrawScope = this.f26262c;
        Density density = this.f26266h;
        LayoutDirection layoutDirection = this.f26267i;
        float width = getWidth();
        long jD = Size.d((((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        GraphicsLayer graphicsLayer = this.f26269k;
        Function1 function1 = this.f26268j;
        Density density2 = canvasDrawScope.Q1().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.Q1().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvasG = canvasDrawScope.Q1().g();
        long jB = canvasDrawScope.Q1().b();
        GraphicsLayer graphicsLayerI = canvasDrawScope.Q1().i();
        DrawContext drawContextQ1 = canvasDrawScope.Q1();
        drawContextQ1.d(density);
        drawContextQ1.c(layoutDirection);
        drawContextQ1.j(androidCanvasA);
        drawContextQ1.h(jD);
        drawContextQ1.f(graphicsLayer);
        androidCanvasA.t();
        try {
            function1.invoke(canvasDrawScope);
            androidCanvasA.k();
            DrawContext drawContextQ12 = canvasDrawScope.Q1();
            drawContextQ12.d(density2);
            drawContextQ12.c(layoutDirection2);
            drawContextQ12.j(canvasG);
            drawContextQ12.h(jB);
            drawContextQ12.f(graphicsLayerI);
            canvasHolder.a().C(canvasB);
            this.f26263d = false;
        } catch (Throwable th) {
            androidCanvasA.k();
            DrawContext drawContextQ13 = canvasDrawScope.Q1();
            drawContextQ13.d(density2);
            drawContextQ13.c(layoutDirection2);
            drawContextQ13.j(canvasG);
            drawContextQ13.h(jB);
            drawContextQ13.f(graphicsLayerI);
            throw th;
        }
    }

    public final boolean getCanUseCompositingLayer$ui_graphics_release() {
        return this.f26265g;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.f26261b;
    }

    public final View getOwnerView() {
        return this.f26260a;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.f26265g;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.f26263d) {
            return;
        }
        this.f26263d = true;
        super.invalidate();
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z2) {
        if (this.f26265g != z2) {
            this.f26265g = z2;
            invalidate();
        }
    }

    public final void setInvalidated(boolean z2) {
        this.f26263d = z2;
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }
}
