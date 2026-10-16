package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
public final class DrawerState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f17493d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f17494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f17495b = new State<Float>() { // from class: androidx.compose.material3.DrawerState$offset$1
        @Override // androidx.compose.runtime.State
        public Float getValue() {
            return Float.valueOf(this.f17511a.e().w());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f17496c = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.material3.DrawerState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<DrawerValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f17497a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DrawerValue drawerValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final Function1 function1) {
            return SaverKt.a(new Function2<SaverScope, DrawerState, DrawerValue>() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DrawerValue invoke(SaverScope saverScope, DrawerState drawerState) {
                    return drawerState.g();
                }
            }, new Function1<DrawerValue, DrawerState>() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DrawerState invoke(DrawerValue drawerValue) {
                    return new DrawerState(drawerValue, function1);
                }
            });
        }

        private Companion() {
        }
    }

    public DrawerState(DrawerValue drawerValue, Function1 function1) {
        this.f17494a = new AnchoredDraggableState(drawerValue, new Function1<Float, Float>() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$1
            public final Float c(float f3) {
                return Float.valueOf(f3 * NavigationDrawerKt.f18496a);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f17501a.k().M1(NavigationDrawerKt.f18497b));
            }
        }, NavigationDrawerKt.f18499d, function1);
    }

    private final Object b(DrawerValue drawerValue, AnimationSpec animationSpec, float f3, Continuation continuation) throws Throwable {
        Object objK = AnchoredDraggableState.k(this.f17494a, drawerValue, null, new DrawerState$animateTo$3(this, f3, animationSpec, null), continuation, 2, null);
        return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
    }

    static /* synthetic */ Object c(DrawerState drawerState, DrawerValue drawerValue, AnimationSpec animationSpec, float f3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            animationSpec = NavigationDrawerKt.f18499d;
        }
        if ((i3 & 4) != 0) {
            f3 = drawerState.f17494a.v();
        }
        return drawerState.b(drawerValue, animationSpec, f3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density k() {
        Density densityH = h();
        if (densityH != null) {
            return densityH;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?").toString());
    }

    public final Object d(Continuation continuation) {
        Object objC = c(this, DrawerValue.Closed, null, 0.0f, continuation, 6, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public final AnchoredDraggableState e() {
        return this.f17494a;
    }

    public final float f() {
        return this.f17494a.w();
    }

    public final DrawerValue g() {
        return (DrawerValue) this.f17494a.s();
    }

    public final Density h() {
        return (Density) this.f17496c.getValue();
    }

    public final boolean i() {
        return g() == DrawerValue.Closed;
    }

    public final boolean j() {
        return g() == DrawerValue.Open;
    }

    public final float l() {
        return this.f17494a.A();
    }

    public final void m(Density density) {
        this.f17496c.setValue(density);
    }
}
