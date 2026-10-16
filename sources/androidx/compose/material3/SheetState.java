package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
public final class SheetState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f19855d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnchoredDraggableState f19858c;

    /* JADX INFO: renamed from: androidx.compose.material3.SheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<SheetValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f19859a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SheetValue sheetValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final boolean z2, final Function1 function1, final Density density, final boolean z3) {
            return SaverKt.a(new Function2<SaverScope, SheetState, SheetValue>() { // from class: androidx.compose.material3.SheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final SheetValue invoke(SaverScope saverScope, SheetState sheetState) {
                    return sheetState.e();
                }
            }, new Function1<SheetValue, SheetState>() { // from class: androidx.compose.material3.SheetState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final SheetState invoke(SheetValue sheetValue) {
                    return new SheetState(z2, density, sheetValue, function1, z3);
                }
            });
        }

        private Companion() {
        }
    }

    public SheetState(boolean z2, final Density density, SheetValue sheetValue, Function1 function1, boolean z3) {
        this.f19856a = z2;
        this.f19857b = z3;
        if (z2 && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.");
        }
        if (z3 && sheetValue == SheetValue.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.");
        }
        this.f19858c = new AnchoredDraggableState(sheetValue, new Function1<Float, Float>() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(density.M1(Dp.g(56)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(density.M1(Dp.g(125)));
            }
        }, SheetDefaultsKt.f19845b, function1);
    }

    public static /* synthetic */ Object b(SheetState sheetState, SheetValue sheetValue, float f3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = sheetState.f19858c.v();
        }
        return sheetState.a(sheetValue, f3, continuation);
    }

    public final Object a(SheetValue sheetValue, float f3, Continuation continuation) throws Throwable {
        Object objF = AnchoredDraggableKt.f(this.f19858c, sheetValue, f3, continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final Object c(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f19858c, SheetValue.Expanded, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final AnchoredDraggableState d() {
        return this.f19858c;
    }

    public final SheetValue e() {
        return (SheetValue) this.f19858c.s();
    }

    public final boolean f() {
        return this.f19858c.o().d(SheetValue.Expanded);
    }

    public final boolean g() {
        return this.f19858c.o().d(SheetValue.PartiallyExpanded);
    }

    public final boolean h() {
        return this.f19857b;
    }

    public final boolean i() {
        return this.f19856a;
    }

    public final SheetValue j() {
        return (SheetValue) this.f19858c.x();
    }

    public final Object k(Continuation continuation) {
        if (this.f19857b) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.");
        }
        Object objB = b(this, SheetValue.Hidden, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    public final boolean l() {
        return this.f19858c.s() != SheetValue.Hidden;
    }

    public final Object m(Continuation continuation) {
        if (this.f19856a) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.");
        }
        Object objB = b(this, SheetValue.PartiallyExpanded, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    public final float n() {
        return this.f19858c.A();
    }

    public final Object o(float f3, Continuation continuation) throws Throwable {
        Object objG = this.f19858c.G(f3, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final Object p(Continuation continuation) {
        Object objB = b(this, g() ? SheetValue.PartiallyExpanded : SheetValue.Expanded, 0.0f, continuation, 2, null);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }
}
