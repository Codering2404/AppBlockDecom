package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
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
import kotlin.text.StringsKt;

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
public final class DateInputKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PaddingValues f16793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f16794b = Dp.g(16);

    static {
        float f3 = 24;
        f16793a = PaddingKt.e(Dp.g(f3), Dp.g(10), Dp.g(f3), 0.0f, 8, null);
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final void a(final Long l3, final Function1 function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        DateInputFormat dateInputFormat;
        int i5;
        ?? r02;
        Composer composer3;
        Composer composerK = composer.k(643325609);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(l3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(calendarModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(intRange) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= (i3 & 32768) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(selectableDates) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 1048576 : 524288;
        }
        if ((599187 & i4) == 599186 && composerK.l()) {
            composerK.Q();
            composer3 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(643325609, i4, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:60)");
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
            boolean Z2 = composerK.Z(dateInputFormat2) | ((i4 & 57344) == 16384 || ((i4 & 32768) != 0 && composerK.Z(datePickerFormatter)));
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                composer2 = composerK;
                dateInputFormat = dateInputFormat2;
                i5 = i4;
                r02 = 1;
                DateInputValidator dateInputValidator = new DateInputValidator(intRange, selectableDates, dateInputFormat, datePickerFormatter, strA, strA2, strA3, "", null, null, 768, null);
                composer2.w(dateInputValidator);
                objG2 = dateInputValidator;
            } else {
                composer2 = composerK;
                i5 = i4;
                dateInputFormat = dateInputFormat2;
                r02 = 1;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) objG2;
            final String upperCase = dateInputFormat.b().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            final String strA4 = Strings_androidKt.a(Strings.a(R.string.f19308k), composer2, 0);
            Modifier modifierH = PaddingKt.h(SizeKt.h(Modifier.b8, 0.0f, r02, null), f16793a);
            int iB = InputIdentifier.f17997b.b();
            dateInputValidator2.b(l3);
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1819015125, r02, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer4, int i6) {
                    if ((i6 & 3) == 2 && composer4.l()) {
                        composer4.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1819015125, i6, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:87)");
                    }
                    String str = strA4;
                    Modifier.Companion companion2 = Modifier.b8;
                    boolean Z3 = composer4.Z(str) | composer4.Z(upperCase);
                    final String str2 = strA4;
                    final String str3 = upperCase;
                    Object objG3 = composer4.G();
                    if (Z3 || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2$1$1
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
                        composer4.w(objG3);
                    }
                    TextKt.c(str, SemanticsModifierKt.f(companion2, false, (Function1) objG3, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54);
            ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(-564233108, r02, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer4, int i6) {
                    if ((i6 & 3) == 2 && composer4.l()) {
                        composer4.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-564233108, i6, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:92)");
                    }
                    TextKt.c(upperCase, SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$3.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }
                    }), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 0, 0, 131068);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54);
            int i6 = i5 << 3;
            Composer composer4 = composer2;
            b(modifierH, l3, function1, calendarModel, composableLambdaE, composableLambdaE2, iB, dateInputValidator2, dateInputFormat, localeA, datePickerColors, composer4, (i6 & 112) | 1794054 | (i6 & 896) | (i6 & 7168), (i5 >> 18) & 14);
            composer3 = composer4;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer3.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer5, int i7) {
                    DateInputKt.a(l3, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer5, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void b(final Modifier modifier, final Long l3, final Function1 function1, final CalendarModel calendarModel, final Function2 function2, final Function2 function22, final int i3, final DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, final Locale locale, final DatePickerColors datePickerColors, Composer composer, final int i4, final int i5) {
        int i6;
        Function1 function12;
        int i7;
        final MutableState mutableState;
        int i8;
        Composer composer2;
        final DateInputFormat dateInputFormat2 = dateInputFormat;
        Composer composerK = composer.k(-857008589);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(l3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            function12 = function1;
            i6 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function12 = function1;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.I(calendarModel) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.I(function2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerK.I(function22) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= composerK.e(i3) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= composerK.Z(dateInputValidator) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerK.Z(dateInputFormat2) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerK.I(locale) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerK.Z(datePickerColors) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i6 & 306783379) == 306783378 && (i7 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-857008589, i6, i7, "androidx.compose.material3.DateInputTextField (DateInput.kt:121)");
            }
            MutableState mutableState2 = (MutableState) RememberSaveableKt.e(new Object[0], null, null, new Function0<MutableState<String>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1
                @Override // kotlin.jvm.functions.Function0
                public final MutableState invoke() {
                    return SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                }
            }, composerK, 3072, 6);
            Object[] objArr = new Object[0];
            Saver saverA = TextFieldValue.f29419d.a();
            boolean zI = ((i6 & 112) == 32) | composerK.I(calendarModel);
            int i9 = 234881024 & i6;
            boolean zI2 = zI | (i9 == 67108864) | composerK.I(locale);
            Object objG = composerK.G();
            if (zI2 || objG == Composer.f23746a.a()) {
                objG = new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.runtime.MutableState invoke() {
                        /*
                            r8 = this;
                            java.lang.Long r0 = r1
                            if (r0 == 0) goto L1b
                            androidx.compose.material3.internal.CalendarModel r1 = r2
                            androidx.compose.material3.internal.DateInputFormat r2 = r3
                            java.util.Locale r3 = r4
                            long r4 = r0.longValue()
                            java.lang.String r0 = r2.c()
                            java.lang.String r0 = r1.a(r4, r0, r3)
                            if (r0 != 0) goto L19
                            goto L1b
                        L19:
                            r2 = r0
                            goto L1e
                        L1b:
                            java.lang.String r0 = ""
                            goto L19
                        L1e:
                            r0 = 0
                            long r3 = androidx.compose.ui.text.TextRangeKt.b(r0, r0)
                            androidx.compose.ui.text.input.TextFieldValue r1 = new androidx.compose.ui.text.input.TextFieldValue
                            r5 = 0
                            r6 = 4
                            r7 = 0
                            r1.<init>(r2, r3, r5, r6, r7)
                            r0 = 2
                            r2 = 0
                            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt.j(r1, r2, r0, r2)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1.invoke():androidx.compose.runtime.MutableState");
                    }
                };
                composerK.w(objG);
            }
            final MutableState mutableStateD = RememberSaveableKt.d(objArr, saverA, null, (Function0) objG, composerK, 0, 4);
            TextFieldValue textFieldValueC = c(mutableStateD);
            boolean Z = (i9 == 67108864) | composerK.Z(mutableStateD) | composerK.Z(mutableState2) | ((i6 & 896) == 256) | composerK.I(calendarModel) | ((29360128 & i6) == 8388608) | ((3670016 & i6) == 1048576) | composerK.I(locale);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                mutableState = mutableState2;
                i8 = i6;
                final Function1 function13 = function12;
                Function1<TextFieldValue, Unit> function14 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(TextFieldValue textFieldValue) {
                        if (textFieldValue.i().length() <= dateInputFormat2.c().length()) {
                            String strI = textFieldValue.i();
                            for (int i10 = 0; i10 < strI.length(); i10++) {
                                if (!Character.isDigit(strI.charAt(i10))) {
                                    return;
                                }
                            }
                            DateInputKt.d(mutableStateD, textFieldValue);
                            String string = StringsKt.t1(textFieldValue.i()).toString();
                            Long lValueOf = null;
                            if (string.length() == 0 || string.length() < dateInputFormat2.c().length()) {
                                mutableState.setValue("");
                                function13.invoke(null);
                                return;
                            }
                            CalendarDate calendarDateK = calendarModel.k(string, dateInputFormat2.c());
                            mutableState.setValue(dateInputValidator.c(calendarDateK, i3, locale));
                            Function1 function15 = function13;
                            if (((CharSequence) mutableState.getValue()).length() == 0 && calendarDateK != null) {
                                lValueOf = Long.valueOf(calendarDateK.d());
                            }
                            function15.invoke(lValueOf);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((TextFieldValue) obj);
                        return Unit.f139807a;
                    }
                };
                dateInputFormat2 = dateInputFormat2;
                composerK.w(function14);
                objG2 = function14;
            } else {
                mutableState = mutableState2;
                i8 = i6;
            }
            Function1 function15 = (Function1) objG2;
            Modifier modifierM = PaddingKt.m(modifier, 0.0f, 0.0f, 0.0f, !StringsKt.p0((CharSequence) mutableState.getValue()) ? Dp.g(0) : f16794b, 7, null);
            boolean Z2 = composerK.Z(mutableState);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        if (StringsKt.p0((CharSequence) mutableState.getValue())) {
                            return;
                        }
                        SemanticsPropertiesKt.o(semanticsPropertyReceiver, (String) mutableState.getValue());
                    }
                };
                composerK.w(objG3);
            }
            OutlinedTextFieldKt.a(textFieldValueC, function15, SemanticsModifierKt.f(modifierM, false, (Function1) objG3, 1, null), false, false, null, function2, function22, null, null, null, null, ComposableLambdaKt.e(-591991974, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i10) {
                    if ((i10 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-591991974, i10, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:191)");
                    }
                    if (!StringsKt.p0((CharSequence) mutableState.getValue())) {
                        TextKt.c((String) mutableState.getValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), !StringsKt.p0((CharSequence) mutableState.getValue()), new DateVisualTransformation(dateInputFormat2), new KeyboardOptions(0, Boolean.FALSE, KeyboardType.f29379b.d(), ImeAction.f29348b.b(), null, null, null, 113, null), null, true, 0, 0, null, null, datePickerColors.f(), composerK, (i8 << 6) & 33030144, 12779904, 0, 4001592);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i10) {
                    DateInputKt.b(modifier, l3, function1, calendarModel, function2, function22, i3, dateInputValidator, dateInputFormat2, locale, datePickerColors, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    private static final TextFieldValue c(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    public static final PaddingValues f() {
        return f16793a;
    }
}
