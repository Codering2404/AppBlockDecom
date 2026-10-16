package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.material.SliderColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class DefaultSliderColors implements SliderColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f131994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f131995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f131996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f131997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f131998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f131999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f132000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f132001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f132002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f132003j;

    @Override // androidx.compose.material.SliderColors
    public State a(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1432035806);
        if (ComposerKt.M()) {
            ComposerKt.U(1432035806, i3, -1, "cz.mobilesoft.coreblock.view.compose.slider.DefaultSliderColors.trackColor (StyledSlider.kt:709)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f131996c : this.f131997d : z3 ? this.f131998e : this.f131999f), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SliderColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1117577740);
        if (ComposerKt.M()) {
            ComposerKt.U(1117577740, i3, -1, "cz.mobilesoft.coreblock.view.compose.slider.DefaultSliderColors.tickColor (StyledSlider.kt:720)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f132000g : this.f132001h : z3 ? this.f132002i : this.f132003j), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SliderColors
    public State c(boolean z2, Composer composer, int i3) {
        composer.a0(-502129531);
        if (ComposerKt.M()) {
            ComposerKt.U(-502129531, i3, -1, "cz.mobilesoft.coreblock.view.compose.slider.DefaultSliderColors.thumbColor (StyledSlider.kt:704)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f131994a : this.f131995b), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultSliderColors.class != obj.getClass()) {
            return false;
        }
        DefaultSliderColors defaultSliderColors = (DefaultSliderColors) obj;
        return Color.t(this.f131994a, defaultSliderColors.f131994a) && Color.t(this.f131995b, defaultSliderColors.f131995b) && Color.t(this.f131996c, defaultSliderColors.f131996c) && Color.t(this.f131997d, defaultSliderColors.f131997d) && Color.t(this.f131998e, defaultSliderColors.f131998e) && Color.t(this.f131999f, defaultSliderColors.f131999f) && Color.t(this.f132000g, defaultSliderColors.f132000g) && Color.t(this.f132001h, defaultSliderColors.f132001h) && Color.t(this.f132002i, defaultSliderColors.f132002i) && Color.t(this.f132003j, defaultSliderColors.f132003j);
    }

    public int hashCode() {
        return (((((((((((((((((Color.z(this.f131994a) * 31) + Color.z(this.f131995b)) * 31) + Color.z(this.f131996c)) * 31) + Color.z(this.f131997d)) * 31) + Color.z(this.f131998e)) * 31) + Color.z(this.f131999f)) * 31) + Color.z(this.f132000g)) * 31) + Color.z(this.f132001h)) * 31) + Color.z(this.f132002i)) * 31) + Color.z(this.f132003j);
    }
}
