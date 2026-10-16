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
final class DefaultButtonColors implements ButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12537d;

    public /* synthetic */ DefaultButtonColors(long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6);
    }

    @Override // androidx.compose.material.ButtonColors
    public State a(boolean z2, Composer composer, int i3) {
        composer.a0(-655254499);
        if (ComposerKt.M()) {
            ComposerKt.U(-655254499, i3, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:587)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12534a : this.f12536c), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.ButtonColors
    public State b(boolean z2, Composer composer, int i3) {
        composer.a0(-2133647540);
        if (ComposerKt.M()) {
            ComposerKt.U(-2133647540, i3, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:592)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12535b : this.f12537d), composer, 0);
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
        if (obj == null || DefaultButtonColors.class != obj.getClass()) {
            return false;
        }
        DefaultButtonColors defaultButtonColors = (DefaultButtonColors) obj;
        return Color.t(this.f12534a, defaultButtonColors.f12534a) && Color.t(this.f12535b, defaultButtonColors.f12535b) && Color.t(this.f12536c, defaultButtonColors.f12536c) && Color.t(this.f12537d, defaultButtonColors.f12537d);
    }

    public int hashCode() {
        return (((((Color.z(this.f12534a) * 31) + Color.z(this.f12535b)) * 31) + Color.z(this.f12536c)) * 31) + Color.z(this.f12537d);
    }

    private DefaultButtonColors(long j3, long j4, long j5, long j6) {
        this.f12534a = j3;
        this.f12535b = j4;
        this.f12536c = j5;
        this.f12537d = j6;
    }
}
