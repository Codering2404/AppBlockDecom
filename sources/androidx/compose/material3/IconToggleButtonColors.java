package androidx.compose.material3;

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
public final class IconToggleButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f17989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f17991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f17992f;

    public /* synthetic */ IconToggleButtonColors(long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8);
    }

    public static /* synthetic */ IconToggleButtonColors d(IconToggleButtonColors iconToggleButtonColors, long j3, long j4, long j5, long j6, long j7, long j8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = iconToggleButtonColors.f17987a;
        }
        return iconToggleButtonColors.c(j3, (i3 & 2) != 0 ? iconToggleButtonColors.f17988b : j4, (i3 & 4) != 0 ? iconToggleButtonColors.f17989c : j5, (i3 & 8) != 0 ? iconToggleButtonColors.f17990d : j6, (i3 & 16) != 0 ? iconToggleButtonColors.f17991e : j7, (i3 & 32) != 0 ? iconToggleButtonColors.f17992f : j8);
    }

    public final State a(boolean z2, boolean z3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1175394478, i3, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:1239)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f17989c : !z3 ? this.f17987a : this.f17991e), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public final State b(boolean z2, boolean z3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1340854054, i3, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:1256)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f17990d : !z3 ? this.f17988b : this.f17992f), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public final IconToggleButtonColors c(long j3, long j4, long j5, long j6, long j7, long j8) {
        return new IconToggleButtonColors(j3 != 16 ? j3 : this.f17987a, j4 != 16 ? j4 : this.f17988b, j5 != 16 ? j5 : this.f17989c, j6 != 16 ? j6 : this.f17990d, j7 != 16 ? j7 : this.f17991e, j8 != 16 ? j8 : this.f17992f, null);
    }

    public final long e() {
        return this.f17988b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IconToggleButtonColors)) {
            return false;
        }
        IconToggleButtonColors iconToggleButtonColors = (IconToggleButtonColors) obj;
        return Color.t(this.f17987a, iconToggleButtonColors.f17987a) && Color.t(this.f17988b, iconToggleButtonColors.f17988b) && Color.t(this.f17989c, iconToggleButtonColors.f17989c) && Color.t(this.f17990d, iconToggleButtonColors.f17990d) && Color.t(this.f17991e, iconToggleButtonColors.f17991e) && Color.t(this.f17992f, iconToggleButtonColors.f17992f);
    }

    public int hashCode() {
        return (((((((((Color.z(this.f17987a) * 31) + Color.z(this.f17988b)) * 31) + Color.z(this.f17989c)) * 31) + Color.z(this.f17990d)) * 31) + Color.z(this.f17991e)) * 31) + Color.z(this.f17992f);
    }

    private IconToggleButtonColors(long j3, long j4, long j5, long j6, long j7, long j8) {
        this.f17987a = j3;
        this.f17988b = j4;
        this.f17989c = j5;
        this.f17990d = j6;
        this.f17991e = j7;
        this.f17992f = j8;
    }
}
