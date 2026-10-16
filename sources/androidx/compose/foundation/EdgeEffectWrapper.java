package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

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
final class EdgeEffectWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4907c = IntSize.f29998b.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EdgeEffect f4908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EdgeEffect f4909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EdgeEffect f4910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private EdgeEffect f4911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EdgeEffect f4912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EdgeEffect f4913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EdgeEffect f4914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EdgeEffect f4915k;

    public EdgeEffectWrapper(Context context, int i3) {
        this.f4905a = context;
        this.f4906b = i3;
    }

    private final EdgeEffect e(Orientation orientation) {
        EdgeEffect edgeEffectB = EdgeEffectCompat.f4901a.b(this.f4905a);
        edgeEffectB.setColor(this.f4906b);
        if (!IntSize.e(this.f4907c, IntSize.f29998b.a())) {
            if (orientation == Orientation.f6031a) {
                long j3 = this.f4907c;
                edgeEffectB.setSize((int) (j3 >> 32), (int) (j3 & 4294967295L));
                return edgeEffectB;
            }
            long j4 = this.f4907c;
            edgeEffectB.setSize((int) (j4 & 4294967295L), (int) (j4 >> 32));
        }
        return edgeEffectB;
    }

    private final boolean o(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    private final boolean y(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(EdgeEffectCompat.f4901a.c(edgeEffect) == 0.0f);
    }

    public final boolean A() {
        return y(this.f4912h);
    }

    public final boolean B() {
        return y(this.f4908d);
    }

    public final void C(long j3) {
        this.f4907c = j3;
        EdgeEffect edgeEffect = this.f4908d;
        if (edgeEffect != null) {
            edgeEffect.setSize((int) (j3 >> 32), (int) (j3 & 4294967295L));
        }
        EdgeEffect edgeEffect2 = this.f4909e;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize((int) (j3 >> 32), (int) (j3 & 4294967295L));
        }
        EdgeEffect edgeEffect3 = this.f4910f;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize((int) (j3 & 4294967295L), (int) (j3 >> 32));
        }
        EdgeEffect edgeEffect4 = this.f4911g;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize((int) (j3 & 4294967295L), (int) (j3 >> 32));
        }
        EdgeEffect edgeEffect5 = this.f4912h;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize((int) (j3 >> 32), (int) (j3 & 4294967295L));
        }
        EdgeEffect edgeEffect6 = this.f4913i;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize((int) (j3 >> 32), (int) (j3 & 4294967295L));
        }
        EdgeEffect edgeEffect7 = this.f4914j;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize((int) (j3 & 4294967295L), (int) (j3 >> 32));
        }
        EdgeEffect edgeEffect8 = this.f4915k;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize((int) (4294967295L & j3), (int) (j3 >> 32));
        }
    }

    public final void f() {
        EdgeEffect edgeEffect = this.f4908d;
        if (edgeEffect != null) {
            edgeEffect.finish();
        }
        EdgeEffect edgeEffect2 = this.f4909e;
        if (edgeEffect2 != null) {
            edgeEffect2.finish();
        }
        EdgeEffect edgeEffect3 = this.f4910f;
        if (edgeEffect3 != null) {
            edgeEffect3.finish();
        }
        EdgeEffect edgeEffect4 = this.f4911g;
        if (edgeEffect4 != null) {
            edgeEffect4.finish();
        }
        EdgeEffect edgeEffect5 = this.f4912h;
        if (edgeEffect5 != null) {
            edgeEffect5.finish();
        }
        EdgeEffect edgeEffect6 = this.f4913i;
        if (edgeEffect6 != null) {
            edgeEffect6.finish();
        }
        EdgeEffect edgeEffect7 = this.f4914j;
        if (edgeEffect7 != null) {
            edgeEffect7.finish();
        }
        EdgeEffect edgeEffect8 = this.f4915k;
        if (edgeEffect8 != null) {
            edgeEffect8.finish();
        }
    }

    public final EdgeEffect g() {
        EdgeEffect edgeEffect = this.f4909e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6031a);
        this.f4909e = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect h() {
        EdgeEffect edgeEffect = this.f4913i;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6031a);
        this.f4913i = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect i() {
        EdgeEffect edgeEffect = this.f4910f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6032b);
        this.f4910f = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect j() {
        EdgeEffect edgeEffect = this.f4914j;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6032b);
        this.f4914j = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect k() {
        EdgeEffect edgeEffect = this.f4911g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6032b);
        this.f4911g = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect l() {
        EdgeEffect edgeEffect = this.f4915k;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6032b);
        this.f4915k = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect m() {
        EdgeEffect edgeEffect = this.f4908d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6031a);
        this.f4908d = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect n() {
        EdgeEffect edgeEffect = this.f4912h;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(Orientation.f6031a);
        this.f4912h = edgeEffectE;
        return edgeEffectE;
    }

    public final boolean p() {
        return o(this.f4909e);
    }

    public final boolean q() {
        return y(this.f4913i);
    }

    public final boolean r() {
        return y(this.f4909e);
    }

    public final boolean s() {
        return o(this.f4910f);
    }

    public final boolean t() {
        return y(this.f4914j);
    }

    public final boolean u() {
        return y(this.f4910f);
    }

    public final boolean v() {
        return o(this.f4911g);
    }

    public final boolean w() {
        return y(this.f4915k);
    }

    public final boolean x() {
        return y(this.f4911g);
    }

    public final boolean z() {
        return o(this.f4908d);
    }
}
