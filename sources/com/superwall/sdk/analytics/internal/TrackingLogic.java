package com.superwall.sdk.analytics.internal;

import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.analytics.superwall.SuperwallEvents;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.paywall.PaywallURL;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

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
public abstract class TrackingLogic {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SuperwallEvents.values().length];
                try {
                    iArr[SuperwallEvents.TransactionAbandon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SuperwallEvents.TransactionFail.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SuperwallEvents.SurveyResponse.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SuperwallEvents.PaywallDecline.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SuperwallEvents.CustomPlacement.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object clean(Object obj) {
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof List)) {
                if ((obj instanceof Map) || (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Boolean)) {
                    return obj;
                }
                if (obj instanceof JsonElement) {
                    return ConvertersKt.convertFromJsonElement((JsonElement) obj);
                }
                try {
                    Json.Default r12 = Json.f142959d;
                    r12.b(SerializersKt.a(r12.a(), Reflection.b(Object.class)), obj);
                    return obj;
                } catch (SerializationException unused) {
                    if (obj instanceof LocalDateTime) {
                        return Long.valueOf(((LocalDateTime) obj).q(ZoneOffset.f146222i).v().S());
                    }
                    if (obj instanceof URI) {
                        return ((URI) obj).toString();
                    }
                    if (obj instanceof PaywallURL) {
                        return PaywallURL.m1301toStringimpl(((PaywallURL) obj).m1302unboximpl());
                    }
                }
            }
            return null;
        }

        public final ImplicitTriggerOutcome canTriggerPaywall(Trackable event, Set<String> triggers, PaywallView paywallView) {
            PaywallInfo info;
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(triggers, "triggers");
            if ((event instanceof TrackableSuperwallEvent) && Intrinsics.areEqual(((TrackableSuperwallEvent) event).getSuperwallPlacement().getRawName(), SuperwallEvents.DeepLink.getRawName())) {
                return ImplicitTriggerOutcome.DeepLinkTrigger.INSTANCE;
            }
            if (!triggers.contains(event.getRawName())) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! canTriggerPaywall: triggers.contains(event.rawName) " + event.getRawName() + " " + triggers, (Map) null, (Throwable) null, 24, (Object) null);
                return ImplicitTriggerOutcome.DontTriggerPaywall.INSTANCE;
            }
            String presentedByEventWithName = (paywallView == null || (info = paywallView.getInfo()) == null) ? null : info.getPresentedByEventWithName();
            if (presentedByEventWithName != null && (event instanceof TrackableSuperwallEvent)) {
                String rawName = ((TrackableSuperwallEvent) event).getSuperwallPlacement().getBackingEvent().getRawName();
                if (SetsKt.setOf((Object[]) new String[]{SuperwallEvents.TransactionAbandon.getRawName(), SuperwallEvents.TransactionFail.getRawName(), SuperwallEvents.PaywallDecline.getRawName(), SuperwallEvents.CustomPlacement.getRawName()}).contains(presentedByEventWithName) && Intrinsics.areEqual(presentedByEventWithName, rawName)) {
                    Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! canTriggerPaywall: Blocking duplicate exit offer event: " + rawName, (Map) null, (Throwable) null, 24, (Object) null);
                    return ImplicitTriggerOutcome.DontTriggerPaywall.INSTANCE;
                }
            }
            if (event instanceof TrackableSuperwallEvent) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[((TrackableSuperwallEvent) event).getSuperwallPlacement().getBackingEvent().ordinal()];
                return (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) ? ImplicitTriggerOutcome.ClosePaywallThenTriggerPaywall.INSTANCE : ImplicitTriggerOutcome.TriggerPaywall.INSTANCE;
            }
            if (paywallView == null) {
                return ImplicitTriggerOutcome.TriggerPaywall.INSTANCE;
            }
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! canTriggerPaywall: paywallViewController != null", (Map) null, (Throwable) null, 24, (Object) null);
            return ImplicitTriggerOutcome.DontTriggerPaywall.INSTANCE;
        }

        public final void checkNotSuperwallEvent(String event) throws Exception {
            SuperwallEvents superwallEvents;
            Intrinsics.checkNotNullParameter(event, "event");
            SuperwallEvents[] superwallEventsArrValues = SuperwallEvents.values();
            int length = superwallEventsArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    superwallEvents = null;
                    break;
                }
                superwallEvents = superwallEventsArrValues[i3];
                if (Intrinsics.areEqual(superwallEvents.getRawName(), event)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (superwallEvents != null) {
                throw new Exception("Do not track an event with the same name as a SuperwallEvent");
            }
        }

        public final boolean isNotDisabledVerboseEvent(Trackable event, Boolean bool, boolean z2) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (bool != null) {
                boolean zBooleanValue = bool.booleanValue();
                if (z2) {
                    return true;
                }
                if (event instanceof InternalSuperwallEvent.PresentationRequest) {
                    return !zBooleanValue;
                }
                InternalSuperwallEvent.PaywallLoad paywallLoad = event instanceof InternalSuperwallEvent.PaywallLoad ? (InternalSuperwallEvent.PaywallLoad) event : null;
                if (paywallLoad != null) {
                    InternalSuperwallEvent.PaywallLoad.State state = paywallLoad.getState();
                    return (((state instanceof InternalSuperwallEvent.PaywallLoad.State.Start) || (state instanceof InternalSuperwallEvent.PaywallLoad.State.Complete)) && zBooleanValue) ? false : true;
                }
                if (event instanceof InternalSuperwallEvent.ShimmerLoad) {
                    return !zBooleanValue;
                }
                InternalSuperwallEvent.PaywallProductsLoad paywallProductsLoad = event instanceof InternalSuperwallEvent.PaywallProductsLoad ? (InternalSuperwallEvent.PaywallProductsLoad) event : null;
                if (paywallProductsLoad != null) {
                    InternalSuperwallEvent.PaywallProductsLoad.State state2 = paywallProductsLoad.getState();
                    return (((state2 instanceof InternalSuperwallEvent.PaywallProductsLoad.State.Start) || (state2 instanceof InternalSuperwallEvent.PaywallProductsLoad.State.Complete)) && zBooleanValue) ? false : true;
                }
                InternalSuperwallEvent.PaywallWebviewLoad paywallWebviewLoad = event instanceof InternalSuperwallEvent.PaywallWebviewLoad ? (InternalSuperwallEvent.PaywallWebviewLoad) event : null;
                if (paywallWebviewLoad != null) {
                    InternalSuperwallEvent.PaywallWebviewLoad.State state3 = paywallWebviewLoad.getState();
                    return (((state3 instanceof InternalSuperwallEvent.PaywallWebviewLoad.State.Start) || (state3 instanceof InternalSuperwallEvent.PaywallWebviewLoad.State.Complete)) && zBooleanValue) ? false : true;
                }
            }
            return true;
        }

        public final Object processParameters(Trackable trackable, String str, Continuation<? super TrackingParameters> continuation) {
            return BuildersKt.g(Dispatchers.b(), new TrackingLogic$Companion$processParameters$2(trackable, str, null), continuation);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class ImplicitTriggerOutcome {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ClosePaywallThenTriggerPaywall extends ImplicitTriggerOutcome {
            public static final ClosePaywallThenTriggerPaywall INSTANCE = new ClosePaywallThenTriggerPaywall();

            private ClosePaywallThenTriggerPaywall() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DeepLinkTrigger extends ImplicitTriggerOutcome {
            public static final DeepLinkTrigger INSTANCE = new DeepLinkTrigger();

            private DeepLinkTrigger() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DisallowedEventAsTrigger extends ImplicitTriggerOutcome {
            public static final DisallowedEventAsTrigger INSTANCE = new DisallowedEventAsTrigger();

            private DisallowedEventAsTrigger() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DontTriggerPaywall extends ImplicitTriggerOutcome {
            public static final DontTriggerPaywall INSTANCE = new DontTriggerPaywall();

            private DontTriggerPaywall() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TriggerPaywall extends ImplicitTriggerOutcome {
            public static final TriggerPaywall INSTANCE = new TriggerPaywall();

            private TriggerPaywall() {
                super(null);
            }
        }

        public /* synthetic */ ImplicitTriggerOutcome(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ImplicitTriggerOutcome() {
        }
    }

    public /* synthetic */ TrackingLogic(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TrackingLogic() {
    }
}
