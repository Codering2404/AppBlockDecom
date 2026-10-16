package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
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
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public final class SliderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f19973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f19975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f19976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f19978f;

    static {
        SliderTokens sliderTokens = SliderTokens.f23396a;
        f19973a = sliderTokens.n();
        float fL = sliderTokens.l();
        f19974b = fL;
        float fJ = sliderTokens.j();
        f19975c = fJ;
        f19976d = DpKt.b(fL, fJ);
        f19977e = sliderTokens.a();
        f19978f = Dp.g(2);
    }

    private static final Modifier A(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z2) {
        final ClosedFloatingPointRange closedFloatingPointRangeB = RangesKt.b(((Number) rangeSliderState.v().a()).floatValue(), rangeSliderState.a());
        return ProgressSemanticsKt.b(SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1
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
                if (!z2) {
                    SemanticsPropertiesKt.l(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange closedFloatingPointRange = closedFloatingPointRangeB;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.p0(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean c(float f3) {
                        int iP;
                        float fO = RangesKt.o(f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
                        boolean z3 = false;
                        if (rangeSliderState2.p() > 0 && (iP = rangeSliderState2.p() + 1) >= 0) {
                            float fAbs = fO;
                            float f4 = fAbs;
                            int i3 = 0;
                            while (true) {
                                float fB = MathHelpersKt.b(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), i3 / (rangeSliderState2.p() + 1));
                                float f5 = fB - fO;
                                if (Math.abs(f5) <= fAbs) {
                                    fAbs = Math.abs(f5);
                                    f4 = fB;
                                }
                                if (i3 == iP) {
                                    break;
                                }
                                i3++;
                            }
                            fO = f4;
                        }
                        if (fO != rangeSliderState2.c()) {
                            long jI = SliderKt.i(fO, rangeSliderState2.a());
                            if (!SliderRange.e(jI, SliderKt.i(rangeSliderState2.c(), rangeSliderState2.a()))) {
                                if (rangeSliderState2.l() != null) {
                                    Function1 function1L = rangeSliderState2.l();
                                    if (function1L != null) {
                                        function1L.invoke(SliderRange.b(jI));
                                    }
                                } else {
                                    rangeSliderState2.C(SliderRange.g(jI));
                                    rangeSliderState2.A(SliderRange.f(jI));
                                }
                            }
                            Function0 function0M = rangeSliderState2.m();
                            if (function0M != null) {
                                function0M.invoke();
                            }
                            z3 = true;
                        }
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return c(((Number) obj).floatValue());
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.b()), rangeSliderState.c(), closedFloatingPointRangeB, rangeSliderState.p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float B(float f3, float f4, float f5, float f6, float f7) {
        return MathHelpersKt.b(f6, f7, v(f3, f4, f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long C(float f3, float f4, long j3, float f5, float f6) {
        return i(B(f3, f4, SliderRange.g(j3), f5, f6), B(f3, f4, SliderRange.f(j3), f5, f6));
    }

    private static final Modifier D(Modifier modifier, final SliderState sliderState, final boolean z2) {
        return ProgressSemanticsKt.b(SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1
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
                if (!z2) {
                    SemanticsPropertiesKt.l(semanticsPropertyReceiver);
                }
                final SliderState sliderState2 = sliderState;
                SemanticsPropertiesKt.p0(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1.1
                    {
                        super(1);
                    }

                    public final Boolean c(float f3) {
                        int iM;
                        float fO = RangesKt.o(f3, ((Number) sliderState2.s().a()).floatValue(), ((Number) sliderState2.s().e()).floatValue());
                        boolean z3 = false;
                        if (sliderState2.m() > 0 && (iM = sliderState2.m() + 1) >= 0) {
                            float fAbs = fO;
                            float f4 = fAbs;
                            int i3 = 0;
                            while (true) {
                                float fB = MathHelpersKt.b(((Number) sliderState2.s().a()).floatValue(), ((Number) sliderState2.s().e()).floatValue(), i3 / (sliderState2.m() + 1));
                                float f5 = fB - fO;
                                if (Math.abs(f5) <= fAbs) {
                                    fAbs = Math.abs(f5);
                                    f4 = fB;
                                }
                                if (i3 == iM) {
                                    break;
                                }
                                i3++;
                            }
                            fO = f4;
                        }
                        if (fO != sliderState2.r()) {
                            if (fO != sliderState2.r()) {
                                if (sliderState2.i() != null) {
                                    Function1 function1I = sliderState2.i();
                                    if (function1I != null) {
                                        function1I.invoke(Float.valueOf(fO));
                                    }
                                } else {
                                    sliderState2.I(fO);
                                }
                            }
                            Function0 function0J = sliderState2.j();
                            if (function0J != null) {
                                function0J.invoke();
                            }
                            z3 = true;
                        }
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return c(((Number) obj).floatValue());
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.b()), sliderState.r(), RangesKt.b(((Number) sliderState.s().a()).floatValue(), ((Number) sliderState.s().e()).floatValue()), sliderState.m());
    }

    private static final Modifier E(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z2) {
        return z2 ? modifier.then(new SuspendPointerInputElement(sliderState, mutableInteractionSource, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new SliderKt$sliderTapModifier$1(sliderState, null)), 4, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float F(float f3, float[] fArr, float f4, float f5) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f6 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                fValueOf = Float.valueOf(f6);
            } else {
                float fAbs = Math.abs(MathHelpersKt.b(f4, f5, f6) - f3);
                IntIterator it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f7 = fArr[it.nextInt()];
                    float fAbs2 = Math.abs(MathHelpersKt.b(f4, f5, f7) - f3);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f6 = f7;
                        fAbs = fAbs2;
                    }
                }
                fValueOf = Float.valueOf(f6);
            }
        }
        return fValueOf != null ? MathHelpersKt.b(f4, f5, fValueOf.floatValue()) : f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] G(int i3) {
        if (i3 == 0) {
            return new float[0];
        }
        int i4 = i3 + 2;
        float[] fArr = new float[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr[i5] = i5 / (i3 + 1);
        }
        return fArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.foundation.interaction.MutableInteractionSource r27, kotlin.jvm.functions.Function3 r28, kotlin.jvm.functions.Function3 r29, kotlin.jvm.functions.Function3 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.a(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.ranges.ClosedFloatingPointRange r28, final kotlin.jvm.functions.Function1 r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.ranges.ClosedFloatingPointRange r32, int r33, kotlin.jvm.functions.Function0 r34, androidx.compose.material3.SliderColors r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.b(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final kotlin.ranges.ClosedFloatingPointRange r31, final kotlin.jvm.functions.Function1 r32, androidx.compose.ui.Modifier r33, boolean r34, kotlin.ranges.ClosedFloatingPointRange r35, kotlin.jvm.functions.Function0 r36, androidx.compose.material3.SliderColors r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, kotlin.jvm.functions.Function3 r40, kotlin.jvm.functions.Function3 r41, kotlin.jvm.functions.Function3 r42, int r43, androidx.compose.runtime.Composer r44, final int r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.c(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z2, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3 function3, final Function3 function32, final Function3 function33, Composer composer, final int i3) {
        Modifier modifier2;
        int i4;
        Composer composerK = composer.k(-1411725677);
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(rangeSliderState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(mutableInteractionSource2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function32) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function33) ? 8388608 : 4194304;
        }
        if ((4793491 & i4) == 4793490 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1411725677, i4, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:735)");
            }
            rangeSliderState.L(composerK.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierZ = z(companion, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z2);
            Strings.Companion companion2 = Strings.f22102b;
            final String strA = Strings_androidKt.a(Strings.a(androidx.compose.ui.R.string.f25164k), composerK, 0);
            final String strA2 = Strings_androidKt.a(Strings.a(androidx.compose.ui.R.string.f25163j), composerK, 0);
            Modifier modifierThen = SizeKt.r(InteractiveComponentSizeKt.b(modifier2), f19974b, f19973a, 0.0f, 0.0f, 12, null).then(modifierZ);
            boolean zI = composerK.I(rangeSliderState);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        long j4 = j3;
                        int size = list.size();
                        int i5 = 0;
                        int i6 = 0;
                        while (i6 < size) {
                            Measurable measurable = (Measurable) list.get(i6);
                            if (LayoutIdKt.a(measurable) == RangeSliderComponents.STARTTHUMB) {
                                final Placeable placeableN0 = measurable.n0(j4);
                                int size2 = list.size();
                                int i7 = 0;
                                while (i7 < size2) {
                                    Measurable measurable2 = (Measurable) list.get(i7);
                                    if (LayoutIdKt.a(measurable2) == RangeSliderComponents.ENDTHUMB) {
                                        final Placeable placeableN02 = measurable2.n0(j4);
                                        int size3 = list.size();
                                        while (i5 < size3) {
                                            Measurable measurable3 = (Measurable) list.get(i5);
                                            if (LayoutIdKt.a(measurable3) == RangeSliderComponents.TRACK) {
                                                final Placeable placeableN03 = measurable3.n0(Constraints.d(ConstraintsKt.j(j4, (-(placeableN0.X0() + placeableN02.X0())) / 2, 0, 2, null), 0, 0, 0, 0, 11, null));
                                                int iX0 = placeableN03.X0() + ((placeableN0.X0() + placeableN02.X0()) / 2);
                                                int iMax = Math.max(placeableN03.O0(), Math.max(placeableN0.O0(), placeableN02.O0()));
                                                rangeSliderState.O(placeableN03.O0());
                                                rangeSliderState.N(iX0);
                                                rangeSliderState.P();
                                                final int iX02 = placeableN0.X0() / 2;
                                                final int iD = MathKt.d(placeableN03.X0() * rangeSliderState.f());
                                                final int iD2 = MathKt.d((placeableN03.X0() * rangeSliderState.e()) + ((placeableN0.X0() - placeableN02.X0()) / 2));
                                                final int iO0 = (iMax - placeableN03.O0()) / 2;
                                                final int iO02 = (iMax - placeableN0.O0()) / 2;
                                                final int iO03 = (iMax - placeableN02.O0()) / 2;
                                                return MeasureScope.B0(measureScope, iX0, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return Unit.f139807a;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        Placeable.PlacementScope.m(placementScope, placeableN03, iX02, iO0, 0.0f, 4, null);
                                                        Placeable.PlacementScope.m(placementScope, placeableN0, iD, iO02, 0.0f, 4, null);
                                                        Placeable.PlacementScope.m(placementScope, placeableN02, iD2, iO03, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                            i5++;
                                            j4 = j3;
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    i7++;
                                    j4 = j3;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i6++;
                            j4 = j3;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
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
            int i5 = i4;
            Updater.e(composerA, measurePolicy, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierI = SizeKt.I(LayoutIdKt.b(companion, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            boolean zI2 = composerK.I(rangeSliderState);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m180invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m180invokeozmzZPI(long j3) {
                        rangeSliderState.M(IntSize.g(j3));
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierA = A(OnRemeasuredModifierKt.a(modifierI, (Function1) objG2), rangeSliderState, z2);
            boolean Z = composerK.Z(strA);
            Object objG3 = composerK.G();
            if (Z || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$2$1
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
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierA2 = FocusableKt.a(SemanticsModifierKt.e(modifierA, true, (Function1) objG3), z2, mutableInteractionSource);
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA2);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i6 = (i5 >> 3) & 14;
            function3.invoke(rangeSliderState, composerK, Integer.valueOf(((i5 >> 12) & 112) | i6));
            composerK.y();
            Modifier modifierI2 = SizeKt.I(LayoutIdKt.b(companion, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            boolean zI3 = composerK.I(rangeSliderState);
            Object objG4 = composerK.G();
            if (zI3 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$4$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m181invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m181invokeozmzZPI(long j3) {
                        rangeSliderState.E(IntSize.g(j3));
                    }
                };
                composerK.w(objG4);
            }
            Modifier modifierY = y(OnRemeasuredModifierKt.a(modifierI2, (Function1) objG4), rangeSliderState, z2);
            boolean Z2 = composerK.Z(strA2);
            Object objG5 = composerK.G();
            if (Z2 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$5$1
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
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA2);
                    }
                };
                composerK.w(objG5);
            }
            Modifier modifierA3 = FocusableKt.a(SemanticsModifierKt.e(modifierY, true, (Function1) objG5), z2, mutableInteractionSource2);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion4.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierA3);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            function32.invoke(rangeSliderState, composerK, Integer.valueOf(((i5 >> 15) & 112) | i6));
            composerK.y();
            Modifier modifierB = LayoutIdKt.b(companion, RangeSliderComponents.TRACK);
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion4.o(), false);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A4 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyG3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            function33.invoke(rangeSliderState, composerK, Integer.valueOf(((i5 >> 18) & 112) | i6));
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SliderKt.d(modifier, rangeSliderState, z2, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final float r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function0 r31, androidx.compose.material3.SliderColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, int r34, kotlin.jvm.functions.Function3 r35, kotlin.jvm.functions.Function3 r36, kotlin.ranges.ClosedFloatingPointRange r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.e(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, int, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.ranges.ClosedFloatingPointRange, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final float r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.ranges.ClosedFloatingPointRange r31, int r32, kotlin.jvm.functions.Function0 r33, androidx.compose.material3.SliderColors r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.f(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final androidx.compose.material3.SliderState r17, androidx.compose.ui.Modifier r18, boolean r19, androidx.compose.material3.SliderColors r20, androidx.compose.foundation.interaction.MutableInteractionSource r21, kotlin.jvm.functions.Function3 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.g(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final Modifier modifier, final SliderState sliderState, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function3 function3, final Function3 function32, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1390990089);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(sliderState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function32) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1390990089, i4, -1, "androidx.compose.material3.SliderImpl (Slider.kt:664)");
            }
            sliderState.E(composerK.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierE = E(companion, sliderState, mutableInteractionSource, z2);
            int i5 = i4;
            Orientation orientation = Orientation.f6032b;
            boolean zV = sliderState.v();
            boolean zU = sliderState.u();
            boolean zI = composerK.I(sliderState);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                composerK.w(objG);
            }
            Modifier modifierThen = FocusableKt.a(D(SizeKt.r(InteractiveComponentSizeKt.b(modifier), f19974b, f19973a, 0.0f, 0.0f, 12, null), sliderState, z2), z2, mutableInteractionSource).then(modifierE).then(DraggableKt.h(companion, sliderState, orientation, z2, mutableInteractionSource, zU, null, (Function3) objG, zV, 32, null));
            boolean zI2 = composerK.I(sliderState);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        int size = list.size();
                        int i6 = 0;
                        for (int i7 = 0; i7 < size; i7++) {
                            Measurable measurable = (Measurable) list.get(i7);
                            if (LayoutIdKt.a(measurable) == SliderComponents.THUMB) {
                                long j4 = j3;
                                final Placeable placeableN0 = measurable.n0(j4);
                                int size2 = list.size();
                                while (i6 < size2) {
                                    Measurable measurable2 = (Measurable) list.get(i6);
                                    if (LayoutIdKt.a(measurable2) == SliderComponents.TRACK) {
                                        final Placeable placeableN02 = measurable2.n0(Constraints.d(ConstraintsKt.j(j4, -placeableN0.X0(), 0, 2, null), 0, 0, 0, 0, 11, null));
                                        int iX0 = placeableN0.X0() + placeableN02.X0();
                                        int iMax = Math.max(placeableN02.O0(), placeableN0.O0());
                                        sliderState.K(placeableN02.O0(), iX0);
                                        final int iX02 = placeableN0.X0() / 2;
                                        final int iD = MathKt.d(placeableN02.X0() * sliderState.g());
                                        final int iO0 = (iMax - placeableN02.O0()) / 2;
                                        final int iO02 = (iMax - placeableN0.O0()) / 2;
                                        return MeasureScope.B0(measureScope, iX0, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.m(placementScope, placeableN02, iX02, iO0, 0.0f, 4, null);
                                                Placeable.PlacementScope.m(placementScope, placeableN0, iD, iO02, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                    i6++;
                                    j4 = j3;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG2;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            Modifier modifierI = SizeKt.I(LayoutIdKt.b(companion, SliderComponents.THUMB), null, false, 3, null);
            boolean zI3 = composerK.I(sliderState);
            Object objG3 = composerK.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m182invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m182invokeozmzZPI(long j3) {
                        sliderState.F(IntSize.g(j3));
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierA = OnRemeasuredModifierKt.a(modifierI, (Function1) objG3);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA);
            Function0 function0A2 = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i6 = (i5 >> 3) & 14;
            function3.invoke(sliderState, composerK, Integer.valueOf(((i5 >> 9) & 112) | i6));
            composerK.y();
            Modifier modifierB = LayoutIdKt.b(companion, SliderComponents.TRACK);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A3 = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion2.e());
            Updater.e(composerA3, compositionLocalMapU3, companion2.g());
            Function2 function2B3 = companion2.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion2.f());
            function32.invoke(sliderState, composerK, Integer.valueOf(((i5 >> 12) & 112) | i6));
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SliderKt.h(modifier, sliderState, z2, mutableInteractionSource, function3, function32, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final long i(float f3, float f4) {
        if ((Float.isNaN(f3) && Float.isNaN(f4)) || f3 <= ((double) f4) + 1.0E-4d) {
            return SliderRange.c((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
        }
        throw new IllegalArgumentException(("start(" + f3 + ") must be <= endInclusive(" + f4 + ')').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object u(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.f20132c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f20132c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f20131b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f20132c
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.f20130a
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.b(r12)
            goto L55
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>()
            r6.f20130a = r12
            r6.f20132c = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.internal.DragGestureDetectorCopyKt.a(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L52
            return r0
        L52:
            r7 = r12
            r12 = r8
            r8 = r7
        L55:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L64
            float r8 = r8.f140141a
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.c(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.a(r12, r8)
            return r8
        L64:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.u(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float v(float f3, float f4, float f5) {
        float f6 = f4 - f3;
        return RangesKt.o(f6 == 0.0f ? 0.0f : (f5 - f3) / f6, 0.0f, 1.0f);
    }

    public static final float w() {
        return f19973a;
    }

    public static final boolean x(long j3) {
        return j3 != SliderRange.f20181b.a();
    }

    private static final Modifier y(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z2) {
        final ClosedFloatingPointRange closedFloatingPointRangeB = RangesKt.b(rangeSliderState.c(), ((Number) rangeSliderState.v().e()).floatValue());
        return ProgressSemanticsKt.b(SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1
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
                if (!z2) {
                    SemanticsPropertiesKt.l(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange closedFloatingPointRange = closedFloatingPointRangeB;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.p0(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean c(float f3) {
                        int iG;
                        float fO = RangesKt.o(f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
                        boolean z3 = false;
                        if (rangeSliderState2.g() > 0 && (iG = rangeSliderState2.g() + 1) >= 0) {
                            float fAbs = fO;
                            float f4 = fAbs;
                            int i3 = 0;
                            while (true) {
                                float fB = MathHelpersKt.b(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), i3 / (rangeSliderState2.g() + 1));
                                float f5 = fB - fO;
                                if (Math.abs(f5) <= fAbs) {
                                    fAbs = Math.abs(f5);
                                    f4 = fB;
                                }
                                if (i3 == iG) {
                                    break;
                                }
                                i3++;
                            }
                            fO = f4;
                        }
                        if (fO != rangeSliderState2.a()) {
                            long jI = SliderKt.i(rangeSliderState2.c(), fO);
                            if (!SliderRange.e(jI, SliderKt.i(rangeSliderState2.c(), rangeSliderState2.a()))) {
                                if (rangeSliderState2.l() != null) {
                                    Function1 function1L = rangeSliderState2.l();
                                    if (function1L != null) {
                                        function1L.invoke(SliderRange.b(jI));
                                    }
                                } else {
                                    rangeSliderState2.C(SliderRange.g(jI));
                                    rangeSliderState2.A(SliderRange.f(jI));
                                }
                            }
                            Function0 function0M = rangeSliderState2.m();
                            if (function0M != null) {
                                function0M.invoke();
                            }
                            z3 = true;
                        }
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return c(((Number) obj).floatValue());
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.b()), rangeSliderState.a(), closedFloatingPointRangeB, rangeSliderState.g());
    }

    private static final Modifier z(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z2) {
        return z2 ? modifier.then(new SuspendPointerInputElement(null, null, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new SliderKt$rangeSliderPressDragModifier$1(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, null)), 3, null)) : modifier;
    }
}
