package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
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
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Density f6654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ BoxScopeInstance f6656c;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j3);
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public long c() {
        return this.f6655b;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float d() {
        return Constraints.h(c()) ? this.f6654a.F(Constraints.l(c())) : Dp.f29970b.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return Intrinsics.areEqual(this.f6654a, boxWithConstraintsScopeImpl.f6654a) && Constraints.f(this.f6655b, boxWithConstraintsScopeImpl.f6655b);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier f(Modifier modifier, Alignment alignment) {
        return this.f6656c.f(modifier, alignment);
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    public float g() {
        return Constraints.g(c()) ? this.f6654a.F(Constraints.k(c())) : Dp.f29970b.b();
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier h(Modifier modifier) {
        return this.f6656c.h(modifier);
    }

    public int hashCode() {
        return (this.f6654a.hashCode() * 31) + Constraints.o(this.f6655b);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.f6654a + ", constraints=" + ((Object) Constraints.q(this.f6655b)) + ')';
    }

    private BoxWithConstraintsScopeImpl(Density density, long j3) {
        this.f6654a = density;
        this.f6655b = j3;
        this.f6656c = BoxScopeInstance.f6642a;
    }
}
