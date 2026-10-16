package com.superwall.sdk.game;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class GameControllerEvent {
    public static final Companion Companion = new Companion(null);
    private String controllerElement;
    private boolean directional;
    private String eventName;
    private double value;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f93557x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private double f93558y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GameControllerEvent> serializer() {
            return GameControllerEvent$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GameControllerEvent(int i3, String str, String str2, double d3, double d4, double d5, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if (62 != (i3 & 62)) {
            PluginExceptionsKt.b(i3, 62, GameControllerEvent$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.eventName = "game_controller_input";
        } else {
            this.eventName = str;
        }
        this.controllerElement = str2;
        this.value = d3;
        this.f93557x = d4;
        this.f93558y = d5;
        this.directional = z2;
    }

    public static /* synthetic */ GameControllerEvent copy$default(GameControllerEvent gameControllerEvent, String str, String str2, double d3, double d4, double d5, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gameControllerEvent.eventName;
        }
        if ((i3 & 2) != 0) {
            str2 = gameControllerEvent.controllerElement;
        }
        if ((i3 & 4) != 0) {
            d3 = gameControllerEvent.value;
        }
        if ((i3 & 8) != 0) {
            d4 = gameControllerEvent.f93557x;
        }
        if ((i3 & 16) != 0) {
            d5 = gameControllerEvent.f93558y;
        }
        if ((i3 & 32) != 0) {
            z2 = gameControllerEvent.directional;
        }
        boolean z3 = z2;
        double d6 = d5;
        double d7 = d4;
        return gameControllerEvent.copy(str, str2, d3, d7, d6, z3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(GameControllerEvent gameControllerEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(gameControllerEvent.eventName, "game_controller_input")) {
            compositeEncoder.y(serialDescriptor, 0, gameControllerEvent.eventName);
        }
        compositeEncoder.y(serialDescriptor, 1, gameControllerEvent.controllerElement);
        compositeEncoder.E(serialDescriptor, 2, gameControllerEvent.value);
        compositeEncoder.E(serialDescriptor, 3, gameControllerEvent.f93557x);
        compositeEncoder.E(serialDescriptor, 4, gameControllerEvent.f93558y);
        compositeEncoder.x(serialDescriptor, 5, gameControllerEvent.directional);
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.controllerElement;
    }

    public final double component3() {
        return this.value;
    }

    public final double component4() {
        return this.f93557x;
    }

    public final double component5() {
        return this.f93558y;
    }

    public final boolean component6() {
        return this.directional;
    }

    public final GameControllerEvent copy(String eventName, String controllerElement, double d3, double d4, double d5, boolean z2) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(controllerElement, "controllerElement");
        return new GameControllerEvent(eventName, controllerElement, d3, d4, d5, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameControllerEvent)) {
            return false;
        }
        GameControllerEvent gameControllerEvent = (GameControllerEvent) obj;
        return Intrinsics.areEqual(this.eventName, gameControllerEvent.eventName) && Intrinsics.areEqual(this.controllerElement, gameControllerEvent.controllerElement) && Double.compare(this.value, gameControllerEvent.value) == 0 && Double.compare(this.f93557x, gameControllerEvent.f93557x) == 0 && Double.compare(this.f93558y, gameControllerEvent.f93558y) == 0 && this.directional == gameControllerEvent.directional;
    }

    public final String getControllerElement() {
        return this.controllerElement;
    }

    public final boolean getDirectional() {
        return this.directional;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final double getValue() {
        return this.value;
    }

    public final double getX() {
        return this.f93557x;
    }

    public final double getY() {
        return this.f93558y;
    }

    public int hashCode() {
        return (((((((((this.eventName.hashCode() * 31) + this.controllerElement.hashCode()) * 31) + Double.hashCode(this.value)) * 31) + Double.hashCode(this.f93557x)) * 31) + Double.hashCode(this.f93558y)) * 31) + Boolean.hashCode(this.directional);
    }

    public final void setControllerElement(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.controllerElement = str;
    }

    public final void setDirectional(boolean z2) {
        this.directional = z2;
    }

    public final void setEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    public final void setValue(double d3) {
        this.value = d3;
    }

    public final void setX(double d3) {
        this.f93557x = d3;
    }

    public final void setY(double d3) {
        this.f93558y = d3;
    }

    public String toString() {
        return "GameControllerEvent(eventName=" + this.eventName + ", controllerElement=" + this.controllerElement + ", value=" + this.value + ", x=" + this.f93557x + ", y=" + this.f93558y + ", directional=" + this.directional + ")";
    }

    public GameControllerEvent(String eventName, String controllerElement, double d3, double d4, double d5, boolean z2) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(controllerElement, "controllerElement");
        this.eventName = eventName;
        this.controllerElement = controllerElement;
        this.value = d3;
        this.f93557x = d4;
        this.f93558y = d5;
        this.directional = z2;
    }

    public /* synthetic */ GameControllerEvent(String str, String str2, double d3, double d4, double d5, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "game_controller_input" : str, str2, d3, d4, d5, z2);
    }

    @SerialName
    public static /* synthetic */ void getControllerElement$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDirectional$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEventName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getValue$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getX$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getY$annotations() {
    }
}
