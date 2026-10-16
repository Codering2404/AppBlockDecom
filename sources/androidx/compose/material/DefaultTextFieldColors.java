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
final class DefaultTextFieldColors implements TextFieldColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f12628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f12629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f12630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f12631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f12632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f12633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f12634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f12635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f12636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f12637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f12638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f12639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f12640u;

    public /* synthetic */ DefaultTextFieldColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23);
    }

    private static final boolean k(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean l(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    @Override // androidx.compose.material.TextFieldColors
    public State a(boolean z2, Composer composer, int i3) {
        composer.a0(-1423938813);
        if (ComposerKt.M()) {
            ComposerKt.U(-1423938813, i3, -1, "androidx.compose.material.DefaultTextFieldColors.backgroundColor (TextFieldDefaults.kt:881)");
        }
        State stateP = SnapshotStateKt.p(Color.n(this.f12634o), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State b(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1016171324);
        if (ComposerKt.M()) {
            ComposerKt.U(1016171324, i3, -1, "androidx.compose.material.DefaultTextFieldColors.leadingIconColor (TextFieldDefaults.kt:807)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12629j : z3 ? this.f12630k : this.f12628i), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State c(boolean z2, Composer composer, int i3) {
        composer.a0(9804418);
        if (ComposerKt.M()) {
            ComposerKt.U(9804418, i3, -1, "androidx.compose.material.DefaultTextFieldColors.textColor (TextFieldDefaults.kt:908)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12620a : this.f12621b), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State d(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(-1519634405);
        if (ComposerKt.M()) {
            ComposerKt.U(-1519634405, i3, -1, "androidx.compose.material.DefaultTextFieldColors.leadingIconColor (TextFieldDefaults.kt:822)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12629j : z3 ? this.f12630k : this.f12628i), composer, 0);
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
        composer.a0(998675979);
        if (ComposerKt.M()) {
            ComposerKt.U(998675979, i3, -1, "androidx.compose.material.DefaultTextFieldColors.indicatorColor (TextFieldDefaults.kt:864)");
        }
        long j3 = !z2 ? this.f12627h : z3 ? this.f12626g : k(FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14)) ? this.f12624e : this.f12625f;
        if (z2) {
            composer.a0(1613846559);
            composer2 = composer;
            stateP = SingleValueAnimationKt.a(j3, AnimationSpecKt.n(150, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.U();
        } else {
            composer2 = composer;
            composer2.a0(1613949417);
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
        if (obj == null || DefaultTextFieldColors.class != obj.getClass()) {
            return false;
        }
        DefaultTextFieldColors defaultTextFieldColors = (DefaultTextFieldColors) obj;
        return Color.t(this.f12620a, defaultTextFieldColors.f12620a) && Color.t(this.f12621b, defaultTextFieldColors.f12621b) && Color.t(this.f12622c, defaultTextFieldColors.f12622c) && Color.t(this.f12623d, defaultTextFieldColors.f12623d) && Color.t(this.f12624e, defaultTextFieldColors.f12624e) && Color.t(this.f12625f, defaultTextFieldColors.f12625f) && Color.t(this.f12626g, defaultTextFieldColors.f12626g) && Color.t(this.f12627h, defaultTextFieldColors.f12627h) && Color.t(this.f12628i, defaultTextFieldColors.f12628i) && Color.t(this.f12629j, defaultTextFieldColors.f12629j) && Color.t(this.f12630k, defaultTextFieldColors.f12630k) && Color.t(this.f12631l, defaultTextFieldColors.f12631l) && Color.t(this.f12632m, defaultTextFieldColors.f12632m) && Color.t(this.f12633n, defaultTextFieldColors.f12633n) && Color.t(this.f12634o, defaultTextFieldColors.f12634o) && Color.t(this.f12635p, defaultTextFieldColors.f12635p) && Color.t(this.f12636q, defaultTextFieldColors.f12636q) && Color.t(this.f12637r, defaultTextFieldColors.f12637r) && Color.t(this.f12638s, defaultTextFieldColors.f12638s) && Color.t(this.f12639t, defaultTextFieldColors.f12639t) && Color.t(this.f12640u, defaultTextFieldColors.f12640u);
    }

    @Override // androidx.compose.material.TextFieldColors
    public State f(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(225259054);
        if (ComposerKt.M()) {
            ComposerKt.U(225259054, i3, -1, "androidx.compose.material.DefaultTextFieldColors.trailingIconColor (TextFieldDefaults.kt:834)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12632m : z3 ? this.f12633n : this.f12631l), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State g(boolean z2, Composer composer, int i3) {
        composer.a0(264799724);
        if (ComposerKt.M()) {
            ComposerKt.U(264799724, i3, -1, "androidx.compose.material.DefaultTextFieldColors.placeholderColor (TextFieldDefaults.kt:886)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12639t : this.f12640u), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State h(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(727091888);
        if (ComposerKt.M()) {
            ComposerKt.U(727091888, i3, -1, "androidx.compose.material.DefaultTextFieldColors.labelColor (TextFieldDefaults.kt:895)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12637r : z3 ? this.f12638s : l(FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14)) ? this.f12635p : this.f12636q), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((Color.z(this.f12620a) * 31) + Color.z(this.f12621b)) * 31) + Color.z(this.f12622c)) * 31) + Color.z(this.f12623d)) * 31) + Color.z(this.f12624e)) * 31) + Color.z(this.f12625f)) * 31) + Color.z(this.f12626g)) * 31) + Color.z(this.f12627h)) * 31) + Color.z(this.f12628i)) * 31) + Color.z(this.f12629j)) * 31) + Color.z(this.f12630k)) * 31) + Color.z(this.f12631l)) * 31) + Color.z(this.f12632m)) * 31) + Color.z(this.f12633n)) * 31) + Color.z(this.f12634o)) * 31) + Color.z(this.f12635p)) * 31) + Color.z(this.f12636q)) * 31) + Color.z(this.f12637r)) * 31) + Color.z(this.f12638s)) * 31) + Color.z(this.f12639t)) * 31) + Color.z(this.f12640u);
    }

    @Override // androidx.compose.material.TextFieldColors
    public State i(boolean z2, Composer composer, int i3) {
        composer.a0(-1446422485);
        if (ComposerKt.M()) {
            ComposerKt.U(-1446422485, i3, -1, "androidx.compose.material.DefaultTextFieldColors.cursorColor (TextFieldDefaults.kt:913)");
        }
        State stateP = SnapshotStateKt.p(Color.n(z2 ? this.f12623d : this.f12622c), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State j(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(1383318157);
        if (ComposerKt.M()) {
            ComposerKt.U(1383318157, i3, -1, "androidx.compose.material.DefaultTextFieldColors.trailingIconColor (TextFieldDefaults.kt:849)");
        }
        State stateP = SnapshotStateKt.p(Color.n(!z2 ? this.f12632m : z3 ? this.f12633n : this.f12631l), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateP;
    }

    private DefaultTextFieldColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23) {
        this.f12620a = j3;
        this.f12621b = j4;
        this.f12622c = j5;
        this.f12623d = j6;
        this.f12624e = j7;
        this.f12625f = j8;
        this.f12626g = j9;
        this.f12627h = j10;
        this.f12628i = j11;
        this.f12629j = j12;
        this.f12630k = j13;
        this.f12631l = j14;
        this.f12632m = j15;
        this.f12633n = j16;
        this.f12634o = j17;
        this.f12635p = j18;
        this.f12636q = j19;
        this.f12637r = j20;
        this.f12638s = j21;
        this.f12639t = j22;
        this.f12640u = j23;
    }
}
