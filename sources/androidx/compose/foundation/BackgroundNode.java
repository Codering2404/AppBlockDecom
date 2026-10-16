package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Brush f4626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f4627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Shape f4628d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LayoutDirection f4630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Outline f4631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Shape f4632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Outline f4633j;

    public /* synthetic */ BackgroundNode(long j3, Brush brush, float f3, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, brush, f3, shape);
    }

    private final void n2(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2;
        Outline outlineP2 = p2(contentDrawScope);
        if (Color.t(this.f4625a, Color.f25715b.k())) {
            contentDrawScope2 = contentDrawScope;
        } else {
            contentDrawScope2 = contentDrawScope;
            OutlineKt.e(contentDrawScope2, outlineP2, this.f4625a, 0.0f, null, null, 0, 60, null);
        }
        Brush brush = this.f4626b;
        if (brush != null) {
            OutlineKt.c(contentDrawScope2, outlineP2, brush, this.f4627c, null, null, 0, 56, null);
        }
    }

    private final void o2(ContentDrawScope contentDrawScope) {
        if (!Color.t(this.f4625a, Color.f25715b.k())) {
            DrawScope.L1(contentDrawScope, this.f4625a, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        Brush brush = this.f4626b;
        if (brush != null) {
            DrawScope.k1(contentDrawScope, brush, 0L, 0L, this.f4627c, null, null, 0, 118, null);
        }
    }

    private final Outline p2(final ContentDrawScope contentDrawScope) {
        Outline outline;
        if (Size.f(contentDrawScope.b(), this.f4629f) && contentDrawScope.getLayoutDirection() == this.f4630g && Intrinsics.areEqual(this.f4632i, this.f4628d)) {
            outline = this.f4631h;
            Intrinsics.checkNotNull(outline);
        } else {
            ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.BackgroundNode$getOutline$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m26invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m26invoke() {
                    BackgroundNode backgroundNode = this.f4634a;
                    backgroundNode.f4633j = backgroundNode.q2().mo29createOutlinePq9zytI(contentDrawScope.b(), contentDrawScope.getLayoutDirection(), contentDrawScope);
                }
            });
            outline = this.f4633j;
            this.f4633j = null;
        }
        this.f4631h = outline;
        this.f4629f = contentDrawScope.b();
        this.f4630g = contentDrawScope.getLayoutDirection();
        this.f4632i = this.f4628d;
        Intrinsics.checkNotNull(outline);
        return outline;
    }

    public final void I1(Shape shape) {
        this.f4628d = shape;
    }

    public final void c(float f3) {
        this.f4627c = f3;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (this.f4628d == RectangleShapeKt.a()) {
            o2(contentDrawScope);
        } else {
            n2(contentDrawScope);
        }
        contentDrawScope.i2();
    }

    public final Shape q2() {
        return this.f4628d;
    }

    public final void r2(Brush brush) {
        this.f4626b = brush;
    }

    public final void s2(long j3) {
        this.f4625a = j3;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        this.f4629f = Size.f25617b.a();
        this.f4630g = null;
        this.f4631h = null;
        this.f4632i = null;
        DrawModifierNodeKt.a(this);
    }

    private BackgroundNode(long j3, Brush brush, float f3, Shape shape) {
        this.f4625a = j3;
        this.f4626b = brush;
        this.f4627c = f3;
        this.f4628d = shape;
        this.f4629f = Size.f25617b.a();
    }
}
