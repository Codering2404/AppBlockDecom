package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class Preferences {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35949a;

        public Key(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f35949a = name;
        }

        public final String a() {
            return this.f35949a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return Intrinsics.areEqual(this.f35949a, ((Key) obj).f35949a);
            }
            return false;
        }

        public int hashCode() {
            return this.f35949a.hashCode();
        }

        public String toString() {
            return this.f35949a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pair<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Key f35950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f35951b;

        public final Key a() {
            return this.f35950a;
        }

        public final Object b() {
            return this.f35951b;
        }
    }

    public abstract Map a();

    public abstract boolean b(Key key);

    public abstract Object c(Key key);

    public final MutablePreferences d() {
        return new MutablePreferences(MapsKt.toMutableMap(a()), false);
    }

    public final Preferences e() {
        return new MutablePreferences(MapsKt.toMutableMap(a()), true);
    }
}
