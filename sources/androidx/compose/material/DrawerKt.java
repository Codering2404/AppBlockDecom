package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DrawerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f12714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f12715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12716c = Dp.g(RCHTTPStatusCodes.BAD_REQUEST);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TweenSpec f12717d = new TweenSpec(Function.MAX_NARGS, 0, null, 6, null);

    static {
        float f3 = 56;
        f12714a = Dp.g(f3);
        f12715b = Dp.g(f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /* JADX WARN: Type inference failed for: r0v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
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
    public static final void a(final kotlin.jvm.functions.Function3 r33, androidx.compose.ui.Modifier r34, androidx.compose.material.BottomDrawerState r35, boolean r36, androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, final kotlin.jvm.functions.Function2 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.a(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final long j3, final Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Modifier modifierE;
        Composer composerK = composer.k(-513067266);
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
                ComposerKt.U(-513067266, i4, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:793)");
            }
            if (j3 != 16) {
                composerK.a0(1552753222);
                int i5 = i4;
                final State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerK, 48, 28);
                final String strA = Strings_androidKt.a(Strings.f14174b.a(), composerK, 6);
                if (z2) {
                    composerK.a0(1552981692);
                    Modifier.Companion companion = Modifier.b8;
                    int i6 = i5 & 112;
                    boolean z3 = i6 == 32;
                    Object objG = composerK.G();
                    if (z3 || objG == Composer.f23746a.a()) {
                        objG = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        composerK.w(objG);
                    }
                    Modifier modifierThen = companion.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG), 6, null));
                    boolean Z = composerK.Z(strA) | (i6 == 32);
                    Object objG2 = composerK.G();
                    if (Z || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
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
                                final Function0 function02 = function0;
                                SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
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
                    composerK.U();
                } else {
                    composerK.a0(1553298078);
                    composerK.U();
                    modifierE = Modifier.b8;
                }
                Modifier modifierThen2 = SizeKt.f(Modifier.b8, 0.0f, 1, null).then(modifierE);
                boolean Z2 = composerK.Z(stateD) | ((i5 & 14) == 4);
                Object objG3 = composerK.G();
                if (Z2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
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
                            DrawScope.L1(drawScope, j3, 0L, 0L, DrawerKt.c(stateD), null, null, 0, 118, null);
                        }
                    };
                    composerK.w(objG3);
                }
                CanvasKt.b(modifierThen2, (Function1) objG3, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(1553514334);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
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
                    DrawerKt.b(j3, function0, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection d(AnchoredDraggableState anchoredDraggableState) {
        return new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final kotlin.jvm.functions.Function3 r31, androidx.compose.ui.Modifier r32, androidx.compose.material.DrawerState r33, boolean r34, androidx.compose.ui.graphics.Shape r35, float r36, long r37, long r39, long r41, final kotlin.jvm.functions.Function2 r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.e(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final boolean z2, final Function0 function0, final Function0 function02, final long j3, Composer composer, final int i3) {
        int i4;
        Modifier modifierE;
        Composer composerK = composer.k(1983403750);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1983403750, i4, -1, "androidx.compose.material.Scrim (Drawer.kt:829)");
            }
            final String strA = Strings_androidKt.a(Strings.f14174b.a(), composerK, 6);
            if (z2) {
                composerK.a0(487729414);
                Modifier.Companion companion = Modifier.b8;
                int i5 = i4 & 112;
                boolean z3 = i5 == 32;
                Object objG = composerK.G();
                if (z3 || objG == Composer.f23746a.a()) {
                    objG = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    composerK.w(objG);
                }
                Modifier modifierThen = companion.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG), 6, null));
                boolean Z = (i5 == 32) | composerK.Z(strA);
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
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
                            final Function0 function03 = function0;
                            SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                        }
                    };
                    composerK.w(objG2);
                }
                modifierE = SemanticsModifierKt.e(modifierThen, true, (Function1) objG2);
                composerK.U();
            } else {
                composerK.a0(487978282);
                composerK.U();
                modifierE = Modifier.b8;
            }
            Modifier modifierThen2 = SizeKt.f(Modifier.b8, 0.0f, 1, null).then(modifierE);
            boolean z4 = ((i4 & 7168) == 2048) | ((i4 & 896) == 256);
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
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
                        DrawScope.L1(drawScope, j3, 0L, 0L, ((Number) function02.invoke()).floatValue(), null, null, 0, 118, null);
                    }
                };
                composerK.w(objG3);
            }
            CanvasKt.b(modifierThen2, (Function1) objG3, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    DrawerKt.f(z2, function0, function02, j3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(float f3, float f4, float f5) {
        float f6 = (f5 - f3) / (f4 - f3);
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            return 1.0f;
        }
        return f6;
    }

    public static final BottomDrawerState q(final BottomDrawerValue bottomDrawerValue, final Function1 function1, final AnimationSpec animationSpec, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(BottomDrawerValue bottomDrawerValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if ((i4 & 4) != 0) {
            animationSpec = DrawerDefaults.f12711a.a();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1477366969, i3, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:448)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        Object[] objArr = {density};
        Saver saverA = BottomDrawerState.f12101c.a(density, function1, animationSpec);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(bottomDrawerValue)) || (i3 & 6) == 4) | composer.Z(density) | ((((i3 & 112) ^ 48) > 32 && composer.Z(function1)) || (i3 & 48) == 32) | composer.I(animationSpec);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomDrawerState invoke() {
                    return new BottomDrawerState(bottomDrawerValue, density, function1, animationSpec);
                }
            };
            composer.w(objG);
        }
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return bottomDrawerState;
    }

    public static final DrawerState r(final DrawerValue drawerValue, final Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1435874229, i3, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:429)");
        }
        Object[] objArr = new Object[0];
        Saver saverA = DrawerState.f12851c.a(function1);
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.Z(drawerValue)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.Z(function1)) || (i3 & 48) == 32);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DrawerState invoke() {
                    return new DrawerState(drawerValue, function1);
                }
            };
            composer.w(objG);
        }
        DrawerState drawerState = (DrawerState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return drawerState;
    }
}
