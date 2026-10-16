package cz.mobilesoft.coreblock.scene.streaks.banner;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class StreakTopBannerKt$StreakTopBannerContent$3$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f120617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f120618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f120619c;

    StreakTopBannerKt$StreakTopBannerContent$3$1(float f3, MutableFloatState mutableFloatState, State state) {
        this.f120617a = f3;
        this.f120618b = mutableFloatState;
        this.f120619c = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(float f3, MutableFloatState mutableFloatState, State state) {
        if (StreakTopBannerKt.q(mutableFloatState) < (-f3)) {
            StreakTopBannerKt.p(state).invoke();
        } else {
            StreakTopBannerKt.r(mutableFloatState, 0.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(MutableFloatState mutableFloatState) {
        StreakTopBannerKt.r(mutableFloatState, 0.0f);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(MutableFloatState mutableFloatState, PointerInputChange pointerInputChange, float f3) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        StreakTopBannerKt.r(mutableFloatState, RangesKt.j(StreakTopBannerKt.q(mutableFloatState) + f3, 0.0f));
        return Unit.f139807a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        final float f3 = this.f120617a;
        final MutableFloatState mutableFloatState = this.f120618b;
        final State state = this.f120619c;
        Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakTopBannerKt$StreakTopBannerContent$3$1.d(f3, mutableFloatState, state);
            }
        };
        final MutableFloatState mutableFloatState2 = this.f120618b;
        Function0 function02 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakTopBannerKt$StreakTopBannerContent$3$1.e(mutableFloatState2);
            }
        };
        final MutableFloatState mutableFloatState3 = this.f120618b;
        Object objR = DragGestureDetectorKt.r(pointerInputScope, null, function0, function02, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.t
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StreakTopBannerKt$StreakTopBannerContent$3$1.f(mutableFloatState3, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, continuation, 1, null);
        return objR == IntrinsicsKt.f() ? objR : Unit.f139807a;
    }
}
