package cz.mobilesoft.coreblock.storage.room.management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateGreendaoToRoom$3", f = "GreendaoToRoomMigration.kt", l = {47}, m = "invokeSuspend", v = 1)
final class GreendaoToRoomMigrationKt$migrateGreendaoToRoom$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SQLiteDatabase f126724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f126725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BlockingDatabase f126726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GreendaoToRoomMigrationKt$migrateGreendaoToRoom$3(SQLiteDatabase sQLiteDatabase, Context context, BlockingDatabase blockingDatabase, Continuation continuation) {
        super(1, continuation);
        this.f126724b = sQLiteDatabase;
        this.f126725c = context;
        this.f126726d = blockingDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new GreendaoToRoomMigrationKt$migrateGreendaoToRoom$3(this.f126724b, this.f126725c, this.f126726d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126723a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SQLiteDatabase sQLiteDatabase = this.f126724b;
            Context context = this.f126725c;
            BlockingDatabase blockingDatabase = this.f126726d;
            this.f126723a = 1;
            if (GreendaoToRoomMigrationKt.H(sQLiteDatabase, context, blockingDatabase, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((GreendaoToRoomMigrationKt$migrateGreendaoToRoom$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
