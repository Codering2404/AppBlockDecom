package com.revenuecat.purchases.paywalls;

import android.content.Context;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class OfferingFontPreDownloader {
    private final String assetsFontsDir;
    private final Context context;
    private final FontLoader fontLoader;
    private final Set<String> genericFonts;

    public OfferingFontPreDownloader(Context context, FontLoader fontLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontLoader, "fontLoader");
        this.context = context;
        this.fontLoader = fontLoader;
        this.assetsFontsDir = "fonts";
        this.genericFonts = SetsKt.setOf((Object[]) new String[]{"sans-serif", "serif", "monospace"});
    }

    private final String getAssetFontPath(Context context, String str) throws IOException {
        String str2;
        int i3 = 0;
        if (!StringsKt.E(str, ".ttf", false, 2, null)) {
            str = str + ".ttf";
        }
        String[] list = context.getResources().getAssets().list(this.assetsFontsDir);
        if (list != null) {
            int length = list.length;
            while (true) {
                if (i3 >= length) {
                    str2 = null;
                    break;
                }
                str2 = list[i3];
                if (Intrinsics.areEqual(str2, str)) {
                    break;
                }
                i3++;
            }
            if (str2 != null) {
                return this.assetsFontsDir + '/' + str2;
            }
        }
        return null;
    }

    private final int getResourceIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    private final boolean isBundled(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        if (name.getValue().length() == 0) {
            return false;
        }
        return (!this.genericFonts.contains(name.getValue()) && getResourceIdentifier(this.context, name.getValue(), "font") == 0 && getAssetFontPath(this.context, name.getValue()) == null) ? false : true;
    }

    public final void preDownloadOfferingFontsIfNeeded(Offerings offerings) {
        List listEmptyList;
        UiConfig uiConfig;
        UiConfig.AppConfig app;
        Map fonts;
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Iterator<T> it = offerings.getAll().values().iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                break;
            }
            Offering.PaywallComponents paywallComponents = ((Offering) it.next()).getPaywallComponents();
            if (paywallComponents != null && (uiConfig = paywallComponents.getUiConfig()) != null && (app = uiConfig.getApp()) != null && (fonts = app.getFonts()) != null) {
                listEmptyList = fonts.values();
            }
        } while (listEmptyList == null);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Collection collection = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(((UiConfig.AppConfig.FontsConfig) it2.next()).getAndroid());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            if (obj instanceof UiConfig.AppConfig.FontsConfig.FontInfo.Name) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj2;
            if ((DownloadableFontInfoKt.toDownloadableFontInfo(name) instanceof Result.Success) && !isBundled(name)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj3 = arrayList3.get(i6);
            i6++;
            UiConfig.AppConfig.FontsConfig.FontInfo.Name name2 = (UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj3;
            try {
                new URL(name2.getUrl());
                arrayList4.add(obj3);
            } catch (MalformedURLException e3) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Malformed URL for font: " + name2.getValue() + ". Skipping download.", e3);
            }
        }
        int size4 = arrayList4.size();
        while (i3 < size4) {
            Object obj4 = arrayList4.get(i3);
            i3++;
            this.fontLoader.getCachedFontFamilyOrStartDownload((UiConfig.AppConfig.FontsConfig.FontInfo.Name) obj4);
        }
    }
}
