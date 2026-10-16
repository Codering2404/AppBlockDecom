package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ClickableKt {
    public static final Modifier c(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final String str, final Role role, final Function0 function0) {
        Modifier modifierC;
        if (indication instanceof IndicationNodeFactory) {
            modifierC = new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z2, str, role, function0, null);
        } else if (indication == null) {
            modifierC = new ClickableElement(mutableInteractionSource, null, z2, str, role, function0, null);
        } else if (mutableInteractionSource != null) {
            modifierC = IndicationKt.b(Modifier.b8, mutableInteractionSource, indication).then(new ClickableElement(mutableInteractionSource, null, z2, str, role, function0, null));
        } else {
            modifierC = ComposedModifierKt.c(Modifier.b8, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                    composer.a0(-1525724089);
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1525724089, i3, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
                    }
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = InteractionSourceKt.a();
                        composer.w(objG);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objG;
                    Modifier modifierThen = IndicationKt.b(Modifier.b8, mutableInteractionSource2, indication).then(new ClickableElement(mutableInteractionSource2, null, z2, str, role, function0, null));
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer.U();
                    return modifierThen;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            }, 1, null);
        }
        return modifier.then(modifierC);
    }

    public static /* synthetic */ Modifier d(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, String str, Role role, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return c(modifier, mutableInteractionSource, indication, z2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : role, function0);
    }

    public static final Modifier e(Modifier modifier, final boolean z2, final String str, final Role role, final Function0 function0) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("clickable");
                inspectorInfo.b().c("enabled", Boolean.valueOf(z2));
                inspectorInfo.b().c("onClickLabel", str);
                inspectorInfo.b().c("role", role);
                inspectorInfo.b().c("onClick", function0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                MutableInteractionSource mutableInteractionSource;
                composer.a0(-756081143);
                if (ComposerKt.M()) {
                    ComposerKt.U(-756081143, i3, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:120)");
                }
                Indication indication = (Indication) composer.q(IndicationKt.a());
                if (indication instanceof IndicationNodeFactory) {
                    composer.a0(617653824);
                    composer.U();
                    mutableInteractionSource = null;
                } else {
                    composer.a0(617786442);
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = InteractionSourceKt.a();
                        composer.w(objG);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objG;
                    composer.U();
                }
                Modifier modifierC = ClickableKt.c(Modifier.b8, mutableInteractionSource, indication, z2, str, role, function0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierC;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static /* synthetic */ Modifier f(Modifier modifier, boolean z2, String str, Role role, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            role = null;
        }
        return e(modifier, z2, str, role, function0);
    }

    public static final Modifier g(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final boolean z3, final Function0 function03) {
        Modifier modifierC;
        if (indication instanceof IndicationNodeFactory) {
            modifierC = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z2, str, role, function03, str2, function0, function02, z3, null);
        } else if (indication == null) {
            modifierC = new CombinedClickableElement(mutableInteractionSource, null, z2, str, role, function03, str2, function0, function02, z3, null);
        } else if (mutableInteractionSource != null) {
            modifierC = IndicationKt.b(Modifier.b8, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, null, z2, str, role, function03, str2, function0, function02, z3, null));
        } else {
            modifierC = ComposedModifierKt.c(Modifier.b8, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-auXiCPI$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                    composer.a0(-1525724089);
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1525724089, i3, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
                    }
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = InteractionSourceKt.a();
                        composer.w(objG);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objG;
                    Modifier modifierThen = IndicationKt.b(Modifier.b8, mutableInteractionSource2, indication).then(new CombinedClickableElement(mutableInteractionSource2, null, z2, str, role, function03, str2, function0, function02, z3, null));
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer.U();
                    return modifierThen;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            }, 1, null);
        }
        return modifier.then(modifierC);
    }

    public static /* synthetic */ Modifier h(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z3, Function0 function03, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        if ((i3 & 16) != 0) {
            role = null;
        }
        if ((i3 & 32) != 0) {
            str2 = null;
        }
        if ((i3 & 64) != 0) {
            function0 = null;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            function02 = null;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z3 = true;
        }
        return g(modifier, mutableInteractionSource, indication, z2, str, role, str2, function0, function02, z3, function03);
    }

    public static final Modifier i(Modifier modifier, final boolean z2, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final boolean z3, final Function0 function03) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-f5TDLPQ$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("combinedClickable");
                inspectorInfo.b().c("enabled", Boolean.valueOf(z2));
                inspectorInfo.b().c("onClickLabel", str);
                inspectorInfo.b().c("role", role);
                inspectorInfo.b().c("onClick", function03);
                inspectorInfo.b().c("onDoubleClick", function02);
                inspectorInfo.b().c("onLongClick", function0);
                inspectorInfo.b().c("onLongClickLabel", str2);
                inspectorInfo.b().c("hapticFeedbackEnabled", Boolean.valueOf(z3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                MutableInteractionSource mutableInteractionSource;
                composer.a0(-1534186401);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1534186401, i3, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:264)");
                }
                Indication indication = (Indication) composer.q(IndicationKt.a());
                if (indication instanceof IndicationNodeFactory) {
                    composer.a0(-1726068379);
                    composer.U();
                    mutableInteractionSource = null;
                } else {
                    composer.a0(-1725935761);
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = InteractionSourceKt.a();
                        composer.w(objG);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objG;
                    composer.U();
                }
                Modifier modifierG = ClickableKt.g(Modifier.b8, mutableInteractionSource, indication, z2, str, role, str2, function0, function02, z3, function03);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierG;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static /* synthetic */ Modifier j(Modifier modifier, boolean z2, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z3, Function0 function03, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            role = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        if ((i3 & 16) != 0) {
            function0 = null;
        }
        if ((i3 & 32) != 0) {
            function02 = null;
        }
        if ((i3 & 64) != 0) {
            z3 = true;
        }
        return i(modifier, z2, str, role, str2, function0, function02, z3, function03);
    }

    public static final boolean k(TraversableNode traversableNode) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.c(traversableNode, ScrollableContainerNode.f6068c, new Function1<TraversableNode, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$hasScrollableContainer$1
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.TraversableNode r4) {
                /*
                    r3 = this;
                    kotlin.jvm.internal.Ref$BooleanRef r0 = r1
                    boolean r1 = r0.f140137a
                    r2 = 1
                    if (r1 != 0) goto L17
                    java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode"
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r1)
                    androidx.compose.foundation.gestures.ScrollableContainerNode r4 = (androidx.compose.foundation.gestures.ScrollableContainerNode) r4
                    boolean r4 = r4.m2()
                    if (r4 == 0) goto L15
                    goto L17
                L15:
                    r4 = 0
                    goto L18
                L17:
                    r4 = r2
                L18:
                    r0.f140137a = r4
                    kotlin.jvm.internal.Ref$BooleanRef r4 = r1
                    boolean r4 = r4.f140137a
                    r4 = r4 ^ r2
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$hasScrollableContainer$1.invoke(androidx.compose.ui.node.TraversableNode):java.lang.Boolean");
            }
        });
        return booleanRef.f140137a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(KeyEvent keyEvent) {
        return KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.b()) && m(keyEvent);
    }

    private static final boolean m(KeyEvent keyEvent) {
        long jA = KeyEvent_androidKt.a(keyEvent);
        Key.Companion companion = Key.f26638b;
        if (Key.p(jA, companion.b()) ? true : Key.p(jA, companion.g()) ? true : Key.p(jA, companion.i())) {
            return true;
        }
        return Key.p(jA, companion.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(KeyEvent keyEvent) {
        return KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) && m(keyEvent);
    }
}
