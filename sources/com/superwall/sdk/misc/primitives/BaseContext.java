package com.superwall.sdk.misc.primitives;

import com.google.common.cache.LSNn.vfptEEmYY;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.misc.primitives.BaseContext;
import com.superwall.sdk.misc.primitives.StoreContext;
import com.superwall.sdk.storage.Storable;
import com.superwall.sdk.storage.Storage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface BaseContext<S, Self extends BaseContext<S, Self>> extends StoreContext<S, Self> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static <S, Self extends BaseContext<S, Self>> void delete(BaseContext<S, Self> baseContext, Storable<?> storable) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            baseContext.getStorage().delete(storable);
        }

        public static <S, Self extends BaseContext<S, Self>> void effect(BaseContext<S, Self> baseContext, TypedAction<Self> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            StoreContext.DefaultImpls.effect(baseContext, action);
        }

        public static <S, Self extends BaseContext<S, Self>> StateFlow<S> getState(BaseContext<S, Self> baseContext) {
            return StoreContext.DefaultImpls.getState(baseContext);
        }

        public static <S, Self extends BaseContext<S, Self>> Object immediate(BaseContext<S, Self> baseContext, TypedAction<Self> typedAction, Continuation<? super Unit> continuation) {
            Object objImmediate = StoreContext.DefaultImpls.immediate(baseContext, typedAction, continuation);
            return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
        }

        public static <S, Self extends BaseContext<S, Self>> Object immediateUntil(BaseContext<S, Self> baseContext, TypedAction<Self> typedAction, Function1<? super S, Boolean> function1, Continuation<? super Unit> continuation) {
            Object objImmediateUntil = StoreContext.DefaultImpls.immediateUntil(baseContext, typedAction, function1, continuation);
            return objImmediateUntil == IntrinsicsKt.f() ? objImmediateUntil : Unit.f139807a;
        }

        public static <S, Self extends BaseContext<S, Self>, T> void persist(BaseContext<S, Self> baseContext, Storable<T> storable, T value) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            Intrinsics.checkNotNullParameter(value, "value");
            baseContext.getStorage().write(storable, value);
        }

        public static <S, Self extends BaseContext<S, Self>> void sideEffect(BaseContext<S, Self> baseContext, Function1<? super Continuation<? super Unit>, ? extends Object> what) {
            Intrinsics.checkNotNullParameter(what, "what");
            StoreContext.DefaultImpls.sideEffect(baseContext, what);
        }

        public static <S, Self extends BaseContext<S, Self>> void track(BaseContext<S, Self> baseContext, TrackableSuperwallEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BuildersKt__Builders_commonKt.d(baseContext.getScope(), null, null, new AnonymousClass1(baseContext, event, null), 3, null);
        }

        public static <S, Self extends BaseContext<S, Self>> void update(BaseContext<S, Self> baseContext, Reducer<S> reducer) {
            Intrinsics.checkNotNullParameter(reducer, "reducer");
            StoreContext.DefaultImpls.update(baseContext, reducer);
        }

        /* JADX INFO: renamed from: read-IoAF18A, reason: not valid java name */
        public static <S, Self extends BaseContext<S, Self>, T> Object m1276readIoAF18A(BaseContext<S, Self> baseContext, Storable<T> storable) {
            Intrinsics.checkNotNullParameter(storable, vfptEEmYY.VesZJ);
            Object obj = baseContext.getStorage().read(storable);
            if (obj != null) {
                return Result.b(obj);
            }
            Result.Companion companion = Result.f139772b;
            return Result.b(ResultKt.a(new IllegalArgumentException("Not found")));
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.BaseContext$track$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.BaseContext$track$1", f = "BaseContext.kt", l = {38}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TrackableSuperwallEvent $event;
        int label;
        final /* synthetic */ BaseContext<S, Self> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseContext<S, Self> baseContext, TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseContext;
            this.$event = trackableSuperwallEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$event, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> tracker = this.this$0.getTracker();
                TrackableSuperwallEvent trackableSuperwallEvent = this.$event;
                this.label = 1;
                if (tracker.invoke(trackableSuperwallEvent, this) == objF) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    void delete(Storable<?> storable);

    Storage getStorage();

    Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> getTracker();

    <T> void persist(Storable<T> storable, T t2);

    /* JADX INFO: renamed from: read-IoAF18A */
    <T> Object mo1262readIoAF18A(Storable<T> storable);

    void track(TrackableSuperwallEvent trackableSuperwallEvent);
}
