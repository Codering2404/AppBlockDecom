package cz.mobilesoft.coreblock.storage.room.management;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_2_3$1$migrate$1", f = "CoreMigrations.kt", l = {101}, m = "invokeSuspend", v = 1)
final class CoreMigrationsKt$MIGRATION_2_3$1$migrate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f126701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f126702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f126703d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SQLiteDatabase f126704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CoreMigrationsKt$MIGRATION_2_3$1 f126705g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreMigrationsKt$MIGRATION_2_3$1$migrate$1(SQLiteDatabase sQLiteDatabase, CoreMigrationsKt$MIGRATION_2_3$1 coreMigrationsKt$MIGRATION_2_3$1, Continuation continuation) {
        super(2, continuation);
        this.f126704f = sQLiteDatabase;
        this.f126705g = coreMigrationsKt$MIGRATION_2_3$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CoreMigrationsKt$MIGRATION_2_3$1$migrate$1 coreMigrationsKt$MIGRATION_2_3$1$migrate$1 = new CoreMigrationsKt$MIGRATION_2_3$1$migrate$1(this.f126704f, this.f126705g, continuation);
        coreMigrationsKt$MIGRATION_2_3$1$migrate$1.f126703d = obj;
        return coreMigrationsKt$MIGRATION_2_3$1$migrate$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01b0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_2_3$1$migrate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoreMigrationsKt$MIGRATION_2_3$1$migrate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
