package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
public final class BottomDrawerState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f12101c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12102d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f12103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NestedScrollConnection f12104b;

    /* JADX INFO: renamed from: androidx.compose.material.BottomDrawerState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<BottomDrawerValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f12105a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(BottomDrawerValue bottomDrawerValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final Density density, final Function1 function1, final AnimationSpec animationSpec) {
            return SaverKt.a(new Function2<SaverScope, BottomDrawerState, BottomDrawerValue>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomDrawerValue invoke(SaverScope saverScope, BottomDrawerState bottomDrawerState) {
                    return (BottomDrawerValue) bottomDrawerState.c().s();
                }
            }, new Function1<BottomDrawerValue, BottomDrawerState>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomDrawerState invoke(BottomDrawerValue bottomDrawerValue) {
                    return new BottomDrawerState(bottomDrawerValue, density, function1, animationSpec);
                }
            });
        }

        private Companion() {
        }
    }

    public BottomDrawerState(BottomDrawerValue bottomDrawerValue, final Density density, Function1 function1, AnimationSpec animationSpec) {
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(bottomDrawerValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BottomDrawerState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(density.M1(DrawerKt.f12715b));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BottomDrawerState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(density.M1(DrawerKt.f12716c));
            }
        }, animationSpec, function1);
        this.f12103a = anchoredDraggableState;
        this.f12104b = DrawerKt.d(anchoredDraggableState);
    }

    public final Object a(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f12103a, BottomDrawerValue.Closed, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final boolean b(BottomDrawerValue bottomDrawerValue) {
        return ((Boolean) this.f12103a.r().invoke(bottomDrawerValue)).booleanValue();
    }

    public final AnchoredDraggableState c() {
        return this.f12103a;
    }

    public final BottomDrawerValue d() {
        return (BottomDrawerValue) this.f12103a.s();
    }

    public final NestedScrollConnection e() {
        return this.f12104b;
    }

    public final BottomDrawerValue f() {
        return (BottomDrawerValue) this.f12103a.x();
    }

    public final boolean g() {
        return this.f12103a.s() != BottomDrawerValue.Closed;
    }

    public final float h() {
        return this.f12103a.A();
    }
}
