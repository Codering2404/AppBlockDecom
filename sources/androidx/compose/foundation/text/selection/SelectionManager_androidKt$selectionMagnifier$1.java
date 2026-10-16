package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class SelectionManager_androidKt$selectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SelectionManager f11471a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager_androidKt$selectionMagnifier$1(SelectionManager selectionManager) {
        super(3);
        this.f11471a = selectionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h(MutableState mutableState) {
        return ((IntSize) mutableState.getValue()).j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MutableState mutableState, long j3) {
        mutableState.setValue(IntSize.b(j3));
    }

    public final Modifier e(Modifier modifier, Composer composer, int i3) {
        composer.a0(-1914520728);
        if (ComposerKt.M()) {
            ComposerKt.U(-1914520728, i3, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:49)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(IntSize.b(IntSize.f29998b.a()), null, 2, null);
            composer.w(objG);
        }
        final MutableState mutableState = (MutableState) objG;
        boolean zI = composer.I(this.f11471a);
        final SelectionManager selectionManager = this.f11471a;
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final long c() {
                    return SelectionManagerKt.c(selectionManager, SelectionManager_androidKt$selectionMagnifier$1.h(mutableState));
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.d(c());
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean Z = composer.Z(density);
        Object objG3 = composer.G();
        if (Z || objG3 == companion.a()) {
            objG3 = new Function1<Function0<? extends Offset>, Modifier>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Modifier invoke(final Function0 function02) {
                    Modifier.Companion companion2 = Modifier.b8;
                    Function1<Density, Offset> function1 = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.1
                        {
                            super(1);
                        }

                        public final long c(Density density2) {
                            return ((Offset) function02.invoke()).u();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return Offset.d(c((Density) obj));
                        }
                    };
                    final Density density2 = density;
                    final MutableState mutableState2 = mutableState;
                    return Magnifier_androidKt.f(companion2, function1, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void c(long j3) {
                            MutableState mutableState3 = mutableState2;
                            Density density3 = density2;
                            int iZ0 = density3.z0(DpSize.j(j3));
                            SelectionManager_androidKt$selectionMagnifier$1.m(mutableState3, IntSize.c((((long) density3.z0(DpSize.i(j3))) & 4294967295L) | (((long) iZ0) << 32)));
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c(((DpSize) obj).m());
                            return Unit.f139807a;
                        }
                    }, 0.0f, true, 0L, 0.0f, 0.0f, false, PlatformMagnifierFactory.f5107a.a(), 490, null);
                }
            };
            composer.w(objG3);
        }
        Modifier modifierD = SelectionMagnifierKt.d(modifier, function0, (Function1) objG3);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierD;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return e((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
