package androidx.room;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RoomRawQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f52352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f52353b;

    public RoomRawQuery(String sql, final Function1 onBindStatement) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(onBindStatement, "onBindStatement");
        this.f52352a = sql;
        this.f52353b = new Function1() { // from class: androidx.room.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomRawQuery.d(onBindStatement, (SQLiteStatement) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function1 function1, SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new BindOnlySQLiteStatement(it));
        return Unit.f139807a;
    }

    public final Function1 e() {
        return this.f52353b;
    }

    public final String f() {
        return this.f52352a;
    }

    public /* synthetic */ RoomRawQuery(String str, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? new Function1() { // from class: androidx.room.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomRawQuery.c((SQLiteStatement) obj);
            }
        } : function1);
    }
}
