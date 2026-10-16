package cz.mobilesoft.coreblock.rest.request;

import android.content.Context;
import android.os.Build;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RegisterDeviceRequest {
    public static final int $stable = 8;

    @SerializedName("brand")
    private final String brand;

    @SerializedName("currentTime")
    private final Date currentTime;

    @SerializedName(DeviceRequestsHelper.DEVICE_INFO_DEVICE)
    private final String device;

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName("deviceLanguage")
    private final String deviceLanguage;

    @SerializedName("devicePlatform")
    private final String devicePlatform;

    @SerializedName("deviceType")
    private final String deviceType;

    @SerializedName("fcmToken")
    private final String fcmToken;

    @SerializedName("manufacturer")
    private final String manufacturer;

    @SerializedName(DeviceRequestsHelper.DEVICE_INFO_MODEL)
    private final String model;

    @SerializedName(AppLovinEventTypes.USER_VIEWED_PRODUCT)
    private final String product;

    public RegisterDeviceRequest(String brand, Date currentTime, String device, String deviceId, String deviceLanguage, String devicePlatform, String deviceType, String manufacturer, String model, String product, String str) {
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(devicePlatform, "devicePlatform");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(product, "product");
        this.brand = brand;
        this.currentTime = currentTime;
        this.device = device;
        this.deviceId = deviceId;
        this.deviceLanguage = deviceLanguage;
        this.devicePlatform = devicePlatform;
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.model = model;
        this.product = product;
        this.fcmToken = str;
    }

    public static /* synthetic */ RegisterDeviceRequest copy$default(RegisterDeviceRequest registerDeviceRequest, String str, Date date, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = registerDeviceRequest.brand;
        }
        if ((i3 & 2) != 0) {
            date = registerDeviceRequest.currentTime;
        }
        if ((i3 & 4) != 0) {
            str2 = registerDeviceRequest.device;
        }
        if ((i3 & 8) != 0) {
            str3 = registerDeviceRequest.deviceId;
        }
        if ((i3 & 16) != 0) {
            str4 = registerDeviceRequest.deviceLanguage;
        }
        if ((i3 & 32) != 0) {
            str5 = registerDeviceRequest.devicePlatform;
        }
        if ((i3 & 64) != 0) {
            str6 = registerDeviceRequest.deviceType;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str7 = registerDeviceRequest.manufacturer;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            str8 = registerDeviceRequest.model;
        }
        if ((i3 & 512) != 0) {
            str9 = registerDeviceRequest.product;
        }
        if ((i3 & 1024) != 0) {
            str10 = registerDeviceRequest.fcmToken;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        String str17 = str4;
        String str18 = str2;
        return registerDeviceRequest.copy(str, date, str18, str3, str17, str15, str16, str13, str14, str11, str12);
    }

    public final String component1() {
        return this.brand;
    }

    public final String component10() {
        return this.product;
    }

    public final String component11() {
        return this.fcmToken;
    }

    public final Date component2() {
        return this.currentTime;
    }

    public final String component3() {
        return this.device;
    }

    public final String component4() {
        return this.deviceId;
    }

    public final String component5() {
        return this.deviceLanguage;
    }

    public final String component6() {
        return this.devicePlatform;
    }

    public final String component7() {
        return this.deviceType;
    }

    public final String component8() {
        return this.manufacturer;
    }

    public final String component9() {
        return this.model;
    }

    public final RegisterDeviceRequest copy(String brand, Date currentTime, String device, String deviceId, String deviceLanguage, String devicePlatform, String deviceType, String manufacturer, String model, String product, String str) {
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(devicePlatform, "devicePlatform");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(product, "product");
        return new RegisterDeviceRequest(brand, currentTime, device, deviceId, deviceLanguage, devicePlatform, deviceType, manufacturer, model, product, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterDeviceRequest)) {
            return false;
        }
        RegisterDeviceRequest registerDeviceRequest = (RegisterDeviceRequest) obj;
        return Intrinsics.areEqual(this.brand, registerDeviceRequest.brand) && Intrinsics.areEqual(this.currentTime, registerDeviceRequest.currentTime) && Intrinsics.areEqual(this.device, registerDeviceRequest.device) && Intrinsics.areEqual(this.deviceId, registerDeviceRequest.deviceId) && Intrinsics.areEqual(this.deviceLanguage, registerDeviceRequest.deviceLanguage) && Intrinsics.areEqual(this.devicePlatform, registerDeviceRequest.devicePlatform) && Intrinsics.areEqual(this.deviceType, registerDeviceRequest.deviceType) && Intrinsics.areEqual(this.manufacturer, registerDeviceRequest.manufacturer) && Intrinsics.areEqual(this.model, registerDeviceRequest.model) && Intrinsics.areEqual(this.product, registerDeviceRequest.product) && Intrinsics.areEqual(this.fcmToken, registerDeviceRequest.fcmToken);
    }

    public final String getBrand() {
        return this.brand;
    }

    public final Date getCurrentTime() {
        return this.currentTime;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProduct() {
        return this.product;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.brand.hashCode() * 31) + this.currentTime.hashCode()) * 31) + this.device.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.deviceLanguage.hashCode()) * 31) + this.devicePlatform.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.model.hashCode()) * 31) + this.product.hashCode()) * 31;
        String str = this.fcmToken;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RegisterDeviceRequest(brand=" + this.brand + ", currentTime=" + this.currentTime + ", device=" + this.device + ", deviceId=" + this.deviceId + ", deviceLanguage=" + this.deviceLanguage + ", devicePlatform=" + this.devicePlatform + ", deviceType=" + this.deviceType + ", manufacturer=" + this.manufacturer + ", model=" + this.model + ", product=" + this.product + ", fcmToken=" + this.fcmToken + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RegisterDeviceRequest(String str, Date date, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        if ((i3 & 1) != 0) {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            str11 = BRAND;
        } else {
            str11 = str;
        }
        Date date2 = (i3 & 2) != 0 ? new Date() : date;
        if ((i3 & 4) != 0) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            str12 = DEVICE;
        } else {
            str12 = str2;
        }
        if ((i3 & 16) != 0) {
            String languageTag = Locale.getDefault().toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
            str13 = languageTag;
        } else {
            str13 = str4;
        }
        String str18 = (i3 & 32) != 0 ? "ANDROID" : str5;
        if ((i3 & 64) != 0) {
            RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
            Context contextG = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
            str14 = runnabilityHelper.L(contextG) ? "TABLET" : "PHONE";
        } else {
            str14 = str6;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            str15 = MANUFACTURER;
        } else {
            str15 = str7;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            str16 = MODEL;
        } else {
            str16 = str8;
        }
        if ((i3 & 512) != 0) {
            String PRODUCT = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
            str17 = PRODUCT;
        } else {
            str17 = str9;
        }
        this(str11, date2, str12, str3, str13, str18, str14, str15, str16, str17, str10);
    }
}
