package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1", f = "SharedSessionRepository.kt", l = {112}, m = "invokeSuspend")
final class SharedSessionRepositoryImpl$appBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f90093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedSessionRepositoryImpl f90094b;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appBackground$1$1", f = "SharedSessionRepository.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<SessionData, Continuation<? super SessionData>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f90095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f90096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SharedSessionRepositoryImpl f90097c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation continuation) {
            super(2, continuation);
            this.f90097c = sharedSessionRepositoryImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f90097c, continuation);
            anonymousClass1.f90096b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SessionData sessionData, Continuation continuation) {
            return ((AnonymousClass1) create(sessionData, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f90095a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return SessionData.c((SessionData) this.f90096b, null, this.f90097c.f90073e.a(), null, 5, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SharedSessionRepositoryImpl$appBackground$1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation continuation) {
        super(2, continuation);
        this.f90094b = sharedSessionRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SharedSessionRepositoryImpl$appBackground$1(this.f90094b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f90093a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                DataStore dataStore = this.f90094b.f90074f;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f90094b, null);
                this.f90093a = 1;
                if (dataStore.a(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e3) {
            Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + e3.getMessage());
            SharedSessionRepositoryImpl sharedSessionRepositoryImpl = this.f90094b;
            sharedSessionRepositoryImpl.r(SessionData.c(sharedSessionRepositoryImpl.m(), null, this.f90094b.f90073e.a(), null, 5, null));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SharedSessionRepositoryImpl$appBackground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
