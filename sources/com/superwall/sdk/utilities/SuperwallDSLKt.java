package com.superwall.sdk.utilities;

import android.app.Application;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.options.PaywallOptions;
import com.superwall.sdk.config.options.SuperwallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class SuperwallDSLKt {
    @SuperwallDSL
    public static final Superwall configureSuperwall(Application application, String apiKey, Function1<? super SuperwallBuilder, Unit> configure) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(configure, "configure");
        SuperwallBuilder superwallBuilder = new SuperwallBuilder();
        configure.invoke(superwallBuilder);
        Superwall.Companion companion = Superwall.Companion;
        companion.configure(application, apiKey, superwallBuilder.getPurchaseController(), superwallBuilder.getOptions(), superwallBuilder.getActivityProvider(), superwallBuilder.getCompletion());
        return companion.getInstance();
    }

    @SuperwallDSL
    public static final void logging(SuperwallOptions superwallOptions, Function1<? super SuperwallOptions.Logging, Unit> action) {
        Intrinsics.checkNotNullParameter(superwallOptions, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        SuperwallOptions.Logging logging = superwallOptions.getLogging();
        action.invoke(logging);
        superwallOptions.setLogging(logging);
    }

    @SuperwallDSL
    public static final void paywalls(SuperwallOptions superwallOptions, Function1<? super PaywallOptions, Unit> action) {
        Intrinsics.checkNotNullParameter(superwallOptions, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        PaywallOptions paywalls = superwallOptions.getPaywalls();
        action.invoke(paywalls);
        superwallOptions.setPaywalls(paywalls);
    }
}
