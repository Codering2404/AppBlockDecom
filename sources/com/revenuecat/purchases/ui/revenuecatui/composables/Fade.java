package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
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
public final class Fade implements PlaceholderHighlight {
    public static final int $stable = InfiniteRepeatableSpec.f3963d;
    private final InfiniteRepeatableSpec<Float> animationSpec;
    private final SolidColor brush;
    private final long highlightColor;

    public /* synthetic */ Fade(long j3, InfiniteRepeatableSpec infiniteRepeatableSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, infiniteRepeatableSpec);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name */
    private final long m878component10d7_KjU() {
        return this.highlightColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ Fade m879copyDxMtmZc$default(Fade fade, long j3, InfiniteRepeatableSpec infiniteRepeatableSpec, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = fade.highlightColor;
        }
        if ((i3 & 2) != 0) {
            infiniteRepeatableSpec = fade.animationSpec;
        }
        return fade.m881copyDxMtmZc(j3, infiniteRepeatableSpec);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    /* JADX INFO: renamed from: brush-d16Qtg0, reason: not valid java name */
    public Brush mo880brushd16Qtg0(float f3, long j3) {
        return this.brush;
    }

    public final InfiniteRepeatableSpec<Float> component2() {
        return this.animationSpec;
    }

    /* JADX INFO: renamed from: copy-DxMtmZc, reason: not valid java name */
    public final Fade m881copyDxMtmZc(long j3, InfiniteRepeatableSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new Fade(j3, animationSpec, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) obj;
        return Color.t(this.highlightColor, fade.highlightColor) && Intrinsics.areEqual(this.animationSpec, fade.animationSpec);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    public InfiniteRepeatableSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return (Color.z(this.highlightColor) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Fade(highlightColor=" + ((Object) Color.A(this.highlightColor)) + ", animationSpec=" + this.animationSpec + ')';
    }

    private Fade(long j3, InfiniteRepeatableSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.highlightColor = j3;
        this.animationSpec = animationSpec;
        this.brush = new SolidColor(j3, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    public float alpha(float f3) {
        return f3;
    }
}
