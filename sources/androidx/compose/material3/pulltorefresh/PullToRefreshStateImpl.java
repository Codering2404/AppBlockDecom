package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class PullToRefreshStateImpl implements PullToRefreshState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f22289b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Saver f22290c = SaverKt.a(new Function2<SaverScope, PullToRefreshStateImpl, Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Float invoke(SaverScope saverScope, PullToRefreshStateImpl pullToRefreshStateImpl) {
            return (Float) pullToRefreshStateImpl.f22291a.n();
        }
    }, new Function1<Float, PullToRefreshStateImpl>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$Companion$Saver$2
        public final PullToRefreshStateImpl c(float f3) {
            return new PullToRefreshStateImpl(new Animatable(Float.valueOf(f3), VectorConvertersKt.i(FloatCompanionObject.f140130a), null, null, 12, null), null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).floatValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Animatable f22291a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return PullToRefreshStateImpl.f22290c;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PullToRefreshStateImpl(Animatable animatable, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatable);
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public float a() {
        return ((Number) this.f22291a.n()).floatValue();
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public Object b(Continuation continuation) {
        Object objF = Animatable.f(this.f22291a, Boxing.c(0.0f), null, null, null, continuation, 14, null);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public boolean c() {
        return this.f22291a.q();
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public Object d(float f3, Continuation continuation) {
        Object objU = this.f22291a.u(Boxing.c(f3), continuation);
        return objU == IntrinsicsKt.f() ? objU : Unit.f139807a;
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public Object e(Continuation continuation) {
        Object objF = Animatable.f(this.f22291a, Boxing.c(1.0f), null, null, null, continuation, 14, null);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    private PullToRefreshStateImpl(Animatable animatable) {
        this.f22291a = animatable;
    }

    public PullToRefreshStateImpl() {
        this(new Animatable(Float.valueOf(0.0f), VectorConvertersKt.i(FloatCompanionObject.f140130a), null, null, 12, null));
    }
}
