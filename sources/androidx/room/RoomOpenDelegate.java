package androidx.room;

import androidx.sqlite.SQLiteConnection;
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
public abstract class RoomOpenDelegate implements RoomOpenDelegateMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f52339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f52340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f52341c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ValidationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f52342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52343b;

        public ValidationResult(boolean z2, String str) {
            this.f52342a = z2;
            this.f52343b = str;
        }
    }

    public RoomOpenDelegate(int i3, String identityHash, String legacyIdentityHash) {
        Intrinsics.checkNotNullParameter(identityHash, "identityHash");
        Intrinsics.checkNotNullParameter(legacyIdentityHash, "legacyIdentityHash");
        this.f52339a = i3;
        this.f52340b = identityHash;
        this.f52341c = legacyIdentityHash;
    }

    public abstract void a(SQLiteConnection sQLiteConnection);

    public abstract void b(SQLiteConnection sQLiteConnection);

    public final String c() {
        return this.f52340b;
    }

    public final String d() {
        return this.f52341c;
    }

    public final int e() {
        return this.f52339a;
    }

    public abstract void f(SQLiteConnection sQLiteConnection);

    public abstract void g(SQLiteConnection sQLiteConnection);

    public abstract void h(SQLiteConnection sQLiteConnection);

    public abstract void i(SQLiteConnection sQLiteConnection);

    public abstract ValidationResult j(SQLiteConnection sQLiteConnection);
}
