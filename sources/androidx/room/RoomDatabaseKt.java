package androidx.room;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RoomDatabaseKt {
    public static final Object a(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return RoomDatabaseKt__RoomDatabase_androidKt.b(roomDatabase, function1, continuation);
    }

    public static final Object b(RoomDatabase roomDatabase, Function2 function2, Continuation continuation) {
        return RoomDatabaseKt__RoomDatabaseKt.a(roomDatabase, function2, continuation);
    }

    public static final Object c(RoomDatabase roomDatabase, Function2 function2, Continuation continuation) {
        return RoomDatabaseKt__RoomDatabaseKt.b(roomDatabase, function2, continuation);
    }

    public static final void d(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.c(roomDatabase, databaseConfiguration);
    }

    public static final void e(Set set, Set set2) {
        RoomDatabaseKt__RoomDatabaseKt.d(set, set2);
    }

    public static final void f(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.e(roomDatabase, databaseConfiguration);
    }

    public static final Object g(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return RoomDatabaseKt__RoomDatabase_androidKt.e(roomDatabase, function1, continuation);
    }

    public static final Object h(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return RoomDatabaseKt__RoomDatabase_androidKt.f(roomDatabase, function1, continuation);
    }
}
