package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class ModalBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18232a = Dp.g(48);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18233b = Dp.g(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f18234c = TransformOriginKt.a(0.5f, 0.0f);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function0 r45, androidx.compose.ui.Modifier r46, androidx.compose.material3.SheetState r47, float r48, androidx.compose.ui.graphics.Shape r49, long r50, long r52, float r54, long r55, kotlin.jvm.functions.Function2 r57, kotlin.jvm.functions.Function2 r58, androidx.compose.material3.ModalBottomSheetProperties r59, final kotlin.jvm.functions.Function3 r60, androidx.compose.runtime.Composer r61, final int r62, final int r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 1114
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.a(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.foundation.layout.BoxScope r44, final androidx.compose.animation.core.Animatable r45, final kotlinx.coroutines.CoroutineScope r46, final kotlin.jvm.functions.Function0 r47, final kotlin.jvm.functions.Function1 r48, androidx.compose.ui.Modifier r49, androidx.compose.material3.SheetState r50, float r51, androidx.compose.ui.graphics.Shape r52, long r53, long r55, float r57, kotlin.jvm.functions.Function2 r58, kotlin.jvm.functions.Function2 r59, final kotlin.jvm.functions.Function3 r60, androidx.compose.runtime.Composer r61, final int r62, final int r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 1215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.b(androidx.compose.foundation.layout.BoxScope, androidx.compose.animation.core.Animatable, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final long j3, final Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Modifier modifierE;
        Composer composerK = composer.k(951870469);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(951870469, i4, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:407)");
            }
            if (j3 != 16) {
                int i5 = i4;
                final State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerK, 48, 28);
                Strings.Companion companion = Strings.f22102b;
                final String strA = Strings_androidKt.a(Strings.a(androidx.compose.ui.R.string.f25155b), composerK, 0);
                composerK.a0(-1785653838);
                if (z2) {
                    Modifier.Companion companion2 = Modifier.b8;
                    int i6 = i5 & 112;
                    boolean z3 = i6 == 32;
                    Object objG = composerK.G();
                    if (z3 || objG == Composer.f23746a.a()) {
                        objG = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function0, null);
                        composerK.w(objG);
                    }
                    Modifier modifierThen = companion2.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG), 6, null));
                    boolean Z = composerK.Z(strA) | (i6 == 32);
                    Object objG2 = composerK.G();
                    if (Z || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetKt$Scrim$dismissSheet$2$1
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
                                SemanticsPropertiesKt.H0(semanticsPropertyReceiver, 1.0f);
                                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA);
                                final Function0 function02 = function0;
                                SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheetKt$Scrim$dismissSheet$2$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        };
                        composerK.w(objG2);
                    }
                    modifierE = SemanticsModifierKt.e(modifierThen, true, (Function1) objG2);
                } else {
                    modifierE = Modifier.b8;
                }
                composerK.U();
                Modifier modifierThen2 = SizeKt.f(Modifier.b8, 0.0f, 1, null).then(modifierE);
                boolean Z2 = composerK.Z(stateD) | ((i5 & 14) == 4);
                Object objG3 = composerK.G();
                if (Z2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetKt$Scrim$1$1
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
                            DrawScope.L1(drawScope, j3, 0L, 0L, RangesKt.o(ModalBottomSheetKt.d(stateD), 0.0f, 1.0f), null, null, 0, 118, null);
                        }
                    };
                    composerK.w(objG3);
                }
                CanvasKt.b(modifierThen2, (Function1) objG3, composerK, 0);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetKt$Scrim$2
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
                    ModalBottomSheetKt.c(j3, function0, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(GraphicsLayerScope graphicsLayerScope, float f3) {
        float fI = Size.i(graphicsLayerScope.b());
        if (Float.isNaN(fI) || fI == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.b(0.0f, Math.min(graphicsLayerScope.M1(f18232a), fI), f3) / fI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(GraphicsLayerScope graphicsLayerScope, float f3) {
        float fG = Size.g(graphicsLayerScope.b());
        if (Float.isNaN(fG) || fG == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.b(0.0f, Math.min(graphicsLayerScope.M1(f18233b), fG), f3) / fG);
    }

    public static final SheetState l(boolean z2, Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if ((i4 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheetKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(SheetValue sheetValue) {
                    return Boolean.TRUE;
                }
            };
        }
        Function1 function12 = function1;
        if (ComposerKt.M()) {
            ComposerKt.U(-778250030, i3, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:400)");
        }
        SheetState sheetStateD = SheetDefaultsKt.d(z3, function12, SheetValue.Hidden, false, composer, (i3 & 14) | 384 | (i3 & 112), 8);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sheetStateD;
    }
}
