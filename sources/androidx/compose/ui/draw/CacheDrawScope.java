package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CacheDrawScope implements Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BuildDrawCacheParams f25391a = EmptyBuildDrawCacheParams.f25408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DrawResult f25392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentDrawScope f25393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f25394d;

    public static /* synthetic */ void H(CacheDrawScope cacheDrawScope, GraphicsLayer graphicsLayer, Density density, LayoutDirection layoutDirection, long j3, Function1 function1, int i3, Object obj) {
        Density density2 = density;
        if ((i3 & 1) != 0) {
            density2 = cacheDrawScope;
        }
        if ((i3 & 2) != 0) {
            layoutDirection = cacheDrawScope.getLayoutDirection();
        }
        if ((i3 & 4) != 0) {
            j3 = IntSizeKt.d(cacheDrawScope.b());
        }
        cacheDrawScope.z(graphicsLayer, density2, layoutDirection, j3, function1);
    }

    public final void I(BuildDrawCacheParams buildDrawCacheParams) {
        this.f25391a = buildDrawCacheParams;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f25391a.getDensity().K1();
    }

    public final void N(ContentDrawScope contentDrawScope) {
        this.f25393c = contentDrawScope;
    }

    public final void O(DrawResult drawResult) {
        this.f25392b = drawResult;
    }

    public final void Q(Function0 function0) {
        this.f25394d = function0;
    }

    public final long b() {
        return this.f25391a.b();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f25391a.getDensity().getDensity();
    }

    public final LayoutDirection getLayoutDirection() {
        return this.f25391a.getLayoutDirection();
    }

    public final DrawResult m() {
        return this.f25392b;
    }

    public final GraphicsLayer p() {
        Function0 function0 = this.f25394d;
        Intrinsics.checkNotNull(function0);
        return ((GraphicsContext) function0.invoke()).a();
    }

    public final DrawResult u(final Function1 function1) {
        return x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.ui.draw.CacheDrawScope$onDrawBehind$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                function1.invoke(contentDrawScope);
                contentDrawScope.i2();
            }
        });
    }

    public final DrawResult x(Function1 function1) {
        DrawResult drawResult = new DrawResult(function1);
        this.f25392b = drawResult;
        return drawResult;
    }

    public final void z(GraphicsLayer graphicsLayer, final Density density, final LayoutDirection layoutDirection, long j3, final Function1 function1) {
        final ContentDrawScope contentDrawScope = this.f25393c;
        Intrinsics.checkNotNull(contentDrawScope);
        final Density density2 = contentDrawScope.Q1().getDensity();
        final LayoutDirection layoutDirection2 = contentDrawScope.Q1().getLayoutDirection();
        contentDrawScope.D1(graphicsLayer, j3, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.draw.CacheDrawScope$record$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                DrawContext drawContextQ1 = drawScope.Q1();
                Density density3 = density;
                LayoutDirection layoutDirection3 = layoutDirection;
                drawContextQ1.d(density3);
                drawContextQ1.c(layoutDirection3);
                try {
                    function1.invoke(contentDrawScope);
                } finally {
                    DrawContext drawContextQ12 = drawScope.Q1();
                    Density density4 = density2;
                    LayoutDirection layoutDirection4 = layoutDirection2;
                    drawContextQ12.d(density4);
                    drawContextQ12.c(layoutDirection4);
                }
            }
        });
    }
}
