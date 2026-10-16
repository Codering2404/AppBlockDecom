package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DeviceRenderNodeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f28021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f28023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f28024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f28025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f28026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f28027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f28028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f28029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f28030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f28031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f28032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f28033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f28034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f28035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f28036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f28037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f28038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f28039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private RenderEffect f28040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f28041y;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceRenderNodeData)) {
            return false;
        }
        DeviceRenderNodeData deviceRenderNodeData = (DeviceRenderNodeData) obj;
        return this.f28017a == deviceRenderNodeData.f28017a && this.f28018b == deviceRenderNodeData.f28018b && this.f28019c == deviceRenderNodeData.f28019c && this.f28020d == deviceRenderNodeData.f28020d && this.f28021e == deviceRenderNodeData.f28021e && this.f28022f == deviceRenderNodeData.f28022f && this.f28023g == deviceRenderNodeData.f28023g && Float.compare(this.f28024h, deviceRenderNodeData.f28024h) == 0 && Float.compare(this.f28025i, deviceRenderNodeData.f28025i) == 0 && Float.compare(this.f28026j, deviceRenderNodeData.f28026j) == 0 && Float.compare(this.f28027k, deviceRenderNodeData.f28027k) == 0 && Float.compare(this.f28028l, deviceRenderNodeData.f28028l) == 0 && this.f28029m == deviceRenderNodeData.f28029m && this.f28030n == deviceRenderNodeData.f28030n && Float.compare(this.f28031o, deviceRenderNodeData.f28031o) == 0 && Float.compare(this.f28032p, deviceRenderNodeData.f28032p) == 0 && Float.compare(this.f28033q, deviceRenderNodeData.f28033q) == 0 && Float.compare(this.f28034r, deviceRenderNodeData.f28034r) == 0 && Float.compare(this.f28035s, deviceRenderNodeData.f28035s) == 0 && Float.compare(this.f28036t, deviceRenderNodeData.f28036t) == 0 && this.f28037u == deviceRenderNodeData.f28037u && this.f28038v == deviceRenderNodeData.f28038v && Float.compare(this.f28039w, deviceRenderNodeData.f28039w) == 0 && Intrinsics.areEqual(this.f28040x, deviceRenderNodeData.f28040x) && CompositingStrategy.g(this.f28041y, deviceRenderNodeData.f28041y);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((Long.hashCode(this.f28017a) * 31) + Integer.hashCode(this.f28018b)) * 31) + Integer.hashCode(this.f28019c)) * 31) + Integer.hashCode(this.f28020d)) * 31) + Integer.hashCode(this.f28021e)) * 31) + Integer.hashCode(this.f28022f)) * 31) + Integer.hashCode(this.f28023g)) * 31) + Float.hashCode(this.f28024h)) * 31) + Float.hashCode(this.f28025i)) * 31) + Float.hashCode(this.f28026j)) * 31) + Float.hashCode(this.f28027k)) * 31) + Float.hashCode(this.f28028l)) * 31) + Integer.hashCode(this.f28029m)) * 31) + Integer.hashCode(this.f28030n)) * 31) + Float.hashCode(this.f28031o)) * 31) + Float.hashCode(this.f28032p)) * 31) + Float.hashCode(this.f28033q)) * 31) + Float.hashCode(this.f28034r)) * 31) + Float.hashCode(this.f28035s)) * 31) + Float.hashCode(this.f28036t)) * 31) + Boolean.hashCode(this.f28037u)) * 31) + Boolean.hashCode(this.f28038v)) * 31) + Float.hashCode(this.f28039w)) * 31;
        RenderEffect renderEffect = this.f28040x;
        return ((iHashCode + (renderEffect == null ? 0 : renderEffect.hashCode())) * 31) + CompositingStrategy.h(this.f28041y);
    }

    public String toString() {
        return "DeviceRenderNodeData(uniqueId=" + this.f28017a + ", left=" + this.f28018b + ", top=" + this.f28019c + ", right=" + this.f28020d + ", bottom=" + this.f28021e + ", width=" + this.f28022f + ", height=" + this.f28023g + ", scaleX=" + this.f28024h + ", scaleY=" + this.f28025i + ", translationX=" + this.f28026j + ", translationY=" + this.f28027k + ", elevation=" + this.f28028l + ", ambientShadowColor=" + this.f28029m + ", spotShadowColor=" + this.f28030n + ", rotationZ=" + this.f28031o + ", rotationX=" + this.f28032p + ", rotationY=" + this.f28033q + ", cameraDistance=" + this.f28034r + ", pivotX=" + this.f28035s + ", pivotY=" + this.f28036t + ", clipToOutline=" + this.f28037u + ", clipToBounds=" + this.f28038v + ", alpha=" + this.f28039w + ", renderEffect=" + this.f28040x + ", compositingStrategy=" + ((Object) CompositingStrategy.i(this.f28041y)) + ')';
    }
}
