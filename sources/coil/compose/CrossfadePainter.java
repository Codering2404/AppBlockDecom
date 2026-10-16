package coil.compose;

import android.os.SystemClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CrossfadePainter extends Painter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Painter f55569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Painter f55570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ContentScale f55571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f55572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f55573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f55574m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f55577p;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f55575n = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f55576o = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableState f55578q = SnapshotStateKt__SnapshotStateKt.e(Float.valueOf(1.0f), null, 2, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final MutableState f55579r = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, int i3, boolean z2, boolean z3) {
        this.f55569h = painter;
        this.f55570i = painter2;
        this.f55571j = contentScale;
        this.f55572k = i3;
        this.f55573l = z2;
        this.f55574m = z3;
    }

    private final long o(long j3, long j4) {
        Size.Companion companion = Size.f25617b;
        return (j3 == companion.a() || Size.k(j3) || j4 == companion.a() || Size.k(j4)) ? j4 : ScaleFactorKt.a(j3, this.f55571j.a(j3, j4));
    }

    private final long p() {
        Painter painter = this.f55569h;
        long jL = painter != null ? painter.l() : Size.f25617b.b();
        Painter painter2 = this.f55570i;
        long jL2 = painter2 != null ? painter2.l() : Size.f25617b.b();
        Size.Companion companion = Size.f25617b;
        boolean z2 = jL != companion.a();
        boolean z3 = jL2 != companion.a();
        if (z2 && z3) {
            return SizeKt.a(Math.max(Size.i(jL), Size.i(jL2)), Math.max(Size.g(jL), Size.g(jL2)));
        }
        if (this.f55574m) {
            if (z2) {
                return jL;
            }
            if (z3) {
                return jL2;
            }
        }
        return companion.a();
    }

    private final void q(DrawScope drawScope, Painter painter, float f3) {
        if (painter == null || f3 <= 0.0f) {
            return;
        }
        long jB = drawScope.b();
        long jO = o(painter.l(), jB);
        if (jB == Size.f25617b.a() || Size.k(jB)) {
            painter.j(drawScope, jO, f3, r());
            return;
        }
        float f4 = 2;
        float fI = (Size.i(jB) - Size.i(jO)) / f4;
        float fG = (Size.g(jB) - Size.g(jO)) / f4;
        drawScope.Q1().e().k(fI, fG, fI, fG);
        painter.j(drawScope, jO, f3, r());
        DrawTransform drawTransformE = drawScope.Q1().e();
        float f5 = -fI;
        float f6 = -fG;
        drawTransformE.k(f5, f6, f5, f6);
    }

    private final ColorFilter r() {
        return (ColorFilter) this.f55579r.getValue();
    }

    private final int s() {
        return ((Number) this.f55575n.getValue()).intValue();
    }

    private final float t() {
        return ((Number) this.f55578q.getValue()).floatValue();
    }

    private final void u(ColorFilter colorFilter) {
        this.f55579r.setValue(colorFilter);
    }

    private final void v(int i3) {
        this.f55575n.setValue(Integer.valueOf(i3));
    }

    private final void w(float f3) {
        this.f55578q.setValue(Float.valueOf(f3));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        w(f3);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        u(colorFilter);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return p();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        if (this.f55577p) {
            q(drawScope, this.f55570i, t());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f55576o == -1) {
            this.f55576o = jUptimeMillis;
        }
        float f3 = (jUptimeMillis - this.f55576o) / this.f55572k;
        float fO = RangesKt.o(f3, 0.0f, 1.0f) * t();
        float fT = this.f55573l ? t() - fO : t();
        this.f55577p = f3 >= 1.0f;
        q(drawScope, this.f55569h, fT);
        q(drawScope, this.f55570i, fO);
        if (this.f55577p) {
            this.f55569h = null;
        } else {
            v(s() + 1);
        }
    }
}
