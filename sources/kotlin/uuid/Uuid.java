package kotlin.uuid;

import com.facebook.stetho.dumpapp.Framer;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Uuid implements Comparable<Uuid>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140682c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Uuid f140683d = new Uuid(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f140685b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uuid a(long j3, long j4) {
            return (j3 == 0 && j4 == 0) ? b() : new Uuid(j3, j4, null);
        }

        public final Uuid b() {
            return Uuid.f140683d;
        }

        public final Uuid c(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return UuidKt__UuidJVMKt.c(uuidString);
            }
            if (length == 36) {
                return UuidKt__UuidJVMKt.d(uuidString);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.h(uuidString, 64) + "\" of length " + uuidString.length());
        }

        private Companion() {
        }
    }

    public /* synthetic */ Uuid(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return UuidKt__UuidJVMKt.b(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Uuid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j3 = this.f140684a;
        return j3 != other.f140684a ? Long.compareUnsigned(ULong.b(j3), ULong.b(other.f140684a)) : Long.compareUnsigned(ULong.b(this.f140685b), ULong.b(other.f140685b));
    }

    public final long c() {
        return this.f140685b;
    }

    public final long d() {
        return this.f140684a;
    }

    public final String e() {
        byte[] bArr = new byte[36];
        UuidKt__UuidJVMKt.a(this.f140684a, bArr, 0, 0, 4);
        bArr[8] = Framer.STDIN_FRAME_PREFIX;
        UuidKt__UuidJVMKt.a(this.f140684a, bArr, 9, 4, 6);
        bArr[13] = Framer.STDIN_FRAME_PREFIX;
        UuidKt__UuidJVMKt.a(this.f140684a, bArr, 14, 6, 8);
        bArr[18] = Framer.STDIN_FRAME_PREFIX;
        UuidKt__UuidJVMKt.a(this.f140685b, bArr, 19, 0, 2);
        bArr[23] = Framer.STDIN_FRAME_PREFIX;
        UuidKt__UuidJVMKt.a(this.f140685b, bArr, 24, 2, 8);
        return StringsKt.B(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.f140684a == uuid.f140684a && this.f140685b == uuid.f140685b;
    }

    public int hashCode() {
        return Long.hashCode(this.f140684a ^ this.f140685b);
    }

    public String toString() {
        return e();
    }

    private Uuid(long j3, long j4) {
        this.f140684a = j3;
        this.f140685b = j4;
    }
}
