package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class ModalBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f13153a = Dp.g(56);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f13154b = Dp.g(125);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f13155c = Dp.g(640);

    private static final NestedScrollConnection a(AnchoredDraggableState anchoredDraggableState, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010d  */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
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
    public static final void b(final kotlin.jvm.functions.Function3 r33, androidx.compose.ui.Modifier r34, androidx.compose.material.ModalBottomSheetState r35, boolean r36, androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, final kotlin.jvm.functions.Function2 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 1250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.b(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final long j3, final Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Modifier modifierE;
        Composer composerK = composer.k(-526532668);
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
                ComposerKt.U(-526532668, i4, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:496)");
            }
            if (j3 != 16) {
                composerK.a0(477285297);
                int i5 = i4;
                final State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerK, 48, 28);
                final String strA = Strings_androidKt.a(Strings.f14174b.b(), composerK, 6);
                if (z2) {
                    composerK.a0(477511845);
                    Modifier.Companion companion = Modifier.b8;
                    int i6 = i5 & 112;
                    boolean z3 = i6 == 32;
                    Object objG = composerK.G();
                    if (z3 || objG == Composer.f23746a.a()) {
                        objG = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        composerK.w(objG);
                    }
                    Modifier modifierThen = companion.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG), 6, null));
                    boolean Z = composerK.Z(strA) | (i6 == 32);
                    Object objG2 = composerK.G();
                    if (Z || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
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
                    composerK.a0(477792674);
                    composerK.U();
                    modifierE = Modifier.b8;
                }
                Modifier modifierThen2 = SizeKt.f(Modifier.b8, 0.0f, 1, null).then(modifierE);
                boolean Z2 = composerK.Z(stateD) | ((i5 & 14) == 4);
                Object objG3 = composerK.G();
                if (Z2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
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
                            DrawScope.L1(drawScope, j3, 0L, 0L, ModalBottomSheetKt.d(stateD), null, null, 0, 118, null);
                        }
                    };
                    composerK.w(objG3);
                }
                CanvasKt.b(modifierThen2, (Function1) objG3, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(478008930);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
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

    private static final Modifier i(Modifier modifier, final ModalBottomSheetState modalBottomSheetState) {
        return AnchoredDraggableKt.h(modifier, modalBottomSheetState.d(), Orientation.f6031a, new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue>>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13211a;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f13211a = iArr;
                }
            }

            {
                super(2);
            }

            public final Pair c(final long j3, long j4) {
                final float fK = Constraints.k(j4);
                final ModalBottomSheetState modalBottomSheetState2 = modalBottomSheetState;
                DraggableAnchors draggableAnchorsA = AnchoredDraggableKt.a(new Function1<DraggableAnchorsConfig<ModalBottomSheetValue>, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(DraggableAnchorsConfig draggableAnchorsConfig) {
                        draggableAnchorsConfig.a(ModalBottomSheetValue.Hidden, fK);
                        float f3 = fK / 2.0f;
                        if (!modalBottomSheetState2.j() && IntSize.f(j3) > f3) {
                            draggableAnchorsConfig.a(ModalBottomSheetValue.HalfExpanded, f3);
                        }
                        if (IntSize.f(j3) != 0) {
                            draggableAnchorsConfig.a(ModalBottomSheetValue.Expanded, Math.max(0.0f, fK - IntSize.f(j3)));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((DraggableAnchorsConfig) obj);
                        return Unit.f139807a;
                    }
                });
                boolean z2 = modalBottomSheetState.d().o().getSize() > 0;
                ModalBottomSheetValue modalBottomSheetValueE = modalBottomSheetState.e();
                if (z2 || !draggableAnchorsA.d(modalBottomSheetValueE)) {
                    int i3 = WhenMappings.f13211a[modalBottomSheetState.g().ordinal()];
                    if (i3 == 1) {
                        modalBottomSheetValueE = ModalBottomSheetValue.Hidden;
                    } else {
                        if (i3 != 2 && i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                        if (!draggableAnchorsA.d(modalBottomSheetValue)) {
                            modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                            if (!draggableAnchorsA.d(modalBottomSheetValue)) {
                                modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                            }
                        }
                        modalBottomSheetValueE = modalBottomSheetValue;
                    }
                }
                return TuplesKt.a(draggableAnchorsA, modalBottomSheetValueE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((IntSize) obj).j(), ((Constraints) obj2).r());
            }
        });
    }

    public static final ModalBottomSheetState j(final ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, boolean z2, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = ModalBottomSheetDefaults.f13149a.a();
        }
        final AnimationSpec animationSpec2 = animationSpec;
        final Function1 function12 = (i4 & 4) != 0 ? new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue2) {
                return Boolean.TRUE;
            }
        } : function1;
        final boolean z3 = (i4 & 8) != 0 ? false : z2;
        if (ComposerKt.M()) {
            ComposerKt.U(-126412120, i3, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:291)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        composer.K(976450751, modalBottomSheetValue);
        Object[] objArr = {modalBottomSheetValue, animationSpec2, Boolean.valueOf(z3), function12, density};
        Saver saverA = ModalBottomSheetState.f13221d.a(animationSpec2, function12, z3, density);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(modalBottomSheetValue)) || (i3 & 6) == 4) | composer.Z(density) | ((((i3 & 896) ^ 384) > 256 && composer.Z(function12)) || (i3 & 384) == 256) | composer.I(animationSpec2) | ((((i3 & 7168) ^ 3072) > 2048 && composer.b(z3)) || (i3 & 3072) == 2048);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            Object obj = new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ModalBottomSheetState invoke() {
                    return new ModalBottomSheetState(modalBottomSheetValue, density, function12, animationSpec2, z3);
                }
            };
            composer.w(obj);
            objG = obj;
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        composer.X();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modalBottomSheetState;
    }
}
