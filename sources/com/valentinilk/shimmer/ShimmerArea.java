package com.valentinilk.shimmer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerArea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f93788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f93789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f93790c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f93792e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Rect f93794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f93795h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f93791d = Size.f25617b.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f93793f = Offset.f25596b.b();

    public ShimmerArea(float f3, float f4) {
        this.f93788a = f3;
        this.f93789b = i(g(f4));
        Rect.Companion companion = Rect.f25601e;
        this.f93794g = companion.a();
        this.f93795h = companion.a();
    }

    private final void a() {
        if (this.f93795h.y()) {
            return;
        }
        Rect rect = this.f93790c;
        if (rect == null) {
            rect = this.f93795h;
        }
        this.f93794g = rect;
        this.f93793f = Offset.q(Offset.t(this.f93795h.t()), this.f93794g.m());
        long jQ = this.f93794g.q();
        if (Size.f(this.f93791d, jQ)) {
            return;
        }
        this.f93791d = jQ;
        b();
    }

    private final void b() {
        float f3 = 2;
        float fI = Size.i(this.f93791d) / f3;
        double d3 = 2;
        this.f93792e = (((float) Math.cos(((float) Math.acos(fI / r1)) - this.f93789b)) * ((float) Math.sqrt(((float) Math.pow(fI, d3)) + ((float) Math.pow(Size.g(this.f93791d) / f3, d3)))) * f3) + this.f93788a;
    }

    private final float g(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("The shimmer's rotation must be a positive number");
        }
        float f4 = 90;
        return (-Math.abs((f3 % SensibleDefaults.X_OFFSET) - f4)) + f4;
    }

    private final float i(float f3) {
        return (f3 / SensibleDefaults.X_OFFSET) * 3.1415927f;
    }

    public final long c() {
        return this.f93793f;
    }

    public final Rect d() {
        return this.f93794g;
    }

    public final float e() {
        return this.f93792e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ShimmerArea.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.valentinilk.shimmer.ShimmerArea");
        ShimmerArea shimmerArea = (ShimmerArea) obj;
        return this.f93788a == shimmerArea.f93788a && this.f93789b == shimmerArea.f93789b;
    }

    public final Rect f() {
        return this.f93795h;
    }

    public final void h(Rect value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.f93795h)) {
            return;
        }
        this.f93795h = value;
        a();
    }

    public int hashCode() {
        return (Float.hashCode(this.f93788a) * 31) + Float.hashCode(this.f93789b);
    }

    public final void j(Rect rect) {
        if (Intrinsics.areEqual(this.f93790c, rect)) {
            return;
        }
        this.f93790c = rect;
        a();
    }
}
