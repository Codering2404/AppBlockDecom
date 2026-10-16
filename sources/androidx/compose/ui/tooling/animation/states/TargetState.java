package androidx.compose.ui.tooling.animation.states;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TargetState<T> implements ComposeAnimationState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f29911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f29912b;

    public TargetState(Object obj, Object obj2) {
        this.f29911a = obj;
        this.f29912b = obj2;
    }

    public final Object a() {
        return this.f29911a;
    }

    public final Object b() {
        return this.f29912b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TargetState)) {
            return false;
        }
        TargetState targetState = (TargetState) obj;
        return Intrinsics.areEqual(this.f29911a, targetState.f29911a) && Intrinsics.areEqual(this.f29912b, targetState.f29912b);
    }

    public int hashCode() {
        Object obj = this.f29911a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f29912b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "TargetState(initial=" + this.f29911a + ", target=" + this.f29912b + ')';
    }
}
