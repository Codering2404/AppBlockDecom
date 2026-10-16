package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
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
public final class DateRangePickerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DateRangePickerDefaults f17264a = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Long l3, final Long l4, final int i3, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final String str, final String str2, final Function2 function2, final Function2 function22, final Function2 function23, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composer2;
        Long l5;
        String str3;
        Composer composerK = composer.k(-820363420);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(l3) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(l4) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= (i4 & 4096) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerK.Z(str) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i6 |= composerK.Z(str2) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i6 |= composerK.I(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            i6 |= composerK.I(function22) ? 67108864 : 33554432;
        }
        if ((805306368 & i4) == 0) {
            i6 |= composerK.I(function23) ? 536870912 : 268435456;
        }
        if ((306783379 & i6) == 306783378 && (i5 & 1) == 0 && composerK.l()) {
            composerK.Q();
            l5 = l3;
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-820363420, i6, i5, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:419)");
            }
            Locale localeA = CalendarLocale_androidKt.a(composerK, 0);
            int i7 = i6;
            composer2 = composerK;
            String strA = DatePickerFormatter.a(datePickerFormatter, l3, localeA, false, 4, null);
            l5 = l3;
            String strA2 = DatePickerFormatter.a(datePickerFormatter, l4, localeA, false, 4, null);
            String strC = datePickerFormatter.c(l5, localeA, true);
            composer2.a0(1063158288);
            String strA3 = "";
            if (strC == null) {
                DisplayMode.Companion companion = DisplayMode.f17460b;
                str3 = strA2;
                if (DisplayMode.f(i3, companion.b())) {
                    composer2.a0(1063166242);
                    Strings.Companion companion2 = Strings.f22102b;
                    String strA4 = Strings_androidKt.a(Strings.a(R.string.f19314q), composer2, 0);
                    composer2.U();
                    strC = strA4;
                } else if (DisplayMode.f(i3, companion.a())) {
                    composer2.a0(1063169213);
                    Strings.Companion companion3 = Strings.f22102b;
                    strC = Strings_androidKt.a(Strings.a(R.string.f19309l), composer2, 0);
                    composer2.U();
                } else {
                    composer2.a0(-1401419729);
                    composer2.U();
                    strC = "";
                }
            } else {
                str3 = strA2;
            }
            composer2.U();
            String strC2 = datePickerFormatter.c(l4, localeA, true);
            composer2.a0(1063174382);
            if (strC2 == null) {
                DisplayMode.Companion companion4 = DisplayMode.f17460b;
                if (DisplayMode.f(i3, companion4.b())) {
                    composer2.a0(1063182274);
                    Strings.Companion companion5 = Strings.f22102b;
                    strA3 = Strings_androidKt.a(Strings.a(R.string.f19314q), composer2, 0);
                    composer2.U();
                } else if (DisplayMode.f(i3, companion4.a())) {
                    composer2.a0(1063185245);
                    Strings.Companion companion6 = Strings.f22102b;
                    strA3 = Strings_androidKt.a(Strings.a(R.string.f19309l), composer2, 0);
                    composer2.U();
                } else {
                    composer2.a0(-1400922737);
                    composer2.U();
                }
            } else {
                strA3 = strC2;
            }
            composer2.U();
            final String str4 = str + ": " + strC;
            final String str5 = str2 + ": " + strA3;
            boolean Z = composer2.Z(str4) | composer2.Z(str5);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1
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
                        SemanticsPropertiesKt.l0(semanticsPropertyReceiver, LiveRegionMode.f28448b.b());
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str4 + ", " + str5);
                    }
                };
                composer2.w(objG);
            }
            Modifier modifierC = SemanticsModifierKt.c(modifier, (Function1) objG);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(4)), Alignment.f25072a.i(), composer2, 54);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierC);
            ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
            Function0 function0A = companion7.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyB, companion7.e());
            Updater.e(composerA, compositionLocalMapU, companion7.g());
            Function2 function2B = companion7.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion7.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (strA != null) {
                composer2.a0(303536053);
                TextKt.c(strA, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                composer2.U();
            } else {
                composer2.a0(303604222);
                function2.invoke(composer2, Integer.valueOf((i7 >> 21) & 14));
                composer2.U();
            }
            function23.invoke(composer2, Integer.valueOf((i7 >> 27) & 14));
            if (str3 != null) {
                composer2.a0(303729431);
                TextKt.c(str3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                composer2.U();
            } else {
                composer2.a0(303795616);
                function22.invoke(composer2, Integer.valueOf((i7 >> 24) & 14));
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final Long l6 = l5;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    this.f17277a.a(l6, l4, i3, datePickerFormatter, modifier, str, str2, function2, function22, function23, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(final java.lang.Long r18, final java.lang.Long r19, final int r20, final androidx.compose.material3.DatePickerFormatter r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.b(java.lang.Long, java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(final int r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.c(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
