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
final class DefaultSelectableChipColors implements SelectableChipColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f12601i;

    public /* synthetic */ DefaultSelectableChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(189838188);
        if (ComposerKt.M()) {
            ComposerKt.U(189838188, i3, -1, "androidx.compose.material.DefaultSelectableChipColors.leadingIconColor (Chip.kt:680)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12598f : !z3 ? this.f12595c : this.f12601i), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State c(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(-403836585);
        if (ComposerKt.M()) {
            ComposerKt.U(-403836585, i3, -1, "androidx.compose.material.DefaultSelectableChipColors.backgroundColor (Chip.kt:660)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12596d : !z3 ? this.f12593a : this.f12599g), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State d(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(2025240134);
        if (ComposerKt.M()) {
            ComposerKt.U(2025240134, i3, -1, "androidx.compose.material.DefaultSelectableChipColors.contentColor (Chip.kt:670)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12597e : !z3 ? this.f12594b : this.f12600h), composer, 0);
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
        if (obj == null || DefaultSelectableChipColors.class != obj.getClass()) {
            return false;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = (DefaultSelectableChipColors) obj;
        return Color.t(this.f12593a, defaultSelectableChipColors.f12593a) && Color.t(this.f12594b, defaultSelectableChipColors.f12594b) && Color.t(this.f12595c, defaultSelectableChipColors.f12595c) && Color.t(this.f12596d, defaultSelectableChipColors.f12596d) && Color.t(this.f12597e, defaultSelectableChipColors.f12597e) && Color.t(this.f12598f, defaultSelectableChipColors.f12598f) && Color.t(this.f12599g, defaultSelectableChipColors.f12599g) && Color.t(this.f12600h, defaultSelectableChipColors.f12600h) && Color.t(this.f12601i, defaultSelectableChipColors.f12601i);
    }

    public int hashCode() {
        return (((((((((((((((Color.z(this.f12593a) * 31) + Color.z(this.f12594b)) * 31) + Color.z(this.f12595c)) * 31) + Color.z(this.f12596d)) * 31) + Color.z(this.f12597e)) * 31) + Color.z(this.f12598f)) * 31) + Color.z(this.f12599g)) * 31) + Color.z(this.f12600h)) * 31) + Color.z(this.f12601i);
    }

    private DefaultSelectableChipColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.f12593a = j3;
        this.f12594b = j4;
        this.f12595c = j5;
        this.f12596d = j6;
        this.f12597e = j7;
        this.f12598f = j8;
        this.f12599g = j9;
        this.f12600h = j10;
        this.f12601i = j11;
    }
}
