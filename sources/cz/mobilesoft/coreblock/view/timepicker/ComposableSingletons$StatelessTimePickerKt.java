package cz.mobilesoft.coreblock.view.timepicker;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class ComposableSingletons$StatelessTimePickerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StatelessTimePickerKt f132970a = new ComposableSingletons$StatelessTimePickerKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f132971b = ComposableLambdaKt.c(-1305423666, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatelessTimePickerKt.y((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f132972c = ComposableLambdaKt.c(414302332, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatelessTimePickerKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f132973d = ComposableLambdaKt.c(-492469891, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatelessTimePickerKt.B((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f132974e = ComposableLambdaKt.c(1192727930, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatelessTimePickerKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-492469891, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.ComposableSingletons$StatelessTimePickerKt.lambda$-492469891.<anonymous> (StatelessTimePicker.kt:534)");
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TimePickerState timePickerStateZ = StatelessTimePickerKt.Z(TimePickerConfig.f133036h.d(), TimeUnit.HOURS.toMillis(14L) + TimeUnit.MINUTES.toMillis(30L), composer, 0, 0);
            objectRef.f140144a = timePickerStateZ;
            TimePickerConfiguration timePickerConfigurationA = TimePickerConfiguration.f133137r.a(composer, 6);
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$StatelessTimePickerKt.C(objectRef, (TimePickerState) obj);
                }
            };
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.D(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            StatelessTimePickerKt.N(null, timePickerStateZ, timePickerConfigurationA, function1, (Function1) objG, composer, 24576, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Ref.ObjectRef objectRef, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        objectRef.f140144a = newState;
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1192727930, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.ComposableSingletons$StatelessTimePickerKt.lambda$1192727930.<anonymous> (StatelessTimePicker.kt:554)");
            }
            TimePickerConfig.Companion companion = TimePickerConfig.f133036h;
            TimePickerConfig timePickerConfigD = companion.d();
            TimeUnit timeUnit = TimeUnit.HOURS;
            long millis = timeUnit.toMillis(10L);
            TimeUnit timeUnit2 = TimeUnit.MINUTES;
            TimePickerState timePickerStateZ = StatelessTimePickerKt.Z(timePickerConfigD, millis + timeUnit2.toMillis(30L), composer, 0, 0);
            TimePickerState timePickerStateZ2 = StatelessTimePickerKt.Z(companion.d(), timeUnit.toMillis(14L) + timeUnit2.toMillis(30L), composer, 0, 0);
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f3), Dp.g(f3));
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion3.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(2)), companion3.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            TimePickerConfiguration.Companion companion5 = TimePickerConfiguration.f133137r;
            float f4 = 4;
            float f5 = 0;
            TimePickerConfiguration timePickerConfigurationB = TimePickerConfiguration.b(companion5.a(composer, 6), 0, 0L, null, Dp.g(f5), 0.0f, Dp.g(f4), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131031, null);
            Object objG = composer.G();
            Composer.Companion companion6 = Composer.f23746a;
            if (objG == companion6.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.q((TimePickerState) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion6.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.r(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            StatelessTimePickerKt.N(modifierC, timePickerStateZ, timePickerConfigurationB, function1, (Function1) objG2, composer, 27648, 0);
            TextKt.c(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 6, 0, 65530);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            TimePickerConfiguration timePickerConfigurationB2 = TimePickerConfiguration.b(companion5.a(composer, 6), 0, 0L, null, Dp.g(f5), 0.0f, Dp.g(f4), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131031, null);
            Object objG3 = composer.G();
            if (objG3 == companion6.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.s((TimePickerState) obj);
                    }
                };
                composer.w(objG3);
            }
            Function1 function12 = (Function1) objG3;
            Object objG4 = composer.G();
            if (objG4 == companion6.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.t(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG4);
            }
            StatelessTimePickerKt.N(modifierC2, timePickerStateZ2, timePickerConfigurationB2, function12, (Function1) objG4, composer, 27648, 0);
            composer.y();
            float f6 = 24;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f6)), composer, 6);
            TextKt.c(DateHelperExtKt.g((Context) composer.q(AndroidCompositionLocals_androidKt.g()), timePickerStateZ2.i(timePickerStateZ) / ((long) 1000)), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f6)), composer, 6);
            Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
            String strB = StringResources_androidKt.b(R.string.d8, composer, 0);
            Object objG5 = composer.G();
            if (objG5 == companion6.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StatelessTimePickerKt.u();
                    }
                };
                composer.w(objG5);
            }
            FlatButtonsKt.u(modifierH2, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, true, false, (Function0) objG5, composer, 6, 3120, 6078);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(TimePickerState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(TimePickerState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(414302332, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.ComposableSingletons$StatelessTimePickerKt.lambda$414302332.<anonymous> (StatelessTimePicker.kt:515)");
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TimePickerState timePickerStateZ = StatelessTimePickerKt.Z(TimePickerConfig.f133036h.c(), TimeUnit.HOURS.toMillis(14L) + TimeUnit.MINUTES.toMillis(30L), composer, 0, 0);
            objectRef.f140144a = timePickerStateZ;
            TimePickerConfiguration timePickerConfigurationA = TimePickerConfiguration.f133137r.a(composer, 6);
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$StatelessTimePickerKt.w(objectRef, (TimePickerState) obj);
                }
            };
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.x(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            StatelessTimePickerKt.N(null, timePickerStateZ, timePickerConfigurationA, function1, (Function1) objG, composer, 24576, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Ref.ObjectRef objectRef, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        objectRef.f140144a = newState;
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1305423666, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.ComposableSingletons$StatelessTimePickerKt.lambda$-1305423666.<anonymous> (StatelessTimePicker.kt:496)");
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TimePickerState timePickerStateZ = StatelessTimePickerKt.Z(TimePickerConfig.f133036h.b(), TimeUnit.HOURS.toMillis(2L) + TimeUnit.MINUTES.toMillis(30L), composer, 0, 0);
            objectRef.f140144a = timePickerStateZ;
            TimePickerConfiguration timePickerConfigurationA = TimePickerConfiguration.f133137r.a(composer, 6);
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$StatelessTimePickerKt.z(objectRef, (TimePickerState) obj);
                }
            };
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatelessTimePickerKt.A(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            StatelessTimePickerKt.N(null, timePickerStateZ, timePickerConfigurationA, function1, (Function1) objG, composer, 24576, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Ref.ObjectRef objectRef, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        objectRef.f140144a = newState;
        return Unit.f139807a;
    }
}
