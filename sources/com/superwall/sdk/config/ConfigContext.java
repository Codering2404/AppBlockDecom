package com.superwall.sdk.config;

import android.content.Context;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.identity.IdentityManager;
import com.superwall.sdk.misc.primitives.BaseContext;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.network.SuperwallAPI;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.storage.Storable;
import com.superwall.sdk.store.Entitlements;
import com.superwall.sdk.store.StoreManager;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
public interface ConfigContext extends BaseContext<ConfigState, ConfigContext> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static void delete(ConfigContext configContext, Storable<?> storable) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            BaseContext.DefaultImpls.delete(configContext, storable);
        }

        public static void effect(ConfigContext configContext, TypedAction<ConfigContext> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            BaseContext.DefaultImpls.effect(configContext, action);
        }

        public static StateFlow<ConfigState> getState(ConfigContext configContext) {
            return BaseContext.DefaultImpls.getState(configContext);
        }

        public static Object immediate(ConfigContext configContext, TypedAction<ConfigContext> typedAction, Continuation<? super Unit> continuation) {
            Object objImmediate = BaseContext.DefaultImpls.immediate(configContext, typedAction, continuation);
            return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
        }

        public static Object immediateUntil(ConfigContext configContext, TypedAction<ConfigContext> typedAction, Function1<? super ConfigState, Boolean> function1, Continuation<? super Unit> continuation) {
            Object objImmediateUntil = BaseContext.DefaultImpls.immediateUntil(configContext, typedAction, function1, continuation);
            return objImmediateUntil == IntrinsicsKt.f() ? objImmediateUntil : Unit.f139807a;
        }

        public static <T> void persist(ConfigContext configContext, Storable<T> storable, T value) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            Intrinsics.checkNotNullParameter(value, "value");
            BaseContext.DefaultImpls.persist(configContext, storable, value);
        }

        /* JADX INFO: renamed from: read-IoAF18A, reason: not valid java name */
        public static <T> Object m1261readIoAF18A(ConfigContext configContext, Storable<T> storable) {
            Intrinsics.checkNotNullParameter(storable, "storable");
            return BaseContext.DefaultImpls.m1276readIoAF18A(configContext, storable);
        }

        public static void sideEffect(ConfigContext configContext, Function1<? super Continuation<? super Unit>, ? extends Object> what) {
            Intrinsics.checkNotNullParameter(what, "what");
            BaseContext.DefaultImpls.sideEffect(configContext, what);
        }

        public static void track(ConfigContext configContext, TrackableSuperwallEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BaseContext.DefaultImpls.track(configContext, event);
        }

        public static void update(ConfigContext configContext, Reducer<ConfigState> reducer) {
            Intrinsics.checkNotNullParameter(reducer, "reducer");
            BaseContext.DefaultImpls.update(configContext, reducer);
        }
    }

    Function3<Config, Boolean, Continuation<? super Unit>, Object> getActivateTestMode();

    Assignments getAssignments();

    Function1<Continuation<? super Unit>, Object> getAwaitUtilNetwork();

    Context getContext();

    DeviceHelper getDeviceHelper();

    Entitlements getEntitlements();

    ConfigManager.Factory getFactory();

    Function0<IdentityManager> getIdentityManager();

    SuperwallAPI getNetwork();

    SuperwallOptions getOptions();

    PaywallManager getPaywallManager();

    PaywallPreload getPaywallPreload();

    Function1<SubscriptionStatus, Unit> getSetSubscriptionStatus();

    StoreManager getStoreManager();

    TestMode getTestMode();

    Function0<WebPaywallRedeemer> getWebPaywallRedeemer();

    void setTriggers(Map<String, Trigger> map);
}
