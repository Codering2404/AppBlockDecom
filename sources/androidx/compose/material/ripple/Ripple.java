package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Deprecated
@Metadata
public abstract class Ripple implements Indication {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f15343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final State f15344c;

    public /* synthetic */ Ripple(boolean z2, float f3, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, state);
    }

    @Override // androidx.compose.foundation.Indication
    public final IndicationInstance a(InteractionSource interactionSource, Composer composer, int i3) {
        long jA;
        composer.a0(988743187);
        if (ComposerKt.M()) {
            ComposerKt.U(988743187, i3, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        RippleTheme rippleTheme = (RippleTheme) composer.q(RippleThemeKt.d());
        if (((Color) this.f15344c.getValue()).B() != 16) {
            composer.a0(-303571590);
            composer.U();
            jA = ((Color) this.f15344c.getValue()).B();
        } else {
            composer.a0(-303521246);
            jA = rippleTheme.a(composer, 0);
            composer.U();
        }
        State stateP = SnapshotStateKt.p(Color.n(jA), composer, 0);
        State stateP2 = SnapshotStateKt.p(rippleTheme.b(composer, 0), composer, 0);
        int i4 = i3 & 14;
        RippleIndicationInstance rippleIndicationInstanceC = c(interactionSource, this.f15342a, this.f15343b, stateP, stateP2, composer, i4 | ((i3 << 12) & 458752));
        boolean zI = composer.I(rippleIndicationInstanceC) | (((i4 ^ 6) > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Ripple$rememberUpdatedInstance$1$1(interactionSource, rippleIndicationInstanceC, null);
            composer.w(objG);
        }
        EffectsKt.f(rippleIndicationInstanceC, interactionSource, (Function2) objG, composer, (i3 << 3) & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return rippleIndicationInstanceC;
    }

    public abstract RippleIndicationInstance c(InteractionSource interactionSource, boolean z2, float f3, State state, State state2, Composer composer, int i3);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        return this.f15342a == ripple.f15342a && Dp.i(this.f15343b, ripple.f15343b) && Intrinsics.areEqual(this.f15344c, ripple.f15344c);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f15342a) * 31) + Dp.j(this.f15343b)) * 31) + this.f15344c.hashCode();
    }

    private Ripple(boolean z2, float f3, State state) {
        this.f15342a = z2;
        this.f15343b = f3;
        this.f15344c = state;
    }
}
