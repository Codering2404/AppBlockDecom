package androidx.compose.material;

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

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f12851c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f12852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Density f12853b;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<DrawerValue, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f12854a = new AnonymousClass1();

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
            return SaverKt.a(new Function2<SaverScope, DrawerState, DrawerValue>() { // from class: androidx.compose.material.DrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DrawerValue invoke(SaverScope saverScope, DrawerState drawerState) {
                    return drawerState.d();
                }
            }, new Function1<DrawerValue, DrawerState>() { // from class: androidx.compose.material.DrawerState$Companion$Saver$2
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
        this.f12852a = new AnchoredDraggableState(drawerValue, new Function1<Float, Float>() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(this.f12857a.f().M1(DrawerKt.f12715b));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f12858a.f().M1(DrawerKt.f12716c));
            }
        }, DrawerKt.f12717d, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density f() {
        Density density = this.f12853b;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }

    public final Object b(Continuation continuation) {
        Object objG = AnchoredDraggableKt.g(this.f12852a, DrawerValue.Closed, 0.0f, continuation, 2, null);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final AnchoredDraggableState c() {
        return this.f12852a;
    }

    public final DrawerValue d() {
        return (DrawerValue) this.f12852a.s();
    }

    public final boolean e() {
        return d() == DrawerValue.Open;
    }

    public final float g() {
        return this.f12852a.A();
    }

    public final void h(Density density) {
        this.f12853b = density;
    }
}
