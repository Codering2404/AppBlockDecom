package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CheckboxColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f16268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f16269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f16270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f16271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f16272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f16273l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16274a;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.f28618a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.f28620c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.f28619b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16274a = iArr;
        }
    }

    public /* synthetic */ CheckboxColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    public final State a(boolean z2, ToggleableState toggleableState, Composer composer, int i3) {
        long j3;
        State stateP;
        if (ComposerKt.M()) {
            ComposerKt.U(1009643462, i3, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:534)");
        }
        if (z2) {
            int i4 = WhenMappings.f16274a[toggleableState.ordinal()];
            if (i4 == 1 || i4 == 2) {
                j3 = this.f16269h;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f16270i;
            }
        } else {
            int i5 = WhenMappings.f16274a[toggleableState.ordinal()];
            if (i5 == 1) {
                j3 = this.f16271j;
            } else if (i5 == 2) {
                j3 = this.f16273l;
            } else {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f16272k;
            }
        }
        long j4 = j3;
        if (z2) {
            composer.a0(-1725816497);
            stateP = SingleValueAnimationKt.a(j4, AnimationSpecKt.n(toggleableState == ToggleableState.f28619b ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
            composer.U();
        } else {
            composer.a0(-1725635953);
            stateP = SnapshotStateKt.p(Color.n(j4), composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public final State b(boolean z2, ToggleableState toggleableState, Composer composer, int i3) {
        long j3;
        State stateP;
        if (ComposerKt.M()) {
            ComposerKt.U(360729865, i3, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:501)");
        }
        if (z2) {
            int i4 = WhenMappings.f16274a[toggleableState.ordinal()];
            if (i4 == 1 || i4 == 2) {
                j3 = this.f16264c;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f16265d;
            }
        } else {
            int i5 = WhenMappings.f16274a[toggleableState.ordinal()];
            if (i5 == 1) {
                j3 = this.f16266e;
            } else if (i5 == 2) {
                j3 = this.f16268g;
            } else {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f16267f;
            }
        }
        long j4 = j3;
        if (z2) {
            composer.a0(-392211906);
            stateP = SingleValueAnimationKt.a(j4, AnimationSpecKt.n(toggleableState == ToggleableState.f28619b ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
            composer.U();
        } else {
            composer.a0(-392031362);
            stateP = SnapshotStateKt.p(Color.n(j4), composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP;
    }

    public final State c(ToggleableState toggleableState, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-507585681, i3, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:481)");
        }
        ToggleableState toggleableState2 = ToggleableState.f28619b;
        State stateA = SingleValueAnimationKt.a(toggleableState == toggleableState2 ? this.f16263b : this.f16262a, AnimationSpecKt.n(toggleableState == toggleableState2 ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    public final CheckboxColors d(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        return new CheckboxColors(j3 != 16 ? j3 : this.f16262a, j4 != 16 ? j4 : this.f16263b, j5 != 16 ? j5 : this.f16264c, j6 != 16 ? j6 : this.f16265d, j7 != 16 ? j7 : this.f16266e, j8 != 16 ? j8 : this.f16267f, j9 != 16 ? j9 : this.f16268g, j10 != 16 ? j10 : this.f16269h, j11 != 16 ? j11 : this.f16270i, j12 != 16 ? j12 : this.f16271j, j13 != 16 ? j13 : this.f16272k, j14 != 16 ? j14 : this.f16273l, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return Color.t(this.f16262a, checkboxColors.f16262a) && Color.t(this.f16263b, checkboxColors.f16263b) && Color.t(this.f16264c, checkboxColors.f16264c) && Color.t(this.f16265d, checkboxColors.f16265d) && Color.t(this.f16266e, checkboxColors.f16266e) && Color.t(this.f16267f, checkboxColors.f16267f) && Color.t(this.f16268g, checkboxColors.f16268g) && Color.t(this.f16269h, checkboxColors.f16269h) && Color.t(this.f16270i, checkboxColors.f16270i) && Color.t(this.f16271j, checkboxColors.f16271j) && Color.t(this.f16272k, checkboxColors.f16272k) && Color.t(this.f16273l, checkboxColors.f16273l);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.z(this.f16262a) * 31) + Color.z(this.f16263b)) * 31) + Color.z(this.f16264c)) * 31) + Color.z(this.f16265d)) * 31) + Color.z(this.f16266e)) * 31) + Color.z(this.f16267f)) * 31) + Color.z(this.f16268g)) * 31) + Color.z(this.f16269h)) * 31) + Color.z(this.f16270i)) * 31) + Color.z(this.f16271j)) * 31) + Color.z(this.f16272k)) * 31) + Color.z(this.f16273l);
    }

    private CheckboxColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.f16262a = j3;
        this.f16263b = j4;
        this.f16264c = j5;
        this.f16265d = j6;
        this.f16266e = j7;
        this.f16267f = j8;
        this.f16268g = j9;
        this.f16269h = j10;
        this.f16270i = j11;
        this.f16271j = j12;
        this.f16272k = j13;
        this.f16273l = j14;
    }
}
