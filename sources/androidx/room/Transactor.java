package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;

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
public interface Transactor extends PooledConnection {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SQLiteTransactionType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SQLiteTransactionType f52389a = new SQLiteTransactionType("DEFERRED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SQLiteTransactionType f52390b = new SQLiteTransactionType("IMMEDIATE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SQLiteTransactionType f52391c = new SQLiteTransactionType("EXCLUSIVE", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ SQLiteTransactionType[] f52392d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f52393f;

        static {
            SQLiteTransactionType[] sQLiteTransactionTypeArrA = a();
            f52392d = sQLiteTransactionTypeArrA;
            f52393f = EnumEntriesKt.a(sQLiteTransactionTypeArrA);
        }

        private SQLiteTransactionType(String str, int i3) {
        }

        private static final /* synthetic */ SQLiteTransactionType[] a() {
            return new SQLiteTransactionType[]{f52389a, f52390b, f52391c};
        }

        public static SQLiteTransactionType valueOf(String str) {
            return (SQLiteTransactionType) Enum.valueOf(SQLiteTransactionType.class, str);
        }

        public static SQLiteTransactionType[] values() {
            return (SQLiteTransactionType[]) f52392d.clone();
        }
    }

    Object a(SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation);

    Object b(Continuation continuation);
}
