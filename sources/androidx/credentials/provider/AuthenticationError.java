package androidx.credentials.provider;

import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AuthenticationError {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f35234c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f35235d = "AuthenticationError";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final LinkedHashMap f35236e = MapsKt.linkedMapOf(TuplesKt.a(5, 5), TuplesKt.a(12, 12), TuplesKt.a(1, 1), TuplesKt.a(7, 7), TuplesKt.a(9, 9), TuplesKt.a(11, 11), TuplesKt.a(14, 14), TuplesKt.a(4, 4), TuplesKt.a(15, 15), TuplesKt.a(3, 3), TuplesKt.a(2, 2), TuplesKt.a(10, 10), TuplesKt.a(8, 8));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f35238b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthenticationError) {
            AuthenticationError authenticationError = (AuthenticationError) obj;
            if (this.f35237a == authenticationError.f35237a && Intrinsics.areEqual(this.f35238b, authenticationError.f35238b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f35237a), this.f35238b);
    }
}
