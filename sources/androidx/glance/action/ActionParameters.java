package androidx.glance.action;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class ActionParameters {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37665a;

        public Key(String str) {
            this.f37665a = str;
        }

        public final String a() {
            return this.f37665a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Key) && Intrinsics.areEqual(this.f37665a, ((Key) obj).f37665a);
        }

        public int hashCode() {
            return this.f37665a.hashCode();
        }

        public String toString() {
            return this.f37665a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pair<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Key f37666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f37667b;

        public final Key a() {
            return this.f37666a;
        }

        public final Object b() {
            return this.f37667b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            return Intrinsics.areEqual(this.f37666a, pair.f37666a) && Intrinsics.areEqual(this.f37667b, pair.f37667b);
        }

        public int hashCode() {
            return this.f37666a.hashCode() + this.f37667b.hashCode();
        }

        public String toString() {
            return '(' + this.f37666a.a() + ", " + this.f37667b + ')';
        }
    }

    public abstract Map a();
}
