package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class MockResourceProvider implements ResourceProvider {
    public static final int $stable = 8;
    private final List<String> assetPaths;
    private final Map<String, DownloadedFontFamily> downloadedFilesByUrl;
    private final Map<Integer, FontFamily> fontFamiliesByXmlResourceId;
    private final AssetManager mockAssetManager;
    private final Map<String, Map<String, Integer>> resourceIds;

    public MockResourceProvider() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getApplicationName() {
        return "Mock Paywall";
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public Map<String, String> getAssetFontPaths(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        List<String> list = names;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            String str = (String) obj;
            if (!StringsKt.E(str, ".ttf", false, 2, null)) {
                str = str + ".ttf";
            }
            linkedHashMap.put(obj, "fonts/" + str);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (this.assetPaths.contains(entry.getValue())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public AssetManager getAssetManager() {
        return this.mockAssetManager;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.downloadedFilesByUrl.get(fontInfo.getUrl());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public Locale getLocale() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public int getResourceIdentifier(String name, String type) {
        Integer num;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Map<String, Integer> map = this.resourceIds.get(type);
        if (map == null || (num = map.get(name)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getString(int i3, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        if (i3 == R.string.restore_purchases) {
            return "Restore purchases";
        }
        if (i3 == R.string.annual) {
            return "Annual";
        }
        if (i3 == R.string.semester) {
            return "6 month";
        }
        if (i3 == R.string.quarter) {
            return "3 month";
        }
        if (i3 == R.string.bimonthly) {
            return "2 month";
        }
        if (i3 == R.string.monthly) {
            return "Monthly";
        }
        if (i3 == R.string.weekly) {
            return "Weekly";
        }
        if (i3 == R.string.lifetime) {
            return "Lifetime";
        }
        if (i3 == R.string.continue_cta) {
            return "Continue";
        }
        if (i3 == R.string.default_offer_details_with_intro_offer) {
            return "Start your {{ sub_offer_duration }} trial, then {{ total_price_and_per_month }}.";
        }
        if (i3 == R.string.package_discount) {
            return formatArgs[0] + "% off";
        }
        throw new IllegalStateException(("Unknown string resource " + i3).toString());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public FontFamily getXmlFontFamily(int i3) {
        return this.fontFamiliesByXmlResourceId.get(Integer.valueOf(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MockResourceProvider(Map<String, ? extends Map<String, Integer>> resourceIds, List<String> assetPaths, Map<String, DownloadedFontFamily> downloadedFilesByUrl, Map<Integer, ? extends FontFamily> fontFamiliesByXmlResourceId, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(resourceIds, "resourceIds");
        Intrinsics.checkNotNullParameter(assetPaths, "assetPaths");
        Intrinsics.checkNotNullParameter(downloadedFilesByUrl, "downloadedFilesByUrl");
        Intrinsics.checkNotNullParameter(fontFamiliesByXmlResourceId, "fontFamiliesByXmlResourceId");
        this.resourceIds = resourceIds;
        this.assetPaths = assetPaths;
        this.downloadedFilesByUrl = downloadedFilesByUrl;
        this.fontFamiliesByXmlResourceId = fontFamiliesByXmlResourceId;
        this.mockAssetManager = assetManager;
    }

    public /* synthetic */ MockResourceProvider(Map map, List list, Map map2, Map map3, AssetManager assetManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt.emptyMap() : map, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? MapsKt.emptyMap() : map2, (i3 & 8) != 0 ? MapsKt.emptyMap() : map3, (i3 & 16) != 0 ? null : assetManager);
    }
}
