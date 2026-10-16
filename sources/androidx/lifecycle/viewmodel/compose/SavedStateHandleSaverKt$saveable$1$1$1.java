package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
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
final /* synthetic */ class SavedStateHandleSaverKt$saveable$1$1$1 implements SaverScope, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SavedStateHandle.Companion f40244a;

    @Override // androidx.compose.runtime.saveable.SaverScope
    public final boolean a(Object obj) {
        return this.f40244a.b(obj);
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function b() {
        return new FunctionReferenceImpl(1, this.f40244a, SavedStateHandle.Companion.class, "validateValue", "validateValue(Ljava/lang/Object;)Z", 0);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof SaverScope) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
