package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.AndroidFontKt;
import androidx.compose.ui.text.font.DeviceFontFamilyName;
import androidx.compose.ui.text.font.DeviceFontFamilyNameFontKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.compose.ui.text.googlefonts.GoogleFontKt;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFont;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class FontSpecKt {
    private static final GoogleFont.Provider GoogleFontsProvider = new GoogleFont.Provider("com.google.android.gms.fonts", "com.google.android.gms", R.array.com_google_android_gms_fonts_certs);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontStyle.values().length];
            try {
                iArr[FontStyle.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontStyle.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final FontSpec determineFontSpec(ResourceProvider resourceProvider, UiConfig.AppConfig.FontsConfig fontsConfig, Map<String, FontSpec.Resource> map, Map<String, FontSpec.Asset> map2) {
        FontSpec.Asset asset;
        UiConfig.AppConfig.FontsConfig.FontInfo android2 = fontsConfig.getAndroid();
        if (android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts) {
            return new FontSpec.Google(((UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts) android2).getValue());
        }
        if (!(android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name)) {
            throw new NoWhenBranchMatchedException();
        }
        UiConfig.AppConfig.FontsConfig.FontInfo.Name name = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) android2;
        FontSpec.Generic genericFontSpec = getGenericFontSpec(name);
        if (genericFontSpec != null) {
            return genericFontSpec;
        }
        if (name.getFamily() != null) {
            asset = map.get(name.getFamily());
            if (asset == null) {
                asset = map2.get(name.getFamily());
            }
        } else {
            asset = null;
        }
        if (asset != null) {
            return asset;
        }
        FontSpec.Downloaded downloadedFontSpec = getDownloadedFontSpec(resourceProvider, name);
        if (downloadedFontSpec != null) {
            return downloadedFontSpec;
        }
        FontSpec.System system = new FontSpec.System(name.getValue());
        Logger.INSTANCE.d("Could not find a font resource named `" + name.getValue() + "`. Assuming it's an OEM system font. If it isn't, make sure the font exists in the `res/font` folder. See for more info: https://developer.android.com/develop/ui/views/text-and-emoji/fonts-in-xml");
        return system;
    }

    public static final /* synthetic */ Map determineFontSpecs(Map map, ResourceProvider resourceProvider) {
        String family;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Set set = CollectionsKt.toSet(map.values());
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (true) {
            Pair pairA = null;
            if (!it.hasNext()) {
                break;
            }
            UiConfig.AppConfig.FontsConfig.FontInfo android2 = ((UiConfig.AppConfig.FontsConfig) it.next()).getAndroid();
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name = android2 instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name ? (UiConfig.AppConfig.FontsConfig.FontInfo.Name) android2 : null;
            if (name != null && (family = name.getFamily()) != null) {
                pairA = TuplesKt.a(family, name);
            }
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Pair pair = (Pair) obj;
            String str = (String) pair.a();
            Object arrayList2 = linkedHashMap.get(str);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(str, arrayList2);
            }
            ((List) arrayList2).add((UiConfig.AppConfig.FontsConfig.FontInfo.Name) pair.b());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            FontSpec.Resource fontSpecResource = toFontSpecResource((List) entry.getValue(), resourceProvider);
            Pair pairA2 = fontSpecResource != null ? TuplesKt.a(str2, fontSpecResource) : null;
            if (pairA2 != null) {
                arrayList3.add(pairA2);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList3, 10)), 16));
        int size2 = arrayList3.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList3.get(i5);
            i5++;
            Pair pair2 = (Pair) obj2;
            linkedHashMap2.put((String) pair2.e(), (FontSpec.Resource) pair2.f());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!linkedHashMap2.containsKey(entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str3 = (String) entry3.getKey();
            FontSpec.Asset fontSpecAsset = toFontSpecAsset((List) entry3.getValue(), resourceProvider);
            Pair pairA3 = fontSpecAsset != null ? TuplesKt.a(str3, fontSpecAsset) : null;
            if (pairA3 != null) {
                arrayList4.add(pairA3);
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList4, 10)), 16));
        int size3 = arrayList4.size();
        while (i3 < size3) {
            Object obj3 = arrayList4.get(i3);
            i3++;
            Pair pair3 = (Pair) obj3;
            linkedHashMap4.put((String) pair3.e(), (FontSpec.Asset) pair3.f());
        }
        Set set2 = CollectionsKt.toSet(map.values());
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
        for (Object obj4 : set2) {
            linkedHashMap5.put(obj4, determineFontSpec(resourceProvider, (UiConfig.AppConfig.FontsConfig) obj4, linkedHashMap2, linkedHashMap4));
        }
        LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry4 : map.entrySet()) {
            linkedHashMap6.put(entry4.getKey(), (FontSpec) MapsKt.getValue(linkedHashMap5, (UiConfig.AppConfig.FontsConfig) entry4.getValue()));
        }
        return linkedHashMap6;
    }

    private static final FontSpec.Downloaded getDownloadedFontSpec(ResourceProvider resourceProvider, UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        DownloadedFontFamily cachedFontFamilyOrStartDownload = resourceProvider.getCachedFontFamilyOrStartDownload(name);
        if (cachedFontFamilyOrStartDownload != null) {
            return new FontSpec.Downloaded(cachedFontFamilyOrStartDownload);
        }
        return null;
    }

    /* JADX INFO: renamed from: getFontSpec-pDyximM, reason: not valid java name */
    public static final /* synthetic */ Result m787getFontSpecpDyximM(Map getFontSpec, String alias) {
        Intrinsics.checkNotNullParameter(getFontSpec, "$this$getFontSpec");
        Intrinsics.checkNotNullParameter(alias, "alias");
        FontSpec fontSpec = (FontSpec) getFontSpec.get(FontAlias.m433boximpl(alias));
        return fontSpec != null ? new Result.Success(fontSpec) : new Result.Error(new PaywallValidationError.MissingFontAlias(alias, null));
    }

    private static final FontSpec.Generic getGenericFontSpec(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        String value = name.getValue();
        FontFamily.Companion companion = FontFamily.f29155b;
        if (Intrinsics.areEqual(value, companion.d().g())) {
            return FontSpec.Generic.SansSerif.INSTANCE;
        }
        if (Intrinsics.areEqual(value, companion.e().g())) {
            return FontSpec.Generic.Serif.INSTANCE;
        }
        if (Intrinsics.areEqual(value, companion.c().g())) {
            return FontSpec.Generic.Monospace.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ Result recoverFromFontAliasError(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallValidationError paywallValidationError = (PaywallValidationError) ((Result.Error) result).getValue();
        boolean z2 = paywallValidationError instanceof PaywallValidationError.MissingFontAlias;
        if (z2 && StringsKt.p0(((PaywallValidationError.MissingFontAlias) paywallValidationError).m1137getAliasBejUyPs())) {
            return new Result.Success(null);
        }
        if (!z2) {
            return new Result.Error(paywallValidationError);
        }
        Logger.INSTANCE.w("Font named '" + ((Object) FontAlias.m438toStringimpl(((PaywallValidationError.MissingFontAlias) paywallValidationError).m1137getAliasBejUyPs())) + "' was not found in the font config. Try re-adding it in the Paywall editor.");
        return new Result.Success(null);
    }

    /* JADX INFO: renamed from: resolve-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ FontFamily m788resolveRetOiIg(FontSpec resolve, FontWeight weight, int i3) {
        Intrinsics.checkNotNullParameter(resolve, "$this$resolve");
        Intrinsics.checkNotNullParameter(weight, "weight");
        if (resolve instanceof FontSpec.Resource) {
            return ((FontSpec.Resource) resolve).getFontFamily();
        }
        if (resolve instanceof FontSpec.Asset) {
            return ((FontSpec.Asset) resolve).getFontFamily();
        }
        if (resolve instanceof FontSpec.Google) {
            return FontFamilyKt.c(GoogleFontKt.a(new GoogleFont(((FontSpec.Google) resolve).getName(), false, 2, null), GoogleFontsProvider, weight, i3));
        }
        if (resolve instanceof FontSpec.Generic) {
            if (Intrinsics.areEqual(resolve, FontSpec.Generic.SansSerif.INSTANCE)) {
                return FontFamily.f29155b.d();
            }
            if (Intrinsics.areEqual(resolve, FontSpec.Generic.Serif.INSTANCE)) {
                return FontFamily.f29155b.e();
            }
            if (Intrinsics.areEqual(resolve, FontSpec.Generic.Monospace.INSTANCE)) {
                return FontFamily.f29155b.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(resolve instanceof FontSpec.Downloaded)) {
            if (resolve instanceof FontSpec.System) {
                return FontFamilyKt.c(DeviceFontFamilyNameFontKt.b(DeviceFontFamilyName.a(((FontSpec.System) resolve).getName()), weight, i3, null, 8, null));
            }
            throw new NoWhenBranchMatchedException();
        }
        List<DownloadedFont> fonts = ((FontSpec.Downloaded) resolve).getDownloadedFontFamily().getFonts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fonts, 10));
        for (DownloadedFont downloadedFont : fonts) {
            arrayList.add(AndroidFontKt.b(new File(downloadedFont.getFile().getPath()), new FontWeight(downloadedFont.getWeight()), toComposeFontStyle(downloadedFont.getStyle()), null, 8, null));
        }
        return FontFamilyKt.b(arrayList);
    }

    private static final int toComposeFontStyle(FontStyle fontStyle) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[fontStyle.ordinal()];
        if (i3 == 1) {
            return androidx.compose.ui.text.font.FontStyle.f29211b.b();
        }
        if (i3 == 2) {
            return androidx.compose.ui.text.font.FontStyle.f29211b.a();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> toFontResourceIdAndData(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (UiConfig.AppConfig.FontsConfig.FontInfo.Name name : list) {
            if (!linkedHashSet.contains(name.getValue())) {
                Integer numValueOf = Integer.valueOf(resourceProvider.getResourceIdentifier(name.getValue(), "font"));
                if (numValueOf.intValue() == 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    linkedHashSet.add(name.getValue());
                    Integer numValueOf2 = Integer.valueOf(numValueOf.intValue());
                    Integer weight = name.getWeight();
                    FontStyle style = name.getStyle();
                    triple = new Triple(numValueOf2, weight, style != null ? androidx.compose.ui.text.font.FontStyle.c(toComposeFontStyle(style)) : null);
                }
            }
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        return arrayList;
    }

    private static final FontSpec.Asset toFontSpecAsset(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        Font fontD;
        List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((UiConfig.AppConfig.FontsConfig.FontInfo.Name) it.next()).getValue());
        }
        Map<String, String> assetFontPaths = resourceProvider.getAssetFontPaths(arrayList);
        AssetManager assetManager = resourceProvider.getAssetManager();
        if (assetFontPaths == null || assetManager == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (UiConfig.AppConfig.FontsConfig.FontInfo.Name name : list2) {
            String str = assetFontPaths.get(name.getValue());
            if (str == null) {
                fontD = null;
            } else {
                Integer weight = name.getWeight();
                FontWeight fontWeight = weight != null ? new FontWeight(weight.intValue()) : FontWeight.f29233b.g();
                FontStyle style = name.getStyle();
                fontD = AndroidFontKt.d(str, assetManager, fontWeight, style != null ? toComposeFontStyle(style) : androidx.compose.ui.text.font.FontStyle.f29211b.b(), null, 16, null);
            }
            if (fontD != null) {
                arrayList2.add(fontD);
            }
        }
        return new FontSpec.Asset(FontFamilyKt.b(arrayList2));
    }

    private static final FontSpec.Resource toFontSpecResource(List<UiConfig.AppConfig.FontsConfig.FontInfo.Name> list, ResourceProvider resourceProvider) {
        FontFamily xmlFontFamily;
        List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> fontResourceIdAndData = toFontResourceIdAndData(list, resourceProvider);
        if (fontResourceIdAndData.isEmpty()) {
            return null;
        }
        if (fontResourceIdAndData.size() == 1 && (xmlFontFamily = resourceProvider.getXmlFontFamily(((Number) ((Triple) CollectionsKt.first((List) fontResourceIdAndData)).d()).intValue())) != null) {
            return new FontSpec.Resource(xmlFontFamily);
        }
        List<Triple<Integer, Integer, androidx.compose.ui.text.font.FontStyle>> list2 = fontResourceIdAndData;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            int iIntValue = ((Number) triple.d()).intValue();
            Integer num = (Integer) triple.e();
            FontWeight fontWeight = num != null ? new FontWeight(num.intValue()) : FontWeight.f29233b.g();
            androidx.compose.ui.text.font.FontStyle fontStyle = (androidx.compose.ui.text.font.FontStyle) triple.f();
            arrayList.add(FontKt.b(iIntValue, fontWeight, fontStyle != null ? fontStyle.i() : androidx.compose.ui.text.font.FontStyle.f29211b.b(), 0, 8, null));
        }
        return new FontSpec.Resource(FontFamilyKt.b(arrayList));
    }
}
