package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.experimental.kJ.HcgZcEUYo;

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
final class DefaultTextFieldForExposedDropdownMenusColors implements TextFieldColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f12649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f12650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f12651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f12652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f12653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f12654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f12655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f12656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f12657q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f12658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f12659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f12660t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f12661u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f12662v;

    private static final boolean k(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean l(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean m(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    @Override // androidx.compose.material.TextFieldColors
    public State a(boolean z2, Composer composer, int i3) {
        composer.a0(-1206593285);
        if (ComposerKt.M()) {
            ComposerKt.U(-1206593285, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.backgroundColor (ExposedDropdownMenu.android.kt:643)");
        }
        State stateP = SnapshotStateKt.p(Color.n(this.f12656p), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1834640354);
        if (ComposerKt.M()) {
            ComposerKt.U(1834640354, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.leadingIconColor (ExposedDropdownMenu.android.kt:581)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12650j : z3 ? this.f12651k : this.f12649i), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State c(boolean z2, Composer composer, int i3) {
        composer.a0(-855386788);
        if (ComposerKt.M()) {
            ComposerKt.U(-855386788, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.textColor (ExposedDropdownMenu.android.kt:670)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12641a : this.f12642b), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State e(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        Composer composer2;
        State stateP;
        composer.a0(-1956761869);
        if (ComposerKt.M()) {
            ComposerKt.U(-1956761869, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.indicatorColor (ExposedDropdownMenu.android.kt:626)");
        }
        long j3 = !z2 ? this.f12648h : z3 ? this.f12647g : k(FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14)) ? this.f12645e : this.f12646f;
        if (z2) {
            composer.a0(-887996185);
            composer2 = composer;
            stateP = SingleValueAnimationKt.a(j3, AnimationSpecKt.n(150, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.U();
        } else {
            composer2 = composer;
            composer2.a0(-887893327);
            stateP = SnapshotStateKt.p(Color.n(j3), composer2, 0);
            composer2.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return stateP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultTextFieldForExposedDropdownMenusColors.class != obj.getClass()) {
            return false;
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = (DefaultTextFieldForExposedDropdownMenusColors) obj;
        return Color.t(this.f12641a, defaultTextFieldForExposedDropdownMenusColors.f12641a) && Color.t(this.f12642b, defaultTextFieldForExposedDropdownMenusColors.f12642b) && Color.t(this.f12643c, defaultTextFieldForExposedDropdownMenusColors.f12643c) && Color.t(this.f12644d, defaultTextFieldForExposedDropdownMenusColors.f12644d) && Color.t(this.f12645e, defaultTextFieldForExposedDropdownMenusColors.f12645e) && Color.t(this.f12646f, defaultTextFieldForExposedDropdownMenusColors.f12646f) && Color.t(this.f12647g, defaultTextFieldForExposedDropdownMenusColors.f12647g) && Color.t(this.f12648h, defaultTextFieldForExposedDropdownMenusColors.f12648h) && Color.t(this.f12649i, defaultTextFieldForExposedDropdownMenusColors.f12649i) && Color.t(this.f12650j, defaultTextFieldForExposedDropdownMenusColors.f12650j) && Color.t(this.f12651k, defaultTextFieldForExposedDropdownMenusColors.f12651k) && Color.t(this.f12652l, defaultTextFieldForExposedDropdownMenusColors.f12652l) && Color.t(this.f12653m, defaultTextFieldForExposedDropdownMenusColors.f12653m) && Color.t(this.f12654n, defaultTextFieldForExposedDropdownMenusColors.f12654n) && Color.t(this.f12655o, defaultTextFieldForExposedDropdownMenusColors.f12655o) && Color.t(this.f12656p, defaultTextFieldForExposedDropdownMenusColors.f12656p) && Color.t(this.f12657q, defaultTextFieldForExposedDropdownMenusColors.f12657q) && Color.t(this.f12658r, defaultTextFieldForExposedDropdownMenusColors.f12658r) && Color.t(this.f12659s, defaultTextFieldForExposedDropdownMenusColors.f12659s) && Color.t(this.f12660t, defaultTextFieldForExposedDropdownMenusColors.f12660t) && Color.t(this.f12661u, defaultTextFieldForExposedDropdownMenusColors.f12661u) && Color.t(this.f12662v, defaultTextFieldForExposedDropdownMenusColors.f12662v);
    }

    @Override // androidx.compose.material.TextFieldColors
    public State f(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1174562608);
        if (ComposerKt.M()) {
            ComposerKt.U(1174562608, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.android.kt:593)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12654n : z3 ? this.f12655o : this.f12652l), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State g(boolean z2, Composer composer, int i3) {
        composer.a0(1682014002);
        if (ComposerKt.M()) {
            ComposerKt.U(1682014002, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.placeholderColor (ExposedDropdownMenu.android.kt:648)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12661u : this.f12662v), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.z(this.f12641a) * 31) + Color.z(this.f12642b)) * 31) + Color.z(this.f12643c)) * 31) + Color.z(this.f12644d)) * 31) + Color.z(this.f12645e)) * 31) + Color.z(this.f12646f)) * 31) + Color.z(this.f12647g)) * 31) + Color.z(this.f12648h)) * 31) + Color.z(this.f12649i)) * 31) + Color.z(this.f12650j)) * 31) + Color.z(this.f12651k)) * 31) + Color.z(this.f12652l)) * 31) + Color.z(this.f12653m)) * 31) + Color.z(this.f12654n)) * 31) + Color.z(this.f12655o)) * 31) + Color.z(this.f12656p)) * 31) + Color.z(this.f12657q)) * 31) + Color.z(this.f12658r)) * 31) + Color.z(this.f12659s)) * 31) + Color.z(this.f12660t)) * 31) + Color.z(this.f12661u)) * 31) + Color.z(this.f12662v);
    }

    @Override // androidx.compose.material.TextFieldColors
    public State i(boolean z2, Composer composer, int i3) {
        composer.a0(603205843);
        if (ComposerKt.M()) {
            ComposerKt.U(603205843, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.cursorColor (ExposedDropdownMenu.android.kt:675)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12644d : this.f12643c), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State j(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(1172839089);
        if (ComposerKt.M()) {
            ComposerKt.U(1172839089, i3, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.android.kt:608)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12654n : z3 ? this.f12655o : m(FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14)) ? this.f12653m : this.f12652l), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State h(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        long j3;
        composer.a0(-1110039826);
        if (ComposerKt.M()) {
            ComposerKt.U(-1110039826, i3, -1, HcgZcEUYo.wNE);
        }
        State stateA = FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14);
        if (!z2) {
            j3 = this.f12659s;
        } else if (z3) {
            j3 = this.f12660t;
        } else if (l(stateA)) {
            j3 = this.f12657q;
        } else {
            j3 = this.f12658r;
        }
        State stateP = SnapshotStateKt.p(Color.n(j3), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }
}
