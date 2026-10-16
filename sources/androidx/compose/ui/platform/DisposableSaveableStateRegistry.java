package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f28042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ SaveableStateRegistry f28043b;

    public DisposableSaveableStateRegistry(SaveableStateRegistry saveableStateRegistry, Function0 function0) {
        this.f28042a = function0;
        this.f28043b = saveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean a(Object obj) {
        return this.f28043b.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry b(String str, Function0 function0) {
        return this.f28043b.b(str, function0);
    }

    public final void c() {
        this.f28042a.invoke();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map e() {
        return this.f28043b.e();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object f(String str) {
        return this.f28043b.f(str);
    }
}
