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
final class DefaultSwitchColors implements SwitchColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12619h;

    public /* synthetic */ DefaultSwitchColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10);
    }

    @Override // androidx.compose.material.SwitchColors
    public State a(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(-1176343362);
        if (ComposerKt.M()) {
            ComposerKt.U(-1176343362, i3, -1, "androidx.compose.material.DefaultSwitchColors.trackColor (Switch.kt:382)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f12613b : this.f12615d : z3 ? this.f12617f : this.f12619h), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.SwitchColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(-66424183);
        if (ComposerKt.M()) {
            ComposerKt.U(-66424183, i3, -1, "androidx.compose.material.DefaultSwitchColors.thumbColor (Switch.kt:371)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? z3 ? this.f12612a : this.f12614c : z3 ? this.f12616e : this.f12618g), composer, 0);
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
        if (obj == null || DefaultSwitchColors.class != obj.getClass()) {
            return false;
        }
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) obj;
        return Color.t(this.f12612a, defaultSwitchColors.f12612a) && Color.t(this.f12613b, defaultSwitchColors.f12613b) && Color.t(this.f12614c, defaultSwitchColors.f12614c) && Color.t(this.f12615d, defaultSwitchColors.f12615d) && Color.t(this.f12616e, defaultSwitchColors.f12616e) && Color.t(this.f12617f, defaultSwitchColors.f12617f) && Color.t(this.f12618g, defaultSwitchColors.f12618g) && Color.t(this.f12619h, defaultSwitchColors.f12619h);
    }

    public int hashCode() {
        return (((((((((((((Color.z(this.f12612a) * 31) + Color.z(this.f12613b)) * 31) + Color.z(this.f12614c)) * 31) + Color.z(this.f12615d)) * 31) + Color.z(this.f12616e)) * 31) + Color.z(this.f12617f)) * 31) + Color.z(this.f12618g)) * 31) + Color.z(this.f12619h);
    }

    private DefaultSwitchColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.f12612a = j3;
        this.f12613b = j4;
        this.f12614c = j5;
        this.f12615d = j6;
        this.f12616e = j7;
        this.f12617f = j8;
        this.f12618g = j9;
        this.f12619h = j10;
    }
}
