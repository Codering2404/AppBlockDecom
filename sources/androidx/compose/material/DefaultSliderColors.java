package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class DefaultSliderColors implements SliderColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f12610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f12611j;

    public /* synthetic */ DefaultSliderColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    @Override // androidx.compose.material.SliderColors
    public State a(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1575395620);
        if (ComposerKt.M()) {
            ComposerKt.U(1575395620, i3, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1100)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f12604c : this.f12605d : z3 ? this.f12606e : this.f12607f), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SliderColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(-1491563694);
        if (ComposerKt.M()) {
            ComposerKt.U(-1491563694, i3, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1111)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f12608g : this.f12609h : z3 ? this.f12610i : this.f12611j), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SliderColors
    public State c(boolean z2, Composer composer, int i3) {
        composer.a0(-1733795637);
        if (ComposerKt.M()) {
            ComposerKt.U(-1733795637, i3, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1095)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12602a : this.f12603b), composer, 0);
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
        return Color.t(this.f12602a, defaultSliderColors.f12602a) && Color.t(this.f12603b, defaultSliderColors.f12603b) && Color.t(this.f12604c, defaultSliderColors.f12604c) && Color.t(this.f12605d, defaultSliderColors.f12605d) && Color.t(this.f12606e, defaultSliderColors.f12606e) && Color.t(this.f12607f, defaultSliderColors.f12607f) && Color.t(this.f12608g, defaultSliderColors.f12608g) && Color.t(this.f12609h, defaultSliderColors.f12609h) && Color.t(this.f12610i, defaultSliderColors.f12610i) && Color.t(this.f12611j, defaultSliderColors.f12611j);
    }

    public int hashCode() {
        return (((((((((((((((((Color.z(this.f12602a) * 31) + Color.z(this.f12603b)) * 31) + Color.z(this.f12604c)) * 31) + Color.z(this.f12605d)) * 31) + Color.z(this.f12606e)) * 31) + Color.z(this.f12607f)) * 31) + Color.z(this.f12608g)) * 31) + Color.z(this.f12609h)) * 31) + Color.z(this.f12610i)) * 31) + Color.z(this.f12611j);
    }

    private DefaultSliderColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.f12602a = j3;
        this.f12603b = j4;
        this.f12604c = j5;
        this.f12605d = j6;
        this.f12606e = j7;
        this.f12607f = j8;
        this.f12608g = j9;
        this.f12609h = j10;
        this.f12610i = j11;
        this.f12611j = j12;
    }
}
