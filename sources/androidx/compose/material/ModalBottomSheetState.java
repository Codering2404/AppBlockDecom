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
public final class ModalBottomSheetState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f13221d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13222e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f13223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnchoredDraggableState f13225c;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<ModalBottomSheetValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f13226a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final AnimationSpec animationSpec, final Function1 function1, final boolean z2, final Density density) {
            return SaverKt.a(new Function2<SaverScope, ModalBottomSheetState, ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ModalBottomSheetValue invoke(SaverScope saverScope, ModalBottomSheetState modalBottomSheetState) {
                    return modalBottomSheetState.e();
                }
            }, new Function1<ModalBottomSheetValue, ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ModalBottomSheetState invoke(ModalBottomSheetValue modalBottomSheetValue) {
                    return new ModalBottomSheetState(modalBottomSheetValue, density, function1, animationSpec, z2);
                }
            });
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13232a;

        static {
            int[] iArr = new int[ModalBottomSheetValue.values().length];
            try {
                iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f13232a = iArr;
        }
    }

    public ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, final Density density, Function1 function1, AnimationSpec animationSpec, boolean z2) {
        this.f13223a = animationSpec;
        this.f13224b = z2;
        this.f13225c = new AnchoredDraggableState(modalBottomSheetValue, new Function1<Float, Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(density.M1(ModalBottomSheetKt.f13153a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(density.M1(ModalBottomSheetKt.f13154b));
            }
        }, animationSpec, function1);
        if (z2 && modalBottomSheetValue == ModalBottomSheetValue.HalfExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.");
        }
    }

    public static /* synthetic */ Object b(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = modalBottomSheetState.f13225c.v();
        }
        return modalBottomSheetState.a(modalBottomSheetValue, f3, continuation);
    }

    public final Object a(ModalBottomSheetValue modalBottomSheetValue, float f3, Continuation continuation) throws Throwable {
        Object objF = AnchoredDraggableKt.f(this.f13225c, modalBottomSheetValue, f3, continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final Object c(Continuation continuation) {
        DraggableAnchors draggableAnchorsO = this.f13225c.o();
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        if (!draggableAnchorsO.d(modalBottomSheetValue)) {
            return Unit.f139807a;
        }
        Object objB = b(this, modalBottomSheetValue, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    public final AnchoredDraggableState d() {
        return this.f13225c;
    }

    public final ModalBottomSheetValue e() {
        return (ModalBottomSheetValue) this.f13225c.s();
    }

    public final boolean f() {
        return this.f13225c.o().d(ModalBottomSheetValue.HalfExpanded);
    }

    public final ModalBottomSheetValue g() {
        return (ModalBottomSheetValue) this.f13225c.x();
    }

    public final Object h(Continuation continuation) {
        if (!f()) {
            return Unit.f139807a;
        }
        Object objB = b(this, ModalBottomSheetValue.HalfExpanded, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    public final Object i(Continuation continuation) {
        Object objB = b(this, ModalBottomSheetValue.Hidden, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    public final boolean j() {
        return this.f13224b;
    }

    public final boolean k() {
        return this.f13225c.s() != ModalBottomSheetValue.Hidden;
    }

    public final Object l(Continuation continuation) {
        DraggableAnchors draggableAnchorsO = this.f13225c.o();
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        boolean zD = draggableAnchorsO.d(modalBottomSheetValue);
        if (WhenMappings.f13232a[e().ordinal()] == 1) {
            if (f()) {
                modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
            }
        } else if (!zD) {
            modalBottomSheetValue = ModalBottomSheetValue.Hidden;
        }
        Object objB = b(this, modalBottomSheetValue, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }
}
