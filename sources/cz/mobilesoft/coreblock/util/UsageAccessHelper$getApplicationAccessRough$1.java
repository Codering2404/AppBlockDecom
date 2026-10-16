package cz.mobilesoft.coreblock.util;

import android.app.usage.UsageStatsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$getApplicationAccessRough$1", f = "UsageAccessHelper.kt", l = {200}, m = "invokeSuspend", v = 1)
final class UsageAccessHelper$getApplicationAccessRough$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f128042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UsageStatsManager f128043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f128044d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f128045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f128046g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.UsageAccessHelper$getApplicationAccessRough$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$getApplicationAccessRough$1$1", f = "UsageAccessHelper.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f128049c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, List list, Continuation continuation) {
            super(2, continuation);
            this.f128048b = function1;
            this.f128049c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128048b, this.f128049c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128047a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f128048b.invoke(this.f128049c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageAccessHelper$getApplicationAccessRough$1(UsageStatsManager usageStatsManager, long j3, long j4, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f128043c = usageStatsManager;
        this.f128044d = j3;
        this.f128045f = j4;
        this.f128046g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UsageAccessHelper$getApplicationAccessRough$1(this.f128043c, this.f128044d, this.f128045f, this.f128046g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128042b;
        if (i3 == 0) {
            ResultKt.b(obj);
            List listK = UsageAccessHelper.f128032a.k(this.f128043c, this.f128044d, this.f128045f);
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128046g, listK, null);
            this.f128041a = SpillingKt.a(listK);
            this.f128042b = 1;
            if (BuildersKt.g(mainCoroutineDispatcherC, anonymousClass1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UsageAccessHelper$getApplicationAccessRough$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
