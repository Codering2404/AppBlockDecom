package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.Ref;
import androidx.constraintlayout.core.state.WidgetFrame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class MotionLayoutScope$onStartEndBoundsChanged$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f30886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MotionLayoutScope f30887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f30888c;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        composer.a0(-1096247907);
        if (ComposerKt.M()) {
            ComposerKt.U(-1096247907, i3, -1, "androidx.constraintlayout.compose.MotionLayoutScope.onStartEndBoundsChanged.<anonymous> (MotionLayout.kt:712)");
        }
        boolean Z = composer.Z(this.f30886a);
        Object obj = this.f30886a;
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = obj.toString();
            composer.w(objG);
        }
        final String str = (String) objG;
        Object objG2 = composer.G();
        Object obj2 = objG2;
        if (objG2 == Composer.f23746a.a()) {
            int[] iArr = new int[4];
            for (int i4 = 0; i4 < 4; i4++) {
                iArr[i4] = 0;
            }
            composer.w(iArr);
            obj2 = iArr;
        }
        final int[] iArr2 = (int[]) obj2;
        Object objG3 = composer.G();
        Composer.Companion companion = Composer.f23746a;
        Object obj3 = objG3;
        if (objG3 == companion.a()) {
            Ref ref = new Ref();
            ref.b(Rect.f25601e.a());
            composer.w(ref);
            obj3 = ref;
        }
        final Ref ref2 = (Ref) obj3;
        Object objG4 = composer.G();
        Object obj4 = objG4;
        if (objG4 == companion.a()) {
            int[] iArr3 = new int[4];
            for (int i5 = 0; i5 < 4; i5++) {
                iArr3[i5] = 0;
            }
            composer.w(iArr3);
            obj4 = iArr3;
        }
        final int[] iArr4 = (int[]) obj4;
        Object objG5 = composer.G();
        Composer.Companion companion2 = Composer.f23746a;
        Object obj5 = objG5;
        if (objG5 == companion2.a()) {
            Ref ref3 = new Ref();
            ref3.b(Rect.f25601e.a());
            composer.w(ref3);
            obj5 = ref3;
        }
        final Ref ref4 = (Ref) obj5;
        boolean zI = composer.I(this.f30887b) | composer.Z(str) | composer.I(iArr2) | composer.I(ref2) | composer.I(iArr4) | composer.I(ref4) | composer.Z(this.f30888c);
        final MotionLayoutScope motionLayoutScope = this.f30887b;
        final Function2 function2 = this.f30888c;
        Object objG6 = composer.G();
        if (zI || objG6 == companion2.a()) {
            Object obj6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj7) {
                    invoke((LayoutCoordinates) obj7);
                    return Unit.f139807a;
                }

                public final void invoke(LayoutCoordinates layoutCoordinates) {
                    boolean z2;
                    WidgetFrame widgetFrameB = motionLayoutScope.f30879a.G().B(str);
                    int i6 = widgetFrameB.f32151b;
                    int[] iArr5 = iArr2;
                    boolean z3 = true;
                    if (i6 == iArr5[0] && widgetFrameB.f32152c == iArr5[1] && widgetFrameB.f32153d == iArr5[2] && widgetFrameB.f32154e == iArr5[3]) {
                        z2 = false;
                    } else {
                        iArr5[0] = i6;
                        iArr5[1] = widgetFrameB.f32152c;
                        iArr5[2] = widgetFrameB.f32153d;
                        iArr5[3] = widgetFrameB.f32154e;
                        Ref ref5 = ref2;
                        int[] iArr6 = iArr2;
                        ref5.b(new Rect(iArr6[0], iArr6[1], iArr6[2], iArr6[3]));
                        z2 = true;
                    }
                    WidgetFrame widgetFrameS = motionLayoutScope.f30879a.G().s(str);
                    int i7 = widgetFrameS.f32151b;
                    int[] iArr7 = iArr4;
                    if (i7 == iArr7[0] && widgetFrameS.f32152c == iArr7[1] && widgetFrameS.f32153d == iArr7[2] && widgetFrameS.f32154e == iArr7[3]) {
                        z3 = z2;
                    } else {
                        iArr7[0] = i7;
                        iArr7[1] = widgetFrameS.f32152c;
                        iArr7[2] = widgetFrameS.f32153d;
                        iArr7[3] = widgetFrameS.f32154e;
                        Ref ref6 = ref4;
                        int[] iArr8 = iArr4;
                        ref6.b(new Rect(iArr8[0], iArr8[1], iArr8[2], iArr8[3]));
                    }
                    if (z3) {
                        Function2 function22 = function2;
                        Rect rectA = (Rect) ref2.a();
                        if (rectA == null) {
                            rectA = Rect.f25601e.a();
                        }
                        Rect rectA2 = (Rect) ref4.a();
                        if (rectA2 == null) {
                            rectA2 = Rect.f25601e.a();
                        }
                        function22.invoke(rectA, rectA2);
                    }
                }
            };
            composer.w(obj6);
            objG6 = obj6;
        }
        Modifier modifierA = OnPlacedModifierKt.a(modifier, (Function1) objG6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierA;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
