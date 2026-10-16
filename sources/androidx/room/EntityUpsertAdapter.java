package androidx.room;

import android.database.SQLException;
import androidx.sqlite.SQLiteConnection;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class EntityUpsertAdapter<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f52151c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EntityInsertAdapter f52152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f52153b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public EntityUpsertAdapter(EntityInsertAdapter entityInsertAdapter, EntityDeleteOrUpdateAdapter updateAdapter) {
        Intrinsics.checkNotNullParameter(entityInsertAdapter, "entityInsertAdapter");
        Intrinsics.checkNotNullParameter(updateAdapter, "updateAdapter");
        this.f52152a = entityInsertAdapter;
        this.f52153b = updateAdapter;
    }

    private final void a(SQLException sQLException) {
        String message = sQLException.getMessage();
        if (message == null) {
            throw sQLException;
        }
        if (!StringsKt.Y(message, "unique", true) && !StringsKt.a0(message, "2067", false, 2, null) && !StringsKt.a0(message, "1555", false, 2, null)) {
            throw sQLException;
        }
    }

    public final long b(SQLiteConnection connection, Object obj) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            return this.f52152a.d(connection, obj);
        } catch (SQLException e3) {
            a(e3);
            this.f52153b.c(connection, obj);
            return -1L;
        }
    }

    public final List c(SQLiteConnection connection, Collection collection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (collection == null) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (T t2 : collection) {
            try {
                listCreateListBuilder.add(Long.valueOf(this.f52152a.d(connection, t2)));
            } catch (SQLException e3) {
                a(e3);
                this.f52153b.c(connection, t2);
                listCreateListBuilder.add(-1L);
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }
}
