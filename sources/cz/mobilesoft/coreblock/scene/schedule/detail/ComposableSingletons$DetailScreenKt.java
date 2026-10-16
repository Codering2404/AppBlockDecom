package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$DetailScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DetailScreenKt f116520a = new ComposableSingletons$DetailScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f116521b = ComposableLambdaKt.c(1741081858, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.l1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f116522c = ComposableLambdaKt.c(-2134368607, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.D((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f116523d = ComposableLambdaKt.c(-1714851776, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.A((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f116524e = ComposableLambdaKt.c(-1295334945, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f116525f = ComposableLambdaKt.c(-875818114, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.G((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f116526g = ComposableLambdaKt.c(-108304064, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function2 f116527h = ComposableLambdaKt.c(-1712307937, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DetailScreenKt.z((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function3 f116528i = ComposableLambdaKt.c(-175640184, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DetailScreenKt.C((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1714851776, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-1714851776.<anonymous> (DetailScreen.kt:134)");
            }
            AppBlockingSettings appBlockingSettings = new AppBlockingSettings(true, false, false, false, 14, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.p1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DetailScreenKt.B((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            DetailScreenKt.D0(appBlockingSettings, (Function1) objG, composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(RowScope rowScope, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-175640184, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-175640184.<anonymous> (DetailScreen.kt:698)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2134368607, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-2134368607.<anonymous> (DetailScreen.kt:125)");
            }
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            ScheduleViewState scheduleViewStateB = DetailPreviewsKt.b();
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.q1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DetailScreenKt.E((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$DetailScreenKt.F();
                    }
                };
                composer.w(objG3);
            }
            DetailScreenKt.g0(modalBottomSheetStateJ, scheduleViewStateB, function1, coroutineScope, false, (Function0) objG3, composer, ModalBottomSheetState.f13222e | 221568);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-875818114, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-875818114.<anonymous> (DetailScreen.kt:159)");
            }
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            ScheduleViewState scheduleViewStateC = DetailPreviewsKt.c();
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DetailScreenKt.H((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.n1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$DetailScreenKt.I();
                    }
                };
                composer.w(objG3);
            }
            DetailScreenKt.g0(modalBottomSheetStateJ, scheduleViewStateC, function1, coroutineScope, false, (Function0) objG3, composer, ModalBottomSheetState.f13222e | 221568);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1741081858, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$1741081858.<anonymous> (DetailScreen.kt:115)");
            }
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            ScheduleViewState scheduleViewStateA = DetailPreviewsKt.a();
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DetailScreenKt.u((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$DetailScreenKt.v();
                    }
                };
                composer.w(objG3);
            }
            DetailScreenKt.g0(modalBottomSheetStateJ, scheduleViewStateA, function1, coroutineScope, true, (Function0) objG3, composer, ModalBottomSheetState.f13222e | 221616);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-108304064, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-108304064.<anonymous> (DetailScreen.kt:651)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.zk, composer, 0), SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1295334945, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-1295334945.<anonymous> (DetailScreen.kt:142)");
            }
            ScheduleViewState scheduleViewState = new ScheduleViewState(null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, new ScheduleDescriptor.ScheduleId(1L, true), PremiumState.Subscription.Yearly.INSTANCE, 32767, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.o1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DetailScreenKt.y((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, (Function1) objG2, modalBottomSheetStateJ, composer, (ModalBottomSheetState.f13222e << 9) | 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1712307937, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$DetailScreenKt.lambda$-1712307937.<anonymous> (DetailScreen.kt:661)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 q() {
        return f116526g;
    }

    public final Function2 r() {
        return f116527h;
    }

    public final Function3 s() {
        return f116528i;
    }
}
