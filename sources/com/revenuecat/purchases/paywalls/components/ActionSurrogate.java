package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
final class ActionSurrogate {
    public static final Companion Companion = new Companion(null);
    private final DestinationSurrogate destination;
    private final ButtonComponent.Destination.Sheet sheet;
    private final ActionTypeSurrogate type;
    private final UrlSurrogate url;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ActionSurrogate> serializer() {
            return ActionSurrogate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DestinationSurrogate.values().length];
            try {
                iArr[DestinationSurrogate.customer_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DestinationSurrogate.privacy_policy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DestinationSurrogate.terms.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DestinationSurrogate.url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DestinationSurrogate.sheet.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DestinationSurrogate.unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionTypeSurrogate.values().length];
            try {
                iArr2[ActionTypeSurrogate.unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ActionTypeSurrogate.restore_purchases.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ActionTypeSurrogate.navigate_back.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ActionTypeSurrogate.workflow.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ActionTypeSurrogate.navigate_to.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Deprecated
    public /* synthetic */ ActionSurrogate(int i3, ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ActionSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.type = actionTypeSurrogate;
        if ((i3 & 2) == 0) {
            this.destination = null;
        } else {
            this.destination = destinationSurrogate;
        }
        if ((i3 & 4) == 0) {
            this.url = null;
        } else {
            this.url = urlSurrogate;
        }
        if ((i3 & 8) == 0) {
            this.sheet = null;
        } else {
            this.sheet = sheet;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ActionSurrogate actionSurrogate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, ActionTypeSurrogateDeserializer.INSTANCE, actionSurrogate.type);
        if (compositeEncoder.z(serialDescriptor, 1) || actionSurrogate.destination != null) {
            compositeEncoder.i(serialDescriptor, 1, DestinationSurrogateDeserializer.INSTANCE, actionSurrogate.destination);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || actionSurrogate.url != null) {
            compositeEncoder.i(serialDescriptor, 2, UrlSurrogate$$serializer.INSTANCE, actionSurrogate.url);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && actionSurrogate.sheet == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, actionSurrogate.sheet);
    }

    public final DestinationSurrogate getDestination() {
        return this.destination;
    }

    public final ButtonComponent.Destination.Sheet getSheet() {
        return this.sheet;
    }

    public final ActionTypeSurrogate getType() {
        return this.type;
    }

    public final UrlSurrogate getUrl() {
        return this.url;
    }

    public final ButtonComponent.Action toAction() {
        ButtonComponent.Destination privacyPolicy;
        int i3 = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
        if (i3 == 1) {
            return ButtonComponent.Action.Unknown.INSTANCE;
        }
        if (i3 == 2) {
            return ButtonComponent.Action.RestorePurchases.INSTANCE;
        }
        if (i3 == 3) {
            return ButtonComponent.Action.NavigateBack.INSTANCE;
        }
        if (i3 == 4) {
            return ButtonComponent.Action.WorkflowTrigger.INSTANCE;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        DestinationSurrogate destinationSurrogate = this.destination;
        switch (destinationSurrogate == null ? -1 : WhenMappings.$EnumSwitchMapping$0[destinationSurrogate.ordinal()]) {
            case -1:
                throw new IllegalStateException("`destination` cannot be null when `action` is `navigate_to`.");
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                privacyPolicy = ButtonComponent.Destination.CustomerCenter.INSTANCE;
                break;
            case 2:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `privacy_policy`.");
                }
                privacyPolicy = new ButtonComponent.Destination.PrivacyPolicy(this.url.m609getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 3:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `terms`.");
                }
                privacyPolicy = new ButtonComponent.Destination.Terms(this.url.m609getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 4:
                if (this.url == null) {
                    throw new IllegalStateException("`url` cannot be null when `destination` is `url`.");
                }
                privacyPolicy = new ButtonComponent.Destination.Url(this.url.m609getUrl_lidz7Tp4o(), this.url.getMethod(), null);
                break;
                break;
            case 5:
                privacyPolicy = this.sheet;
                if (privacyPolicy == null) {
                    throw new IllegalStateException("`sheet` cannot be null when `destination` is `sheet`.");
                }
                break;
            case 6:
                privacyPolicy = ButtonComponent.Destination.Unknown.INSTANCE;
                break;
        }
        return new ButtonComponent.Action.NavigateTo(privacyPolicy);
    }

    public ActionSurrogate(ActionTypeSurrogate type, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.destination = destinationSurrogate;
        this.url = urlSurrogate;
        this.sheet = sheet;
    }

    public /* synthetic */ ActionSurrogate(ActionTypeSurrogate actionTypeSurrogate, DestinationSurrogate destinationSurrogate, UrlSurrogate urlSurrogate, ButtonComponent.Destination.Sheet sheet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionTypeSurrogate, (i3 & 2) != 0 ? null : destinationSurrogate, (i3 & 4) != 0 ? null : urlSurrogate, (i3 & 8) != 0 ? null : sheet);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0087  */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$Sheet] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ActionSurrogate(com.revenuecat.purchases.paywalls.components.ButtonComponent.Action r9) {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.ActionSurrogate.<init>(com.revenuecat.purchases.paywalls.components.ButtonComponent$Action):void");
    }
}
