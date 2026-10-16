package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@JvmInline
public final class ObservableScopeInvalidator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f8260a;

    public static final void a(MutableState mutableState) {
        mutableState.getValue();
    }

    public static /* synthetic */ MutableState c(MutableState mutableState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            mutableState = SnapshotStateKt.i(Unit.f139807a, SnapshotStateKt.k());
        }
        return b(mutableState);
    }

    public static boolean d(MutableState mutableState, Object obj) {
        return (obj instanceof ObservableScopeInvalidator) && Intrinsics.areEqual(mutableState, ((ObservableScopeInvalidator) obj).h());
    }

    public static int e(MutableState mutableState) {
        return mutableState.hashCode();
    }

    public static final void f(MutableState mutableState) {
        mutableState.setValue(Unit.f139807a);
    }

    public static String g(MutableState mutableState) {
        return "ObservableScopeInvalidator(state=" + mutableState + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f8260a, obj);
    }

    public final /* synthetic */ MutableState h() {
        return this.f8260a;
    }

    public int hashCode() {
        return e(this.f8260a);
    }

    public String toString() {
        return g(this.f8260a);
    }

    public static MutableState b(MutableState mutableState) {
        return mutableState;
    }
}
