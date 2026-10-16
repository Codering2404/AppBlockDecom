package cz.mobilesoft.coreblock.scene.lockscreen;

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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
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
public final class ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f105345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref f105346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConstraintLayoutScope f105347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f105348d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f105349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f105350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LockViewState f105351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f105352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function1 f105353j;

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public final void invoke(Composer composer, int i3) {
        ?? r14;
        int i4;
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-74958949, i3, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
        }
        this.f105345a.setValue(Unit.f139807a);
        if (this.f105346b.a() == CompositionSource.Unknown) {
            this.f105346b.b(CompositionSource.Content);
        }
        this.f105347c.j();
        ConstraintLayoutScope constraintLayoutScope = this.f105347c;
        composer.a0(-311106704);
        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope.n();
        ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
        ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
        if (this.f105351h.z()) {
            composer.a0(-311079208);
            Modifier.Companion companion = Modifier.b8;
            boolean Z = composer.Z(constrainedLayoutReferenceB);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$1$1(constrainedLayoutReferenceB);
                composer.w(objG);
            }
            r14 = 0;
            i4 = 3;
            ComposeCountDownKt.b(SizeKt.v(PaddingKt.m(constraintLayoutScope.l(companion, constrainedLayoutReferenceA, (Function1) objG), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), Dp.g(40)), Dp.g(3), Dp.g(0), this.f105351h.n(), 0L, ComposableLambdaKt.e(298736708, true, new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$2(this.f105351h), composer, 54), composer, 197040, 16);
        } else {
            r14 = 0;
            i4 = 3;
            composer.a0(-333699350);
        }
        composer.U();
        Modifier.Companion companion2 = Modifier.b8;
        Object objG2 = composer.G();
        Composer.Companion companion3 = Composer.f23746a;
        if (objG2 == companion3.a()) {
            objG2 = ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1.f105341a;
            composer.w(objG2);
        }
        Modifier modifierI = SizeKt.I(SizeKt.i(constraintLayoutScope.l(companion2, constrainedLayoutReferenceB, (Function1) objG2), Dp.g(48)), null, r14, i4, null);
        boolean zL = this.f105351h.l();
        ButtonColors buttonColorsA = ButtonDefaults.f12323a.a(ComposeColorsKt.j(composer, r14).b(), 0L, ComposeColorsKt.j(composer, r14).f0(), 0L, composer, ButtonDefaults.f12334l << 12, 10);
        RoundedCornerShape roundedCornerShapeG = RoundedCornerShapeKt.g();
        PaddingValues paddingValuesC = PaddingKt.c(Dp.g(52), 0.0f, 2, null);
        boolean zB = composer.b(this.f105352i) | composer.Z(this.f105353j);
        Object objG3 = composer.G();
        if (zB || objG3 == companion3.a()) {
            objG3 = new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$4$1(this.f105352i, this.f105353j);
            composer.w(objG3);
        }
        ButtonKt.a((Function0) objG3, modifierI, zL, null, null, roundedCornerShapeG, null, buttonColorsA, paddingValuesC, ComposableLambdaKt.e(1522667144, true, new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$5(this.f105351h), composer, 54), composer, 905969664, 88);
        composer.U();
        boolean zI = composer.I(this.f105347c) | composer.I(this.f105348d);
        final ConstraintLayoutScope constraintLayoutScope2 = this.f105347c;
        final MutableState mutableState = this.f105349f;
        final MutableState mutableState2 = this.f105350g;
        final Channel channel = this.f105348d;
        Object objG4 = composer.G();
        if (zI || objG4 == companion3.a()) {
            objG4 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1361invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1361invoke() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.h().a());
                    if (mutableState.getValue() != null && mutableState2.getValue() != null) {
                        channel.h(rawConstraintSet);
                    } else {
                        mutableState.setValue(rawConstraintSet);
                        mutableState2.setValue(mutableState.getValue());
                    }
                }
            };
            composer.w(objG4);
        }
        EffectsKt.j((Function0) objG4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
