package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class DatePickerColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f16853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f16854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f16855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f16856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f16857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f16858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f16859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f16860n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f16861o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f16862p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f16863q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f16864r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f16865s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f16866t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f16867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f16868v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f16869w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f16870x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final TextFieldColors f16871y;

    public /* synthetic */ DatePickerColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, TextFieldColors textFieldColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, textFieldColors);
    }

    public final DatePickerColors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, TextFieldColors textFieldColors) {
        return new DatePickerColors(j3 != 16 ? j3 : this.f16847a, j4 != 16 ? j4 : this.f16848b, j5 != 16 ? j5 : this.f16849c, j6 != 16 ? j6 : this.f16850d, j7 != 16 ? j7 : this.f16851e, j8 != 16 ? j8 : this.f16852f, j9 != 16 ? j9 : this.f16853g, j10 != 16 ? j10 : this.f16854h, j11 != 16 ? j11 : this.f16855i, j12 != 16 ? j12 : this.f16856j, j13 != 16 ? j13 : this.f16857k, j14 != 16 ? j14 : this.f16858l, j15 != 16 ? j15 : this.f16859m, j16 != 16 ? j16 : this.f16860n, j17 != 16 ? j17 : this.f16861o, j18 != 16 ? j18 : this.f16862p, j19 != 16 ? j19 : this.f16863q, j20 != 16 ? j20 : this.f16864r, j21 != 16 ? j21 : this.f16865s, j22 != 16 ? j22 : this.f16866t, j23 != 16 ? j23 : this.f16867u, j24 != 16 ? j24 : this.f16868v, j25 != 16 ? j25 : this.f16869w, j26 != 16 ? j26 : this.f16870x, o(textFieldColors, new Function0<TextFieldColors>() { // from class: androidx.compose.material3.DatePickerColors$copy$25
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TextFieldColors invoke() {
                return this.f16872a.f();
            }
        }), null);
    }

    public final State c(boolean z2, boolean z3, boolean z4, Composer composer, int i3) {
        State stateP;
        if (ComposerKt.M()) {
            ComposerKt.U(-1240482658, i3, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:933)");
        }
        long j3 = z2 ? z3 ? this.f16864r : this.f16865s : Color.f25715b.j();
        if (z4) {
            composer.a0(-217363149);
            stateP = SingleValueAnimationKt.a(j3, AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.U();
        } else {
            composer.a0(-217247953);
            stateP = SnapshotStateKt.p(Color.n(j3), composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public final State d(boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i3) {
        State stateA;
        if (ComposerKt.M()) {
            ComposerKt.U(-1233694918, i3, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:901)");
        }
        long j3 = (z3 && z5) ? this.f16862p : (!z3 || z5) ? (z4 && z5) ? this.f16869w : (!z4 || z5) ? z2 ? this.f16866t : z5 ? this.f16860n : this.f16861o : this.f16861o : this.f16863q;
        if (z4) {
            composer.a0(-828303257);
            stateA = SnapshotStateKt.p(Color.n(j3), composer, 0);
            composer.U();
        } else {
            composer.a0(-828241443);
            stateA = SingleValueAnimationKt.a(j3, AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    public final long e() {
        return this.f16847a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DatePickerColors)) {
            return false;
        }
        DatePickerColors datePickerColors = (DatePickerColors) obj;
        return Color.t(this.f16847a, datePickerColors.f16847a) && Color.t(this.f16848b, datePickerColors.f16848b) && Color.t(this.f16849c, datePickerColors.f16849c) && Color.t(this.f16850d, datePickerColors.f16850d) && Color.t(this.f16851e, datePickerColors.f16851e) && Color.t(this.f16853g, datePickerColors.f16853g) && Color.t(this.f16854h, datePickerColors.f16854h) && Color.t(this.f16855i, datePickerColors.f16855i) && Color.t(this.f16856j, datePickerColors.f16856j) && Color.t(this.f16857k, datePickerColors.f16857k) && Color.t(this.f16858l, datePickerColors.f16858l) && Color.t(this.f16859m, datePickerColors.f16859m) && Color.t(this.f16860n, datePickerColors.f16860n) && Color.t(this.f16861o, datePickerColors.f16861o) && Color.t(this.f16862p, datePickerColors.f16862p) && Color.t(this.f16863q, datePickerColors.f16863q) && Color.t(this.f16864r, datePickerColors.f16864r) && Color.t(this.f16865s, datePickerColors.f16865s) && Color.t(this.f16866t, datePickerColors.f16866t) && Color.t(this.f16867u, datePickerColors.f16867u) && Color.t(this.f16868v, datePickerColors.f16868v) && Color.t(this.f16869w, datePickerColors.f16869w);
    }

    public final TextFieldColors f() {
        return this.f16871y;
    }

    public final long g() {
        return this.f16868v;
    }

    public final long h() {
        return this.f16870x;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.z(this.f16847a) * 31) + Color.z(this.f16848b)) * 31) + Color.z(this.f16849c)) * 31) + Color.z(this.f16850d)) * 31) + Color.z(this.f16851e)) * 31) + Color.z(this.f16853g)) * 31) + Color.z(this.f16854h)) * 31) + Color.z(this.f16855i)) * 31) + Color.z(this.f16856j)) * 31) + Color.z(this.f16857k)) * 31) + Color.z(this.f16858l)) * 31) + Color.z(this.f16859m)) * 31) + Color.z(this.f16860n)) * 31) + Color.z(this.f16861o)) * 31) + Color.z(this.f16862p)) * 31) + Color.z(this.f16863q)) * 31) + Color.z(this.f16864r)) * 31) + Color.z(this.f16865s)) * 31) + Color.z(this.f16866t)) * 31) + Color.z(this.f16867u)) * 31) + Color.z(this.f16868v)) * 31) + Color.z(this.f16869w);
    }

    public final long i() {
        return this.f16849c;
    }

    public final long j() {
        return this.f16852f;
    }

    public final long k() {
        return this.f16851e;
    }

    public final long l() {
        return this.f16848b;
    }

    public final long m() {
        return this.f16867u;
    }

    public final long n() {
        return this.f16850d;
    }

    public final TextFieldColors o(TextFieldColors textFieldColors, Function0 function0) {
        return textFieldColors == null ? (TextFieldColors) function0.invoke() : textFieldColors;
    }

    public final State p(boolean z2, boolean z3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1306331107, i3, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:982)");
        }
        State stateA = SingleValueAnimationKt.a(z2 ? z3 ? this.f16858l : this.f16859m : Color.f25715b.j(), AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    public final State q(boolean z2, boolean z3, boolean z4, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(874111097, i3, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:959)");
        }
        State stateA = SingleValueAnimationKt.a((z3 && z4) ? this.f16856j : (!z3 || z4) ? z2 ? this.f16855i : z4 ? this.f16853g : this.f16854h : this.f16857k, AnimationSpecKt.n(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    private DatePickerColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, TextFieldColors textFieldColors) {
        this.f16847a = j3;
        this.f16848b = j4;
        this.f16849c = j5;
        this.f16850d = j6;
        this.f16851e = j7;
        this.f16852f = j8;
        this.f16853g = j9;
        this.f16854h = j10;
        this.f16855i = j11;
        this.f16856j = j12;
        this.f16857k = j13;
        this.f16858l = j14;
        this.f16859m = j15;
        this.f16860n = j16;
        this.f16861o = j17;
        this.f16862p = j18;
        this.f16863q = j19;
        this.f16864r = j20;
        this.f16865s = j21;
        this.f16866t = j22;
        this.f16867u = j23;
        this.f16868v = j24;
        this.f16869w = j25;
        this.f16870x = j26;
        this.f16871y = textFieldColors;
    }
}
