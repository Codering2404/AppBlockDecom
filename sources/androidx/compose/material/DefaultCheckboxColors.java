package androidx.compose.material;

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
final class DefaultCheckboxColors implements CheckboxColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f12559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f12560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f12561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f12562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f12563k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12564a;

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
            f12564a = iArr;
        }
    }

    public /* synthetic */ DefaultCheckboxColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    @Override // androidx.compose.material.CheckboxColors
    public State a(ToggleableState toggleableState, Composer composer, int i3) {
        composer.a0(544656267);
        if (ComposerKt.M()) {
            ComposerKt.U(544656267, i3, -1, "androidx.compose.material.DefaultCheckboxColors.checkmarkColor (Checkbox.kt:413)");
        }
        ToggleableState toggleableState2 = ToggleableState.f28619b;
        State stateA = SingleValueAnimationKt.a(toggleableState == toggleableState2 ? this.f12554b : this.f12553a, AnimationSpecKt.n(toggleableState == toggleableState2 ? 100 : 50, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateA;
    }

    @Override // androidx.compose.material.CheckboxColors
    public State b(boolean z2, ToggleableState toggleableState, Composer composer, int i3) {
        long j3;
        Composer composer2;
        State stateP;
        composer.a0(-1568341342);
        if (ComposerKt.M()) {
            ComposerKt.U(-1568341342, i3, -1, "androidx.compose.material.DefaultCheckboxColors.borderColor (Checkbox.kt:450)");
        }
        if (z2) {
            int i4 = WhenMappings.f12564a[toggleableState.ordinal()];
            if (i4 == 1 || i4 == 2) {
                j3 = this.f12560h;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f12561i;
            }
        } else {
            int i5 = WhenMappings.f12564a[toggleableState.ordinal()];
            if (i5 == 1) {
                j3 = this.f12562j;
            } else if (i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f12562j;
            } else {
                j3 = this.f12563k;
            }
        }
        long j4 = j3;
        if (z2) {
            composer.a0(-840809961);
            composer2 = composer;
            stateP = SingleValueAnimationKt.a(j4, AnimationSpecKt.n(toggleableState == ToggleableState.f28619b ? 100 : 50, 0, null, 6, null), null, null, composer2, 0, 12);
            composer2.U();
        } else {
            composer2 = composer;
            composer2.a0(-840629417);
            stateP = SnapshotStateKt.p(Color.n(j4), composer2, 0);
            composer2.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return stateP;
    }

    @Override // androidx.compose.material.CheckboxColors
    public State c(boolean z2, ToggleableState toggleableState, Composer composer, int i3) {
        long j3;
        Composer composer2;
        State stateP;
        composer.a0(840901029);
        if (ComposerKt.M()) {
            ComposerKt.U(840901029, i3, -1, "androidx.compose.material.DefaultCheckboxColors.boxColor (Checkbox.kt:425)");
        }
        if (z2) {
            int i4 = WhenMappings.f12564a[toggleableState.ordinal()];
            if (i4 == 1 || i4 == 2) {
                j3 = this.f12555c;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f12556d;
            }
        } else {
            int i5 = WhenMappings.f12564a[toggleableState.ordinal()];
            if (i5 == 1) {
                j3 = this.f12557e;
            } else if (i5 == 2) {
                j3 = this.f12559g;
            } else {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = this.f12558f;
            }
        }
        long j4 = j3;
        if (z2) {
            composer.a0(507315190);
            composer2 = composer;
            stateP = SingleValueAnimationKt.a(j4, AnimationSpecKt.n(toggleableState == ToggleableState.f28619b ? 100 : 50, 0, null, 6, null), null, null, composer2, 0, 12);
            composer2.U();
        } else {
            composer2 = composer;
            composer2.a0(507495734);
            stateP = SnapshotStateKt.p(Color.n(j4), composer2, 0);
            composer2.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return stateP;
    }

    private DefaultCheckboxColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.f12553a = j3;
        this.f12554b = j4;
        this.f12555c = j5;
        this.f12556d = j6;
        this.f12557e = j7;
        this.f12558f = j8;
        this.f12559g = j9;
        this.f12560h = j10;
        this.f12561i = j11;
        this.f12562j = j12;
        this.f12563k = j13;
    }
}
