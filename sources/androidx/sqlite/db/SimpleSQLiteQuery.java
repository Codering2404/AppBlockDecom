package androidx.sqlite.db;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f53158c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f53159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f53160b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(SupportSQLiteProgram supportSQLiteProgram, int i3, Object obj) {
            if (obj == null) {
                supportSQLiteProgram.D(i3);
                return;
            }
            if (obj instanceof byte[]) {
                supportSQLiteProgram.B(i3, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                supportSQLiteProgram.t(i3, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                supportSQLiteProgram.t(i3, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                supportSQLiteProgram.A(i3, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                supportSQLiteProgram.A(i3, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                supportSQLiteProgram.A(i3, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                supportSQLiteProgram.A(i3, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                supportSQLiteProgram.s1(i3, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                supportSQLiteProgram.A(i3, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i3 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(SupportSQLiteProgram statement, Object[] objArr) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i3 = 0;
            while (i3 < length) {
                Object obj = objArr[i3];
                i3++;
                a(statement, i3, obj);
            }
        }

        private Companion() {
        }
    }

    public SimpleSQLiteQuery(String query, Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.f53159a = query;
        this.f53160b = objArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int a() {
        Object[] objArr = this.f53160b;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String b() {
        return this.f53159a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void c(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        f53158c.b(statement, this.f53160b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(String query) {
        this(query, null);
        Intrinsics.checkNotNullParameter(query, "query");
    }
}
