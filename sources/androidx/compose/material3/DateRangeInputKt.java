package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.InputIdentifier;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class DateRangeInputKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f17238a = Dp.g(8);

    public static final void a(final Long l3, final Long l4, final Function2 function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        IntRange intRange2;
        SelectableDates selectableDates2;
        DateInputFormat dateInputFormat;
        Composer composerK = composer.k(-607499086);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(l3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(l4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(calendarModel) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            intRange2 = intRange;
            i4 |= composerK.I(intRange2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            intRange2 = intRange;
        }
        if ((196608 & i3) == 0) {
            i4 |= (i3 & 262144) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerK.Z(selectableDates2) ? 1048576 : 524288;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i3 & 12582912) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 8388608 : 4194304;
        }
        if ((i4 & 4793491) == 4793490 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-607499086, i4, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:43)");
            }
            Locale localeA = CalendarLocale_androidKt.a(composerK, 0);
            boolean Z = composerK.Z(localeA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = calendarModel.c(localeA);
                composerK.w(objG);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) objG;
            Strings.Companion companion = Strings.f22102b;
            String strA = Strings_androidKt.a(Strings.a(R.string.f19305h), composerK, 0);
            String strA2 = Strings_androidKt.a(Strings.a(R.string.f19307j), composerK, 0);
            String strA3 = Strings_androidKt.a(Strings.a(R.string.f19306i), composerK, 0);
            String strA4 = Strings_androidKt.a(Strings.a(R.string.C), composerK, 0);
            boolean Z2 = ((i4 & 458752) == 131072 || ((i4 & 262144) != 0 && composerK.Z(datePickerFormatter))) | composerK.Z(dateInputFormat2);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                dateInputFormat = dateInputFormat2;
                objG2 = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter, strA, strA2, strA3, strA4, null, null, 768, null);
                composerK.w(objG2);
            } else {
                dateInputFormat = dateInputFormat2;
            }
            DateInputValidator dateInputValidator = (DateInputValidator) objG2;
            dateInputValidator.b(l3);
            dateInputValidator.a(l4);
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion2, DateInputKt.f());
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(f17238a), Alignment.f25072a.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            final String upperCase = dateInputFormat.b().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            final String strA5 = Strings_androidKt.a(Strings.a(R.string.I), composerK, 0);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 0.5f, false, 2, null);
            InputIdentifier.Companion companion4 = InputIdentifier.f17997b;
            int iC = companion4.c();
            int i5 = i4 & 896;
            int i6 = i4 & 112;
            boolean z2 = (i6 == 32) | (i5 == 256);
            Object objG3 = composerK.G();
            if (z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(Long l5) {
                        function2.invoke(l5, l4);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Long) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG3);
            }
            int i7 = i4 & 7168;
            int i8 = (i4 >> 21) & 14;
            int i9 = i4;
            DateInputFormat dateInputFormat3 = dateInputFormat;
            DateInputKt.b(modifierC, l3, (Function1) objG3, calendarModel, ComposableLambdaKt.e(801434508, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(801434508, i10, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:80)");
                    }
                    String str = strA5;
                    Modifier.Companion companion5 = Modifier.b8;
                    boolean Z3 = composer2.Z(str) | composer2.Z(upperCase);
                    final String str2 = strA5;
                    final String str3 = upperCase;
                    Object objG4 = composer2.G();
                    if (Z3 || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str2 + ", " + str3);
                            }
                        };
                        composer2.w(objG4);
                    }
                    TextKt.c(str, SemanticsModifierKt.f(companion5, false, (Function1) objG4, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), ComposableLambdaKt.e(665407211, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(665407211, i10, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:86)");
                    }
                    TextKt.c(upperCase, SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }
                    }), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), iC, dateInputValidator, dateInputFormat3, localeA, datePickerColors, composerK, ((i4 << 3) & 112) | 1794048 | i7, i8);
            final String strA6 = Strings_androidKt.a(Strings.a(R.string.F), composerK, 0);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion2, 0.5f, false, 2, null);
            int iA2 = companion4.a();
            boolean z3 = (i5 == 256) | ((i9 & 14) == 4);
            Object objG4 = composerK.G();
            if (z3 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(Long l5) {
                        function2.invoke(l3, l5);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Long) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG4);
            }
            DateInputKt.b(modifierC2, l4, (Function1) objG4, calendarModel, ComposableLambdaKt.e(911487285, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(911487285, i10, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:103)");
                    }
                    String str = strA6;
                    Modifier.Companion companion5 = Modifier.b8;
                    boolean Z3 = composer2.Z(str) | composer2.Z(upperCase);
                    final String str2 = strA6;
                    final String str3 = upperCase;
                    Object objG5 = composer2.G();
                    if (Z3 || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str2 + ", " + str3);
                            }
                        };
                        composer2.w(objG5);
                    }
                    TextKt.c(str, SemanticsModifierKt.f(companion5, false, (Function1) objG5, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), ComposableLambdaKt.e(-961726252, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-961726252, i10, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:108)");
                    }
                    TextKt.c(upperCase, SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }
                    }), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), iA2, dateInputValidator, dateInputFormat3, localeA, datePickerColors, composerK, i6 | 1794048 | i7, i8);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    DateRangeInputKt.a(l3, l4, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
