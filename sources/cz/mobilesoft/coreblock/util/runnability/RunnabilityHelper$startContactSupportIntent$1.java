package cz.mobilesoft.coreblock.util.runnability;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$startContactSupportIntent$1", f = "RunnabilityHelper.kt", l = {351}, m = "invokeSuspend", v = 1)
final class RunnabilityHelper$startContactSupportIntent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f129637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f129638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContactReason f129639d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f129640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f129641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f129642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Integer f129643i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$startContactSupportIntent$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$startContactSupportIntent$1$1", f = "RunnabilityHelper.kt", l = {352}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f129644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f129645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f129646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ContactReason f129647d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f129648f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f129649g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f129650h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Integer f129651i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, Context context, ContactReason contactReason, String str, boolean z3, int i3, Integer num, Continuation continuation) {
            super(2, continuation);
            this.f129645b = z2;
            this.f129646c = context;
            this.f129647d = contactReason;
            this.f129648f = str;
            this.f129649g = z3;
            this.f129650h = i3;
            this.f129651i = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f129645b, this.f129646c, this.f129647d, this.f129648f, this.f129649g, this.f129650h, this.f129651i, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Intent intentO;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f129644a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowB3 = RunnabilityHelper.f129617a.g().b3();
                this.f129644a = 1;
                obj = FlowKt.D(flowB3, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            if (!((Boolean) obj).booleanValue() || this.f129645b) {
                Context context = this.f129646c;
                intentO = RunnabilityHelper.o(context, this.f129650h, RunnabilityHelper.h(context), "Support");
            } else {
                intentO = FeedbackActivity.Companion.b(FeedbackActivity.f102045f, this.f129646c, this.f129647d, null, null, this.f129648f, null, this.f129649g, 44, null);
            }
            Integer num = this.f129651i;
            if (num != null) {
                intentO.setFlags(num.intValue());
            }
            this.f129646c.startActivity(intentO);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RunnabilityHelper$startContactSupportIntent$1(boolean z2, Context context, ContactReason contactReason, String str, boolean z3, int i3, Integer num, Continuation continuation) {
        super(1, continuation);
        this.f129637b = z2;
        this.f129638c = context;
        this.f129639d = contactReason;
        this.f129640f = str;
        this.f129641g = z3;
        this.f129642h = i3;
        this.f129643i = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RunnabilityHelper$startContactSupportIntent$1(this.f129637b, this.f129638c, this.f129639d, this.f129640f, this.f129641g, this.f129642h, this.f129643i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129636a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f129637b, this.f129638c, this.f129639d, this.f129640f, this.f129641g, this.f129642h, this.f129643i, null);
            this.f129636a = 1;
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RunnabilityHelper$startContactSupportIntent$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
