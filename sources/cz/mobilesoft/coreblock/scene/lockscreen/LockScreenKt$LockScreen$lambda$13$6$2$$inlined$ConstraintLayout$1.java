package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCountDownKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockScreenKt$LockScreen$lambda$13$6$2$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f105413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref f105414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConstraintLayoutScope f105415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f105416d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f105417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f105418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LockViewState f105419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f105420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function1 f105421j;

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    public final void invoke(Composer composer, int i3) {
        long jB;
        MutableState mutableState;
        Animatable animatable;
        long j3;
        boolean z2;
        float f3;
        ButtonColors buttonColorsA;
        Composer composer2 = composer;
        if ((i3 & 3) == 2 && composer2.l()) {
            composer2.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-74958949, i3, -1, wgbAZXYjrv.ClAgr);
        }
        this.f105413a.setValue(Unit.f139807a);
        if (this.f105414b.a() == CompositionSource.Unknown) {
            this.f105414b.b(CompositionSource.Content);
        }
        this.f105415c.j();
        ConstraintLayoutScope constraintLayoutScope = this.f105415c;
        composer2.a0(-2144476161);
        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope.n();
        ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
        ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityQ = this.f105419h.q();
        String strD = customBlockingScreenConfigEntityQ != null ? customBlockingScreenConfigEntityQ.d() : null;
        if (strD == null || strD.length() == 0) {
            composer2.a0(-2144419308);
            jB = ComposeColorsKt.j(composer2, 0).b();
            composer2.U();
        } else {
            composer2.a0(-2144326959);
            composer2.U();
            jB = ColorKt.h(Color.r(Color.f25715b.l(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.b(android.graphics.Color.parseColor(strD)));
        }
        long j4 = jB;
        Object objG = composer2.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
            composer2.w(objG);
        }
        MutableState mutableState2 = (MutableState) objG;
        Object objG2 = composer2.G();
        if (objG2 == companion.a()) {
            objG2 = AnimatableKt.b(0.5f, 0.0f, 2, null);
            composer2.w(objG2);
        }
        Animatable animatable2 = (Animatable) objG2;
        Boolean bool = Boolean.TRUE;
        boolean zI = composer2.I(animatable2);
        Object objG3 = composer2.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new LockScreenKt$LockScreen$4$4$3$2$1$1(animatable2, mutableState2, null);
            composer2.w(objG3);
        }
        EffectsKt.g(bool, (Function2) objG3, composer2, 6);
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityQ2 = this.f105419h.q();
        Integer numValueOf = customBlockingScreenConfigEntityQ2 != null ? Integer.valueOf(customBlockingScreenConfigEntityQ2.l()) : null;
        if (numValueOf == null) {
            composer2.a0(-2143252066);
            composer2.U();
            mutableState = mutableState2;
            animatable = animatable2;
            j3 = j4;
            f3 = 0.0f;
            z2 = true;
        } else {
            composer2.a0(-2143252065);
            if (numValueOf.intValue() <= 0 || !this.f105419h.z()) {
                mutableState = mutableState2;
                animatable = animatable2;
                j3 = j4;
                z2 = true;
                f3 = 0.0f;
                composer2.a0(-1272571649);
            } else {
                composer2.a0(-1232947480);
                Modifier.Companion companion2 = Modifier.b8;
                boolean Z = composer2.Z(constrainedLayoutReferenceB);
                Object objG4 = composer2.G();
                if (Z || objG4 == companion.a()) {
                    objG4 = new LockScreenKt$LockScreen$4$4$3$2$2$1$1(constrainedLayoutReferenceB);
                    composer2.w(objG4);
                }
                z2 = true;
                animatable = animatable2;
                mutableState = mutableState2;
                f3 = 0.0f;
                ComposeCountDownKt.b(SizeKt.v(PaddingKt.m(constraintLayoutScope.l(companion2, constrainedLayoutReferenceA, (Function1) objG4), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), Dp.g(40)), Dp.g(3), Dp.g(0), this.f105419h.n(), j4, ComposableLambdaKt.e(-1869587409, true, new LockScreenKt$LockScreen$4$4$3$2$2$2(this.f105419h, j4), composer2, 54), composer, 197040, 0);
                j3 = j4;
                composer2 = composer;
            }
            composer2.U();
            composer2.U();
        }
        Modifier.Companion companion3 = Modifier.b8;
        Object objG5 = composer2.G();
        if (objG5 == companion.a()) {
            objG5 = LockScreenKt$LockScreen$4$4$3$2$3$1.f105408a;
            composer2.w(objG5);
        }
        Modifier modifierA = ScaleKt.a(SizeKt.I(SizeKt.i(constraintLayoutScope.l(companion3, constrainedLayoutReferenceB, (Function1) objG5), Dp.g(48)), null, false, 3, null), ((Number) animatable.n()).floatValue());
        boolean z3 = (!this.f105419h.l() || this.f105420i) ? false : z2;
        if (this.f105420i) {
            composer2.a0(-2140471830);
            buttonColorsA = ButtonDefaults.f12323a.a(0L, 0L, j3, 0L, composer2, ButtonDefaults.f12334l << 12, 11);
            composer2.U();
        } else {
            composer2.a0(-2140209725);
            buttonColorsA = ButtonDefaults.f12323a.a(j3, 0L, ComposeColorsKt.j(composer2, 0).f0(), 0L, composer2, ButtonDefaults.f12334l << 12, 10);
            composer2.U();
        }
        ButtonColors buttonColors = buttonColorsA;
        RoundedCornerShape roundedCornerShapeG = RoundedCornerShapeKt.g();
        PaddingValues paddingValuesC = PaddingKt.c(Dp.g(52), f3, 2, null);
        boolean Z2 = composer2.Z(this.f105421j);
        Object objG6 = composer2.G();
        if (Z2 || objG6 == companion.a()) {
            objG6 = new LockScreenKt$LockScreen$4$4$3$2$4$1(this.f105421j, mutableState);
            composer2.w(objG6);
        }
        Composer composer3 = composer2;
        ButtonKt.a((Function0) objG6, modifierA, z3, null, null, roundedCornerShapeG, null, buttonColors, paddingValuesC, ComposableLambdaKt.e(1881152681, z2, new LockScreenKt$LockScreen$4$4$3$2$5(this.f105419h, this.f105420i), composer2, 54), composer3, 905969664, 88);
        composer3.U();
        boolean zI2 = composer3.I(this.f105415c) | composer3.I(this.f105416d);
        final ConstraintLayoutScope constraintLayoutScope2 = this.f105415c;
        final MutableState mutableState3 = this.f105417f;
        final MutableState mutableState4 = this.f105418g;
        final Channel channel = this.f105416d;
        Object objG7 = composer3.G();
        if (zI2 || objG7 == companion.a()) {
            objG7 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt$LockScreen$lambda$13$6$2$$inlined$ConstraintLayout$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1363invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1363invoke() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.h().a());
                    if (mutableState3.getValue() != null && mutableState4.getValue() != null) {
                        channel.h(rawConstraintSet);
                    } else {
                        mutableState3.setValue(rawConstraintSet);
                        mutableState4.setValue(mutableState3.getValue());
                    }
                }
            };
            composer3.w(objG7);
        }
        EffectsKt.j((Function0) objG7, composer3, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
