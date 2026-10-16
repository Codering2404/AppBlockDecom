package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DefaultChipColors implements ChipColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12570f;

    public /* synthetic */ DefaultChipColors(long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8);
    }

    @Override // androidx.compose.material.ChipColors
    public State a(boolean z2, Composer composer, int i3) {
        composer.a0(-1593588247);
        if (ComposerKt.M()) {
            ComposerKt.U(-1593588247, i3, -1, "androidx.compose.material.DefaultChipColors.backgroundColor (Chip.kt:598)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12565a : this.f12568d), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.ChipColors
    public State b(boolean z2, Composer composer, int i3) {
        composer.a0(483145880);
        if (ComposerKt.M()) {
            ComposerKt.U(483145880, i3, -1, "androidx.compose.material.DefaultChipColors.contentColor (Chip.kt:603)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12566b : this.f12569e), composer, 0);
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
        if (obj == null || DefaultChipColors.class != obj.getClass()) {
            return false;
        }
        DefaultChipColors defaultChipColors = (DefaultChipColors) obj;
        return Color.t(this.f12565a, defaultChipColors.f12565a) && Color.t(this.f12566b, defaultChipColors.f12566b) && Color.t(this.f12567c, defaultChipColors.f12567c) && Color.t(this.f12568d, defaultChipColors.f12568d) && Color.t(this.f12569e, defaultChipColors.f12569e) && Color.t(this.f12570f, defaultChipColors.f12570f);
    }

    public int hashCode() {
        return (((((((((Color.z(this.f12565a) * 31) + Color.z(this.f12566b)) * 31) + Color.z(this.f12567c)) * 31) + Color.z(this.f12568d)) * 31) + Color.z(this.f12569e)) * 31) + Color.z(this.f12570f);
    }

    private DefaultChipColors(long j3, long j4, long j5, long j6, long j7, long j8) {
        this.f12565a = j3;
        this.f12566b = j4;
        this.f12567c = j5;
        this.f12568d = j6;
        this.f12569e = j7;
        this.f12570f = j8;
    }

    @Override // androidx.compose.material.ChipColors
    public State c(boolean z2, Composer composer, int i3) {
        long j3;
        composer.a0(1955749013);
        if (ComposerKt.M()) {
            ComposerKt.U(1955749013, i3, -1, MHoiDDglUlPJC.ZSUSlRYk);
        }
        if (z2) {
            j3 = this.f12567c;
        } else {
            j3 = this.f12570f;
        }
        State stateP = SnapshotStateKt.p(Color.n(j3), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }
}
