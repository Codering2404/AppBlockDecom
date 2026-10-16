package androidx.room.util;

import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
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
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", l = {72}, m = "invokeSuspend")
final class DBUtil__DBUtil_androidKt$performBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineContext f52882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RoomDatabase f52883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f52884d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f52885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f52886g;

    /* JADX INFO: renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1", f = "DBUtil.android.kt", l = {260}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RoomDatabase f52888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f52889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f52890d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f52891f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomDatabase roomDatabase, boolean z2, boolean z3, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f52888b = roomDatabase;
            this.f52889c = z2;
            this.f52890d = z3;
            this.f52891f = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f52888b, this.f52889c, this.f52890d, this.f52891f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52887a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            boolean z2 = !(this.f52888b.inCompatibilityMode() && this.f52888b.inTransaction()) && this.f52889c;
            RoomDatabase roomDatabase = this.f52888b;
            boolean z3 = this.f52890d;
            DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1(z2, z3, roomDatabase, null, this.f52891f);
            this.f52887a = 1;
            Object objUseConnection = roomDatabase.useConnection(z3, dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1, this);
            return objUseConnection == objF ? objF : objUseConnection;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DBUtil__DBUtil_androidKt$performBlocking$1(CoroutineContext coroutineContext, RoomDatabase roomDatabase, boolean z2, boolean z3, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f52882b = coroutineContext;
        this.f52883c = roomDatabase;
        this.f52884d = z2;
        this.f52885f = z3;
        this.f52886g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DBUtil__DBUtil_androidKt$performBlocking$1(this.f52882b, this.f52883c, this.f52884d, this.f52885f, this.f52886g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f52881a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CoroutineContext coroutineContext = this.f52882b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52883c, this.f52884d, this.f52885f, this.f52886g, null);
        this.f52881a = 1;
        Object objG = BuildersKt.g(coroutineContext, anonymousClass1, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DBUtil__DBUtil_androidKt$performBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
