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
final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f17446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f17448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f17449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f17450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f17451h;

    public /* synthetic */ DefaultDrawerItemsColor(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10);
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State a(boolean z2, Composer composer, int i3) {
        composer.a0(-433512770);
        if (ComposerKt.M()) {
            ComposerKt.U(-433512770, i3, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:1099)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f17448e : this.f17449f), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State b(boolean z2, Composer composer, int i3) {
        composer.a0(1141354218);
        if (ComposerKt.M()) {
            ComposerKt.U(1141354218, i3, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:1089)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f17444a : this.f17445b), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State c(boolean z2, Composer composer, int i3) {
        composer.a0(1275109558);
        if (ComposerKt.M()) {
            ComposerKt.U(1275109558, i3, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:1094)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f17446c : this.f17447d), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State d(boolean z2, Composer composer, int i3) {
        composer.a0(-561675044);
        if (ComposerKt.M()) {
            ComposerKt.U(-561675044, i3, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:1106)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f17450g : this.f17451h), composer, 0);
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
        if (!(obj instanceof DefaultDrawerItemsColor)) {
            return false;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = (DefaultDrawerItemsColor) obj;
        if (Color.t(this.f17444a, defaultDrawerItemsColor.f17444a) && Color.t(this.f17445b, defaultDrawerItemsColor.f17445b) && Color.t(this.f17446c, defaultDrawerItemsColor.f17446c) && Color.t(this.f17447d, defaultDrawerItemsColor.f17447d) && Color.t(this.f17448e, defaultDrawerItemsColor.f17448e) && Color.t(this.f17449f, defaultDrawerItemsColor.f17449f) && Color.t(this.f17450g, defaultDrawerItemsColor.f17450g)) {
            return Color.t(this.f17451h, defaultDrawerItemsColor.f17451h);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Color.z(this.f17444a) * 31) + Color.z(this.f17445b)) * 31) + Color.z(this.f17446c)) * 31) + Color.z(this.f17447d)) * 31) + Color.z(this.f17448e)) * 31) + Color.z(this.f17449f)) * 31) + Color.z(this.f17450g)) * 31) + Color.z(this.f17451h);
    }

    private DefaultDrawerItemsColor(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.f17444a = j3;
        this.f17445b = j4;
        this.f17446c = j5;
        this.f17447d = j6;
        this.f17448e = j7;
        this.f17449f = j8;
        this.f17450g = j9;
        this.f17451h = j10;
    }
}
