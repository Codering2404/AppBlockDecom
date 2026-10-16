package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
final class WrappedOverscrollEffect implements OverscrollEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OverscrollEffect f5184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DelegatableNode f5185d;

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean a() {
        return this.f5184c.a();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public long b(long j3, int i3, Function1 function1) {
        return this.f5183b ? this.f5184c.b(j3, i3, function1) : ((Offset) function1.invoke(Offset.d(j3))).u();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Object c(long j3, Function2 function2, Continuation continuation) {
        if (this.f5183b) {
            Object objC = this.f5184c.c(j3, function2, continuation);
            return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
        }
        Object objInvoke = function2.invoke(Velocity.b(j3), continuation);
        return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WrappedOverscrollEffect)) {
            return false;
        }
        WrappedOverscrollEffect wrappedOverscrollEffect = (WrappedOverscrollEffect) obj;
        return this.f5182a == wrappedOverscrollEffect.f5182a && this.f5183b == wrappedOverscrollEffect.f5183b && Intrinsics.areEqual(this.f5184c, wrappedOverscrollEffect.f5184c);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.f5185d;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f5182a) * 31) + Boolean.hashCode(this.f5183b)) * 31) + this.f5184c.hashCode();
    }
}
