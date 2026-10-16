package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
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
@Deprecated
@Metadata
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj);

    public final void insert(T t2) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t2);
            supportSQLiteStatementAcquire.k1();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long insertAndReturnId(T t2) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t2);
            return supportSQLiteStatementAcquire.k1();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i3 = 0;
            for (T t2 : entities) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                bind(supportSQLiteStatementAcquire, t2);
                jArr[i3] = supportSQLiteStatementAcquire.k1();
                i3 = i4;
            }
            release(supportSQLiteStatementAcquire);
            return jArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i3 = 0; i3 < size; i3++) {
                bind(supportSQLiteStatementAcquire, it.next());
                lArr[i3] = Long.valueOf(supportSQLiteStatementAcquire.k1());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            for (T t2 : entities) {
                bind(supportSQLiteStatementAcquire, t2);
                listCreateListBuilder.add(Long.valueOf(supportSQLiteStatementAcquire.k1()));
            }
            List<Long> listBuild = CollectionsKt.build(listCreateListBuilder);
            release(supportSQLiteStatementAcquire);
            return listBuild;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            for (T t2 : entities) {
                bind(supportSQLiteStatementAcquire, t2);
                supportSQLiteStatementAcquire.k1();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 1;
                bind(supportSQLiteStatementAcquire, entities[i3]);
                jArr[i4] = supportSQLiteStatementAcquire.k1();
                i3++;
                i4 = i5;
            }
            return jArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator itA = ArrayIteratorKt.a(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i3 = 0; i3 < length; i3++) {
                bind(supportSQLiteStatementAcquire, itA.next());
                lArr[i3] = Long.valueOf(supportSQLiteStatementAcquire.k1());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                listCreateListBuilder.add(Long.valueOf(supportSQLiteStatementAcquire.k1()));
            }
            List<Long> listBuild = CollectionsKt.build(listCreateListBuilder);
            release(supportSQLiteStatementAcquire);
            return listBuild;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                supportSQLiteStatementAcquire.k1();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
