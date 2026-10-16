package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

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
public final class BottomSheetState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f12311b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f12312a;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<BottomSheetValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f12313a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(BottomSheetValue bottomSheetValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final AnimationSpec animationSpec, final Function1 function1, final Density density) {
            return SaverKt.a(new Function2<SaverScope, BottomSheetState, BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomSheetValue invoke(SaverScope saverScope, BottomSheetState bottomSheetState) {
                    return (BottomSheetValue) bottomSheetState.c().s();
                }
            }, new Function1<BottomSheetValue, BottomSheetState>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomSheetState invoke(BottomSheetValue bottomSheetValue) {
                    return new BottomSheetState(bottomSheetValue, density, animationSpec, function1);
                }
            });
        }

        private Companion() {
        }
    }

    public BottomSheetState(BottomSheetValue bottomSheetValue, final Density density, AnimationSpec animationSpec, Function1 function1) {
        this.f12312a = new AnchoredDraggableState(bottomSheetValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(density.M1(BottomSheetScaffoldKt.f12187b));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(density.M1(BottomSheetScaffoldKt.f12188c));
            }
        }, animationSpec, function1);
    }

    public final Object a(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f12312a, BottomSheetValue.Collapsed, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final Object b(Continuation continuation) {
        DraggableAnchors draggableAnchorsO = this.f12312a.o();
        BottomSheetValue bottomSheetValue = BottomSheetValue.Expanded;
        if (!draggableAnchorsO.d(bottomSheetValue)) {
            bottomSheetValue = BottomSheetValue.Collapsed;
        }
        Object objG = AnchoredDraggableKt.g(this.f12312a, bottomSheetValue, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final AnchoredDraggableState c() {
        return this.f12312a;
    }

    public final BottomSheetValue d() {
        return (BottomSheetValue) this.f12312a.s();
    }

    public final boolean e() {
        return this.f12312a.s() == BottomSheetValue.Collapsed;
    }

    public final float f() {
        return this.f12312a.A();
    }
}
