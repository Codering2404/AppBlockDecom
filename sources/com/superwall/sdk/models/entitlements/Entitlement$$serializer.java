package com.superwall.sdk.models.entitlements;

import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType;
import com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Date;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@Deprecated
public /* synthetic */ class Entitlement$$serializer implements GeneratedSerializer<Entitlement> {
    public static final Entitlement$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private Entitlement$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = Entitlement.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KSerializer<?> kSerializer = kSerializerArr[1];
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        KSerializer<?> kSerializer2 = kSerializerArr[3];
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(stringSerializer);
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializer, booleanSerializer, kSerializer2, kSerializerU, BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(dateSerializer), BuiltinSerializersKt.u(booleanSerializer), BuiltinSerializersKt.u(booleanSerializer), BuiltinSerializersKt.u(kSerializerArr[10]), BuiltinSerializersKt.u(kSerializerArr[11]), BuiltinSerializersKt.u(StoreSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Entitlement deserialize(Decoder decoder) {
        int i3;
        Entitlement.Type type;
        LatestPeriodType latestPeriodType;
        Boolean bool;
        Boolean bool2;
        Date date;
        LatestSubscriptionState latestSubscriptionState;
        Date date2;
        String str;
        Store store;
        Date date3;
        Set set;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = Entitlement.$childSerializers;
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(serialDescriptor, 0);
            type = (Entitlement.Type) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            boolean zC = compositeDecoderB.C(serialDescriptor, 2);
            Set set2 = (Set) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            String str3 = (String) compositeDecoderB.n(serialDescriptor, 4, StringSerializer.f142891a, null);
            DateSerializer dateSerializer = DateSerializer.INSTANCE;
            Date date4 = (Date) compositeDecoderB.n(serialDescriptor, 5, dateSerializer, null);
            Date date5 = (Date) compositeDecoderB.n(serialDescriptor, 6, dateSerializer, null);
            Date date6 = (Date) compositeDecoderB.n(serialDescriptor, 7, dateSerializer, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
            Boolean bool3 = (Boolean) compositeDecoderB.n(serialDescriptor, 8, booleanSerializer, null);
            Boolean bool4 = (Boolean) compositeDecoderB.n(serialDescriptor, 9, booleanSerializer, null);
            LatestSubscriptionState latestSubscriptionState2 = (LatestSubscriptionState) compositeDecoderB.n(serialDescriptor, 10, kSerializerArr[10], null);
            LatestPeriodType latestPeriodType2 = (LatestPeriodType) compositeDecoderB.n(serialDescriptor, 11, kSerializerArr[11], null);
            i3 = 8191;
            store = (Store) compositeDecoderB.n(serialDescriptor, 12, StoreSerializer.INSTANCE, null);
            str2 = strM;
            bool = bool4;
            date = date6;
            date2 = date5;
            date3 = date4;
            bool2 = bool3;
            str = str3;
            z2 = zC;
            latestSubscriptionState = latestSubscriptionState2;
            set = set2;
            latestPeriodType = latestPeriodType2;
        } else {
            boolean zC2 = false;
            LatestPeriodType latestPeriodType3 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            Date date7 = null;
            LatestSubscriptionState latestSubscriptionState3 = null;
            Date date8 = null;
            String str4 = null;
            String strM2 = null;
            int i4 = 10;
            int i5 = 3;
            boolean z6 = true;
            i3 = 0;
            type = null;
            Store store2 = null;
            Date date9 = null;
            Set set3 = null;
            while (z6) {
                KSerializer[] kSerializerArr2 = kSerializerArr;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z6 = false;
                        kSerializerArr = kSerializerArr2;
                        i5 = 3;
                        i4 = 10;
                        break;
                    case 0:
                        z4 = zC2;
                        strM2 = compositeDecoderB.m(serialDescriptor, 0);
                        i3 |= 1;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z4;
                        i5 = 3;
                        i4 = 10;
                        break;
                    case 1:
                        z4 = zC2;
                        type = (Entitlement.Type) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr2[1], type);
                        i3 |= 2;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z4;
                        i5 = 3;
                        i4 = 10;
                        break;
                    case 2:
                        i3 |= 4;
                        zC2 = compositeDecoderB.C(serialDescriptor, 2);
                        kSerializerArr = kSerializerArr2;
                        i4 = 10;
                        break;
                    case 3:
                        z5 = zC2;
                        set3 = (Set) compositeDecoderB.y(serialDescriptor, i5, kSerializerArr2[i5], set3);
                        i3 |= 8;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 4:
                        z5 = zC2;
                        str4 = (String) compositeDecoderB.n(serialDescriptor, 4, StringSerializer.f142891a, str4);
                        i3 |= 16;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 5:
                        z5 = zC2;
                        date9 = (Date) compositeDecoderB.n(serialDescriptor, 5, DateSerializer.INSTANCE, date9);
                        i3 |= 32;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 6:
                        z5 = zC2;
                        date8 = (Date) compositeDecoderB.n(serialDescriptor, 6, DateSerializer.INSTANCE, date8);
                        i3 |= 64;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 7:
                        z5 = zC2;
                        date7 = (Date) compositeDecoderB.n(serialDescriptor, 7, DateSerializer.INSTANCE, date7);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 8:
                        z5 = zC2;
                        bool6 = (Boolean) compositeDecoderB.n(serialDescriptor, 8, BooleanSerializer.f142767a, bool6);
                        i3 |= Function.MAX_NARGS;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 9:
                        z5 = zC2;
                        bool5 = (Boolean) compositeDecoderB.n(serialDescriptor, 9, BooleanSerializer.f142767a, bool5);
                        i3 |= 512;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z5;
                        i4 = 10;
                        break;
                    case 10:
                        z3 = zC2;
                        latestSubscriptionState3 = (LatestSubscriptionState) compositeDecoderB.n(serialDescriptor, i4, kSerializerArr2[i4], latestSubscriptionState3);
                        i3 |= 1024;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z3;
                        break;
                    case 11:
                        z3 = zC2;
                        latestPeriodType3 = (LatestPeriodType) compositeDecoderB.n(serialDescriptor, 11, kSerializerArr2[11], latestPeriodType3);
                        i3 |= 2048;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z3;
                        break;
                    case 12:
                        z3 = zC2;
                        store2 = (Store) compositeDecoderB.n(serialDescriptor, 12, StoreSerializer.INSTANCE, store2);
                        i3 |= 4096;
                        kSerializerArr = kSerializerArr2;
                        zC2 = z3;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            latestPeriodType = latestPeriodType3;
            bool = bool5;
            bool2 = bool6;
            date = date7;
            latestSubscriptionState = latestSubscriptionState3;
            date2 = date8;
            str = str4;
            store = store2;
            date3 = date9;
            set = set3;
            str2 = strM2;
            z2 = zC2;
        }
        Entitlement.Type type2 = type;
        int i6 = i3;
        compositeDecoderB.c(serialDescriptor);
        return new Entitlement(i6, str2, type2, z2, set, str, date3, date2, date, bool2, bool, latestSubscriptionState, latestPeriodType, store, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Entitlement value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        Entitlement.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        Entitlement$$serializer entitlement$$serializer = new Entitlement$$serializer();
        INSTANCE = entitlement$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.entitlements.Entitlement", entitlement$$serializer, 13);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p("type", true);
        pluginGeneratedSerialDescriptor.p("isActive", true);
        pluginGeneratedSerialDescriptor.p("productIds", true);
        pluginGeneratedSerialDescriptor.p("latestProductId", true);
        pluginGeneratedSerialDescriptor.p("startsAt", true);
        pluginGeneratedSerialDescriptor.p("renewedAt", true);
        pluginGeneratedSerialDescriptor.p("expiresAt", true);
        pluginGeneratedSerialDescriptor.p("isLifetime", true);
        pluginGeneratedSerialDescriptor.p(KrzujOtzIk.EKCuXsKBooujGfA, true);
        pluginGeneratedSerialDescriptor.p(ServerProtocol.DIALOG_PARAM_STATE, true);
        pluginGeneratedSerialDescriptor.p("offerType", true);
        pluginGeneratedSerialDescriptor.p(ProductResponseJsonKeys.STORE, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
