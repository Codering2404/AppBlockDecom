package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class BorderModifierNode extends DelegatingNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BorderCache f4743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4744d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Brush f4745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Shape f4746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CacheDrawModifierNode f4747h;

    public /* synthetic */ BorderModifierNode(float f3, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, brush, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.draw.DrawResult u2(androidx.compose.ui.draw.CacheDrawScope r43, final androidx.compose.ui.graphics.Brush r44, final androidx.compose.ui.graphics.Outline.Generic r45, boolean r46, float r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.u2(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DrawResult v2(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j3, final long j4, final boolean z2, final float f3) {
        if (RoundRectKt.g(rounded.b())) {
            final long jH = rounded.b().h();
            final float f4 = f3 / 2;
            final Stroke stroke = new Stroke(f3, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return Unit.f139807a;
                }

                public final void invoke(ContentDrawScope contentDrawScope) {
                    contentDrawScope.i2();
                    if (z2) {
                        DrawScope.g2(contentDrawScope, brush, 0L, 0L, jH, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
                    float f5 = f4;
                    if (fIntBitsToFloat >= f5) {
                        DrawScope.g2(contentDrawScope, brush, j3, j4, BorderKt.m(jH, f5), 0.0f, stroke, null, 0, 208, null);
                        return;
                    }
                    float f6 = f3;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.b() >> 32)) - f3;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope.b() & 4294967295L)) - f3;
                    int iA = ClipOp.f25711b.a();
                    Brush brush2 = brush;
                    long j5 = jH;
                    DrawContext drawContextQ1 = contentDrawScope.Q1();
                    long jB = drawContextQ1.b();
                    drawContextQ1.g().t();
                    try {
                        drawContextQ1.e().c(f6, f6, fIntBitsToFloat2, fIntBitsToFloat3, iA);
                        DrawScope.g2(contentDrawScope, brush2, 0L, 0L, j5, 0.0f, null, null, 0, 246, null);
                    } finally {
                        drawContextQ1.g().k();
                        drawContextQ1.h(jB);
                    }
                }
            });
        }
        if (this.f4743c == null) {
            this.f4743c = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.f4743c;
        Intrinsics.checkNotNull(borderCache);
        final Path pathJ = BorderKt.j(borderCache.g(), rounded.b(), f3, z2);
        return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
                DrawScope.F1(contentDrawScope, pathJ, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    public final void A2(float f3) {
        if (Dp.i(this.f4744d, f3)) {
            return;
        }
        this.f4744d = f3;
        this.f4747h.X0();
    }

    public final void I1(Shape shape) {
        if (Intrinsics.areEqual(this.f4746g, shape)) {
            return;
        }
        this.f4746g = shape;
        this.f4747h.X0();
    }

    public final Brush w2() {
        return this.f4745f;
    }

    public final Shape x2() {
        return this.f4746g;
    }

    public final float y2() {
        return this.f4744d;
    }

    public final void z2(Brush brush) {
        if (Intrinsics.areEqual(this.f4745f, brush)) {
            return;
        }
        this.f4745f = brush;
        this.f4747h.X0();
    }

    private BorderModifierNode(float f3, Brush brush, Shape shape) {
        this.f4744d = f3;
        this.f4745f = brush;
        this.f4746g = shape;
        this.f4747h = (CacheDrawModifierNode) m2(DrawModifierKt.a(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                if (cacheDrawScope.M1(this.f4764a.y2()) < 0.0f || Size.h(cacheDrawScope.b()) <= 0.0f) {
                    return BorderKt.k(cacheDrawScope);
                }
                float f4 = 2;
                float fMin = Math.min(Dp.i(this.f4764a.y2(), Dp.f29970b.a()) ? 1.0f : (float) Math.ceil(cacheDrawScope.M1(this.f4764a.y2())), (float) Math.ceil(Size.h(cacheDrawScope.b()) / f4));
                float f5 = fMin / f4;
                long jE = Offset.e((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L));
                long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.b() >> 32)) - fMin)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.b() & 4294967295L)) - fMin))));
                boolean z2 = f4 * fMin > Size.h(cacheDrawScope.b());
                Outline outlineMo29createOutlinePq9zytI = this.f4764a.x2().mo29createOutlinePq9zytI(cacheDrawScope.b(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (outlineMo29createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = this.f4764a;
                    return borderModifierNode.u2(cacheDrawScope, borderModifierNode.w2(), (Outline.Generic) outlineMo29createOutlinePq9zytI, z2, fMin);
                }
                if (outlineMo29createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = this.f4764a;
                    return borderModifierNode2.v2(cacheDrawScope, borderModifierNode2.w2(), (Outline.Rounded) outlineMo29createOutlinePq9zytI, jE, jD, z2, fMin);
                }
                if (outlineMo29createOutlinePq9zytI instanceof Outline.Rectangle) {
                    return BorderKt.l(cacheDrawScope, this.f4764a.w2(), jE, jD, z2, fMin);
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }
}
