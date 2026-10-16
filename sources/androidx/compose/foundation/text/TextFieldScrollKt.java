package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public final class TextFieldScrollKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9995a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.f6031a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.f6032b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f9995a = iArr;
        }
    }

    public static final Modifier b(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0 function0) {
        Modifier verticalScrollLayoutModifier;
        Orientation orientationF = textFieldScrollerPosition.f();
        int iE = textFieldScrollerPosition.e(textFieldValue.h());
        textFieldScrollerPosition.i(textFieldValue.h());
        TransformedText transformedTextC = ValidatingOffsetMappingKt.c(visualTransformation, textFieldValue.f());
        int i3 = WhenMappings.f9995a[orientationF.ordinal()];
        if (i3 == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition, iE, transformedTextC, function0);
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, iE, transformedTextC, function0);
        }
        return ClipKt.b(modifier).then(verticalScrollLayoutModifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect c(Density density, int i3, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z2, int i4) {
        Rect rectA;
        if (textLayoutResult == null || (rectA = textLayoutResult.e(transformedText.a().b(i3))) == null) {
            rectA = Rect.f25601e.a();
        }
        Rect rect = rectA;
        int iZ0 = density.z0(TextFieldCursor_androidKt.a());
        return Rect.h(rect, z2 ? (i4 - rect.o()) - iZ0 : rect.o(), 0.0f, z2 ? i4 - rect.o() : iZ0 + rect.o(), 0.0f, 10, null);
    }

    public static final Modifier d(Modifier modifier, final TextFieldScrollerPosition textFieldScrollerPosition, final MutableInteractionSource mutableInteractionSource, final boolean z2) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("textFieldScrollable");
                inspectorInfo.b().c("scrollerPosition", textFieldScrollerPosition);
                inspectorInfo.b().c("interactionSource", mutableInteractionSource);
                inspectorInfo.b().c("enabled", Boolean.valueOf(z2));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(805428266);
                if (ComposerKt.M()) {
                    ComposerKt.U(805428266, i3, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:71)");
                }
                boolean z3 = textFieldScrollerPosition.f() == Orientation.f6031a || !(composer.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b);
                boolean Z = composer.Z(textFieldScrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1<Float, Float>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
                        {
                            super(1);
                        }

                        public final Float c(float f3) {
                            float fD = textFieldScrollerPosition2.d() + f3;
                            if (fD > textFieldScrollerPosition2.c()) {
                                f3 = textFieldScrollerPosition2.c() - textFieldScrollerPosition2.d();
                            } else if (fD < 0.0f) {
                                f3 = -textFieldScrollerPosition2.d();
                            }
                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                            textFieldScrollerPosition3.h(textFieldScrollerPosition3.d() + f3);
                            return Float.valueOf(f3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return c(((Number) obj).floatValue());
                        }
                    };
                    composer.w(objG);
                }
                final ScrollableState scrollableStateB = ScrollableStateKt.b((Function1) objG, composer, 0);
                boolean Z2 = composer.Z(scrollableStateB) | composer.Z(textFieldScrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition;
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new ScrollableState(textFieldScrollerPosition3) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        private final State f10004b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        private final State f10005c;

                        {
                            this.f10004b = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition3.d() < textFieldScrollerPosition3.c());
                                }
                            });
                            this.f10005c = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition3.d() > 0.0f);
                                }
                            });
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public float b(float f3) {
                            return this.f10003a.b(f3);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean c() {
                            return this.f10003a.c();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean d() {
                            return ((Boolean) this.f10005c.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public Object e(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
                            return this.f10003a.e(mutatePriority, function2, continuation);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean f() {
                            return ((Boolean) this.f10004b.getValue()).booleanValue();
                        }
                    };
                    composer.w(objG2);
                }
                Modifier modifierK = ScrollableKt.k(Modifier.b8, (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objG2, textFieldScrollerPosition.f(), z2 && textFieldScrollerPosition.c() != 0.0f, z3, null, mutableInteractionSource, 16, null);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierK;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }
}
