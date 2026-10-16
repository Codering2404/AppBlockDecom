package androidx.glance.session;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2", f = "IdleEventBroadcastReceiver.kt", l = {88}, m = "invokeSuspend")
final class IdleEventBroadcastReceiverKt$observeIdleEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f39545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f39546d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f39547f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IdleEventBroadcastReceiverKt$observeIdleEvents$2(Context context, Function1 function1, Function1 function12, Continuation continuation) {
        super(2, continuation);
        this.f39545c = context;
        this.f39546d = function1;
        this.f39547f = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        IdleEventBroadcastReceiverKt$observeIdleEvents$2 idleEventBroadcastReceiverKt$observeIdleEvents$2 = new IdleEventBroadcastReceiverKt$observeIdleEvents$2(this.f39545c, this.f39546d, this.f39547f, continuation);
        idleEventBroadcastReceiverKt$observeIdleEvents$2.f39544b = obj;
        return idleEventBroadcastReceiverKt$observeIdleEvents$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IdleEventBroadcastReceiver idleEventBroadcastReceiver;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39543a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            idleEventBroadcastReceiver = (IdleEventBroadcastReceiver) this.f39544b;
            try {
                ResultKt.b(obj);
                this.f39545c.unregisterReceiver(idleEventBroadcastReceiver);
                return obj;
            } catch (Throwable th) {
                th = th;
                this.f39545c.unregisterReceiver(idleEventBroadcastReceiver);
                throw th;
            }
        }
        ResultKt.b(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.f39544b;
        final Function1 function1 = this.f39547f;
        IdleEventBroadcastReceiver idleEventBroadcastReceiver2 = new IdleEventBroadcastReceiver(new Function0<Unit>() { // from class: androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1

            /* JADX INFO: renamed from: androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.glance.session.IdleEventBroadcastReceiverKt$observeIdleEvents$2$idleReceiver$1$1", f = "IdleEventBroadcastReceiver.kt", l = {84}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f39550a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function1 f39551b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Function1 function1, Continuation continuation) {
                    super(2, continuation);
                    this.f39551b = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f39551b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f39550a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        Function1 function1 = this.f39551b;
                        this.f39550a = 1;
                        if (function1.invoke(this) == objF) {
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
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m347invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m347invoke() {
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(function1, null), 3, null);
            }
        });
        this.f39545c.registerReceiver(idleEventBroadcastReceiver2, IdleEventBroadcastReceiver.f39539b.a());
        try {
            idleEventBroadcastReceiver2.b(this.f39545c);
            Function1 function12 = this.f39546d;
            this.f39544b = idleEventBroadcastReceiver2;
            this.f39543a = 1;
            obj = function12.invoke(this);
            if (obj == objF) {
                return objF;
            }
            idleEventBroadcastReceiver = idleEventBroadcastReceiver2;
            this.f39545c.unregisterReceiver(idleEventBroadcastReceiver);
            return obj;
        } catch (Throwable th2) {
            th = th2;
            idleEventBroadcastReceiver = idleEventBroadcastReceiver2;
            this.f39545c.unregisterReceiver(idleEventBroadcastReceiver);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IdleEventBroadcastReceiverKt$observeIdleEvents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
