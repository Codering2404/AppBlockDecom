package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.List;
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
public final class RawConstraintSet implements ConstraintSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CLObject f30925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConstraintSetParser.LayoutVariables f30926b = new ConstraintSetParser.LayoutVariables();

    public RawConstraintSet(CLObject cLObject) {
        this.f30925a = cLObject;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void a(State state, List list) {
        ConstraintSetParser.C(this.f30925a, state, this.f30926b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(RawConstraintSet.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.constraintlayout.compose.RawConstraintSet");
        return Intrinsics.areEqual(this.f30925a, ((RawConstraintSet) obj).f30925a);
    }

    public int hashCode() {
        return this.f30925a.hashCode();
    }
}
