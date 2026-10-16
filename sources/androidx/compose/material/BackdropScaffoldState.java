package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
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
public final class BackdropScaffoldState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f12057f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f12058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SnackbarHostState f12059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnchoredDraggableState f12060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Density f12061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NestedScrollConnection f12062e;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<BackdropValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f12063a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(BackdropValue backdropValue) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final AnimationSpec animationSpec, final Function1 function1, final SnackbarHostState snackbarHostState, final Density density) {
            return SaverKt.a(new Function2<SaverScope, BackdropScaffoldState, BackdropValue>() { // from class: androidx.compose.material.BackdropScaffoldState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BackdropValue invoke(SaverScope saverScope, BackdropScaffoldState backdropScaffoldState) {
                    return (BackdropValue) backdropScaffoldState.c().s();
                }
            }, new Function1<BackdropValue, BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BackdropScaffoldState invoke(BackdropValue backdropValue) {
                    return BackdropScaffoldKt.d(backdropValue, density, animationSpec, function1, snackbarHostState);
                }
            });
        }

        private Companion() {
        }
    }

    public BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState) {
        this.f12058a = function1;
        this.f12059b = snackbarHostState;
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(backdropValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BackdropScaffoldState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(this.f12069a.j().M1(BackdropScaffoldKt.f11911c));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BackdropScaffoldState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f12070a.j().M1(BackdropScaffoldKt.f11910b));
            }
        }, animationSpec, function1);
        this.f12060c = anchoredDraggableState;
        this.f12062e = BackdropScaffoldKt.f(anchoredDraggableState, Orientation.f6031a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density j() {
        Density density = this.f12061d;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on BackdropScaffoldState (" + this + ") was not set. Did you use BackdropScaffoldState with the BackdropScaffold composable?").toString());
    }

    public final Object b(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f12060c, BackdropValue.Concealed, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final AnchoredDraggableState c() {
        return this.f12060c;
    }

    public final Function1 d() {
        return this.f12058a;
    }

    public final NestedScrollConnection e() {
        return this.f12062e;
    }

    public final SnackbarHostState f() {
        return this.f12059b;
    }

    public final BackdropValue g() {
        return (BackdropValue) this.f12060c.x();
    }

    public final boolean h() {
        return this.f12060c.s() == BackdropValue.Concealed;
    }

    public final boolean i() {
        return this.f12060c.s() == BackdropValue.Revealed;
    }

    public final Object k(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f12060c, BackdropValue.Revealed, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final void l(Density density) {
        this.f12061d = density;
    }
}
