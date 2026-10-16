package com.valentinilk.shimmer;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerTheme {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f93821g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f93822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f93823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f93824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f93825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f93826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f93827f;

    public /* synthetic */ ShimmerTheme(AnimationSpec animationSpec, int i3, float f3, List list, List list2, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec, i3, f3, list, list2, f4);
    }

    public static /* synthetic */ ShimmerTheme b(ShimmerTheme shimmerTheme, AnimationSpec animationSpec, int i3, float f3, List list, List list2, float f4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            animationSpec = shimmerTheme.f93822a;
        }
        if ((i4 & 2) != 0) {
            i3 = shimmerTheme.f93823b;
        }
        if ((i4 & 4) != 0) {
            f3 = shimmerTheme.f93824c;
        }
        if ((i4 & 8) != 0) {
            list = shimmerTheme.f93825d;
        }
        if ((i4 & 16) != 0) {
            list2 = shimmerTheme.f93826e;
        }
        if ((i4 & 32) != 0) {
            f4 = shimmerTheme.f93827f;
        }
        List list3 = list2;
        float f5 = f4;
        return shimmerTheme.a(animationSpec, i3, f3, list, list3, f5);
    }

    public final ShimmerTheme a(AnimationSpec animationSpec, int i3, float f3, List shaderColors, List list, float f4) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shaderColors, "shaderColors");
        return new ShimmerTheme(animationSpec, i3, f3, shaderColors, list, f4, null);
    }

    public final AnimationSpec c() {
        return this.f93822a;
    }

    public final int d() {
        return this.f93823b;
    }

    public final float e() {
        return this.f93824c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShimmerTheme)) {
            return false;
        }
        ShimmerTheme shimmerTheme = (ShimmerTheme) obj;
        return Intrinsics.areEqual(this.f93822a, shimmerTheme.f93822a) && BlendMode.F(this.f93823b, shimmerTheme.f93823b) && Float.compare(this.f93824c, shimmerTheme.f93824c) == 0 && Intrinsics.areEqual(this.f93825d, shimmerTheme.f93825d) && Intrinsics.areEqual(this.f93826e, shimmerTheme.f93826e) && Dp.i(this.f93827f, shimmerTheme.f93827f);
    }

    public final List f() {
        return this.f93826e;
    }

    public final List g() {
        return this.f93825d;
    }

    public final float h() {
        return this.f93827f;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f93822a.hashCode() * 31) + BlendMode.G(this.f93823b)) * 31) + Float.hashCode(this.f93824c)) * 31) + this.f93825d.hashCode()) * 31;
        List list = this.f93826e;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Dp.j(this.f93827f);
    }

    public String toString() {
        return "ShimmerTheme(animationSpec=" + this.f93822a + ", blendMode=" + ((Object) BlendMode.H(this.f93823b)) + ", rotation=" + this.f93824c + ", shaderColors=" + this.f93825d + ", shaderColorStops=" + this.f93826e + ", shimmerWidth=" + ((Object) Dp.k(this.f93827f)) + ')';
    }

    private ShimmerTheme(AnimationSpec animationSpec, int i3, float f3, List list, List list2, float f4) {
        this.f93822a = animationSpec;
        this.f93823b = i3;
        this.f93824c = f3;
        this.f93825d = list;
        this.f93826e = list2;
        this.f93827f = f4;
    }
}
