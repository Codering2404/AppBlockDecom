package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f99987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref f99988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConstraintLayoutScope f99989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f99990d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f99991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f99992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ProfileType f99993h;

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    public final void invoke(Composer composer, int i3) {
        String strB;
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-74958949, i3, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
        }
        this.f99987a.setValue(Unit.f139807a);
        if (this.f99988b.a() == CompositionSource.Unknown) {
            this.f99988b.b(CompositionSource.Content);
        }
        this.f99989c.j();
        ConstraintLayoutScope constraintLayoutScope = this.f99989c;
        composer.a0(-1939907227);
        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope.n();
        ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
        ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorF = constraintLayoutScope.f(Dp.g(32));
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierV = SizeKt.v(companion, Dp.g(24));
        boolean Z = composer.Z(horizontalAnchorF);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$1$1(horizontalAnchorF);
            composer.w(objG);
        }
        IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, this.f99993h.getAlternativeScheduleIconResId(), composer, 6), null, constraintLayoutScope.l(modifierV, constrainedLayoutReferenceA, (Function1) objG), ComposeColorsKt.j(composer, 0).p(), composer, 48, 0);
        boolean Z2 = composer.Z(horizontalAnchorF);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$2$1(horizontalAnchorF);
            composer.w(objG2);
        }
        Modifier modifierL = constraintLayoutScope.l(companion, constrainedLayoutReferenceB, (Function1) objG2);
        Integer titleResId = this.f99993h.getTitleResId();
        if (titleResId == null) {
            composer.a0(-1938600858);
            composer.U();
            strB = null;
        } else {
            composer.a0(-1938600857);
            strB = StringResources_androidKt.b(titleResId.intValue(), composer, 0);
            composer.U();
        }
        if (strB == null) {
            strB = "";
        }
        TextKt.c(strB, modifierL, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(16), null, null, null, 0, 0, null, 16646143, null), composer, 0, 0, 65016);
        composer.U();
        boolean zI = composer.I(this.f99989c) | composer.I(this.f99990d);
        final ConstraintLayoutScope constraintLayoutScope2 = this.f99989c;
        final MutableState mutableState = this.f99991f;
        final MutableState mutableState2 = this.f99992g;
        final Channel channel = this.f99990d;
        Object objG3 = composer.G();
        if (zI || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1359invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1359invoke() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.h().a());
                    if (mutableState.getValue() != null && mutableState2.getValue() != null) {
                        channel.h(rawConstraintSet);
                    } else {
                        mutableState.setValue(rawConstraintSet);
                        mutableState2.setValue(mutableState.getValue());
                    }
                }
            };
            composer.w(objG3);
        }
        EffectsKt.j((Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
