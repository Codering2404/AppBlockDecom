package androidx.compose.material3.internal;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldImplKt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f22105b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f22110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f22111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Modifier f22112i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f22104a = ConstraintsKt.a(0, 0, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22106c = Dp.g(12);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22107d = Dp.g(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f22108e = Dp.g(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22109f = Dp.g(24);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f22184b;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f22183a = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f22184b = iArr2;
        }
    }

    static {
        float f3 = 16;
        f22105b = Dp.g(f3);
        f22110g = Dp.g(f3);
        f22111h = Dp.g(f3);
        float f4 = 48;
        f22112i = SizeKt.a(Modifier.b8, Dp.g(f4), Dp.g(f4));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06df  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0952  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0976  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0979  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0994  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0a82  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:504:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.material3.internal.TextFieldType r47, final java.lang.String r48, final kotlin.jvm.functions.Function2 r49, final androidx.compose.ui.text.input.VisualTransformation r50, final kotlin.jvm.functions.Function2 r51, kotlin.jvm.functions.Function2 r52, kotlin.jvm.functions.Function2 r53, kotlin.jvm.functions.Function2 r54, kotlin.jvm.functions.Function2 r55, kotlin.jvm.functions.Function2 r56, kotlin.jvm.functions.Function2 r57, boolean r58, boolean r59, boolean r60, final androidx.compose.foundation.interaction.InteractionSource r61, final androidx.compose.foundation.layout.PaddingValues r62, final androidx.compose.material3.TextFieldColors r63, final kotlin.jvm.functions.Function2 r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 2750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.a(androidx.compose.material3.internal.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean b(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean c(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, TextStyle textStyle, Function2 function2, Composer composer, final int i3) {
        int i4;
        final long j4;
        final TextStyle textStyle2;
        final Function2 function22;
        Composer composerK = composer.k(1208685580);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(textStyle) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            function22 = function2;
            textStyle2 = textStyle;
            j4 = j3;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1208685580, i4, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
            }
            ProvideContentColorTextStyleKt.a(j3, textStyle, function2, composerK, i4 & 1022);
            j4 = j3;
            textStyle2 = textStyle;
            function22 = function2;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextFieldImplKt.d(j4, textStyle2, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final long j3, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(660142980);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(660142980, i4, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
            }
            CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j3)), function2, composerK, (i4 & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextFieldImplKt.e(j3, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final State h(boolean z2, boolean z3, boolean z4, TextFieldColors textFieldColors, float f3, float f4, Composer composer, int i3) {
        State stateP;
        State stateP2;
        Composer composer2 = composer;
        if (ComposerKt.M()) {
            ComposerKt.U(2047013045, i3, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        long jE = textFieldColors.e(z2, z3, z4);
        if (z2) {
            composer2.a0(1023053998);
            stateP = SingleValueAnimationKt.a(jE, AnimationSpecKt.n(150, 0, null, 6, null), null, null, composer, 48, 12);
            composer2 = composer;
            composer2.U();
        } else {
            composer2.a0(1023165505);
            stateP = SnapshotStateKt.p(Color.n(jE), composer2, 0);
            composer2.U();
        }
        State state = stateP;
        if (z2) {
            composer2.a0(1023269417);
            stateP2 = AnimateAsStateKt.c(z4 ? f3 : f4, AnimationSpecKt.n(150, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.U();
        } else {
            composer2.a0(1023478388);
            stateP2 = SnapshotStateKt.p(Dp.d(f4), composer2, (i3 >> 15) & 14);
            composer2.U();
        }
        State stateP3 = SnapshotStateKt.p(BorderStrokeKt.a(((Dp) stateP2.getValue()).l(), ((Color) state.getValue()).B()), composer2, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP3;
    }

    public static final Modifier i(Modifier modifier, boolean z2, final String str) {
        return z2 ? SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$defaultErrorSemantics$1
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
                SemanticsPropertiesKt.o(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final float j() {
        return f22106c;
    }

    public static final Modifier k() {
        return f22112i;
    }

    public static final Object l(IntrinsicMeasurable intrinsicMeasurable) {
        Object objP = intrinsicMeasurable.p();
        LayoutIdParentData layoutIdParentData = objP instanceof LayoutIdParentData ? (LayoutIdParentData) objP : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.Z0();
        }
        return null;
    }

    public static final float m() {
        return f22110g;
    }

    public static final float n() {
        return f22111h;
    }

    public static final float o() {
        return f22109f;
    }

    public static final float p() {
        return f22108e;
    }

    public static final float q() {
        return f22107d;
    }

    public static final float r() {
        return f22105b;
    }

    public static final long s() {
        return f22104a;
    }

    public static final int t(Placeable placeable) {
        if (placeable != null) {
            return placeable.O0();
        }
        return 0;
    }

    public static final Modifier u(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.c(modifier, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$textFieldBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                final Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(cacheDrawScope.b(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                final ColorProducer colorProducer2 = colorProducer;
                return cacheDrawScope.u(new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$textFieldBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        OutlineKt.e(drawScope, outlineMo29createOutlinePq9zytI, colorProducer2.a(), 0.0f, null, null, 0, 60, null);
                    }
                });
            }
        });
    }

    public static final int v(Placeable placeable) {
        if (placeable != null) {
            return placeable.X0();
        }
        return 0;
    }
}
