package com.superwall.sdk.identity;

import com.superwall.sdk.SdkContext;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.misc.primitives.BaseContext;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.storage.Storable;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public interface IdentityContext extends BaseContext<IdentityState, IdentityContext> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static void delete(IdentityContext identityContext, Storable<?> storable) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            BaseContext.DefaultImpls.delete(identityContext, storable);
        }

        public static void effect(IdentityContext identityContext, TypedAction<IdentityContext> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            BaseContext.DefaultImpls.effect(identityContext, action);
        }

        public static StateFlow<IdentityState> getState(IdentityContext identityContext) {
            return BaseContext.DefaultImpls.getState(identityContext);
        }

        public static Object immediate(IdentityContext identityContext, TypedAction<IdentityContext> typedAction, Continuation<? super Unit> continuation) {
            Object objImmediate = BaseContext.DefaultImpls.immediate(identityContext, typedAction, continuation);
            return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
        }

        public static Object immediateUntil(IdentityContext identityContext, TypedAction<IdentityContext> typedAction, Function1<? super IdentityState, Boolean> function1, Continuation<? super Unit> continuation) {
            Object objImmediateUntil = BaseContext.DefaultImpls.immediateUntil(identityContext, typedAction, function1, continuation);
            return objImmediateUntil == IntrinsicsKt.f() ? objImmediateUntil : Unit.f139807a;
        }

        public static <T> void persist(IdentityContext identityContext, Storable<T> storable, T value) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            Intrinsics.checkNotNullParameter(value, "value");
            BaseContext.DefaultImpls.persist(identityContext, storable, value);
        }

        /* JADX INFO: renamed from: read-IoAF18A, reason: not valid java name */
        public static <T> Object m1273readIoAF18A(IdentityContext identityContext, Storable<T> storable) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            return BaseContext.DefaultImpls.m1276readIoAF18A(identityContext, storable);
        }

        public static void sideEffect(IdentityContext identityContext, Function1<? super Continuation<? super Unit>, ? extends Object> what) {
            Intrinsics.checkNotNullParameter(what, "what");
            BaseContext.DefaultImpls.sideEffect(identityContext, what);
        }

        public static void track(IdentityContext identityContext, TrackableSuperwallEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BaseContext.DefaultImpls.track(identityContext, event);
        }

        public static void update(IdentityContext identityContext, Reducer<IdentityState> reducer) {
            Intrinsics.checkNotNullParameter(reducer, "reducer");
            BaseContext.DefaultImpls.update(identityContext, reducer);
        }
    }

    Function0<Unit> getCompleteReset();

    Function1<Map<String, ? extends Object>, Unit> getNotifyUserChange();

    SdkContext getSdkContext();

    Function0<WebPaywallRedeemer> getWebPaywallRedeemer();
}
