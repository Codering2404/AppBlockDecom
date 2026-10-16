package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import android.net.Uri;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
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
public final class TemplateConfigurationFactory {
    public static final int $stable = 0;
    public static final TemplateConfigurationFactory INSTANCE = new TemplateConfigurationFactory();

    private TemplateConfigurationFactory() {
    }

    private final Uri getUriFromImage(PaywallData paywallData, String str) {
        if (str != null) {
            return Uri.parse(paywallData.getAssetBaseURL().toString()).buildUpon().path(str).build();
        }
        return null;
    }

    /* JADX INFO: renamed from: create-hUnOzRk, reason: not valid java name */
    public final Object m1100createhUnOzRk(VariableDataProvider variableDataProvider, PaywallMode mode, PaywallData paywallData, List<Package> availablePackages, PaywallTemplate template, String str) {
        Map mapEmptyMap;
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(paywallData, "paywallData");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        Intrinsics.checkNotNullParameter(template, "template");
        PaywallData.Configuration.Images images = paywallData.getConfig().getImages();
        TemplateConfiguration.Images images2 = new TemplateConfiguration.Images(getUriFromImage(paywallData, images.getIcon()), getUriFromImage(paywallData, images.getBackground()), getUriFromImage(paywallData, images.getHeader()));
        Map<String, PaywallData.Configuration.Images> imagesByTier = paywallData.getConfig().getImagesByTier();
        if (imagesByTier != null) {
            mapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(imagesByTier.size()));
            Iterator<T> it = imagesByTier.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                TemplateConfigurationFactory templateConfigurationFactory = INSTANCE;
                mapEmptyMap.put(key, new TemplateConfiguration.Images(templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getIcon()), templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getBackground()), templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getHeader())));
            }
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map map = mapEmptyMap;
        Object objM1067createPackageConfigurationbMdYcbs = PackageConfigurationFactory.INSTANCE.m1067createPackageConfigurationbMdYcbs(variableDataProvider, availablePackages, paywallData.getConfig().getPackageIds(), paywallData.getConfig().getDefaultPackage(), template.getConfigurationType(), paywallData, str);
        Throwable thE = Result.e(objM1067createPackageConfigurationbMdYcbs);
        if (thE != null) {
            return Result.b(ResultKt.a(thE));
        }
        Pair pair = (Pair) objM1067createPackageConfigurationbMdYcbs;
        return Result.b(new TemplateConfiguration(template, mode, (TemplateConfiguration.PackageConfiguration) pair.b(), paywallData.getConfig(), images2, map, paywallData.getConfig().getColors(), (Locale) pair.a()));
    }
}
