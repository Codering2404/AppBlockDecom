package androidx.room.paging.util;

import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.Transactor;
import androidx.room.paging.util.RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2;
import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.room.paging.util.RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2", f = "RoomPagingUtil.kt", l = {160}, m = "invokeSuspend")
final class RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RoomDatabase f52723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f52724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RoomRawQuery f52725d;

    /* JADX INFO: renamed from: androidx.room.paging.util.RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.paging.util.RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2$1", f = "RoomPagingUtil.kt", l = {161}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f52727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f52728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoomRawQuery f52729d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, RoomRawQuery roomRawQuery, Continuation continuation) {
            super(2, continuation);
            this.f52728c = str;
            this.f52729d = roomRawQuery;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(RoomRawQuery roomRawQuery, SQLiteStatement sQLiteStatement) {
            roomRawQuery.e().invoke(sQLiteStatement);
            if (sQLiteStatement.B2()) {
                return sQLiteStatement.getInt(0);
            }
            return 0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52728c, this.f52729d, continuation);
            anonymousClass1.f52727b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52726a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            Transactor transactor = (Transactor) this.f52727b;
            String str = this.f52728c;
            final RoomRawQuery roomRawQuery = this.f52729d;
            Function1 function1 = new Function1() { // from class: androidx.room.paging.util.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Integer.valueOf(RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2.AnonymousClass1.y(roomRawQuery, (SQLiteStatement) obj2));
                }
            };
            this.f52726a = 1;
            Object objD = transactor.d(str, function1, this);
            return objD == objF ? objF : objD;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Transactor transactor, Continuation continuation) {
            return ((AnonymousClass1) create(transactor, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2(RoomDatabase roomDatabase, String str, RoomRawQuery roomRawQuery, Continuation continuation) {
        super(2, continuation);
        this.f52723b = roomDatabase;
        this.f52724c = str;
        this.f52725d = roomRawQuery;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2(this.f52723b, this.f52724c, this.f52725d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f52722a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        RoomDatabase roomDatabase = this.f52723b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52724c, this.f52725d, null);
        this.f52722a = 1;
        Object objUseConnection = roomDatabase.useConnection(true, anonymousClass1, this);
        return objUseConnection == objF ? objF : objUseConnection;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
