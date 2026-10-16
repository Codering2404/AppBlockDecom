package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

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
final class DefaultScrollableState implements ScrollableState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f5619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScrollScope f5620b = new ScrollScope() { // from class: androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float d(float f3) {
            if (Float.isNaN(f3)) {
                return 0.0f;
            }
            float fFloatValue = ((Number) this.f5633a.l().invoke(Float.valueOf(f3))).floatValue();
            this.f5633a.f5623e.setValue(Boolean.valueOf(fFloatValue > 0.0f));
            this.f5633a.f5624f.setValue(Boolean.valueOf(fFloatValue < 0.0f));
            return fFloatValue;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutatorMutex f5621c = new MutatorMutex();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f5622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f5623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f5624f;

    public DefaultScrollableState(Function1 function1) {
        this.f5619a = function1;
        Boolean bool = Boolean.FALSE;
        this.f5622d = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f5623e = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f5624f = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return ((Number) this.f5619a.invoke(Float.valueOf(f3))).floatValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return ((Boolean) this.f5622d.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object e(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new DefaultScrollableState$scroll$2(this, mutatePriority, function2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final Function1 l() {
        return this.f5619a;
    }
}
