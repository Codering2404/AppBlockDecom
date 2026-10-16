package androidx.glance.action;

import androidx.glance.action.ActionParameters;
import java.util.Collections;
import java.util.Map;
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
public final class MutableActionParameters extends ActionParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f37670a;

    public MutableActionParameters(Map map) {
        this.f37670a = map;
    }

    @Override // androidx.glance.action.ActionParameters
    public Map a() {
        return Collections.unmodifiableMap(this.f37670a);
    }

    public Object b(ActionParameters.Key key) {
        return this.f37670a.get(key);
    }

    public final Object c(ActionParameters.Key key) {
        return this.f37670a.remove(key);
    }

    public final Object d(ActionParameters.Key key, Object obj) {
        Object objB = b(key);
        if (obj == null) {
            c(key);
            return objB;
        }
        this.f37670a.put(key, obj);
        return objB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableActionParameters) && Intrinsics.areEqual(this.f37670a, ((MutableActionParameters) obj).f37670a);
    }

    public int hashCode() {
        return this.f37670a.hashCode();
    }

    public String toString() {
        return this.f37670a.toString();
    }
}
